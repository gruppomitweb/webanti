// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_ae_anarapBO extends armt_ae_anarapBL {
  class SqlLoader {
    public boolean m_bLink_1_16 = false;
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
    public void AddJoinedLink_1_16(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_16.CODVAL AS CODVAL116";
        m_cSelect = m_cSelect+" ,link_1_16.DESCRI AS DESCRI116";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_16","VALUTA","CODVAL");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_16","VALUTA","CODVAL",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_16 = true;
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
  public armt_ae_anarapBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_ae_anarap");
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
      l_bResult = CanSaveChild(ardt_ae_delegabo,m_cWv_ardt_ae_delegabo,"m_cWv_ardt_ae_delegabo");
      if (l_bResult) {
        l_bResult = CanSaveChild(ardt_saldioro,m_cWv_ardt_saldioro,"m_cWv_ardt_saldioro");
        if (l_bResult) {
          l_bResult = CanSaveChild(ardt_jarantbo,m_cWv_ardt_jarantbo,"m_cWv_ardt_jarantbo");
          if (l_bResult) {
            l_bResult = CanSaveChild(ardt_ae_saldianno_rap,m_cWv_ardt_ae_saldianno_rap,"m_cWv_ardt_ae_saldianno_rap");
            if (l_bResult) {
              l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
            } else {
              m_cLastMsgError = ardt_ae_saldianno_rap.m_cLastMsgError;
            }
          } else {
            m_cLastMsgError = ardt_jarantbo.m_cLastMsgError;
          }
        } else {
          m_cLastMsgError = ardt_saldioro.m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = ardt_ae_delegabo.m_cLastMsgError;
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
          if ( ! (ardt_ae_delegabo.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_ae_delegabo)) {
            ardt_ae_delegabo.SetFromContext(m_cWv_ardt_ae_delegabo);
            m_cWv_ardt_ae_delegabo = "_not_empty_";
          }
          if (ardt_ae_delegabo.IsUpdated()) {
            ardt_ae_delegabo.w_RAPPORTO = w_RAPPORTO;
            if ( ! (ardt_ae_delegabo.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_saldioro.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_saldioro)) {
            ardt_saldioro.SetFromContext(m_cWv_ardt_saldioro);
            m_cWv_ardt_saldioro = "_not_empty_";
          }
          if (ardt_saldioro.IsUpdated()) {
            ardt_saldioro.w_RAPPORTO = w_RAPPORTO;
            if ( ! (ardt_saldioro.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_jarantbo.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_jarantbo)) {
            ardt_jarantbo.SetFromContext(m_cWv_ardt_jarantbo);
            m_cWv_ardt_jarantbo = "_not_empty_";
          }
          if (ardt_jarantbo.IsUpdated()) {
            ardt_jarantbo.w_RAPPORTO = w_RAPPORTO;
            if ( ! (ardt_jarantbo.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
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
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_jnarapbo,m_cPhName_jnarapbo,m_cVirtName_jnarapbo,m_cVirtName_jnarapbo+".RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_RAPPORTO,"C",25,0),m_cServer_jnarapbo,p_RAPPORTO),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_16(m_cPhName_tbvalute,m_cServer_tbvalute);
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
        w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
        w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_descval = "";
        w_daticoll = 0;
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        w_DESCRAP = l_rsLoad.GetString("DESCRAP");
        w_TIPORAP = l_rsLoad.GetString("TIPORAP");
        w_TIPOAG = l_rsLoad.GetString("TIPOAG");
        w_ISOAGE = l_rsLoad.GetString("ISOAGE");
        w_FLAGLIRE = l_rsLoad.GetString("FLAGLIRE");
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        if (l_oSqlLoader.m_bLink_1_16) {
          w_descval = l_rsLoad.GetString("DESCRI116");
        } else {
          Link_RUMXLFCOKA("Load");
        }
        w_PRGIMPRAP = l_rsLoad.GetDouble("PRGIMPRAP");
        op_PRGIMPRAP = w_PRGIMPRAP;
        w_CODDIP = l_rsLoad.GetString("CODDIP");
        w_titolo = (CPLib.eq(w_gTipInter,"14")?"Relazione d'Affari (AGE)":"Rapporti Continuativi (AGE)")+" - "+CPLib.LRTrim(w_RAPPORTO)+"-"+CPLib.LRTrim(w_DESCRAP);
        w_NOPROT = l_rsLoad.GetDouble("NOPROT");
        w_mess = "Messaggio\\nSecondo\\nTerzo";
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_ae_delegabo = "";
        ardt_ae_delegabo.m_lCtxLoaded = false;
        m_cWv_ardt_saldioro = "";
        ardt_saldioro.m_lCtxLoaded = false;
        m_cWv_ardt_jarantbo = "";
        ardt_jarantbo.m_lCtxLoaded = false;
        m_cWv_ardt_ae_saldianno_rap = "";
        ardt_ae_saldianno_rap.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"jnarapbo")) {
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
    return Load(w_RAPPORTO);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_jnarapbo);
      l_cSql = "insert into "+m_oWrInfo_jnarapbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"DESCRAP,";
      l_cSql = l_cSql+"TIPORAP,";
      l_cSql = l_cSql+"TIPOAG,";
      l_cSql = l_cSql+"ISOAGE,";
      l_cSql = l_cSql+"FLAGLIRE,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"PRGIMPRAP,";
      l_cSql = l_cSql+"CODDIP,";
      l_cSql = l_cSql+"NOPROT,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_jnarapbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jnarapbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCRAP,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPORAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOAG,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ISOAGE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGLIRE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGIMPRAP,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOPROT,"N",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_jnarapbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jnarapbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_jnarapbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_jnarapbo);
      l_cSql = "Update "+m_oWrInfo_jnarapbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DESCRAP = "+CPLib.ToSQL(w_DESCRAP,"C",50,0);
      l_cSql = l_cSql+", TIPORAP = "+CPLib.ToSQL(w_TIPORAP,"C",1,0);
      l_cSql = l_cSql+", TIPOAG = "+CPLib.ToSQL(w_TIPOAG,"C",2,0);
      l_cSql = l_cSql+", ISOAGE = "+CPLib.ToSQL(w_ISOAGE,"C",3,0);
      l_cSql = l_cSql+", FLAGLIRE = "+CPLib.ToSQL(w_FLAGLIRE,"C",1,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQLNull(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", PRGIMPRAP = "+CPLib.ToSQL(w_PRGIMPRAP,"N",15,0);
      l_cSql = l_cSql+", CODDIP = "+CPLib.ToSQL(w_CODDIP,"C",6,0);
      l_cSql = l_cSql+", NOPROT = "+CPLib.ToSQL(w_NOPROT,"N",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jnarapbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_jnarapbo,w_RAPPORTO);
      l_cSql = l_cSql+m_oWrInfo_jnarapbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jnarapbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_jnarapbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_RAPPORTO) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
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
        NotifyEvent("Delete start");
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_ae_delegabo.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_delegabo.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_saldioro.w_RAPPORTO = w_RAPPORTO;
          ardt_saldioro.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_jarantbo.w_RAPPORTO = w_RAPPORTO;
          ardt_jarantbo.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_ae_saldianno_rap.w_RAPPORTO = w_RAPPORTO;
          ardt_ae_saldianno_rap.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_jnarapbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_jnarapbo,w_RAPPORTO);
          l_cSql = l_cSql+m_oWrInfo_jnarapbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"jnarapbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_jnarapbo,l_cSql);
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
    return Delete(w_RAPPORTO);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPRAP","i_codazi,w_PRGIMPRAP",m_cServer_jnarapbo,m_Ctx.GetCompany());
    op_PRGIMPRAP = w_PRGIMPRAP;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"RUMXLFCOKA")) {
      result.m_TableName = "tbvalute";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_divise";
      result.m_rdField = new String[]{"CODVAL" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RUMXLFCOKA",CPLib.GetLinkedFieldProps("CODVAL","VALUTA","C",3,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
