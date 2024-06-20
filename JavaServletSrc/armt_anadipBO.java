// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_anadipBO extends armt_anadipBL {
  class SqlLoader {
    public boolean m_bLink_1_18 = false;
    public boolean m_bLink_1_34 = false;
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
      // questo link aggiunge 4 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+4,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_18.MACODICE AS MACODICE118";
        m_cSelect = m_cSelect+" ,link_1_18.MADESCRI AS MADESCRI118";
        m_cSelect = m_cSelect+" ,link_1_18.MACOGNOME AS MACOGNOME118";
        m_cSelect = m_cSelect+" ,link_1_18.MANOME AS MANOME118";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_18","MACROAGENTE","MACODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_18","MACROAGENTE","MACODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_18 = true;
          m_nColumns = m_nColumns+4;
        }
      }
    }
    public void AddJoinedLink_1_34(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_34.CODSTA AS CODSTA134";
        m_cSelect = m_cSelect+" ,link_1_34.DESCRI AS DESCRI134";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_34","NAZAGENTE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_34","NAZAGENTE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_34 = true;
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
  public armt_anadipBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_anadip");
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
      l_bResult = CanSaveChild(ardt_dippreposti,m_cWv_ardt_dippreposti,"m_cWv_ardt_dippreposti");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_dippreposti.m_cLastMsgError;
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
          if ( ! (ardt_dippreposti.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_dippreposti)) {
            ardt_dippreposti.SetFromContext(m_cWv_ardt_dippreposti);
            m_cWv_ardt_dippreposti = "_not_empty_";
          }
          if (ardt_dippreposti.IsUpdated()) {
            ardt_dippreposti.w_CODDIP = w_CODDIP;
            if ( ! (ardt_dippreposti.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"CODDIP"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CODDIP) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_anadip,m_cPhName_anadip,m_cVirtName_anadip,m_cVirtName_anadip+".CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CODDIP,"C",6,0),m_cServer_anadip,p_CODDIP),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_18(m_cPhName_tbmacage,m_cServer_tbmacage);
    l_oSqlLoader.AddJoinedLink_1_34(m_cPhName_tbstati,m_cServer_tbstati);
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
        w_xMADESCRI = "";
        w_xDESCNAZ = "";
        w_gAgeCGO = m_Ctx.GetGlobalString("gAgeCGO");
        w_xC1DESCRI = "";
        w_xC2DESCRI = "";
        w_xC3DESCRI = "";
        w_xC4DESCRI = "";
        w_xC5DESCRI = "";
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_xDESCAN = "";
        w_xMACOGNOME = "";
        w_xMANOME = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_CODDIP = l_rsLoad.GetString("CODDIP");
        w_DESCRIZ = l_rsLoad.GetString("DESCRIZ");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
        w_CAP = l_rsLoad.GetString("CAP");
        w_IDCITTA = l_rsLoad.GetString("IDCITTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        // Link con tbcitta non eseguito: riporta solo campi
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CAB = l_rsLoad.GetString("CAB");
        w_AGENTE = l_rsLoad.GetString("AGENTE");
        w_MACROAGENTE = l_rsLoad.GetString("MACROAGENTE");
        if (l_oSqlLoader.m_bLink_1_18) {
          w_xMADESCRI = l_rsLoad.GetString("MADESCRI118");
          w_xMACOGNOME = l_rsLoad.GetString("MACOGNOME118");
          w_xMANOME = l_rsLoad.GetString("MANOME118");
        } else {
          Link_BPQQBVFABO("Load");
        }
        w_TERMINALID = l_rsLoad.GetString("TERMINALID");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        w_TELEFONO = l_rsLoad.GetString("TELEFONO");
        w_ABICABSARA = l_rsLoad.GetString("ABICABSARA");
        w_AGACCODE = l_rsLoad.GetString("AGACCODE");
        w_NAZAGENTE = l_rsLoad.GetString("NAZAGENTE");
        if (l_oSqlLoader.m_bLink_1_34) {
          w_xDESCNAZ = l_rsLoad.GetString("DESCRI134");
        } else {
          Link_SGDAQGMTNU("Load");
        }
        w_VALCOMPL = l_rsLoad.GetString("VALCOMPL");
        w_ANOMOPER = l_rsLoad.GetString("ANOMOPER");
        w_OPXSOSCLI = l_rsLoad.GetDouble("OPXSOSCLI");
        w_OPXSOSAGE = l_rsLoad.GetDouble("OPXSOSAGE");
        w_AGEREGIO = l_rsLoad.GetString("AGEREGIO");
        w_FLGATT = l_rsLoad.GetString("FLGATT");
        w_CODLOC = l_rsLoad.GetString("CODLOC");
        w_CODAGE = l_rsLoad.GetString("CODAGE");
        w_TIPOSV = l_rsLoad.GetString("TIPOSV");
        w_FLGNOAUA = l_rsLoad.GetString("FLGNOAUA");
        w_FLGWUPOS = l_rsLoad.GetString("FLGWUPOS");
        w_tipocat = "D";
        w_CATEG04 = l_rsLoad.GetString("CATEG04");
        w_xC4DESCRI = "";
        Link_JQLGHMLOKO("Load");
        w_CATEG05 = l_rsLoad.GetString("CATEG05");
        w_xC5DESCRI = "";
        Link_QVBZSFMTVP("Load");
        w_CATEGORIA = l_rsLoad.GetString("CATEGORIA");
        w_CATEG01 = l_rsLoad.GetString("CATEG01");
        w_xC1DESCRI = "";
        Link_ICGUZGYXTD("Load");
        w_CATEG02 = l_rsLoad.GetString("CATEG02");
        w_xC2DESCRI = "";
        Link_TGQHYPERED("Load");
        w_CATEG03 = l_rsLoad.GetString("CATEG03");
        w_xC3DESCRI = "";
        Link_QRJNKZVHDW("Load");
        w_CAB2 = l_rsLoad.GetString("CAB2");
        w_CODICEAAMS = l_rsLoad.GetString("CODICEAAMS");
        w_CONCESSIONE = l_rsLoad.GetString("CONCESSIONE");
        w_CODFISC = l_rsLoad.GetString("CODFISC");
        w_PARTIVA = l_rsLoad.GetString("PARTIVA");
        w_TIPOAGENTE = l_rsLoad.GetString("TIPOAGENTE");
        w_NUMCIVICO = l_rsLoad.GetString("NUMCIVICO");
        w_SERRIMDEN = l_rsLoad.GetString("SERRIMDEN");
        w_DATAINI = l_rsLoad.GetDate("DATAINI");
        w_DATAFINE = l_rsLoad.GetDate("DATAFINE");
        w_FLGCOMPL = l_rsLoad.GetDouble("FLGCOMPL");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_dippreposti = "";
        ardt_dippreposti.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"anadip")) {
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
    return Load(w_CODDIP);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_anadip);
      l_cSql = "insert into "+m_oWrInfo_anadip.GetTableWriteName()+" (";
      l_cSql = l_cSql+"CODDIP,";
      l_cSql = l_cSql+"DESCRIZ,";
      l_cSql = l_cSql+"DOMICILIO,";
      l_cSql = l_cSql+"CAP,";
      l_cSql = l_cSql+"IDCITTA,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CAB,";
      l_cSql = l_cSql+"AGENTE,";
      l_cSql = l_cSql+"MACROAGENTE,";
      l_cSql = l_cSql+"TERMINALID,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"TELEFONO,";
      l_cSql = l_cSql+"ABICABSARA,";
      l_cSql = l_cSql+"AGACCODE,";
      l_cSql = l_cSql+"NAZAGENTE,";
      l_cSql = l_cSql+"VALCOMPL,";
      l_cSql = l_cSql+"ANOMOPER,";
      l_cSql = l_cSql+"OPXSOSCLI,";
      l_cSql = l_cSql+"OPXSOSAGE,";
      l_cSql = l_cSql+"AGEREGIO,";
      l_cSql = l_cSql+"FLGATT,";
      l_cSql = l_cSql+"CODLOC,";
      l_cSql = l_cSql+"CODAGE,";
      l_cSql = l_cSql+"TIPOSV,";
      l_cSql = l_cSql+"FLGNOAUA,";
      l_cSql = l_cSql+"FLGWUPOS,";
      l_cSql = l_cSql+"CATEG04,";
      l_cSql = l_cSql+"CATEG05,";
      l_cSql = l_cSql+"CATEGORIA,";
      l_cSql = l_cSql+"CATEG01,";
      l_cSql = l_cSql+"CATEG02,";
      l_cSql = l_cSql+"CATEG03,";
      l_cSql = l_cSql+"CAB2,";
      l_cSql = l_cSql+"CODICEAAMS,";
      l_cSql = l_cSql+"CONCESSIONE,";
      l_cSql = l_cSql+"CODFISC,";
      l_cSql = l_cSql+"PARTIVA,";
      l_cSql = l_cSql+"TIPOAGENTE,";
      l_cSql = l_cSql+"NUMCIVICO,";
      l_cSql = l_cSql+"SERRIMDEN,";
      l_cSql = l_cSql+"DATAINI,";
      l_cSql = l_cSql+"DATAFINE,";
      l_cSql = l_cSql+"FLGCOMPL,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_anadip.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"anadip")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCRIZ,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_IDCITTA,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DESCCIT,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AGENTE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MACROAGENTE,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TERMINALID,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TELEFONO,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ABICABSARA,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AGACCODE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_NAZAGENTE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VALCOMPL,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ANOMOPER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPXSOSCLI,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPXSOSAGE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AGEREGIO,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGATT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODLOC,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODAGE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOSV,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGNOAUA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGWUPOS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG04,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG05,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATEGORIA,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG01,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG02,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG03,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAB2,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODICEAAMS,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONCESSIONE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODFISC,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PARTIVA,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOAGENTE,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMCIVICO,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SERRIMDEN,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAINI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAFINE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCOMPL,"N",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_anadip.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"anadip")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_anadip,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_anadip);
      l_cSql = "Update "+m_oWrInfo_anadip.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DESCRIZ = "+CPLib.ToSQL(w_DESCRIZ,"C",30,0);
      l_cSql = l_cSql+", DOMICILIO = "+CPLib.ToSQL(w_DOMICILIO,"C",50,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",5,0);
      l_cSql = l_cSql+", IDCITTA = "+CPLib.ToSQLNull(w_IDCITTA,"C",10,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQLNull(w_DESCCIT,"C",60,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CAB = "+CPLib.ToSQL(w_CAB,"C",6,0);
      l_cSql = l_cSql+", AGENTE = "+CPLib.ToSQL(w_AGENTE,"C",1,0);
      l_cSql = l_cSql+", MACROAGENTE = "+CPLib.ToSQLNull(w_MACROAGENTE,"C",5,0);
      l_cSql = l_cSql+", TERMINALID = "+CPLib.ToSQL(w_TERMINALID,"C",15,0);
      l_cSql = l_cSql+", IDBASE = "+CPLib.ToSQL(w_IDBASE,"C",10,0);
      l_cSql = l_cSql+", TELEFONO = "+CPLib.ToSQL(w_TELEFONO,"C",15,0);
      l_cSql = l_cSql+", ABICABSARA = "+CPLib.ToSQL(w_ABICABSARA,"C",12,0);
      l_cSql = l_cSql+", AGACCODE = "+CPLib.ToSQL(w_AGACCODE,"C",10,0);
      l_cSql = l_cSql+", NAZAGENTE = "+CPLib.ToSQLNull(w_NAZAGENTE,"C",3,0);
      l_cSql = l_cSql+", VALCOMPL = "+CPLib.ToSQL(w_VALCOMPL,"C",2,0);
      l_cSql = l_cSql+", ANOMOPER = "+CPLib.ToSQL(w_ANOMOPER,"C",2,0);
      l_cSql = l_cSql+", OPXSOSCLI = "+CPLib.ToSQL(w_OPXSOSCLI,"N",10,0);
      l_cSql = l_cSql+", OPXSOSAGE = "+CPLib.ToSQL(w_OPXSOSAGE,"N",10,0);
      l_cSql = l_cSql+", AGEREGIO = "+CPLib.ToSQL(w_AGEREGIO,"C",2,0);
      l_cSql = l_cSql+", FLGATT = "+CPLib.ToSQL(w_FLGATT,"C",1,0);
      l_cSql = l_cSql+", CODLOC = "+CPLib.ToSQL(w_CODLOC,"C",25,0);
      l_cSql = l_cSql+", CODAGE = "+CPLib.ToSQL(w_CODAGE,"C",15,0);
      l_cSql = l_cSql+", TIPOSV = "+CPLib.ToSQL(w_TIPOSV,"C",3,0);
      l_cSql = l_cSql+", FLGNOAUA = "+CPLib.ToSQL(w_FLGNOAUA,"C",1,0);
      l_cSql = l_cSql+", FLGWUPOS = "+CPLib.ToSQL(w_FLGWUPOS,"C",1,0);
      l_cSql = l_cSql+", CATEG04 = "+CPLib.ToSQLNull(w_CATEG04,"C",2,0);
      l_cSql = l_cSql+", CATEG05 = "+CPLib.ToSQLNull(w_CATEG05,"C",2,0);
      l_cSql = l_cSql+", CATEGORIA = "+CPLib.ToSQL(w_CATEGORIA,"C",10,0);
      l_cSql = l_cSql+", CATEG01 = "+CPLib.ToSQLNull(w_CATEG01,"C",2,0);
      l_cSql = l_cSql+", CATEG02 = "+CPLib.ToSQLNull(w_CATEG02,"C",2,0);
      l_cSql = l_cSql+", CATEG03 = "+CPLib.ToSQLNull(w_CATEG03,"C",2,0);
      l_cSql = l_cSql+", CAB2 = "+CPLib.ToSQL(w_CAB2,"C",6,0);
      l_cSql = l_cSql+", CODICEAAMS = "+CPLib.ToSQL(w_CODICEAAMS,"C",12,0);
      l_cSql = l_cSql+", CONCESSIONE = "+CPLib.ToSQL(w_CONCESSIONE,"C",10,0);
      l_cSql = l_cSql+", CODFISC = "+CPLib.ToSQL(w_CODFISC,"C",16,0);
      l_cSql = l_cSql+", PARTIVA = "+CPLib.ToSQL(w_PARTIVA,"C",11,0);
      l_cSql = l_cSql+", TIPOAGENTE = "+CPLib.ToSQL(w_TIPOAGENTE,"C",2,0);
      l_cSql = l_cSql+", NUMCIVICO = "+CPLib.ToSQL(w_NUMCIVICO,"C",15,0);
      l_cSql = l_cSql+", SERRIMDEN = "+CPLib.ToSQL(w_SERRIMDEN,"C",1,0);
      l_cSql = l_cSql+", DATAINI = "+CPLib.ToSQL(w_DATAINI,"D",8,0);
      l_cSql = l_cSql+", DATAFINE = "+CPLib.ToSQL(w_DATAFINE,"D",8,0);
      l_cSql = l_cSql+", FLGCOMPL = "+CPLib.ToSQL(w_FLGCOMPL,"N",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"anadip")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIP,"C",6,0),m_cServer_anadip,w_CODDIP);
      l_cSql = l_cSql+m_oWrInfo_anadip.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"anadip")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_anadip,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_CODDIP) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_CODDIP);
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
          ardt_dippreposti.w_CODDIP = w_CODDIP;
          ardt_dippreposti.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_anadip.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODDIP,"C",6,0),m_cServer_anadip,w_CODDIP);
          l_cSql = l_cSql+m_oWrInfo_anadip.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"anadip")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_anadip,l_cSql);
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
    return Delete(w_CODDIP);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"CZGVBAYWKP")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_citta";
      result.m_rdField = new String[]{"IDBASE" , "CITTA" , "CAB" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CZGVBAYWKP",CPLib.GetLinkedFieldProps("IDBASE","IDCITTA","C",10,0));
    } else if (CPLib.eq(p_cID,"AEZUFOYHTM")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "IDBASE" , "PROV" , "CAB" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AEZUFOYHTM",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",60,0));
    } else if (CPLib.eq(p_cID,"BPQQBVFABO")) {
      result.m_TableName = "tbmacage";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbmacage";
      result.m_rdField = new String[]{"MACODICE" , "MADESCRI" , "MACOGNOME" , "MANOME"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BPQQBVFABO",CPLib.GetLinkedFieldProps("MACODICE","MACROAGENTE","C",5,0));
    } else if (CPLib.eq(p_cID,"SGDAQGMTNU")) {
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
      result.AppendFieldsHash("SGDAQGMTNU",CPLib.GetLinkedFieldProps("CODSTA","NAZAGENTE","C",3,0));
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
      result.m_kField = new String[]{"C4CODTAB"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("JQLGHMLOKO",CPLib.GetLinkedFieldProps("C4CODICE","CATEG04","C",2,0),CPLib.GetLinkedFieldProps("C4CODTAB","tipocat","C",10,0));
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
      result.m_kField = new String[]{"C5CODTAB"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("QVBZSFMTVP",CPLib.GetLinkedFieldProps("C5CODICE","CATEG05","C",2,0),CPLib.GetLinkedFieldProps("C5CODTAB","tipocat","C",10,0));
    } else if (CPLib.eq(p_cID,"ICGUZGYXTD")) {
      result.m_TableName = "tbcateg01";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"C1CODICE" , "C1DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{"C1CODTAB"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("ICGUZGYXTD",CPLib.GetLinkedFieldProps("C1CODICE","CATEG01","C",2,0),CPLib.GetLinkedFieldProps("C1CODTAB","tipocat","C",10,0));
    } else if (CPLib.eq(p_cID,"TGQHYPERED")) {
      result.m_TableName = "tbcateg02";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"C2CODICE" , "C2DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{"C2CODTAB"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("TGQHYPERED",CPLib.GetLinkedFieldProps("C2CODICE","CATEG02","C",2,0),CPLib.GetLinkedFieldProps("C2CODTAB","tipocat","C",10,0));
    } else if (CPLib.eq(p_cID,"QRJNKZVHDW")) {
      result.m_TableName = "tbcateg03";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"C3CODICE" , "C3DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{"C3CODTAB"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("QRJNKZVHDW",CPLib.GetLinkedFieldProps("C3CODICE","CATEG03","C",2,0),CPLib.GetLinkedFieldProps("C3CODTAB","tipocat","C",10,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arrt_creaute_age,
  public static final String i_InvokedRoutines = ",arrt_creaute_age,";
}
