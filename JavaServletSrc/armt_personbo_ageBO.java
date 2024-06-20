// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_personbo_ageBO extends armt_personbo_ageBL {
  class SqlLoader {
    public boolean m_bLink_1_28 = false;
    public boolean m_bLink_1_33 = false;
    public boolean m_bLink_1_43 = false;
    public boolean m_bLink_1_45 = false;
    public boolean m_bLink_1_46 = false;
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
    public void AddJoinedLink_1_28(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_28.IDBASE AS IDBASE128";
        m_cSelect = m_cSelect+" ,link_1_28.DESCRI AS DESCRI128";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_28","IDNASSTATO","IDBASE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_28","IDNASSTATO","IDBASE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_28 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_33(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_33.TIPDOC AS TIPDOC133";
        m_cSelect = m_cSelect+" ,link_1_33.DESCRI AS DESCRI133";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_33","TIPODOC","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_33","TIPODOC","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_33 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_43(String rightTable,String rightServer) {
      // questo link aggiunge 4 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+4,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_43.SOTGRU AS SOTGRU143";
        m_cSelect = m_cSelect+" ,link_1_43.DESCRI AS DESCRI143";
        m_cSelect = m_cSelect+" ,link_1_43.TIPOSOT AS TIPOSOT143";
        m_cSelect = m_cSelect+" ,link_1_43.DATAFINE AS DATAFINE143";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_43","SOTGRUP","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_43","SOTGRUP","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_43 = true;
          m_nColumns = m_nColumns+4;
        }
      }
    }
    public void AddJoinedLink_1_45(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_45.RAMGRU AS RAMGRU145";
        m_cSelect = m_cSelect+" ,link_1_45.DESCRI AS DESCRI145";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_45","RAMOGRUP","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_45","RAMOGRUP","RAMGRU",true);
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
    public void AddJoinedLink_1_46(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_46.CODICE AS CODICE146";
        m_cSelect = m_cSelect+" ,link_1_46.DESCRI AS DESCRI146";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_46","ATTIV","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_46","ATTIV","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_46 = true;
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
  public armt_personbo_ageBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_personbo_age");
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
  public static String[] m_cLoadParameterNames = {"CONNES"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CONNES) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_personbo,m_cPhName_personbo,m_cVirtName_personbo,m_cVirtName_personbo+".CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CONNES,"C",16,0),m_cServer_personbo,p_CONNES),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_28(m_cPhName_tbstatna,m_cServer_tbstatna);
    l_oSqlLoader.AddJoinedLink_1_33(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
    l_oSqlLoader.AddJoinedLink_1_43(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_1_45(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_46(m_cPhName_tbtipatt,m_cServer_tbtipatt);
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
        w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
        w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_tipsot = "";
        w_DESCSGRU = "";
        w_DESCRAMGRU = "";
        w_DESCUIC = "";
        w_dessta = "";
        w_DATARETT = CPLib.NullDate();
        w_STATOREG = "";
        w_NUMPROG = "";
        w_DESCRI = "";
        w_xstatonas = "";
        w_finesae = CPLib.NullDate();
        w_finesint = CPLib.NullDate();
        w_xFLGVALIDO = "";
        w_xFLGANAVAL = "";
        w_xDSETSIN = "";
        w_xITFLGPEP = "";
        w_xdescareag = "";
        w_xdescnatgiu = "";
        w_xdesctipatt = "";
        w_xdesccomp = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_xITFLGPEP = "";
        w_flgaggfam = "";
        Link_LDTVEYLAXJ("Load");
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
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_idcitta = l_rsLoad.GetString("idcitta");
        // Link con tbcitta non eseguito: riporta solo campi
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
        if (l_oSqlLoader.m_bLink_1_28) {
          w_xstatonas = l_rsLoad.GetString("DESCRI128");
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
        if (l_oSqlLoader.m_bLink_1_33) {
          w_DESCRI = l_rsLoad.GetString("DESCRI133");
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
        w_dataoggi = CPLib.Date();
        w_SOTGRUP = l_rsLoad.GetString("SOTGRUP");
        if (l_oSqlLoader.m_bLink_1_43) {
          w_DESCSGRU = l_rsLoad.GetString("DESCRI143");
          w_tipsot = l_rsLoad.GetString("TIPOSOT143");
          w_finesae = l_rsLoad.GetDate("DATAFINE143");
        } else {
          Link_LLYIGAMXRH("Load");
        }
        w_RAMOGRUP = l_rsLoad.GetString("RAMOGRUP");
        if (l_oSqlLoader.m_bLink_1_45) {
          w_DESCRAMGRU = l_rsLoad.GetString("DESCRI145");
        } else {
          Link_RVNHQCXNEM("Load");
        }
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        if (l_oSqlLoader.m_bLink_1_46) {
          w_xdesctipatt = l_rsLoad.GetString("DESCRI146");
        } else {
          Link_SAQTIHOALW("Load");
        }
        w_SETTSINT = l_rsLoad.GetString("SETTSINT");
        w_finesint = CPLib.NullDate();
        w_xDSETSIN = "";
        Link_ZGNLLSFQHC("Load");
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_NOTIT = l_rsLoad.GetDouble("NOTIT");
        w_PEP = l_rsLoad.GetString("PEP");
        w_flgaggfam = "N";
        w_CRIME = l_rsLoad.GetString("CRIME");
        w_PROGIMPORT = l_rsLoad.GetDouble("PROGIMPORT");
        op_PROGIMPORT = w_PROGIMPORT;
        w_OLDSETSIN = l_rsLoad.GetString("OLDSETSIN");
        w_CONADD = w_CONNES;
        w_xFLGVALIDO = "";
        w_xFLGANAVAL = "";
        Link_QHGWFLNQMV("Load");
        w_NOSARA = l_rsLoad.GetString("NOSARA");
        w_CRIMEDATE = l_rsLoad.GetDate("CRIMEDATE");
        w_PEPDATE = l_rsLoad.GetDate("PEPDATE");
        w_NOTE = l_rsLoad.GetString("NOTE");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
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
    // * --- armt_personbo_age
    SetUpdated();
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
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"idcitta,";
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
      l_cSql = l_cSql+"NOTIT,";
      l_cSql = l_cSql+"PEP,";
      l_cSql = l_cSql+"CRIME,";
      l_cSql = l_cSql+"PROGIMPORT,";
      l_cSql = l_cSql+"OLDSETSIN,";
      l_cSql = l_cSql+"NOSARA,";
      l_cSql = l_cSql+"CRIMEDATE,";
      l_cSql = l_cSql+"PEPDATE,";
      l_cSql = l_cSql+"NOTE,";
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
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_idcitta,"C",40,0)+", ";
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
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ATTIV,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SETTSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNES,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOTIT,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CRIME,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGIMPORT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OLDSETSIN,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOSARA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CRIMEDATE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEPDATE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOTE,"M",10,0,m_cServer_personbo,m_oParameters)+", ";
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
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", idcitta = "+CPLib.ToSQLNull(w_idcitta,"C",40,0);
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
      l_cSql = l_cSql+", ATTIV = "+CPLib.ToSQLNull(w_ATTIV,"C",10,0);
      l_cSql = l_cSql+", SETTSINT = "+CPLib.ToSQLNull(w_SETTSINT,"C",3,0);
      l_cSql = l_cSql+", NOTIT = "+CPLib.ToSQL(w_NOTIT,"N",1,0);
      l_cSql = l_cSql+", PEP = "+CPLib.ToSQL(w_PEP,"C",1,0);
      l_cSql = l_cSql+", CRIME = "+CPLib.ToSQL(w_CRIME,"C",1,0);
      l_cSql = l_cSql+", PROGIMPORT = "+CPLib.ToSQL(w_PROGIMPORT,"N",15,0);
      l_cSql = l_cSql+", OLDSETSIN = "+CPLib.ToSQL(w_OLDSETSIN,"C",3,0);
      l_cSql = l_cSql+", NOSARA = "+CPLib.ToSQL(w_NOSARA,"C",1,0);
      l_cSql = l_cSql+", CRIMEDATE = "+CPLib.ToSQL(w_CRIMEDATE,"D",8,0);
      l_cSql = l_cSql+", PEPDATE = "+CPLib.ToSQL(w_PEPDATE,"D",8,0);
      l_cSql = l_cSql+", NOTE = "+CPLib.ToSQL(w_NOTE,"M",10,0,m_cServer_personbo,m_oParameters);
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
    // * --- armt_personbo_age
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
    // * --- armt_personbo_age
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
      result.m_kField = new String[]{"PKTBSTATI"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",30,0),CPLib.GetLinkedFieldProps("PKTBSTATI","PAESE","C",3,0));
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
      result.AppendFieldsHash("ZRIWLTGERM",CPLib.GetLinkedFieldProps("IDBASE","nascomunid","C",10,0));
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
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbtipatt";
      result.m_rdField = new String[]{"CODICE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
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
    } else if (CPLib.eq(p_cID,"QHGWFLNQMV")) {
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
      result.AppendFieldsHash("QHGWFLNQMV",CPLib.GetLinkedFieldProps("CONNES","CONADD","C",16,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkateco,arfn_chkcodfis,arfn_chklundoc,arfn_chksint,arrt_agg_famiglie,arrt_calccodfis,arrt_calcolasett,arrt_crea_agg,arrt_delpersonbo,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkateco,arfn_chkcodfis,arfn_chklundoc,arfn_chksint,arrt_agg_famiglie,arrt_calccodfis,arrt_calcolasett,arrt_crea_agg,arrt_delpersonbo,arrt_writelog,";
}
