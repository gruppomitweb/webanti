// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armd_anagrappoBO extends armd_anagrappoBL {
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
    public boolean m_bLink_2_1 = false;
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
    public void AddJoinedLink_2_1(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_1.CONNES AS CONNES201";
        m_cSelect = m_cSelect+" ,link_2_1.RAGSOC AS RAGSOC201";
        m_cSelect = m_cSelect+" ,link_2_1.CFESTERO AS CFESTERO201";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_1","CONNESINT","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_1","CONNESINT","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_1 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public CPResultSet Query() {
      String l_cWhere = m_cWhere;
      return m_Sql.Query(m_cServer,CPSql.BuildSQLPhrase(m_cSelect,m_cFrom,l_cWhere,m_cOrderBy));
    }
  }
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public armd_anagrappoBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armd_anagrappo");
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
      l_bResult = CanSaveChild(ardt_ae_saldianno_rap,m_cWv_ardt_ae_saldianno_rap,"m_cWv_ardt_ae_saldianno_rap");
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
      } else {
        m_cLastMsgError = ardt_ae_saldianno_rap.m_cLastMsgError;
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
          if ( ! (ardt_ae_saldianno_rap.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_ae_saldianno_rap)) {
            ardt_ae_saldianno_rap.SetFromContext(m_cWv_ardt_ae_saldianno_rap);
            m_cWv_ardt_ae_saldianno_rap = "_not_empty_";
          }
          if (ardt_ae_saldianno_rap.IsUpdated()) {
            ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
            if ( ! (ardt_ae_saldianno_rap.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"RAPPORTO"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_RAPPORTO) {
    CPResultSet l_rsLoad=null;
    CPResultSet l_rsLoadBody=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_aetesta,m_cPhName_aetesta,m_cVirtName_aetesta,m_cVirtName_aetesta+".RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_RAPPORTO,"C",25,0),m_cServer_aetesta,p_RAPPORTO),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    String l_cOrderBy;
    l_cOrderBy = m_cVirtName_aerighe+".CPRowNum";
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
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        w_TIPOAG = l_rsLoad.GetString("TIPOAG");
        w_COINT = l_rsLoad.GetString("COINT");
        w_RIFANA = l_rsLoad.GetString("RIFANA");
        w_PROGAET = l_rsLoad.GetDouble("PROGAET");
        op_PROGAET = w_PROGAET;
        w_UNIQUECODE = l_rsLoad.GetString("UNIQUECODE");
        w_CAB = l_rsLoad.GetString("CAB");
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        op_PROGAER = w_PROGAER;
        // Assegna il contesto dei figli di testata/piedi a Empty
        m_cWv_ardt_ae_saldianno_rap = "";
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
          m_cOldCPCCCHK = l_rsLoad.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        // azzera i totali
        // ora legge il corpo
        SqlDetailLoader l_oSqlDetailLoader;
        l_oSqlDetailLoader = new SqlDetailLoader(m_Sql,m_cServer_aerighe,m_cPhName_aerighe,m_cVirtName_aerighe,m_cVirtName_aerighe+".RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_RAPPORTO,"C",25,0),m_cServer_aetesta,p_RAPPORTO),l_cOrderBy);
        // * --- Area Manuale = BO - Before Load Detail
        // * --- Fine Area Manuale
        l_oSqlDetailLoader.AddJoinedLink_2_1(m_cPhName_personbo,m_cServer_personbo);
        l_rsLoadBody = l_oSqlDetailLoader.Query();
        try {
          while ( ! (l_rsLoadBody.Eof())) {
            m_nCurrentRow = Rows();
            w_CONNESINT = l_rsLoadBody.GetString("CONNESINT");
            if (l_oSqlDetailLoader.m_bLink_2_1) {
              w_xragsoc = l_rsLoadBody.GetString("RAGSOC201");
              w_CFESTERO = l_rsLoadBody.GetDouble("CFESTERO201");
            } else {
              Link_ZWBKZJLHCV("Load");
            }
            w_ASPEDITO = l_rsLoadBody.GetDouble("ASPEDITO");
            w_ADATA = l_rsLoadBody.GetDate("ADATA");
            w_APROG = l_rsLoadBody.GetString("APROG");
            w_AOLDPROG = l_rsLoadBody.GetString("AOLDPROG");
            w_AFILE = l_rsLoadBody.GetString("AFILE");
            w_AOLDFILE = l_rsLoadBody.GetString("AOLDFILE");
            w_ADATARET = l_rsLoadBody.GetDate("ADATARET");
            w_CSPEDITO = l_rsLoadBody.GetDouble("CSPEDITO");
            w_CDATA = l_rsLoadBody.GetDate("CDATA");
            w_CPROG = l_rsLoadBody.GetString("CPROG");
            w_COLDPROG = l_rsLoadBody.GetString("COLDPROG");
            w_CFILE = l_rsLoadBody.GetString("CFILE");
            w_COLDFILE = l_rsLoadBody.GetString("COLDFILE");
            w_CDATARET = l_rsLoadBody.GetDate("CDATARET");
            w_IDRIF = l_rsLoadBody.GetString("IDRIF");
            w_NOCODFISC = l_rsLoadBody.GetString("NOCODFISC");
            w_IDBASE = l_rsLoadBody.GetString("IDBASE");
            w_ADATA = l_rsLoadBody.GetDate("ADATA");
            w_CDATA = l_rsLoadBody.GetDate("CDATA");
            w_CPROWNUM = l_rsLoadBody.GetDouble("CPROWNUM");
            w_IDESITO = l_rsLoadBody.GetString("IDESITO");
            w_ADATARET = l_rsLoadBody.GetDate("ADATARET");
            w_RSPEDITO = l_rsLoadBody.GetDouble("RSPEDITO");
            w_COLDFILE = l_rsLoadBody.GetString("COLDFILE");
            w_COLDPROG = l_rsLoadBody.GetString("COLDPROG");
            w_IDBASE = l_rsLoadBody.GetString("IDBASE");
            w_filecanc = "";
            w_idcanc = "";
            w_spcanc = 0;
            w_dtcanc = CPLib.NullDate();
            Link_NQPTOOEBKN("Load");
            w_PROGAER = l_rsLoadBody.GetDouble("PROGAER");
            w_DATESITO = l_rsLoadBody.GetDate("DATESITO");
            // Assegna il contesto dei figli del dettaglio a Empty
            work_children = CPLib.BlankChildMNTs(m_MNTs,true);
            work_extended = SPExtenderLib.BlankRepeatedExtendedFields(extendedFields_trs);
            SPExtenderLib.LoadExtendedFields(l_rsLoadBody,work_extended);
            m_nCPRowNum = l_rsLoadBody.GetInt("CPROWNUM");
            if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
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
    return Load(w_RAPPORTO);
  }
  void Insert() {
    double l_nCPHSTK = 0;
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    int l_nRow;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // Aggiornamento dei progressivi
    SaveAutonumber();
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      // salva la testata
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_aerighe);
      l_cSql = "insert into "+m_oWrInfo_aetesta.GetTableWriteName()+" (";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"TIPOAG,";
      l_cSql = l_cSql+"COINT,";
      l_cSql = l_cSql+"RIFANA,";
      l_cSql = l_cSql+"PROGAET,";
      l_cSql = l_cSql+"UNIQUECODE,";
      l_cSql = l_cSql+"CAB,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_aetesta.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOAG,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COINT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RIFANA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGAET,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_UNIQUECODE,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAB,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_aetesta.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_aerighe,l_cSql,m_oParameters);
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
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_aerighe);
        l_cSql = "Update "+m_oWrInfo_aetesta.GetTableWriteName()+" set";
        l_cSql = l_cSql+" TIPOAG = "+CPLib.ToSQL(w_TIPOAG,"C",2,0);
        l_cSql = l_cSql+", COINT = "+CPLib.ToSQL(w_COINT,"C",1,0);
        l_cSql = l_cSql+", RIFANA = "+CPLib.ToSQL(w_RIFANA,"C",1,0);
        l_cSql = l_cSql+", PROGAET = "+CPLib.ToSQL(w_PROGAET,"N",15,0);
        l_cSql = l_cSql+", UNIQUECODE = "+CPLib.ToSQL(w_UNIQUECODE,"C",50,0);
        l_cSql = l_cSql+", CAB = "+CPLib.ToSQL(w_CAB,"C",5,0);
        l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQL(w_VALUTA,"C",3,0);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
          l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
        }
        l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
        l_cSql = l_cSql+" where ";
        l_cSql = l_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_aetesta,w_RAPPORTO);
        l_cSql = l_cSql+m_oWrInfo_aetesta.WhereFilter();
        if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
          l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
        }
        l_nUpdatedRows = m_Sql.Update(m_cServer_aetesta,l_cSql,m_oParameters);
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
  public boolean Delete(String p_RAPPORTO) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    int l_nRow;
    Load(p_RAPPORTO);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                      gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
                                      ne inizia una nuova ("begin transaction").
                                    */
        m_Sql.RequireTransaction();
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_saldianno_rap.Delete();
        }
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
          l_cSql = "Delete from "+m_oWrInfo_aetesta.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_aetesta,w_RAPPORTO);
          l_cSql = l_cSql+m_oWrInfo_aetesta.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_aetesta,l_cSql);
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
        l_cSql = "Delete from "+m_oWrInfo_aerighe.GetTableWriteName()+" where ";
        l_cSql = l_cSql+"RAPPORTO="+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+" AND CPROWNUM="+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
        l_cSql = l_cSql+m_oWrInfo_aerighe.WhereFilter();
        if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
          l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
        }
        l_nUpdatedRows = m_Sql.Update(m_cServer_aerighe,l_cSql);
        if (CPLib.ne(l_nUpdatedRows,1)) {
          m_Sql.AbortTransaction();
        }
      }
    }
    NotifyEvent("Delete row end");
  }
  public boolean Delete() {
    return Delete(w_RAPPORTO);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PROGAET","i_codazi,w_PROGAET",m_cServer_aerighe,m_Ctx.GetCompany());
    op_PROGAET = w_PROGAET;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PROGAER","i_codazi,w_PROGAER",m_cServer_aerighe,m_Ctx.GetCompany());
    op_PROGAER = w_PROGAER;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"ZWBKZJLHCV")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "CFESTERO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZWBKZJLHCV",CPLib.GetLinkedFieldProps("CONNES","CONNESINT","C",16,0));
    } else if (CPLib.eq(p_cID,"NQPTOOEBKN")) {
      result.m_TableName = "aecanc";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "IDFILE" , "IDPROG" , "SPEDITO" , "DATARIF"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "N" , "D"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NQPTOOEBKN",CPLib.GetLinkedFieldProps("IDBASE","IDBASE","C",10,0));
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_aerighe);
      l_cSql = "insert into "+m_oWrInfo_aerighe.GetTableWriteName()+" (";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"CONNESINT,";
      l_cSql = l_cSql+"ASPEDITO,";
      l_cSql = l_cSql+"ADATA,";
      l_cSql = l_cSql+"APROG,";
      l_cSql = l_cSql+"AOLDPROG,";
      l_cSql = l_cSql+"AFILE,";
      l_cSql = l_cSql+"AOLDFILE,";
      l_cSql = l_cSql+"ADATARET,";
      l_cSql = l_cSql+"CSPEDITO,";
      l_cSql = l_cSql+"CDATA,";
      l_cSql = l_cSql+"CPROG,";
      l_cSql = l_cSql+"COLDPROG,";
      l_cSql = l_cSql+"CFILE,";
      l_cSql = l_cSql+"COLDFILE,";
      l_cSql = l_cSql+"CDATARET,";
      l_cSql = l_cSql+"IDRIF,";
      l_cSql = l_cSql+"NOCODFISC,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"CPROWNUM,";
      l_cSql = l_cSql+"IDESITO,";
      l_cSql = l_cSql+"RSPEDITO,";
      l_cSql = l_cSql+"PROGAER,";
      l_cSql = l_cSql+"DATESITO,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(work_extended);
      l_cSql = l_cSql+m_oWrInfo_aerighe.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESINT,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ASPEDITO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ADATA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_APROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AOLDPROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AOLDFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ADATARET,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CSPEDITO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLDPROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLDFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATARET,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDRIF,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOCODFISC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPROWNUM,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDESITO,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RSPEDITO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGAER,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATESITO,"D",8,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(work_extended);
      l_cSql = l_cSql+m_oWrInfo_aerighe.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_aerighe,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_aerighe);
      l_cSql = "Update "+m_oWrInfo_aerighe.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CONNESINT = "+CPLib.ToSQLNull(w_CONNESINT,"C",16,0);
      l_cSql = l_cSql+", ASPEDITO = "+CPLib.ToSQL(w_ASPEDITO,"N",1,0);
      l_cSql = l_cSql+", ADATA = "+CPLib.ToSQL(w_ADATA,"D",8,0);
      l_cSql = l_cSql+", APROG = "+CPLib.ToSQL(w_APROG,"C",25,0);
      l_cSql = l_cSql+", AOLDPROG = "+CPLib.ToSQL(w_AOLDPROG,"C",25,0);
      l_cSql = l_cSql+", AFILE = "+CPLib.ToSQL(w_AFILE,"C",15,0);
      l_cSql = l_cSql+", AOLDFILE = "+CPLib.ToSQL(w_AOLDFILE,"C",15,0);
      l_cSql = l_cSql+", ADATARET = "+CPLib.ToSQL(w_ADATARET,"D",8,0);
      l_cSql = l_cSql+", CSPEDITO = "+CPLib.ToSQL(w_CSPEDITO,"N",1,0);
      l_cSql = l_cSql+", CDATA = "+CPLib.ToSQL(w_CDATA,"D",8,0);
      l_cSql = l_cSql+", CPROG = "+CPLib.ToSQL(w_CPROG,"C",25,0);
      l_cSql = l_cSql+", COLDPROG = "+CPLib.ToSQL(w_COLDPROG,"C",25,0);
      l_cSql = l_cSql+", CFILE = "+CPLib.ToSQL(w_CFILE,"C",15,0);
      l_cSql = l_cSql+", COLDFILE = "+CPLib.ToSQL(w_COLDFILE,"C",15,0);
      l_cSql = l_cSql+", CDATARET = "+CPLib.ToSQL(w_CDATARET,"D",8,0);
      l_cSql = l_cSql+", IDRIF = "+CPLib.ToSQL(w_IDRIF,"C",10,0);
      l_cSql = l_cSql+", NOCODFISC = "+CPLib.ToSQL(w_NOCODFISC,"C",1,0);
      l_cSql = l_cSql+", IDBASE = "+CPLib.ToSQL(w_IDBASE,"C",10,0);
      l_cSql = l_cSql+", CPROWNUM = "+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
      l_cSql = l_cSql+", IDESITO = "+CPLib.ToSQL(w_IDESITO,"C",8,0);
      l_cSql = l_cSql+", RSPEDITO = "+CPLib.ToSQL(w_RSPEDITO,"N",1,0);
      l_cSql = l_cSql+", PROGAER = "+CPLib.ToSQL(w_PROGAER,"N",15,0);
      l_cSql = l_cSql+", DATESITO = "+CPLib.ToSQL(w_DATESITO,"D",8,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(work_extended);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"RAPPORTO="+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+" AND CPROWNUM="+CPLib.ToSQL(w_CPROWNUM,"N",4,0);
      l_cSql = l_cSql+m_oWrInfo_aerighe.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aerighe")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldRowCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_aerighe,l_cSql,m_oParameters);
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
  // ENTITY_BATCHES: ,arfn_ae_chkdel,
  public static final String i_InvokedRoutines = ",arfn_ae_chkdel,";
}
