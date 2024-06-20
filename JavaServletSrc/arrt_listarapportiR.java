// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_listarapportiR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_tmp_listarapd;
  public String m_cServer_tmp_listarapd;
  public String m_cPhName_tmp_listarapp;
  public String m_cServer_tmp_listarapp;
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
  public String pConnes;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_listarapportiR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_listarapporti",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listarapd")) {
      m_cPhName_tmp_listarapd = p_ContextObject.GetPhName("tmp_listarapd");
      if (m_cPhName_tmp_listarapd.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listarapd = m_cPhName_tmp_listarapd+" "+m_Ctx.GetWritePhName("tmp_listarapd");
      }
      m_cServer_tmp_listarapd = p_ContextObject.GetServer("tmp_listarapd");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listarapp")) {
      m_cPhName_tmp_listarapp = p_ContextObject.GetPhName("tmp_listarapp");
      if (m_cPhName_tmp_listarapp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listarapp = m_cPhName_tmp_listarapp+" "+m_Ctx.GetWritePhName("tmp_listarapp");
      }
      m_cServer_tmp_listarapp = p_ContextObject.GetServer("tmp_listarapp");
    }
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
      return "arrt_listarapporti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pConnes",p_cVarName)) {
      return pConnes;
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
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pConnes",p_cVarName)) {
      pConnes = value;
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
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xnarapbo=null;
    try {
      /* Parametri */
      /* pTipo Char(1) */
      /* pConnes Char(16) */
      /* Variabili del caller */
      /* Crea il file d'appoggio */
      /* Trova i rapporti basandosi su intestbo */
      /* If pTipo = 'D' */
      if (CPLib.eqr(pTipo,"D")) {
        // * --- Drop temporary table tmp_listarapd
        if (m_Ctx.IsSharedTemp("tmp_listarapd")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_listarapd")) {
            m_cServer = m_Ctx.GetServer("tmp_listarapd");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapd");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_listarapd");
        }
        // * --- Create temporary table tmp_listarapd
        if (m_Ctx.IsSharedTemp("tmp_listarapd")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_listarapd")) {
            m_cServer = m_Ctx.GetServer("tmp_listarapd");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapd");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_listarapd");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_listarapd");
        if ( ! (m_Ctx.IsSharedTemp("tmp_listarapd"))) {
          m_cServer = m_Ctx.GetServer("tmp_listarapd");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listarapd",m_cServer,"proto")),m_cPhName,"tmp_listarapd",m_Ctx);
        }
        m_cPhName_tmp_listarapd = m_cPhName;
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,pConnes)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          double nTry0000000Bstatus;
          nTry0000000Bstatus = m_Sql.GetTransactionStatus();
          String cTry0000000Bmsg;
          cTry0000000Bmsg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tmp_listarapd from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listarapd");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapd");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listarapd",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_listarapporti",12,"0000000C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listarapd",true);
            m_cSql = m_cSql+")";
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Bstatus,0)) {
              m_Sql.SetTransactionStatus(nTry0000000Bstatus,cTry0000000Bmsg);
            }
          }
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            // * --- Write into tmp_listarapd from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listarapd");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapd");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listarapd",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_listarapporti",12,"0000000F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_listarapd",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
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
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* Stop arpg_pers_rapporti */
        Forward f;
        f=new Forward("arpg_pers_rapporti",false,this,Forward.Start,false);
        f.SetParameter("m_bQuery",true);
        f.SetParameter("CONNES",pConnes);
        f.SetParameter("m_cParameterSequence","m_bQuery"+","+"CONNES");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        // * --- Drop temporary table tmp_listarapp
        if (m_Ctx.IsSharedTemp("tmp_listarapp")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_listarapp")) {
            m_cServer = m_Ctx.GetServer("tmp_listarapp");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapp");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_listarapp");
        }
        // * --- Create temporary table tmp_listarapp
        if (m_Ctx.IsSharedTemp("tmp_listarapp")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_listarapp")) {
            m_cServer = m_Ctx.GetServer("tmp_listarapp");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapp");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_listarapp");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_listarapp");
        if ( ! (m_Ctx.IsSharedTemp("tmp_listarapp"))) {
          m_cServer = m_Ctx.GetServer("tmp_listarapp");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listarapp",m_cServer,"proto")),m_cPhName,"tmp_listarapp",m_Ctx);
        }
        m_cPhName_tmp_listarapp = m_cPhName;
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,pConnes)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          double nTry00000014status;
          nTry00000014status = m_Sql.GetTransactionStatus();
          String cTry00000014msg;
          cTry00000014msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tmp_listarapp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listarapp");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listarapp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_listarapporti",12,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listarapp",true);
            m_cSql = m_cSql+")";
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000014status,0)) {
              m_Sql.SetTransactionStatus(nTry00000014status,cTry00000014msg);
            }
          }
          // * --- Select from xnarapbo
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          if (Cursor_xnarapbo!=null)
            Cursor_xnarapbo.Close();
          Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xntestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xnarapbo.Eof())) {
            // * --- Write into tmp_listarapp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listarapp");
            m_cPhName = m_Ctx.GetPhName("tmp_listarapp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listarapp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_listarapporti",12,"00000018")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_listarapp",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xnarapbo.GetString("RAPPORTO"))+"";
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
            Cursor_xnarapbo.Next();
          }
          m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
          Cursor_xnarapbo.Close();
          // * --- End Select
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
        /* Stop arpg_pers_rapporti_prov */
        Forward f;
        f=new Forward("arpg_pers_rapporti_prov",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
      try {
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,String p_pConnes) {
    pTipo = p_pTipo;
    pConnes = p_pConnes;
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
  public Forward Run(String p_pTipo,String p_pConnes) {
    pTipo = p_pTipo;
    pConnes = p_pConnes;
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
  public static arrt_listarapportiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_listarapportiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    pConnes = CPLib.Space(16);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pTipo","pConnes"};
  protected static String GetFieldsName_0000000C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listarapd",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listarapp",true);
    return p_cSql;
  }
}
