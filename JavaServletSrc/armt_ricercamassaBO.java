// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_ricercamassaBO extends armt_ricercamassaBL {
  class SqlLoader {
    public boolean m_bLink_2_6 = false;
    public boolean m_bLink_2_12 = false;
    public boolean m_bLink_2_47 = false;
    public boolean m_bLink_2_51 = false;
    public boolean m_bLink_3_3 = false;
    public boolean m_bLink_4_8 = false;
    public boolean m_bLink_4_12 = false;
    public boolean m_bLink_4_15 = false;
    public boolean m_bLink_4_21 = false;
    public boolean m_bLink_4_25 = false;
    public boolean m_bLink_5_29 = false;
    public boolean m_bLink_5_33 = false;
    public boolean m_bLink_5_41 = false;
    public boolean m_bLink_6_28 = false;
    public boolean m_bLink_8_29 = false;
    public boolean m_bLink_9_29 = false;
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
    public void AddJoinedLink_8_29(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_8_29.TIPDOC AS TIPDOC829";
        m_cSelect = m_cSelect+" ,link_8_29.DESCRI AS DESCRI829";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_8_29","G41","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_8_29","G41","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_8_29 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_28(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_28.TIPDOC AS TIPDOC628";
        m_cSelect = m_cSelect+" ,link_6_28.DESCRI AS DESCRI628";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_28","E41","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_28","E41","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_28 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_5_29(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_5_29.SOTGRU AS SOTGRU529";
        m_cSelect = m_cSelect+" ,link_5_29.DESCRI AS DESCRI529";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_5_29","D21","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_5_29","D21","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_5_29 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_5_33(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_5_33.RAMGRU AS RAMGRU533";
        m_cSelect = m_cSelect+" ,link_5_33.DESCRI AS DESCRI533";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_5_33","D22","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_5_33","D22","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_5_33 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_5_41(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_5_41.TIPDOC AS TIPDOC541";
        m_cSelect = m_cSelect+" ,link_5_41.DESCRI AS DESCRI541";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_5_41","D41","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_5_41","D41","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_5_41 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_8.CONNES AS CONNES408";
        m_cSelect = m_cSelect+" ,link_4_8.RAGSOC AS RAGSOC408";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_8","C11","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_8","C11","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_8 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_12(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_12.CONNES AS CONNES412";
        m_cSelect = m_cSelect+" ,link_4_12.RAGSOC AS RAGSOC412";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_12","C21","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_12","C21","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_12 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_15(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_15.CONNES AS CONNES415";
        m_cSelect = m_cSelect+" ,link_4_15.RAGSOC AS RAGSOC415";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_15","C31","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_15","C31","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_15 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_3_3(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_3_3.CODVAL AS CODVAL303";
        m_cSelect = m_cSelect+" ,link_3_3.DESCRI AS DESCRI303";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_3_3","B12","CODVAL");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_3_3","B12","CODVAL",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_3_3 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_6(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_6.CODINTER AS CODINTER206";
        m_cSelect = m_cSelect+" ,link_2_6.RAGSOC AS RAGSOC206";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_6","A01B","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_6","A01B","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_6 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_12(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_12.CODDIP AS CODDIP212";
        m_cSelect = m_cSelect+" ,link_2_12.DESCRIZ AS DESCRIZ212";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_12","A11","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_12","A11","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_12 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_47(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_47.RAPPORTO AS RAPPORTO247";
        m_cSelect = m_cSelect+" ,link_2_47.DESCRAP AS DESCRAP247";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_47","A41","RAPPORTO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_47","A41","RAPPORTO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_47 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_51(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_51.TIPLEG AS TIPLEG251";
        m_cSelect = m_cSelect+" ,link_2_51.DESCRIZ AS DESCRIZ251";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_51","A43","TIPLEG");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_51","A43","TIPLEG",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_51 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_21(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_21.CONNES AS CONNES421";
        m_cSelect = m_cSelect+" ,link_4_21.RAGSOC AS RAGSOC421";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_21","C41","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_21","C41","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_21 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_25(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_25.CONNES AS CONNES425";
        m_cSelect = m_cSelect+" ,link_4_25.RAGSOC AS RAGSOC425";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_25","C51","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_25","C51","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_25 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_9_29(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_9_29.TIPDOC AS TIPDOC929";
        m_cSelect = m_cSelect+" ,link_9_29.DESCRI AS DESCRI929";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_9_29","H41","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_9_29","H41","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_9_29 = true;
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
  public armt_ricercamassaBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_ricercamassa");
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
    l_bResult = CPLib.le(w_attsel,15);
    if (l_bResult) {
    } else {
      m_cLastMsgError = "Sono selezionabili al massimo 15 attributi";
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
  public static String[] m_cLoadParameterNames = {"IDBASE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDBASE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_tmp_ricmas1,m_cPhName_tmp_ricmas1,m_cVirtName_tmp_ricmas1,m_cVirtName_tmp_ricmas1+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_tmp_ricmas1,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_8_29(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
    l_oSqlLoader.AddJoinedLink_6_28(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
    l_oSqlLoader.AddJoinedLink_5_29(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_5_33(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_5_41(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
    l_oSqlLoader.AddJoinedLink_4_8(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_4_12(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_4_15(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_3_3(m_cPhName_tbvalute,m_cServer_tbvalute);
    l_oSqlLoader.AddJoinedLink_2_6(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_2_12(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_2_47(m_cPhName_anarapbo,m_cServer_anarapbo);
    l_oSqlLoader.AddJoinedLink_2_51(m_cPhName_tbtipleg,m_cServer_tbtipleg);
    l_oSqlLoader.AddJoinedLink_4_21(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_4_25(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_9_29(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
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
        w_xraginter = "";
        w_xdesdip = "";
        w_xdescittab = "";
        w_xtipleg = "";
        w_xdesrap = "";
        w_oldval = "";
        w_richieste = 0;
        w_xdesval = "";
        w_richieste = 0;
        w_xragintes = "";
        w_xragsogope = "";
        w_xragbenef = "";
        w_xragsecond = "";
        w_xragterzo = "";
        w_richieste = 0;
        w_xdessoteco = "";
        w_xdesramgrp = "";
        w_xdessetsin = "";
        w_xdestipdoc = "";
        w_richieste = 0;
        w_xdestipdocsg = "";
        w_richieste = 0;
        w_richieste = 0;
        w_xdestipdoct = "";
        w_richieste = 0;
        w_xdestipdoct1 = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_archivio = l_rsLoad.GetString("archivio");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_richieste = arfn_calcrichiesteR.Make(m_Ctx,this).Run();
        w_A01A = l_rsLoad.GetString("A01A");
        w_A01B = l_rsLoad.GetString("A01B");
        if (l_oSqlLoader.m_bLink_2_6) {
          w_xraginter = l_rsLoad.GetString("RAGSOC206");
        } else {
          Link_TIPXBDXITE("Load");
        }
        w_A03 = l_rsLoad.GetString("A03");
        w_A11 = l_rsLoad.GetString("A11");
        if (l_oSqlLoader.m_bLink_2_12) {
          w_xdesdip = l_rsLoad.GetString("DESCRIZ212");
        } else {
          Link_BQNMQAOIPA("Load");
        }
        w_A12A = l_rsLoad.GetString("A12A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_A12B = l_rsLoad.GetString("A12B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_A12C = l_rsLoad.GetString("A12C");
        w_A21 = l_rsLoad.GetDate("A21");
        w_A22 = l_rsLoad.GetDouble("A22");
        w_A23 = l_rsLoad.GetString("A23");
        w_A24 = l_rsLoad.GetString("A24");
        // Link con tbcauana non eseguito: riporta solo campi
        w_A25 = l_rsLoad.GetString("A25");
        // Link con tbcausin non eseguito: riporta solo campi
        w_A31A = l_rsLoad.GetString("A31A");
        w_A31B = l_rsLoad.GetString("A31B");
        // Link con inter2bo non eseguito: riporta solo campi
        w_A32 = l_rsLoad.GetString("A32");
        // Link con tbstati non eseguito: riporta solo campi
        w_A33A = l_rsLoad.GetString("A33A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_A33B = l_rsLoad.GetString("A33B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_A33C = l_rsLoad.GetString("A33C");
        w_A34 = l_rsLoad.GetString("A34");
        w_A41 = l_rsLoad.GetString("A41");
        if (l_oSqlLoader.m_bLink_2_47) {
          w_xdesrap = l_rsLoad.GetString("DESCRAP247");
        } else {
          Link_HDIAJDVNVI("Load");
        }
        w_A42 = l_rsLoad.GetString("A42");
        // Link con tbtipnat non eseguito: riporta solo campi
        w_A43 = l_rsLoad.GetString("A43");
        if (l_oSqlLoader.m_bLink_2_51) {
          w_xtipleg = l_rsLoad.GetString("DESCRIZ251");
        } else {
          Link_CHJJABTJCS("Load");
        }
        w_A51 = l_rsLoad.GetDate("A51");
        w_A52B = l_rsLoad.GetString("A52B");
        // Link con tbtipreg non eseguito: riporta solo campi
        w_A53 = l_rsLoad.GetString("A53");
        w_A54A = l_rsLoad.GetString("A54A");
        w_A54B = l_rsLoad.GetDate("A54B");
        w_A54C = l_rsLoad.GetString("A54C");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_richieste = arfn_calcrichiesteR.Make(m_Ctx,this).Run();
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        op_IDBASE = w_IDBASE;
        w_B11 = l_rsLoad.GetString("B11");
        w_B12 = l_rsLoad.GetString("B12");
        if (l_oSqlLoader.m_bLink_3_3) {
          w_xdesval = l_rsLoad.GetString("DESCRI303");
        } else {
          Link_CDFYKKBMYS("Load");
        }
        w_B13 = l_rsLoad.GetString("B13");
        w_B14 = l_rsLoad.GetDouble("B14");
        w_B15 = l_rsLoad.GetDouble("B15");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_X_B14_OP = l_rsLoad.GetString("X_B14_OP");
        w_X_B15_OP = l_rsLoad.GetString("X_B15_OP");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_C11 = l_rsLoad.GetString("C11");
        if (l_oSqlLoader.m_bLink_4_8) {
          w_xragintes = l_rsLoad.GetString("RAGSOC408");
        } else {
          Link_BZRDFHBMPM("Load");
        }
        w_C21 = l_rsLoad.GetString("C21");
        if (l_oSqlLoader.m_bLink_4_12) {
          w_xragsogope = l_rsLoad.GetString("RAGSOC412");
        } else {
          Link_UYRQHSBRRT("Load");
        }
        w_C31 = l_rsLoad.GetString("C31");
        if (l_oSqlLoader.m_bLink_4_15) {
          w_xragbenef = l_rsLoad.GetString("RAGSOC415");
        } else {
          Link_PMFBITPOAZ("Load");
        }
        w_C41 = l_rsLoad.GetString("C41");
        if (l_oSqlLoader.m_bLink_4_21) {
          w_xragsecond = l_rsLoad.GetString("RAGSOC421");
        } else {
          Link_LZSKLOQPNQ("Load");
        }
        w_C51 = l_rsLoad.GetString("C51");
        if (l_oSqlLoader.m_bLink_4_25) {
          w_xragterzo = l_rsLoad.GetString("RAGSOC425");
        } else {
          Link_RHMPOMWSNG("Load");
        }
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_D11 = l_rsLoad.GetString("D11");
        // Link con personbo non eseguito: riporta solo campi
        w_D13 = l_rsLoad.GetString("D13");
        // Link con tbstati non eseguito: riporta solo campi
        w_D14A = l_rsLoad.GetString("D14A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_D14B = l_rsLoad.GetString("D14B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_D14C = l_rsLoad.GetString("D14C");
        w_D15 = l_rsLoad.GetString("D15");
        w_D16 = l_rsLoad.GetString("D16");
        w_D17 = l_rsLoad.GetString("D17");
        w_D18 = l_rsLoad.GetDate("D18");
        w_D19A = l_rsLoad.GetString("D19A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_D19B = l_rsLoad.GetString("D19B");
        // Link con tbstati non eseguito: riporta solo campi
        w_D21 = l_rsLoad.GetString("D21");
        if (l_oSqlLoader.m_bLink_5_29) {
          w_xdessoteco = l_rsLoad.GetString("DESCRI529");
        } else {
          Link_DXFRERNUEZ("Load");
        }
        w_D22 = l_rsLoad.GetString("D22");
        if (l_oSqlLoader.m_bLink_5_33) {
          w_xdesramgrp = l_rsLoad.GetString("DESCRI533");
        } else {
          Link_QZTKKLVNJB("Load");
        }
        w_D23 = l_rsLoad.GetString("D23");
        w_xdessetsin = "";
        Link_RIPVAPFZCO("Load");
        w_D41 = l_rsLoad.GetString("D41");
        if (l_oSqlLoader.m_bLink_5_41) {
          w_xdestipdoc = l_rsLoad.GetString("DESCRI541");
        } else {
          Link_QDVHTXVAEJ("Load");
        }
        w_D42 = l_rsLoad.GetString("D42");
        w_D43 = l_rsLoad.GetDate("D43");
        w_D44 = l_rsLoad.GetString("D44");
        w_D45 = l_rsLoad.GetString("D45");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_E11 = l_rsLoad.GetString("E11");
        // Link con personbo non eseguito: riporta solo campi
        w_E13 = l_rsLoad.GetString("E13");
        // Link con tbstati non eseguito: riporta solo campi
        w_E14A = l_rsLoad.GetString("E14A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_E14B = l_rsLoad.GetString("E14B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_E14C = l_rsLoad.GetString("E14C");
        w_E15 = l_rsLoad.GetString("E15");
        w_E16 = l_rsLoad.GetString("E16");
        w_E17 = l_rsLoad.GetString("E17");
        w_E18 = l_rsLoad.GetDate("E18");
        w_E19A = l_rsLoad.GetString("E19A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_E19B = l_rsLoad.GetString("E19B");
        // Link con tbstati non eseguito: riporta solo campi
        w_E41 = l_rsLoad.GetString("E41");
        if (l_oSqlLoader.m_bLink_6_28) {
          w_xdestipdocsg = l_rsLoad.GetString("DESCRI628");
        } else {
          Link_SZZONHIXUX("Load");
        }
        w_E42 = l_rsLoad.GetString("E42");
        w_E43 = l_rsLoad.GetDate("E43");
        w_E44 = l_rsLoad.GetString("E44");
        w_E45 = l_rsLoad.GetString("E45");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_F11 = l_rsLoad.GetString("F11");
        // Link con personbo non eseguito: riporta solo campi
        w_F13 = l_rsLoad.GetString("F13");
        // Link con tbstati non eseguito: riporta solo campi
        w_F14A = l_rsLoad.GetString("F14A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_F14B = l_rsLoad.GetString("F14B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_F14C = l_rsLoad.GetString("F14C");
        w_F15 = l_rsLoad.GetString("F15");
        w_F16 = l_rsLoad.GetString("F16");
        w_F17 = l_rsLoad.GetString("F17");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_G11 = l_rsLoad.GetString("G11");
        // Link con personbo non eseguito: riporta solo campi
        w_G13 = l_rsLoad.GetString("G13");
        // Link con tbstati non eseguito: riporta solo campi
        w_G14A = l_rsLoad.GetString("G14A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_G14B = l_rsLoad.GetString("G14B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_G14C = l_rsLoad.GetString("G14C");
        w_G15 = l_rsLoad.GetString("G15");
        w_G16 = l_rsLoad.GetString("G16");
        w_G17 = l_rsLoad.GetString("G17");
        w_G18 = l_rsLoad.GetDate("G18");
        w_G19A = l_rsLoad.GetString("G19A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_G19B = l_rsLoad.GetString("G19B");
        // Link con tbstati non eseguito: riporta solo campi
        w_G41 = l_rsLoad.GetString("G41");
        if (l_oSqlLoader.m_bLink_8_29) {
          w_xdestipdoct = l_rsLoad.GetString("DESCRI829");
        } else {
          Link_BCOSCDETUR("Load");
        }
        w_G42 = l_rsLoad.GetString("G42");
        w_G43 = l_rsLoad.GetDate("G43");
        w_G44 = l_rsLoad.GetString("G44");
        w_G45 = l_rsLoad.GetString("G45");
        w_attsel = l_rsLoad.GetDouble("attsel");
        w_H11 = l_rsLoad.GetString("H11");
        // Link con personbo non eseguito: riporta solo campi
        w_H13 = l_rsLoad.GetString("H13");
        // Link con tbstati non eseguito: riporta solo campi
        w_H14A = l_rsLoad.GetString("H14A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_H14B = l_rsLoad.GetString("H14B");
        // Link con tbcitta non eseguito: riporta solo campi
        w_H14C = l_rsLoad.GetString("H14C");
        w_H15 = l_rsLoad.GetString("H15");
        w_H16 = l_rsLoad.GetString("H16");
        w_H17 = l_rsLoad.GetString("H17");
        w_H18 = l_rsLoad.GetDate("H18");
        w_H19A = l_rsLoad.GetString("H19A");
        // Link con tbcitta non eseguito: riporta solo campi
        w_H19B = l_rsLoad.GetString("H19B");
        // Link con tbstati non eseguito: riporta solo campi
        w_H41 = l_rsLoad.GetString("H41");
        if (l_oSqlLoader.m_bLink_9_29) {
          w_xdestipdoct1 = l_rsLoad.GetString("DESCRI929");
        } else {
          Link_OAWXXEHPRA("Load");
        }
        w_H42 = l_rsLoad.GetString("H42");
        w_H43 = l_rsLoad.GetDate("H43");
        w_H44 = l_rsLoad.GetString("H44");
        w_H45 = l_rsLoad.GetString("H45");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"tmp_ricmas1")) {
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_tmp_ricmas1);
      l_cSql = "insert into "+m_oWrInfo_tmp_ricmas1.GetTableWriteName()+" (";
      l_cSql = l_cSql+"archivio,";
      l_cSql = l_cSql+"attsel,";
      l_cSql = l_cSql+"A01A,";
      l_cSql = l_cSql+"A01B,";
      l_cSql = l_cSql+"A03,";
      l_cSql = l_cSql+"A11,";
      l_cSql = l_cSql+"A12A,";
      l_cSql = l_cSql+"A12B,";
      l_cSql = l_cSql+"A12C,";
      l_cSql = l_cSql+"A21,";
      l_cSql = l_cSql+"A22,";
      l_cSql = l_cSql+"A23,";
      l_cSql = l_cSql+"A24,";
      l_cSql = l_cSql+"A25,";
      l_cSql = l_cSql+"A31A,";
      l_cSql = l_cSql+"A31B,";
      l_cSql = l_cSql+"A32,";
      l_cSql = l_cSql+"A33A,";
      l_cSql = l_cSql+"A33B,";
      l_cSql = l_cSql+"A33C,";
      l_cSql = l_cSql+"A34,";
      l_cSql = l_cSql+"A41,";
      l_cSql = l_cSql+"A42,";
      l_cSql = l_cSql+"A43,";
      l_cSql = l_cSql+"A51,";
      l_cSql = l_cSql+"A52B,";
      l_cSql = l_cSql+"A53,";
      l_cSql = l_cSql+"A54A,";
      l_cSql = l_cSql+"A54B,";
      l_cSql = l_cSql+"A54C,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"B11,";
      l_cSql = l_cSql+"B12,";
      l_cSql = l_cSql+"B13,";
      l_cSql = l_cSql+"B14,";
      l_cSql = l_cSql+"B15,";
      l_cSql = l_cSql+"X_B14_OP,";
      l_cSql = l_cSql+"X_B15_OP,";
      l_cSql = l_cSql+"C11,";
      l_cSql = l_cSql+"C21,";
      l_cSql = l_cSql+"C31,";
      l_cSql = l_cSql+"C41,";
      l_cSql = l_cSql+"C51,";
      l_cSql = l_cSql+"D11,";
      l_cSql = l_cSql+"D13,";
      l_cSql = l_cSql+"D14A,";
      l_cSql = l_cSql+"D14B,";
      l_cSql = l_cSql+"D14C,";
      l_cSql = l_cSql+"D15,";
      l_cSql = l_cSql+"D16,";
      l_cSql = l_cSql+"D17,";
      l_cSql = l_cSql+"D18,";
      l_cSql = l_cSql+"D19A,";
      l_cSql = l_cSql+"D19B,";
      l_cSql = l_cSql+"D21,";
      l_cSql = l_cSql+"D22,";
      l_cSql = l_cSql+"D23,";
      l_cSql = l_cSql+"D41,";
      l_cSql = l_cSql+"D42,";
      l_cSql = l_cSql+"D43,";
      l_cSql = l_cSql+"D44,";
      l_cSql = l_cSql+"D45,";
      l_cSql = l_cSql+"E11,";
      l_cSql = l_cSql+"E13,";
      l_cSql = l_cSql+"E14A,";
      l_cSql = l_cSql+"E14B,";
      l_cSql = l_cSql+"E14C,";
      l_cSql = l_cSql+"E15,";
      l_cSql = l_cSql+"E16,";
      l_cSql = l_cSql+"E17,";
      l_cSql = l_cSql+"E18,";
      l_cSql = l_cSql+"E19A,";
      l_cSql = l_cSql+"E19B,";
      l_cSql = l_cSql+"E41,";
      l_cSql = l_cSql+"E42,";
      l_cSql = l_cSql+"E43,";
      l_cSql = l_cSql+"E44,";
      l_cSql = l_cSql+"E45,";
      l_cSql = l_cSql+"F11,";
      l_cSql = l_cSql+"F13,";
      l_cSql = l_cSql+"F14A,";
      l_cSql = l_cSql+"F14B,";
      l_cSql = l_cSql+"F14C,";
      l_cSql = l_cSql+"F15,";
      l_cSql = l_cSql+"F16,";
      l_cSql = l_cSql+"F17,";
      l_cSql = l_cSql+"G11,";
      l_cSql = l_cSql+"G13,";
      l_cSql = l_cSql+"G14A,";
      l_cSql = l_cSql+"G14B,";
      l_cSql = l_cSql+"G14C,";
      l_cSql = l_cSql+"G15,";
      l_cSql = l_cSql+"G16,";
      l_cSql = l_cSql+"G17,";
      l_cSql = l_cSql+"G18,";
      l_cSql = l_cSql+"G19A,";
      l_cSql = l_cSql+"G19B,";
      l_cSql = l_cSql+"G41,";
      l_cSql = l_cSql+"G42,";
      l_cSql = l_cSql+"G43,";
      l_cSql = l_cSql+"G44,";
      l_cSql = l_cSql+"G45,";
      l_cSql = l_cSql+"H11,";
      l_cSql = l_cSql+"H13,";
      l_cSql = l_cSql+"H14A,";
      l_cSql = l_cSql+"H14B,";
      l_cSql = l_cSql+"H14C,";
      l_cSql = l_cSql+"H15,";
      l_cSql = l_cSql+"H16,";
      l_cSql = l_cSql+"H17,";
      l_cSql = l_cSql+"H18,";
      l_cSql = l_cSql+"H19A,";
      l_cSql = l_cSql+"H19B,";
      l_cSql = l_cSql+"H41,";
      l_cSql = l_cSql+"H42,";
      l_cSql = l_cSql+"H43,";
      l_cSql = l_cSql+"H44,";
      l_cSql = l_cSql+"H45,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_tmp_ricmas1.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tmp_ricmas1")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_archivio,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_attsel,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A01A,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A01B,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A03,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A11,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A12A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A12B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A12C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A21,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A22,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A23,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A24,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A25,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A31A,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A31B,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A32,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A33A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A33B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A33C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A34,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A41,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A42,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A43,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A51,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_A52B,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A53,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A54A,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A54B,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_A54C,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_B11,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_B12,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_B13,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_B14,"N",19,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_B15,"N",19,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_X_B14_OP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_X_B15_OP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C11,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C21,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C31,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C41,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C51,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D11,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D13,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D14A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D14B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D14C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D15,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D16,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D17,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D18,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D19A,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D19B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D21,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D22,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D23,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_D41,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D42,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D43,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D44,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_D45,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E11,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E13,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E14A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E14B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E14C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E15,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E16,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E17,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E18,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E19A,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E19B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_E41,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E42,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E43,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E44,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_E45,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_F11,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_F13,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_F14A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_F14B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_F14C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_F15,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_F16,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_F17,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G11,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G13,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G14A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G14B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G14C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G15,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G16,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G17,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G18,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G19A,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G19B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_G41,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G42,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G43,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G44,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_G45,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H11,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H13,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H14A,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H14B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H14C,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H15,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H16,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H17,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H18,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H19A,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H19B,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_H41,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H42,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H43,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H44,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_H45,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_tmp_ricmas1.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tmp_ricmas1")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_ricmas1,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_tmp_ricmas1);
      l_cSql = "Update "+m_oWrInfo_tmp_ricmas1.GetTableWriteName()+" set";
      l_cSql = l_cSql+" archivio = "+CPLib.ToSQL(w_archivio,"C",1,0);
      l_cSql = l_cSql+", attsel = "+CPLib.ToSQL(w_attsel,"N",10,0);
      l_cSql = l_cSql+", A01A = "+CPLib.ToSQL(w_A01A,"C",2,0);
      l_cSql = l_cSql+", A01B = "+CPLib.ToSQLNull(w_A01B,"C",11,0);
      l_cSql = l_cSql+", A03 = "+CPLib.ToSQL(w_A03,"C",20,0);
      l_cSql = l_cSql+", A11 = "+CPLib.ToSQLNull(w_A11,"C",6,0);
      l_cSql = l_cSql+", A12A = "+CPLib.ToSQLNull(w_A12A,"C",6,0);
      l_cSql = l_cSql+", A12B = "+CPLib.ToSQLNull(w_A12B,"C",30,0);
      l_cSql = l_cSql+", A12C = "+CPLib.ToSQL(w_A12C,"C",2,0);
      l_cSql = l_cSql+", A21 = "+CPLib.ToSQL(w_A21,"D",8,0);
      l_cSql = l_cSql+", A22 = "+CPLib.ToSQL(w_A22,"N",1,0);
      l_cSql = l_cSql+", A23 = "+CPLib.ToSQL(w_A23,"C",1,0);
      l_cSql = l_cSql+", A24 = "+CPLib.ToSQLNull(w_A24,"C",4,0);
      l_cSql = l_cSql+", A25 = "+CPLib.ToSQLNull(w_A25,"C",2,0);
      l_cSql = l_cSql+", A31A = "+CPLib.ToSQL(w_A31A,"C",2,0);
      l_cSql = l_cSql+", A31B = "+CPLib.ToSQLNull(w_A31B,"C",10,0);
      l_cSql = l_cSql+", A32 = "+CPLib.ToSQLNull(w_A32,"C",3,0);
      l_cSql = l_cSql+", A33A = "+CPLib.ToSQLNull(w_A33A,"C",6,0);
      l_cSql = l_cSql+", A33B = "+CPLib.ToSQLNull(w_A33B,"C",30,0);
      l_cSql = l_cSql+", A33C = "+CPLib.ToSQL(w_A33C,"C",2,0);
      l_cSql = l_cSql+", A34 = "+CPLib.ToSQL(w_A34,"C",50,0);
      l_cSql = l_cSql+", A41 = "+CPLib.ToSQLNull(w_A41,"C",25,0);
      l_cSql = l_cSql+", A42 = "+CPLib.ToSQLNull(w_A42,"C",1,0);
      l_cSql = l_cSql+", A43 = "+CPLib.ToSQLNull(w_A43,"C",1,0);
      l_cSql = l_cSql+", A51 = "+CPLib.ToSQL(w_A51,"D",8,0);
      l_cSql = l_cSql+", A52B = "+CPLib.ToSQLNull(w_A52B,"C",2,0);
      l_cSql = l_cSql+", A53 = "+CPLib.ToSQL(w_A53,"C",12,0);
      l_cSql = l_cSql+", A54A = "+CPLib.ToSQL(w_A54A,"C",1,0);
      l_cSql = l_cSql+", A54B = "+CPLib.ToSQL(w_A54B,"D",8,0);
      l_cSql = l_cSql+", A54C = "+CPLib.ToSQL(w_A54C,"C",20,0);
      l_cSql = l_cSql+", B11 = "+CPLib.ToSQL(w_B11,"C",1,0);
      l_cSql = l_cSql+", B12 = "+CPLib.ToSQLNull(w_B12,"C",3,0);
      l_cSql = l_cSql+", B13 = "+CPLib.ToSQL(w_B13,"C",1,0);
      l_cSql = l_cSql+", B14 = "+CPLib.ToSQL(w_B14,"N",19,0);
      l_cSql = l_cSql+", B15 = "+CPLib.ToSQL(w_B15,"N",19,0);
      l_cSql = l_cSql+", X_B14_OP = "+CPLib.ToSQL(w_X_B14_OP,"C",2,0);
      l_cSql = l_cSql+", X_B15_OP = "+CPLib.ToSQL(w_X_B15_OP,"C",2,0);
      l_cSql = l_cSql+", C11 = "+CPLib.ToSQLNull(w_C11,"C",16,0);
      l_cSql = l_cSql+", C21 = "+CPLib.ToSQLNull(w_C21,"C",16,0);
      l_cSql = l_cSql+", C31 = "+CPLib.ToSQLNull(w_C31,"C",16,0);
      l_cSql = l_cSql+", C41 = "+CPLib.ToSQLNull(w_C41,"C",16,0);
      l_cSql = l_cSql+", C51 = "+CPLib.ToSQLNull(w_C51,"C",16,0);
      l_cSql = l_cSql+", D11 = "+CPLib.ToSQLNull(w_D11,"C",70,0);
      l_cSql = l_cSql+", D13 = "+CPLib.ToSQLNull(w_D13,"C",3,0);
      l_cSql = l_cSql+", D14A = "+CPLib.ToSQLNull(w_D14A,"C",6,0);
      l_cSql = l_cSql+", D14B = "+CPLib.ToSQLNull(w_D14B,"C",30,0);
      l_cSql = l_cSql+", D14C = "+CPLib.ToSQL(w_D14C,"C",2,0);
      l_cSql = l_cSql+", D15 = "+CPLib.ToSQL(w_D15,"C",35,0);
      l_cSql = l_cSql+", D16 = "+CPLib.ToSQL(w_D16,"C",5,0);
      l_cSql = l_cSql+", D17 = "+CPLib.ToSQL(w_D17,"C",16,0);
      l_cSql = l_cSql+", D18 = "+CPLib.ToSQL(w_D18,"D",8,0);
      l_cSql = l_cSql+", D19A = "+CPLib.ToSQLNull(w_D19A,"C",30,0);
      l_cSql = l_cSql+", D19B = "+CPLib.ToSQLNull(w_D19B,"C",30,0);
      l_cSql = l_cSql+", D21 = "+CPLib.ToSQLNull(w_D21,"C",3,0);
      l_cSql = l_cSql+", D22 = "+CPLib.ToSQLNull(w_D22,"C",3,0);
      l_cSql = l_cSql+", D23 = "+CPLib.ToSQLNull(w_D23,"C",3,0);
      l_cSql = l_cSql+", D41 = "+CPLib.ToSQLNull(w_D41,"C",2,0);
      l_cSql = l_cSql+", D42 = "+CPLib.ToSQL(w_D42,"C",15,0);
      l_cSql = l_cSql+", D43 = "+CPLib.ToSQL(w_D43,"D",8,0);
      l_cSql = l_cSql+", D44 = "+CPLib.ToSQL(w_D44,"C",30,0);
      l_cSql = l_cSql+", D45 = "+CPLib.ToSQL(w_D45,"C",1,0);
      l_cSql = l_cSql+", E11 = "+CPLib.ToSQLNull(w_E11,"C",70,0);
      l_cSql = l_cSql+", E13 = "+CPLib.ToSQLNull(w_E13,"C",3,0);
      l_cSql = l_cSql+", E14A = "+CPLib.ToSQLNull(w_E14A,"C",6,0);
      l_cSql = l_cSql+", E14B = "+CPLib.ToSQLNull(w_E14B,"C",30,0);
      l_cSql = l_cSql+", E14C = "+CPLib.ToSQL(w_E14C,"C",2,0);
      l_cSql = l_cSql+", E15 = "+CPLib.ToSQL(w_E15,"C",35,0);
      l_cSql = l_cSql+", E16 = "+CPLib.ToSQL(w_E16,"C",5,0);
      l_cSql = l_cSql+", E17 = "+CPLib.ToSQL(w_E17,"C",16,0);
      l_cSql = l_cSql+", E18 = "+CPLib.ToSQL(w_E18,"D",8,0);
      l_cSql = l_cSql+", E19A = "+CPLib.ToSQLNull(w_E19A,"C",30,0);
      l_cSql = l_cSql+", E19B = "+CPLib.ToSQLNull(w_E19B,"C",30,0);
      l_cSql = l_cSql+", E41 = "+CPLib.ToSQLNull(w_E41,"C",2,0);
      l_cSql = l_cSql+", E42 = "+CPLib.ToSQL(w_E42,"C",15,0);
      l_cSql = l_cSql+", E43 = "+CPLib.ToSQL(w_E43,"D",8,0);
      l_cSql = l_cSql+", E44 = "+CPLib.ToSQL(w_E44,"C",30,0);
      l_cSql = l_cSql+", E45 = "+CPLib.ToSQL(w_E45,"C",1,0);
      l_cSql = l_cSql+", F11 = "+CPLib.ToSQLNull(w_F11,"C",70,0);
      l_cSql = l_cSql+", F13 = "+CPLib.ToSQLNull(w_F13,"C",3,0);
      l_cSql = l_cSql+", F14A = "+CPLib.ToSQLNull(w_F14A,"C",6,0);
      l_cSql = l_cSql+", F14B = "+CPLib.ToSQLNull(w_F14B,"C",30,0);
      l_cSql = l_cSql+", F14C = "+CPLib.ToSQL(w_F14C,"C",2,0);
      l_cSql = l_cSql+", F15 = "+CPLib.ToSQL(w_F15,"C",35,0);
      l_cSql = l_cSql+", F16 = "+CPLib.ToSQL(w_F16,"C",5,0);
      l_cSql = l_cSql+", F17 = "+CPLib.ToSQL(w_F17,"C",16,0);
      l_cSql = l_cSql+", G11 = "+CPLib.ToSQLNull(w_G11,"C",70,0);
      l_cSql = l_cSql+", G13 = "+CPLib.ToSQLNull(w_G13,"C",3,0);
      l_cSql = l_cSql+", G14A = "+CPLib.ToSQLNull(w_G14A,"C",6,0);
      l_cSql = l_cSql+", G14B = "+CPLib.ToSQLNull(w_G14B,"C",30,0);
      l_cSql = l_cSql+", G14C = "+CPLib.ToSQL(w_G14C,"C",2,0);
      l_cSql = l_cSql+", G15 = "+CPLib.ToSQL(w_G15,"C",35,0);
      l_cSql = l_cSql+", G16 = "+CPLib.ToSQL(w_G16,"C",5,0);
      l_cSql = l_cSql+", G17 = "+CPLib.ToSQL(w_G17,"C",16,0);
      l_cSql = l_cSql+", G18 = "+CPLib.ToSQL(w_G18,"D",8,0);
      l_cSql = l_cSql+", G19A = "+CPLib.ToSQLNull(w_G19A,"C",30,0);
      l_cSql = l_cSql+", G19B = "+CPLib.ToSQLNull(w_G19B,"C",30,0);
      l_cSql = l_cSql+", G41 = "+CPLib.ToSQLNull(w_G41,"C",2,0);
      l_cSql = l_cSql+", G42 = "+CPLib.ToSQL(w_G42,"C",15,0);
      l_cSql = l_cSql+", G43 = "+CPLib.ToSQL(w_G43,"D",8,0);
      l_cSql = l_cSql+", G44 = "+CPLib.ToSQL(w_G44,"C",30,0);
      l_cSql = l_cSql+", G45 = "+CPLib.ToSQL(w_G45,"C",1,0);
      l_cSql = l_cSql+", H11 = "+CPLib.ToSQLNull(w_H11,"C",70,0);
      l_cSql = l_cSql+", H13 = "+CPLib.ToSQLNull(w_H13,"C",3,0);
      l_cSql = l_cSql+", H14A = "+CPLib.ToSQLNull(w_H14A,"C",6,0);
      l_cSql = l_cSql+", H14B = "+CPLib.ToSQLNull(w_H14B,"C",30,0);
      l_cSql = l_cSql+", H14C = "+CPLib.ToSQL(w_H14C,"C",2,0);
      l_cSql = l_cSql+", H15 = "+CPLib.ToSQL(w_H15,"C",35,0);
      l_cSql = l_cSql+", H16 = "+CPLib.ToSQL(w_H16,"C",5,0);
      l_cSql = l_cSql+", H17 = "+CPLib.ToSQL(w_H17,"C",16,0);
      l_cSql = l_cSql+", H18 = "+CPLib.ToSQL(w_H18,"D",8,0);
      l_cSql = l_cSql+", H19A = "+CPLib.ToSQLNull(w_H19A,"C",30,0);
      l_cSql = l_cSql+", H19B = "+CPLib.ToSQLNull(w_H19B,"C",30,0);
      l_cSql = l_cSql+", H41 = "+CPLib.ToSQLNull(w_H41,"C",2,0);
      l_cSql = l_cSql+", H42 = "+CPLib.ToSQL(w_H42,"C",15,0);
      l_cSql = l_cSql+", H43 = "+CPLib.ToSQL(w_H43,"D",8,0);
      l_cSql = l_cSql+", H44 = "+CPLib.ToSQL(w_H44,"C",30,0);
      l_cSql = l_cSql+", H45 = "+CPLib.ToSQL(w_H45,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tmp_ricmas1")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_tmp_ricmas1,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_tmp_ricmas1.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tmp_ricmas1")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_ricmas1,l_cSql,m_oParameters);
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
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_tmp_ricmas1.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_tmp_ricmas1,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_tmp_ricmas1.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"tmp_ricmas1")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_ricmas1,l_cSql);
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
    m_Sql.NextTableProg(this,"PRGMASSA","w_IDBASE",m_cServer_tmp_ricmas1,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave IDBASE, altrimenti non si riesce a linkare da zoom
    w_IDBASE = CPLib.RTrim(w_IDBASE);
    op_IDBASE = w_IDBASE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"TIPXBDXITE")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TIPXBDXITE",CPLib.GetLinkedFieldProps("CODINTER","A01B","C",11,0));
    } else if (CPLib.eq(p_cID,"BQNMQAOIPA")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BQNMQAOIPA",CPLib.GetLinkedFieldProps("CODDIP","A11","C",6,0));
    } else if (CPLib.eq(p_cID,"XHIBDWLIOD")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XHIBDWLIOD",CPLib.GetLinkedFieldProps("CAB","A12A","C",6,0));
    } else if (CPLib.eq(p_cID,"IFYLHOXPRS")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IFYLHOXPRS",CPLib.GetLinkedFieldProps("CITTA","A12B","C",30,0));
    } else if (CPLib.eq(p_cID,"CKACALWZOL")) {
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
      result.AppendFieldsHash("CKACALWZOL",CPLib.GetLinkedFieldProps("CODCAU","A24","C",4,0));
    } else if (CPLib.eq(p_cID,"ZIMEUPPLZY")) {
      result.m_TableName = "tbcausin";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODVOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZIMEUPPLZY",CPLib.GetLinkedFieldProps("CODVOC","A25","C",2,0));
    } else if (CPLib.eq(p_cID,"ZZQPEDWGCO")) {
      result.m_TableName = "inter2bo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZZQPEDWGCO",CPLib.GetLinkedFieldProps("CODINTER","A31B","C",10,0));
    } else if (CPLib.eq(p_cID,"LTUCQORMSA")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LTUCQORMSA",CPLib.GetLinkedFieldProps("CODSTA","A32","C",3,0));
    } else if (CPLib.eq(p_cID,"VDWEKDDBOW")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VDWEKDDBOW",CPLib.GetLinkedFieldProps("CAB","A33A","C",6,0));
    } else if (CPLib.eq(p_cID,"BICDANUWZD")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BICDANUWZD",CPLib.GetLinkedFieldProps("CITTA","A33B","C",30,0));
    } else if (CPLib.eq(p_cID,"HDIAJDVNVI")) {
      result.m_TableName = "anarapbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAPPORTO" , "DESCRAP"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HDIAJDVNVI",CPLib.GetLinkedFieldProps("RAPPORTO","A41","C",25,0));
    } else if (CPLib.eq(p_cID,"RQJLOLNIHM")) {
      result.m_TableName = "tbtipnat";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPONAT"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RQJLOLNIHM",CPLib.GetLinkedFieldProps("TIPONAT","A42","C",1,0));
    } else if (CPLib.eq(p_cID,"CHJJABTJCS")) {
      result.m_TableName = "tbtipleg";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPLEG" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CHJJABTJCS",CPLib.GetLinkedFieldProps("TIPLEG","A43","C",1,0));
    } else if (CPLib.eq(p_cID,"DFFBWGMKTL")) {
      result.m_TableName = "tbtipreg";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DFFBWGMKTL",CPLib.GetLinkedFieldProps("CODICE","A52B","C",2,0));
    } else if (CPLib.eq(p_cID,"CDFYKKBMYS")) {
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
      result.AppendFieldsHash("CDFYKKBMYS",CPLib.GetLinkedFieldProps("CODVAL","B12","C",3,0));
    } else if (CPLib.eq(p_cID,"BZRDFHBMPM")) {
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
      result.AppendFieldsHash("BZRDFHBMPM",CPLib.GetLinkedFieldProps("CONNES","C11","C",16,0));
    } else if (CPLib.eq(p_cID,"UYRQHSBRRT")) {
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
      result.AppendFieldsHash("UYRQHSBRRT",CPLib.GetLinkedFieldProps("CONNES","C21","C",16,0));
    } else if (CPLib.eq(p_cID,"PMFBITPOAZ")) {
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
      result.AppendFieldsHash("PMFBITPOAZ",CPLib.GetLinkedFieldProps("CONNES","C31","C",16,0));
    } else if (CPLib.eq(p_cID,"LZSKLOQPNQ")) {
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
      result.AppendFieldsHash("LZSKLOQPNQ",CPLib.GetLinkedFieldProps("CONNES","C41","C",16,0));
    } else if (CPLib.eq(p_cID,"RHMPOMWSNG")) {
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
      result.AppendFieldsHash("RHMPOMWSNG",CPLib.GetLinkedFieldProps("CONNES","C51","C",16,0));
    } else if (CPLib.eq(p_cID,"OQJHGGFCNJ")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAGSOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("OQJHGGFCNJ",CPLib.GetLinkedFieldProps("RAGSOC","D11","C",70,0));
    } else if (CPLib.eq(p_cID,"GMCYYELLWW")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GMCYYELLWW",CPLib.GetLinkedFieldProps("CODSTA","D13","C",3,0));
    } else if (CPLib.eq(p_cID,"VZGLYXBMQI")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VZGLYXBMQI",CPLib.GetLinkedFieldProps("CAB","D14A","C",6,0));
    } else if (CPLib.eq(p_cID,"YRFNYFRQSY")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YRFNYFRQSY",CPLib.GetLinkedFieldProps("CITTA","D14B","C",30,0));
    } else if (CPLib.eq(p_cID,"ZGFXMEVTVH")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZGFXMEVTVH",CPLib.GetLinkedFieldProps("CITTA","D19A","C",30,0));
    } else if (CPLib.eq(p_cID,"RVQNZAINRJ")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RVQNZAINRJ",CPLib.GetLinkedFieldProps("DESCRI","D19B","C",30,0));
    } else if (CPLib.eq(p_cID,"DXFRERNUEZ")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DXFRERNUEZ",CPLib.GetLinkedFieldProps("SOTGRU","D21","C",3,0));
    } else if (CPLib.eq(p_cID,"QZTKKLVNJB")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QZTKKLVNJB",CPLib.GetLinkedFieldProps("RAMGRU","D22","C",3,0));
    } else if (CPLib.eq(p_cID,"RIPVAPFZCO")) {
      result.m_TableName = "tbsetsin";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SETSINT" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RIPVAPFZCO",CPLib.GetLinkedFieldProps("SETSINT","D23","C",3,0));
    } else if (CPLib.eq(p_cID,"QDVHTXVAEJ")) {
      result.m_TableName = "tbtipdoc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPDOC" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QDVHTXVAEJ",CPLib.GetLinkedFieldProps("TIPDOC","D41","C",2,0));
    } else if (CPLib.eq(p_cID,"UMGRLGMHMY")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAGSOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UMGRLGMHMY",CPLib.GetLinkedFieldProps("RAGSOC","E11","C",70,0));
    } else if (CPLib.eq(p_cID,"GXOOZRXYFU")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GXOOZRXYFU",CPLib.GetLinkedFieldProps("CODSTA","E13","C",3,0));
    } else if (CPLib.eq(p_cID,"IMIPLTLEAA")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IMIPLTLEAA",CPLib.GetLinkedFieldProps("CAB","E14A","C",6,0));
    } else if (CPLib.eq(p_cID,"JMWSEEISWG")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JMWSEEISWG",CPLib.GetLinkedFieldProps("CITTA","E14B","C",30,0));
    } else if (CPLib.eq(p_cID,"OZDICWDQRW")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("OZDICWDQRW",CPLib.GetLinkedFieldProps("CITTA","E19A","C",30,0));
    } else if (CPLib.eq(p_cID,"YSNADFXEBL")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YSNADFXEBL",CPLib.GetLinkedFieldProps("DESCRI","E19B","C",30,0));
    } else if (CPLib.eq(p_cID,"SZZONHIXUX")) {
      result.m_TableName = "tbtipdoc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPDOC" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SZZONHIXUX",CPLib.GetLinkedFieldProps("TIPDOC","E41","C",2,0));
    } else if (CPLib.eq(p_cID,"XUTATNAFCN")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAGSOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XUTATNAFCN",CPLib.GetLinkedFieldProps("RAGSOC","F11","C",70,0));
    } else if (CPLib.eq(p_cID,"GSQDROOXIH")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GSQDROOXIH",CPLib.GetLinkedFieldProps("CODSTA","F13","C",3,0));
    } else if (CPLib.eq(p_cID,"AYOYZWWHED")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AYOYZWWHED",CPLib.GetLinkedFieldProps("CAB","F14A","C",6,0));
    } else if (CPLib.eq(p_cID,"ZKDTAIVYNT")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZKDTAIVYNT",CPLib.GetLinkedFieldProps("CITTA","F14B","C",30,0));
    } else if (CPLib.eq(p_cID,"PGAPCLKWDU")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAGSOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("PGAPCLKWDU",CPLib.GetLinkedFieldProps("RAGSOC","G11","C",70,0));
    } else if (CPLib.eq(p_cID,"NMVYSCDEYI")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NMVYSCDEYI",CPLib.GetLinkedFieldProps("CODSTA","G13","C",3,0));
    } else if (CPLib.eq(p_cID,"IZFSEEEELX")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IZFSEEEELX",CPLib.GetLinkedFieldProps("CAB","G14A","C",6,0));
    } else if (CPLib.eq(p_cID,"RZOPLJQQOD")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RZOPLJQQOD",CPLib.GetLinkedFieldProps("CITTA","G14B","C",30,0));
    } else if (CPLib.eq(p_cID,"GSZGYDPMMI")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GSZGYDPMMI",CPLib.GetLinkedFieldProps("CITTA","G19A","C",30,0));
    } else if (CPLib.eq(p_cID,"HKGGYHAADA")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HKGGYHAADA",CPLib.GetLinkedFieldProps("DESCRI","G19B","C",30,0));
    } else if (CPLib.eq(p_cID,"BCOSCDETUR")) {
      result.m_TableName = "tbtipdoc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPDOC" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BCOSCDETUR",CPLib.GetLinkedFieldProps("TIPDOC","G41","C",2,0));
    } else if (CPLib.eq(p_cID,"LWFUPEVCFF")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAGSOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LWFUPEVCFF",CPLib.GetLinkedFieldProps("RAGSOC","H11","C",70,0));
    } else if (CPLib.eq(p_cID,"LMFVWUIXUQ")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LMFVWUIXUQ",CPLib.GetLinkedFieldProps("CODSTA","H13","C",3,0));
    } else if (CPLib.eq(p_cID,"EVWGKCMMJY")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("EVWGKCMMJY",CPLib.GetLinkedFieldProps("CAB","H14A","C",6,0));
    } else if (CPLib.eq(p_cID,"UVHIQLABPT")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UVHIQLABPT",CPLib.GetLinkedFieldProps("CITTA","H14B","C",30,0));
    } else if (CPLib.eq(p_cID,"KCGLCUJYUP")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KCGLCUJYUP",CPLib.GetLinkedFieldProps("CITTA","H19A","C",30,0));
    } else if (CPLib.eq(p_cID,"RQOFXUOOWZ")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RQOFXUOOWZ",CPLib.GetLinkedFieldProps("DESCRI","H19B","C",30,0));
    } else if (CPLib.eq(p_cID,"OAWXXEHPRA")) {
      result.m_TableName = "tbtipdoc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPDOC" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("OAWXXEHPRA",CPLib.GetLinkedFieldProps("TIPDOC","H41","C",2,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_calcrichieste,
  public static final String i_InvokedRoutines = ",arfn_calcrichieste,";
}
