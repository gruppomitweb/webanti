// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_personboBO extends armt_personboBL {
  class SqlLoader {
    public boolean m_bLink_1_36 = false;
    public boolean m_bLink_1_41 = false;
    public boolean m_bLink_1_50 = false;
    public boolean m_bLink_1_51 = false;
    public boolean m_bLink_6_2 = false;
    public boolean m_bLink_8_7 = false;
    public boolean m_bLink_9_2 = false;
    public boolean m_bLink_9_11 = false;
    public boolean m_bLink_9_12 = false;
    public boolean m_bLink_9_13 = false;
    public boolean m_bLink_10_5 = false;
    public boolean m_bLink_10_8 = false;
    public boolean m_bLink_10_14 = false;
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
    public void AddJoinedLink_1_36(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_36.IDBASE AS IDBASE136";
        m_cSelect = m_cSelect+" ,link_1_36.DESCRI AS DESCRI136";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_36","IDNASSTATO","IDBASE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_36","IDNASSTATO","IDBASE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_36 = true;
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
        m_cSelect = m_cSelect+" ,link_1_41.TIPDOC AS TIPDOC141";
        m_cSelect = m_cSelect+" ,link_1_41.DESCRI AS DESCRI141";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_41","TIPODOC","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_41","TIPODOC","TIPDOC",true);
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
    public void AddJoinedLink_1_50(String rightTable,String rightServer) {
      // questo link aggiunge 4 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+4,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_50.SOTGRU AS SOTGRU150";
        m_cSelect = m_cSelect+" ,link_1_50.DESCRI AS DESCRI150";
        m_cSelect = m_cSelect+" ,link_1_50.TIPOSOT AS TIPOSOT150";
        m_cSelect = m_cSelect+" ,link_1_50.DATAFINE AS DATAFINE150";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_50","SOTGRUP","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_50","SOTGRUP","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_50 = true;
          m_nColumns = m_nColumns+4;
        }
      }
    }
    public void AddJoinedLink_1_51(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_51.RAMGRU AS RAMGRU151";
        m_cSelect = m_cSelect+" ,link_1_51.DESCRI AS DESCRI151";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_51","RAMOGRUP","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_51","RAMOGRUP","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_51 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_2(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_2.CONNES AS CONNES602";
        m_cSelect = m_cSelect+" ,link_6_2.RAGSOC AS RAGSOC602";
        m_cSelect = m_cSelect+" ,link_6_2.IDBASE AS IDBASE602";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_2","CODLEGRAP","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_2","CODLEGRAP","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_2 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_9_2(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_9_2.CODSTA AS CODSTA902";
        m_cSelect = m_cSelect+" ,link_9_2.DESCRI AS DESCRI902";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_9_2","FATCA","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_9_2","FATCA","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_9_2 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_10_5(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_10_5.CODICE AS CODICE1005";
        m_cSelect = m_cSelect+" ,link_10_5.DESCRI AS DESCRI1005";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_10_5","AREAGEO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_10_5","AREAGEO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_10_5 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_10_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_10_8.CODSPE AS CODSPE1008";
        m_cSelect = m_cSelect+" ,link_10_8.DESCRI AS DESCRI1008";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_10_8","PKTBSPECIE","CODSPE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_10_8","PKTBSPECIE","CODSPE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_10_8 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_10_14(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_10_14.CODICE AS CODICE1014";
        m_cSelect = m_cSelect+" ,link_10_14.DESCRI AS DESCRI1014";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_10_14","COMPORT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_10_14","COMPORT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_10_14 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_9_11(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_9_11.CODSTA AS CODSTA911";
        m_cSelect = m_cSelect+" ,link_9_11.DESCRI AS DESCRI911";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_9_11","CITTADIN1","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_9_11","CITTADIN1","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_9_11 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_9_12(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_9_12.CODSTA AS CODSTA912";
        m_cSelect = m_cSelect+" ,link_9_12.DESCRI AS DESCRI912";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_9_12","CITTADIN2","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_9_12","CITTADIN2","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_9_12 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_9_13(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_9_13.CODSTA AS CODSTA913";
        m_cSelect = m_cSelect+" ,link_9_13.DESCRI AS DESCRI913";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_9_13","RESFISC","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_9_13","RESFISC","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_9_13 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_8_7(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_8_7.CODINTER AS CODINTER807";
        m_cSelect = m_cSelect+" ,link_8_7.RAGSOC AS RAGSOC807";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_8_7","BANCABEN","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_8_7","BANCABEN","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_8_7 = true;
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
  public armt_personboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_personbo");
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
    l_bResult =  ! (CPLib.Empty(w_CONNES));
    if (l_bResult) {
    } else {
      m_cLastMsgError = "E' necessario indicare l'NDG del soggetto";
    }
    if (l_bResult) {
      l_bResult = CanSaveChild(ardt_personbo_dip,m_cWv_ardt_personbo_dip,"m_cWv_ardt_personbo_dip");
      if (l_bResult) {
        l_bResult = CanSaveChild(armt_personbo_agg,m_cWv_armt_personbo_agg,"m_cWv_armt_personbo_agg");
        if (l_bResult) {
          l_bResult = CanSaveChild(ardt_soggope,m_cWv_ardt_soggope,"m_cWv_ardt_soggope");
          if (l_bResult) {
            l_bResult = CanSaveChild(ardt_fatca_ind,m_cWv_ardt_fatca_ind,"m_cWv_ardt_fatca_ind");
            if (l_bResult) {
              l_bResult = CanSaveChild(ardt_patrimonio,m_cWv_ardt_patrimonio,"m_cWv_ardt_patrimonio");
              if (l_bResult) {
                l_bResult = CanSaveChild(ardt_reddito,m_cWv_ardt_reddito,"m_cWv_ardt_reddito");
                if (l_bResult) {
                  l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
                } else {
                  m_cLastMsgError = ardt_reddito.m_cLastMsgError;
                }
              } else {
                m_cLastMsgError = ardt_patrimonio.m_cLastMsgError;
              }
            } else {
              m_cLastMsgError = ardt_fatca_ind.m_cLastMsgError;
            }
          } else {
            m_cLastMsgError = ardt_soggope.m_cLastMsgError;
          }
        } else {
          m_cLastMsgError = armt_personbo_agg.m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = ardt_personbo_dip.m_cLastMsgError;
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
          if ( ! (ardt_personbo_dip.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_personbo_dip)) {
            ardt_personbo_dip.SetFromContext(m_cWv_ardt_personbo_dip);
            m_cWv_ardt_personbo_dip = "_not_empty_";
          }
          if (ardt_personbo_dip.IsUpdated()) {
            ardt_personbo_dip.w_CONNES = w_CONNES;
            if ( ! (ardt_personbo_dip.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (armt_personbo_agg.IsUpdated()) && CPLib.IsUpdated(m_cWv_armt_personbo_agg)) {
            armt_personbo_agg.SetFromContext(m_cWv_armt_personbo_agg);
            m_cWv_armt_personbo_agg = "_not_empty_";
          }
          if (armt_personbo_agg.IsUpdated()) {
            armt_personbo_agg.w_CONNES = w_CONNES;
            if ( ! (armt_personbo_agg.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_soggope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_soggope)) {
            ardt_soggope.SetFromContext(m_cWv_ardt_soggope);
            m_cWv_ardt_soggope = "_not_empty_";
          }
          if (ardt_soggope.IsUpdated()) {
            ardt_soggope.w_COLLEG = w_CONNES;
            if ( ! (ardt_soggope.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_fatca_ind.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_fatca_ind)) {
            ardt_fatca_ind.SetFromContext(m_cWv_ardt_fatca_ind);
            m_cWv_ardt_fatca_ind = "_not_empty_";
          }
          if (ardt_fatca_ind.IsUpdated()) {
            ardt_fatca_ind.w_CONNES = w_CONNES;
            if ( ! (ardt_fatca_ind.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_patrimonio.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_patrimonio)) {
            ardt_patrimonio.SetFromContext(m_cWv_ardt_patrimonio);
            m_cWv_ardt_patrimonio = "_not_empty_";
          }
          if (ardt_patrimonio.IsUpdated()) {
            ardt_patrimonio.w_CONNES = w_CONNES;
            if ( ! (ardt_patrimonio.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_reddito.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_reddito)) {
            ardt_reddito.SetFromContext(m_cWv_ardt_reddito);
            m_cWv_ardt_reddito = "_not_empty_";
          }
          if (ardt_reddito.IsUpdated()) {
            ardt_reddito.w_CONNES = w_CONNES;
            if ( ! (ardt_reddito.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"CONNES"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CONNES) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_personbo,m_cPhName_personbo,m_cVirtName_personbo,m_cVirtName_personbo+".CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CONNES,"C",16,0),m_cServer_personbo,p_CONNES),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_36(m_cPhName_tbstatna,m_cServer_tbstatna);
    l_oSqlLoader.AddJoinedLink_1_41(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
    l_oSqlLoader.AddJoinedLink_1_50(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_1_51(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_6_2(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_9_2(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_10_5(m_cPhName_tbareegeog,m_cServer_tbareegeog);
    l_oSqlLoader.AddJoinedLink_10_8(m_cPhName_tbspecie,m_cServer_tbspecie);
    l_oSqlLoader.AddJoinedLink_10_14(m_cPhName_tbcondotta,m_cServer_tbcondotta);
    l_oSqlLoader.AddJoinedLink_9_11(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_9_12(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_9_13(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_8_7(m_cPhName_inter2bo,m_cServer_inter2bo);
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
        w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
        w_DATARETT = CPLib.NullDate();
        w_STATOREG = "";
        w_NUMPROG = "";
        w_tipsot = "";
        w_DESCSGRU = "";
        w_DESCRAMGRU = "";
        w_DESCUIC = "";
        w_dessta = "";
        w_DESCRI = "";
        w_xstatonas = "";
        w_finesae = CPLib.NullDate();
        w_finesint = CPLib.NullDate();
        w_xFLGVALIDO = "";
        w_xFLGANAVAL = "";
        w_xDSETSIN = "";
        w_xdesctipatt = "";
        w_xdescareag = "";
        w_xdescnatgiu = "";
        w_xdesccomp = "";
        w_xITFLGPEP = "";
        w_xRAGLEGRAP = "";
        w_xIDLEGRAP = "";
        w_ragbanben = "";
        w_xDESDIPE = "";
        w_xdesfatca = "";
        w_xDesCit1 = "";
        w_xDesCit2 = "";
        w_xResFis = "";
        w_ATTIVR = "";
        w_FLGALTO = 0;
        w_status = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_xITFLGPEP = "";
        w_flgaggfam = "";
        Link_LDTVEYLAXJ("Load");
        w_dataoggi = CPLib.Date();
        w_TIPOPERS = l_rsLoad.GetString("TIPOPERS");
        w_COGNOME = l_rsLoad.GetString("COGNOME");
        w_NOME = l_rsLoad.GetString("NOME");
        w_CFESTERO = l_rsLoad.GetDouble("CFESTERO");
        w_RAGSOC = l_rsLoad.GetString("RAGSOC");
        w_PAESE = l_rsLoad.GetString("PAESE");
        w_dessta = "";
        Link_YVIKEGPYPM("Load");
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        // Link con tbcitta non eseguito: riporta solo campi
        w_idcitta = l_rsLoad.GetString("idcitta");
        // Link con tbcitta non eseguito: riporta solo campi
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CAP = l_rsLoad.GetString("CAP");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
        w_IDENT = l_rsLoad.GetString("IDENT");
        w_IDNASCOMUN = l_rsLoad.GetString("IDNASCOMUN");
        // Link con tbcittna non eseguito: riporta solo campi
        w_nascomunid = w_IDNASCOMUN;
        w_NASCOMUN = "";
        w_TIPINTER = "";
        Link_ZRIWLTGERM("Load");
        w_NASCOMUN = l_rsLoad.GetString("NASCOMUN");
        w_TIPINTER = l_rsLoad.GetString("TIPINTER");
        w_IDNASSTATO = l_rsLoad.GetString("IDNASSTATO");
        if (l_oSqlLoader.m_bLink_1_36) {
          w_xstatonas = l_rsLoad.GetString("DESCRI136");
        } else {
          Link_IOAMSFCCVV("Load");
        }
        w_nasstatoid = w_IDNASSTATO;
        w_NASSTATO = "";
        Link_AHFPACGVOQ("Load");
        w_NASSTATO = l_rsLoad.GetString("NASSTATO");
        w_SESSO = l_rsLoad.GetString("SESSO");
        w_DATANASC = l_rsLoad.GetDate("DATANASC");
        w_TIPODOC = l_rsLoad.GetString("TIPODOC");
        if (l_oSqlLoader.m_bLink_1_41) {
          w_DESCRI = l_rsLoad.GetString("DESCRI141");
        } else {
          Link_MBGANUUHRA("Load");
        }
        w_NUMDOCUM = l_rsLoad.GetString("NUMDOCUM");
        w_DATARILASC = l_rsLoad.GetDate("DATARILASC");
        w_DATAVALI = l_rsLoad.GetDate("DATAVALI");
        w_AUTRILASC = l_rsLoad.GetString("AUTRILASC");
        w_CODFISC = l_rsLoad.GetString("CODFISC");
        w_PARTIVA = l_rsLoad.GetString("PARTIVA");
        w_CONTO = l_rsLoad.GetString("CONTO");
        w_SOTGRUP = l_rsLoad.GetString("SOTGRUP");
        if (l_oSqlLoader.m_bLink_1_50) {
          w_DESCSGRU = l_rsLoad.GetString("DESCRI150");
          w_tipsot = l_rsLoad.GetString("TIPOSOT150");
          w_finesae = l_rsLoad.GetDate("DATAFINE150");
        } else {
          Link_LLYIGAMXRH("Load");
        }
        w_RAMOGRUP = l_rsLoad.GetString("RAMOGRUP");
        if (l_oSqlLoader.m_bLink_1_51) {
          w_DESCRAMGRU = l_rsLoad.GetString("DESCRI151");
        } else {
          Link_RVNHQCXNEM("Load");
        }
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        w_xdesctipatt = "";
        w_ATTIVR = "";
        Link_SAQTIHOALW("Load");
        w_SETTSINT = l_rsLoad.GetString("SETTSINT");
        w_finesint = CPLib.NullDate();
        w_xDSETSIN = "";
        Link_ZGNLLSFQHC("Load");
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_NOSARA = l_rsLoad.GetString("NOSARA");
        w_NOTIT = l_rsLoad.GetDouble("NOTIT");
        w_flgaggfam = "N";
        w_PROGIMPORT = l_rsLoad.GetDouble("PROGIMPORT");
        op_PROGIMPORT = w_PROGIMPORT;
        w_OLDSETSIN = l_rsLoad.GetString("OLDSETSIN");
        w_CRIMEDATE = l_rsLoad.GetDate("CRIMEDATE");
        w_PEPDATE = l_rsLoad.GetDate("PEPDATE");
        w_DATAFINE = l_rsLoad.GetDate("DATAFINE");
        w_DATAINI = l_rsLoad.GetDate("DATAINI");
        w_DISATTIVO = l_rsLoad.GetDate("DISATTIVO");
        w_TIPOSOGGETTO = l_rsLoad.GetString("TIPOSOGGETTO");
        w_RAPSEGNA = l_rsLoad.GetString("RAPSEGNA");
        w_SOGAFFIDATARIO = l_rsLoad.GetString("SOGAFFIDATARIO");
        w_CAUSALE = l_rsLoad.GetDouble("CAUSALE");
        w_FATTURATO = l_rsLoad.GetDouble("FATTURATO");
        w_FLGNOTRIM = l_rsLoad.GetString("FLGNOTRIM");
        w_DATAIDENT = l_rsLoad.GetDate("DATAIDENT");
        w_COMPLETA = true;
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        w_NUMIMP = l_rsLoad.GetDateTime("NUMIMP");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        w_SOSPMAF = l_rsLoad.GetString("SOSPMAF");
        w_OLDCONNES = l_rsLoad.GetString("OLDCONNES");
        w_DATEXTRA = l_rsLoad.GetDate("DATEXTRA");
        w_ALLINEATO = l_rsLoad.GetDouble("ALLINEATO");
        w_ALLINEATONOMECNOME = l_rsLoad.GetDouble("ALLINEATONOMECNOME");
        w_RAGSOCOLD = l_rsLoad.GetString("RAGSOCOLD");
        w_PROGIMP_C = l_rsLoad.GetString("PROGIMP_C");
        w_IDFILE = l_rsLoad.GetString("IDFILE");
        w_OLDCODFISC = l_rsLoad.GetString("OLDCODFISC");
        w_MACROAGENTE = l_rsLoad.GetString("MACROAGENTE");
        w_SPOTID = l_rsLoad.GetString("SPOTID");
        w_DATAVARAGE = l_rsLoad.GetDate("DATAVARAGE");
        w_SETTSINT2 = l_rsLoad.GetString("SETTSINT2");
        w_TELEF = l_rsLoad.GetString("TELEF");
        w_TIPOORO = l_rsLoad.GetString("TIPOORO");
        w_CODORO = l_rsLoad.GetString("CODORO");
        w_FLGVALIDO = l_rsLoad.GetString("FLGVALIDO");
        w_DAC6 = l_rsLoad.GetString("DAC6");
        w_ALTRODOM = l_rsLoad.GetString("ALTRODOM");
        w_ALTROCAP = l_rsLoad.GetString("ALTROCAP");
        w_IMPORTOMAX = l_rsLoad.GetDouble("IMPORTOMAX");
        w_FREQUENZA = l_rsLoad.GetString("FREQUENZA");
        w_NUMOPERAZ = l_rsLoad.GetDouble("NUMOPERAZ");
        w_DATASIGN = l_rsLoad.GetDate("DATASIGN");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        w_FLAGDAC6 = l_rsLoad.GetDouble("FLAGDAC6");
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_xFLGVALIDO = "";
        w_xFLGANAVAL = "";
        Link_MQYKJYJENJ("Load");
        w_NOTE = l_rsLoad.GetString("NOTE");
        w_CODLEGRAP = l_rsLoad.GetString("CODLEGRAP");
        if (l_oSqlLoader.m_bLink_6_2) {
          w_xRAGLEGRAP = l_rsLoad.GetString("RAGSOC602");
          w_xIDLEGRAP = l_rsLoad.GetString("IDBASE602");
        } else {
          Link_CKHRNQSKKQ("Load");
        }
        w_BANCABEN = l_rsLoad.GetString("BANCABEN");
        if (l_oSqlLoader.m_bLink_8_7) {
          w_ragbanben = l_rsLoad.GetString("RAGSOC807");
        } else {
          Link_DQZNJUSTLN("Load");
        }
        w_DATASEGN = l_rsLoad.GetDate("DATASEGN");
        w_DATARAUT = l_rsLoad.GetDate("DATARAUT");
        w_FATCA = l_rsLoad.GetString("FATCA");
        if (l_oSqlLoader.m_bLink_9_2) {
          w_xdesfatca = l_rsLoad.GetString("DESCRI902");
        } else {
          Link_RKHMYOIJDM("Load");
        }
        w_TIN = l_rsLoad.GetString("TIN");
        w_ODB = l_rsLoad.GetDouble("ODB");
        w_CITTADIN1 = l_rsLoad.GetString("CITTADIN1");
        if (l_oSqlLoader.m_bLink_9_11) {
          w_xDesCit1 = l_rsLoad.GetString("DESCRI911");
        } else {
          Link_CJBEXKJOQO("Load");
        }
        w_CITTADIN2 = l_rsLoad.GetString("CITTADIN2");
        if (l_oSqlLoader.m_bLink_9_12) {
          w_xDesCit2 = l_rsLoad.GetString("DESCRI912");
        } else {
          Link_UNRQNVVFTK("Load");
        }
        w_RESFISC = l_rsLoad.GetString("RESFISC");
        if (l_oSqlLoader.m_bLink_9_13) {
          w_xResFis = l_rsLoad.GetString("DESCRI913");
        } else {
          Link_OSLBLDODHQ("Load");
        }
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        if (l_oSqlLoader.m_bLink_10_5) {
          w_xdescareag = l_rsLoad.GetString("DESCRI1005");
        } else {
          Link_NXVXQSLAGM("Load");
        }
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        // Link con tbareegeog_p non eseguito: riporta solo campi
        w_RAREA = l_rsLoad.GetDouble("RAREA");
        w_PKTBSPECIE = l_rsLoad.GetString("PKTBSPECIE");
        if (l_oSqlLoader.m_bLink_10_8) {
          w_xdescnatgiu = l_rsLoad.GetString("DESCRI1008");
        } else {
          Link_VHXDWWHVXF("Load");
        }
        w_PKTBSPECIE = l_rsLoad.GetString("PKTBSPECIE");
        // Link con tbspecie_p non eseguito: riporta solo campi
        w_RNATGIU = l_rsLoad.GetDouble("RNATGIU");
        w_ATTIV = "";
        Link_UQYOQYIUNM("Load");
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        w_RATTIV = 0;
        w_FLGALTO = 0;
        Link_QFJRACGINU("Load");
        w_RATTIV = l_rsLoad.GetDouble("RATTIV");
        w_COMPORT = l_rsLoad.GetString("COMPORT");
        if (l_oSqlLoader.m_bLink_10_14) {
          w_xdesccomp = l_rsLoad.GetString("DESCRI1014");
        } else {
          Link_HLXRSSMBIW("Load");
        }
        w_COMPORT = l_rsLoad.GetString("COMPORT");
        // Link con tbcondotta_p non eseguito: riporta solo campi
        w_RCOMP = l_rsLoad.GetDouble("RCOMP");
        w_DOCFILE = l_rsLoad.GetString("DOCFILE");
        w_RISGLOB = l_rsLoad.GetString("RISGLOB");
        w_DATAPROF = l_rsLoad.GetDate("DATAPROF");
        w_DATAREVPROF = l_rsLoad.GetDate("DATAREVPROF");
        w_PEP = l_rsLoad.GetString("PEP");
        w_CRIME = l_rsLoad.GetString("CRIME");
        w_MITIG = l_rsLoad.GetDouble("MITIG");
        w_MITIGDOC = l_rsLoad.GetString("MITIGDOC");
        w_VERIFICA = l_rsLoad.GetString("VERIFICA");
        w_NOTERIS = l_rsLoad.GetString("NOTERIS");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_personbo_dip = "";
        ardt_personbo_dip.m_lCtxLoaded = false;
        m_cWv_armt_personbo_agg = "";
        armt_personbo_agg.m_lCtxLoaded = false;
        m_cWv_ardt_soggope = "";
        ardt_soggope.m_lCtxLoaded = false;
        m_cWv_ardt_fatca_ind = "";
        ardt_fatca_ind.m_lCtxLoaded = false;
        m_cWv_ardt_patrimonio = "";
        ardt_patrimonio.m_lCtxLoaded = false;
        m_cWv_ardt_reddito = "";
        ardt_reddito.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo")) {
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
    // * --- armt_personbo
    if(!w_COMPLETA) {
      SetUpdated();
    }
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_CONNES);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_personbo);
      l_cSql = "insert into "+m_oWrInfo_personbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"TIPOPERS,";
      l_cSql = l_cSql+"COGNOME,";
      l_cSql = l_cSql+"NOME,";
      l_cSql = l_cSql+"CFESTERO,";
      l_cSql = l_cSql+"RAGSOC,";
      l_cSql = l_cSql+"PAESE,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"idcitta,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CAP,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"DOMICILIO,";
      l_cSql = l_cSql+"IDENT,";
      l_cSql = l_cSql+"IDNASCOMUN,";
      l_cSql = l_cSql+"NASCOMUN,";
      l_cSql = l_cSql+"TIPINTER,";
      l_cSql = l_cSql+"IDNASSTATO,";
      l_cSql = l_cSql+"NASSTATO,";
      l_cSql = l_cSql+"SESSO,";
      l_cSql = l_cSql+"DATANASC,";
      l_cSql = l_cSql+"TIPODOC,";
      l_cSql = l_cSql+"NUMDOCUM,";
      l_cSql = l_cSql+"DATARILASC,";
      l_cSql = l_cSql+"DATAVALI,";
      l_cSql = l_cSql+"AUTRILASC,";
      l_cSql = l_cSql+"CODFISC,";
      l_cSql = l_cSql+"PARTIVA,";
      l_cSql = l_cSql+"CONTO,";
      l_cSql = l_cSql+"SOTGRUP,";
      l_cSql = l_cSql+"RAMOGRUP,";
      l_cSql = l_cSql+"ATTIV,";
      l_cSql = l_cSql+"SETTSINT,";
      l_cSql = l_cSql+"CONNES,";
      l_cSql = l_cSql+"NOSARA,";
      l_cSql = l_cSql+"NOTIT,";
      l_cSql = l_cSql+"PROGIMPORT,";
      l_cSql = l_cSql+"OLDSETSIN,";
      l_cSql = l_cSql+"CRIMEDATE,";
      l_cSql = l_cSql+"PEPDATE,";
      l_cSql = l_cSql+"DATAFINE,";
      l_cSql = l_cSql+"DATAINI,";
      l_cSql = l_cSql+"DISATTIVO,";
      l_cSql = l_cSql+"TIPOSOGGETTO,";
      l_cSql = l_cSql+"RAPSEGNA,";
      l_cSql = l_cSql+"SOGAFFIDATARIO,";
      l_cSql = l_cSql+"CAUSALE,";
      l_cSql = l_cSql+"FATTURATO,";
      l_cSql = l_cSql+"FLGNOTRIM,";
      l_cSql = l_cSql+"DATAIDENT,";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"NUMIMP,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"SOSPMAF,";
      l_cSql = l_cSql+"OLDCONNES,";
      l_cSql = l_cSql+"DATEXTRA,";
      l_cSql = l_cSql+"ALLINEATO,";
      l_cSql = l_cSql+"ALLINEATONOMECNOME,";
      l_cSql = l_cSql+"RAGSOCOLD,";
      l_cSql = l_cSql+"PROGIMP_C,";
      l_cSql = l_cSql+"IDFILE,";
      l_cSql = l_cSql+"OLDCODFISC,";
      l_cSql = l_cSql+"MACROAGENTE,";
      l_cSql = l_cSql+"SPOTID,";
      l_cSql = l_cSql+"DATAVARAGE,";
      l_cSql = l_cSql+"SETTSINT2,";
      l_cSql = l_cSql+"TELEF,";
      l_cSql = l_cSql+"TIPOORO,";
      l_cSql = l_cSql+"CODORO,";
      l_cSql = l_cSql+"FLGVALIDO,";
      l_cSql = l_cSql+"DAC6,";
      l_cSql = l_cSql+"ALTRODOM,";
      l_cSql = l_cSql+"ALTROCAP,";
      l_cSql = l_cSql+"IMPORTOMAX,";
      l_cSql = l_cSql+"FREQUENZA,";
      l_cSql = l_cSql+"NUMOPERAZ,";
      l_cSql = l_cSql+"DATASIGN,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"FLAGDAC6,";
      l_cSql = l_cSql+"NOTE,";
      l_cSql = l_cSql+"CODLEGRAP,";
      l_cSql = l_cSql+"BANCABEN,";
      l_cSql = l_cSql+"DATASEGN,";
      l_cSql = l_cSql+"DATARAUT,";
      l_cSql = l_cSql+"FATCA,";
      l_cSql = l_cSql+"TIN,";
      l_cSql = l_cSql+"ODB,";
      l_cSql = l_cSql+"CITTADIN1,";
      l_cSql = l_cSql+"CITTADIN2,";
      l_cSql = l_cSql+"RESFISC,";
      l_cSql = l_cSql+"AREAGEO,";
      l_cSql = l_cSql+"RAREA,";
      l_cSql = l_cSql+"PKTBSPECIE,";
      l_cSql = l_cSql+"RNATGIU,";
      l_cSql = l_cSql+"RATTIV,";
      l_cSql = l_cSql+"COMPORT,";
      l_cSql = l_cSql+"RCOMP,";
      l_cSql = l_cSql+"DOCFILE,";
      l_cSql = l_cSql+"RISGLOB,";
      l_cSql = l_cSql+"DATAPROF,";
      l_cSql = l_cSql+"DATAREVPROF,";
      l_cSql = l_cSql+"PEP,";
      l_cSql = l_cSql+"CRIME,";
      l_cSql = l_cSql+"MITIG,";
      l_cSql = l_cSql+"MITIGDOC,";
      l_cSql = l_cSql+"VERIFICA,";
      l_cSql = l_cSql+"NOTERIS,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_personbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOPERS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COGNOME,"C",26,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOME,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFESTERO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAGSOC,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_idcitta,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDENT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_IDNASCOMUN,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASCOMUN,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPINTER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_IDNASSTATO,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASSTATO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATANASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPODOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMDOCUM,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARILASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVALI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTRILASC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODFISC,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PARTIVA,"C",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOTGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAMOGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ATTIV,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SETTSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNES,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOSARA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOTIT,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGIMPORT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OLDSETSIN,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CRIMEDATE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEPDATE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAFINE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAINI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DISATTIVO,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOSOGGETTO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPSEGNA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOGAFFIDATARIO,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAUSALE,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FATTURATO,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGNOTRIM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAIDENT,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMIMP,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSPMAF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OLDCONNES,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATEXTRA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALLINEATO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALLINEATONOMECNOME,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAGSOCOLD,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGIMP_C,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDFILE,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OLDCODFISC,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MACROAGENTE,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SPOTID,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVARAGE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SETTSINT2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TELEF,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOORO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODORO,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGVALIDO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAC6,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTRODOM,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTROCAP,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPORTOMAX,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FREQUENZA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMOPERAZ,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATASIGN,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGDAC6,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOTE,"M",10,0,m_cServer_personbo,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODLEGRAP,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_BANCABEN,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATASEGN,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARAUT,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_FATCA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIN,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ODB,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CITTADIN1,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CITTADIN2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RESFISC,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AREAGEO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PKTBSPECIE,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RNATGIU,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RATTIV,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_COMPORT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOCFILE,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RISGLOB,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAPROF,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREVPROF,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CRIME,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITIG,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITIGDOC,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VERIFICA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOTERIS,"M",10,0,m_cServer_personbo,m_oParameters)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_personbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_personbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_personbo);
      l_cSql = "Update "+m_oWrInfo_personbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TIPOPERS = "+CPLib.ToSQL(w_TIPOPERS,"C",1,0);
      l_cSql = l_cSql+", COGNOME = "+CPLib.ToSQL(w_COGNOME,"C",26,0);
      l_cSql = l_cSql+", NOME = "+CPLib.ToSQL(w_NOME,"C",25,0);
      l_cSql = l_cSql+", CFESTERO = "+CPLib.ToSQL(w_CFESTERO,"N",1,0);
      l_cSql = l_cSql+", RAGSOC = "+CPLib.ToSQL(w_RAGSOC,"C",70,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQL(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", idcitta = "+CPLib.ToSQLNull(w_idcitta,"C",40,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",9,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", DOMICILIO = "+CPLib.ToSQL(w_DOMICILIO,"C",35,0);
      l_cSql = l_cSql+", IDENT = "+CPLib.ToSQL(w_IDENT,"C",3,0);
      l_cSql = l_cSql+", IDNASCOMUN = "+CPLib.ToSQLNull(w_IDNASCOMUN,"C",40,0);
      l_cSql = l_cSql+", NASCOMUN = "+CPLib.ToSQL(w_NASCOMUN,"C",30,0);
      l_cSql = l_cSql+", TIPINTER = "+CPLib.ToSQL(w_TIPINTER,"C",2,0);
      l_cSql = l_cSql+", IDNASSTATO = "+CPLib.ToSQLNull(w_IDNASSTATO,"C",10,0);
      l_cSql = l_cSql+", NASSTATO = "+CPLib.ToSQL(w_NASSTATO,"C",30,0);
      l_cSql = l_cSql+", SESSO = "+CPLib.ToSQL(w_SESSO,"C",1,0);
      l_cSql = l_cSql+", DATANASC = "+CPLib.ToSQL(w_DATANASC,"D",8,0);
      l_cSql = l_cSql+", TIPODOC = "+CPLib.ToSQLNull(w_TIPODOC,"C",2,0);
      l_cSql = l_cSql+", NUMDOCUM = "+CPLib.ToSQL(w_NUMDOCUM,"C",15,0);
      l_cSql = l_cSql+", DATARILASC = "+CPLib.ToSQL(w_DATARILASC,"D",8,0);
      l_cSql = l_cSql+", DATAVALI = "+CPLib.ToSQL(w_DATAVALI,"D",8,0);
      l_cSql = l_cSql+", AUTRILASC = "+CPLib.ToSQL(w_AUTRILASC,"C",30,0);
      l_cSql = l_cSql+", CODFISC = "+CPLib.ToSQL(w_CODFISC,"C",16,0);
      l_cSql = l_cSql+", PARTIVA = "+CPLib.ToSQL(w_PARTIVA,"C",14,0);
      l_cSql = l_cSql+", CONTO = "+CPLib.ToSQL(w_CONTO,"C",25,0);
      l_cSql = l_cSql+", SOTGRUP = "+CPLib.ToSQLNull(w_SOTGRUP,"C",3,0);
      l_cSql = l_cSql+", RAMOGRUP = "+CPLib.ToSQLNull(w_RAMOGRUP,"C",3,0);
      l_cSql = l_cSql+", ATTIV = "+CPLib.ToSQL(w_ATTIV,"C",10,0);
      l_cSql = l_cSql+", SETTSINT = "+CPLib.ToSQLNull(w_SETTSINT,"C",3,0);
      l_cSql = l_cSql+", NOSARA = "+CPLib.ToSQL(w_NOSARA,"C",1,0);
      l_cSql = l_cSql+", NOTIT = "+CPLib.ToSQL(w_NOTIT,"N",1,0);
      l_cSql = l_cSql+", PROGIMPORT = "+CPLib.ToSQL(w_PROGIMPORT,"N",15,0);
      l_cSql = l_cSql+", OLDSETSIN = "+CPLib.ToSQL(w_OLDSETSIN,"C",3,0);
      l_cSql = l_cSql+", CRIMEDATE = "+CPLib.ToSQL(w_CRIMEDATE,"D",8,0);
      l_cSql = l_cSql+", PEPDATE = "+CPLib.ToSQL(w_PEPDATE,"D",8,0);
      l_cSql = l_cSql+", DATAFINE = "+CPLib.ToSQL(w_DATAFINE,"D",8,0);
      l_cSql = l_cSql+", DATAINI = "+CPLib.ToSQL(w_DATAINI,"D",8,0);
      l_cSql = l_cSql+", DISATTIVO = "+CPLib.ToSQL(w_DISATTIVO,"D",8,0);
      l_cSql = l_cSql+", TIPOSOGGETTO = "+CPLib.ToSQL(w_TIPOSOGGETTO,"C",1,0);
      l_cSql = l_cSql+", RAPSEGNA = "+CPLib.ToSQL(w_RAPSEGNA,"C",1,0);
      l_cSql = l_cSql+", SOGAFFIDATARIO = "+CPLib.ToSQL(w_SOGAFFIDATARIO,"C",80,0);
      l_cSql = l_cSql+", CAUSALE = "+CPLib.ToSQL(w_CAUSALE,"N",5,0);
      l_cSql = l_cSql+", FATTURATO = "+CPLib.ToSQL(w_FATTURATO,"N",12,2);
      l_cSql = l_cSql+", FLGNOTRIM = "+CPLib.ToSQL(w_FLGNOTRIM,"C",1,0);
      l_cSql = l_cSql+", DATAIDENT = "+CPLib.ToSQL(w_DATAIDENT,"D",8,0);
      l_cSql = l_cSql+", CODINTER = "+CPLib.ToSQL(w_CODINTER,"C",11,0);
      l_cSql = l_cSql+", NUMIMP = "+CPLib.ToSQL(w_NUMIMP,"T",14,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQL(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", SOSPMAF = "+CPLib.ToSQL(w_SOSPMAF,"C",1,0);
      l_cSql = l_cSql+", OLDCONNES = "+CPLib.ToSQL(w_OLDCONNES,"C",16,0);
      l_cSql = l_cSql+", DATEXTRA = "+CPLib.ToSQL(w_DATEXTRA,"D",8,0);
      l_cSql = l_cSql+", ALLINEATO = "+CPLib.ToSQL(w_ALLINEATO,"N",1,0);
      l_cSql = l_cSql+", ALLINEATONOMECNOME = "+CPLib.ToSQL(w_ALLINEATONOMECNOME,"N",1,0);
      l_cSql = l_cSql+", RAGSOCOLD = "+CPLib.ToSQL(w_RAGSOCOLD,"C",70,0);
      l_cSql = l_cSql+", PROGIMP_C = "+CPLib.ToSQL(w_PROGIMP_C,"C",15,0);
      l_cSql = l_cSql+", IDFILE = "+CPLib.ToSQL(w_IDFILE,"C",60,0);
      l_cSql = l_cSql+", OLDCODFISC = "+CPLib.ToSQL(w_OLDCODFISC,"C",20,0);
      l_cSql = l_cSql+", MACROAGENTE = "+CPLib.ToSQL(w_MACROAGENTE,"C",5,0);
      l_cSql = l_cSql+", SPOTID = "+CPLib.ToSQL(w_SPOTID,"C",16,0);
      l_cSql = l_cSql+", DATAVARAGE = "+CPLib.ToSQL(w_DATAVARAGE,"D",8,0);
      l_cSql = l_cSql+", SETTSINT2 = "+CPLib.ToSQL(w_SETTSINT2,"C",3,0);
      l_cSql = l_cSql+", TELEF = "+CPLib.ToSQL(w_TELEF,"C",15,0);
      l_cSql = l_cSql+", TIPOORO = "+CPLib.ToSQL(w_TIPOORO,"C",1,0);
      l_cSql = l_cSql+", CODORO = "+CPLib.ToSQL(w_CODORO,"C",11,0);
      l_cSql = l_cSql+", FLGVALIDO = "+CPLib.ToSQL(w_FLGVALIDO,"C",1,0);
      l_cSql = l_cSql+", DAC6 = "+CPLib.ToSQL(w_DAC6,"C",100,0);
      l_cSql = l_cSql+", ALTRODOM = "+CPLib.ToSQL(w_ALTRODOM,"C",35,0);
      l_cSql = l_cSql+", ALTROCAP = "+CPLib.ToSQL(w_ALTROCAP,"C",9,0);
      l_cSql = l_cSql+", IMPORTOMAX = "+CPLib.ToSQL(w_IMPORTOMAX,"N",12,2);
      l_cSql = l_cSql+", FREQUENZA = "+CPLib.ToSQL(w_FREQUENZA,"C",1,0);
      l_cSql = l_cSql+", NUMOPERAZ = "+CPLib.ToSQL(w_NUMOPERAZ,"N",3,0);
      l_cSql = l_cSql+", DATASIGN = "+CPLib.ToSQL(w_DATASIGN,"D",8,0);
      l_cSql = l_cSql+", IDBASE = "+CPLib.ToSQL(w_IDBASE,"C",10,0);
      l_cSql = l_cSql+", FLAGDAC6 = "+CPLib.ToSQL(w_FLAGDAC6,"N",1,0);
      l_cSql = l_cSql+", NOTE = "+CPLib.ToSQL(w_NOTE,"M",10,0,m_cServer_personbo,m_oParameters);
      l_cSql = l_cSql+", CODLEGRAP = "+CPLib.ToSQLNull(w_CODLEGRAP,"C",16,0);
      l_cSql = l_cSql+", BANCABEN = "+CPLib.ToSQLNull(w_BANCABEN,"C",11,0);
      l_cSql = l_cSql+", DATASEGN = "+CPLib.ToSQL(w_DATASEGN,"D",8,0);
      l_cSql = l_cSql+", DATARAUT = "+CPLib.ToSQL(w_DATARAUT,"D",8,0);
      l_cSql = l_cSql+", FATCA = "+CPLib.ToSQLNull(w_FATCA,"C",3,0);
      l_cSql = l_cSql+", TIN = "+CPLib.ToSQL(w_TIN,"C",16,0);
      l_cSql = l_cSql+", ODB = "+CPLib.ToSQL(w_ODB,"N",1,0);
      l_cSql = l_cSql+", CITTADIN1 = "+CPLib.ToSQLNull(w_CITTADIN1,"C",3,0);
      l_cSql = l_cSql+", CITTADIN2 = "+CPLib.ToSQLNull(w_CITTADIN2,"C",3,0);
      l_cSql = l_cSql+", RESFISC = "+CPLib.ToSQLNull(w_RESFISC,"C",3,0);
      l_cSql = l_cSql+", AREAGEO = "+CPLib.ToSQLNull(w_AREAGEO,"C",3,0);
      l_cSql = l_cSql+", RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0);
      l_cSql = l_cSql+", PKTBSPECIE = "+CPLib.ToSQLNull(w_PKTBSPECIE,"C",4,0);
      l_cSql = l_cSql+", RNATGIU = "+CPLib.ToSQL(w_RNATGIU,"N",3,0);
      l_cSql = l_cSql+", RATTIV = "+CPLib.ToSQL(w_RATTIV,"N",3,0);
      l_cSql = l_cSql+", COMPORT = "+CPLib.ToSQLNull(w_COMPORT,"C",5,0);
      l_cSql = l_cSql+", RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0);
      l_cSql = l_cSql+", DOCFILE = "+CPLib.ToSQL(w_DOCFILE,"C",100,0);
      l_cSql = l_cSql+", RISGLOB = "+CPLib.ToSQL(w_RISGLOB,"C",3,0);
      l_cSql = l_cSql+", DATAPROF = "+CPLib.ToSQL(w_DATAPROF,"D",8,0);
      l_cSql = l_cSql+", DATAREVPROF = "+CPLib.ToSQL(w_DATAREVPROF,"D",8,0);
      l_cSql = l_cSql+", PEP = "+CPLib.ToSQL(w_PEP,"C",1,0);
      l_cSql = l_cSql+", CRIME = "+CPLib.ToSQL(w_CRIME,"C",1,0);
      l_cSql = l_cSql+", MITIG = "+CPLib.ToSQL(w_MITIG,"N",4,0);
      l_cSql = l_cSql+", MITIGDOC = "+CPLib.ToSQL(w_MITIGDOC,"C",100,0);
      l_cSql = l_cSql+", VERIFICA = "+CPLib.ToSQL(w_VERIFICA,"C",1,0);
      l_cSql = l_cSql+", NOTERIS = "+CPLib.ToSQL(w_NOTERIS,"M",10,0,m_cServer_personbo,m_oParameters);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0),m_cServer_personbo,w_CONNES);
      l_cSql = l_cSql+m_oWrInfo_personbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_personbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_CONNES) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_CONNES);
    // * --- Area Manuale = BO - Delete Init
    // * --- armt_personbo
    m_bLoaded = false;
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
          ardt_personbo_dip.w_CONNES = w_CONNES;
          ardt_personbo_dip.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio Dati_Agg
          armt_personbo_agg.w_CONNES = w_CONNES;
          armt_personbo_agg.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_soggope.w_COLLEG = w_CONNES;
          ardt_soggope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_fatca_ind.w_CONNES = w_CONNES;
          ardt_fatca_ind.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_patrimonio.w_CONNES = w_CONNES;
          ardt_patrimonio.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_reddito.w_CONNES = w_CONNES;
          ardt_reddito.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_personbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0),m_cServer_personbo,w_CONNES);
          l_cSql = l_cSql+m_oWrInfo_personbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_personbo,l_cSql);
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
    // * --- armt_personbo
    m_Sql.RequireTransaction();
    NotifyEvent("Delete end");
    // BROnDeleted();        
    l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
    // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
    // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
    // la parte di transazione corrente
    m_Sql.CompleteTransaction();  
    if (l_bTrsOk) {
      NotifyEvent("Record Deleted");
    }  
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_CONNES);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPOCLI","i_codazi,w_PROGIMPORT",m_cServer_personbo,m_Ctx.GetCompany());
    op_PROGIMPORT = w_PROGIMPORT;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"LDTVEYLAXJ")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER" , "ITFLGPEP" , "FLGAGGFAM"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LDTVEYLAXJ",CPLib.GetLinkedFieldProps("CODINTER","gIntemediario","C",11,0));
    } else if (CPLib.eq(p_cID,"YVIKEGPYPM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YVIKEGPYPM",CPLib.GetLinkedFieldProps("CODSTA","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"ODAYKSRECA")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "IDBASE"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",30,0));
    } else if (CPLib.eq(p_cID,"TYEDHRZCMA")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "CAB" , "PROV" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TYEDHRZCMA",CPLib.GetLinkedFieldProps("IDBASE","idcitta","C",40,0));
    } else if (CPLib.eq(p_cID,"BYPEBFEOAJ")) {
      result.m_TableName = "tbcittna";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BYPEBFEOAJ",CPLib.GetLinkedFieldProps("IDBASE","IDNASCOMUN","C",40,0));
    } else if (CPLib.eq(p_cID,"ZRIWLTGERM")) {
      result.m_TableName = "tbcittna";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "CITTA" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZRIWLTGERM",CPLib.GetLinkedFieldProps("IDBASE","nascomunid","C",40,0));
    } else if (CPLib.eq(p_cID,"IOAMSFCCVV")) {
      result.m_TableName = "tbstatna";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IOAMSFCCVV",CPLib.GetLinkedFieldProps("IDBASE","IDNASSTATO","C",10,0));
    } else if (CPLib.eq(p_cID,"AHFPACGVOQ")) {
      result.m_TableName = "tbstatna";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AHFPACGVOQ",CPLib.GetLinkedFieldProps("IDBASE","nasstatoid","C",10,0));
    } else if (CPLib.eq(p_cID,"MBGANUUHRA")) {
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
      result.AppendFieldsHash("MBGANUUHRA",CPLib.GetLinkedFieldProps("TIPDOC","TIPODOC","C",2,0));
    } else if (CPLib.eq(p_cID,"LLYIGAMXRH")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI" , "TIPOSOT" , "DATAFINE"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "D"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LLYIGAMXRH",CPLib.GetLinkedFieldProps("SOTGRU","SOTGRUP","C",3,0));
    } else if (CPLib.eq(p_cID,"RVNHQCXNEM")) {
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
      result.AppendFieldsHash("RVNHQCXNEM",CPLib.GetLinkedFieldProps("RAMGRU","RAMOGRUP","C",3,0));
    } else if (CPLib.eq(p_cID,"SAQTIHOALW")) {
      result.m_TableName = "tbtipatt";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "armt_tbtipatt";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "CODICE"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SAQTIHOALW",CPLib.GetLinkedFieldProps("CODICE","ATTIV","C",10,0));
    } else if (CPLib.eq(p_cID,"ZGNLLSFQHC")) {
      result.m_TableName = "tbsetsin";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SETSINT" , "DATAFINE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "D" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZGNLLSFQHC",CPLib.GetLinkedFieldProps("SETSINT","SETTSINT","C",3,0));
    } else if (CPLib.eq(p_cID,"MQYKJYJENJ")) {
      result.m_TableName = "personbo_agg";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "FLGVALIDO" , "FLGANAVAL"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MQYKJYJENJ",CPLib.GetLinkedFieldProps("CONNES","CONNES","C",16,0));
    } else if (CPLib.eq(p_cID,"CKHRNQSKKQ")) {
      result.m_TableName = "personbo";
      result.n_KMode = 3;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_personbo";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "IDBASE"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CKHRNQSKKQ",CPLib.GetLinkedFieldProps("CONNES","CODLEGRAP","C",16,0));
    } else if (CPLib.eq(p_cID,"DQZNJUSTLN")) {
      result.m_TableName = "inter2bo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DQZNJUSTLN",CPLib.GetLinkedFieldProps("CODINTER","BANCABEN","C",11,0));
    } else if (CPLib.eq(p_cID,"RKHMYOIJDM")) {
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
      result.AppendFieldsHash("RKHMYOIJDM",CPLib.GetLinkedFieldProps("CODSTA","FATCA","C",3,0));
    } else if (CPLib.eq(p_cID,"CJBEXKJOQO")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CJBEXKJOQO",CPLib.GetLinkedFieldProps("CODSTA","CITTADIN1","C",3,0));
    } else if (CPLib.eq(p_cID,"UNRQNVVFTK")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UNRQNVVFTK",CPLib.GetLinkedFieldProps("CODSTA","CITTADIN2","C",3,0));
    } else if (CPLib.eq(p_cID,"OSLBLDODHQ")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("OSLBLDODHQ",CPLib.GetLinkedFieldProps("CODSTA","RESFISC","C",3,0));
    } else if (CPLib.eq(p_cID,"NXVXQSLAGM")) {
      result.m_TableName = "tbareegeog";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NXVXQSLAGM",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",3,0));
    } else if (CPLib.eq(p_cID,"JHEJMIHGSH")) {
      result.m_TableName = "tbareegeog_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JHEJMIHGSH",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",3,0));
    } else if (CPLib.eq(p_cID,"VHXDWWHVXF")) {
      result.m_TableName = "tbspecie";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbspecie";
      result.m_rdField = new String[]{"CODSPE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VHXDWWHVXF",CPLib.GetLinkedFieldProps("CODSPE","PKTBSPECIE","C",4,0));
    } else if (CPLib.eq(p_cID,"DRJTSDRPVN")) {
      result.m_TableName = "tbspecie_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSPE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DRJTSDRPVN",CPLib.GetLinkedFieldProps("CODSPE","PKTBSPECIE","C",4,0));
    } else if (CPLib.eq(p_cID,"UQYOQYIUNM")) {
      result.m_TableName = "tbtipatt";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "CODICE"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UQYOQYIUNM",CPLib.GetLinkedFieldProps("CODICE","ATTIVR","C",10,0));
    } else if (CPLib.eq(p_cID,"QFJRACGINU")) {
      result.m_TableName = "tbtipatt_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO" , "FLGALTO"};
      result.m_rdTypes = new String[]{"C" , "N" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QFJRACGINU",CPLib.GetLinkedFieldProps("CODICE","ATTIV","C",10,0));
    } else if (CPLib.eq(p_cID,"HLXRSSMBIW")) {
      result.m_TableName = "tbcondotta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbcondotta";
      result.m_rdField = new String[]{"CODICE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HLXRSSMBIW",CPLib.GetLinkedFieldProps("CODICE","COMPORT","C",5,0));
    } else if (CPLib.eq(p_cID,"KYTSUTYBUR")) {
      result.m_TableName = "tbcondotta_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KYTSUTYBUR",CPLib.GetLinkedFieldProps("CODICE","COMPORT","C",5,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chk_tiporapporto,arfn_chkateco,arfn_chkcodfis,arfn_chklundoc,arfn_chksint,arrt_agg_famiglie,arrt_calccodfis,arrt_calcolasett,arrt_crea_agg,arrt_delpersonbo,arrt_storicopers,arrt_writelog,opert_imp_dati_soggetto,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chk_tiporapporto,arfn_chkateco,arfn_chkcodfis,arfn_chklundoc,arfn_chksint,arrt_agg_famiglie,arrt_calccodfis,arrt_calcolasett,arrt_crea_agg,arrt_delpersonbo,arrt_storicopers,arrt_writelog,opert_imp_dati_soggetto,";
}
