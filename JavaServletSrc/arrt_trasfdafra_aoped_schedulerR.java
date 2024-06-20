// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasfdafra_aoped_schedulerR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public double _conta;
  public String cProg1;
  public String cProg2;
  public String cProg3;
  public String cProgCol;
  public double cValRec;
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String w_segno;
  public String w_codcli;
  public String w_codrap;
  public String w_flgfrz;
  public String w_flgdel;
  public double w_importo;
  public String _coddip;
  public String _flgage;
  public double w_impfraz;
  public double w_minfraz;
  public double _ctrasf;
  public String _gMsgProc;
  public String _gAzienda;
  public String cProg;
  public String w_flgscd;
  public double w_ggscd;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasfdafra_aoped_schedulerR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_trasfdafra_aoped_scheduler",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
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
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("cValRec",p_cVarName)) {
      return cValRec;
    }
    if (CPLib.eqr("importo",p_cVarName)) {
      return w_importo;
    }
    if (CPLib.eqr("impfraz",p_cVarName)) {
      return w_impfraz;
    }
    if (CPLib.eqr("minfraz",p_cVarName)) {
      return w_minfraz;
    }
    if (CPLib.eqr("_ctrasf",p_cVarName)) {
      return _ctrasf;
    }
    if (CPLib.eqr("ggscd",p_cVarName)) {
      return w_ggscd;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasfdafra_aoped_scheduler";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      return cProg3;
    }
    if (CPLib.eqr("cProgCol",p_cVarName)) {
      return cProgCol;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      return w_segno;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      return w_codcli;
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      return w_codrap;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      return w_flgfrz;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_flgage",p_cVarName)) {
      return _flgage;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("flgscd",p_cVarName)) {
      return w_flgscd;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
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
    if (CPLib.eqr("cValRec",p_cVarName)) {
      cValRec = value;
      return;
    }
    if (CPLib.eqr("importo",p_cVarName)) {
      w_importo = value;
      return;
    }
    if (CPLib.eqr("impfraz",p_cVarName)) {
      w_impfraz = value;
      return;
    }
    if (CPLib.eqr("minfraz",p_cVarName)) {
      w_minfraz = value;
      return;
    }
    if (CPLib.eqr("_ctrasf",p_cVarName)) {
      _ctrasf = value;
      return;
    }
    if (CPLib.eqr("ggscd",p_cVarName)) {
      w_ggscd = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      cProg3 = value;
      return;
    }
    if (CPLib.eqr("cProgCol",p_cVarName)) {
      cProgCol = value;
      return;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      w_segno = value;
      return;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      w_codcli = value;
      return;
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      w_codrap = value;
      return;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      w_flgfrz = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_flgage",p_cVarName)) {
      _flgage = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("flgscd",p_cVarName)) {
      w_flgscd = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
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
  void Main() throws Exception {
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Variabili locali */
      /* _conta Numeric(10, 0) */
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* cProg3 Char(10) */
      /* cProgCol Char(11) */
      /* cValRec Numeric(1, 0) */
      /* w_dadata Date */
      /* w_adata Date */
      /* w_segno Char(1) // Segno Operazione */
      /* w_codcli Char(16) // Cliente Occasionale */
      /* w_codrap Char(25) // Codice Rapporto */
      /* w_flgfrz Char(1) */
      /* w_flgdel Char(1) */
      /* w_importo Numeric(15, 0) */
      /* _coddip Char(6) */
      /* _flgage Char(1) */
      /* w_impfraz Numeric(12, 2) */
      /* w_minfraz Numeric(12, 2) */
      /* _ctrasf Numeric(10, 0) */
      /* _gMsgProc Memo */
      /* _gAzienda Char(10) // Azienda */
      /* cProg Char(20) */
      /* w_flgscd Char(1) */
      /* w_ggscd Numeric(3, 0) */
      /* Legge i clienti con frazionate da trasferire */
      /* Info Msg 'Lancio Consolidamento Frazionate' */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log(CPLib.FormatMsg(m_Ctx,"Lancio Consolidamento Frazionate"));
      }
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Scorre la query e trasferisce i dati */
        /* w_flgfrz := 'N' */
        w_flgfrz = "N";
        /* w_flgdel := 'N' */
        w_flgdel = "N";
        /* w_impfraz := 0 */
        w_impfraz = CPLib.Round(0,2);
        /* w_minfraz := 0 */
        w_minfraz = CPLib.Round(0,2);
        /* _gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        _gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* w_flgfrz := intermbo->FLGFRAZ */
          w_flgfrz = Cursor_intermbo.GetString("FLGFRAZ");
          /* w_impfraz := intermbo->IMPINTOPE */
          w_impfraz = CPLib.Round(Cursor_intermbo.GetDouble("IMPINTOPE"),2);
          /* w_minfraz := intermbo->LIMITEFRZ */
          w_minfraz = CPLib.Round(Cursor_intermbo.GetDouble("LIMITEFRZ"),2);
          /* w_flgdel := intermbo->FRAZDEL */
          w_flgdel = Cursor_intermbo.GetString("FRAZDEL");
          /* w_flgscd := intermbo->FLGSCDFRZ */
          w_flgscd = Cursor_intermbo.GetString("FLGSCDFRZ");
          /* w_ggscd := intermbo->GIORNIFRZ */
          w_ggscd = CPLib.Round(Cursor_intermbo.GetDouble("GIORNIFRZ"),0);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* If w_flgscd='S' */
        if (CPLib.eqr(w_flgscd,"S")) {
          /* Imposta i limiti */
          /* w_dadata := arfn_dateminus(Date(),w_ggscd+6) */
          w_dadata = arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),w_ggscd+6);
          /* w_adata := arfn_dateminus(Date(),w_ggscd) */
          w_adata = arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),w_ggscd);
          /* w_minfraz := w_minfraz * 100 */
          w_minfraz = CPLib.Round(w_minfraz*100,2);
          /* w_impfraz := iif(w_impfraz=0,1500000,w_impfraz*100) */
          w_impfraz = CPLib.Round((CPLib.eqr(w_impfraz,0)?1500000:w_impfraz*100),2);
          /* Case w_dadata <= CharToDate("20011231") */
          if (CPLib.le(w_dadata,CPLib.CharToDate("20011231"))) {
            /* w_importo := 20000000 */
            w_importo = CPLib.Round(20000000,0);
            /* Case w_dadata >= CharToDate("20020101") and w_dadata <= CharToDate("20021227") */
          } else if (CPLib.ge(w_dadata,CPLib.CharToDate("20020101")) && CPLib.le(w_dadata,CPLib.CharToDate("20021227"))) {
            /* w_importo := 1032914 */
            w_importo = CPLib.Round(1032914,0);
            /* Case w_dadata > CharToDate("20021227") and w_dadata <= CharToDate("20071229") */
          } else if (CPLib.gt(w_dadata,CPLib.CharToDate("20021227")) && CPLib.le(w_dadata,CPLib.CharToDate("20071229"))) {
            /* w_importo := 1250000 */
            w_importo = CPLib.Round(1250000,0);
            /* Case w_dadata > CharToDate("20071229") */
          } else if (CPLib.gt(w_dadata,CPLib.CharToDate("20071229"))) {
            /* w_importo := w_impfraz */
            w_importo = CPLib.Round(w_impfraz,0);
          } // End Case
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000038status;
          nTry00000038status = m_Sql.GetTransactionStatus();
          String cTry00000038msg;
          cTry00000038msg = m_Sql.TransactionErrorMessage();
          try {
            /* _conta := 0 */
            _conta = CPLib.Round(0,0);
            /* _ctrasf := 0 */
            _ctrasf = CPLib.Round(0,0);
            /* Exec "Cliente occasionale e segno dare" Page 2:Page_1 */
            Page_1();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* Exec "Cliente occasionale e segno avere" Page 3:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* Exec "Rapporto continuativo e segno dare" Page 4:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* Exec "Rapporto continuativo e segno avere" Page 5:Page_4 */
            Page_4();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If w_flgdel = 'S' */
            if (CPLib.eqr(w_flgdel,"S")) {
              // * --- Select from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              if (Cursor_fraziobo!=null)
                Cursor_fraziobo.Close();
              Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,CODDIPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_dadata,"?",0,0,m_cServer, m_oParameters),m_cServer,w_dadata)+"  and  TIPOOPRAP <> 10 "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fraziobo.Eof())) {
                /* _coddip := fraziobo->CODDIPE */
                _coddip = Cursor_fraziobo.GetString("CODDIPE");
                /* _flgage := '' */
                _flgage = "";
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _flgage = Read_Cursor.GetString("AGENTE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _flgage = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_coddip)) or (not(Empty(LRTrim(_coddip))) and _flgage <> 'S') */
                if (CPLib.Empty(CPLib.LRTrim(_coddip)) || ( ! (CPLib.Empty(CPLib.LRTrim(_coddip))) && CPLib.ne(_flgage,"S"))) {
                  // * --- Delete from sogopefbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("sogopefbo");
                  m_cPhName = m_Ctx.GetPhName("sogopefbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000045")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("idbase"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("idbase"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Delete from clientifrz
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("clientifrz");
                  m_cPhName = m_Ctx.GetPhName("clientifrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000046")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("idbase"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("idbase"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Delete from beneficfrz
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("beneficfrz");
                  m_cPhName = m_Ctx.GetPhName("beneficfrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000047")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("idbase"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("idbase"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Delete from terzistifrz
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("terzistifrz");
                  m_cPhName = m_Ctx.GetPhName("terzistifrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000048")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("idbase"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("idbase"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Delete from fraziobo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000049")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("idbase"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("idbase"))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
                Cursor_fraziobo.Next();
              }
              m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
              Cursor_fraziobo.Close();
              // * --- End Select
            } // End If
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
            /* _gMsgProc := _gMsgProc + 'Sono state elaborate: '+ LRTrim(Str(_conta,10,0))+' frazionate' + NL */
            _gMsgProc = _gMsgProc+"Sono state elaborate: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate"+"\n";
            /* _gMsgProc := _gMsgProc + 'Sono state trasferite: '+ LRTrim(Str(_ctrasf,10,0))+' frazionate' + NL */
            _gMsgProc = _gMsgProc+"Sono state trasferite: "+CPLib.LRTrim(CPLib.Str(_ctrasf,10,0))+" frazionate"+"\n";
            /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _gMsgProc := "Rilevati errori nel trasferimento delle frazionate !" + NL */
            _gMsgProc = "Rilevati errori nel trasferimento delle frazionate !"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000038status,0)) {
              m_Sql.SetTransactionStatus(nTry00000038status,cTry00000038msg);
            }
          }
          /* Exec Routine arrt_writelog('IMPORT DATI','Scheduler','RESULTS',_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","Scheduler","RESULTS",_gMsgProc,"S");
        } // End If
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
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
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
    }
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_trasffraope1=null;
    CPResultSet Cursor_qbe_trasffraope10a=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cliente occasionale e segno dare */
      // * --- Select from qbe_trasffraope1
      if (Cursor_qbe_trasffraope1!=null)
        Cursor_qbe_trasffraope1.Close();
      Cursor_qbe_trasffraope1 = new VQRHolder("qbe_trasffraope1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasffraope1.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* w_segno := 'D' */
        w_segno = "D";
        /* w_codcli := qbe_trasffraope1->CONNESCLI */
        w_codcli = Cursor_qbe_trasffraope1.GetString("CONNESCLI");
        /* cProgCol := '' */
        cProgCol = "";
        /* cValRec := 0 */
        cValRec = CPLib.Round(0,0);
        // * --- Select from qbe_trasffraope10a
        if (Cursor_qbe_trasffraope10a!=null)
          Cursor_qbe_trasffraope10a.Close();
        Cursor_qbe_trasffraope10a = new VQRHolder("qbe_trasffraope10a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasffraope10a.Eof())) {
          /* _ctrasf := _ctrasf + 1 */
          _ctrasf = CPLib.Round(_ctrasf+1,0);
          /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
          cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          /* cProg3 := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg3 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* If cValRec = 0 */
          if (CPLib.eqr(cValRec,0)) {
            /* cProgCol := cProg2 */
            cProgCol = cProg2;
            /* cValRec := 1 */
            cValRec = CPLib.Round(1,0);
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000062")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000062(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } else { // Else
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000063")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000063(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } // End If
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            // * --- Insert into sogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000065")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000065(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000066")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetDouble("CPROWNUM"))+"";
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
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            // * --- Insert into clientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000068")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000068(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000069")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            // * --- Insert into beneficope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000006B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000006B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000006C")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("CODSOG"))+"";
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
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            // * --- Insert into terzistiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000006E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000006E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000006F")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
          /* _coddip := '' */
          _coddip = "";
          /* _flgage := '' */
          _flgage = "";
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"));
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _coddip = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _coddip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgage = Read_Cursor.GetString("AGENTE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgage = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_coddip)) or (not(Empty(LRTrim(_coddip))) and _flgage <> 'S') */
          if (CPLib.Empty(CPLib.LRTrim(_coddip)) || ( ! (CPLib.Empty(CPLib.LRTrim(_coddip))) && CPLib.ne(_flgage,"S"))) {
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000075")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000076")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000077")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000078")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from fraziobo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000079")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
          Cursor_qbe_trasffraope10a.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffraope10a.ErrorMessage();
        Cursor_qbe_trasffraope10a.Close();
        // * --- End Select
        Cursor_qbe_trasffraope1.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasffraope1.ErrorMessage();
      Cursor_qbe_trasffraope1.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_trasffraope1!=null)
          Cursor_qbe_trasffraope1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffraope10a!=null)
          Cursor_qbe_trasffraope10a.Close();
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
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_trasffraope2=null;
    CPResultSet Cursor_qbe_trasffraope10a=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cliente occasionale e segno avere */
      // * --- Select from qbe_trasffraope2
      if (Cursor_qbe_trasffraope2!=null)
        Cursor_qbe_trasffraope2.Close();
      Cursor_qbe_trasffraope2 = new VQRHolder("qbe_trasffraope2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasffraope2.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* w_segno := 'A' */
        w_segno = "A";
        /* w_codcli := qbe_trasffraope2->CONNESCLI // Cliente Occasionale */
        w_codcli = Cursor_qbe_trasffraope2.GetString("CONNESCLI");
        /* cProgCol := '' */
        cProgCol = "";
        /* cValRec := 0 */
        cValRec = CPLib.Round(0,0);
        // * --- Select from qbe_trasffraope10a
        if (Cursor_qbe_trasffraope10a!=null)
          Cursor_qbe_trasffraope10a.Close();
        Cursor_qbe_trasffraope10a = new VQRHolder("qbe_trasffraope10a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasffraope10a.Eof())) {
          /* _ctrasf := _ctrasf + 1 */
          _ctrasf = CPLib.Round(_ctrasf+1,0);
          /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
          cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          /* cProg3 := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg3 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* If cValRec = 0 */
          if (CPLib.eqr(cValRec,0)) {
            /* cProgCol := cProg2 */
            cProgCol = cProg2;
            /* cValRec := 1 */
            cValRec = CPLib.Round(1,0);
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000089")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000089(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } else { // Else
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000008A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10a.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } // End If
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            // * --- Insert into sogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000008C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000008D")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetDouble("CPROWNUM"))+"";
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
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            // * --- Insert into clientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000008F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000090")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            // * --- Insert into beneficope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000092")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000092(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000093")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("CODSOG"))+"";
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
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            // * --- Insert into terzistiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000095")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000095(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"00000096")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
          /* _coddip := '' */
          _coddip = "";
          /* _flgage := '' */
          _flgage = "";
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"));
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _coddip = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _coddip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgage = Read_Cursor.GetString("AGENTE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgage = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_coddip)) or (not(Empty(LRTrim(_coddip))) and _flgage <> 'S') */
          if (CPLib.Empty(CPLib.LRTrim(_coddip)) || ( ! (CPLib.Empty(CPLib.LRTrim(_coddip))) && CPLib.ne(_flgage,"S"))) {
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000009C")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000009D")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000009E")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"0000009F")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
            // * --- Delete from fraziobo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000A0")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10a.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10a.GetString("IDBASE"))+"";
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
          Cursor_qbe_trasffraope10a.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffraope10a.ErrorMessage();
        Cursor_qbe_trasffraope10a.Close();
        // * --- End Select
        Cursor_qbe_trasffraope2.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasffraope2.ErrorMessage();
      Cursor_qbe_trasffraope2.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_trasffraope2!=null)
          Cursor_qbe_trasffraope2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffraope10a!=null)
          Cursor_qbe_trasffraope10a.Close();
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
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_trasffraope3=null;
    CPResultSet Cursor_qbe_trasffraope10b=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Rapporto continuativo e segno dare */
      // * --- Select from qbe_trasffraope3
      if (Cursor_qbe_trasffraope3!=null)
        Cursor_qbe_trasffraope3.Close();
      Cursor_qbe_trasffraope3 = new VQRHolder("qbe_trasffraope3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasffraope3.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* w_segno := 'D' */
        w_segno = "D";
        /* w_codrap := qbe_trasffraope3->RAPPORTO // Codice Rapporto */
        w_codrap = Cursor_qbe_trasffraope3.GetString("RAPPORTO");
        /* cProgCol := '' */
        cProgCol = "";
        /* cValRec := 0 */
        cValRec = CPLib.Round(0,0);
        // * --- Select from qbe_trasffraope10b
        if (Cursor_qbe_trasffraope10b!=null)
          Cursor_qbe_trasffraope10b.Close();
        Cursor_qbe_trasffraope10b = new VQRHolder("qbe_trasffraope10b",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasffraope10b.Eof())) {
          /* _ctrasf := _ctrasf + 1 */
          _ctrasf = CPLib.Round(_ctrasf+1,0);
          /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
          cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          /* cProg3 := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg3 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* If cValRec = 0 */
          if (CPLib.eqr(cValRec,0)) {
            /* cProgCol := cProg2 */
            cProgCol = cProg2;
            /* cValRec := 1 */
            cValRec = CPLib.Round(1,0);
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } else { // Else
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B1(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } // End If
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            // * --- Insert into sogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B4")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetDouble("CPROWNUM"))+"";
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
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            // * --- Insert into clientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B6(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B7")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            // * --- Insert into beneficope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000B9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000BA")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("CODSOG"))+"";
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
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            // * --- Insert into terzistiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000BC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000BC(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000BD")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
          /* _coddip := '' */
          _coddip = "";
          /* _flgage := '' */
          _flgage = "";
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"));
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _coddip = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _coddip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgage = Read_Cursor.GetString("AGENTE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgage = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_coddip)) or (not(Empty(LRTrim(_coddip))) and _flgage <> 'S') */
          if (CPLib.Empty(CPLib.LRTrim(_coddip)) || ( ! (CPLib.Empty(CPLib.LRTrim(_coddip))) && CPLib.ne(_flgage,"S"))) {
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000C3")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000C4")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000C5")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000C6")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from fraziobo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000C7")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
          Cursor_qbe_trasffraope10b.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffraope10b.ErrorMessage();
        Cursor_qbe_trasffraope10b.Close();
        // * --- End Select
        Cursor_qbe_trasffraope3.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasffraope3.ErrorMessage();
      Cursor_qbe_trasffraope3.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_trasffraope3!=null)
          Cursor_qbe_trasffraope3.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffraope10b!=null)
          Cursor_qbe_trasffraope10b.Close();
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
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_trasffraope4=null;
    CPResultSet Cursor_qbe_trasffraope10b=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Rapporto continuativo e segno avere */
      // * --- Select from qbe_trasffraope4
      if (Cursor_qbe_trasffraope4!=null)
        Cursor_qbe_trasffraope4.Close();
      Cursor_qbe_trasffraope4 = new VQRHolder("qbe_trasffraope4",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasffraope4.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* w_segno := 'A' */
        w_segno = "A";
        /* w_codrap := qbe_trasffraope4->RAPPORTO // Codice Rapporto */
        w_codrap = Cursor_qbe_trasffraope4.GetString("RAPPORTO");
        /* cProgCol := '' */
        cProgCol = "";
        /* cValRec := 0 */
        cValRec = CPLib.Round(0,0);
        // * --- Select from qbe_trasffraope10b
        if (Cursor_qbe_trasffraope10b!=null)
          Cursor_qbe_trasffraope10b.Close();
        Cursor_qbe_trasffraope10b = new VQRHolder("qbe_trasffraope10b",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasffraope10b.Eof())) {
          /* _ctrasf := _ctrasf + 1 */
          _ctrasf = CPLib.Round(_ctrasf+1,0);
          /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(_gAzienda)+"'",'',11) */
          cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(_gAzienda)+"'","",11);
          /* cProg3 := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_gAzienda)+"'",'',10) */
          cProg3 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
          /* If cValRec = 0 */
          if (CPLib.eqr(cValRec,0)) {
            /* cProgCol := cProg2 */
            cProgCol = cProg2;
            /* cValRec := 1 */
            cValRec = CPLib.Round(1,0);
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000D7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } else { // Else
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000D8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D8(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_trasffraope10b.GetDate("DATAOPE"))+cProg1+Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgCol,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("IMPOUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("SV58550"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
          } // End If
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            // * --- Insert into sogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000DA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000DA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000DB")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_sogopefbo.GetDouble("CPROWNUM"))+"";
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
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            // * --- Insert into clientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000DD(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000DE")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"))+"";
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
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            // * --- Insert into beneficope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000E1")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_beneficfrz.GetString("CODSOG"))+"";
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
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            // * --- Insert into terzistiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000E3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000E4")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("IDFILEBO"))+"";
            m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_terzistifrz.GetString("CODSOG"))+"";
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
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
          /* _coddip := '' */
          _coddip = "";
          /* _flgage := '' */
          _flgage = "";
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"));
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _coddip = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _coddip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgage = Read_Cursor.GetString("AGENTE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_trasfdafra_aoped_scheduler returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgage = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_coddip)) or (not(Empty(LRTrim(_coddip))) and _flgage <> 'S') */
          if (CPLib.Empty(CPLib.LRTrim(_coddip)) || ( ! (CPLib.Empty(CPLib.LRTrim(_coddip))) && CPLib.ne(_flgage,"S"))) {
            // * --- Delete from sogopefbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000EA")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from clientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000EB")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from beneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000EC")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from terzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000ED")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
            // * --- Delete from fraziobo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfdafra_aoped_scheduler",107,"000000EE")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10b.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10b.GetString("IDBASE"))+"";
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
          Cursor_qbe_trasffraope10b.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffraope10b.ErrorMessage();
        Cursor_qbe_trasffraope10b.Close();
        // * --- End Select
        Cursor_qbe_trasffraope4.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasffraope4.ErrorMessage();
      Cursor_qbe_trasffraope4.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_trasffraope4!=null)
          Cursor_qbe_trasffraope4.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffraope10b!=null)
          Cursor_qbe_trasffraope10b.Close();
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
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
          Main();
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
  public static arrt_trasfdafra_aoped_schedulerR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasfdafra_aoped_schedulerR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _conta = 0;
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    cProg3 = CPLib.Space(10);
    cProgCol = CPLib.Space(11);
    cValRec = 0;
    w_dadata = CPLib.NullDate();
    w_adata = CPLib.NullDate();
    w_segno = CPLib.Space(1);
    w_codcli = CPLib.Space(16);
    w_codrap = CPLib.Space(25);
    w_flgfrz = CPLib.Space(1);
    w_flgdel = CPLib.Space(1);
    w_importo = 0;
    _coddip = CPLib.Space(6);
    _flgage = CPLib.Space(1);
    w_impfraz = 0;
    w_minfraz = 0;
    _ctrasf = 0;
    _gMsgProc = "";
    _gAzienda = CPLib.Space(10);
    cProg = CPLib.Space(20);
    w_flgscd = CPLib.Space(1);
    w_ggscd = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasffraope1,qbe_trasffraope10a,qbe_trasffraope2,qbe_trasffraope10a,qbe_trasffraope3,qbe_trasffraope10b,qbe_trasffraope4,qbe_trasffraope10b,
  public static final String m_cVQRList = ",qbe_trasffraope1,qbe_trasffraope10a,qbe_trasffraope2,qbe_trasffraope10a,qbe_trasffraope3,qbe_trasffraope10b,qbe_trasffraope4,qbe_trasffraope10b,";
  // ENTITY_BATCHES: ,arfn_dateminus,arfn_fdatetime,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_dateminus,arfn_fdatetime,arrt_writelog,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000062(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000063(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000065(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000068(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000089(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000092(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000095(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"UNIQUECODE,";
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
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
}
