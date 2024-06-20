// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class opemt_scarti_contanteBO extends opemt_scarti_contanteBL {
  class SqlLoader {
    double m_nColumns = 0;
    CPSql m_Sql;
    String m_cServer;
    String m_cMainTable;
    String m_cSelect;
    String m_cFrom;
    String m_cAlias;
    String m_cWhere;
    String m_cOrderBy;
    public SqlLoader(CPSql sql,String server,String from,String alias,String where,String orderby) {
      m_cAlias = alias;
      m_Sql = sql;
      m_cServer = server;
      m_cMainTable = alias;
      m_cSelect = m_cAlias+".*";
      m_cFrom = from+" "+m_cAlias;
      m_cWhere = where;
      m_cOrderBy = orderby;
    }
    public CPResultSet Query() {
      String l_cWhere = QueryFilter(m_Ctx);
      if (CPLib.Empty(l_cWhere)) {
        l_cWhere = m_cWhere;
      } else {
        if ( ! (CPLib.Empty(m_cWhere))) {
          l_cWhere = "("+m_cWhere+") and ("+l_cWhere+")";
        }
      }
      return m_Sql.Query(m_cServer,CPSql.BuildSQLPhrase(m_cSelect,m_cFrom,l_cWhere,m_cOrderBy));
    }
  }
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opemt_scarti_contanteBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean CheckOTPSecurity() {
    boolean l_bResult;
    l_bResult = true;
    int accessType;
    boolean requiredOTP;
    boolean requiredPwd;
    requiredOTP = (m_bLoaded?false:false);
    requiredPwd = (m_bLoaded?false:false);
    if (requiredOTP) {
      accessType = 3;
    } else if (requiredPwd) {
      accessType = 2;
    } else {
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"opemt_scarti_contante");
    }
    if (CPLib.eq(accessType,2)) {
      // richiesta password
      if ( ! (CPLib.CheckPwd(m_Ctx,m_cPassword))) {
        l_bResult = false;
        m_nLastError = 4;
        m_cLastMsgError = (CPLib.Empty(m_cPassword)?"MSG_NEED_PWD":"MSG_WRONG_PWD");
      }
    } else if (CPLib.eq(accessType,3)) {
      // richiesto otp
      if (CPLib.Empty(m_cOTP) ||  ! (CPLib.CheckOTP(m_Ctx.UserCode(),m_cOTP))) {
        l_bResult = false;
        m_nLastError = 5;
        m_cLastMsgError = (CPLib.Empty(m_cOTP)?"MSG_NEED_OTP":"MSG_WRONG_OTP");
      }
    }
    return l_bResult;
  }
  public boolean CanSave() {
    ResetErrorMessage();
    boolean l_bResult;
    l_bResult = true;
    if (l_bResult) {
      l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
    }
    return l_bResult;
  }
  public static String[] m_cSaveParameterNames = {"AlreadyAccepted"};
  public boolean Save() {
    return Save(false);
  }
  public boolean Save(boolean p_bAlreadyAccepted) {
    boolean l_bResult;
    l_bResult = true;
    // Se il record è stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
        // ne inizia una nuova ("begin transaction").
        m_Sql.RequireTransaction();
        if (m_bLoaded) {
          Update();
          BROnUpdated();
        } else {
          Insert();
          BROnInserted();
        }
        if (CPLib.gt(m_MNTs.length,0)) {
          if (m_bLoaded) {
            NotifyEvent("Update children start");
          } else {
            NotifyEvent("Insert children start");
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (CPLib.gt(m_MNTs.length,0)) {
          if (m_bLoaded) {
            NotifyEvent("Update children end");
          } else {
            NotifyEvent("Insert children end");
          }
        }
        /*  Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
                                    questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
                                    la parte di transazione corrente
                                  */
        // * --- Area Manuale = BO - Save End
        // * --- Fine Area Manuale
        BROnSaved();
        if (CPLib.ne(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          l_bResult = false;
        }
        m_Sql.CompleteTransaction();
      }
    }
    return l_bResult;
  }
  public static String[] m_cLoadParameterNames = {"NUMPROG"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_NUMPROG) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_scarto_contante,m_cPhName_scarto_contante,m_cVirtName_scarto_contante,m_cVirtName_scarto_contante+".NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_NUMPROG,"C",11,0),m_cServer_scarto_contante,p_NUMPROG),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    // Cursore dei record caricati
    l_rsLoad = l_oSqlLoader.Query();
    try {
      m_bLoaded =  ! (l_rsLoad.Eof());
      if (m_bLoaded) {
        m_bCalculating = true;
        /*  Assegna il valore iniziale a tutte le variabili non calcolate/inizializzate.
                                    Queste variabili non vengono inizializzate nella lettura del record,
                                    quindi terrebbero il valore che avevano precedentemente.
                                 */
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        w_TIPATT = l_rsLoad.GetString("TIPATT");
        w_TIPOATTIV = l_rsLoad.GetString("TIPOATTIV");
        w_CODICEGLN = l_rsLoad.GetString("CODICEGLN");
        w_TOTBANKNOTE = l_rsLoad.GetDouble("TOTBANKNOTE");
        w_TAGLIO = l_rsLoad.GetDouble("TAGLIO");
        w_NBANCONOTE = l_rsLoad.GetDouble("NBANCONOTE");
        w_ABIINTER = l_rsLoad.GetString("ABIINTER");
        w_ABIPROPR = l_rsLoad.GetString("ABIPROPR");
        w_GLNALTROSOG = l_rsLoad.GetString("GLNALTROSOG");
        w_GLNALTRASC = l_rsLoad.GetString("GLNALTRASC");
        w_CODCLICON = l_rsLoad.GetString("CODCLICON");
        w_CODCOMCON = l_rsLoad.GetString("CODCOMCON");
        w_ATECO_CON = l_rsLoad.GetString("ATECO_CON");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        w_IMPPROG = l_rsLoad.GetString("IMPPROG");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"scarto_contante")) {
          m_cOldCPCCCHK = l_rsLoad.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        m_bCalculating = false;
        SaveDependsOn();
        m_cPreviousState = GetCurrentState();
        NotifyEvent("Load");
      } else {
        Blank();
      }
    } finally {
      l_rsLoad.Close();
    }
    // * --- Area Manuale = BO - Load Record End
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_NUMPROG);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_scarto_contante);
      l_cSql = "insert into "+m_oWrInfo_scarto_contante.GetTableWriteName()+" (";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"TIPATT,";
      l_cSql = l_cSql+"TIPOATTIV,";
      l_cSql = l_cSql+"CODICEGLN,";
      l_cSql = l_cSql+"TOTBANKNOTE,";
      l_cSql = l_cSql+"TAGLIO,";
      l_cSql = l_cSql+"NBANCONOTE,";
      l_cSql = l_cSql+"ABIINTER,";
      l_cSql = l_cSql+"ABIPROPR,";
      l_cSql = l_cSql+"GLNALTROSOG,";
      l_cSql = l_cSql+"GLNALTRASC,";
      l_cSql = l_cSql+"CODCLICON,";
      l_cSql = l_cSql+"CODCOMCON,";
      l_cSql = l_cSql+"ATECO_CON,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"IMPPROG,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_scarto_contante.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarto_contante")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPATT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOATTIV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODICEGLN,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTBANKNOTE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TAGLIO,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NBANCONOTE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ABIINTER,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ABIPROPR,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GLNALTROSOG,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GLNALTRASC,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCLICON,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCOMCON,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ATECO_CON,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPPROG,"C",13,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_scarto_contante.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarto_contante")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_scarto_contante,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Insert end");
    // * --- Area Manuale = BO - Insert End
    // * --- Fine Area Manuale
  }
  void Update() {
    String l_cSql;
    int l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    // * --- Area Manuale = BO - Replace Init
    // * --- Fine Area Manuale
    NotifyEvent("Update start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_scarto_contante);
      l_cSql = "Update "+m_oWrInfo_scarto_contante.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TIPATT = "+CPLib.ToSQL(w_TIPATT,"C",3,0);
      l_cSql = l_cSql+", TIPOATTIV = "+CPLib.ToSQL(w_TIPOATTIV,"C",2,0);
      l_cSql = l_cSql+", CODICEGLN = "+CPLib.ToSQL(w_CODICEGLN,"C",13,0);
      l_cSql = l_cSql+", TOTBANKNOTE = "+CPLib.ToSQL(w_TOTBANKNOTE,"N",10,0);
      l_cSql = l_cSql+", TAGLIO = "+CPLib.ToSQL(w_TAGLIO,"N",4,0);
      l_cSql = l_cSql+", NBANCONOTE = "+CPLib.ToSQL(w_NBANCONOTE,"N",10,0);
      l_cSql = l_cSql+", ABIINTER = "+CPLib.ToSQL(w_ABIINTER,"C",5,0);
      l_cSql = l_cSql+", ABIPROPR = "+CPLib.ToSQL(w_ABIPROPR,"C",5,0);
      l_cSql = l_cSql+", GLNALTROSOG = "+CPLib.ToSQL(w_GLNALTROSOG,"C",13,0);
      l_cSql = l_cSql+", GLNALTRASC = "+CPLib.ToSQL(w_GLNALTRASC,"C",13,0);
      l_cSql = l_cSql+", CODCLICON = "+CPLib.ToSQL(w_CODCLICON,"C",20,0);
      l_cSql = l_cSql+", CODCOMCON = "+CPLib.ToSQL(w_CODCOMCON,"C",6,0);
      l_cSql = l_cSql+", ATECO_CON = "+CPLib.ToSQL(w_ATECO_CON,"C",10,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQL(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", IMPPROG = "+CPLib.ToSQL(w_IMPPROG,"C",13,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarto_contante")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMPROG,"C",11,0),m_cServer_scarto_contante,w_NUMPROG);
      l_cSql = l_cSql+m_oWrInfo_scarto_contante.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarto_contante")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_scarto_contante,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_NUMPROG) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_NUMPROG);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                    gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
                                    ne inizia una nuova ("begin transaction").
                                  */
        m_Sql.RequireTransaction();
        NotifyEvent("Delete start");
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_scarto_contante.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMPROG,"C",11,0),m_cServer_scarto_contante,w_NUMPROG);
          l_cSql = l_cSql+m_oWrInfo_scarto_contante.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"scarto_contante")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_scarto_contante,l_cSql);
          if (CPLib.ne(l_nUpdatedRows,1)) {
            // AbortTransaction
            m_Sql.AbortTransaction();
          }
        }
        NotifyEvent("Delete end");
        BROnDeleted();
        l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
        // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
        // la parte di transazione corrente
        m_Sql.CompleteTransaction();
      } else {
        m_Sql.AbortTransaction(m_cLastMsgError);
      }
    }
    // * --- Area Manuale = BO - Delete End
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_NUMPROG);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
