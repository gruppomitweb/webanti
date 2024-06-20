// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spauthid_clientBO extends spauthid_clientBL {
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
  class SqlDetailLoader {
    double m_nColumns = 0;
    CPSql m_Sql;
    String m_cServer;
    String m_cMainTable;
    String m_cSelect;
    String m_cFrom;
    String m_cAlias;
    String m_cWhere;
    String m_cOrderBy;
    public SqlDetailLoader(CPSql sql,String server,String from,String alias,String where,String orderby) {
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
      String l_cWhere = m_cWhere;
      return m_Sql.Query(m_cServer,CPSql.BuildSQLPhrase(m_cSelect,m_cFrom,l_cWhere,m_cOrderBy));
    }
  }
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spauthid_clientBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"spauthid_client");
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
    double l_nRow;
    boolean l_bResult;
    l_bResult = true;
    if (l_bResult) {
      l_bResult = CanSaveDeletedRows();
      l_nRow = 0;
      while (l_bResult && CPLib.lt(l_nRow,Rows())) {
        SetRow(l_nRow);
        l_bResult = CanSaveRow();
        l_bResult = l_bResult && CanSaveMNTs(m_MNTs,true);
        if (l_bResult) {
        }
        l_nRow = l_nRow+1;
      }
      l_bResult = l_bResult && CanSaveMNTs(m_MNTs,false);
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
    // Se il record � stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'� gi� una, utilizza quella, altrimenti
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
  public static String[] m_cLoadParameterNames = {"usercode"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_usercode) {
    CPResultSet l_rsLoad=null;
    CPResultSet l_rsLoadBody=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_spauthid_client_m,m_cPhName_spauthid_client_m,m_cVirtName_spauthid_client_m,m_cVirtName_spauthid_client_m+".usercode="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_usercode,"N",9,0),m_cServer_spauthid_client_m,p_usercode),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    String l_cOrderBy;
    l_cOrderBy = m_cVirtName_spauthid_client+".CPRowNum";
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
        w_usercode = l_rsLoad.GetDouble("usercode");
        w_publickey = l_rsLoad.GetString("publickey");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
          m_cOldCPCCCHK = l_rsLoad.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        // azzera i totali
        // ora legge il corpo
        SqlDetailLoader l_oSqlDetailLoader;
        l_oSqlDetailLoader = new SqlDetailLoader(m_Sql,m_cServer_spauthid_client,m_cPhName_spauthid_client,m_cVirtName_spauthid_client,m_cVirtName_spauthid_client+".usercode="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_usercode,"N",9,0),m_cServer_spauthid_client_m,p_usercode),l_cOrderBy);
        // * --- Area Manuale = BO - Before Load Detail
        // * --- Fine Area Manuale
        l_rsLoadBody = l_oSqlDetailLoader.Query();
        try {
          while ( ! (l_rsLoadBody.Eof())) {
            m_nCurrentRow = Rows();
            w_callbackuri = l_rsLoadBody.GetString("callbackuri");
            w_CPROWNUM = l_rsLoadBody.GetDouble("CPROWNUM");
            // Assegna il contesto dei figli del dettaglio a Empty
            work_children = CPLib.BlankChildMNTs(m_MNTs,true);
            work_extended = SPExtenderLib.BlankRepeatedExtendedFields(extendedFields_trs);
            SPExtenderLib.LoadExtendedFields(l_rsLoadBody,work_extended);
            m_nCPRowNum = l_rsLoadBody.GetInt("CPROWNUM");
            if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
              m_cOldRowCPCCCHK = l_rsLoadBody.GetString("CPCCCHK");
            } else {
              m_cOldRowCPCCCHK = "nocpcc";
            }
            // aggiunge i valori della riga corrente ai totali
            // * --- Area Manuale = BO - Load Row End
            // * --- Fine Area Manuale
            // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
            AppendRow();
            l_rsLoadBody.Next();
          }
        } finally {
          if (l_rsLoadBody!=null)
            l_rsLoadBody.Close();
        }
        // Valorizza le variabili che dipendono da totalizzazioni
        m_bCalculating = false;
        m_cPreviousState = GetCurrentState();
        SaveDependsOn();
        m_bHeaderUpdated = false;
        NotifyEvent("Load");
      } else {
        Blank();
      }
    } finally {
      if (l_rsLoad!=null)
        l_rsLoad.Close();
    }
    // * --- Area Manuale = BO - Load Record End
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_usercode);
  }
  void Insert() {
    double l_nCPHSTK = 0;
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    int l_nRow;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      // salva la testata
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_spauthid_client);
      l_cSql = "insert into "+m_oWrInfo_spauthid_client_m.GetTableWriteName()+" (";
      l_cSql = l_cSql+"usercode,";
      l_cSql = l_cSql+"publickey,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_spauthid_client_m.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_usercode,"N",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_publickey,"M",10,0,m_cServer_spauthid_client,m_oParameters)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_spauthid_client_m.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_spauthid_client,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Insert end");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      // salva le righe
      l_nRow = 0;
      if (CPLib.lt(0,Rows())) {
        NotifyEvent("Insert with rows start");
      }
      while (CPLib.lt(l_nRow,Rows()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
        SetRow(l_nRow);
        InsertDetailRow();
        l_nRow = l_nRow+1;
      }
      if (CPLib.lt(0,Rows())) {
        NotifyEvent("Insert with rows end");
      }
    }
    // * --- Area Manuale = BO - Insert End
    // * --- Fine Area Manuale
  }
  void Update() {
    String l_cSql;
    int l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    int l_nRow;
    // * --- Area Manuale = BO - Replace Init
    // * --- Fine Area Manuale
    // Aggiornamento della tabella master se la testata od i piedi sono stati modificati
    if (m_bHeaderUpdated) {
      NotifyEvent("Update start");
      if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_spauthid_client);
        l_cSql = "Update "+m_oWrInfo_spauthid_client_m.GetTableWriteName()+" set";
        l_cSql = l_cSql+" publickey = "+CPLib.ToSQL(w_publickey,"M",10,0,m_cServer_spauthid_client,m_oParameters);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
          l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
        }
        l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
        l_cSql = l_cSql+" where ";
        l_cSql = l_cSql+"usercode="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_usercode,"N",9,0),m_cServer_spauthid_client_m,w_usercode);
        l_cSql = l_cSql+m_oWrInfo_spauthid_client_m.WhereFilter();
        if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
          l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
        }
        l_nUpdatedRows = m_Sql.Update(m_cServer_spauthid_client_m,l_cSql,m_oParameters);
        if (CPLib.ne(l_nUpdatedRows,1)) {
          m_Sql.AbortTransaction();
        }
      }
      NotifyEvent("Update end");
    }
    // Aggiornamento del detail
    l_nRow = 0;
    while (CPLib.lt(l_nRow,m_oDeletedRows.size()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      SetDeletedRow(l_nRow);
      DeleteDetailRow();
      l_nRow = l_nRow+1;
    }
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      l_nRow = 0;
      while (CPLib.lt(l_nRow,Rows()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
        SetRow(l_nRow);
        if (CPLib.eq(m_nRowStatus,1)) {
          UpdateDetailRow();
        } else if (CPLib.eq(m_nRowStatus,2)) {
          InsertDetailRow();
        }
        WorkToTrs();
        l_nRow = l_nRow+1;
      }
    }
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_usercode) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    int l_nRow;
    Load(p_usercode);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                      gestisce le transazioni trova che ce n'� gi� una, utilizza quella, altrimenti
                                      ne inizia una nuova ("begin transaction").
                                    */
        m_Sql.RequireTransaction();
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        // Cancella le righe, per prime per rispettare l'integrita' referenziale tra master e detail
        l_nRow = 0;
        while (CPLib.lt(l_nRow,Rows()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          SetRow(l_nRow);
          DeleteDetailRow();
          l_nRow = l_nRow+1;
        }
        NotifyEvent("Delete start");
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella la testata
          l_cSql = "Delete from "+m_oWrInfo_spauthid_client_m.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"usercode="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_usercode,"N",9,0),m_cServer_spauthid_client_m,w_usercode);
          l_cSql = l_cSql+m_oWrInfo_spauthid_client_m.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_spauthid_client_m,l_cSql);
          if (CPLib.lt(l_nUpdatedRows,1) || CPLib.gt(l_nUpdatedRows,2)) {
            m_Sql.AbortTransaction();
          }
        }
        NotifyEvent("Delete end");
        l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        m_Sql.CompleteTransaction();
      } else {
        m_Sql.AbortTransaction(m_cLastMsgError);
      }
    }
    // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
    // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
    // la parte di transazione corrente
    // * --- Area Manuale = BO - Delete End
    // * --- Fine Area Manuale
    BROnDeleted();
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  void DeleteDetailRow() {
    String l_cSql;
    double l_nUpdatedRows;
    NotifyEvent("Delete row start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      CPLib.DeleteRepeatedMNTs(m_Sql,m_MNTs,this,work_children);
      if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
        l_cSql = "Delete from "+m_oWrInfo_spauthid_client.GetTableWriteName()+" where ";
        l_cSql = l_cSql+"usercode="+CPLib.ToSQL(w_usercode,"N",9,0)+" AND CPROWNUM="+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
        l_cSql = l_cSql+m_oWrInfo_spauthid_client.WhereFilter();
        if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
          l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
        }
        l_nUpdatedRows = m_Sql.Update(m_cServer_spauthid_client,l_cSql);
        if (CPLib.ne(l_nUpdatedRows,1)) {
          m_Sql.AbortTransaction();
        }
      }
    }
    NotifyEvent("Delete row end");
  }
  public boolean Delete() {
    return Delete(w_usercode);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  void InsertDetailRow() {
    String l_cSql;
    double l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    // * --- Area Manuale = BO - Insert Detail Init
    // * --- Fine Area Manuale
    NotifyEvent("Insert row start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_spauthid_client);
      l_cSql = "insert into "+m_oWrInfo_spauthid_client.GetTableWriteName()+" (";
      l_cSql = l_cSql+"usercode,";
      l_cSql = l_cSql+"callbackuri,";
      l_cSql = l_cSql+"CPROWNUM,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(work_extended);
      l_cSql = l_cSql+m_oWrInfo_spauthid_client.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_usercode,"N",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_callbackuri,"C",5096,0,m_cServer_spauthid_client,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPROWNUM,"N",4,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(work_extended);
      l_cSql = l_cSql+m_oWrInfo_spauthid_client.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_spauthid_client,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      } else {
        CPLib.SaveRepeatedMNTs(m_Sql,m_MNTs,this,work_children);
      }
    }
    NotifyEvent("Insert row end");
    // * --- Area Manuale = BO - Insert Detail End
    // * --- Fine Area Manuale
  }
  void UpdateDetailRow() {
    String l_cSql;
    int l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    NotifyEvent("Update row start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_spauthid_client);
      l_cSql = "Update "+m_oWrInfo_spauthid_client.GetTableWriteName()+" set";
      l_cSql = l_cSql+" callbackuri = "+CPLib.ToSQL(w_callbackuri,"C",5096,0,m_cServer_spauthid_client,m_oParameters);
      l_cSql = l_cSql+", CPROWNUM = "+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(work_extended);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"usercode="+CPLib.ToSQL(w_usercode,"N",9,0)+" AND CPROWNUM="+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
      l_cSql = l_cSql+m_oWrInfo_spauthid_client.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"spauthid_client")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_spauthid_client,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      } else {
        CPLib.SaveRepeatedMNTs(m_Sql,m_MNTs,this,work_children);
      }
    }
    NotifyEvent("Update row end");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
