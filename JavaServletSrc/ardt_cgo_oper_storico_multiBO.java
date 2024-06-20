// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class ardt_cgo_oper_storico_multiBO extends ardt_cgo_oper_storico_multiBL {
  class SqlDetailLoader {
    public boolean m_bLink_2_8 = false;
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
    public void AddJoinedLink_2_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_8.CODTPGIO AS CODTPGIO208";
        m_cSelect = m_cSelect+" ,link_2_8.IMPMINGIO AS IMPMINGIO208";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_8","TIPOGIOCO","CODTPGIO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_8","TIPOGIOCO","CODTPGIO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_8 = true;
          m_nColumns = m_nColumns+2;
        }
      }
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
  public ardt_cgo_oper_storico_multiBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"ardt_cgo_oper_storico_multi");
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
  public static String[] m_cLoadParameterNames = {"SNAINUMOPE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_SNAINUMOPE) {
    CPResultSet l_rsLoadBody=null;
    String l_cOrderBy;
    l_cOrderBy = m_cVirtName_cgo_operazioni_storico_multi+".CPRowNum";
    SqlDetailLoader l_oSqlDetailLoader;
    l_oSqlDetailLoader = new SqlDetailLoader(m_Sql,m_cServer_cgo_operazioni_storico_multi,m_cPhName_cgo_operazioni_storico_multi,m_cVirtName_cgo_operazioni_storico_multi,m_cVirtName_cgo_operazioni_storico_multi+".SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_storico_multi,p_SNAINUMOPE),l_cOrderBy);
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    // * --- Area Manuale = BO - Before Load Detail
    // * --- Fine Area Manuale
    l_oSqlDetailLoader.AddJoinedLink_2_8(m_cPhName_cgo_tbtipgio,m_cServer_cgo_tbtipgio);
    l_rsLoadBody = l_oSqlDetailLoader.Query();
    try {
      m_bLoaded =  ! (l_rsLoadBody.Eof());
      if (m_bLoaded) {
        m_bCalculating = true;
        w_CGOTIPOPE = "";
        w_impmin = 0;
        w_SNAINUMOPE = l_rsLoadBody.GetString("SNAINUMOPE");
        w_tipogio = Utilities.Make(m_Ctx).GetCallerString("TIPOGIOCO");
        w_impmin = 0;
        Link_FHBFFVNZIS("Load");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli di testata/piedi a Empty
        SPExtenderLib.LoadExtendedFields(l_rsLoadBody,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
          m_cOldCPCCCHK = l_rsLoadBody.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        // azzera i totali
        w_TOTALE = 0;
        // ora legge il corpo
        while ( ! (l_rsLoadBody.Eof())) {
          m_nCurrentRow = Rows();
          w_DATOPE = l_rsLoadBody.GetDate("DATOPE");
          w_CAIDBIGLIETTO = l_rsLoadBody.GetString("CAIDBIGLIETTO");
          w_TOTLIRE = l_rsLoadBody.GetDouble("TOTLIRE");
          w_FLGFULL = l_rsLoadBody.GetString("FLGFULL");
          w_CPROWNUM = l_rsLoadBody.GetDouble("CPROWNUM");
          w_NUMOPEDL = l_rsLoadBody.GetString("NUMOPEDL");
          w_TIPOGIOCO = l_rsLoadBody.GetString("TIPOGIOCO");
          if (l_oSqlDetailLoader.m_bLink_2_8) {
            w_impmin = l_rsLoadBody.GetDouble("IMPMINGIO208");
          } else {
            Link_ATYKZCFGTM("Load");
          }
          // Assegna il contesto dei figli del dettaglio a Empty
          work_children = CPLib.BlankChildMNTs(m_MNTs,true);
          m_nCPRowNum = l_rsLoadBody.GetInt("CPROWNUM");
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
            m_cOldRowCPCCCHK = l_rsLoadBody.GetString("CPCCCHK");
          } else {
            m_cOldRowCPCCCHK = "nocpcc";
          }
          // aggiunge i valori della riga corrente ai totali
          w_TOTALE = w_TOTALE+w_TOTLIRE;
          // * --- Area Manuale = BO - Load Row End
          // * --- Fine Area Manuale
          // Creazione di una nuova riga nel transitorio e sua popolazione dalle variabili di work
          AppendRow();
          l_rsLoadBody.Next();
        }
        // Valorizza le variabili che dipendono da totalizzazioni
        w_tipogio = Utilities.Make(m_Ctx).GetCallerString("TIPOGIOCO");
        m_bCalculating = false;
        SaveDependsOn();
        m_bHeaderUpdated = false;
        NotifyEvent("Load");
      } else {
        Blank();
      }
      l_rsLoadBody.Close();
    } finally {
      if (l_rsLoadBody!=null)
        l_rsLoadBody.Close();
    }
    // * --- Area Manuale = BO - Load Record End
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_SNAINUMOPE);
  }
  void Insert() {
    String l_cSql;
    int l_nUpdatedRows;
    int l_nRow;
    double l_nCPHSTK = 0;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // Aggiornamento dei progressivi
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
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
    NotifyEvent("Insert end");
    // * --- Area Manuale = BO - Insert End
    // * --- Fine Area Manuale
  }
  void Update() {
    String l_cSql;
    int l_nUpdatedRows;
    int l_nRow;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    // * --- Area Manuale = BO - Replace Init
    // * --- Fine Area Manuale
    NotifyEvent("Update start");
    // Aggiornamento del detail
    l_nRow = 0;
    while (CPLib.lt(l_nRow,m_oDeletedRows.size()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      SetDeletedRow(l_nRow);
      DeleteDetailRow();
      l_nRow = l_nRow+1;
    }
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      if (CPLib.lt(m_nCurrentRow,Rows())) {
        TrsToWork();
      }
      l_nRow = 0;
      while (CPLib.lt(l_nRow,Rows()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
        SetRow(l_nRow);
        if (CPLib.eq(m_nRowStatus,2)) {
          InsertDetailRow();
        } else if (CPLib.eq(m_nRowStatus,1) || m_bHeaderUpdated) {
          UpdateDetailRow();
        }
        WorkToTrs();
        l_nRow = l_nRow+1;
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_SNAINUMOPE) {
    String l_cSql;
    int l_nRow;
    boolean l_bTrsOk = false;
    Load(p_SNAINUMOPE);
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
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // cancella le righe, per prime per rispettare l' integrita' referenziale tra master e detail
          l_nRow = 0;
          while (CPLib.lt(l_nRow,Rows()) && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            SetRow(l_nRow);
            DeleteDetailRow();
            l_nRow = l_nRow+1;
          }
          /*  Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
                                              questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
                                              la parte di transazione corrente
                                            */
          NotifyEvent("Delete end");
          BROnDeleted();
          l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        } else {
          m_Sql.AbortTransaction(m_cLastMsgError);
        }
        m_Sql.CompleteTransaction();
      } else {
        m_Sql.AbortTransaction(m_cLastMsgError);
      }
    }
    // * --- Area Manuale = BO - Delete End
    // * --- Fine Area Manuale
    return m_bLoaded && l_bTrsOk;
  }
  void DeleteDetailRow() {
    String l_cSql;
    double l_nUpdatedRows;
    NotifyEvent("Delete row start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      CPLib.DeleteRepeatedMNTs(m_Sql,m_MNTs,this,work_children);
      if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
        l_cSql = "Delete from "+m_oWrInfo_cgo_operazioni_storico_multi.GetTableWriteName()+" where ";
        l_cSql = l_cSql+"SNAINUMOPE="+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+" AND CPROWNUM="+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
        l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_storico_multi.WhereFilter();
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
          l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
        }
        l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_storico_multi,l_cSql);
        if (CPLib.ne(l_nUpdatedRows,1)) {
          m_Sql.AbortTransaction();
        }
      }
    }
    NotifyEvent("Delete row end");
  }
  public boolean Delete() {
    return Delete(w_SNAINUMOPE);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"FHBFFVNZIS")) {
      result.m_TableName = "cgo_tbtipgio";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODTPGIO" , "IMPMINGIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("FHBFFVNZIS",CPLib.GetLinkedFieldProps("CODTPGIO","tipogio","C",2,0));
    } else if (CPLib.eq(p_cID,"ATYKZCFGTM")) {
      result.m_TableName = "cgo_tbtipgio";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_cgo_tbtipgio";
      result.m_rdField = new String[]{"CODTPGIO" , "IMPMINGIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ATYKZCFGTM",CPLib.GetLinkedFieldProps("CODTPGIO","TIPOGIOCO","C",3,0));
    }
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_operazioni_storico_multi);
      l_cSql = "insert into "+m_oWrInfo_cgo_operazioni_storico_multi.GetTableWriteName()+" (";
      l_cSql = l_cSql+"SNAINUMOPE,";
      l_cSql = l_cSql+"DATOPE,";
      l_cSql = l_cSql+"CAIDBIGLIETTO,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"FLGFULL,";
      l_cSql = l_cSql+"CPROWNUM,";
      l_cSql = l_cSql+"NUMOPEDL,";
      l_cSql = l_cSql+"TIPOGIOCO,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_storico_multi.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGFULL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPROWNUM,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMOPEDL,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOGIOCO,"C",3,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_storico_multi.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_storico_multi,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_operazioni_storico_multi);
      l_cSql = "Update "+m_oWrInfo_cgo_operazioni_storico_multi.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DATOPE = "+CPLib.ToSQL(w_DATOPE,"D",8,0);
      l_cSql = l_cSql+", CAIDBIGLIETTO = "+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",30,0);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",12,2);
      l_cSql = l_cSql+", FLGFULL = "+CPLib.ToSQL(w_FLGFULL,"C",1,0);
      l_cSql = l_cSql+", NUMOPEDL = "+CPLib.ToSQL(w_NUMOPEDL,"C",15,0);
      l_cSql = l_cSql+", TIPOGIOCO = "+CPLib.ToSQLNull(w_TIPOGIOCO,"C",3,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SNAINUMOPE="+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+" AND CPROWNUM="+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_storico_multi.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_storico_multi")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_storico_multi,l_cSql,m_oParameters);
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
