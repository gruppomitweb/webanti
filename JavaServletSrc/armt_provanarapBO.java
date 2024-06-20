// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_provanarapBO extends armt_provanarapBL {
  class SqlLoader {
    public boolean m_bLink_1_10 = false;
    public boolean m_bLink_1_43 = false;
    public boolean m_bLink_1_45 = false;
    public boolean m_bLink_1_47 = false;
    public boolean m_bLink_1_50 = false;
    public boolean m_bLink_1_52 = false;
    public boolean m_bLink_1_54 = false;
    public boolean m_bLink_4_10 = false;
    public boolean m_bLink_4_14 = false;
    public boolean m_bLink_5_6 = false;
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
    public void AddJoinedLink_1_10(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_10.CODVAL AS CODVAL110";
        m_cSelect = m_cSelect+" ,link_1_10.DESCRI AS DESCRI110";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_10","VALUTA","CODVAL");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_10","VALUTA","CODVAL",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_10 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_43(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_43.CODICE AS CODICE143";
        m_cSelect = m_cSelect+" ,link_1_43.DESCRI AS DESCRI143";
        m_cSelect = m_cSelect+" ,link_1_43.RISCHIO AS RISCHIO143";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_43","DURAT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_43","DURAT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_43 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_45(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_45.CODICE AS CODICE145";
        m_cSelect = m_cSelect+" ,link_1_45.DESCRI AS DESCRI145";
        m_cSelect = m_cSelect+" ,link_1_45.RISCHIO AS RISCHIO145";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_45","AMMONT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_45","AMMONT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_45 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_47(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_47.CODICE AS CODICE147";
        m_cSelect = m_cSelect+" ,link_1_47.DESCRI AS DESCRI147";
        m_cSelect = m_cSelect+" ,link_1_47.RISCHIO AS RISCHIO147";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_47","AREAGEO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_47","AREAGEO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_47 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_50(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_50.CODICE AS CODICE150";
        m_cSelect = m_cSelect+" ,link_1_50.DESCRI AS DESCRI150";
        m_cSelect = m_cSelect+" ,link_1_50.RISCHIO AS RISCHIO150";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_50","MODSVOL","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_50","MODSVOL","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_50 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_52(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_52.CODICE AS CODICE152";
        m_cSelect = m_cSelect+" ,link_1_52.DESCRI AS DESCRI152";
        m_cSelect = m_cSelect+" ,link_1_52.RISCHIO AS RISCHIO152";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_52","RAGIO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_52","RAGIO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_52 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_54(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_54.CODICE AS CODICE154";
        m_cSelect = m_cSelect+" ,link_1_54.DESCRI AS DESCRI154";
        m_cSelect = m_cSelect+" ,link_1_54.RISCHIO AS RISCHIO154";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_54","TIPO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_54","TIPO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_54 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_5_6(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_5_6.CODDIP AS CODDIP506";
        m_cSelect = m_cSelect+" ,link_5_6.DESCRIZ AS DESCRIZ506";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_5_6","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_5_6","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_5_6 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_10(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_10.MACODICE AS MACODICE410";
        m_cSelect = m_cSelect+" ,link_4_10.MADESCRI AS MADESCRI410";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_10","MACODICE","MACODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_10","MACODICE","MACODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_10 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_14(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_14.CONNES AS CONNES414";
        m_cSelect = m_cSelect+" ,link_4_14.RAGSOC AS RAGSOC414";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_14","CODICELR","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_14","CODICELR","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_14 = true;
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
  public armt_provanarapBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_provanarap");
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
      l_bResult = CanSaveChild(ardt_xarantbo,m_cWv_ardt_xarantbo,"m_cWv_ardt_xarantbo");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_xarantbo.m_cLastMsgError;
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
          if ( ! (ardt_xarantbo.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_xarantbo)) {
            ardt_xarantbo.SetFromContext(m_cWv_ardt_xarantbo);
            m_cWv_ardt_xarantbo = "_not_empty_";
          }
          if (ardt_xarantbo.IsUpdated()) {
            ardt_xarantbo.w_RAPPORTO = w_RAPPORTO;
            if ( ! (ardt_xarantbo.Save(true))) {
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
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_xnarapbo,m_cPhName_xnarapbo,m_cVirtName_xnarapbo,m_cVirtName_xnarapbo+".RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_RAPPORTO,"C",25,0),m_cServer_xnarapbo,p_RAPPORTO),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_10(m_cPhName_tbvalute,m_cServer_tbvalute);
    l_oSqlLoader.AddJoinedLink_1_43(m_cPhName_tbdurata,m_cServer_tbdurata);
    l_oSqlLoader.AddJoinedLink_1_45(m_cPhName_tbimporto,m_cServer_tbimporto);
    l_oSqlLoader.AddJoinedLink_1_47(m_cPhName_tbareegeog,m_cServer_tbareegeog);
    l_oSqlLoader.AddJoinedLink_1_50(m_cPhName_tbsvolgim,m_cServer_tbsvolgim);
    l_oSqlLoader.AddJoinedLink_1_52(m_cPhName_tbplauso,m_cServer_tbplauso);
    l_oSqlLoader.AddJoinedLink_1_54(m_cPhName_tbtiporisc,m_cServer_tbtiporisc);
    l_oSqlLoader.AddJoinedLink_5_6(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_4_10(m_cPhName_tbmacage,m_cServer_tbmacage);
    l_oSqlLoader.AddJoinedLink_4_14(m_cPhName_personbo,m_cServer_personbo);
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
        w_descval = "";
        w_daticoll = 0;
        w_xdescmodsvo = "";
        w_xdescareag = "";
        w_xdescplauso = "";
        w_xdesctipor = "";
        w_xdescfreq = "";
        w_xdescammo = "";
        w_gTelepass = m_Ctx.GetGlobalString("gTelepass");
        w_gBrowser = m_Ctx.GetGlobalString("gBrowser");
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
        w_xC5DESCRI = "";
        w_xC4DESCRI = "";
        w_xC3DESCRI = "";
        w_xC2DESCRI = "";
        w_xC1DESCRI = "";
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_xMADESCRI = "";
        w_xRAGLEG = "";
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
        w_xDESDIPE = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        w_DESCRAP = l_rsLoad.GetString("DESCRAP");
        w_TIPORAP = l_rsLoad.GetString("TIPORAP");
        w_FLAGLIRE = l_rsLoad.GetString("FLAGLIRE");
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        if (l_oSqlLoader.m_bLink_1_10) {
          w_descval = l_rsLoad.GetString("DESCRI110");
        } else {
          Link_RUMXLFCOKA("Load");
        }
        w_TIPOAG = l_rsLoad.GetString("TIPOAG");
        w_NOPROT = l_rsLoad.GetDouble("NOPROT");
        w_PRGIMPRAP = l_rsLoad.GetDouble("PRGIMPRAP");
        op_PRGIMPRAP = w_PRGIMPRAP;
        w_DURAT = l_rsLoad.GetString("DURAT");
        if (l_oSqlLoader.m_bLink_1_43) {
          w_xdescfreq = l_rsLoad.GetString("DESCRI143");
          w_RFREQ = l_rsLoad.GetDouble("RISCHIO143");
        } else {
          Link_CKJQULDXKW("Load");
        }
        w_RFREQ = l_rsLoad.GetDouble("RFREQ");
        w_AMMONT = l_rsLoad.GetString("AMMONT");
        if (l_oSqlLoader.m_bLink_1_45) {
          w_xdescammo = l_rsLoad.GetString("DESCRI145");
          w_RIMP = l_rsLoad.GetDouble("RISCHIO145");
        } else {
          Link_SXTYCPHBIM("Load");
        }
        w_RIMP = l_rsLoad.GetDouble("RIMP");
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        if (l_oSqlLoader.m_bLink_1_47) {
          w_xdescareag = l_rsLoad.GetString("DESCRI147");
          w_RAREA = l_rsLoad.GetDouble("RISCHIO147");
        } else {
          Link_QJSTZIPOQB("Load");
        }
        w_RAREA = l_rsLoad.GetDouble("RAREA");
        w_MODSVOL = l_rsLoad.GetString("MODSVOL");
        if (l_oSqlLoader.m_bLink_1_50) {
          w_xdescmodsvo = l_rsLoad.GetString("DESCRI150");
          w_RCOMP = l_rsLoad.GetDouble("RISCHIO150");
        } else {
          Link_SFFFOYOWNH("Load");
        }
        w_RCOMP = l_rsLoad.GetDouble("RCOMP");
        w_RAGIO = l_rsLoad.GetString("RAGIO");
        if (l_oSqlLoader.m_bLink_1_52) {
          w_xdescplauso = l_rsLoad.GetString("DESCRI152");
          w_RRAGIO = l_rsLoad.GetDouble("RISCHIO152");
        } else {
          Link_NOBMPHKVTX("Load");
        }
        w_RRAGIO = l_rsLoad.GetDouble("RRAGIO");
        w_TIPO = l_rsLoad.GetString("TIPO");
        if (l_oSqlLoader.m_bLink_1_54) {
          w_xdesctipor = l_rsLoad.GetString("DESCRI154");
          w_RTIPO = l_rsLoad.GetDouble("RISCHIO154");
        } else {
          Link_DJOWYRMDDC("Load");
        }
        w_RTIPO = l_rsLoad.GetDouble("RTIPO");
        w_CODDIP = l_rsLoad.GetString("CODDIP");
        w_MITIG = l_rsLoad.GetDouble("MITIG");
        w_MITGDOC = l_rsLoad.GetString("MITGDOC");
        w_CATEG01 = l_rsLoad.GetString("CATEG01");
        w_xC1DESCRI = "";
        Link_CANUTVNGFD("Load");
        w_CATEG02 = l_rsLoad.GetString("CATEG02");
        w_xC2DESCRI = "";
        Link_IXGRJLAKIQ("Load");
        w_CATEG03 = l_rsLoad.GetString("CATEG03");
        w_xC3DESCRI = "";
        Link_NKIXCWZJHO("Load");
        w_CATEG04 = l_rsLoad.GetString("CATEG04");
        w_xC4DESCRI = "";
        Link_JQLGHMLOKO("Load");
        w_CATEG05 = l_rsLoad.GetString("CATEG05");
        w_xC5DESCRI = "";
        Link_QVBZSFMTVP("Load");
        w_CATEGORIA = l_rsLoad.GetString("CATEGORIA");
        w_titolo = (CPLib.eq(w_gTipInter,"14")?"Relazione d'Affari":"Rapporti Continuativi");
        w_NATURA = l_rsLoad.GetString("NATURA");
        w_SCOPO = l_rsLoad.GetString("SCOPO");
        w_RISGLOB = l_rsLoad.GetString("RISGLOB");
        w_DATAREVPROF = l_rsLoad.GetDate("DATAREVPROF");
        w_DATAPROF = l_rsLoad.GetDate("DATAPROF");
        w_CODOGG = l_rsLoad.GetString("CODOGG");
        w_IBAN = l_rsLoad.GetString("IBAN");
        w_NOCANC = l_rsLoad.GetDouble("NOCANC");
        w_ISOAGE = l_rsLoad.GetString("ISOAGE");
        w_SPLITCODE = l_rsLoad.GetString("SPLITCODE");
        w_MACODICE = l_rsLoad.GetString("MACODICE");
        if (l_oSqlLoader.m_bLink_4_10) {
          w_xMADESCRI = l_rsLoad.GetString("MADESCRI410");
        } else {
          Link_SSYXHQXJLD("Load");
        }
        w_CODICELR = l_rsLoad.GetString("CODICELR");
        if (l_oSqlLoader.m_bLink_4_14) {
          w_xRAGLEG = l_rsLoad.GetString("RAGSOC414");
        } else {
          Link_UYHOJSIFEU("Load");
        }
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_5_6) {
          w_xDESDIPE = l_rsLoad.GetString("DESCRIZ506");
        } else {
          Link_HBPZQIPSZE("Load");
        }
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_xarantbo = "";
        ardt_xarantbo.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"xnarapbo")) {
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_xnarapbo);
      l_cSql = "insert into "+m_oWrInfo_xnarapbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"DESCRAP,";
      l_cSql = l_cSql+"TIPORAP,";
      l_cSql = l_cSql+"FLAGLIRE,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"TIPOAG,";
      l_cSql = l_cSql+"NOPROT,";
      l_cSql = l_cSql+"PRGIMPRAP,";
      l_cSql = l_cSql+"DURAT,";
      l_cSql = l_cSql+"RFREQ,";
      l_cSql = l_cSql+"AMMONT,";
      l_cSql = l_cSql+"RIMP,";
      l_cSql = l_cSql+"AREAGEO,";
      l_cSql = l_cSql+"RAREA,";
      l_cSql = l_cSql+"MODSVOL,";
      l_cSql = l_cSql+"RCOMP,";
      l_cSql = l_cSql+"RAGIO,";
      l_cSql = l_cSql+"RRAGIO,";
      l_cSql = l_cSql+"TIPO,";
      l_cSql = l_cSql+"RTIPO,";
      l_cSql = l_cSql+"CODDIP,";
      l_cSql = l_cSql+"MITIG,";
      l_cSql = l_cSql+"MITGDOC,";
      l_cSql = l_cSql+"CATEG01,";
      l_cSql = l_cSql+"CATEG02,";
      l_cSql = l_cSql+"CATEG03,";
      l_cSql = l_cSql+"CATEG04,";
      l_cSql = l_cSql+"CATEG05,";
      l_cSql = l_cSql+"CATEGORIA,";
      l_cSql = l_cSql+"NATURA,";
      l_cSql = l_cSql+"SCOPO,";
      l_cSql = l_cSql+"RISGLOB,";
      l_cSql = l_cSql+"DATAREVPROF,";
      l_cSql = l_cSql+"DATAPROF,";
      l_cSql = l_cSql+"CODOGG,";
      l_cSql = l_cSql+"IBAN,";
      l_cSql = l_cSql+"NOCANC,";
      l_cSql = l_cSql+"ISOAGE,";
      l_cSql = l_cSql+"SPLITCODE,";
      l_cSql = l_cSql+"MACODICE,";
      l_cSql = l_cSql+"CODICELR,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_xnarapbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xnarapbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCRAP,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPORAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGLIRE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOAG,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOPROT,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGIMPRAP,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DURAT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RFREQ,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AMMONT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RIMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AREAGEO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MODSVOL,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAGIO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RRAGIO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RTIPO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITIG,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITGDOC,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG01,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG02,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG03,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG04,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG05,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATEGORIA,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NATURA,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SCOPO,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RISGLOB,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREVPROF,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAPROF,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODOGG,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IBAN,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOCANC,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ISOAGE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SPLITCODE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MACODICE,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODICELR,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_xnarapbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xnarapbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_xnarapbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_xnarapbo);
      l_cSql = "Update "+m_oWrInfo_xnarapbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DESCRAP = "+CPLib.ToSQL(w_DESCRAP,"C",50,0);
      l_cSql = l_cSql+", TIPORAP = "+CPLib.ToSQL(w_TIPORAP,"C",1,0);
      l_cSql = l_cSql+", FLAGLIRE = "+CPLib.ToSQL(w_FLAGLIRE,"C",1,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQLNull(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", TIPOAG = "+CPLib.ToSQL(w_TIPOAG,"C",2,0);
      l_cSql = l_cSql+", NOPROT = "+CPLib.ToSQL(w_NOPROT,"N",1,0);
      l_cSql = l_cSql+", PRGIMPRAP = "+CPLib.ToSQL(w_PRGIMPRAP,"N",15,0);
      l_cSql = l_cSql+", DURAT = "+CPLib.ToSQLNull(w_DURAT,"C",5,0);
      l_cSql = l_cSql+", RFREQ = "+CPLib.ToSQL(w_RFREQ,"N",3,0);
      l_cSql = l_cSql+", AMMONT = "+CPLib.ToSQLNull(w_AMMONT,"C",5,0);
      l_cSql = l_cSql+", RIMP = "+CPLib.ToSQL(w_RIMP,"N",3,0);
      l_cSql = l_cSql+", AREAGEO = "+CPLib.ToSQLNull(w_AREAGEO,"C",5,0);
      l_cSql = l_cSql+", RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0);
      l_cSql = l_cSql+", MODSVOL = "+CPLib.ToSQLNull(w_MODSVOL,"C",5,0);
      l_cSql = l_cSql+", RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0);
      l_cSql = l_cSql+", RAGIO = "+CPLib.ToSQLNull(w_RAGIO,"C",5,0);
      l_cSql = l_cSql+", RRAGIO = "+CPLib.ToSQL(w_RRAGIO,"N",3,0);
      l_cSql = l_cSql+", TIPO = "+CPLib.ToSQLNull(w_TIPO,"C",5,0);
      l_cSql = l_cSql+", RTIPO = "+CPLib.ToSQL(w_RTIPO,"N",3,0);
      l_cSql = l_cSql+", CODDIP = "+CPLib.ToSQL(w_CODDIP,"C",6,0);
      l_cSql = l_cSql+", MITIG = "+CPLib.ToSQL(w_MITIG,"N",4,0);
      l_cSql = l_cSql+", MITGDOC = "+CPLib.ToSQL(w_MITGDOC,"C",100,0);
      l_cSql = l_cSql+", CATEG01 = "+CPLib.ToSQLNull(w_CATEG01,"C",2,0);
      l_cSql = l_cSql+", CATEG02 = "+CPLib.ToSQLNull(w_CATEG02,"C",2,0);
      l_cSql = l_cSql+", CATEG03 = "+CPLib.ToSQLNull(w_CATEG03,"C",2,0);
      l_cSql = l_cSql+", CATEG04 = "+CPLib.ToSQLNull(w_CATEG04,"C",2,0);
      l_cSql = l_cSql+", CATEG05 = "+CPLib.ToSQLNull(w_CATEG05,"C",2,0);
      l_cSql = l_cSql+", CATEGORIA = "+CPLib.ToSQL(w_CATEGORIA,"C",10,0);
      l_cSql = l_cSql+", NATURA = "+CPLib.ToSQL(w_NATURA,"C",50,0);
      l_cSql = l_cSql+", SCOPO = "+CPLib.ToSQL(w_SCOPO,"C",50,0);
      l_cSql = l_cSql+", RISGLOB = "+CPLib.ToSQL(w_RISGLOB,"C",1,0);
      l_cSql = l_cSql+", DATAREVPROF = "+CPLib.ToSQL(w_DATAREVPROF,"D",8,0);
      l_cSql = l_cSql+", DATAPROF = "+CPLib.ToSQL(w_DATAPROF,"D",8,0);
      l_cSql = l_cSql+", CODOGG = "+CPLib.ToSQL(w_CODOGG,"C",3,0);
      l_cSql = l_cSql+", IBAN = "+CPLib.ToSQL(w_IBAN,"C",30,0);
      l_cSql = l_cSql+", NOCANC = "+CPLib.ToSQL(w_NOCANC,"N",1,0);
      l_cSql = l_cSql+", ISOAGE = "+CPLib.ToSQL(w_ISOAGE,"C",3,0);
      l_cSql = l_cSql+", SPLITCODE = "+CPLib.ToSQL(w_SPLITCODE,"C",15,0);
      l_cSql = l_cSql+", MACODICE = "+CPLib.ToSQLNull(w_MACODICE,"C",5,0);
      l_cSql = l_cSql+", CODICELR = "+CPLib.ToSQLNull(w_CODICELR,"C",16,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xnarapbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_xnarapbo,w_RAPPORTO);
      l_cSql = l_cSql+m_oWrInfo_xnarapbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xnarapbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_xnarapbo,l_cSql,m_oParameters);
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
          ardt_xarantbo.w_RAPPORTO = w_RAPPORTO;
          ardt_xarantbo.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_xnarapbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0),m_cServer_xnarapbo,w_RAPPORTO);
          l_cSql = l_cSql+m_oWrInfo_xnarapbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"xnarapbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_xnarapbo,l_cSql);
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
    m_Sql.NextTableProg(this,"PRGIMPRAP","i_codazi,w_PRGIMPRAP",m_cServer_xnarapbo,m_Ctx.GetCompany());
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
    } else if (CPLib.eq(p_cID,"CKJQULDXKW")) {
      result.m_TableName = "tbdurata";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "ammt_tbdurata";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CKJQULDXKW",CPLib.GetLinkedFieldProps("CODICE","DURAT","C",5,0));
    } else if (CPLib.eq(p_cID,"SXTYCPHBIM")) {
      result.m_TableName = "tbimporto";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SXTYCPHBIM",CPLib.GetLinkedFieldProps("CODICE","AMMONT","C",5,0));
    } else if (CPLib.eq(p_cID,"QJSTZIPOQB")) {
      result.m_TableName = "tbareegeog";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QJSTZIPOQB",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",5,0));
    } else if (CPLib.eq(p_cID,"SFFFOYOWNH")) {
      result.m_TableName = "tbsvolgim";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SFFFOYOWNH",CPLib.GetLinkedFieldProps("CODICE","MODSVOL","C",5,0));
    } else if (CPLib.eq(p_cID,"NOBMPHKVTX")) {
      result.m_TableName = "tbplauso";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NOBMPHKVTX",CPLib.GetLinkedFieldProps("CODICE","RAGIO","C",5,0));
    } else if (CPLib.eq(p_cID,"DJOWYRMDDC")) {
      result.m_TableName = "tbtiporisc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DJOWYRMDDC",CPLib.GetLinkedFieldProps("CODICE","TIPO","C",5,0));
    } else if (CPLib.eq(p_cID,"CANUTVNGFD")) {
      result.m_TableName = "tbcateg01";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg01";
      result.m_rdField = new String[]{"C1CODICE" , "C1DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CANUTVNGFD",CPLib.GetLinkedFieldProps("C1CODICE","CATEG01","C",2,0));
      result.AppendFilter("C1CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"IXGRJLAKIQ")) {
      result.m_TableName = "tbcateg02";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg02";
      result.m_rdField = new String[]{"C2CODICE" , "C2DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IXGRJLAKIQ",CPLib.GetLinkedFieldProps("C2CODICE","CATEG02","C",2,0));
      result.AppendFilter("C2CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"NKIXCWZJHO")) {
      result.m_TableName = "tbcateg03";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg03";
      result.m_rdField = new String[]{"C3CODICE" , "C3DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NKIXCWZJHO",CPLib.GetLinkedFieldProps("C3CODICE","CATEG03","C",2,0));
      result.AppendFilter("C3CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"JQLGHMLOKO")) {
      result.m_TableName = "tbcateg04";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg04";
      result.m_rdField = new String[]{"C4CODICE" , "C4DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JQLGHMLOKO",CPLib.GetLinkedFieldProps("C4CODICE","CATEG04","C",2,0));
      result.AppendFilter("C4CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"QVBZSFMTVP")) {
      result.m_TableName = "tbcateg05";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg05";
      result.m_rdField = new String[]{"C5CODICE" , "C5DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QVBZSFMTVP",CPLib.GetLinkedFieldProps("C5CODICE","CATEG05","C",2,0));
      result.AppendFilter("C5CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"SSYXHQXJLD")) {
      result.m_TableName = "tbmacage";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"MACODICE" , "MADESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SSYXHQXJLD",CPLib.GetLinkedFieldProps("MACODICE","MACODICE","C",5,0));
    } else if (CPLib.eq(p_cID,"UYHOJSIFEU")) {
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
      result.AppendFieldsHash("UYHOJSIFEU",CPLib.GetLinkedFieldProps("CONNES","CODICELR","C",16,0));
    } else if (CPLib.eq(p_cID,"HBPZQIPSZE")) {
      result.m_TableName = "anadip";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_anadip";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HBPZQIPSZE",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0),CPLib.GetLinkedFieldProps("DESCRIZ","xDESDIPE","C",30,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_chkrapporto,arrt_knarapbo,arrt_numopecoll,arrt_writelog,fwfn_calc_categoria,
  public static final String i_InvokedRoutines = ",arfn_chkrapporto,arrt_knarapbo,arrt_numopecoll,arrt_writelog,fwfn_calc_categoria,";
}
