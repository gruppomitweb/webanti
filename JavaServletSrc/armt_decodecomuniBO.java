// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_decodecomuniBO extends armt_decodecomuniBL {
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
  public armt_decodecomuniBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_decodecomuni");
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
  public static String[] m_cLoadParameterNames = {"ID"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_ID) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_DecodeCitta,m_cPhName_DecodeCitta,m_cVirtName_DecodeCitta,m_cVirtName_DecodeCitta+".ID="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_ID,"N",10,0),m_cServer_DecodeCitta,p_ID),"");
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
        w_ID = l_rsLoad.GetDouble("ID");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        // Link con tbcitta non eseguito: riporta solo campi
        w_CITTAMIT = l_rsLoad.GetString("CITTAMIT");
        w_CAB = l_rsLoad.GetString("CAB");
        w_PROV = l_rsLoad.GetString("PROV");
        w_CAPMIT = l_rsLoad.GetString("CAPMIT");
        w_PKTBSTATI = l_rsLoad.GetString("PKTBSTATI");
        w_SIGLA = l_rsLoad.GetString("SIGLA");
        w_PREF = l_rsLoad.GetString("PREF");
        w_IDTBLS = l_rsLoad.GetString("IDTBLS");
        w_CITTA = l_rsLoad.GetString("CITTA");
        w_PR = l_rsLoad.GetString("PR");
        w_CATASTALE = l_rsLoad.GetString("CATASTALE");
        w_CAP = l_rsLoad.GetString("CAP");
        w_REGIONE = l_rsLoad.GetString("REGIONE");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"DecodeCitta")) {
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
    return Load(w_ID);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_DecodeCitta);
      l_cSql = "insert into "+m_oWrInfo_DecodeCitta.GetTableWriteName()+" (";
      l_cSql = l_cSql+"ID,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"CITTAMIT,";
      l_cSql = l_cSql+"CAB,";
      l_cSql = l_cSql+"PROV,";
      l_cSql = l_cSql+"CAPMIT,";
      l_cSql = l_cSql+"PKTBSTATI,";
      l_cSql = l_cSql+"SIGLA,";
      l_cSql = l_cSql+"PREF,";
      l_cSql = l_cSql+"IDTBLS,";
      l_cSql = l_cSql+"CITTA,";
      l_cSql = l_cSql+"PR,";
      l_cSql = l_cSql+"CATASTALE,";
      l_cSql = l_cSql+"CAP,";
      l_cSql = l_cSql+"REGIONE,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_DecodeCitta.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"DecodeCitta")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_ID,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CITTAMIT,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAPMIT,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PKTBSTATI,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SIGLA,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PREF,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDTBLS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CITTA,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PR,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATASTALE,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_REGIONE,"C",30,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_DecodeCitta.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"DecodeCitta")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_DecodeCitta,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_DecodeCitta);
      l_cSql = "Update "+m_oWrInfo_DecodeCitta.GetTableWriteName()+" set";
      l_cSql = l_cSql+" IDBASE = "+CPLib.ToSQLNull(w_IDBASE,"C",10,0);
      l_cSql = l_cSql+", CITTAMIT = "+CPLib.ToSQL(w_CITTAMIT,"C",60,0);
      l_cSql = l_cSql+", CAB = "+CPLib.ToSQL(w_CAB,"C",6,0);
      l_cSql = l_cSql+", PROV = "+CPLib.ToSQL(w_PROV,"C",2,0);
      l_cSql = l_cSql+", CAPMIT = "+CPLib.ToSQL(w_CAPMIT,"C",9,0);
      l_cSql = l_cSql+", PKTBSTATI = "+CPLib.ToSQL(w_PKTBSTATI,"C",3,0);
      l_cSql = l_cSql+", SIGLA = "+CPLib.ToSQL(w_SIGLA,"C",4,0);
      l_cSql = l_cSql+", PREF = "+CPLib.ToSQL(w_PREF,"C",4,0);
      l_cSql = l_cSql+", IDTBLS = "+CPLib.ToSQL(w_IDTBLS,"C",1,0);
      l_cSql = l_cSql+", CITTA = "+CPLib.ToSQL(w_CITTA,"C",80,0);
      l_cSql = l_cSql+", PR = "+CPLib.ToSQL(w_PR,"C",2,0);
      l_cSql = l_cSql+", CATASTALE = "+CPLib.ToSQL(w_CATASTALE,"C",4,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",5,0);
      l_cSql = l_cSql+", REGIONE = "+CPLib.ToSQL(w_REGIONE,"C",30,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"DecodeCitta")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"ID="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ID,"N",10,0),m_cServer_DecodeCitta,w_ID);
      l_cSql = l_cSql+m_oWrInfo_DecodeCitta.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"DecodeCitta")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_DecodeCitta,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_ID) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_ID);
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
          l_cSql = "Delete from "+m_oWrInfo_DecodeCitta.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"ID="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_ID,"N",10,0),m_cServer_DecodeCitta,w_ID);
          l_cSql = l_cSql+m_oWrInfo_DecodeCitta.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"DecodeCitta")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_DecodeCitta,l_cSql);
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
    return Delete(w_ID);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"ONHGQHDQFZ")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "CITTA" , "CAB" , "PROV" , "CAP" , "PKTBSTATI" , "SIGLA" , "PREF" , "IDTBLS"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ONHGQHDQFZ",CPLib.GetLinkedFieldProps("IDBASE","IDBASE","C",10,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
