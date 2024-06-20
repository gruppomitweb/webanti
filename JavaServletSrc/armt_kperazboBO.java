// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_kperazboBO extends armt_kperazboBL {
  class SqlLoader {
    public boolean m_bLink_1_18 = false;
    public boolean m_bLink_1_24 = false;
    public boolean m_bLink_1_25 = false;
    public boolean m_bLink_1_26 = false;
    public boolean m_bLink_1_29 = false;
    public boolean m_bLink_1_30 = false;
    public boolean m_bLink_1_37 = false;
    public boolean m_bLink_1_41 = false;
    public boolean m_bLink_1_51 = false;
    public boolean m_bLink_1_55 = false;
    public boolean m_bLink_1_154 = false;
    public boolean m_bLink_2_13 = false;
    public boolean m_bLink_2_15 = false;
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
    public void AddJoinedLink_1_18(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_18.CODVAL AS CODVAL118";
        m_cSelect = m_cSelect+" ,link_1_18.DESCRI AS DESCRI118";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_18","VALUTA","CODVAL");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_18","VALUTA","CODVAL",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_18 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_24(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_24.RAPPORTO AS RAPPORTO124";
        m_cSelect = m_cSelect+" ,link_1_24.DESCRAP AS DESCRAP124";
        m_cSelect = m_cSelect+" ,link_1_24.TIPORAP AS TIPORAP124";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_24","RAPPORTO","RAPPORTO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_24","RAPPORTO","RAPPORTO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_24 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_25(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_25.CONNES AS CONNES125";
        m_cSelect = m_cSelect+" ,link_1_25.RAGSOC AS RAGSOC125";
        m_cSelect = m_cSelect+" ,link_1_25.CODFISC AS CODFISC125";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_25","CONNESCLI","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_25","CONNESCLI","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_25 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_26(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_26.CONNES AS CONNES126";
        m_cSelect = m_cSelect+" ,link_1_26.RAGSOC AS RAGSOC126";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_26","CONNESOPER","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_26","CONNESOPER","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_26 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_29(String rightTable,String rightServer) {
      // questo link aggiunge 8 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+8,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_29.CONNES AS CONNES129";
        m_cSelect = m_cSelect+" ,link_1_29.RAGSOC AS RAGSOC129";
        m_cSelect = m_cSelect+" ,link_1_29.RAGSOC AS RAGSOC129";
        m_cSelect = m_cSelect+" ,link_1_29.DOMICILIO AS DOMICILIO129";
        m_cSelect = m_cSelect+" ,link_1_29.DESCCIT AS DESCCIT129";
        m_cSelect = m_cSelect+" ,link_1_29.PROVINCIA AS PROVINCIA129";
        m_cSelect = m_cSelect+" ,link_1_29.PAESE AS PAESE129";
        m_cSelect = m_cSelect+" ,link_1_29.CAP AS CAP129";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_29","CONNESBEN","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_29","CONNESBEN","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_29 = true;
          m_nColumns = m_nColumns+8;
        }
      }
    }
    public void AddJoinedLink_1_30(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_30.CONNES AS CONNES130";
        m_cSelect = m_cSelect+" ,link_1_30.RAGSOC AS RAGSOC130";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_30","CONNALTRO","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_30","CONNALTRO","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_30 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_37(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_37.CODSTA AS CODSTA137";
        m_cSelect = m_cSelect+" ,link_1_37.DESCRI AS DESCRI137";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_37","C_STA","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_37","C_STA","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_37 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_41(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_41.CODSTA AS CODSTA141";
        m_cSelect = m_cSelect+" ,link_1_41.DESCRI AS DESCRI141";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_41","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_41","PAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_41 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_51(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_51.CODINTER AS CODINTER151";
        m_cSelect = m_cSelect+" ,link_1_51.DATANASC AS DATANASC151";
        m_cSelect = m_cSelect+" ,link_1_51.CODCAB AS CODCAB151";
        m_cSelect = m_cSelect+" ,link_1_51.PROVINCIA AS PROVINCIA151";
        m_cSelect = m_cSelect+" ,link_1_51.DESCCIT AS DESCCIT151";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_51","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_51","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_51 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_55(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_55.CODDIP AS CODDIP155";
        m_cSelect = m_cSelect+" ,link_1_55.DESCRIZ AS DESCRIZ155";
        m_cSelect = m_cSelect+" ,link_1_55.DESCCIT AS DESCCIT155";
        m_cSelect = m_cSelect+" ,link_1_55.PROVINCIA AS PROVINCIA155";
        m_cSelect = m_cSelect+" ,link_1_55.CAB AS CAB155";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_55","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_55","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_55 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_2_13(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_13.CODINTER AS CODINTER213";
        m_cSelect = m_cSelect+" ,link_2_13.DATANASC AS DATANASC213";
        m_cSelect = m_cSelect+" ,link_2_13.CODCAB AS CODCAB213";
        m_cSelect = m_cSelect+" ,link_2_13.PROVINCIA AS PROVINCIA213";
        m_cSelect = m_cSelect+" ,link_2_13.DESCCIT AS DESCCIT213";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_13","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_13","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_13 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_2_15(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_15.CODDIP AS CODDIP215";
        m_cSelect = m_cSelect+" ,link_2_15.DESCRIZ AS DESCRIZ215";
        m_cSelect = m_cSelect+" ,link_2_15.DESCCIT AS DESCCIT215";
        m_cSelect = m_cSelect+" ,link_2_15.PROVINCIA AS PROVINCIA215";
        m_cSelect = m_cSelect+" ,link_2_15.CAB AS CAB215";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_15","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_15","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_15 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_154(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_154.CODVOC AS CODVOC254";
        m_cSelect = m_cSelect+" ,link_1_154.DESCRIZ AS DESCRIZ254";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_154","CODVOC","CODVOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_154","CODVOC","CODVOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_154 = true;
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
  public armt_kperazboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_kperazbo");
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
      l_bResult = CanSaveChild(ardt_clientisara,m_cWv_ardt_clientisara,"m_cWv_ardt_clientisara");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_clientisara.m_cLastMsgError;
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
          if ( ! (ardt_clientisara.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_clientisara)) {
            ardt_clientisara.SetFromContext(m_cWv_ardt_clientisara);
            m_cWv_ardt_clientisara = "_not_empty_";
          }
          if (ardt_clientisara.IsUpdated()) {
            ardt_clientisara.w_IDFILEBO = w_IDBASE;
            if ( ! (ardt_clientisara.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"IDBASE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDBASE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_kperazbo,m_cPhName_kperazbo,m_cVirtName_kperazbo,m_cVirtName_kperazbo+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_kperazbo,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_18(m_cPhName_tbvalute,m_cServer_tbvalute);
    l_oSqlLoader.AddJoinedLink_1_24(m_cPhName_knarapbo,m_cServer_knarapbo);
    l_oSqlLoader.AddJoinedLink_1_25(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_26(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_29(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_30(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_37(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_41(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_51(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_1_55(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_2_13(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_2_15(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_154(m_cPhName_tbcausin,m_cServer_tbcausin);
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
        w_xTOTLIRE = 0;
        w_xTOTCONT = 0;
        w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
        w_xdes1 = "";
        w_desccauana = "";
        w_xdesccausin = "";
        w_descdiv = "";
        w_xragsocper = "";
        w_xdescrap = "";
        w_xragsocct = "";
        w_xragsocben = "";
        w_xdestipleg = "";
        w_xragint2 = "";
        w_xdescpaese2 = "";
        w_datpaseuro = CPLib.NullDate();
        w_xDescDipe = "";
        w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
        w_errmsg = "";
        w_test = "";
        w_valflg2 = "";
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
        w_xcodfisc = "";
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gStatus = m_Ctx.GetGlobalString("gStatus");
        w_CITINT = "";
        w_CITDIP = "";
        w_PROVDIP = "";
        w_CABDIP = "";
        w_PROVINT = "";
        w_CABINT = "";
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_xtiporap = "";
        w_dessta = "";
        w_xragsocalt = "";
        w_xdciticon = "";
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_xdescmodsvo = "";
        w_xdescareag = "";
        w_xdescplauso = "";
        w_xdesctipor = "";
        w_xdescopeage = "";
        w_xdescfreq = "";
        w_xdescammo = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_filtro = "O";
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_CDATOPE = l_rsLoad.GetString("CDATOPE");
        w_DATAREG = l_rsLoad.GetDate("DATAREG");
        w_FLAGCONT = l_rsLoad.GetString("FLAGCONT");
        w_tipope = "1";
        w_TIPOOPRAP = l_rsLoad.GetString("TIPOOPRAP");
        w_xdes1 = "";
        Link_UJRFWINIVQ("Load");
        w_CODANA = l_rsLoad.GetString("CODANA");
        // Link con tbcauana non eseguito: riporta solo campi
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        w_SEGNO = "";
        w_desccauana = "";
        Link_SRWWPHPCUB("Load");
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_FLAGLIRE = l_rsLoad.GetString("FLAGLIRE");
        w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        if (l_oSqlLoader.m_bLink_1_18) {
          w_descdiv = l_rsLoad.GetString("DESCRI118");
        } else {
          Link_MKCXJZEKIG("Load");
        }
        w_CAMBIO = l_rsLoad.GetDouble("CAMBIO");
        w_TOTLIRE = l_rsLoad.GetDouble("TOTLIRE");
        w_TOTCONT = l_rsLoad.GetDouble("TOTCONT");
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        if (l_oSqlLoader.m_bLink_1_24) {
          w_xdescrap = l_rsLoad.GetString("DESCRAP124");
          w_FLAGRAP = l_rsLoad.GetString("TIPORAP124");
        } else {
          Link_RZIQZFKPUE("Load");
        }
        w_CONNESCLI = l_rsLoad.GetString("CONNESCLI");
        if (l_oSqlLoader.m_bLink_1_25) {
          w_xragsocper = l_rsLoad.GetString("RAGSOC125");
          w_xcodfisc = l_rsLoad.GetString("CODFISC125");
        } else {
          Link_QBLXDBODXR("Load");
        }
        w_CONNESOPER = l_rsLoad.GetString("CONNESOPER");
        if (l_oSqlLoader.m_bLink_1_26) {
          w_xragsocct = l_rsLoad.GetString("RAGSOC126");
        } else {
          Link_TCOTJNZLGM("Load");
        }
        w_TIPOLEG = l_rsLoad.GetString("TIPOLEG");
        w_PAGASOGOP = l_rsLoad.GetString("PAGASOGOP");
        w_CONNESBEN = l_rsLoad.GetString("CONNESBEN");
        if (l_oSqlLoader.m_bLink_1_29) {
          w_xragsocben = l_rsLoad.GetString("RAGSOC129");
          w_C_RAG = l_rsLoad.GetString("RAGSOC129");
          w_C_IND = l_rsLoad.GetString("DOMICILIO129");
          w_C_CTA = l_rsLoad.GetString("DESCCIT129");
          w_C_PRV = l_rsLoad.GetString("PROVINCIA129");
          w_C_STA = l_rsLoad.GetString("PAESE129");
          w_C_CAP = l_rsLoad.GetString("CAP129");
        } else {
          Link_ULVCBLFVEU("Load");
        }
        w_CONNALTRO = l_rsLoad.GetString("CONNALTRO");
        if (l_oSqlLoader.m_bLink_1_30) {
          w_xragsocben = l_rsLoad.GetString("RAGSOC130");
        } else {
          Link_HWFHDWYMIU("Load");
        }
        w_C_RAG = l_rsLoad.GetString("C_RAG");
        w_C_CTA = l_rsLoad.GetString("C_CTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_C_PRV = l_rsLoad.GetString("C_PRV");
        w_C_CAP = l_rsLoad.GetString("C_CAP");
        w_C_CAB = l_rsLoad.GetString("C_CAB");
        w_C_IND = l_rsLoad.GetString("C_IND");
        w_C_STA = l_rsLoad.GetString("C_STA");
        if (l_oSqlLoader.m_bLink_1_37) {
          w_dessta = l_rsLoad.GetString("DESCRI137");
        } else {
          Link_YVIKEGPYPM("Load");
        }
        w_TIPOINT2 = l_rsLoad.GetString("TIPOINT2");
        w_CODINT2 = l_rsLoad.GetString("CODINT2");
        // Link con inter2bo non eseguito: riporta solo campi
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_PAESE = l_rsLoad.GetString("PAESE");
        if (l_oSqlLoader.m_bLink_1_41) {
          w_xdescpaese2 = l_rsLoad.GetString("DESCRI141");
        } else {
          Link_NYRJHOZOON("Load");
        }
        w_C_RAPPORTO = l_rsLoad.GetString("C_RAPPORTO");
        w_CODCAB2 = l_rsLoad.GetString("CODCAB2");
        w_xdciticon = "";
        w_PROV2 = "";
        Link_YQINIDXZSL("Load");
        w_PROV2 = l_rsLoad.GetString("PROV2");
        w_DESC2 = l_rsLoad.GetString("DESC2");
        w_ZCPARTE = l_rsLoad.GetString("ZCPARTE");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        op_IDBASE = w_IDBASE;
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        op_NUMPROG = w_NUMPROG;
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        if (l_oSqlLoader.m_bLink_1_51) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC151");
          w_CABINT = l_rsLoad.GetString("CODCAB151");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA151");
          w_CITINT = l_rsLoad.GetString("DESCCIT151");
        } else {
          Link_WJSVGWKSFC("Load");
        }
        w_TIPOINF = l_rsLoad.GetString("TIPOINF");
        w_IDEREG = l_rsLoad.GetString("IDEREG");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_55) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ155");
          w_CITDIP = l_rsLoad.GetString("DESCCIT155");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA155");
          w_CABDIP = l_rsLoad.GetString("CAB155");
        } else {
          Link_AVHTGZTOSZ("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_FLAGRAP = l_rsLoad.GetString("FLAGRAP");
        w_OPRAP = l_rsLoad.GetString("OPRAP");
        w_SEGNO = l_rsLoad.GetString("SEGNO");
        w_OPERAZMOD = l_rsLoad.GetString("OPERAZMOD");
        w_RAPPORTBEN = l_rsLoad.GetString("RAPPORTBEN");
        w_OPERATORE = l_rsLoad.GetString("OPERATORE");
        w_AUTOM = l_rsLoad.GetString("AUTOM");
        w_sEdit = 0;
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_DATARETT = l_rsLoad.GetDate("DATARETT");
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        // Link con kperazbo non eseguito: riporta solo campi
        w_FLAGRAP2 = l_rsLoad.GetString("FLAGRAP2");
        w_STATOREG = l_rsLoad.GetString("STATOREG");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_PRGIMPOPE = l_rsLoad.GetDouble("PRGIMPOPE");
        op_PRGIMPOPE = w_PRGIMPOPE;
        w_dataoggi = CPLib.Date();
        w_stringaflagrap2 = "ABCDEFGHI";
        w_CDATAOPE = l_rsLoad.GetString("CDATAOPE");
        w_CONNESDOC = l_rsLoad.GetString("CONNESDOC");
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        if (l_oSqlLoader.m_bLink_1_154) {
          w_xdesccausin = l_rsLoad.GetString("DESCRIZ254");
        } else {
          Link_KHRUYMSPDK("Load");
        }
        w_MTCN = l_rsLoad.GetString("MTCN");
        w_prova = CPLib.DateDiff(w_DATAOPE,w_DATAREG);
        w_CDATREG = l_rsLoad.GetString("CDATREG");
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        if (l_oSqlLoader.m_bLink_2_13) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC213");
          w_CABINT = l_rsLoad.GetString("CODCAB213");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA213");
          w_CITINT = l_rsLoad.GetString("DESCCIT213");
        } else {
          Link_AKAVLTKFQJ("Load");
        }
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_2_15) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ215");
          w_CITDIP = l_rsLoad.GetString("DESCCIT215");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA215");
          w_CABDIP = l_rsLoad.GetString("CAB215");
        } else {
          Link_VFSCXTRPBT("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_clientisara = "";
        ardt_clientisara.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"kperazbo")) {
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
    return Load(w_IDBASE);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_kperazbo);
      l_cSql = "insert into "+m_oWrInfo_kperazbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"CDATOPE,";
      l_cSql = l_cSql+"DATAREG,";
      l_cSql = l_cSql+"FLAGCONT,";
      l_cSql = l_cSql+"TIPOOPRAP,";
      l_cSql = l_cSql+"CODANA,";
      l_cSql = l_cSql+"CODVOC,";
      l_cSql = l_cSql+"FLAGFRAZ,";
      l_cSql = l_cSql+"FLAGLIRE,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"CAMBIO,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"TOTCONT,";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"CONNESCLI,";
      l_cSql = l_cSql+"CONNESOPER,";
      l_cSql = l_cSql+"TIPOLEG,";
      l_cSql = l_cSql+"PAGASOGOP,";
      l_cSql = l_cSql+"CONNESBEN,";
      l_cSql = l_cSql+"CONNALTRO,";
      l_cSql = l_cSql+"C_RAG,";
      l_cSql = l_cSql+"C_CTA,";
      l_cSql = l_cSql+"C_PRV,";
      l_cSql = l_cSql+"C_CAP,";
      l_cSql = l_cSql+"C_CAB,";
      l_cSql = l_cSql+"C_IND,";
      l_cSql = l_cSql+"C_STA,";
      l_cSql = l_cSql+"TIPOINT2,";
      l_cSql = l_cSql+"CODINT2,";
      l_cSql = l_cSql+"DESCINTER,";
      l_cSql = l_cSql+"PAESE,";
      l_cSql = l_cSql+"C_RAPPORTO,";
      l_cSql = l_cSql+"CODCAB2,";
      l_cSql = l_cSql+"PROV2,";
      l_cSql = l_cSql+"DESC2,";
      l_cSql = l_cSql+"ZCPARTE,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"TIPOINF,";
      l_cSql = l_cSql+"IDEREG,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"FLAGRAP,";
      l_cSql = l_cSql+"OPRAP,";
      l_cSql = l_cSql+"SEGNO,";
      l_cSql = l_cSql+"OPERAZMOD,";
      l_cSql = l_cSql+"RAPPORTBEN,";
      l_cSql = l_cSql+"OPERATORE,";
      l_cSql = l_cSql+"AUTOM,";
      l_cSql = l_cSql+"DATARETT,";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"FLAGRAP2,";
      l_cSql = l_cSql+"STATOREG,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"PRGIMPOPE,";
      l_cSql = l_cSql+"CDATAOPE,";
      l_cSql = l_cSql+"CONNESDOC,";
      l_cSql = l_cSql+"MTCN,";
      l_cSql = l_cSql+"CDATREG,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_kperazbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kperazbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGCONT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODANA,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODVOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGLIRE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAMBIO,"N",9,4)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTCONT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOLEG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PAGASOGOP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESBEN,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNALTRO,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_RAG,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CTA,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_PRV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CAP,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_IND,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C_STA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINT2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODINT2,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCINTER,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB2,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROV2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESC2,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ZCPARTE,"C",69,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDEREG,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERAZMOD,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTBEN,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERATORE,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTOM,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_COLLEG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_STATOREG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGIMPOPE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATAOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESDOC,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MTCN,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATREG,"C",8,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_kperazbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kperazbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_kperazbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_kperazbo);
      l_cSql = "Update "+m_oWrInfo_kperazbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", CDATOPE = "+CPLib.ToSQL(w_CDATOPE,"C",8,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"D",8,0);
      l_cSql = l_cSql+", FLAGCONT = "+CPLib.ToSQL(w_FLAGCONT,"C",1,0);
      l_cSql = l_cSql+", TIPOOPRAP = "+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0);
      l_cSql = l_cSql+", CODANA = "+CPLib.ToSQLNull(w_CODANA,"C",4,0);
      l_cSql = l_cSql+", CODVOC = "+CPLib.ToSQLNull(w_CODVOC,"C",2,0);
      l_cSql = l_cSql+", FLAGFRAZ = "+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0);
      l_cSql = l_cSql+", FLAGLIRE = "+CPLib.ToSQL(w_FLAGLIRE,"C",1,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQLNull(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", CAMBIO = "+CPLib.ToSQL(w_CAMBIO,"N",9,4);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",15,0);
      l_cSql = l_cSql+", TOTCONT = "+CPLib.ToSQL(w_TOTCONT,"N",15,0);
      l_cSql = l_cSql+", RAPPORTO = "+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", CONNESCLI = "+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0);
      l_cSql = l_cSql+", CONNESOPER = "+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0);
      l_cSql = l_cSql+", TIPOLEG = "+CPLib.ToSQL(w_TIPOLEG,"C",1,0);
      l_cSql = l_cSql+", PAGASOGOP = "+CPLib.ToSQL(w_PAGASOGOP,"C",1,0);
      l_cSql = l_cSql+", CONNESBEN = "+CPLib.ToSQLNull(w_CONNESBEN,"C",16,0);
      l_cSql = l_cSql+", CONNALTRO = "+CPLib.ToSQLNull(w_CONNALTRO,"C",16,0);
      l_cSql = l_cSql+", C_RAG = "+CPLib.ToSQL(w_C_RAG,"C",70,0);
      l_cSql = l_cSql+", C_CTA = "+CPLib.ToSQL(w_C_CTA,"C",30,0);
      l_cSql = l_cSql+", C_PRV = "+CPLib.ToSQL(w_C_PRV,"C",2,0);
      l_cSql = l_cSql+", C_CAP = "+CPLib.ToSQL(w_C_CAP,"C",5,0);
      l_cSql = l_cSql+", C_CAB = "+CPLib.ToSQL(w_C_CAB,"C",6,0);
      l_cSql = l_cSql+", C_IND = "+CPLib.ToSQL(w_C_IND,"C",35,0);
      l_cSql = l_cSql+", C_STA = "+CPLib.ToSQLNull(w_C_STA,"C",3,0);
      l_cSql = l_cSql+", TIPOINT2 = "+CPLib.ToSQL(w_TIPOINT2,"C",2,0);
      l_cSql = l_cSql+", CODINT2 = "+CPLib.ToSQLNull(w_CODINT2,"C",11,0);
      l_cSql = l_cSql+", DESCINTER = "+CPLib.ToSQL(w_DESCINTER,"C",50,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQLNull(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", C_RAPPORTO = "+CPLib.ToSQL(w_C_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", CODCAB2 = "+CPLib.ToSQL(w_CODCAB2,"C",6,0);
      l_cSql = l_cSql+", PROV2 = "+CPLib.ToSQL(w_PROV2,"C",2,0);
      l_cSql = l_cSql+", DESC2 = "+CPLib.ToSQL(w_DESC2,"C",30,0);
      l_cSql = l_cSql+", ZCPARTE = "+CPLib.ToSQL(w_ZCPARTE,"C",69,0);
      l_cSql = l_cSql+", NUMPROG = "+CPLib.ToSQL(w_NUMPROG,"C",11,0);
      l_cSql = l_cSql+", CODINTER = "+CPLib.ToSQLNull(w_CODINTER,"C",11,0);
      l_cSql = l_cSql+", TIPOINF = "+CPLib.ToSQL(w_TIPOINF,"C",1,0);
      l_cSql = l_cSql+", IDEREG = "+CPLib.ToSQL(w_IDEREG,"C",20,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", FLAGRAP = "+CPLib.ToSQL(w_FLAGRAP,"C",1,0);
      l_cSql = l_cSql+", OPRAP = "+CPLib.ToSQL(w_OPRAP,"C",1,0);
      l_cSql = l_cSql+", SEGNO = "+CPLib.ToSQL(w_SEGNO,"C",1,0);
      l_cSql = l_cSql+", OPERAZMOD = "+CPLib.ToSQL(w_OPERAZMOD,"C",20,0);
      l_cSql = l_cSql+", RAPPORTBEN = "+CPLib.ToSQL(w_RAPPORTBEN,"C",25,0);
      l_cSql = l_cSql+", OPERATORE = "+CPLib.ToSQL(w_OPERATORE,"C",70,0);
      l_cSql = l_cSql+", AUTOM = "+CPLib.ToSQL(w_AUTOM,"C",5,0);
      l_cSql = l_cSql+", DATARETT = "+CPLib.ToSQL(w_DATARETT,"D",8,0);
      l_cSql = l_cSql+", COLLEG = "+CPLib.ToSQLNull(w_COLLEG,"C",11,0);
      l_cSql = l_cSql+", FLAGRAP2 = "+CPLib.ToSQL(w_FLAGRAP2,"C",1,0);
      l_cSql = l_cSql+", STATOREG = "+CPLib.ToSQL(w_STATOREG,"C",1,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", PRGIMPOPE = "+CPLib.ToSQL(w_PRGIMPOPE,"N",15,0);
      l_cSql = l_cSql+", CDATAOPE = "+CPLib.ToSQL(w_CDATAOPE,"C",8,0);
      l_cSql = l_cSql+", CONNESDOC = "+CPLib.ToSQL(w_CONNESDOC,"C",40,0);
      l_cSql = l_cSql+", MTCN = "+CPLib.ToSQL(w_MTCN,"C",10,0);
      l_cSql = l_cSql+", CDATREG = "+CPLib.ToSQL(w_CDATREG,"C",8,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kperazbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_kperazbo,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_kperazbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kperazbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_kperazbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_IDBASE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_IDBASE);
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
          ardt_clientisara.w_IDFILEBO = w_IDBASE;
          ardt_clientisara.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_kperazbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_kperazbo,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_kperazbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"kperazbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_kperazbo,l_cSql);
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
    return Delete(w_IDBASE);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a IDBASE
    w_IDBASE = CPLib.Left(w_IDBASE,10)+CPLib.Space(10-CPLib.Len(w_IDBASE));
    m_Sql.NextTableProg(this,"PPOPER1","i_codazi,w_IDBASE",m_cServer_kperazbo,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave IDBASE, altrimenti non si riesce a linkare da zoom
    w_IDBASE = CPLib.RTrim(w_IDBASE);
    op_IDBASE = w_IDBASE;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a NUMPROG
    w_NUMPROG = CPLib.Left(w_NUMPROG,11)+CPLib.Space(11-CPLib.Len(w_NUMPROG));
    m_Sql.NextTableProg(this,"PPOPER2","i_codazi,w_NUMPROG",m_cServer_kperazbo,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave NUMPROG, altrimenti non si riesce a linkare da zoom
    w_NUMPROG = CPLib.RTrim(w_NUMPROG);
    op_NUMPROG = w_NUMPROG;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPOPE","i_codazi,w_PRGIMPOPE",m_cServer_kperazbo,m_Ctx.GetCompany());
    op_PRGIMPOPE = w_PRGIMPOPE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"UJRFWINIVQ")) {
      result.m_TableName = "tbtipreg";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DES1"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{"OPERAZIO"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("UJRFWINIVQ",CPLib.GetLinkedFieldProps("CODICE","TIPOOPRAP","C",2,0),CPLib.GetLinkedFieldProps("OPERAZIO","tipope","C",1,0));
    } else if (CPLib.eq(p_cID,"SQVJLYRFKQ")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODCAU"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SQVJLYRFKQ",CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"SRWWPHPCUB")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAUSINT" , "SEGNO" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{"CODCAU"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("SRWWPHPCUB",CPLib.GetLinkedFieldProps("CAUSINT","CODVOC","C",2,0),CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"MKCXJZEKIG")) {
      result.m_TableName = "tbvalute";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODVAL" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MKCXJZEKIG",CPLib.GetLinkedFieldProps("CODVAL","VALUTA","C",3,0));
    } else if (CPLib.eq(p_cID,"RZIQZFKPUE")) {
      result.m_TableName = "knarapbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAPPORTO" , "DESCRAP" , "TIPORAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RZIQZFKPUE",CPLib.GetLinkedFieldProps("RAPPORTO","RAPPORTO","C",25,0));
    } else if (CPLib.eq(p_cID,"QBLXDBODXR")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "CODFISC"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QBLXDBODXR",CPLib.GetLinkedFieldProps("CONNES","CONNESCLI","C",16,0));
    } else if (CPLib.eq(p_cID,"TCOTJNZLGM")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TCOTJNZLGM",CPLib.GetLinkedFieldProps("CONNES","CONNESOPER","C",16,0));
    } else if (CPLib.eq(p_cID,"ULVCBLFVEU")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "RAGSOC" , "DOMICILIO" , "DESCCIT" , "PROVINCIA" , "PAESE" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ULVCBLFVEU",CPLib.GetLinkedFieldProps("CONNES","CONNESBEN","C",16,0));
    } else if (CPLib.eq(p_cID,"HWFHDWYMIU")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HWFHDWYMIU",CPLib.GetLinkedFieldProps("CONNES","CONNALTRO","C",16,0));
    } else if (CPLib.eq(p_cID,"ODAYKSRECA")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAB" , "PROV" , "PKTBSTATI" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","C_CTA","C",30,0));
    } else if (CPLib.eq(p_cID,"YVIKEGPYPM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YVIKEGPYPM",CPLib.GetLinkedFieldProps("CODSTA","C_STA","C",3,0));
    } else if (CPLib.eq(p_cID,"CDJFSCCGNX")) {
      result.m_TableName = "inter2bo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER" , "RAGSOC" , "CODCAB" , "PROVINCIA" , "PAESE" , "TIPINTER"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CDJFSCCGNX",CPLib.GetLinkedFieldProps("CODINTER","CODINT2","C",11,0));
    } else if (CPLib.eq(p_cID,"NYRJHOZOON")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NYRJHOZOON",CPLib.GetLinkedFieldProps("CODSTA","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"YQINIDXZSL")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB" , "CITTA" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YQINIDXZSL",CPLib.GetLinkedFieldProps("CAB","CODCAB2","C",6,0));
    } else if (CPLib.eq(p_cID,"WJSVGWKSFC")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_intermbo";
      result.m_rdField = new String[]{"CODINTER" , "DATANASC" , "CODCAB" , "PROVINCIA" , "DESCCIT"};
      result.m_rdTypes = new String[]{"C" , "D" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("WJSVGWKSFC",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0));
    } else if (CPLib.eq(p_cID,"AVHTGZTOSZ")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ" , "DESCCIT" , "PROVINCIA" , "CAB"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AVHTGZTOSZ",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    } else if (CPLib.eq(p_cID,"MSGBKOOAOY")) {
      result.m_TableName = "kperazbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_operazioni";
      result.m_rdField = new String[]{"NUMPROG"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MSGBKOOAOY",CPLib.GetLinkedFieldProps("NUMPROG","COLLEG","C",11,0));
    } else if (CPLib.eq(p_cID,"KHRUYMSPDK")) {
      result.m_TableName = "tbcausin";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODVOC" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KHRUYMSPDK",CPLib.GetLinkedFieldProps("CODVOC","CODVOC","C",2,0));
    } else if (CPLib.eq(p_cID,"AKAVLTKFQJ")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_intermbo";
      result.m_rdField = new String[]{"CODINTER" , "DATANASC" , "CODCAB" , "PROVINCIA" , "DESCCIT"};
      result.m_rdTypes = new String[]{"C" , "D" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AKAVLTKFQJ",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0));
    } else if (CPLib.eq(p_cID,"VFSCXTRPBT")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ" , "DESCCIT" , "PROVINCIA" , "CAB"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VFSCXTRPBT",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_calcflaglire,arfn_chktotalelire,arfn_chktotalelire_cont,arrt_imp_frischio,arrt_li_kperazbo,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_calcflaglire,arfn_chktotalelire,arfn_chktotalelire_cont,arrt_imp_frischio,arrt_li_kperazbo,arrt_writelog,";
}
