// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_updatesecurityR implements CallerWithObjs {
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
  public String m_cPhName_cpprgsec;
  public String m_cServer_cpprgsec;
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
  public String link;
  public String pType;
  public String usertype;
  public double code;
  public boolean opensecurity;
  public boolean hadSecurity;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_updatesecurityR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_updatesecurity",m_Caller);
    m_cPhName_cpprgsec = p_ContextObject.GetPhName("cpprgsec");
    if (m_cPhName_cpprgsec.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpprgsec = m_cPhName_cpprgsec+" "+m_Ctx.GetWritePhName("cpprgsec");
    }
    m_cServer_cpprgsec = p_ContextObject.GetServer("cpprgsec");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("code",p_cVarName)) {
      return code;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_updatesecurity";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("link",p_cVarName)) {
      return link;
    }
    if (CPLib.eqr("pType",p_cVarName)) {
      return pType;
    }
    if (CPLib.eqr("usertype",p_cVarName)) {
      return usertype;
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
    if (CPLib.eqr("opensecurity",p_cVarName)) {
      return opensecurity;
    }
    if (CPLib.eqr("hadSecurity",p_cVarName)) {
      return hadSecurity;
    }
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
    if (CPLib.eqr("code",p_cVarName)) {
      code = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("link",p_cVarName)) {
      link = value;
      return;
    }
    if (CPLib.eqr("pType",p_cVarName)) {
      pType = value;
      return;
    }
    if (CPLib.eqr("usertype",p_cVarName)) {
      usertype = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("opensecurity",p_cVarName)) {
      opensecurity = value;
      return;
    }
    if (CPLib.eqr("hadSecurity",p_cVarName)) {
      hadSecurity = value;
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
    /* link Char(250) */
    /* pType Char(10) // tipo di link */
    /* usertype Char(1) // U: user, G: group */
    /* code Numeric(9, 0) */
    /* opensecurity Bool */
    /* hadSecurity Bool // se true, ha delle sicurezze generiche impostate (non all'utente selezionato) */
    /* codifyLink Char(0) */
    String codifyLink;
    codifyLink = CPLib.Space(0);
    /* codifyLink := link // VMNMenuLoader.CodifyLink(link, pType) */
    codifyLink = link;
    /* If Utilities.IsAdministrator() */
    if (Utilities.Make(m_Ctx,m_Caller).IsAdministrator()) {
      /* If Upper(usertype)='U' */
      if (CPLib.eqr(CPLib.Upper(usertype),"U")) {
        /* If hadSecurity */
        if (hadSecurity) {
          // * --- Write into cpprgsec from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpprgsec");
          m_cPhName = m_Ctx.GetPhName("cpprgsec");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"0000000C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"sec1 = "+CPLib.ToSQL((opensecurity?1:-1000),"N",4,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpprgsec",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"progname = "+CPSql.SQLValueAdapter(CPLib.ToSQL(codifyLink,"?",0,0,m_cServer),m_cServer,codifyLink)+"";
          m_cSql = m_cSql+" and grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
          m_cSql = m_cSql+" and usrcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(code,"?",0,0,m_cServer),m_cServer,code)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows updated
            // * --- Insert into cpprgsec from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"0000000D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000000D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(codifyLink,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(code,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((opensecurity?1:-1000),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((opensecurity?1:-1000),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((opensecurity?1:-1000),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((opensecurity?1:-1000),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } else { // Else
          /* If opensecurity */
          if (opensecurity) {
            // * --- Delete from cpprgsec
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"0000000F")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"progname = "+CPSql.SQLValueAdapter(CPLib.ToSQL(codifyLink,"?",0,0,m_cServer),m_cServer,codifyLink)+"";
            m_cSql = m_cSql+" and usrcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(code,"?",0,0,m_cServer),m_cServer,code)+"";
            m_cSql = m_cSql+" and grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
            m_cSql = m_cSql+" and sec1 <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows deleted
              // * --- Insert into cpprgsec from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpprgsec");
              m_cPhName = m_Ctx.GetPhName("cpprgsec");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"00000010")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000010(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(codifyLink,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(code,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } else { // Else
            // * --- Insert into cpprgsec from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"00000011")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000011(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(codifyLink,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(code,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(-1000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(-1000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(-1000,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(-1000,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
        } // End If
      } else { // Else
        /* If hadSecurity */
        if (hadSecurity) {
          /* If opensecurity */
          if (opensecurity) {
            // * --- Write into cpprgsec from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"00000014")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"sec1 = "+CPLib.ToSQL(1,"N",4,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpprgsec",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"progname = "+CPSql.SQLValueAdapter(CPLib.ToSQL(codifyLink,"?",0,0,m_cServer),m_cServer,codifyLink)+"";
            m_cSql = m_cSql+" and grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(code,"?",0,0,m_cServer),m_cServer,code)+"";
            m_cSql = m_cSql+" and usrcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              // * --- Insert into cpprgsec from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpprgsec");
              m_cPhName = m_Ctx.GetPhName("cpprgsec");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(codifyLink,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(code,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } else { // Else
            // * --- Delete from cpprgsec
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"00000016")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"progname = "+CPSql.SQLValueAdapter(CPLib.ToSQL(codifyLink,"?",0,0,m_cServer),m_cServer,codifyLink)+"";
            m_cSql = m_cSql+" and usrcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
            m_cSql = m_cSql+" and grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(code,"?",0,0,m_cServer),m_cServer,code)+"";
            m_cSql = m_cSql+" and sec1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows deleted
              /* Error Msg 'Record non trovato, elemento non disabilitato' */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Record non trovato, elemento non disabilitato");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
              /* Return false */
              throw new Stop(false);
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
        } else { // Else
          /* -- in teoria dovrebbe esserci solo opensecurity true */
          /* If opensecurity */
          if (opensecurity) {
            // * --- Write into cpprgsec from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"0000001B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"sec1 = "+CPLib.ToSQL(1,"N",4,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpprgsec",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"progname = "+CPSql.SQLValueAdapter(CPLib.ToSQL(codifyLink,"?",0,0,m_cServer),m_cServer,codifyLink)+"";
            m_cSql = m_cSql+" and grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(code,"?",0,0,m_cServer),m_cServer,code)+"";
            m_cSql = m_cSql+" and usrcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              // * --- Insert into cpprgsec from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpprgsec");
              m_cPhName = m_Ctx.GetPhName("cpprgsec");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatesecurity",20,"0000001C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000001C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(codifyLink,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(code,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } else { // Else
            /* Error Msg 'Azione non valida, non è possibile disabilitare un gruppo su entità senza sicurezza impostata' */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Azione non valida, non è possibile disabilitare un gruppo su entità senza sicurezza impostata");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            /* Return false */
            throw new Stop(false);
          } // End If
        } // End If
      } // End If
      /* l_cEntityName Char(0) */
      String l_cEntityName;
      l_cEntityName = CPLib.Space(0);
      /* l_cEntityName := codifyLink */
      l_cEntityName = codifyLink;
      /* index Numeric(0, 0) */
      double index;
      index = 0;
      /* index := At(".", l_cEntityName) */
      index = CPLib.Round(CPLib.At(".",l_cEntityName),0);
      /* If index>0 */
      if (CPLib.gt(index,0)) {
        /* CPContext.RescanSecurity() */
        CPContext.RescanSecurity();
      } else { // Else
        /* index := At("/", l_cEntityName) */
        index = CPLib.Round(CPLib.At("/",l_cEntityName),0);
        /* If index>0 */
        if (CPLib.gt(index,0)) {
          /* CPContext.RescanSecurity() */
          CPContext.RescanSecurity();
        } else { // Else
          /* UserAdmin.ReloadSecurityForProgname( l_cEntityName ) */
          UserAdmin.Make(m_Ctx).ReloadSecurityForProgname(l_cEntityName);
        } // End If
      } // End If
    } // End If
    /* Return true */
    throw new Stop(true);
  }
  void _init_() {
  }
  public String RunAsync(String p_link,String p_pType,String p_usertype,double p_code,boolean p_opensecurity,boolean p_hadSecurity) {
    link = p_link;
    pType = p_pType;
    usertype = p_usertype;
    code = p_code;
    opensecurity = p_opensecurity;
    hadSecurity = p_hadSecurity;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public boolean Run(String p_link,String p_pType,String p_usertype,double p_code,boolean p_opensecurity,boolean p_hadSecurity) {
    link = p_link;
    pType = p_pType;
    usertype = p_usertype;
    code = p_code;
    opensecurity = p_opensecurity;
    hadSecurity = p_hadSecurity;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
    return l_result;
  }
  public static spadministration_updatesecurityR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_updatesecurityR(p_Ctx, p_Caller);
  }
  public static spadministration_updatesecurityR Make(CPContext p_Ctx) {
    return new spadministration_updatesecurityR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    link = CPLib.Space(250);
    pType = CPLib.Space(10);
    usertype = CPLib.Space(1);
    code = 0;
    opensecurity = false;
    hadSecurity = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_updatesecurity,
  public static final String i_InvokedRoutines = ",spadministration_updatesecurity,";
  public static String[] m_cRunParameterNames={"link","pType","usertype","code","opensecurity","hadSecurity"};
  protected static String GetFieldsName_0000000D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000010(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000011(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
}
