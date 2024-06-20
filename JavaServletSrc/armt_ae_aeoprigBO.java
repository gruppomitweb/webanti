// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_ae_aeoprigBO extends armt_ae_aeoprigBL {
  class SqlLoader {
    public boolean m_bLink_1_6 = false;
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
    public void AddJoinedLink_1_6(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_6.CONNES AS CONNES106";
        m_cSelect = m_cSelect+" ,link_1_6.RAGSOC AS RAGSOC106";
        m_cSelect = m_cSelect+" ,link_1_6.CFESTERO AS CFESTERO106";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_6","CONNESINT","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_6","CONNESINT","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_6 = true;
          m_nColumns = m_nColumns+3;
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
  public armt_ae_aeoprigBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_ae_aeoprig");
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
  public static String[] m_cLoadParameterNames = {"IDBASE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDBASE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_aeoprig,m_cPhName_aeoprig,m_cVirtName_aeoprig,m_cVirtName_aeoprig+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_aeoprig,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_6(m_cPhName_personbo,m_cServer_personbo);
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
        w_xragsoc = "";
        w_dtcanc = CPLib.NullDate();
        w_spcanc = 0;
        w_filecanc = "";
        w_idcanc = "";
        w_xcfestero = 0;
        w_desctrap = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        w_COINT = l_rsLoad.GetString("COINT");
        w_TIPOAG = l_rsLoad.GetString("TIPOAG");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        op_IDBASE = w_IDBASE;
        w_CONNESINT = l_rsLoad.GetString("CONNESINT");
        if (l_oSqlLoader.m_bLink_1_6) {
          w_xragsoc = l_rsLoad.GetString("RAGSOC106");
          w_xcfestero = l_rsLoad.GetDouble("CFESTERO106");
        } else {
          Link_DZWSXMBIHR("Load");
        }
        w_ADATA = l_rsLoad.GetDate("ADATA");
        w_ADATARET = l_rsLoad.GetDate("ADATARET");
        w_ASPEDITO = l_rsLoad.GetDouble("ASPEDITO");
        w_AFILE = l_rsLoad.GetString("AFILE");
        w_APROG = l_rsLoad.GetString("APROG");
        w_AOLDPROG = l_rsLoad.GetString("AOLDPROG");
        w_AOLDFILE = l_rsLoad.GetString("AOLDFILE");
        w_CSPEDITO = l_rsLoad.GetDouble("CSPEDITO");
        w_CPROG = l_rsLoad.GetString("CPROG");
        w_COLDPROG = l_rsLoad.GetString("COLDPROG");
        w_CFILE = l_rsLoad.GetString("CFILE");
        w_COLDFILE = l_rsLoad.GetString("COLDFILE");
        w_IDRIF = l_rsLoad.GetString("IDRIF");
        w_ADTPRE = l_rsLoad.GetDate("ADTPRE");
        w_CDTPRE = l_rsLoad.GetDate("CDTPRE");
        w_CDATA = l_rsLoad.GetDate("CDATA");
        w_CDATARET = l_rsLoad.GetDate("CDATARET");
        w_NOCODFISC = l_rsLoad.GetString("NOCODFISC");
        w_IDESITO = l_rsLoad.GetString("IDESITO");
        w_DATESITO = l_rsLoad.GetDate("DATESITO");
        w_PROGOPX = l_rsLoad.GetDouble("PROGOPX");
        op_PROGOPX = w_PROGOPX;
        w_RSPEDITO = l_rsLoad.GetDouble("RSPEDITO");
        w_COLDFILE = l_rsLoad.GetString("COLDFILE");
        w_COLDPROG = l_rsLoad.GetString("COLDPROG");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        w_filecanc = "";
        w_idcanc = "";
        w_spcanc = 0;
        w_dtcanc = CPLib.NullDate();
        Link_VQOCGQDTYC("Load");
        op_IDBASE = w_IDBASE;
        w_NOCODFISC = l_rsLoad.GetString("NOCODFISC");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"aeoprig")) {
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_aeoprig);
      l_cSql = "insert into "+m_oWrInfo_aeoprig.GetTableWriteName()+" (";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"COINT,";
      l_cSql = l_cSql+"TIPOAG,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"CONNESINT,";
      l_cSql = l_cSql+"ADATA,";
      l_cSql = l_cSql+"ADATARET,";
      l_cSql = l_cSql+"ASPEDITO,";
      l_cSql = l_cSql+"AFILE,";
      l_cSql = l_cSql+"APROG,";
      l_cSql = l_cSql+"AOLDPROG,";
      l_cSql = l_cSql+"AOLDFILE,";
      l_cSql = l_cSql+"CSPEDITO,";
      l_cSql = l_cSql+"CPROG,";
      l_cSql = l_cSql+"COLDPROG,";
      l_cSql = l_cSql+"CFILE,";
      l_cSql = l_cSql+"COLDFILE,";
      l_cSql = l_cSql+"IDRIF,";
      l_cSql = l_cSql+"ADTPRE,";
      l_cSql = l_cSql+"CDTPRE,";
      l_cSql = l_cSql+"CDATA,";
      l_cSql = l_cSql+"CDATARET,";
      l_cSql = l_cSql+"NOCODFISC,";
      l_cSql = l_cSql+"IDESITO,";
      l_cSql = l_cSql+"DATESITO,";
      l_cSql = l_cSql+"PROGOPX,";
      l_cSql = l_cSql+"RSPEDITO,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_aeoprig.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aeoprig")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COINT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOAG,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESINT,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ADATA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ADATARET,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ASPEDITO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_APROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AOLDPROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AOLDFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CSPEDITO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLDPROG,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLDFILE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDRIF,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ADTPRE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDTPRE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATA,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATARET,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOCODFISC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDESITO,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATESITO,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGOPX,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RSPEDITO,"N",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_aeoprig.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aeoprig")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_aeoprig,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_aeoprig);
      l_cSql = "Update "+m_oWrInfo_aeoprig.GetTableWriteName()+" set";
      l_cSql = l_cSql+" RAPPORTO = "+CPLib.ToSQL(w_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", COINT = "+CPLib.ToSQL(w_COINT,"C",1,0);
      l_cSql = l_cSql+", TIPOAG = "+CPLib.ToSQL(w_TIPOAG,"C",2,0);
      l_cSql = l_cSql+", CONNESINT = "+CPLib.ToSQLNull(w_CONNESINT,"C",16,0);
      l_cSql = l_cSql+", ADATA = "+CPLib.ToSQL(w_ADATA,"D",8,0);
      l_cSql = l_cSql+", ADATARET = "+CPLib.ToSQL(w_ADATARET,"D",8,0);
      l_cSql = l_cSql+", ASPEDITO = "+CPLib.ToSQL(w_ASPEDITO,"N",1,0);
      l_cSql = l_cSql+", AFILE = "+CPLib.ToSQL(w_AFILE,"C",15,0);
      l_cSql = l_cSql+", APROG = "+CPLib.ToSQL(w_APROG,"C",25,0);
      l_cSql = l_cSql+", AOLDPROG = "+CPLib.ToSQL(w_AOLDPROG,"C",25,0);
      l_cSql = l_cSql+", AOLDFILE = "+CPLib.ToSQL(w_AOLDFILE,"C",15,0);
      l_cSql = l_cSql+", CSPEDITO = "+CPLib.ToSQL(w_CSPEDITO,"N",1,0);
      l_cSql = l_cSql+", CPROG = "+CPLib.ToSQL(w_CPROG,"C",25,0);
      l_cSql = l_cSql+", COLDPROG = "+CPLib.ToSQL(w_COLDPROG,"C",25,0);
      l_cSql = l_cSql+", CFILE = "+CPLib.ToSQL(w_CFILE,"C",15,0);
      l_cSql = l_cSql+", COLDFILE = "+CPLib.ToSQL(w_COLDFILE,"C",15,0);
      l_cSql = l_cSql+", IDRIF = "+CPLib.ToSQL(w_IDRIF,"C",10,0);
      l_cSql = l_cSql+", ADTPRE = "+CPLib.ToSQL(w_ADTPRE,"D",8,0);
      l_cSql = l_cSql+", CDTPRE = "+CPLib.ToSQL(w_CDTPRE,"D",8,0);
      l_cSql = l_cSql+", CDATA = "+CPLib.ToSQL(w_CDATA,"D",8,0);
      l_cSql = l_cSql+", CDATARET = "+CPLib.ToSQL(w_CDATARET,"D",8,0);
      l_cSql = l_cSql+", NOCODFISC = "+CPLib.ToSQL(w_NOCODFISC,"C",1,0);
      l_cSql = l_cSql+", IDESITO = "+CPLib.ToSQL(w_IDESITO,"C",8,0);
      l_cSql = l_cSql+", DATESITO = "+CPLib.ToSQL(w_DATESITO,"D",8,0);
      l_cSql = l_cSql+", PROGOPX = "+CPLib.ToSQL(w_PROGOPX,"N",15,0);
      l_cSql = l_cSql+", RSPEDITO = "+CPLib.ToSQL(w_RSPEDITO,"N",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aeoprig")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_aeoprig,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_aeoprig.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"aeoprig")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_aeoprig,l_cSql,m_oParameters);
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
          l_cSql = "Delete from "+m_oWrInfo_aeoprig.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_aeoprig,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_aeoprig.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"aeoprig")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_aeoprig,l_cSql);
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
    m_Sql.NextTableProg(this,"PRGAEOPEXTR","i_codazi,w_IDBASE",m_cServer_aeoprig,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave IDBASE, altrimenti non si riesce a linkare da zoom
    w_IDBASE = CPLib.RTrim(w_IDBASE);
    op_IDBASE = w_IDBASE;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PROGAED","i_codazi,w_PROGOPX",m_cServer_aeoprig,m_Ctx.GetCompany());
    op_PROGOPX = w_PROGOPX;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"DZWSXMBIHR")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "CFESTERO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DZWSXMBIHR",CPLib.GetLinkedFieldProps("CONNES","CONNESINT","C",16,0));
    } else if (CPLib.eq(p_cID,"VQOCGQDTYC")) {
      result.m_TableName = "aeopcanc";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "IDFILE" , "IDPROG" , "SPEDITO" , "DATARIF"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "N" , "D"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VQOCGQDTYC",CPLib.GetLinkedFieldProps("IDBASE","IDBASE","C",10,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_ae_chkdel,
  public static final String i_InvokedRoutines = ",arfn_ae_chkdel,";
}
