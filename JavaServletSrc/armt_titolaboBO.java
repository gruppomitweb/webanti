// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_titolaboBO extends armt_titolaboBL {
  class SqlLoader {
    public boolean m_bLink_1_5 = false;
    public boolean m_bLink_1_7 = false;
    public boolean m_bLink_1_64 = false;
    public boolean m_bLink_1_69 = false;
    public boolean m_bLink_1_72 = false;
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
    public void AddJoinedLink_1_5(String rightTable,String rightServer) {
      // questo link aggiunge 6 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+6,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_5.CODINTER AS CODINTER105";
        m_cSelect = m_cSelect+" ,link_1_5.DATANASC AS DATANASC105";
        m_cSelect = m_cSelect+" ,link_1_5.CODCAB AS CODCAB105";
        m_cSelect = m_cSelect+" ,link_1_5.PROVINCIA AS PROVINCIA105";
        m_cSelect = m_cSelect+" ,link_1_5.DESCCIT AS DESCCIT105";
        m_cSelect = m_cSelect+" ,link_1_5.TIPINTER AS TIPINTER105";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_5","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_5","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_5 = true;
          m_nColumns = m_nColumns+6;
        }
      }
    }
    public void AddJoinedLink_1_7(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_7.CODDIP AS CODDIP107";
        m_cSelect = m_cSelect+" ,link_1_7.DESCRIZ AS DESCRIZ107";
        m_cSelect = m_cSelect+" ,link_1_7.DESCCIT AS DESCCIT107";
        m_cSelect = m_cSelect+" ,link_1_7.PROVINCIA AS PROVINCIA107";
        m_cSelect = m_cSelect+" ,link_1_7.CAB AS CAB107";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_7","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_7","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_7 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_64(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_64.CONNES AS CONNES164";
        m_cSelect = m_cSelect+" ,link_1_64.RAGSOC AS RAGSOC164";
        m_cSelect = m_cSelect+" ,link_1_64.SESSO AS SESSO164";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_64","CONNESCLI","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_64","CONNESCLI","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_64 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_69(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_69.CODICE AS CODICE169";
        m_cSelect = m_cSelect+" ,link_1_69.DES1 AS DES1169";
        m_cSelect = m_cSelect+" ,link_1_69.TIPREG AS TIPREG169";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_69","TIPOOPRAP","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_69","TIPOOPRAP","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_69 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_72(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_72.RAPPORTO AS RAPPORTO172";
        m_cSelect = m_cSelect+" ,link_1_72.DESCRAP AS DESCRAP172";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_72","RAPPORTO","RAPPORTO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_72","RAPPORTO","RAPPORTO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_72 = true;
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
  public armt_titolaboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_titolabo");
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
    l_bResult = arfn_chkdatregR.Make(m_Ctx,this).Run(w_DATAOPE,w_DATAREG,w_gChkDate,w_gStatus);
    if (l_bResult) {
    } else {
      m_cLastMsgError = CPLib.Strtran("'%ERRORMESSAGE%'","%ERRORMESSAGE%",m_cLastMsgError);
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
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_rapotit,m_cPhName_rapotit,m_cVirtName_rapotit,m_cVirtName_rapotit+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_rapotit,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_5(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_1_7(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_64(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_69(m_cPhName_tbtipreg,m_cServer_tbtipreg);
    l_oSqlLoader.AddJoinedLink_1_72(m_cPhName_anarapbo,m_cServer_anarapbo);
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
        w_xdescrap = "";
        w_xDescDipe = "";
        w_datpaseuro = CPLib.NullDate();
        w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
        w_xDesReg = "";
        w_xRagSoc = "";
        w_errmsg = "";
        w_Aggiorna = "";
        w_lancio = 0;
        w_VALUTA = "";
        w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
        w_tipreg = "";
        w_gStatus = m_Ctx.GetGlobalString("gStatus");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_CITINT = "";
        w_CITDIP = "";
        w_PROVDIP = "";
        w_CABDIP = "";
        w_PROVINT = "";
        w_CABINT = "";
        w_xRagSocCli = "";
        w_SESSO = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_flgpf = "P";
        w_flgpg = "G";
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        if (l_oSqlLoader.m_bLink_1_5) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC105");
          w_CABINT = l_rsLoad.GetString("CODCAB105");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA105");
          w_CITINT = l_rsLoad.GetString("DESCCIT105");
          w_TIPOINTER = l_rsLoad.GetString("TIPINTER105");
        } else {
          Link_WJSVGWKSFC("Load");
        }
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_7) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ107");
          w_CITDIP = l_rsLoad.GetString("DESCCIT107");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA107");
          w_CABDIP = l_rsLoad.GetString("CAB107");
        } else {
          Link_AVHTGZTOSZ("Load");
        }
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        op_IDBASE = w_IDBASE;
        w_TIPOINTER = l_rsLoad.GetString("TIPOINTER");
        w_TIPOINF = l_rsLoad.GetString("TIPOINF");
        w_IDEREG = l_rsLoad.GetString("IDEREG");
        w_FLAGRAP = l_rsLoad.GetString("FLAGRAP");
        w_OPRAP = l_rsLoad.GetString("OPRAP");
        w_OPERATORE = l_rsLoad.GetString("OPERATORE");
        w_AUTOM = l_rsLoad.GetString("AUTOM");
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_sEdit = 0;
        w_FLAGRAP2 = l_rsLoad.GetString("FLAGRAP2");
        w_FLAGLIRE = l_rsLoad.GetString("FLAGLIRE");
        w_tipregn = CPLib.Val(CPLib.LRTrim(w_tipreg));
        w_PRGIMPTIT = l_rsLoad.GetDouble("PRGIMPTIT");
        op_PRGIMPTIT = w_PRGIMPTIT;
        w_dataoggi = CPLib.Date();
        w_filtro = "T";
        w_CONNESCLI = l_rsLoad.GetString("CONNESCLI");
        if (l_oSqlLoader.m_bLink_1_64) {
          w_xRagSocCli = l_rsLoad.GetString("RAGSOC164");
          w_SESSO = l_rsLoad.GetString("SESSO164");
        } else {
          Link_UMFEJVRUFZ("Load");
        }
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_DATAREG = l_rsLoad.GetDate("DATAREG");
        w_CDATOPE = l_rsLoad.GetString("CDATOPE");
        w_TIPOOPRAP = l_rsLoad.GetString("TIPOOPRAP");
        if (l_oSqlLoader.m_bLink_1_69) {
          w_xDesReg = l_rsLoad.GetString("DES1169");
          w_tipreg = l_rsLoad.GetString("TIPREG169");
        } else {
          Link_SWRTSKXMDH("Load");
        }
        w_CONNESOPER = l_rsLoad.GetString("CONNESOPER");
        w_xRagSoc = "";
        Link_SLTZSUMACW("Load");
        w_TIPOLEG = l_rsLoad.GetString("TIPOLEG");
        // Link con tbtipleg non eseguito: riporta solo campi
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        if (l_oSqlLoader.m_bLink_1_72) {
          w_xdescrap = l_rsLoad.GetString("DESCRAP172");
        } else {
          Link_FMTBXELZFV("Load");
        }
        w_STATOREG = l_rsLoad.GetString("STATOREG");
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        op_NUMPROG = w_NUMPROG;
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        w_DATARETT = l_rsLoad.GetDate("DATARETT");
        w_IDEREG = l_rsLoad.GetString("IDEREG");
        w_STATOREG = l_rsLoad.GetString("STATOREG");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"rapotit")) {
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_rapotit);
      l_cSql = "insert into "+m_oWrInfo_rapotit.GetTableWriteName()+" (";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"TIPOINTER,";
      l_cSql = l_cSql+"TIPOINF,";
      l_cSql = l_cSql+"IDEREG,";
      l_cSql = l_cSql+"FLAGRAP,";
      l_cSql = l_cSql+"OPRAP,";
      l_cSql = l_cSql+"OPERATORE,";
      l_cSql = l_cSql+"AUTOM,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"FLAGRAP2,";
      l_cSql = l_cSql+"FLAGLIRE,";
      l_cSql = l_cSql+"PRGIMPTIT,";
      l_cSql = l_cSql+"CONNESCLI,";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"DATAREG,";
      l_cSql = l_cSql+"CDATOPE,";
      l_cSql = l_cSql+"TIPOOPRAP,";
      l_cSql = l_cSql+"CONNESOPER,";
      l_cSql = l_cSql+"TIPOLEG,";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"STATOREG,";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"DESCINTER,";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"DATARETT,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_rapotit.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"rapotit")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINTER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDEREG,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERATORE,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTOM,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGLIRE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGIMPTIT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOLEG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_STATOREG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCINTER,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLLEG,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_rapotit.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"rapotit")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_rapotit,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_rapotit);
      l_cSql = "Update "+m_oWrInfo_rapotit.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CODINTER = "+CPLib.ToSQLNull(w_CODINTER,"C",11,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", TIPOINTER = "+CPLib.ToSQL(w_TIPOINTER,"C",2,0);
      l_cSql = l_cSql+", TIPOINF = "+CPLib.ToSQL(w_TIPOINF,"C",1,0);
      l_cSql = l_cSql+", IDEREG = "+CPLib.ToSQL(w_IDEREG,"C",20,0);
      l_cSql = l_cSql+", FLAGRAP = "+CPLib.ToSQL(w_FLAGRAP,"C",1,0);
      l_cSql = l_cSql+", OPRAP = "+CPLib.ToSQL(w_OPRAP,"C",1,0);
      l_cSql = l_cSql+", OPERATORE = "+CPLib.ToSQL(w_OPERATORE,"C",70,0);
      l_cSql = l_cSql+", AUTOM = "+CPLib.ToSQL(w_AUTOM,"C",5,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", FLAGRAP2 = "+CPLib.ToSQL(w_FLAGRAP2,"C",1,0);
      l_cSql = l_cSql+", FLAGLIRE = "+CPLib.ToSQL(w_FLAGLIRE,"C",1,0);
      l_cSql = l_cSql+", PRGIMPTIT = "+CPLib.ToSQL(w_PRGIMPTIT,"N",15,0);
      l_cSql = l_cSql+", CONNESCLI = "+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0);
      l_cSql = l_cSql+", DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"D",8,0);
      l_cSql = l_cSql+", CDATOPE = "+CPLib.ToSQL(w_CDATOPE,"C",8,0);
      l_cSql = l_cSql+", TIPOOPRAP = "+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0);
      l_cSql = l_cSql+", CONNESOPER = "+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0);
      l_cSql = l_cSql+", TIPOLEG = "+CPLib.ToSQLNull(w_TIPOLEG,"C",1,0);
      l_cSql = l_cSql+", RAPPORTO = "+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", STATOREG = "+CPLib.ToSQL(w_STATOREG,"C",1,0);
      l_cSql = l_cSql+", NUMPROG = "+CPLib.ToSQL(w_NUMPROG,"C",11,0);
      l_cSql = l_cSql+", DESCINTER = "+CPLib.ToSQL(w_DESCINTER,"C",50,0);
      l_cSql = l_cSql+", COLLEG = "+CPLib.ToSQL(w_COLLEG,"C",12,0);
      l_cSql = l_cSql+", DATARETT = "+CPLib.ToSQL(w_DATARETT,"D",8,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"rapotit")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_rapotit,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_rapotit.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"rapotit")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_rapotit,l_cSql,m_oParameters);
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
    // * --- armt_titolabo
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
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_rapotit.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_rapotit,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_rapotit.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"rapotit")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_rapotit,l_cSql);
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
    // * --- armt_titolabo
    NotifyEvent("Record Deleted");
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
    m_Sql.NextTableProg(this,"PRGTITO1","i_codazi,w_IDBASE",m_cServer_rapotit,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave IDBASE, altrimenti non si riesce a linkare da zoom
    w_IDBASE = CPLib.RTrim(w_IDBASE);
    op_IDBASE = w_IDBASE;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a NUMPROG
    w_NUMPROG = CPLib.Left(w_NUMPROG,11)+CPLib.Space(11-CPLib.Len(w_NUMPROG));
    m_Sql.NextTableProg(this,"PRGTITO2","i_codazi,w_NUMPROG",m_cServer_rapotit,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave NUMPROG, altrimenti non si riesce a linkare da zoom
    w_NUMPROG = CPLib.RTrim(w_NUMPROG);
    op_NUMPROG = w_NUMPROG;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPTIT","i_codazi,w_PRGIMPTIT",m_cServer_rapotit,m_Ctx.GetCompany());
    op_PRGIMPTIT = w_PRGIMPTIT;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"WJSVGWKSFC")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_intermbo";
      result.m_rdField = new String[]{"CODINTER" , "DATANASC" , "CODCAB" , "PROVINCIA" , "DESCCIT" , "TIPINTER"};
      result.m_rdTypes = new String[]{"C" , "D" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("WJSVGWKSFC",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0),CPLib.GetLinkedFieldProps("TIPINTER","TIPOINTER","C",2,0));
    } else if (CPLib.eq(p_cID,"AVHTGZTOSZ")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ" , "DESCCIT" , "PROVINCIA" , "CAB"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AVHTGZTOSZ",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    } else if (CPLib.eq(p_cID,"UMFEJVRUFZ")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "SESSO"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UMFEJVRUFZ",CPLib.GetLinkedFieldProps("CONNES","CONNESCLI","C",16,0));
    } else if (CPLib.eq(p_cID,"SWRTSKXMDH")) {
      result.m_TableName = "tbtipreg";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DES1" , "TIPREG"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SWRTSKXMDH",CPLib.GetLinkedFieldProps("CODICE","TIPOOPRAP","C",2,0));
    } else if (CPLib.eq(p_cID,"SLTZSUMACW")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{"TIPOPERS"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("SLTZSUMACW",CPLib.GetLinkedFieldProps("CONNES","CONNESOPER","C",16,0),CPLib.GetLinkedFieldProps("TIPOPERS","flgpf","C",1,0));
    } else if (CPLib.eq(p_cID,"MLPGOPNAKN")) {
      result.m_TableName = "tbtipleg";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tipileg";
      result.m_rdField = new String[]{"TIPLEG"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MLPGOPNAKN",CPLib.GetLinkedFieldProps("TIPLEG","TIPOLEG","C",1,0));
    } else if (CPLib.eq(p_cID,"FMTBXELZFV")) {
      result.m_TableName = "anarapbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAPPORTO" , "DESCRAP"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("FMTBXELZFV",CPLib.GetLinkedFieldProps("RAPPORTO","RAPPORTO","C",25,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_chkdatdoc,arfn_chkdatreg,arfn_chktiporeg,arrt_aggstatoreg,arrt_delrapotit,arrt_edtrapotit,arrt_tit_load_aui,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_chkdatdoc,arfn_chkdatreg,arfn_chktiporeg,arrt_aggstatoreg,arrt_delrapotit,arrt_edtrapotit,arrt_tit_load_aui,arrt_writelog,";
}
