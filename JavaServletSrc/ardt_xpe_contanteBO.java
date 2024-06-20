// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class ardt_xpe_contanteBO extends ardt_xpe_contanteBL {
  class SqlDetailLoader {
    public boolean m_bLink_1_11 = false;
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
    public void AddJoinedLink_1_11(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_11.CODICE AS CODICE111";
        m_cSelect = m_cSelect+" ,link_1_11.DESCRI AS DESCRI111";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_11","ATECO_CON","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_11","ATECO_CON","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_11 = true;
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
  public ardt_xpe_contanteBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"ardt_xpe_contante");
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
  public static String[] m_cLoadParameterNames = {"IDOPE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDOPE) {
    CPResultSet l_rsLoadBody=null;
    String l_cOrderBy;
    l_cOrderBy = m_cVirtName_xpe_contante+".TAGLIO";
    SqlDetailLoader l_oSqlDetailLoader;
    l_oSqlDetailLoader = new SqlDetailLoader(m_Sql,m_cServer_xpe_contante,m_cPhName_xpe_contante,m_cVirtName_xpe_contante,m_cVirtName_xpe_contante+".IDOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDOPE,"C",10,0),m_cServer_xpe_contante,p_IDOPE),l_cOrderBy);
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    // * --- Area Manuale = BO - Before Load Detail
    // * --- Fine Area Manuale
    l_oSqlDetailLoader.AddJoinedLink_1_11(m_cPhName_tbtipatt,m_cServer_tbtipatt);
    l_rsLoadBody = l_oSqlDetailLoader.Query();
    try {
      m_bLoaded =  ! (l_rsLoadBody.Eof());
      if (m_bLoaded) {
        m_bCalculating = true;
        w_xDESATECO = "";
        w_xDESCITTA = "";
        w_IDOPE = l_rsLoadBody.GetString("IDOPE");
        w_TIPATT = l_rsLoadBody.GetString("TIPATT");
        w_TIPOATTIV = l_rsLoadBody.GetString("TIPOATTIV");
        w_CODICEGLN = l_rsLoadBody.GetString("CODICEGLN");
        w_CODCLICON = l_rsLoadBody.GetString("CODCLICON");
        w_ATECO_CON = l_rsLoadBody.GetString("ATECO_CON");
        if (l_oSqlDetailLoader.m_bLink_1_11) {
          w_xDESATECO = l_rsLoadBody.GetString("DESCRI111");
        } else {
          Link_IACBXHVCCO("Load");
        }
        w_CODCOMCON = l_rsLoadBody.GetString("CODCOMCON");
        w_xDESCITTA = "";
        Link_JCXOTDXIKP("Load");
        w_ABIINTER = l_rsLoadBody.GetString("ABIINTER");
        w_ABIPROPR = l_rsLoadBody.GetString("ABIPROPR");
        w_GLNALTROSOG = l_rsLoadBody.GetString("GLNALTROSOG");
        w_GLNALTRASC = l_rsLoadBody.GetString("GLNALTRASC");
        w_BILLSRIT = l_rsLoadBody.GetDouble("BILLSRIT");
        w_BILLSSOV = l_rsLoadBody.GetDouble("BILLSSOV");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli di testata/piedi a Empty
        SPExtenderLib.LoadExtendedFields(l_rsLoadBody,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
          m_cOldCPCCCHK = l_rsLoadBody.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        // azzera i totali
        // ora legge il corpo
        while ( ! (l_rsLoadBody.Eof())) {
          m_nCurrentRow = Rows();
          w_TAGLIO = l_rsLoadBody.GetDouble("TAGLIO");
          w_NBANCONOTE = l_rsLoadBody.GetDouble("NBANCONOTE");
          // Assegna il contesto dei figli del dettaglio a Empty
          work_children = CPLib.BlankChildMNTs(m_MNTs,true);
          opk_TAGLIO = w_TAGLIO;
          if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
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
        // Valorizza le variabili che dipendono da totalizzazioni
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
    return Load(w_IDOPE);
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
  public boolean Delete(String p_IDOPE) {
    String l_cSql;
    int l_nRow;
    boolean l_bTrsOk = false;
    Load(p_IDOPE);
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
        l_cSql = "Delete from "+m_oWrInfo_xpe_contante.GetTableWriteName()+" where ";
        l_cSql = l_cSql+"IDOPE="+CPLib.ToSQL(w_IDOPE,"C",10,0)+" AND TAGLIO="+CPLib.ToSQL(opk_TAGLIO,"N",7,2);
        l_cSql = l_cSql+m_oWrInfo_xpe_contante.WhereFilter();
        if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
          l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
        }
        l_nUpdatedRows = m_Sql.Update(m_cServer_xpe_contante,l_cSql);
        if (CPLib.ne(l_nUpdatedRows,1)) {
          m_Sql.AbortTransaction();
        }
      }
    }
    NotifyEvent("Delete row end");
  }
  public boolean Delete() {
    return Delete(w_IDOPE);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"IACBXHVCCO")) {
      result.m_TableName = "tbtipatt";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IACBXHVCCO",CPLib.GetLinkedFieldProps("CODICE","ATECO_CON","C",10,0));
    } else if (CPLib.eq(p_cID,"JCXOTDXIKP")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDISTAT" , "CITTA"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JCXOTDXIKP",CPLib.GetLinkedFieldProps("IDISTAT","CODCOMCON","C",6,0));
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_xpe_contante);
      l_cSql = "insert into "+m_oWrInfo_xpe_contante.GetTableWriteName()+" (";
      l_cSql = l_cSql+"IDOPE,";
      l_cSql = l_cSql+"TIPATT,";
      l_cSql = l_cSql+"TIPOATTIV,";
      l_cSql = l_cSql+"CODICEGLN,";
      l_cSql = l_cSql+"CODCLICON,";
      l_cSql = l_cSql+"ATECO_CON,";
      l_cSql = l_cSql+"CODCOMCON,";
      l_cSql = l_cSql+"ABIINTER,";
      l_cSql = l_cSql+"ABIPROPR,";
      l_cSql = l_cSql+"GLNALTROSOG,";
      l_cSql = l_cSql+"GLNALTRASC,";
      l_cSql = l_cSql+"BILLSRIT,";
      l_cSql = l_cSql+"BILLSSOV,";
      l_cSql = l_cSql+"TAGLIO,";
      l_cSql = l_cSql+"NBANCONOTE,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_xpe_contante.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDOPE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPATT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOATTIV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODICEGLN,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCLICON,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ATECO_CON,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODCOMCON,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ABIINTER,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ABIPROPR,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GLNALTROSOG,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GLNALTRASC,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BILLSRIT,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BILLSSOV,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TAGLIO,"N",7,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NBANCONOTE,"N",5,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_xpe_contante.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_xpe_contante,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_xpe_contante);
      l_cSql = "Update "+m_oWrInfo_xpe_contante.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TIPATT = "+CPLib.ToSQL(w_TIPATT,"C",3,0);
      l_cSql = l_cSql+", TIPOATTIV = "+CPLib.ToSQL(w_TIPOATTIV,"C",2,0);
      l_cSql = l_cSql+", CODICEGLN = "+CPLib.ToSQL(w_CODICEGLN,"C",13,0);
      l_cSql = l_cSql+", CODCLICON = "+CPLib.ToSQL(w_CODCLICON,"C",20,0);
      l_cSql = l_cSql+", ATECO_CON = "+CPLib.ToSQLNull(w_ATECO_CON,"C",10,0);
      l_cSql = l_cSql+", CODCOMCON = "+CPLib.ToSQLNull(w_CODCOMCON,"C",6,0);
      l_cSql = l_cSql+", ABIINTER = "+CPLib.ToSQL(w_ABIINTER,"C",5,0);
      l_cSql = l_cSql+", ABIPROPR = "+CPLib.ToSQL(w_ABIPROPR,"C",5,0);
      l_cSql = l_cSql+", GLNALTROSOG = "+CPLib.ToSQL(w_GLNALTROSOG,"C",13,0);
      l_cSql = l_cSql+", GLNALTRASC = "+CPLib.ToSQL(w_GLNALTRASC,"C",13,0);
      l_cSql = l_cSql+", BILLSRIT = "+CPLib.ToSQL(w_BILLSRIT,"N",10,0);
      l_cSql = l_cSql+", BILLSSOV = "+CPLib.ToSQL(w_BILLSSOV,"N",10,0);
      l_cSql = l_cSql+", NBANCONOTE = "+CPLib.ToSQL(w_NBANCONOTE,"N",5,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+", TAGLIO = "+CPLib.ToSQL(w_TAGLIO,"N",7,2);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDOPE="+CPLib.ToSQL(w_IDOPE,"C",10,0)+" AND TAGLIO="+CPLib.ToSQL(opk_TAGLIO,"N",7,2);
      l_cSql = l_cSql+m_oWrInfo_xpe_contante.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xpe_contante")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_xpe_contante,l_cSql,m_oParameters);
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
