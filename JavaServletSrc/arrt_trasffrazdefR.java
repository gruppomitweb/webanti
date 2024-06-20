// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasffrazdefR implements CallerWithObjs {
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_msgtxt;
  public double w_valelab;
  public String cProg1;
  public String cProg2;
  public String cConCli;
  public String cConRap;
  public String cNumProg;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasffrazdefR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasffrazdef",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("valelab",p_cVarName)) {
      return w_valelab;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasffrazdef";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgtxt",p_cVarName)) {
      return w_msgtxt;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("cConCli",p_cVarName)) {
      return cConCli;
    }
    if (CPLib.eqr("cConRap",p_cVarName)) {
      return cConRap;
    }
    if (CPLib.eqr("cNumProg",p_cVarName)) {
      return cNumProg;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("valelab",p_cVarName)) {
      w_valelab = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgtxt",p_cVarName)) {
      w_msgtxt = value;
      return;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("cConCli",p_cVarName)) {
      cConCli = value;
      return;
    }
    if (CPLib.eqr("cConRap",p_cVarName)) {
      cConRap = value;
      return;
    }
    if (CPLib.eqr("cNumProg",p_cVarName)) {
      cNumProg = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_qbe_trasffraope10=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Variabili del caller */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_msgtxt Char(80) */
      /* w_valelab Numeric(1, 0) */
      /* Variabili locali */
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* cConCli Char(16) */
      /* cConRap Char(25) */
      /* cNumProg Char(11) */
      /* gAzienda Char(10) // Azienda */
      /* Scorre la query e trasferisce i dati */
      /* cConCli := Space(16) */
      cConCli = CPLib.Space(16);
      /* cConRap := Space(25) */
      cConRap = CPLib.Space(25);
      // * --- Select from qbe_trasffraope10
      if (Cursor_qbe_trasffraope10!=null)
        Cursor_qbe_trasffraope10.Close();
      Cursor_qbe_trasffraope10 = new VQRHolder("qbe_trasffraope10",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasffraope10.Eof())) {
        /* Calcolo i nuovi progressivi */
        /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
        cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
        /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",Space(11),11) */
        cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(11),11);
        /* Case Empty(qbe_trasffraope10->CONNESCLI) */
        if (CPLib.Empty(Cursor_qbe_trasffraope10.GetString("CONNESCLI"))) {
          /* If cConRap <> qbe_trasffraope10->RAPPORTO */
          if (CPLib.ne(cConRap,Cursor_qbe_trasffraope10.GetString("RAPPORTO"))) {
            /* cConRap := qbe_trasffraope10->RAPPORTO */
            cConRap = Cursor_qbe_trasffraope10.GetString("RAPPORTO");
            /* cNumProg := cProg2 */
            cNumProg = cProg2;
          } // End If
          /* Case Empty(qbe_trasffraope10->RAPPORTO) */
        } else if (CPLib.Empty(Cursor_qbe_trasffraope10.GetString("RAPPORTO"))) {
          /* If cConCli <> qbe_trasffraope10->CONNESCLI */
          if (CPLib.ne(cConCli,Cursor_qbe_trasffraope10.GetString("CONNESCLI"))) {
            /* cConCli := qbe_trasffraope10->CONNESCLI */
            cConCli = Cursor_qbe_trasffraope10.GetString("CONNESCLI");
            /* cNumProg := cProg2 */
            cNumProg = cProg2;
          } // End If
        } // End Case
        // * --- Insert into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffrazdef",24,"0000001B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODANA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("DESC2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetDouble("TOTLIRE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetDouble("TOTCONT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cNumProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetDouble("CAMBIO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("idcauana"),"?",0,0,m_cServer)+", ";
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
        // * --- Write into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffrazdef",24,"0000001C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
        m_cSql = m_cSql+"TIPOLEG = "+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("TIPOLEG"),"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("PAESE"),"C",3,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cProg1,"?",0,0,m_cServer),m_cServer,cProg1)+"";
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffrazdef",24,"0000001D")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_trasffraope10.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_trasffraope10.GetString("IDBASE"))+"";
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
        Cursor_qbe_trasffraope10.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasffraope10.ErrorMessage();
      Cursor_qbe_trasffraope10.Close();
      // * --- End Select
      // * --- Drop temporary table tmp_clirap
      if (m_Ctx.IsSharedTemp("tmp_clirap")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_clirap")) {
          m_cServer = m_Ctx.GetServer("tmp_clirap");
          m_cPhName = m_Ctx.GetPhName("tmp_clirap");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_clirap");
      }
      // * --- Drop temporary table tmp_elenco
      if (m_Ctx.IsSharedTemp("tmp_elenco")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_elenco")) {
          m_cServer = m_Ctx.GetServer("tmp_elenco");
          m_cPhName = m_Ctx.GetPhName("tmp_elenco");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_elenco");
      }
      /* w_msgtxt := Space(80) */
      w_msgtxt = CPLib.Space(80);
      /* w_valelab := 0 */
      w_valelab = CPLib.Round(0,0);
      /* Return  */
      Forward f;
      f=new Forward("arpg_trasfdafra_aope",false,this,Forward.Start,false);
      f.SetParameter("DaDatOpe",w_DaDatOpe);
      f.SetParameter("ADatOpe",w_ADatOpe);
      f.SetParameter("msgtxt",w_msgtxt);
      f.SetParameter("valelab",w_valelab);
      f.SetParameter("m_cParameterSequence","DaDatOpe"+","+"ADatOpe"+","+"msgtxt"+","+"valelab");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_trasffraope10!=null)
          Cursor_qbe_trasffraope10.Close();
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("msgtxt","C",80,0,w_msgtxt);
      m_Caller.SetNumber("valelab","N",1,0,w_valelab);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_trasffrazdefR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasffrazdefR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_msgtxt = m_Caller.GetString("msgtxt","C",80,0);
    w_valelab = m_Caller.GetNumber("valelab","N",1,0);
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    cConCli = CPLib.Space(16);
    cConRap = CPLib.Space(25);
    cNumProg = CPLib.Space(11);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasffraope10,
  public static final String m_cVQRList = ",qbe_trasffraope10,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000001B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
}
