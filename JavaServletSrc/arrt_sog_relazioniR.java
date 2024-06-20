// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_sog_relazioniR implements CallerWithObjs {
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
  public String m_cPhName_tmp_soggettioper;
  public String m_cServer_tmp_soggettioper;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
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
  public String w_CodCli;
  public String w_RAGSOC1;
  public String NoName;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_sog_relazioniR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sog_relazioni",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
      m_cPhName_tmp_soggettioper = p_ContextObject.GetPhName("tmp_soggettioper");
      if (m_cPhName_tmp_soggettioper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_soggettioper = m_cPhName_tmp_soggettioper+" "+m_Ctx.GetWritePhName("tmp_soggettioper");
      }
      m_cServer_tmp_soggettioper = p_ContextObject.GetServer("tmp_soggettioper");
    }
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_sog_relazioni";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CodCli",p_cVarName)) {
      return w_CodCli;
    }
    if (CPLib.eqr("RAGSOC1",p_cVarName)) {
      return w_RAGSOC1;
    }
    if (CPLib.eqr("NoName",p_cVarName)) {
      return NoName;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CodCli",p_cVarName)) {
      w_CodCli = value;
      return;
    }
    if (CPLib.eqr("RAGSOC1",p_cVarName)) {
      w_RAGSOC1 = value;
      return;
    }
    if (CPLib.eqr("NoName",p_cVarName)) {
      NoName = value;
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
    CPResultSet Cursor_qbe_relazioni_o1=null;
    CPResultSet Cursor_qbe_relazioni_f1=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_rapotit=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_CodCli Char(16) */
      /* w_RAGSOC1 Char(16) */
      /* NoName Char(1) */
      /* gMsgImp Char(120) // Messaggio Import */
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
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_soggettioper",m_cServer,"proto")),m_cPhName,"tmp_soggettioper",m_Ctx);
      }
      m_cPhName_tmp_soggettioper = m_cPhName;
      /* gMsgImp := 'Elaborazione Operazioni' // Messaggio Import */
      gMsgImp = "Elaborazione Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_relazioni_o1
      SPBridge.HMCaller _h0000000D;
      _h0000000D = new SPBridge.HMCaller();
      _h0000000D.Set("m_cVQRList",m_cVQRList);
      _h0000000D.Set("CodCli",w_CodCli);
      if (Cursor_qbe_relazioni_o1!=null)
        Cursor_qbe_relazioni_o1.Close();
      Cursor_qbe_relazioni_o1 = new VQRHolder("qbe_relazioni_o1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_relazioni_o1.Eof())) {
        // * --- Insert into tmp_soggettioper from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"0000000E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000000E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_o1.GetString("RUOLO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_o1.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_o1.GetString("TIPO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_o1.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_o1.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_o1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
        Cursor_qbe_relazioni_o1.Next();
      }
      m_cConnectivityError = Cursor_qbe_relazioni_o1.ErrorMessage();
      Cursor_qbe_relazioni_o1.Close();
      // * --- End Select
      /* gMsgImp := 'Elaborazione Frazionate' // Messaggio Import */
      gMsgImp = "Elaborazione Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_relazioni_f1
      SPBridge.HMCaller _h00000011;
      _h00000011 = new SPBridge.HMCaller();
      _h00000011.Set("m_cVQRList",m_cVQRList);
      _h00000011.Set("CodCli",w_CodCli);
      if (Cursor_qbe_relazioni_f1!=null)
        Cursor_qbe_relazioni_f1.Close();
      Cursor_qbe_relazioni_f1 = new VQRHolder("qbe_relazioni_f1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000011,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_relazioni_f1.Eof())) {
        // * --- Insert into tmp_soggettioper from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000012")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000012(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_f1.GetString("RUOLO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_f1.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_f1.GetString("TIPO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_f1.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_f1.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_relazioni_f1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
        Cursor_qbe_relazioni_f1.Next();
      }
      m_cConnectivityError = Cursor_qbe_relazioni_f1.ErrorMessage();
      Cursor_qbe_relazioni_f1.Close();
      // * --- End Select
      /* gMsgImp := 'Elaborazione Rapporti Continuativi' // Messaggio Import */
      gMsgImp = "Elaborazione Rapporti Continuativi";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      if (Cursor_intestbo!=null)
        Cursor_intestbo.Close();
      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CodCli)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestbo.Eof())) {
        /* If not(Empty(intestbo->NUMPROG1)) */
        if ( ! (CPLib.Empty(Cursor_intestbo.GetString("NUMPROG1")))) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* If At(rapopebo->TIPOOPRAP,"|31|32") = 0 */
            if (CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|31|32"),0)) {
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000019")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000019(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(intestbo->NUMPROG2)) */
        if ( ! (CPLib.Empty(Cursor_intestbo.GetString("NUMPROG2")))) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* If At(rapopebo->TIPOOPRAP,"|31|32") = 0 */
            if (CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|31|32"),0)) {
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"0000001D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000001D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
        } // End If
        Cursor_intestbo.Next();
      }
      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
      Cursor_intestbo.Close();
      // * --- End Select
      // * --- Select from delegabo
      m_cServer = m_Ctx.GetServer("delegabo");
      m_cPhName = m_Ctx.GetPhName("delegabo");
      if (Cursor_delegabo!=null)
        Cursor_delegabo.Close();
      Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CodCli)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_delegabo.Eof())) {
        /* If not(Empty(delegabo->NUMPROG1)) */
        if ( ! (CPLib.Empty(Cursor_delegabo.GetString("NUMPROG1")))) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* If At(rapopebo->TIPOOPRAP,"|31|32") = 0 */
            if (CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|31|32"),0)) {
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000022")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000022(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(delegabo->NUMPROG2)) */
        if ( ! (CPLib.Empty(Cursor_delegabo.GetString("NUMPROG2")))) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* If At(rapopebo->TIPOOPRAP,"|31|32") = 0 */
            if (CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|31|32"),0)) {
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
        } // End If
        Cursor_delegabo.Next();
      }
      m_cConnectivityError = Cursor_delegabo.ErrorMessage();
      Cursor_delegabo.Close();
      // * --- End Select
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CodCli)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        /* If At(rapopebo->TIPOOPRAP,"|31|32") = 0 */
        if (CPLib.eqr(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|31|32"),0)) {
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000029")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000029(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
      /* gMsgImp := 'Elaborazione Legami Tra Soggetti' // Messaggio Import */
      gMsgImp = "Elaborazione Legami Tra Soggetti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from intestit
      m_cServer = m_Ctx.GetServer("intestit");
      m_cPhName = m_Ctx.GetPhName("intestit");
      if (Cursor_intestit!=null)
        Cursor_intestit.Close();
      Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CodCli)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestit.Eof())) {
        /* If not(Empty(intestit->NUMPROG1)) */
        if ( ! (CPLib.Empty(Cursor_intestit.GetString("NUMPROG1")))) {
          // * --- Select from rapotit
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          if (Cursor_rapotit!=null)
            Cursor_rapotit.Close();
          Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,CONNESCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG1"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapotit.Eof())) {
            /* If At(rapotit->TIPOOPRAP,"|54|55") = 0 */
            if (CPLib.eqr(CPLib.At(Cursor_rapotit.GetString("TIPOOPRAP"),"|54|55"),0)) {
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("L","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
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
            Cursor_rapotit.Next();
          }
          m_cConnectivityError = Cursor_rapotit.ErrorMessage();
          Cursor_rapotit.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(intestit->NUMPROG2)) */
        if ( ! (CPLib.Empty(Cursor_intestit.GetString("NUMPROG2")))) {
          // * --- Select from rapotit
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          if (Cursor_rapotit!=null)
            Cursor_rapotit.Close();
          Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG,DATAOPE,TIPOOPRAP,CONNESCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG2"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapotit.Eof())) {
            /* If At(rapotit->TIPOOPRAP,"|54|55") = 0 */
            if (CPLib.eqr(CPLib.At(Cursor_rapotit.GetString("TIPOOPRAP"),"|54|55"),0)) {
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("L","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
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
            Cursor_rapotit.Next();
          }
          m_cConnectivityError = Cursor_rapotit.ErrorMessage();
          Cursor_rapotit.Close();
          // * --- End Select
        } // End If
        Cursor_intestit.Next();
      }
      m_cConnectivityError = Cursor_intestit.ErrorMessage();
      Cursor_intestit.Close();
      // * --- End Select
      // * --- Select from rapotit
      m_cServer = m_Ctx.GetServer("rapotit");
      m_cPhName = m_Ctx.GetPhName("rapotit");
      if (Cursor_rapotit!=null)
        Cursor_rapotit.Close();
      Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CodCli)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapotit.Eof())) {
        /* If At(rapotit->TIPOOPRAP,"|54|55") = 0 */
        if (CPLib.eqr(CPLib.At(Cursor_rapotit.GetString("TIPOOPRAP"),"|54|55"),0)) {
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_sog_relazioni",15,"00000037")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000037(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_CodCli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("L","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
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
        Cursor_rapotit.Next();
      }
      m_cConnectivityError = Cursor_rapotit.ErrorMessage();
      Cursor_rapotit.Close();
      // * --- End Select
      /* gMsgImp := 'Elaborazione Terminata! Dati pronti per la stampa.' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata! Dati pronti per la stampa.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Stop arrp_sog_relazioni.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("formatTypes","PDF|XLS|CSV");
      f.SetParameter("hideCover",true);
      f.SetParameter("hideLanguage",true);
      f.SetParameter("hideSettings",true);
      f.SetParameter("w_CodCli",w_CodCli);
      f.SetParameter("w_RagSoc",w_RAGSOC1);
      f.SetParameter("ReportName","arrp_sog_relazioni.vrp");
      f.SetParameter("m_cParameterSequence","formatTypes"+","+"hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"w_CodCli"+","+"w_RagSoc"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_relazioni_o1!=null)
          Cursor_qbe_relazioni_o1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_relazioni_f1!=null)
          Cursor_qbe_relazioni_f1.Close();
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
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
      m_Caller.SetString("CodCli","C",16,0,w_CodCli);
      m_Caller.SetString("RAGSOC1","C",16,0,w_RAGSOC1);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sog_relazioniR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sog_relazioniR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CodCli = m_Caller.GetString("CodCli","C",16,0);
    w_RAGSOC1 = m_Caller.GetString("RAGSOC1","C",16,0);
    NoName = CPLib.Space(1);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_relazioni_o1,qbe_relazioni_f1,
  public static final String m_cVQRList = ",qbe_relazioni_o1,qbe_relazioni_f1,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000000E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000012(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000019(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000022(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000029(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000037(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
}
