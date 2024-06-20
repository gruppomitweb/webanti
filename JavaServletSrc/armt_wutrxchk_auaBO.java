// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_wutrxchk_auaBO extends armt_wutrxchk_auaBL {
  class SqlLoader {
    public boolean m_bLink_1_18 = false;
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
        m_cSelect = m_cSelect+" ,link_1_18.WUTDCODICE AS WUTDCODICE118";
        m_cSelect = m_cSelect+" ,link_1_18.WUTDTIPDOC AS WUTDTIPDOC118";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_18","TRXTIPDOC","WUTDCODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_18","TRXTIPDOC","WUTDCODICE",true);
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
  public armt_wutrxchk_auaBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_wutrxchk_aua");
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
    l_oSqlLoader.AddJoinedLink_1_18(m_cPhName_wutipdoc,m_cServer_wutipdoc);
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
        w_doctype = "";
        w_xTRXPROVINCIA = "";
        w_xtipdoc = "";
        w_xtnumdoc = "";
        w_xDESCRIZ = "";
        w_xluonas = "";
        w_xMADESCRI = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_TRXCODPRG = l_rsLoad.GetDouble("TRXCODPRG");
        op_TRXCODPRG = w_TRXCODPRG;
        w_TRXCOGNOM = l_rsLoad.GetString("TRXCOGNOM");
        w_TRXNOME = l_rsLoad.GetString("TRXNOME");
        w_TRXFLGCF = l_rsLoad.GetString("TRXFLGCF");
        w_TRXCODFIS = l_rsLoad.GetString("TRXCODFIS");
        w_TRXLUONAS = l_rsLoad.GetString("TRXLUONAS");
        w_xTRXPROVINCIA = "";
        Link_CAICHGXWXW("Load");
        w_TRXNUMDOC = l_rsLoad.GetString("TRXNUMDOC");
        w_TRXDATSCA = l_rsLoad.GetDate("TRXDATSCA");
        w_TRXDATRIL = l_rsLoad.GetDate("TRXDATRIL");
        w_TRXTIPDOC = l_rsLoad.GetString("TRXTIPDOC");
        if (l_oSqlLoader.m_bLink_1_18) {
          w_doctype = l_rsLoad.GetString("WUTDTIPDOC118");
        } else {
          Link_TTQTFXMWFO("Load");
        }
        w_TRXMTCN = l_rsLoad.GetString("TRXMTCN");
        w_TRXDATNAS = l_rsLoad.GetDate("TRXDATNAS");
        w_TRXDATOPE = l_rsLoad.GetDate("TRXDATOPE");
        w_TRXSESSO = l_rsLoad.GetString("TRXSESSO");
        w_sesso = (CPLib.eq(w_TRXSESSO,"M")?"1":(CPLib.eq(w_TRXSESSO,"F")?"2":""));
        w_TRXNASSTATO = l_rsLoad.GetString("TRXNASSTATO");
        w_TRXNASCOMUN = l_rsLoad.GetString("TRXNASCOMUN");
        w_TRXFLGAUAQ1 = l_rsLoad.GetString("TRXFLGAUAQ1");
        w_TRXFLGAUAQ2 = l_rsLoad.GetString("TRXFLGAUAQ2");
        w_TRXFLGAUAQ3 = l_rsLoad.GetString("TRXFLGAUAQ3");
        w_TRXFLGAUAQ4 = l_rsLoad.GetString("TRXFLGAUAQ4");
        w_TRXFLGAUAQ5 = l_rsLoad.GetString("TRXFLGAUAQ5");
        w_TRXFLGAUA = l_rsLoad.GetString("TRXFLGAUA");
        w_TRXFLGFOR = l_rsLoad.GetString("TRXFLGFOR");
        w_TRXFORCE = l_rsLoad.GetString("TRXFORCE");
        w_TRXDATRICERCA = l_rsLoad.GetDate("TRXDATRICERCA");
        w_FLGDATIOLD = "N";
        w_TRXTFINLAV = l_rsLoad.GetDateTime("TRXTFINLAV");
        w_TRDFINLAV = l_rsLoad.GetDate("TRDFINLAV");
        w_TRFLGINLAV = l_rsLoad.GetString("TRFLGINLAV");
        w_TRXFLGAUA = l_rsLoad.GetString("TRXFLGAUA");
        w_TRXESITO = l_rsLoad.GetString("TRXESITO");
        w_TRXAUTRIL = l_rsLoad.GetString("TRXAUTRIL");
        w_TRXCODDIP = l_rsLoad.GetString("TRXCODDIP");
        w_xDESCRIZ = "";
        Link_HZPBCLSNRS("Load");
        w_finalized = "N";
        w_TRXUTENTE = l_rsLoad.GetDouble("TRXUTENTE");
        w_TRFLGINLAV = l_rsLoad.GetString("TRFLGINLAV");
        w_TRXTINILAV = l_rsLoad.GetDateTime("TRXTINILAV");
        w_TRXDINILAV = l_rsLoad.GetDate("TRXDINILAV");
        w_TRXFLGCON = l_rsLoad.GetString("TRXFLGCON");
        w_TRSSEGNO = l_rsLoad.GetString("TRSSEGNO");
        w_TRXIMPORTO = l_rsLoad.GetDouble("TRXIMPORTO");
        w_TRXCONTAN = l_rsLoad.GetDouble("TRXCONTAN");
        w_TRXUNIQUE = l_rsLoad.GetString("TRXUNIQUE");
        w_TRXCOGCON = l_rsLoad.GetString("TRXCOGCON");
        w_TRXNOMCON = l_rsLoad.GetString("TRXNOMCON");
        w_TRXDESTIN = l_rsLoad.GetString("TRXDESTIN");
        w_TRXCODCAS = l_rsLoad.GetString("TRXCODCAS");
        w_TRXRECTYPE = l_rsLoad.GetString("TRXRECTYPE");
        w_TRXCODMAG = l_rsLoad.GetString("TRXCODMAG");
        w_xMADESCRI = "";
        Link_UTFQIBBLAF("Load");
        w_TRXCODUNI = l_rsLoad.GetString("TRXCODUNI");
        w_TRXNAZRES = l_rsLoad.GetString("TRXNAZRES");
        // Link con tbstati non eseguito: riporta solo campi
        w_TRXCITRES = l_rsLoad.GetString("TRXCITRES");
        // Link con tbcitta non eseguito: riporta solo campi
        w_TRXDOMICI = l_rsLoad.GetString("TRXDOMICI");
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
      l_cSql = l_cSql+"TRXFLGCF,";
      l_cSql = l_cSql+"TRXCODFIS,";
      l_cSql = l_cSql+"TRXLUONAS,";
      l_cSql = l_cSql+"TRXNUMDOC,";
      l_cSql = l_cSql+"TRXDATSCA,";
      l_cSql = l_cSql+"TRXDATRIL,";
      l_cSql = l_cSql+"TRXTIPDOC,";
      l_cSql = l_cSql+"TRXMTCN,";
      l_cSql = l_cSql+"TRXDATNAS,";
      l_cSql = l_cSql+"TRXDATOPE,";
      l_cSql = l_cSql+"TRXSESSO,";
      l_cSql = l_cSql+"TRXNASSTATO,";
      l_cSql = l_cSql+"TRXNASCOMUN,";
      l_cSql = l_cSql+"TRXFLGAUAQ1,";
      l_cSql = l_cSql+"TRXFLGAUAQ2,";
      l_cSql = l_cSql+"TRXFLGAUAQ3,";
      l_cSql = l_cSql+"TRXFLGAUAQ4,";
      l_cSql = l_cSql+"TRXFLGAUAQ5,";
      l_cSql = l_cSql+"TRXFLGAUA,";
      l_cSql = l_cSql+"TRXFLGFOR,";
      l_cSql = l_cSql+"TRXFORCE,";
      l_cSql = l_cSql+"TRXDATRICERCA,";
      l_cSql = l_cSql+"TRXTFINLAV,";
      l_cSql = l_cSql+"TRDFINLAV,";
      l_cSql = l_cSql+"TRFLGINLAV,";
      l_cSql = l_cSql+"TRXESITO,";
      l_cSql = l_cSql+"TRXAUTRIL,";
      l_cSql = l_cSql+"TRXCODDIP,";
      l_cSql = l_cSql+"TRXUTENTE,";
      l_cSql = l_cSql+"TRXTINILAV,";
      l_cSql = l_cSql+"TRXDINILAV,";
      l_cSql = l_cSql+"TRXFLGCON,";
      l_cSql = l_cSql+"TRSSEGNO,";
      l_cSql = l_cSql+"TRXIMPORTO,";
      l_cSql = l_cSql+"TRXCONTAN,";
      l_cSql = l_cSql+"TRXUNIQUE,";
      l_cSql = l_cSql+"TRXCOGCON,";
      l_cSql = l_cSql+"TRXNOMCON,";
      l_cSql = l_cSql+"TRXDESTIN,";
      l_cSql = l_cSql+"TRXCODCAS,";
      l_cSql = l_cSql+"TRXRECTYPE,";
      l_cSql = l_cSql+"TRXCODMAG,";
      l_cSql = l_cSql+"TRXCODUNI,";
      l_cSql = l_cSql+"TRXNAZRES,";
      l_cSql = l_cSql+"TRXCITRES,";
      l_cSql = l_cSql+"TRXDOMICI,";
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
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGCF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODFIS,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TRXLUONAS,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNUMDOC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATSCA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATRIL,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TRXTIPDOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXMTCN,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXSESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNASSTATO,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNASCOMUN,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUAQ1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUAQ2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUAQ3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUAQ4,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUAQ5,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGAUA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGFOR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFORCE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDATRICERCA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXTFINLAV,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRDFINLAV,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRFLGINLAV,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXESITO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXAUTRIL,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TRXCODDIP,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXUTENTE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXTINILAV,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDINILAV,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXFLGCON,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRSSEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXIMPORTO,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCONTAN,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXUNIQUE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCOGCON,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXNOMCON,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDESTIN,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODCAS,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXRECTYPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TRXCODMAG,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXCODUNI,"C",18,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TRXNAZRES,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TRXCITRES,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TRXDOMICI,"C",100,0)+", ";
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
      l_cSql = l_cSql+", TRXFLGCF = "+CPLib.ToSQL(w_TRXFLGCF,"C",1,0);
      l_cSql = l_cSql+", TRXCODFIS = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0);
      l_cSql = l_cSql+", TRXLUONAS = "+CPLib.ToSQLNull(w_TRXLUONAS,"C",50,0);
      l_cSql = l_cSql+", TRXNUMDOC = "+CPLib.ToSQL(w_TRXNUMDOC,"C",30,0);
      l_cSql = l_cSql+", TRXDATSCA = "+CPLib.ToSQL(w_TRXDATSCA,"D",8,0);
      l_cSql = l_cSql+", TRXDATRIL = "+CPLib.ToSQL(w_TRXDATRIL,"D",8,0);
      l_cSql = l_cSql+", TRXTIPDOC = "+CPLib.ToSQLNull(w_TRXTIPDOC,"C",2,0);
      l_cSql = l_cSql+", TRXMTCN = "+CPLib.ToSQL(w_TRXMTCN,"C",10,0);
      l_cSql = l_cSql+", TRXDATNAS = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0);
      l_cSql = l_cSql+", TRXDATOPE = "+CPLib.ToSQL(w_TRXDATOPE,"D",8,0);
      l_cSql = l_cSql+", TRXSESSO = "+CPLib.ToSQL(w_TRXSESSO,"C",1,0);
      l_cSql = l_cSql+", TRXNASSTATO = "+CPLib.ToSQL(w_TRXNASSTATO,"C",40,0);
      l_cSql = l_cSql+", TRXNASCOMUN = "+CPLib.ToSQL(w_TRXNASCOMUN,"C",40,0);
      l_cSql = l_cSql+", TRXFLGAUAQ1 = "+CPLib.ToSQL(w_TRXFLGAUAQ1,"C",1,0);
      l_cSql = l_cSql+", TRXFLGAUAQ2 = "+CPLib.ToSQL(w_TRXFLGAUAQ2,"C",1,0);
      l_cSql = l_cSql+", TRXFLGAUAQ3 = "+CPLib.ToSQL(w_TRXFLGAUAQ3,"C",1,0);
      l_cSql = l_cSql+", TRXFLGAUAQ4 = "+CPLib.ToSQL(w_TRXFLGAUAQ4,"C",1,0);
      l_cSql = l_cSql+", TRXFLGAUAQ5 = "+CPLib.ToSQL(w_TRXFLGAUAQ5,"C",1,0);
      l_cSql = l_cSql+", TRXFLGAUA = "+CPLib.ToSQL(w_TRXFLGAUA,"C",1,0);
      l_cSql = l_cSql+", TRXFLGFOR = "+CPLib.ToSQL(w_TRXFLGFOR,"C",1,0);
      l_cSql = l_cSql+", TRXFORCE = "+CPLib.ToSQL(w_TRXFORCE,"C",3,0);
      l_cSql = l_cSql+", TRXDATRICERCA = "+CPLib.ToSQL(w_TRXDATRICERCA,"D",8,0);
      l_cSql = l_cSql+", TRXTFINLAV = "+CPLib.ToSQL(w_TRXTFINLAV,"T",14,0);
      l_cSql = l_cSql+", TRDFINLAV = "+CPLib.ToSQL(w_TRDFINLAV,"D",8,0);
      l_cSql = l_cSql+", TRFLGINLAV = "+CPLib.ToSQL(w_TRFLGINLAV,"C",1,0);
      l_cSql = l_cSql+", TRXESITO = "+CPLib.ToSQL(w_TRXESITO,"C",1,0);
      l_cSql = l_cSql+", TRXAUTRIL = "+CPLib.ToSQL(w_TRXAUTRIL,"C",50,0);
      l_cSql = l_cSql+", TRXCODDIP = "+CPLib.ToSQLNull(w_TRXCODDIP,"C",10,0);
      l_cSql = l_cSql+", TRXUTENTE = "+CPLib.ToSQL(w_TRXUTENTE,"N",10,0);
      l_cSql = l_cSql+", TRXTINILAV = "+CPLib.ToSQL(w_TRXTINILAV,"T",14,0);
      l_cSql = l_cSql+", TRXDINILAV = "+CPLib.ToSQL(w_TRXDINILAV,"D",8,0);
      l_cSql = l_cSql+", TRXFLGCON = "+CPLib.ToSQL(w_TRXFLGCON,"C",1,0);
      l_cSql = l_cSql+", TRSSEGNO = "+CPLib.ToSQL(w_TRSSEGNO,"C",1,0);
      l_cSql = l_cSql+", TRXIMPORTO = "+CPLib.ToSQL(w_TRXIMPORTO,"N",15,2);
      l_cSql = l_cSql+", TRXCONTAN = "+CPLib.ToSQL(w_TRXCONTAN,"N",15,2);
      l_cSql = l_cSql+", TRXUNIQUE = "+CPLib.ToSQL(w_TRXUNIQUE,"C",10,0);
      l_cSql = l_cSql+", TRXCOGCON = "+CPLib.ToSQL(w_TRXCOGCON,"C",100,0);
      l_cSql = l_cSql+", TRXNOMCON = "+CPLib.ToSQL(w_TRXNOMCON,"C",100,0);
      l_cSql = l_cSql+", TRXDESTIN = "+CPLib.ToSQL(w_TRXDESTIN,"C",100,0);
      l_cSql = l_cSql+", TRXCODCAS = "+CPLib.ToSQL(w_TRXCODCAS,"C",4,0);
      l_cSql = l_cSql+", TRXRECTYPE = "+CPLib.ToSQL(w_TRXRECTYPE,"C",1,0);
      l_cSql = l_cSql+", TRXCODMAG = "+CPLib.ToSQLNull(w_TRXCODMAG,"C",5,0);
      l_cSql = l_cSql+", TRXCODUNI = "+CPLib.ToSQL(w_TRXCODUNI,"C",18,0);
      l_cSql = l_cSql+", TRXNAZRES = "+CPLib.ToSQLNull(w_TRXNAZRES,"C",50,0);
      l_cSql = l_cSql+", TRXCITRES = "+CPLib.ToSQLNull(w_TRXCITRES,"C",50,0);
      l_cSql = l_cSql+", TRXDOMICI = "+CPLib.ToSQL(w_TRXDOMICI,"C",100,0);
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
    if (CPLib.eq(p_cID,"CAICHGXWXW")) {
      result.m_TableName = "tbluonas";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 10;
      result.m_rdField = new String[]{"DESCRI" , "PROVINCIA"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CAICHGXWXW",CPLib.GetLinkedFieldProps("DESCRI","TRXLUONAS","C",50,0));
    } else if (CPLib.eq(p_cID,"TTQTFXMWFO")) {
      result.m_TableName = "wutipdoc";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"WUTDCODICE" , "WUTDTIPDOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TTQTFXMWFO",CPLib.GetLinkedFieldProps("WUTDCODICE","TRXTIPDOC","C",2,0));
    } else if (CPLib.eq(p_cID,"HZPBCLSNRS")) {
      result.m_TableName = "anadip";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"AGACCODE" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HZPBCLSNRS",CPLib.GetLinkedFieldProps("AGACCODE","TRXCODDIP","C",10,0));
      result.AppendFilter("MACROAGENTE","C","=",true);
    } else if (CPLib.eq(p_cID,"UTFQIBBLAF")) {
      result.m_TableName = "tbmacage";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"MANAIDWU" , "MADESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UTFQIBBLAF",CPLib.GetLinkedFieldProps("MANAIDWU","TRXCODMAG","C",5,0));
    } else if (CPLib.eq(p_cID,"UUXGHAXWLH")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_stati";
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UUXGHAXWLH",CPLib.GetLinkedFieldProps("DESCRI","TRXNAZRES","C",50,0));
    } else if (CPLib.eq(p_cID,"XSZDOLIZKJ")) {
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
      result.AppendFieldsHash("XSZDOLIZKJ",CPLib.GetLinkedFieldProps("CITTA","TRXCITRES","C",50,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_chkcodfis,arrt_wu_autocorrect,arrt_wutrxchk_aua_exit,arrt_wutrxchk_save,arrt_wutrxchk_upddata,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arrt_wu_autocorrect,arrt_wutrxchk_aua_exit,arrt_wutrxchk_save,arrt_wutrxchk_upddata,";
}
