// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_mobappregBO extends spadministration_mobappregBL {
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
  public spadministration_mobappregBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"spadministration_mobappreg");
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
    l_bResult = CPLib.lt(CPLib.Len(CPLib.LRTrim(w_arfullname)),20);
    if (l_bResult && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
    } else {
      m_cLastMsgError = "errore di lunghezza";
    }
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
        if (l_bResult && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
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
    }
    return l_bResult;
  }
  public static String[] m_cLoadParameterNames = {"ar__code"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_ar__code) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cpappreg,m_cPhName_cpappreg,m_cVirtName_cpappreg,m_cVirtName_cpappreg+".ar__code="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_ar__code,"C",10,0),m_cServer_cpappreg,p_ar__code),"");
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
        w_ar__code = l_rsLoad.GetString("ar__code");
        op_ar__code = w_ar__code;
        w_ar__mail = l_rsLoad.GetString("ar__mail");
        w_arfullname = l_rsLoad.GetString("arfullname");
        w_arcompany = l_rsLoad.GetString("arcompany");
        w_ar__note = l_rsLoad.GetString("ar__note");
        w_ar_dtreg = l_rsLoad.GetDateTime("ar_dtreg");
        w_arappurl = l_rsLoad.GetString("arappurl");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappreg")) {
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
    return Load(w_ar__code);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // Aggiornamento dei progressivi
    SaveAutonumber();
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cpappreg);
      l_cSql = "insert into "+m_oWrInfo_cpappreg.GetTableWriteName()+" (";
      l_cSql = l_cSql+"ar__code,";
      l_cSql = l_cSql+"ar__mail,";
      l_cSql = l_cSql+"arfullname,";
      l_cSql = l_cSql+"arcompany,";
      l_cSql = l_cSql+"ar__note,";
      l_cSql = l_cSql+"ar_dtreg,";
      l_cSql = l_cSql+"arappurl,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cpappreg.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappreg")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_ar__code,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ar__mail,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_arfullname,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_arcompany,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ar__note,"M",10,0,m_cServer_cpappreg,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ar_dtreg,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_arappurl,"C",120,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cpappreg.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappreg")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cpappreg,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cpappreg);
      l_cSql = "Update "+m_oWrInfo_cpappreg.GetTableWriteName()+" set";
      l_cSql = l_cSql+" ar__mail = "+CPLib.ToSQL(w_ar__mail,"C",80,0);
      l_cSql = l_cSql+", arfullname = "+CPLib.ToSQL(w_arfullname,"C",80,0);
      l_cSql = l_cSql+", arcompany = "+CPLib.ToSQL(w_arcompany,"C",80,0);
      l_cSql = l_cSql+", ar__note = "+CPLib.ToSQL(w_ar__note,"M",10,0,m_cServer_cpappreg,m_oParameters);
      l_cSql = l_cSql+", ar_dtreg = "+CPLib.ToSQL(w_ar_dtreg,"T",14,0);
      l_cSql = l_cSql+", arappurl = "+CPLib.ToSQL(w_arappurl,"C",120,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappreg")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"ar__code="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ar__code,"C",10,0),m_cServer_cpappreg,w_ar__code);
      l_cSql = l_cSql+m_oWrInfo_cpappreg.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappreg")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cpappreg,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_ar__code) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_ar__code);
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
          l_cSql = "Delete from "+m_oWrInfo_cpappreg.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"ar__code="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ar__code,"C",10,0),m_cServer_cpappreg,w_ar__code);
          l_cSql = l_cSql+m_oWrInfo_cpappreg.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappreg")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cpappreg,l_cSql);
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
    return Delete(w_ar__code);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a ar__code
    w_ar__code = CPLib.Left(w_ar__code,10)+CPLib.Space(10-CPLib.Len(w_ar__code));
    m_Sql.NextTableProg(this,"cpappreg","w_ar__code",m_cServer_cpappreg,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave ar__code, altrimenti non si riesce a linkare da zoom
    w_ar__code = CPLib.RTrim(w_ar__code);
    op_ar__code = w_ar__code;
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
