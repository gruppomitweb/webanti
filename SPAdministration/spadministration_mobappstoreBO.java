// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_mobappstoreBO extends spadministration_mobappstoreBL {
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
  public spadministration_mobappstoreBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"spadministration_mobappstore");
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
      l_bResult = CanSaveChild(spadministration_dmobapp_qkm,m_cWv_spadministration_dmobapp_qkm,"m_cWv_spadministration_dmobapp_qkm");
      if (l_bResult) {
        l_bResult = CanSaveChild(spadministration_mobapppermissions,m_cWv_spadministration_mobapppermissions,"m_cWv_spadministration_mobapppermissions");
        if (l_bResult) {
          l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
        } else {
          m_cLastMsgError = spadministration_mobapppermissions.m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = spadministration_dmobapp_qkm.m_cLastMsgError;
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
          if ( ! (spadministration_dmobapp_qkm.IsUpdated()) && CPLib.IsUpdated(m_cWv_spadministration_dmobapp_qkm)) {
            spadministration_dmobapp_qkm.SetFromContext(m_cWv_spadministration_dmobapp_qkm);
            m_cWv_spadministration_dmobapp_qkm = "_not_empty_";
          }
          if (spadministration_dmobapp_qkm.IsUpdated()) {
            spadministration_dmobapp_qkm.w_QA_CODE = w_oa__code;
            if ( ! (spadministration_dmobapp_qkm.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (spadministration_mobapppermissions.IsUpdated()) && CPLib.IsUpdated(m_cWv_spadministration_mobapppermissions)) {
            spadministration_mobapppermissions.SetFromContext(m_cWv_spadministration_mobapppermissions);
            m_cWv_spadministration_mobapppermissions = "_not_empty_";
          }
          if (spadministration_mobapppermissions.IsUpdated()) {
            spadministration_mobapppermissions.w_pecodice = w_oa__code;
            if ( ! (spadministration_mobapppermissions.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"oa__code"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_oa__code) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cpappstore,m_cPhName_cpappstore,m_cVirtName_cpappstore,m_cVirtName_cpappstore+".oa__code="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_oa__code,"C",10,0),m_cServer_cpappstore,p_oa__code),"");
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
        w_changeSkin = false;
        w_custom_homelink = "";
        w_forceCreateFile = false;
        w_ignoreFile = false;
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_oa__code = l_rsLoad.GetString("oa__code");
        op_oa__code = w_oa__code;
        w_oaapppublished = l_rsLoad.GetDouble("oaapppublished");
        w_oareserved = l_rsLoad.GetString("oareserved");
        w_oaappmenu = l_rsLoad.GetString("oaappmenu");
        w_oaapptitle = l_rsLoad.GetString("oaapptitle");
        w_oadescri = l_rsLoad.GetString("oadescri");
        w_oaapplogo = l_rsLoad.GetString("oaapplogo");
        w_oaappfavico = l_rsLoad.GetString("oaappfavico");
        w_oaapplanding = l_rsLoad.GetString("oaapplanding");
        w_oaskinname = l_rsLoad.GetString("oaskinname");
        w_oaappvariantname = l_rsLoad.GetString("oaappvariantname");
        w_oaappheader = l_rsLoad.GetString("oaappheader");
        w_oaappdescrheader = l_rsLoad.GetString("oaappdescrheader");
        w_oaapphideutilitygroup = l_rsLoad.GetDouble("oaapphideutilitygroup");
        w_oaapphomelink = l_rsLoad.GetString("oaapphomelink");
        w_combo_homelink = 1;
        w_oaappchecksum = l_rsLoad.GetString("oaappchecksum");
        w_OAAPPACCESSMODE = l_rsLoad.GetString("OAAPPACCESSMODE");
        w_oaappdevtyp = l_rsLoad.GetString("oaappdevtyp");
        w_oaappreqreg = l_rsLoad.GetDouble("oaappreqreg");
        w_oaappurlreg = l_rsLoad.GetString("oaappurlreg");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_spadministration_dmobapp_qkm = "";
        spadministration_dmobapp_qkm.m_lCtxLoaded = false;
        m_cWv_spadministration_mobapppermissions = "";
        spadministration_mobapppermissions.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappstore")) {
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
    return Load(w_oa__code);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cpappstore);
      l_cSql = "insert into "+m_oWrInfo_cpappstore.GetTableWriteName()+" (";
      l_cSql = l_cSql+"oa__code,";
      l_cSql = l_cSql+"oaapppublished,";
      l_cSql = l_cSql+"oareserved,";
      l_cSql = l_cSql+"oaappmenu,";
      l_cSql = l_cSql+"oaapptitle,";
      l_cSql = l_cSql+"oadescri,";
      l_cSql = l_cSql+"oaapplogo,";
      l_cSql = l_cSql+"oaappfavico,";
      l_cSql = l_cSql+"oaapplanding,";
      l_cSql = l_cSql+"oaskinname,";
      l_cSql = l_cSql+"oaappvariantname,";
      l_cSql = l_cSql+"oaappheader,";
      l_cSql = l_cSql+"oaappdescrheader,";
      l_cSql = l_cSql+"oaapphideutilitygroup,";
      l_cSql = l_cSql+"oaapphomelink,";
      l_cSql = l_cSql+"oaappchecksum,";
      l_cSql = l_cSql+"OAAPPACCESSMODE,";
      l_cSql = l_cSql+"oaappdevtyp,";
      l_cSql = l_cSql+"oaappreqreg,";
      l_cSql = l_cSql+"oaappurlreg,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cpappstore.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappstore")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_oa__code,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaapppublished,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oareserved,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappmenu,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaapptitle,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oadescri,"M",10,0,m_cServer_cpappstore,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaapplogo,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappfavico,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaapplanding,"C",255,0,m_cServer_cpappstore,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaskinname,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappvariantname,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappheader,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappdescrheader,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaapphideutilitygroup,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaapphomelink,"C",255,0,m_cServer_cpappstore,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappchecksum,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OAAPPACCESSMODE,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappdevtyp,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappreqreg,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_oaappurlreg,"C",255,0,m_cServer_cpappstore,m_oParameters)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cpappstore.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappstore")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cpappstore,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cpappstore);
      l_cSql = "Update "+m_oWrInfo_cpappstore.GetTableWriteName()+" set";
      l_cSql = l_cSql+" oaapppublished = "+CPLib.ToSQL(w_oaapppublished,"N",1,0);
      l_cSql = l_cSql+", oareserved = "+CPLib.ToSQL(w_oareserved,"C",1,0);
      l_cSql = l_cSql+", oaappmenu = "+CPLib.ToSQL(w_oaappmenu,"C",100,0);
      l_cSql = l_cSql+", oaapptitle = "+CPLib.ToSQL(w_oaapptitle,"C",50,0);
      l_cSql = l_cSql+", oadescri = "+CPLib.ToSQL(w_oadescri,"M",10,0,m_cServer_cpappstore,m_oParameters);
      l_cSql = l_cSql+", oaapplogo = "+CPLib.ToSQL(w_oaapplogo,"C",50,0);
      l_cSql = l_cSql+", oaappfavico = "+CPLib.ToSQL(w_oaappfavico,"C",50,0);
      l_cSql = l_cSql+", oaapplanding = "+CPLib.ToSQL(w_oaapplanding,"C",255,0,m_cServer_cpappstore,m_oParameters);
      l_cSql = l_cSql+", oaskinname = "+CPLib.ToSQL(w_oaskinname,"C",30,0);
      l_cSql = l_cSql+", oaappvariantname = "+CPLib.ToSQL(w_oaappvariantname,"C",30,0);
      l_cSql = l_cSql+", oaappheader = "+CPLib.ToSQL(w_oaappheader,"C",50,0);
      l_cSql = l_cSql+", oaappdescrheader = "+CPLib.ToSQL(w_oaappdescrheader,"C",50,0);
      l_cSql = l_cSql+", oaapphideutilitygroup = "+CPLib.ToSQL(w_oaapphideutilitygroup,"N",1,0);
      l_cSql = l_cSql+", oaapphomelink = "+CPLib.ToSQL(w_oaapphomelink,"C",255,0,m_cServer_cpappstore,m_oParameters);
      l_cSql = l_cSql+", oaappchecksum = "+CPLib.ToSQL(w_oaappchecksum,"C",20,0);
      l_cSql = l_cSql+", OAAPPACCESSMODE = "+CPLib.ToSQL(w_OAAPPACCESSMODE,"C",30,0);
      l_cSql = l_cSql+", oaappdevtyp = "+CPLib.ToSQL(w_oaappdevtyp,"C",1,0);
      l_cSql = l_cSql+", oaappreqreg = "+CPLib.ToSQL(w_oaappreqreg,"N",1,0);
      l_cSql = l_cSql+", oaappurlreg = "+CPLib.ToSQL(w_oaappurlreg,"C",255,0,m_cServer_cpappstore,m_oParameters);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappstore")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"oa__code="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oa__code,"C",10,0),m_cServer_cpappstore,w_oa__code);
      l_cSql = l_cSql+m_oWrInfo_cpappstore.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappstore")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cpappstore,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_oa__code) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_oa__code);
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
          spadministration_dmobapp_qkm.w_QA_CODE = w_oa__code;
          spadministration_dmobapp_qkm.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio Gruppi/Utenti
          spadministration_mobapppermissions.w_pecodice = w_oa__code;
          spadministration_mobapppermissions.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_cpappstore.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"oa__code="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oa__code,"C",10,0),m_cServer_cpappstore,w_oa__code);
          l_cSql = l_cSql+m_oWrInfo_cpappstore.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cpappstore")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cpappstore,l_cSql);
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
    return Delete(w_oa__code);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a oa__code
    w_oa__code = CPLib.Left(w_oa__code,10)+CPLib.Space(10-CPLib.Len(w_oa__code));
    m_Sql.NextTableProg(this,"cpappstore","w_oa__code",m_cServer_cpappstore,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave oa__code, altrimenti non si riesce a linkare da zoom
    w_oa__code = CPLib.RTrim(w_oa__code);
    op_oa__code = w_oa__code;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,spadministration_checkmobappdir,spadministration_createmobappdir,spadministration_deletemobappdir,
  public static final String i_InvokedRoutines = ",spadministration_checkmobappdir,spadministration_createmobappdir,spadministration_deletemobappdir,";
}
