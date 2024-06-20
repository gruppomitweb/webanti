// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_tbmacageBO extends armt_tbmacageBL {
  class SqlLoader {
    public boolean m_bLink_1_16 = false;
    public boolean m_bLink_1_24 = false;
    public boolean m_bLink_1_45 = false;
    public boolean m_bLink_1_60 = false;
    public boolean m_bLink_1_76 = false;
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
        m_cSelect = m_cSelect+" ,link_1_16.CODDIP AS CODDIP116";
        m_cSelect = m_cSelect+" ,link_1_16.DESCRIZ AS DESCRIZ116";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_16","MADIPSTD","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_16","MADIPSTD","CODDIP",true);
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
    public void AddJoinedLink_1_24(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_24.CODSTA AS CODSTA124";
        m_cSelect = m_cSelect+" ,link_1_24.DESCRI AS DESCRI124";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_24","MARESSDEF","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_24","MARESSDEF","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_24 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_45(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_45.CODSTA AS CODSTA145";
        m_cSelect = m_cSelect+" ,link_1_45.DESCRI AS DESCRI145";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_45","MARESPAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_45","MARESPAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_45 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_60(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_60.CODSTA AS CODSTA160";
        m_cSelect = m_cSelect+" ,link_1_60.DESCRI AS DESCRI160";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_60","MADOMPAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_60","MADOMPAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_60 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_76(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_76.CODSTA AS CODSTA176";
        m_cSelect = m_cSelect+" ,link_1_76.DESCRI AS DESCRI176";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_76","MARESPAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_76","MARESPAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_76 = true;
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
  public armt_tbmacageBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_tbmacage");
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
      l_bResult = CanSaveChild(ardt_ageresleg,m_cWv_ardt_ageresleg,"m_cWv_ardt_ageresleg");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_ageresleg.m_cLastMsgError;
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
          if ( ! (ardt_ageresleg.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_ageresleg)) {
            ardt_ageresleg.SetFromContext(m_cWv_ardt_ageresleg);
            m_cWv_ardt_ageresleg = "_not_empty_";
          }
          if (ardt_ageresleg.IsUpdated()) {
            ardt_ageresleg.w_CODMAGE = w_MACODICE;
            if ( ! (ardt_ageresleg.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"MACODICE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_MACODICE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_tbmacage,m_cPhName_tbmacage,m_cVirtName_tbmacage,m_cVirtName_tbmacage+".MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_MACODICE,"C",5,0),m_cServer_tbmacage,p_MACODICE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_16(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_24(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_45(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_60(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_76(m_cPhName_tbstati,m_cServer_tbstati);
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
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_xDESDIP = "";
        w_despaese = "";
        w_xDESSTARES = "";
        w_xDESSTADOM = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_MACODICE = l_rsLoad.GetString("MACODICE");
        w_MADESCRI = l_rsLoad.GetString("MADESCRI");
        w_MAFLGRAP = l_rsLoad.GetString("MAFLGRAP");
        w_MAFLGOPE = l_rsLoad.GetString("MAFLGOPE");
        w_MAFLGBON = l_rsLoad.GetString("MAFLGBON");
        w_MAFLGCKR = l_rsLoad.GetString("MAFLGCKR");
        w_MAFLGASR = l_rsLoad.GetString("MAFLGASR");
        w_MAFLGNOX = l_rsLoad.GetString("MAFLGNOX");
        w_MADIPSTD = l_rsLoad.GetString("MADIPSTD");
        if (l_oSqlLoader.m_bLink_1_16) {
          w_xDESDIP = l_rsLoad.GetString("DESCRIZ116");
        } else {
          Link_LRWPVABXRO("Load");
        }
        w_MANAIDWU = l_rsLoad.GetString("MANAIDWU");
        w_MAFLGCHKDAT = l_rsLoad.GetString("MAFLGCHKDAT");
        w_MAFLGACT = l_rsLoad.GetString("MAFLGACT");
        w_MARESSDEF = l_rsLoad.GetString("MARESSDEF");
        if (l_oSqlLoader.m_bLink_1_24) {
          w_despaese = l_rsLoad.GetString("DESCRI124");
        } else {
          Link_XDJMLPLVUM("Load");
        }
        w_MAFLGAUA = l_rsLoad.GetString("MAFLGAUA");
        w_MATIPAGE = l_rsLoad.GetString("MATIPAGE");
        w_MAFISGIU = l_rsLoad.GetString("MAFISGIU");
        w_MADATINI = l_rsLoad.GetDate("MADATINI");
        w_MADATFIN = l_rsLoad.GetDate("MADATFIN");
        w_MADATMOD = l_rsLoad.GetDate("MADATMOD");
        w_MACODFIS = l_rsLoad.GetString("MACODFIS");
        w_MACOGNOME = l_rsLoad.GetString("MACOGNOME");
        w_MANOME = l_rsLoad.GetString("MANOME");
        w_MARESPAESE = l_rsLoad.GetString("MARESPAESE");
        if (l_oSqlLoader.m_bLink_1_45) {
          w_xDESSTARES = l_rsLoad.GetString("DESCRI145");
        } else {
          Link_BFMOWHWVBP("Load");
        }
        w_MARESCITTA = l_rsLoad.GetString("MARESCITTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_MARESCAP = l_rsLoad.GetString("MARESCAP");
        w_MARESPRV = l_rsLoad.GetString("MARESPRV");
        w_MARESIND = l_rsLoad.GetString("MARESIND");
        w_MARESNCIV = l_rsLoad.GetString("MARESNCIV");
        w_MADOMPAESE = l_rsLoad.GetString("MADOMPAESE");
        if (l_oSqlLoader.m_bLink_1_60) {
          w_xDESSTADOM = l_rsLoad.GetString("DESCRI160");
        } else {
          Link_DJVPNMOUXM("Load");
        }
        w_MADOMCITTA = l_rsLoad.GetString("MADOMCITTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_MADOMCAP = l_rsLoad.GetString("MADOMCAP");
        w_MADOMPRV = l_rsLoad.GetString("MADOMPRV");
        w_MADOMIND = l_rsLoad.GetString("MADOMIND");
        w_MADOMNCIV = l_rsLoad.GetString("MADOMNCIV");
        w_MARESPAESE = l_rsLoad.GetString("MARESPAESE");
        if (l_oSqlLoader.m_bLink_1_76) {
          w_xDESSTARES = l_rsLoad.GetString("DESCRI176");
        } else {
          Link_HSKILYGZSO("Load");
        }
        w_MARESCITTA = l_rsLoad.GetString("MARESCITTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_MARESIND = l_rsLoad.GetString("MARESIND");
        w_MARESNCIV = l_rsLoad.GetString("MARESNCIV");
        w_MARESCAP = l_rsLoad.GetString("MARESCAP");
        w_MARESPRV = l_rsLoad.GetString("MARESPRV");
        w_MAFLGCOMPL = l_rsLoad.GetDouble("MAFLGCOMPL");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_ageresleg = "";
        ardt_ageresleg.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"tbmacage")) {
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
    return Load(w_MACODICE);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_tbmacage);
      l_cSql = "insert into "+m_oWrInfo_tbmacage.GetTableWriteName()+" (";
      l_cSql = l_cSql+"MACODICE,";
      l_cSql = l_cSql+"MADESCRI,";
      l_cSql = l_cSql+"MAFLGRAP,";
      l_cSql = l_cSql+"MAFLGOPE,";
      l_cSql = l_cSql+"MAFLGBON,";
      l_cSql = l_cSql+"MAFLGCKR,";
      l_cSql = l_cSql+"MAFLGASR,";
      l_cSql = l_cSql+"MAFLGNOX,";
      l_cSql = l_cSql+"MADIPSTD,";
      l_cSql = l_cSql+"MANAIDWU,";
      l_cSql = l_cSql+"MAFLGCHKDAT,";
      l_cSql = l_cSql+"MAFLGACT,";
      l_cSql = l_cSql+"MARESSDEF,";
      l_cSql = l_cSql+"MAFLGAUA,";
      l_cSql = l_cSql+"MATIPAGE,";
      l_cSql = l_cSql+"MAFISGIU,";
      l_cSql = l_cSql+"MADATINI,";
      l_cSql = l_cSql+"MADATFIN,";
      l_cSql = l_cSql+"MADATMOD,";
      l_cSql = l_cSql+"MACODFIS,";
      l_cSql = l_cSql+"MACOGNOME,";
      l_cSql = l_cSql+"MANOME,";
      l_cSql = l_cSql+"MARESPAESE,";
      l_cSql = l_cSql+"MARESCITTA,";
      l_cSql = l_cSql+"MARESCAP,";
      l_cSql = l_cSql+"MARESPRV,";
      l_cSql = l_cSql+"MARESIND,";
      l_cSql = l_cSql+"MARESNCIV,";
      l_cSql = l_cSql+"MADOMPAESE,";
      l_cSql = l_cSql+"MADOMCITTA,";
      l_cSql = l_cSql+"MADOMCAP,";
      l_cSql = l_cSql+"MADOMPRV,";
      l_cSql = l_cSql+"MADOMIND,";
      l_cSql = l_cSql+"MADOMNCIV,";
      l_cSql = l_cSql+"MAFLGCOMPL,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_tbmacage.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbmacage")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_MACODICE,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADESCRI,"C",120,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGOPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGBON,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGCKR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGASR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGNOX,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MADIPSTD,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MANAIDWU,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGCHKDAT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGACT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MARESSDEF,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGAUA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MATIPAGE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFISGIU,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADATINI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADATFIN,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADATMOD,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MACODFIS,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MACOGNOME,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MANOME,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MARESPAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MARESCITTA,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MARESCAP,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MARESPRV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MARESIND,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MARESNCIV,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MADOMPAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADOMCITTA,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADOMCAP,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADOMPRV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADOMIND,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MADOMNCIV,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAFLGCOMPL,"N",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_tbmacage.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbmacage")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_tbmacage,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_tbmacage);
      l_cSql = "Update "+m_oWrInfo_tbmacage.GetTableWriteName()+" set";
      l_cSql = l_cSql+" MADESCRI = "+CPLib.ToSQL(w_MADESCRI,"C",120,0);
      l_cSql = l_cSql+", MAFLGRAP = "+CPLib.ToSQL(w_MAFLGRAP,"C",1,0);
      l_cSql = l_cSql+", MAFLGOPE = "+CPLib.ToSQL(w_MAFLGOPE,"C",1,0);
      l_cSql = l_cSql+", MAFLGBON = "+CPLib.ToSQL(w_MAFLGBON,"C",1,0);
      l_cSql = l_cSql+", MAFLGCKR = "+CPLib.ToSQL(w_MAFLGCKR,"C",1,0);
      l_cSql = l_cSql+", MAFLGASR = "+CPLib.ToSQL(w_MAFLGASR,"C",1,0);
      l_cSql = l_cSql+", MAFLGNOX = "+CPLib.ToSQL(w_MAFLGNOX,"C",1,0);
      l_cSql = l_cSql+", MADIPSTD = "+CPLib.ToSQLNull(w_MADIPSTD,"C",6,0);
      l_cSql = l_cSql+", MANAIDWU = "+CPLib.ToSQL(w_MANAIDWU,"C",5,0);
      l_cSql = l_cSql+", MAFLGCHKDAT = "+CPLib.ToSQL(w_MAFLGCHKDAT,"C",1,0);
      l_cSql = l_cSql+", MAFLGACT = "+CPLib.ToSQL(w_MAFLGACT,"C",1,0);
      l_cSql = l_cSql+", MARESSDEF = "+CPLib.ToSQLNull(w_MARESSDEF,"C",3,0);
      l_cSql = l_cSql+", MAFLGAUA = "+CPLib.ToSQL(w_MAFLGAUA,"C",1,0);
      l_cSql = l_cSql+", MATIPAGE = "+CPLib.ToSQL(w_MATIPAGE,"C",1,0);
      l_cSql = l_cSql+", MAFISGIU = "+CPLib.ToSQL(w_MAFISGIU,"C",1,0);
      l_cSql = l_cSql+", MADATINI = "+CPLib.ToSQL(w_MADATINI,"D",8,0);
      l_cSql = l_cSql+", MADATFIN = "+CPLib.ToSQL(w_MADATFIN,"D",8,0);
      l_cSql = l_cSql+", MADATMOD = "+CPLib.ToSQL(w_MADATMOD,"D",8,0);
      l_cSql = l_cSql+", MACODFIS = "+CPLib.ToSQL(w_MACODFIS,"C",16,0);
      l_cSql = l_cSql+", MACOGNOME = "+CPLib.ToSQL(w_MACOGNOME,"C",50,0);
      l_cSql = l_cSql+", MANOME = "+CPLib.ToSQL(w_MANOME,"C",50,0);
      l_cSql = l_cSql+", MARESPAESE = "+CPLib.ToSQLNull(w_MARESPAESE,"C",3,0);
      l_cSql = l_cSql+", MARESCITTA = "+CPLib.ToSQL(w_MARESCITTA,"C",60,0);
      l_cSql = l_cSql+", MARESCAP = "+CPLib.ToSQL(w_MARESCAP,"C",15,0);
      l_cSql = l_cSql+", MARESPRV = "+CPLib.ToSQL(w_MARESPRV,"C",2,0);
      l_cSql = l_cSql+", MARESIND = "+CPLib.ToSQL(w_MARESIND,"C",50,0);
      l_cSql = l_cSql+", MARESNCIV = "+CPLib.ToSQL(w_MARESNCIV,"C",15,0);
      l_cSql = l_cSql+", MADOMPAESE = "+CPLib.ToSQLNull(w_MADOMPAESE,"C",3,0);
      l_cSql = l_cSql+", MADOMCITTA = "+CPLib.ToSQL(w_MADOMCITTA,"C",60,0);
      l_cSql = l_cSql+", MADOMCAP = "+CPLib.ToSQL(w_MADOMCAP,"C",15,0);
      l_cSql = l_cSql+", MADOMPRV = "+CPLib.ToSQL(w_MADOMPRV,"C",2,0);
      l_cSql = l_cSql+", MADOMIND = "+CPLib.ToSQL(w_MADOMIND,"C",50,0);
      l_cSql = l_cSql+", MADOMNCIV = "+CPLib.ToSQL(w_MADOMNCIV,"C",15,0);
      l_cSql = l_cSql+", MAFLGCOMPL = "+CPLib.ToSQL(w_MAFLGCOMPL,"N",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbmacage")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACODICE,"C",5,0),m_cServer_tbmacage,w_MACODICE);
      l_cSql = l_cSql+m_oWrInfo_tbmacage.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbmacage")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_tbmacage,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_MACODICE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_MACODICE);
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
          ardt_ageresleg.w_CODMAGE = w_MACODICE;
          ardt_ageresleg.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_tbmacage.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"MACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_MACODICE,"C",5,0),m_cServer_tbmacage,w_MACODICE);
          l_cSql = l_cSql+m_oWrInfo_tbmacage.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"tbmacage")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_tbmacage,l_cSql);
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
    return Delete(w_MACODICE);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"LRWPVABXRO")) {
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
      result.AppendFieldsHash("LRWPVABXRO",CPLib.GetLinkedFieldProps("CODDIP","MADIPSTD","C",6,0));
      result.AppendFilter("MACROAGENTE","C","=",false);
    } else if (CPLib.eq(p_cID,"XDJMLPLVUM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 10;
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XDJMLPLVUM",CPLib.GetLinkedFieldProps("CODSTA","MARESSDEF","C",3,0));
    } else if (CPLib.eq(p_cID,"BFMOWHWVBP")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_stati";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BFMOWHWVBP",CPLib.GetLinkedFieldProps("CODSTA","MARESPAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"ODQOMCYUIH")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAP" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ODQOMCYUIH",CPLib.GetLinkedFieldProps("CITTA","MARESCITTA","C",60,0));
    } else if (CPLib.eq(p_cID,"DJVPNMOUXM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_stati";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DJVPNMOUXM",CPLib.GetLinkedFieldProps("CODSTA","MADOMPAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"UUHMAJHIGT")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAP" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UUHMAJHIGT",CPLib.GetLinkedFieldProps("CITTA","MADOMCITTA","C",60,0));
    } else if (CPLib.eq(p_cID,"HSKILYGZSO")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_stati";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HSKILYGZSO",CPLib.GetLinkedFieldProps("CODSTA","MARESPAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"NHXACJTYPN")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAP" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NHXACJTYPN",CPLib.GetLinkedFieldProps("CITTA","MARESCITTA","C",60,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
