// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_vltplatBO extends armt_cgo_vltplatBL {
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
  public armt_cgo_vltplatBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_vltplat");
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
    // Se il record � stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'� gi� una, utilizza quella, altrimenti
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
  public static String[] m_cLoadParameterNames = {"VPCODICE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_VPCODICE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_vltplat,m_cPhName_cgo_vltplat,m_cVirtName_cgo_vltplat,m_cVirtName_cgo_vltplat+".VPCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_VPCODICE,"C",2,0),m_cServer_cgo_vltplat,p_VPCODICE),"");
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
        w_VPCODICE = l_rsLoad.GetString("VPCODICE");
        w_VPDESCRI = l_rsLoad.GetString("VPDESCRI");
        w_VPFLGATT = l_rsLoad.GetString("VPFLGATT");
        w_VPIDAAMS = l_rsLoad.GetString("VPIDAAMS");
        w_VPCODPIAT = l_rsLoad.GetDouble("VPCODPIAT");
        w_VPSIGLAPIAT = l_rsLoad.GetString("VPSIGLAPIAT");
        w_VPPROVENIENZA = l_rsLoad.GetString("VPPROVENIENZA");
        w_VPVLTCODPLAT = l_rsLoad.GetDouble("VPVLTCODPLAT");
        w_VPFLGCRYPTO = l_rsLoad.GetString("VPFLGCRYPTO");
        w_VFPKAYCRYPTO = l_rsLoad.GetString("VFPKAYCRYPTO");
        w_VPDIRFILE = l_rsLoad.GetString("VPDIRFILE");
        w_VPFILEINTESTA1 = l_rsLoad.GetString("VPFILEINTESTA1");
        w_VPFFILESPERATOR1 = l_rsLoad.GetString("VPFFILESPERATOR1");
        w_VPFILEFORDATA1 = l_rsLoad.GetString("VPFILEFORDATA1");
        w_VPPREFFILE1 = l_rsLoad.GetString("VPPREFFILE1");
        w_VPFILEINTESTA2 = l_rsLoad.GetString("VPFILEINTESTA2");
        w_VPFFILESPERATOR2 = l_rsLoad.GetString("VPFFILESPERATOR2");
        w_VPFILEFORDATA2 = l_rsLoad.GetString("VPFILEFORDATA2");
        w_VPPREFFILE2 = l_rsLoad.GetString("VPPREFFILE2");
        w_VPFILEINTESTA3 = l_rsLoad.GetString("VPFILEINTESTA3");
        w_VPFFILESPERATOR3 = l_rsLoad.GetString("VPFFILESPERATOR3");
        w_VPFILEFORDATA3 = l_rsLoad.GetString("VPFILEFORDATA3");
        w_VPPREFFILE3 = l_rsLoad.GetString("VPPREFFILE3");
        w_VPFLGPRESUF1 = l_rsLoad.GetString("VPFLGPRESUF1");
        w_VPFLGPRESUF2 = l_rsLoad.GetString("VPFLGPRESUF2");
        w_VPFLGPRESUF3 = l_rsLoad.GetString("VPFLGPRESUF3");
        w_VFPFLAGIMPORT = l_rsLoad.GetString("VFPFLAGIMPORT");
        w_VFPTIPOFILE1 = l_rsLoad.GetString("VFPTIPOFILE1");
        w_VFPTIPOFILE2 = l_rsLoad.GetString("VFPTIPOFILE2");
        w_VFPTIPOFILE3 = l_rsLoad.GetString("VFPTIPOFILE3");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_vltplat")) {
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
    return Load(w_VPCODICE);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_vltplat);
      l_cSql = "insert into "+m_oWrInfo_cgo_vltplat.GetTableWriteName()+" (";
      l_cSql = l_cSql+"VPCODICE,";
      l_cSql = l_cSql+"VPDESCRI,";
      l_cSql = l_cSql+"VPFLGATT,";
      l_cSql = l_cSql+"VPIDAAMS,";
      l_cSql = l_cSql+"VPCODPIAT,";
      l_cSql = l_cSql+"VPSIGLAPIAT,";
      l_cSql = l_cSql+"VPPROVENIENZA,";
      l_cSql = l_cSql+"VPVLTCODPLAT,";
      l_cSql = l_cSql+"VPFLGCRYPTO,";
      l_cSql = l_cSql+"VFPKAYCRYPTO,";
      l_cSql = l_cSql+"VPDIRFILE,";
      l_cSql = l_cSql+"VPFILEINTESTA1,";
      l_cSql = l_cSql+"VPFFILESPERATOR1,";
      l_cSql = l_cSql+"VPFILEFORDATA1,";
      l_cSql = l_cSql+"VPPREFFILE1,";
      l_cSql = l_cSql+"VPFILEINTESTA2,";
      l_cSql = l_cSql+"VPFFILESPERATOR2,";
      l_cSql = l_cSql+"VPFILEFORDATA2,";
      l_cSql = l_cSql+"VPPREFFILE2,";
      l_cSql = l_cSql+"VPFILEINTESTA3,";
      l_cSql = l_cSql+"VPFFILESPERATOR3,";
      l_cSql = l_cSql+"VPFILEFORDATA3,";
      l_cSql = l_cSql+"VPPREFFILE3,";
      l_cSql = l_cSql+"VPFLGPRESUF1,";
      l_cSql = l_cSql+"VPFLGPRESUF2,";
      l_cSql = l_cSql+"VPFLGPRESUF3,";
      l_cSql = l_cSql+"VFPFLAGIMPORT,";
      l_cSql = l_cSql+"VFPTIPOFILE1,";
      l_cSql = l_cSql+"VFPTIPOFILE2,";
      l_cSql = l_cSql+"VFPTIPOFILE3,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_vltplat.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_vltplat")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPCODICE,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPDESCRI,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFLGATT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPIDAAMS,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPCODPIAT,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPSIGLAPIAT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPPROVENIENZA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPVLTCODPLAT,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFLGCRYPTO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VFPKAYCRYPTO,"M",10,0,m_cServer_cgo_vltplat,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPDIRFILE,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFILEINTESTA1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFFILESPERATOR1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFILEFORDATA1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPPREFFILE1,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFILEINTESTA2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFFILESPERATOR2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFILEFORDATA2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPPREFFILE2,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFILEINTESTA3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFFILESPERATOR3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFILEFORDATA3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPPREFFILE3,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFLGPRESUF1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFLGPRESUF2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VPFLGPRESUF3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VFPFLAGIMPORT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VFPTIPOFILE1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VFPTIPOFILE2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VFPTIPOFILE3,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_vltplat.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_vltplat")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_vltplat,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_vltplat);
      l_cSql = "Update "+m_oWrInfo_cgo_vltplat.GetTableWriteName()+" set";
      l_cSql = l_cSql+" VPDESCRI = "+CPLib.ToSQL(w_VPDESCRI,"C",50,0);
      l_cSql = l_cSql+", VPFLGATT = "+CPLib.ToSQL(w_VPFLGATT,"C",1,0);
      l_cSql = l_cSql+", VPIDAAMS = "+CPLib.ToSQL(w_VPIDAAMS,"C",16,0);
      l_cSql = l_cSql+", VPCODPIAT = "+CPLib.ToSQL(w_VPCODPIAT,"N",4,0);
      l_cSql = l_cSql+", VPSIGLAPIAT = "+CPLib.ToSQL(w_VPSIGLAPIAT,"C",3,0);
      l_cSql = l_cSql+", VPPROVENIENZA = "+CPLib.ToSQL(w_VPPROVENIENZA,"C",1,0);
      l_cSql = l_cSql+", VPVLTCODPLAT = "+CPLib.ToSQL(w_VPVLTCODPLAT,"N",4,0);
      l_cSql = l_cSql+", VPFLGCRYPTO = "+CPLib.ToSQL(w_VPFLGCRYPTO,"C",1,0);
      l_cSql = l_cSql+", VFPKAYCRYPTO = "+CPLib.ToSQL(w_VFPKAYCRYPTO,"M",10,0,m_cServer_cgo_vltplat,m_oParameters);
      l_cSql = l_cSql+", VPDIRFILE = "+CPLib.ToSQL(w_VPDIRFILE,"C",30,0);
      l_cSql = l_cSql+", VPFILEINTESTA1 = "+CPLib.ToSQL(w_VPFILEINTESTA1,"C",1,0);
      l_cSql = l_cSql+", VPFFILESPERATOR1 = "+CPLib.ToSQL(w_VPFFILESPERATOR1,"C",1,0);
      l_cSql = l_cSql+", VPFILEFORDATA1 = "+CPLib.ToSQL(w_VPFILEFORDATA1,"C",1,0);
      l_cSql = l_cSql+", VPPREFFILE1 = "+CPLib.ToSQL(w_VPPREFFILE1,"C",30,0);
      l_cSql = l_cSql+", VPFILEINTESTA2 = "+CPLib.ToSQL(w_VPFILEINTESTA2,"C",1,0);
      l_cSql = l_cSql+", VPFFILESPERATOR2 = "+CPLib.ToSQL(w_VPFFILESPERATOR2,"C",1,0);
      l_cSql = l_cSql+", VPFILEFORDATA2 = "+CPLib.ToSQL(w_VPFILEFORDATA2,"C",1,0);
      l_cSql = l_cSql+", VPPREFFILE2 = "+CPLib.ToSQL(w_VPPREFFILE2,"C",30,0);
      l_cSql = l_cSql+", VPFILEINTESTA3 = "+CPLib.ToSQL(w_VPFILEINTESTA3,"C",1,0);
      l_cSql = l_cSql+", VPFFILESPERATOR3 = "+CPLib.ToSQL(w_VPFFILESPERATOR3,"C",1,0);
      l_cSql = l_cSql+", VPFILEFORDATA3 = "+CPLib.ToSQL(w_VPFILEFORDATA3,"C",1,0);
      l_cSql = l_cSql+", VPPREFFILE3 = "+CPLib.ToSQL(w_VPPREFFILE3,"C",30,0);
      l_cSql = l_cSql+", VPFLGPRESUF1 = "+CPLib.ToSQL(w_VPFLGPRESUF1,"C",1,0);
      l_cSql = l_cSql+", VPFLGPRESUF2 = "+CPLib.ToSQL(w_VPFLGPRESUF2,"C",1,0);
      l_cSql = l_cSql+", VPFLGPRESUF3 = "+CPLib.ToSQL(w_VPFLGPRESUF3,"C",1,0);
      l_cSql = l_cSql+", VFPFLAGIMPORT = "+CPLib.ToSQL(w_VFPFLAGIMPORT,"C",1,0);
      l_cSql = l_cSql+", VFPTIPOFILE1 = "+CPLib.ToSQL(w_VFPTIPOFILE1,"C",1,0);
      l_cSql = l_cSql+", VFPTIPOFILE2 = "+CPLib.ToSQL(w_VFPTIPOFILE2,"C",1,0);
      l_cSql = l_cSql+", VFPTIPOFILE3 = "+CPLib.ToSQL(w_VFPTIPOFILE3,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_vltplat")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"VPCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VPCODICE,"C",2,0),m_cServer_cgo_vltplat,w_VPCODICE);
      l_cSql = l_cSql+m_oWrInfo_cgo_vltplat.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_vltplat")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_vltplat,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_VPCODICE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_VPCODICE);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                    gestisce le transazioni trova che ce n'� gi� una, utilizza quella, altrimenti
                                    ne inizia una nuova ("begin transaction").
                                  */
        m_Sql.RequireTransaction();
        NotifyEvent("Delete start");
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_cgo_vltplat.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"VPCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_VPCODICE,"C",2,0),m_cServer_cgo_vltplat,w_VPCODICE);
          l_cSql = l_cSql+m_oWrInfo_cgo_vltplat.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_vltplat")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_vltplat,l_cSql);
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
    return Delete(w_VPCODICE);
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
