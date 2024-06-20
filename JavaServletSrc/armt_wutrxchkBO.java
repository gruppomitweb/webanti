// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_wutrxchkBO extends armt_wutrxchkBL {
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
  public armt_wutrxchkBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_wutrxchk");
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
  public static String[] m_cLoadParameterNames = {"TRXCODPRG"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_TRXCODPRG) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_wutrxchk,m_cPhName_wutrxchk,m_cVirtName_wutrxchk,m_cVirtName_wutrxchk+".TRXCODPRG="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_TRXCODPRG,"N",15,0),m_cServer_wutrxchk,p_TRXCODPRG),"");
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
        w_TRXCODPRG = l_rsLoad.GetDouble("TRXCODPRG");
        op_TRXCODPRG = w_TRXCODPRG;
        w_TRXCOGNOM = l_rsLoad.GetString("TRXCOGNOM");
        w_TRXNOME = l_rsLoad.GetString("TRXNOME");
        w_TRXDOMICI = l_rsLoad.GetString("TRXDOMICI");
        w_TRXFLGCF = l_rsLoad.GetString("TRXFLGCF");
        w_TRXCODFIS = l_rsLoad.GetString("TRXCODFIS");
        w_TRXLUONAS = l_rsLoad.GetString("TRXLUONAS");
        w_TRXNUMDOC = l_rsLoad.GetString("TRXNUMDOC");
        w_TRXDATSCA = l_rsLoad.GetDate("TRXDATSCA");
        w_TRXDATRIL = l_rsLoad.GetDate("TRXDATRIL");
        w_TRXAUTRIL = l_rsLoad.GetString("TRXAUTRIL");
        w_TRXNAZRES = l_rsLoad.GetString("TRXNAZRES");
        w_TRXCITRES = l_rsLoad.GetString("TRXCITRES");
        w_TRXTIPDOC = l_rsLoad.GetString("TRXTIPDOC");
        w_TRXDATOPE = l_rsLoad.GetDate("TRXDATOPE");
        w_TRXFLGCON = l_rsLoad.GetString("TRXFLGCON");
        w_TRSSEGNO = l_rsLoad.GetString("TRSSEGNO");
        w_TRXIMPORTO = l_rsLoad.GetDouble("TRXIMPORTO");
        w_TRXCONTAN = l_rsLoad.GetDouble("TRXCONTAN");
        w_TRXUNIQUE = l_rsLoad.GetString("TRXUNIQUE");
        w_TRXCODDIP = l_rsLoad.GetString("TRXCODDIP");
        w_TRXCOGCON = l_rsLoad.GetString("TRXCOGCON");
        w_TRXNOMCON = l_rsLoad.GetString("TRXNOMCON");
        w_TRXDESTIN = l_rsLoad.GetString("TRXDESTIN");
        w_TRXMTCN = l_rsLoad.GetString("TRXMTCN");
        w_TRXDATNAS = l_rsLoad.GetDate("TRXDATNAS");
        w_TRXSESSO = l_rsLoad.GetString("TRXSESSO");
        w_TRXCODCAS = l_rsLoad.GetString("TRXCODCAS");
        w_TRXRECTYPE = l_rsLoad.GetString("TRXRECTYPE");
        w_TRXCODMAG = l_rsLoad.GetString("TRXCODMAG");
        w_TRXCODUNI = l_rsLoad.GetString("TRXCODUNI");
        w_TRXERROR01 = l_rsLoad.GetString("TRXERROR01");
        w_TRXERROR02 = l_rsLoad.GetString("TRXERROR02");
        w_TRXERROR03 = l_rsLoad.GetString("TRXERROR03");
        w_TRXERROR04 = l_rsLoad.GetString("TRXERROR04");
        w_TRXERROR05 = l_rsLoad.GetString("TRXERROR05");
        w_TRXERROR06 = l_rsLoad.GetString("TRXERROR06");
        w_TRXERROR07 = l_rsLoad.GetString("TRXERROR07");
        w_TRXERROR08 = l_rsLoad.GetString("TRXERROR08");
        w_TRXERROR09 = l_rsLoad.GetString("TRXERROR09");
        w_TRXERROR10 = l_rsLoad.GetString("TRXERROR10");
        w_TRXERROR11 = l_rsLoad.GetString("TRXERROR11");
        w_TRXERROR12 = l_rsLoad.GetString("TRXERROR12");
        w_TRXERROR13 = l_rsLoad.GetString("TRXERROR13");
        w_TRXERROR14 = l_rsLoad.GetString("TRXERROR14");
        w_TRXERROR15 = l_rsLoad.GetString("TRXERROR15");
        w_TRXERROR16 = l_rsLoad.GetString("TRXERROR16");
        w_TRXERROR17 = l_rsLoad.GetString("TRXERROR17");
        w_TRXERROR18 = l_rsLoad.GetString("TRXERROR18");
        w_TRXERROR19 = l_rsLoad.GetString("TRXERROR19");
        w_TRXERROR20 = l_rsLoad.GetString("TRXERROR20");
        w_TRXERROR21 = l_rsLoad.GetString("TRXERROR21");
        w_TRXERROR22 = l_rsLoad.GetString("TRXERROR22");
        w_TRXERROR23 = l_rsLoad.GetString("TRXERROR23");
        w_TRXERROR24 = l_rsLoad.GetString("TRXERROR24");
        w_TRXERROR25 = l_rsLoad.GetString("TRXERROR25");
        w_TRXERROR26 = l_rsLoad.GetString("TRXERROR26");
        w_TRXERROR27 = l_rsLoad.GetString("TRXERROR27");
        w_TRXERROR28 = l_rsLoad.GetString("TRXERROR28");
        w_TRXERROR29 = l_rsLoad.GetString("TRXERROR29");
        w_TRXERROR30 = l_rsLoad.GetString("TRXERROR30");
        w_TRXERROR31 = l_rsLoad.GetString("TRXERROR31");
        w_TRXERROR32 = l_rsLoad.GetString("TRXERROR32");
        w_TRXERROR33 = l_rsLoad.GetString("TRXERROR33");
        w_TRXERROR34 = l_rsLoad.GetString("TRXERROR34");
        w_TRXERROR35 = l_rsLoad.GetString("TRXERROR35");
        w_TRXERROR36 = l_rsLoad.GetString("TRXERROR36");
        w_TRXERROR37 = l_rsLoad.GetString("TRXERROR37");
        w_TRXERROR38 = l_rsLoad.GetString("TRXERROR38");
        w_TRXERROR39 = l_rsLoad.GetString("TRXERROR39");
        w_TRXERROR40 = l_rsLoad.GetString("TRXERROR40");
        w_TRXERROR41 = l_rsLoad.GetString("TRXERROR41");
        w_TRXERROR42 = l_rsLoad.GetString("TRXERROR42");
        w_TRXERROR43 = l_rsLoad.GetString("TRXERROR43");
        w_TRXERROR44 = l_rsLoad.GetString("TRXERROR44");
        w_TRXERROR45 = l_rsLoad.GetString("TRXERROR45");
        w_TRXERROR46 = l_rsLoad.GetString("TRXERROR46");
        w_TRXERROR47 = l_rsLoad.GetString("TRXERROR47");
        w_TRXERROR48 = l_rsLoad.GetString("TRXERROR48");
        w_TRXERROR49 = l_rsLoad.GetString("TRXERROR49");
        w_TRXERROR50 = l_rsLoad.GetString("TRXERROR50");
        w_TRXERRAUA01 = l_rsLoad.GetString("TRXERRAUA01");
        w_TRXERRAUA02 = l_rsLoad.GetString("TRXERRAUA02");
        w_TRXERRAUA03 = l_rsLoad.GetString("TRXERRAUA03");
        w_TRXERRAUA04 = l_rsLoad.GetString("TRXERRAUA04");
        w_TRXERRAUA05 = l_rsLoad.GetString("TRXERRAUA05");
        w_TRXERRAUA06 = l_rsLoad.GetString("TRXERRAUA06");
        w_TRXERRAUA07 = l_rsLoad.GetString("TRXERRAUA07");
        w_TRXERRAUA08 = l_rsLoad.GetString("TRXERRAUA08");
        w_TRXERRAUA09 = l_rsLoad.GetString("TRXERRAUA09");
        w_TRXERRAUA10 = l_rsLoad.GetString("TRXERRAUA10");
        w_TRXFLGAUI = l_rsLoad.GetString("TRXFLGAUI");
        w_TRXFLGAUA = l_rsLoad.GetString("TRXFLGAUA");
        w_TRXFLGFOR = l_rsLoad.GetString("TRXFLGFOR");
        w_TRXAUICHK = l_rsLoad.GetString("TRXAUICHK");
        w_TRXAUACHK = l_rsLoad.GetString("TRXAUACHK");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"wutrxchk")) {
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
    return Load(w_TRXCODPRG);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_wutrxchk);
      l_cSql = "insert into "+m_oWrInfo_wutrxchk.GetTableWriteName()+" (";
      l_cSql = l_cSql+"TRXCODPRG,";
      l_cSql = l_cSql+"TRXCOGNOM,";
      l_cSql = l_cSql+"TRXNOME,";
      l_cSql = l_cSql+"TRXDOMICI,";
      l_cSql = l_cSql+"TRXFLGCF,";
      l_cSql = l_cSql+"TRXCODFIS,";
      l_cSql = l_cSql+"TRXLUONAS,";
      l_cSql = l_cSql+"TRXNUMDOC,";
      l_cSql = l_cSql+"TRXDATSCA,";
      l_cSql = l_cSql+"TRXDATRIL,";
      l_cSql = l_cSql+"TRXAUTRIL,";
      l_cSql = l_cSql+"TRXNAZRES,";
      l_cSql = l_cSql+"TRXCITRES,";
      l_cSql = l_cSql+"TRXTIPDOC,";
      l_cSql = l_cSql+"TRXDATOPE,";
      l_cSql = l_cSql+"TRXFLGCON,";
      l_cSql = l_cSql+"TRSSEGNO,";
      l_cSql = l_cSql+"TRXIMPORTO,";
      l_cSql = l_cSql+"TRXCONTAN,";
      l_cSql = l_cSql+"TRXUNIQUE,";
      l_cSql = l_cSql+"TRXCODDIP,";
      l_cSql = l_cSql+"TRXCOGCON,";
      l_cSql = l_cSql+"TRXNOMCON,";
      l_cSql = l_cSql+"TRXDESTIN,";
      l_cSql = l_cSql+"TRXMTCN,";
      l_cSql = l_cSql+"TRXDATNAS,";
      l_cSql = l_cSql+"TRXSESSO,";
      l_cSql = l_cSql+"TRXCODCAS,";
      l_cSql = l_cSql+"TRXRECTYPE,";
      l_cSql = l_cSql+"TRXCODMAG,";
      l_cSql = l_cSql+"TRXCODUNI,";
      l_cSql = l_cSql+"TRXERROR01,";
      l_cSql = l_cSql+"TRXERROR02,";
      l_cSql = l_cSql+"TRXERROR03,";
      l_cSql = l_cSql+"TRXERROR04,";
      l_cSql = l_cSql+"TRXERROR05,";
      l_cSql = l_cSql+"TRXERROR06,";
      l_cSql = l_cSql+"TRXERROR07,";
      l_cSql = l_cSql+"TRXERROR08,";
      l_cSql = l_cSql+"TRXERROR09,";
      l_cSql = l_cSql+"TRXERROR10,";
      l_cSql = l_cSql+"TRXERROR11,";
      l_cSql = l_cSql+"TRXERROR12,";
      l_cSql = l_cSql+"TRXERROR13,";
      l_cSql = l_cSql+"TRXERROR14,";
      l_cSql = l_cSql+"TRXERROR15,";
      l_cSql = l_cSql+"TRXERROR16,";
      l_cSql = l_cSql+"TRXERROR17,";
      l_cSql = l_cSql+"TRXERROR18,";
      l_cSql = l_cSql+"TRXERROR19,";
      l_cSql = l_cSql+"TRXERROR20,";
      l_cSql = l_cSql+"TRXERROR21,";
      l_cSql = l_cSql+"TRXERROR22,";
      l_cSql = l_cSql+"TRXERROR23,";
      l_cSql = l_cSql+"TRXERROR24,";
      l_cSql = l_cSql+"TRXERROR25,";
      l_cSql = l_cSql+"TRXERROR26,";
      l_cSql = l_cSql+"TRXERROR27,";
      l_cSql = l_cSql+"TRXERROR28,";
      l_cSql = l_cSql+"TRXERROR29,";
      l_cSql = l_cSql+"TRXERROR30,";
      l_cSql = l_cSql+"TRXERROR31,";
      l_cSql = l_cSql+"TRXERROR32,";
      l_cSql = l_cSql+"TRXERROR33,";
      l_cSql = l_cSql+"TRXERROR34,";
      l_cSql = l_cSql+"TRXERROR35,";
      l_cSql = l_cSql+"TRXERROR36,";
      l_cSql = l_cSql+"TRXERROR37,";
      l_cSql = l_cSql+"TRXERROR38,";
      l_cSql = l_cSql+"TRXERROR39,";
      l_cSql = l_cSql+"TRXERROR40,";
      l_cSql = l_cSql+"TRXERROR41,";
      l_cSql = l_cSql+"TRXERROR42,";
      l_cSql = l_cSql+"TRXERROR43,";
      l_cSql = l_cSql+"TRXERROR44,";
      l_cSql = l_cSql+"TRXERROR45,";
      l_cSql = l_cSql+"TRXERROR46,";
      l_cSql = l_cSql+"TRXERROR47,";
      l_cSql = l_cSql+"TRXERROR48,";
      l_cSql = l_cSql+"TRXERROR49,";
      l_cSql = l_cSql+"TRXERROR50,";
      l_cSql = l_cSql+"TRXERRAUA01,";
      l_cSql = l_cSql+"TRXERRAUA02,";
      l_cSql = l_cSql+"TRXERRAUA03,";
      l_cSql = l_cSql+"TRXERRAUA04,";
      l_cSql = l_cSql+"TRXERRAUA05,";
      l_cSql = l_cSql+"TRXERRAUA06,";
      l_cSql = l_cSql+"TRXERRAUA07,";
      l_cSql = l_cSql+"TRXERRAUA08,";
      l_cSql = l_cSql+"TRXERRAUA09,";
      l_cSql = l_cSql+"TRXERRAUA10,";
      l_cSql = l_cSql+"TRXFLGAUI,";
      l_cSql = l_cSql+"TRXFLGAUA,";
      l_cSql = l_cSql+"TRXFLGFOR,";
      l_cSql = l_cSql+"TRXAUICHK,";
      l_cSql = l_cSql+"TRXAUACHK,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_wutrxchk.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wutrxchk")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODPRG,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCOGNOM,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNOME,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDOMICI,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGCF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODFIS,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXLUONAS,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNUMDOC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATSCA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATRIL,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXAUTRIL,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNAZRES,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCITRES,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXTIPDOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGCON,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRSSEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXIMPORTO,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCONTAN,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXUNIQUE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODDIP,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCOGCON,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNOMCON,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDESTIN,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXMTCN,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXSESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODCAS,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXRECTYPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODMAG,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODUNI,"C",18,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR01,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR02,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR03,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR04,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR05,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR06,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR07,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR08,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR09,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR10,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR11,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR12,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR13,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR14,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR15,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR16,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR17,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR18,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR19,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR20,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR21,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR22,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR23,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR24,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR25,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR26,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR27,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR28,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR29,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR30,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR31,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR32,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR33,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR34,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR35,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR36,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR37,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR38,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR39,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR40,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR41,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR42,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR43,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR44,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR45,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR46,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR47,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR48,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR49,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERROR50,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA01,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA02,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA03,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA04,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA05,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA06,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA07,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA08,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA09,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXERRAUA10,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUI,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGFOR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXAUICHK,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXAUACHK,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_wutrxchk.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wutrxchk")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_wutrxchk,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_wutrxchk);
      l_cSql = "Update "+m_oWrInfo_wutrxchk.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TRXCOGNOM = "+CPLib.ToSQL(w_TRXCOGNOM,"C",50,0);
      l_cSql = l_cSql+", TRXNOME = "+CPLib.ToSQL(w_TRXNOME,"C",50,0);
      l_cSql = l_cSql+", TRXDOMICI = "+CPLib.ToSQL(w_TRXDOMICI,"C",100,0);
      l_cSql = l_cSql+", TRXFLGCF = "+CPLib.ToSQL(w_TRXFLGCF,"C",1,0);
      l_cSql = l_cSql+", TRXCODFIS = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0);
      l_cSql = l_cSql+", TRXLUONAS = "+CPLib.ToSQL(w_TRXLUONAS,"C",50,0);
      l_cSql = l_cSql+", TRXNUMDOC = "+CPLib.ToSQL(w_TRXNUMDOC,"C",30,0);
      l_cSql = l_cSql+", TRXDATSCA = "+CPLib.ToSQL(w_TRXDATSCA,"D",8,0);
      l_cSql = l_cSql+", TRXDATRIL = "+CPLib.ToSQL(w_TRXDATRIL,"D",8,0);
      l_cSql = l_cSql+", TRXAUTRIL = "+CPLib.ToSQL(w_TRXAUTRIL,"C",50,0);
      l_cSql = l_cSql+", TRXNAZRES = "+CPLib.ToSQL(w_TRXNAZRES,"C",50,0);
      l_cSql = l_cSql+", TRXCITRES = "+CPLib.ToSQL(w_TRXCITRES,"C",50,0);
      l_cSql = l_cSql+", TRXTIPDOC = "+CPLib.ToSQL(w_TRXTIPDOC,"C",2,0);
      l_cSql = l_cSql+", TRXDATOPE = "+CPLib.ToSQL(w_TRXDATOPE,"D",8,0);
      l_cSql = l_cSql+", TRXFLGCON = "+CPLib.ToSQL(w_TRXFLGCON,"C",1,0);
      l_cSql = l_cSql+", TRSSEGNO = "+CPLib.ToSQL(w_TRSSEGNO,"C",1,0);
      l_cSql = l_cSql+", TRXIMPORTO = "+CPLib.ToSQL(w_TRXIMPORTO,"N",15,2);
      l_cSql = l_cSql+", TRXCONTAN = "+CPLib.ToSQL(w_TRXCONTAN,"N",15,2);
      l_cSql = l_cSql+", TRXUNIQUE = "+CPLib.ToSQL(w_TRXUNIQUE,"C",10,0);
      l_cSql = l_cSql+", TRXCODDIP = "+CPLib.ToSQL(w_TRXCODDIP,"C",10,0);
      l_cSql = l_cSql+", TRXCOGCON = "+CPLib.ToSQL(w_TRXCOGCON,"C",100,0);
      l_cSql = l_cSql+", TRXNOMCON = "+CPLib.ToSQL(w_TRXNOMCON,"C",100,0);
      l_cSql = l_cSql+", TRXDESTIN = "+CPLib.ToSQL(w_TRXDESTIN,"C",100,0);
      l_cSql = l_cSql+", TRXMTCN = "+CPLib.ToSQL(w_TRXMTCN,"C",10,0);
      l_cSql = l_cSql+", TRXDATNAS = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0);
      l_cSql = l_cSql+", TRXSESSO = "+CPLib.ToSQL(w_TRXSESSO,"C",1,0);
      l_cSql = l_cSql+", TRXCODCAS = "+CPLib.ToSQL(w_TRXCODCAS,"C",4,0);
      l_cSql = l_cSql+", TRXRECTYPE = "+CPLib.ToSQL(w_TRXRECTYPE,"C",1,0);
      l_cSql = l_cSql+", TRXCODMAG = "+CPLib.ToSQL(w_TRXCODMAG,"C",5,0);
      l_cSql = l_cSql+", TRXCODUNI = "+CPLib.ToSQL(w_TRXCODUNI,"C",18,0);
      l_cSql = l_cSql+", TRXERROR01 = "+CPLib.ToSQL(w_TRXERROR01,"C",80,0);
      l_cSql = l_cSql+", TRXERROR02 = "+CPLib.ToSQL(w_TRXERROR02,"C",80,0);
      l_cSql = l_cSql+", TRXERROR03 = "+CPLib.ToSQL(w_TRXERROR03,"C",80,0);
      l_cSql = l_cSql+", TRXERROR04 = "+CPLib.ToSQL(w_TRXERROR04,"C",80,0);
      l_cSql = l_cSql+", TRXERROR05 = "+CPLib.ToSQL(w_TRXERROR05,"C",80,0);
      l_cSql = l_cSql+", TRXERROR06 = "+CPLib.ToSQL(w_TRXERROR06,"C",80,0);
      l_cSql = l_cSql+", TRXERROR07 = "+CPLib.ToSQL(w_TRXERROR07,"C",80,0);
      l_cSql = l_cSql+", TRXERROR08 = "+CPLib.ToSQL(w_TRXERROR08,"C",80,0);
      l_cSql = l_cSql+", TRXERROR09 = "+CPLib.ToSQL(w_TRXERROR09,"C",80,0);
      l_cSql = l_cSql+", TRXERROR10 = "+CPLib.ToSQL(w_TRXERROR10,"C",80,0);
      l_cSql = l_cSql+", TRXERROR11 = "+CPLib.ToSQL(w_TRXERROR11,"C",80,0);
      l_cSql = l_cSql+", TRXERROR12 = "+CPLib.ToSQL(w_TRXERROR12,"C",80,0);
      l_cSql = l_cSql+", TRXERROR13 = "+CPLib.ToSQL(w_TRXERROR13,"C",80,0);
      l_cSql = l_cSql+", TRXERROR14 = "+CPLib.ToSQL(w_TRXERROR14,"C",80,0);
      l_cSql = l_cSql+", TRXERROR15 = "+CPLib.ToSQL(w_TRXERROR15,"C",80,0);
      l_cSql = l_cSql+", TRXERROR16 = "+CPLib.ToSQL(w_TRXERROR16,"C",80,0);
      l_cSql = l_cSql+", TRXERROR17 = "+CPLib.ToSQL(w_TRXERROR17,"C",80,0);
      l_cSql = l_cSql+", TRXERROR18 = "+CPLib.ToSQL(w_TRXERROR18,"C",80,0);
      l_cSql = l_cSql+", TRXERROR19 = "+CPLib.ToSQL(w_TRXERROR19,"C",80,0);
      l_cSql = l_cSql+", TRXERROR20 = "+CPLib.ToSQL(w_TRXERROR20,"C",80,0);
      l_cSql = l_cSql+", TRXERROR21 = "+CPLib.ToSQL(w_TRXERROR21,"C",80,0);
      l_cSql = l_cSql+", TRXERROR22 = "+CPLib.ToSQL(w_TRXERROR22,"C",80,0);
      l_cSql = l_cSql+", TRXERROR23 = "+CPLib.ToSQL(w_TRXERROR23,"C",80,0);
      l_cSql = l_cSql+", TRXERROR24 = "+CPLib.ToSQL(w_TRXERROR24,"C",80,0);
      l_cSql = l_cSql+", TRXERROR25 = "+CPLib.ToSQL(w_TRXERROR25,"C",80,0);
      l_cSql = l_cSql+", TRXERROR26 = "+CPLib.ToSQL(w_TRXERROR26,"C",80,0);
      l_cSql = l_cSql+", TRXERROR27 = "+CPLib.ToSQL(w_TRXERROR27,"C",80,0);
      l_cSql = l_cSql+", TRXERROR28 = "+CPLib.ToSQL(w_TRXERROR28,"C",80,0);
      l_cSql = l_cSql+", TRXERROR29 = "+CPLib.ToSQL(w_TRXERROR29,"C",80,0);
      l_cSql = l_cSql+", TRXERROR30 = "+CPLib.ToSQL(w_TRXERROR30,"C",80,0);
      l_cSql = l_cSql+", TRXERROR31 = "+CPLib.ToSQL(w_TRXERROR31,"C",80,0);
      l_cSql = l_cSql+", TRXERROR32 = "+CPLib.ToSQL(w_TRXERROR32,"C",80,0);
      l_cSql = l_cSql+", TRXERROR33 = "+CPLib.ToSQL(w_TRXERROR33,"C",80,0);
      l_cSql = l_cSql+", TRXERROR34 = "+CPLib.ToSQL(w_TRXERROR34,"C",80,0);
      l_cSql = l_cSql+", TRXERROR35 = "+CPLib.ToSQL(w_TRXERROR35,"C",80,0);
      l_cSql = l_cSql+", TRXERROR36 = "+CPLib.ToSQL(w_TRXERROR36,"C",80,0);
      l_cSql = l_cSql+", TRXERROR37 = "+CPLib.ToSQL(w_TRXERROR37,"C",80,0);
      l_cSql = l_cSql+", TRXERROR38 = "+CPLib.ToSQL(w_TRXERROR38,"C",80,0);
      l_cSql = l_cSql+", TRXERROR39 = "+CPLib.ToSQL(w_TRXERROR39,"C",80,0);
      l_cSql = l_cSql+", TRXERROR40 = "+CPLib.ToSQL(w_TRXERROR40,"C",80,0);
      l_cSql = l_cSql+", TRXERROR41 = "+CPLib.ToSQL(w_TRXERROR41,"C",80,0);
      l_cSql = l_cSql+", TRXERROR42 = "+CPLib.ToSQL(w_TRXERROR42,"C",80,0);
      l_cSql = l_cSql+", TRXERROR43 = "+CPLib.ToSQL(w_TRXERROR43,"C",80,0);
      l_cSql = l_cSql+", TRXERROR44 = "+CPLib.ToSQL(w_TRXERROR44,"C",80,0);
      l_cSql = l_cSql+", TRXERROR45 = "+CPLib.ToSQL(w_TRXERROR45,"C",80,0);
      l_cSql = l_cSql+", TRXERROR46 = "+CPLib.ToSQL(w_TRXERROR46,"C",80,0);
      l_cSql = l_cSql+", TRXERROR47 = "+CPLib.ToSQL(w_TRXERROR47,"C",80,0);
      l_cSql = l_cSql+", TRXERROR48 = "+CPLib.ToSQL(w_TRXERROR48,"C",80,0);
      l_cSql = l_cSql+", TRXERROR49 = "+CPLib.ToSQL(w_TRXERROR49,"C",80,0);
      l_cSql = l_cSql+", TRXERROR50 = "+CPLib.ToSQL(w_TRXERROR50,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA01 = "+CPLib.ToSQL(w_TRXERRAUA01,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA02 = "+CPLib.ToSQL(w_TRXERRAUA02,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA03 = "+CPLib.ToSQL(w_TRXERRAUA03,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA04 = "+CPLib.ToSQL(w_TRXERRAUA04,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA05 = "+CPLib.ToSQL(w_TRXERRAUA05,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA06 = "+CPLib.ToSQL(w_TRXERRAUA06,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA07 = "+CPLib.ToSQL(w_TRXERRAUA07,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA08 = "+CPLib.ToSQL(w_TRXERRAUA08,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA09 = "+CPLib.ToSQL(w_TRXERRAUA09,"C",80,0);
      l_cSql = l_cSql+", TRXERRAUA10 = "+CPLib.ToSQL(w_TRXERRAUA10,"C",80,0);
      l_cSql = l_cSql+", TRXFLGAUI = "+CPLib.ToSQL(w_TRXFLGAUI,"C",1,0);
      l_cSql = l_cSql+", TRXFLGAUA = "+CPLib.ToSQL(w_TRXFLGAUA,"C",1,0);
      l_cSql = l_cSql+", TRXFLGFOR = "+CPLib.ToSQL(w_TRXFLGFOR,"C",1,0);
      l_cSql = l_cSql+", TRXAUICHK = "+CPLib.ToSQL(w_TRXAUICHK,"C",1,0);
      l_cSql = l_cSql+", TRXAUACHK = "+CPLib.ToSQL(w_TRXAUACHK,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wutrxchk")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"TRXCODPRG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODPRG,"N",15,0),m_cServer_wutrxchk,w_TRXCODPRG);
      l_cSql = l_cSql+m_oWrInfo_wutrxchk.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wutrxchk")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_wutrxchk,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_TRXCODPRG) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_TRXCODPRG);
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
          l_cSql = "Delete from "+m_oWrInfo_wutrxchk.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"TRXCODPRG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODPRG,"N",15,0),m_cServer_wutrxchk,w_TRXCODPRG);
          l_cSql = l_cSql+m_oWrInfo_wutrxchk.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"wutrxchk")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_wutrxchk,l_cSql);
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
    return Delete(w_TRXCODPRG);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGRTRA","w_TRXCODPRG",m_cServer_wutrxchk,m_Ctx.GetCompany());
    op_TRXCODPRG = w_TRXCODPRG;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
