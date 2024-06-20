// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stp_stdtecR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_tmp_soggettioper;
  public String m_cServer_tmp_soggettioper;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
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
  public String pTipo;
  public String pAUI;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_daCodDip;
  public String w_aCodDip;
  public String w_flgrae;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  public String _id;
  public String _idrep;
  public double _conta;
  public String _numsto;
  public String w_c_dadata;
  public String w_c_adata;
  public String xProg;
  public String lReport;
  public String gDescAzi;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  public double _fint;
  public double _fope;
  public double _fter;
  public double _fben;
  public String _dipcabinter;
  public String _dipcittainter;
  public String _dipprvinter;
  public String _dipcab;
  public String _dipcitta;
  public String _dipprv;
  public String _codint2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_stdtecR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_stdtec",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
      m_cPhName_tmp_soggettioper = p_ContextObject.GetPhName("tmp_soggettioper");
      if (m_cPhName_tmp_soggettioper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_soggettioper = m_cPhName_tmp_soggettioper+" "+m_Ctx.GetWritePhName("tmp_soggettioper");
      }
      m_cServer_tmp_soggettioper = p_ContextObject.GetServer("tmp_soggettioper");
    }
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
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
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
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
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_fint",p_cVarName)) {
      return _fint;
    }
    if (CPLib.eqr("_fope",p_cVarName)) {
      return _fope;
    }
    if (CPLib.eqr("_fter",p_cVarName)) {
      return _fter;
    }
    if (CPLib.eqr("_fben",p_cVarName)) {
      return _fben;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stp_stdtec";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      return w_daCodDip;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      return w_aCodDip;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      return w_flgrae;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      return pAUI;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    if (CPLib.eqr("_idrep",p_cVarName)) {
      return _idrep;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      return xProg;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      return lReport;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("_dipcabinter",p_cVarName)) {
      return _dipcabinter;
    }
    if (CPLib.eqr("_dipcittainter",p_cVarName)) {
      return _dipcittainter;
    }
    if (CPLib.eqr("_dipprvinter",p_cVarName)) {
      return _dipprvinter;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      return _dipcab;
    }
    if (CPLib.eqr("_dipcitta",p_cVarName)) {
      return _dipcitta;
    }
    if (CPLib.eqr("_dipprv",p_cVarName)) {
      return _dipprv;
    }
    if (CPLib.eqr("_codint2",p_cVarName)) {
      return _codint2;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_fint",p_cVarName)) {
      _fint = value;
      return;
    }
    if (CPLib.eqr("_fope",p_cVarName)) {
      _fope = value;
      return;
    }
    if (CPLib.eqr("_fter",p_cVarName)) {
      _fter = value;
      return;
    }
    if (CPLib.eqr("_fben",p_cVarName)) {
      _fben = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      w_daCodDip = value;
      return;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      w_aCodDip = value;
      return;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      w_flgrae = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      pAUI = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
    if (CPLib.eqr("_idrep",p_cVarName)) {
      _idrep = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      xProg = value;
      return;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      lReport = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_dipcabinter",p_cVarName)) {
      _dipcabinter = value;
      return;
    }
    if (CPLib.eqr("_dipcittainter",p_cVarName)) {
      _dipcittainter = value;
      return;
    }
    if (CPLib.eqr("_dipprvinter",p_cVarName)) {
      _dipprvinter = value;
      return;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      _dipcab = value;
      return;
    }
    if (CPLib.eqr("_dipcitta",p_cVarName)) {
      _dipcitta = value;
      return;
    }
    if (CPLib.eqr("_dipprv",p_cVarName)) {
      _dipprv = value;
      return;
    }
    if (CPLib.eqr("_codint2",p_cVarName)) {
      _codint2 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* pTipo Char(1) */
      /* pAUI Char(1) */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_daCodCli Char(16) */
      /* w_aCodCli Char(16) */
      /* w_daCodDip Char(6) */
      /* w_aCodDip Char(6) */
      /* w_flgrae Char(1) // Rae/ateco */
      /* _nomerep Memo // Nome Stampa */
      /* _report Object(ReportLibrary) */
      /* bReport Bool */
      /* _id Char(6) */
      /* _idrep Char(10) */
      /* _conta Numeric(10, 0) */
      /* _numsto Char(15) */
      /* w_c_dadata Char(8) */
      /* w_c_adata Char(8) */
      /* xProg Char(15) */
      /* lReport Memo */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* _fint Numeric(1, 0) */
      /* _fope Numeric(1, 0) */
      /* _fter Numeric(1, 0) */
      /* _fben Numeric(1, 0) */
      /* _dipcabinter Char(6) // cab dipendenza intermediario */
      /* _dipcittainter Char(30) // Citta dipendenza intermediario */
      /* _dipprvinter Char(2) // provincia dipendenza intermediario */
      /* _dipcab Char(6) // cab dipendenza */
      /* _dipcitta Char(30) // Citta dipendenza */
      /* _dipprv Char(2) // provincia dipendenza */
      /* _codint2 Char(11) // provincia dipendenza */
      // * --- Drop temporary table tmp_stpoperazioni
      if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpoperazioni");
      }
      // * --- Drop temporary table tmp_soggettioper
      if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_soggettioper");
      }
      // * --- Create temporary table tmp_stpoperazioni
      if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpoperazioni");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpoperazioni");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpoperazioni"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpoperazioni",m_cServer,"proto")),m_cPhName,"tmp_stpoperazioni",m_Ctx);
      }
      m_cPhName_tmp_stpoperazioni = m_cPhName;
      // * --- Create temporary table tmp_soggettioper
      if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_soggettioper");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_soggettioper");
      if ( ! (m_Ctx.IsSharedTemp("tmp_soggettioper"))) {
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_soggettioper",m_cServer,"proto")),m_cPhName,"tmp_soggettioper",m_Ctx,new String[]{"IDBASE,TIPOPERS,CONNES"});
      }
      m_cPhName_tmp_soggettioper = m_cPhName;
      /* Lancio la stampa */
      /* w_c_dadata := iif(Empty(w_DaDatOpe),'20100601',DateToChar(w_DaDatOpe)) */
      w_c_dadata = (CPLib.Empty(w_DaDatOpe)?"20100601":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_adata := iif(Empty(w_ADatOpe),'20131231',DateToChar(w_ADatOpe)) */
      w_c_adata = (CPLib.Empty(w_ADatOpe)?"20131231":CPLib.DateToChar(w_ADatOpe));
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* _fint := 0 */
      _fint = CPLib.Round(0,0);
      /* _fter := 0 */
      _fter = CPLib.Round(0,0);
      /* _fben := 0 */
      _fben = CPLib.Round(0,0);
      /* _fope := 0 */
      _fope = CPLib.Round(0,0);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _dipcabinter := intermbo->CODCAB // cab dipendenza intermediario */
        _dipcabinter = Cursor_intermbo.GetString("CODCAB");
        /* _dipcittainter := intermbo->DESCCIT // Citta dipendenza intermediario */
        _dipcittainter = Cursor_intermbo.GetString("DESCCIT");
        /* _dipprvinter := intermbo->PROVINCIA // provincia dipendenza intermediario */
        _dipprvinter = Cursor_intermbo.GetString("PROVINCIA");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Case pTipo='O' and pAUI='D' */
      if (CPLib.eqr(pTipo,"O") && CPLib.eqr(pAUI,"D")) {
        /* Exec "Operazioni AUI" Page 2:Page_2 */
        Page_2();
        /* Case pTipo='O' and pAUI='P' */
      } else if (CPLib.eqr(pTipo,"O") && CPLib.eqr(pAUI,"P")) {
        /* Exec "Operazioni Prov." Page 3:Page_3 */
        Page_3();
        /* Case pTipo='F' and pAUI='D' */
      } else if (CPLib.eqr(pTipo,"F") && CPLib.eqr(pAUI,"D")) {
        /* Exec "Frazionate AUI" Page 4:Page_4 */
        Page_4();
        /* Case pTipo='F' and pAUI='P' */
      } else if (CPLib.eqr(pTipo,"F") && CPLib.eqr(pAUI,"P")) {
        /* Exec "Frazionate Prov." Page 5:Page_5 */
        Page_5();
      } // End Case
      /* If not(Empty(LRTrim(lReport))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(lReport)))) {
        /* _idrep := LibreriaMit.UniqueId() */
        _idrep = LibreriaMit.UniqueId();
        /* bReport := _report.MergingPdf(lReport,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_idrep+'.pdf',True) */
        bReport = _report.MergingPdf(lReport,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_idrep+".pdf",true);
        /* Stop LRTrim(gUrlApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_idrep+".pdf" */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_idrep+".pdf",false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_alloperazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_alloperazbo
      if (Cursor_qbe_alloperazbo!=null)
        Cursor_qbe_alloperazbo.Close();
      Cursor_qbe_alloperazbo = new VQRHolder("qbe_alloperazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000043")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000044")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Read from inter2bo
        m_cServer = m_Ctx.GetServer("inter2bo");
        m_cPhName = m_Ctx.GetPhName("inter2bo");
        m_cSql = "";
        m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CODINT2"));
        if (m_Ctx.IsSharedTemp("inter2bo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codint2 = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codint2 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(qbe_alloperazbo->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_alloperazbo.GetString("CODDIPE"))) {
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000047")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000047(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } else { // Else
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CODDIPE"));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dipcab = Read_Cursor.GetString("CAB");
            _dipcitta = Read_Cursor.GetString("DESCCIT");
            _dipprv = Read_Cursor.GetString("PROVINCIA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dipcab = "";
            _dipcitta = "";
            _dipprv = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000049")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000049(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcitta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } // End If
        /* If not(Empty(qbe_alloperazbo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo.GetString("CONNESCLI")))) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000004F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000004F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_alloperazbo->CONNESCLI,iif(qbe_alloperazbo->STATOREG<>'1',qbe_alloperazbo->DATAREG,qbe_alloperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_alloperazbo.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo.GetDate("DATAREG"):Cursor_qbe_alloperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000053")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CONNESCLI"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000055")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from clientiope
        m_cServer = m_Ctx.GetServer("clientiope");
        m_cPhName = m_Ctx.GetPhName("clientiope");
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
        Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientiope.Eof())) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(clientiope->CODSOG,iif(qbe_alloperazbo->STATOREG<>'1',qbe_alloperazbo->DATAREG,qbe_alloperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo.GetDate("DATAREG"):Cursor_qbe_alloperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000005E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientiope.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000060")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientiope.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_clientiope.Next();
        }
        m_cConnectivityError = Cursor_clientiope.ErrorMessage();
        Cursor_clientiope.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo.GetString("CONNESOPER")))) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000066")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000066(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_alloperazbo->CONNESOPER,iif(qbe_alloperazbo->STATOREG<>'1',qbe_alloperazbo->DATAREG,qbe_alloperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_alloperazbo.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo.GetDate("DATAREG"):Cursor_qbe_alloperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CONNESOPER"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000006C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CONNESOPER"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000071")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000071(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(sogopebo->CODSOG,iif(qbe_alloperazbo->STATOREG<>'1',qbe_alloperazbo->DATAREG,qbe_alloperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_sogopebo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo.GetDate("DATAREG"):Cursor_qbe_alloperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000075")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_sogopebo.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000077")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_sogopebo.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo.GetString("CONNALTRO")))) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000007D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000007D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_alloperazbo->CONNALTRO,iif(qbe_alloperazbo->STATOREG<>'1',qbe_alloperazbo->DATAREG,qbe_alloperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_alloperazbo.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_alloperazbo.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo.GetDate("DATAREG"):Cursor_qbe_alloperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000081")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CONNALTRO"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000083")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("CONNALTRO"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from terzistiope
        m_cServer = m_Ctx.GetServer("terzistiope");
        m_cPhName = m_Ctx.GetPhName("terzistiope");
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
        Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_terzistiope.Eof())) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000088")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000088(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(terzistiope->CODSOG,iif(qbe_alloperazbo->STATOREG<>'1',qbe_alloperazbo->DATAREG,qbe_alloperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo.GetDate("DATAREG"):Cursor_qbe_alloperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000008C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistiope.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000008E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistiope.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_terzistiope.Next();
        }
        m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
        Cursor_terzistiope.Close();
        // * --- End Select
        /* If not(Empty(qbe_alloperazbo->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo.GetString("C_RAG")))) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000093")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000093(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_alloperazbo.GetString("CONNESBEN"))?"":Cursor_qbe_alloperazbo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
        } // End If
        // * --- Select from beneficope
        m_cServer = m_Ctx.GetServer("beneficope");
        m_cPhName = m_Ctx.GetPhName("beneficope");
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
        Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_beneficope.Eof())) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000097")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000097(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_beneficope.GetString("CODSOG"))?"":Cursor_beneficope.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000099")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Write into tmp_soggettioper from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000009A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Stampa" Page 6:Page_6 */
        Page_6();
        Cursor_qbe_alloperazbo.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo.ErrorMessage();
      Cursor_qbe_alloperazbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_alloperazbo!=null)
          Cursor_qbe_alloperazbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
      try {
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_allxperazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xerzistiope=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxperazbo
      if (Cursor_qbe_allxperazbo!=null)
        Cursor_qbe_allxperazbo.Close();
      Cursor_qbe_allxperazbo = new VQRHolder("qbe_allxperazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxperazbo.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000009F")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000A0")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Read from inter2bo
        m_cServer = m_Ctx.GetServer("inter2bo");
        m_cPhName = m_Ctx.GetPhName("inter2bo");
        m_cSql = "";
        m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CODINT2"));
        if (m_Ctx.IsSharedTemp("inter2bo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codint2 = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codint2 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(qbe_allxperazbo->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_allxperazbo.GetString("CODDIPE"))) {
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000A3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000A3(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } else { // Else
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CODDIPE"));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dipcab = Read_Cursor.GetString("CAB");
            _dipcitta = Read_Cursor.GetString("DESCCIT");
            _dipprv = Read_Cursor.GetString("PROVINCIA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dipcab = "";
            _dipcitta = "";
            _dipprv = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000A5(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcitta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } // End If
        /* If not(Empty(qbe_allxperazbo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo.GetString("CONNESCLI")))) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000AB(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxperazbo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allxperazbo->CONNESCLI,iif(qbe_allxperazbo->STATOREG<>'1',qbe_allxperazbo->DATAREG,qbe_allxperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_allxperazbo.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo.GetDate("DATAREG"):Cursor_qbe_allxperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000AF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CONNESCLI"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000B1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from xlientiope
        m_cServer = m_Ctx.GetServer("xlientiope");
        m_cPhName = m_Ctx.GetPhName("xlientiope");
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
        Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xlientiope.Eof())) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000B6(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxperazbo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(xlientiope->CODSOG,iif(qbe_allxperazbo->STATOREG<>'1',qbe_allxperazbo->DATAREG,qbe_allxperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xlientiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxperazbo.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo.GetDate("DATAREG"):Cursor_qbe_allxperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000BA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientiope.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000BC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientiope.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_xlientiope.Next();
        }
        m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
        Cursor_xlientiope.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxperazbo->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo.GetString("CONNESOPER")))) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000C2(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allxperazbo->CONNESOPER,iif(qbe_allxperazbo->STATOREG<>'1',qbe_allxperazbo->DATAREG,qbe_allxperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_allxperazbo.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo.GetDate("DATAREG"):Cursor_qbe_allxperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CONNESOPER"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000C8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CONNESOPER"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from xogopebo
        m_cServer = m_Ctx.GetServer("xogopebo");
        m_cPhName = m_Ctx.GetPhName("xogopebo");
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
        Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopebo.Eof())) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000CD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000CD(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(xogopebo->CODSOG,iif(qbe_allxperazbo->STATOREG<>'1',qbe_allxperazbo->DATAREG,qbe_allxperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xogopebo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxperazbo.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo.GetDate("DATAREG"):Cursor_qbe_allxperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000D1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xogopebo.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000D3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xogopebo.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_xogopebo.Next();
        }
        m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
        Cursor_xogopebo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxperazbo->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo.GetString("CONNALTRO")))) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000D9(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allxperazbo->CONNALTRO,iif(qbe_allxperazbo->STATOREG<>'1',qbe_allxperazbo->DATAREG,qbe_allxperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxperazbo.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_allxperazbo.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo.GetDate("DATAREG"):Cursor_qbe_allxperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000DD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CONNALTRO"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000DF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("CONNALTRO"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from xerzistiope
        m_cServer = m_Ctx.GetServer("xerzistiope");
        m_cPhName = m_Ctx.GetPhName("xerzistiope");
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
        Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistiope.Eof())) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000E4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000E4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(xerzistiope->CODSOG,iif(qbe_allxperazbo->STATOREG<>'1',qbe_allxperazbo->DATAREG,qbe_allxperazbo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xerzistiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxperazbo.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo.GetDate("DATAREG"):Cursor_qbe_allxperazbo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000E8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistiope.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000EA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistiope.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_xerzistiope.Next();
        }
        m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
        Cursor_xerzistiope.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxperazbo->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo.GetString("C_RAG")))) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000EF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000EF(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_allxperazbo.GetString("CONNESBEN"))?"":Cursor_qbe_allxperazbo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
        } // End If
        // * --- Select from xeneficope
        m_cServer = m_Ctx.GetServer("xeneficope");
        m_cPhName = m_Ctx.GetPhName("xeneficope");
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
        Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficope.Eof())) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000F3(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_xeneficope.GetString("CODSOG"))?"":Cursor_xeneficope.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          Cursor_xeneficope.Next();
        }
        m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
        Cursor_xeneficope.Close();
        // * --- End Select
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000F5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Write into tmp_soggettioper from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000F6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Stampa" Page 6:Page_6 */
        Page_6();
        Cursor_qbe_allxperazbo.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxperazbo.ErrorMessage();
      Cursor_qbe_allxperazbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxperazbo!=null)
          Cursor_qbe_allxperazbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
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
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_allfraziobo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allfraziobo
      if (Cursor_qbe_allfraziobo!=null)
        Cursor_qbe_allfraziobo.Close();
      Cursor_qbe_allfraziobo = new VQRHolder("qbe_allfraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allfraziobo.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000FB")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000FC")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Read from inter2bo
        m_cServer = m_Ctx.GetServer("inter2bo");
        m_cPhName = m_Ctx.GetPhName("inter2bo");
        m_cSql = "";
        m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CODINT2"));
        if (m_Ctx.IsSharedTemp("inter2bo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codint2 = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codint2 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(qbe_allfraziobo->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_allfraziobo.GetString("CODDIPE"))) {
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000000FF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000FF(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } else { // Else
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CODDIPE"));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dipcab = Read_Cursor.GetString("CAB");
            _dipcitta = Read_Cursor.GetString("DESCCIT");
            _dipprv = Read_Cursor.GetString("PROVINCIA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dipcab = "";
            _dipcitta = "";
            _dipprv = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000101")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000101(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcitta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } // End If
        /* If not(Empty(qbe_allfraziobo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo.GetString("CONNESCLI")))) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000107")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000107(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allfraziobo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allfraziobo->CONNESCLI,iif(qbe_allfraziobo->STATOREG<>'1',qbe_allfraziobo->DATAREG,qbe_allfraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_allfraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo.GetDate("DATAREG"):Cursor_qbe_allfraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000010B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CONNESCLI"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000010D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from clientifrz
        m_cServer = m_Ctx.GetServer("clientifrz");
        m_cPhName = m_Ctx.GetPhName("clientifrz");
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
        Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientifrz.Eof())) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000112")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000112(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allfraziobo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(clientifrz->CODSOG,iif(qbe_allfraziobo->STATOREG<>'1',qbe_allfraziobo->DATAREG,qbe_allfraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_clientifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo.GetDate("DATAREG"):Cursor_qbe_allfraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000116")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000118")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_clientifrz.Next();
        }
        m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
        Cursor_clientifrz.Close();
        // * --- End Select
        /* If not(Empty(qbe_allfraziobo->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo.GetString("CONNESOPER")))) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000011E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000011E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allfraziobo->CONNESOPER,iif(qbe_allfraziobo->STATOREG<>'1',qbe_allfraziobo->DATAREG,qbe_allfraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_allfraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo.GetDate("DATAREG"):Cursor_qbe_allfraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000122")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CONNESOPER"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000124")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CONNESOPER"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from sogopefbo
        m_cServer = m_Ctx.GetServer("sogopefbo");
        m_cPhName = m_Ctx.GetPhName("sogopefbo");
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
        Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopefbo.Eof())) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000129")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000129(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(sogopefbo->CODSOG,iif(qbe_allfraziobo->STATOREG<>'1',qbe_allfraziobo->DATAREG,qbe_allfraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_sogopefbo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo.GetDate("DATAREG"):Cursor_qbe_allfraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000012D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000012F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_sogopefbo.Next();
        }
        m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
        Cursor_sogopefbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allfraziobo->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo.GetString("CONNALTRO")))) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000135")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000135(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allfraziobo->CONNALTRO,iif(qbe_allfraziobo->STATOREG<>'1',qbe_allfraziobo->DATAREG,qbe_allfraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allfraziobo.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_allfraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo.GetDate("DATAREG"):Cursor_qbe_allfraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000139")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CONNALTRO"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000013B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("CONNALTRO"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from terzistifrz
        m_cServer = m_Ctx.GetServer("terzistifrz");
        m_cPhName = m_Ctx.GetPhName("terzistifrz");
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
        Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_terzistifrz.Eof())) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000140")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000140(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(terzistifrz->CODSOG,iif(qbe_allfraziobo->STATOREG<>'1',qbe_allfraziobo->DATAREG,qbe_allfraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo.GetDate("DATAREG"):Cursor_qbe_allfraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000144")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000146")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_terzistifrz.Next();
        }
        m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
        Cursor_terzistifrz.Close();
        // * --- End Select
        /* If not(Empty(qbe_allfraziobo->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo.GetString("C_RAG")))) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000014B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000014B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_allfraziobo.GetString("CONNESBEN"))?"":Cursor_qbe_allfraziobo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
        } // End If
        // * --- Select from beneficfrz
        m_cServer = m_Ctx.GetServer("beneficfrz");
        m_cPhName = m_Ctx.GetPhName("beneficfrz");
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
        Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_beneficfrz.Eof())) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000014F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000014F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_beneficfrz.GetString("CODSOG"))?"":Cursor_beneficfrz.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000151")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Write into tmp_soggettioper from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000152")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Stampa" Page 6:Page_6 */
        Page_6();
        Cursor_qbe_allfraziobo.Next();
      }
      m_cConnectivityError = Cursor_qbe_allfraziobo.ErrorMessage();
      Cursor_qbe_allfraziobo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allfraziobo!=null)
          Cursor_qbe_allfraziobo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
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
      try {
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_allxraziobo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxraziobo
      if (Cursor_qbe_allxraziobo!=null)
        Cursor_qbe_allxraziobo.Close();
      Cursor_qbe_allxraziobo = new VQRHolder("qbe_allxraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxraziobo.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000157")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000158")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Read from inter2bo
        m_cServer = m_Ctx.GetServer("inter2bo");
        m_cPhName = m_Ctx.GetPhName("inter2bo");
        m_cSql = "";
        m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CODINT2"));
        if (m_Ctx.IsSharedTemp("inter2bo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codint2 = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codint2 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(qbe_allxraziobo->CODDIPE) */
        if (CPLib.Empty(Cursor_qbe_allxraziobo.GetString("CODDIPE"))) {
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000015B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000015B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } else { // Else
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CODDIPE"));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dipcab = Read_Cursor.GetString("CAB");
            _dipcitta = Read_Cursor.GetString("DESCCIT");
            _dipprv = Read_Cursor.GetString("PROVINCIA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_stp_stdtec returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dipcab = "";
            _dipcitta = "";
            _dipprv = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000015D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000015D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipcitta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dipprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        } // End If
        /* If not(Empty(qbe_allxraziobo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo.GetString("CONNESCLI")))) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000163")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000163(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxraziobo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allxraziobo->CONNESCLI,iif(qbe_allxraziobo->STATOREG<>'1',qbe_allxraziobo->DATAREG,qbe_allxraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_allxraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo.GetDate("DATAREG"):Cursor_qbe_allxraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000167")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CONNESCLI"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000169")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from xlientifrz
        m_cServer = m_Ctx.GetServer("xlientifrz");
        m_cPhName = m_Ctx.GetPhName("xlientifrz");
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
        Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xlientifrz.Eof())) {
          /* _fint := 1 */
          _fint = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000016E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000016E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxraziobo.GetString("CONNESOPER")))?"2":"3"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(xlientifrz->CODSOG,iif(qbe_allxraziobo->STATOREG<>'1',qbe_allxraziobo->DATAREG,qbe_allxraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xlientifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo.GetDate("DATAREG"):Cursor_qbe_allxraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000172")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientifrz.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000174")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientifrz.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_xlientifrz.Next();
        }
        m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
        Cursor_xlientifrz.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxraziobo->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo.GetString("CONNESOPER")))) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000017A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000017A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allxraziobo->CONNESOPER,iif(qbe_allxraziobo->STATOREG<>'1',qbe_allxraziobo->DATAREG,qbe_allxraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_allxraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo.GetDate("DATAREG"):Cursor_qbe_allxraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000017E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CONNESOPER"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000180")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CONNESOPER"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from xogopefbo
        m_cServer = m_Ctx.GetServer("xogopefbo");
        m_cPhName = m_Ctx.GetPhName("xogopefbo");
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
        Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopefbo.Eof())) {
          /* _fope := 1 */
          _fope = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000185")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000185(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(xogopefbo->CODSOG,iif(qbe_allxraziobo->STATOREG<>'1',qbe_allxraziobo->DATAREG,qbe_allxraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xogopefbo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo.GetDate("DATAREG"):Cursor_qbe_allxraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000189")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xogopefbo.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000018B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xogopefbo.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_xogopefbo.Next();
        }
        m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
        Cursor_xogopefbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxraziobo->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo.GetString("CONNALTRO")))) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000191")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000191(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(qbe_allxraziobo->CONNALTRO,iif(qbe_allxraziobo->STATOREG<>'1',qbe_allxraziobo->DATAREG,qbe_allxraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxraziobo.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_allxraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo.GetDate("DATAREG"):Cursor_qbe_allxraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000195")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CONNALTRO"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"00000197")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("CONNALTRO"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from xerzistifrz
        m_cServer = m_Ctx.GetServer("xerzistifrz");
        m_cPhName = m_Ctx.GetPhName("xerzistifrz");
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
        Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistifrz.Eof())) {
          /* _fter := 1 */
          _fter = CPLib.Round(1,0);
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"0000019C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000019C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          /* xProg := arfn_chkspers(xerzistifrz->CODSOG,iif(qbe_allxraziobo->STATOREG<>'1',qbe_allxraziobo->DATAREG,qbe_allxraziobo->DATARETT)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xerzistifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxraziobo.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo.GetDate("DATAREG"):Cursor_qbe_allxraziobo.GetDate("DATARETT")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000001A0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistifrz.GetString("CODSOG"))+"";
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
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000001A2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL((CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistifrz.GetString("CODSOG"))+"";
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
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
          Cursor_xerzistifrz.Next();
        }
        m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
        Cursor_xerzistifrz.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxraziobo->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo.GetString("C_RAG")))) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000001A7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001A7(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_allxraziobo.GetString("CONNESBEN"))?"":Cursor_qbe_allxraziobo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
        } // End If
        // * --- Select from xeneficfrz
        m_cServer = m_Ctx.GetServer("xeneficfrz");
        m_cPhName = m_Ctx.GetPhName("xeneficfrz");
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
        Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficfrz.Eof())) {
          /* _fben := 1 */
          _fben = CPLib.Round(1,0);
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000001AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001AB(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_xeneficfrz.GetString("CODSOG"))?"":Cursor_xeneficfrz.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
          Cursor_xeneficfrz.Next();
        }
        m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
        Cursor_xeneficfrz.Close();
        // * --- End Select
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000001AD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Write into tmp_soggettioper from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec",149,"000001AE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Stampa" Page 6:Page_6 */
        Page_6();
        Cursor_qbe_allxraziobo.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxraziobo.ErrorMessage();
      Cursor_qbe_allxraziobo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxraziobo!=null)
          Cursor_qbe_allxraziobo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
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
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    /* _report := ReportLibrary.GetReportLibrary() */
    _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
    /* _report.setParameterChar('w_daCodDip',w_daCodDip) */
    _report.setParameterChar("w_daCodDip",w_daCodDip);
    /* _report.setParameterChar('w_aCodDip',w_aCodDip) */
    _report.setParameterChar("w_aCodDip",w_aCodDip);
    /* _report.setParameterChar('w_daCodCli',w_daCodCli) */
    _report.setParameterChar("w_daCodCli",w_daCodCli);
    /* _report.setParameterChar('w_aCodCli',w_aCodCli) */
    _report.setParameterChar("w_aCodCli",w_aCodCli);
    /* _report.setParameterChar('w_c_dadata',w_c_dadata) */
    _report.setParameterChar("w_c_dadata",w_c_dadata);
    /* _report.setParameterChar('w_c_adata',w_c_adata) */
    _report.setParameterChar("w_c_adata",w_c_adata);
    /* _report.setParameterChar('DescAzi',gDescAzi) */
    _report.setParameterChar("DescAzi",gDescAzi);
    /* _report.setParameterChar('pTipo',pTipo) */
    _report.setParameterChar("pTipo",pTipo);
    /* _report.setParameterChar('pAUI',pAUI) */
    _report.setParameterChar("pAUI",pAUI);
    /* _report.setParameterChar('w_flgrae',w_flgrae) */
    _report.setParameterChar("w_flgrae",w_flgrae);
    /* _nomerep := 'arrp_stp_stdtec;' // Nome Stampa */
    _nomerep = "arrp_stp_stdtec;";
    /* If _fint=1 */
    if (CPLib.eqr(_fint,1)) {
      /* _nomerep := _nomerep + 'arrp_stp_stdtec_1;' // Nome Stampa */
      _nomerep = _nomerep+"arrp_stp_stdtec_1;";
    } // End If
    /* If _fope=1 */
    if (CPLib.eqr(_fope,1)) {
      /* _nomerep := _nomerep + 'arrp_stp_stdtec_2;' // Nome Stampa */
      _nomerep = _nomerep+"arrp_stp_stdtec_2;";
    } // End If
    /* If _fben=1 */
    if (CPLib.eqr(_fben,1)) {
      /* _nomerep := _nomerep + 'arrp_stp_stdtec_3;' // Nome Stampa */
      _nomerep = _nomerep+"arrp_stp_stdtec_3;";
    } // End If
    /* If _fter=1 */
    if (CPLib.eqr(_fter,1)) {
      /* _nomerep := _nomerep + 'arrp_stp_stdtec_4;' // Nome Stampa */
      _nomerep = _nomerep+"arrp_stp_stdtec_4;";
    } // End If
    /* _nomerep := Left(_nomerep,Len(LRTrim(_nomerep)) - 1) // Nome Stampa */
    _nomerep = CPLib.Left(_nomerep,CPLib.Len(CPLib.LRTrim(_nomerep))-1);
    /* bReport := _report.makeReportMergingPdf(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_id+'.pdf','A4','PORTRAIT','PDF') */
    bReport = _report.makeReportMergingPdf(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_id+".pdf","A4","PORTRAIT","PDF");
    /* lReport := lReport+LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_id+'.pdf;' */
    lReport = lReport+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_id+".pdf;";
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,String p_pAUI) {
    pTipo = p_pTipo;
    pAUI = p_pAUI;
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
  public Forward Run(String p_pTipo,String p_pAUI) {
    pTipo = p_pTipo;
    pAUI = p_pAUI;
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("daCodCli","C",16,0,w_daCodCli);
      m_Caller.SetString("aCodCli","C",16,0,w_aCodCli);
      m_Caller.SetString("daCodDip","C",6,0,w_daCodDip);
      m_Caller.SetString("aCodDip","C",6,0,w_aCodDip);
      m_Caller.SetString("flgrae","C",1,0,w_flgrae);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stp_stdtecR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_stdtecR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    pAUI = CPLib.Space(1);
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_daCodCli = m_Caller.GetString("daCodCli","C",16,0);
    w_aCodCli = m_Caller.GetString("aCodCli","C",16,0);
    w_daCodDip = m_Caller.GetString("daCodDip","C",6,0);
    w_aCodDip = m_Caller.GetString("aCodDip","C",6,0);
    w_flgrae = m_Caller.GetString("flgrae","C",1,0);
    _nomerep = "";
    _report = null;
    bReport = false;
    _id = CPLib.Space(6);
    _idrep = CPLib.Space(10);
    _conta = 0;
    _numsto = CPLib.Space(15);
    w_c_dadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    xProg = CPLib.Space(15);
    lReport = "";
    _fint = 0;
    _fope = 0;
    _fter = 0;
    _fben = 0;
    _dipcabinter = CPLib.Space(6);
    _dipcittainter = CPLib.Space(30);
    _dipprvinter = CPLib.Space(2);
    _dipcab = CPLib.Space(6);
    _dipcitta = CPLib.Space(30);
    _dipprv = CPLib.Space(2);
    _codint2 = CPLib.Space(11);
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_alloperazbo,qbe_allxperazbo,qbe_allfraziobo,qbe_allxraziobo,
  public static final String m_cVQRList = ",qbe_alloperazbo,qbe_allxperazbo,qbe_allfraziobo,qbe_allxraziobo,";
  // ENTITY_BATCHES: ,arfn_chkspers,
  public static final String i_InvokedRoutines = ",arfn_chkspers,";
  public static String[] m_cRunParameterNames={"pTipo","pAUI"};
  protected static String GetFieldsName_00000047(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000049(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000066(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000071(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000088(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000093(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000097(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000101(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000107(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000112(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000129(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000135(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000140(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000014B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000014F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000163(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000185(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000191(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
}
