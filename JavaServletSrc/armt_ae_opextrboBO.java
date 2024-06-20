// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_ae_opextrboBO extends armt_ae_opextrboBL {
  class SqlLoader {
    public boolean m_bLink_1_8 = false;
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
    public void AddJoinedLink_1_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_8.CONNES AS CONNES108";
        m_cSelect = m_cSelect+" ,link_1_8.RAGSOC AS RAGSOC108";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_8","CONNESOPER","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_8","CONNESOPER","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_8 = true;
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
  public armt_ae_opextrboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_ae_opextrbo");
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
      l_bResult = CanSaveChild(ardt_delegaop,m_cWv_ardt_delegaop,"m_cWv_ardt_delegaop");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_delegaop.m_cLastMsgError;
      }
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
        if (m_bLoaded) {
          NotifyEvent("Update children start");
        } else {
          NotifyEvent("Insert children start");
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_delegaop.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_delegaop)) {
            ardt_delegaop.SetFromContext(m_cWv_ardt_delegaop);
            m_cWv_ardt_delegaop = "_not_empty_";
          }
          if (ardt_delegaop.IsUpdated()) {
            ardt_delegaop.w_COLLEG = w_COLLEG;
            ardt_delegaop.w_ANNO = w_ANNO;
            if ( ! (ardt_delegaop.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (m_bLoaded) {
          NotifyEvent("Update children end");
        } else {
          NotifyEvent("Insert children end");
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
  public static String[] m_cLoadParameterNames = {"COLLEG","ANNO"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_COLLEG,String p_ANNO) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_opextrbo,m_cPhName_opextrbo,m_cVirtName_opextrbo,m_cVirtName_opextrbo+".COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_COLLEG,"C",16,0),m_cServer_opextrbo,p_COLLEG)+" AND "+m_cVirtName_opextrbo+".ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_ANNO,"C",4,0),m_cServer_opextrbo,p_ANNO),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_8(m_cPhName_personbo,m_cServer_personbo);
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
        w_xRAGSOC = "";
        w_xRAGSOC2 = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        w_xRAGSOC = "";
        Link_RVOXKWUSWH("Load");
        w_ANNO = l_rsLoad.GetString("ANNO");
        w_CONNESOPER = l_rsLoad.GetString("CONNESOPER");
        if (l_oSqlLoader.m_bLink_1_8) {
          w_xRAGSOC2 = l_rsLoad.GetString("RAGSOC108");
        } else {
          Link_PXVUKDVPLL("Load");
        }
        w_SALDO = l_rsLoad.GetDouble("SALDO");
        w_QUANTITA = l_rsLoad.GetDouble("QUANTITA");
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        w_UNIQUER = l_rsLoad.GetString("UNIQUER");
        w_OLDINTER = l_rsLoad.GetString("OLDINTER");
        w_INVIATO = l_rsLoad.GetDouble("INVIATO");
        w_DATAINVIO = l_rsLoad.GetDate("DATAINVIO");
        w_DATAMODI = l_rsLoad.GetDate("DATAMODI");
        w_ANNULLA = l_rsLoad.GetDouble("ANNULLA");
        w_DATAANNU = l_rsLoad.GetDate("DATAANNU");
        w_IDESITO = l_rsLoad.GetString("IDESITO");
        w_INVSALDO = l_rsLoad.GetDouble("INVSALDO");
        w_DTSALDO = l_rsLoad.GetDate("DTSALDO");
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_CFESTERO = l_rsLoad.GetString("CFESTERO");
        w_NATURA = l_rsLoad.GetString("NATURA");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_delegaop = "";
        ardt_delegaop.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"opextrbo")) {
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
    return Load(w_COLLEG,w_ANNO);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_opextrbo);
      l_cSql = "insert into "+m_oWrInfo_opextrbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"ANNO,";
      l_cSql = l_cSql+"CONNESOPER,";
      l_cSql = l_cSql+"SALDO,";
      l_cSql = l_cSql+"QUANTITA,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"UNIQUER,";
      l_cSql = l_cSql+"OLDINTER,";
      l_cSql = l_cSql+"INVIATO,";
      l_cSql = l_cSql+"DATAINVIO,";
      l_cSql = l_cSql+"DATAMODI,";
      l_cSql = l_cSql+"ANNULLA,";
      l_cSql = l_cSql+"DATAANNU,";
      l_cSql = l_cSql+"IDESITO,";
      l_cSql = l_cSql+"INVSALDO,";
      l_cSql = l_cSql+"DTSALDO,";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"CFESTERO,";
      l_cSql = l_cSql+"NATURA,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_opextrbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"opextrbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLLEG,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ANNO,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SALDO,"N",17,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QUANTITA,"N",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_UNIQUER,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OLDINTER,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_INVIATO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAINVIO,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAMODI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ANNULLA,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAANNU,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDESITO,"C",13,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_INVSALDO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DTSALDO,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFESTERO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NATURA,"C",2,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_opextrbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"opextrbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_opextrbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_opextrbo);
      l_cSql = "Update "+m_oWrInfo_opextrbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CONNESOPER = "+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0);
      l_cSql = l_cSql+", SALDO = "+CPLib.ToSQL(w_SALDO,"N",17,0);
      l_cSql = l_cSql+", QUANTITA = "+CPLib.ToSQL(w_QUANTITA,"N",6,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQL(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", UNIQUER = "+CPLib.ToSQL(w_UNIQUER,"C",50,0);
      l_cSql = l_cSql+", OLDINTER = "+CPLib.ToSQL(w_OLDINTER,"C",16,0);
      l_cSql = l_cSql+", INVIATO = "+CPLib.ToSQL(w_INVIATO,"N",1,0);
      l_cSql = l_cSql+", DATAINVIO = "+CPLib.ToSQL(w_DATAINVIO,"D",8,0);
      l_cSql = l_cSql+", DATAMODI = "+CPLib.ToSQL(w_DATAMODI,"D",8,0);
      l_cSql = l_cSql+", ANNULLA = "+CPLib.ToSQL(w_ANNULLA,"N",1,0);
      l_cSql = l_cSql+", DATAANNU = "+CPLib.ToSQL(w_DATAANNU,"D",8,0);
      l_cSql = l_cSql+", IDESITO = "+CPLib.ToSQL(w_IDESITO,"C",13,0);
      l_cSql = l_cSql+", INVSALDO = "+CPLib.ToSQL(w_INVSALDO,"N",1,0);
      l_cSql = l_cSql+", DTSALDO = "+CPLib.ToSQL(w_DTSALDO,"D",8,0);
      l_cSql = l_cSql+", DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", CFESTERO = "+CPLib.ToSQL(w_CFESTERO,"C",1,0);
      l_cSql = l_cSql+", NATURA = "+CPLib.ToSQL(w_NATURA,"C",2,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"opextrbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COLLEG,"C",16,0),m_cServer_opextrbo,w_COLLEG)+" AND "+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ANNO,"C",4,0),m_cServer_opextrbo,w_ANNO);
      l_cSql = l_cSql+m_oWrInfo_opextrbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"opextrbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_opextrbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_COLLEG,String p_ANNO) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_COLLEG,p_ANNO);
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
          // Cancella il figlio LinkPC
          ardt_delegaop.w_COLLEG = w_COLLEG;
          ardt_delegaop.w_ANNO = w_ANNO;
          ardt_delegaop.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_opextrbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_COLLEG,"C",16,0),m_cServer_opextrbo,w_COLLEG)+" AND "+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ANNO,"C",4,0),m_cServer_opextrbo,w_ANNO);
          l_cSql = l_cSql+m_oWrInfo_opextrbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"opextrbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_opextrbo,l_cSql);
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
    return Delete(w_COLLEG,w_ANNO);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"RVOXKWUSWH")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RVOXKWUSWH",CPLib.GetLinkedFieldProps("CONNES","COLLEG","C",16,0));
    } else if (CPLib.eq(p_cID,"PXVUKDVPLL")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("PXVUKDVPLL",CPLib.GetLinkedFieldProps("CONNES","CONNESOPER","C",16,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arrt_allinea_estero,arrt_imp_frischio,arrt_val_benefic,arrt_writelog,
  public static final String i_InvokedRoutines = ",arrt_allinea_estero,arrt_imp_frischio,arrt_val_benefic,arrt_writelog,";
}
