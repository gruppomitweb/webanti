// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_intermboBO extends armt_intermboBL {
  class SqlLoader {
    public boolean m_bLink_1_11 = false;
    public boolean m_bLink_1_15 = false;
    public boolean m_bLink_1_16 = false;
    public boolean m_bLink_1_23 = false;
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
    public void AddJoinedLink_1_11(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_11.CODSTA AS CODSTA111";
        m_cSelect = m_cSelect+" ,link_1_11.DESCRI AS DESCRI111";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_11","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_11","PAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_11 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_15(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_15.SOTGRU AS SOTGRU115";
        m_cSelect = m_cSelect+" ,link_1_15.DESCRI AS DESCRI115";
        m_cSelect = m_cSelect+" ,link_1_15.TIPOSOT AS TIPOSOT115";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_15","SOTGRUP","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_15","SOTGRUP","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_15 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_16(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_16.RAMGRU AS RAMGRU116";
        m_cSelect = m_cSelect+" ,link_1_16.DESCRI AS DESCRI116";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_16","RAMOGRUP","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_16","RAMOGRUP","RAMGRU",true);
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
    public void AddJoinedLink_1_23(String rightTable,String rightServer) {
      // questo link aggiunge 4 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+4,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_23.CODDIP AS CODDIP123";
        m_cSelect = m_cSelect+" ,link_1_23.DESCRIZ AS DESCRIZ123";
        m_cSelect = m_cSelect+" ,link_1_23.DESCCIT AS DESCCIT123";
        m_cSelect = m_cSelect+" ,link_1_23.CAB AS CAB123";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_23","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_23","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_23 = true;
          m_nColumns = m_nColumns+4;
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
  public armt_intermboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_intermbo");
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
      l_bResult = CanSaveChild(ardt_destwarn,m_cWv_ardt_destwarn,"m_cWv_ardt_destwarn");
      if (l_bResult) {
        l_bResult = CanSaveChild(ardt_cgo_tipall,m_cWv_ardt_cgo_tipall,"m_cWv_ardt_cgo_tipall");
        if (l_bResult) {
          l_bResult = CanSaveChild(ardt_cgo_subnets,m_cWv_ardt_cgo_subnets,"m_cWv_ardt_cgo_subnets");
          if (l_bResult) {
            l_bResult = CanSaveChild(ardt_destemail,m_cWv_ardt_destemail,"m_cWv_ardt_destemail");
            if (l_bResult) {
              l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
            } else {
              m_cLastMsgError = ardt_destemail.m_cLastMsgError;
            }
          } else {
            m_cLastMsgError = ardt_cgo_subnets.m_cLastMsgError;
          }
        } else {
          m_cLastMsgError = ardt_cgo_tipall.m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = ardt_destwarn.m_cLastMsgError;
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
          if ( ! (ardt_destwarn.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_destwarn)) {
            ardt_destwarn.SetFromContext(m_cWv_ardt_destwarn);
            m_cWv_ardt_destwarn = "_not_empty_";
          }
          if (ardt_destwarn.IsUpdated()) {
            ardt_destwarn.w_DWCODINT = w_CODINTER;
            if ( ! (ardt_destwarn.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_cgo_tipall.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_cgo_tipall)) {
            ardt_cgo_tipall.SetFromContext(m_cWv_ardt_cgo_tipall);
            m_cWv_ardt_cgo_tipall = "_not_empty_";
          }
          if (ardt_cgo_tipall.IsUpdated()) {
            ardt_cgo_tipall.w_TACODINT = w_CODINTER;
            if ( ! (ardt_cgo_tipall.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_cgo_subnets.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_cgo_subnets)) {
            ardt_cgo_subnets.SetFromContext(m_cWv_ardt_cgo_subnets);
            m_cWv_ardt_cgo_subnets = "_not_empty_";
          }
          if (ardt_cgo_subnets.IsUpdated()) {
            ardt_cgo_subnets.w_SNCODINT = w_CODINTER;
            if ( ! (ardt_cgo_subnets.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_destemail.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_destemail)) {
            ardt_destemail.SetFromContext(m_cWv_ardt_destemail);
            m_cWv_ardt_destemail = "_not_empty_";
          }
          if (ardt_destemail.IsUpdated()) {
            ardt_destemail.w_DWCODINT = w_CODINTER;
            if ( ! (ardt_destemail.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"CODINTER"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CODINTER) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_intermbo,m_cPhName_intermbo,m_cVirtName_intermbo,m_cVirtName_intermbo+".CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CODINTER,"C",11,0),m_cServer_intermbo,p_CODINTER),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_11(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_15(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_1_16(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_23(m_cPhName_anadip,m_cServer_anadip);
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
        w_DESCRIsta = "";
        w_DESCSGRU = "";
        w_DESCRAMGRU = "";
        w_DESCUIC = "";
        w_descdip = "";
        w_tipsot = "";
        w_xdescitdip = "";
        w_xcabdip = "";
        w_gUserCode = m_Ctx.GetGlobalNumber("gUserCode");
        w_ATTIV = "";
        w_gUrlApp = m_Ctx.GetGlobalString("gUrlApp");
        w_gAzienda = m_Ctx.GetGlobalString("gAzienda");
        w_appocert = "";
        w_PWDSER = "";
        w_xDESCAN = "";
        w_pathmanuale = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_TIPINTER = l_rsLoad.GetString("TIPINTER");
        // Link con tbtipint non eseguito: riporta solo campi
        w_RAGSOC = l_rsLoad.GetString("RAGSOC");
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        // Link con tbcitta non eseguito: riporta solo campi
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CAP = l_rsLoad.GetString("CAP");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
        w_PAESE = l_rsLoad.GetString("PAESE");
        if (l_oSqlLoader.m_bLink_1_11) {
          w_DESCRIsta = l_rsLoad.GetString("DESCRI111");
        } else {
          Link_IIXRREUEAM("Load");
        }
        w_CODFISC = l_rsLoad.GetString("CODFISC");
        w_PARTIVA = l_rsLoad.GetString("PARTIVA");
        w_DATANASC = l_rsLoad.GetDate("DATANASC");
        w_SOTGRUP = l_rsLoad.GetString("SOTGRUP");
        if (l_oSqlLoader.m_bLink_1_15) {
          w_DESCSGRU = l_rsLoad.GetString("DESCRI115");
          w_tipsot = l_rsLoad.GetString("TIPOSOT115");
        } else {
          Link_LLYIGAMXRH("Load");
        }
        w_RAMOGRUP = l_rsLoad.GetString("RAMOGRUP");
        if (l_oSqlLoader.m_bLink_1_16) {
          w_DESCRAMGRU = l_rsLoad.GetString("DESCRI116");
        } else {
          Link_RVNHQCXNEM("Load");
        }
        w_SETTSINT = l_rsLoad.GetString("SETTSINT");
        w_DESCUIC = "";
        Link_ZGNLLSFQHC("Load");
        w_TIPODOC = l_rsLoad.GetString("TIPODOC");
        // Link con tbtipdoc non eseguito: riporta solo campi
        w_SESSO = l_rsLoad.GetString("SESSO");
        w_NUMDOCUM = l_rsLoad.GetString("NUMDOCUM");
        w_DATARILASC = l_rsLoad.GetDate("DATARILASC");
        w_AUTRILASC = l_rsLoad.GetString("AUTRILASC");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_23) {
          w_descdip = l_rsLoad.GetString("DESCRIZ123");
          w_xdescitdip = l_rsLoad.GetString("DESCCIT123");
          w_xcabdip = l_rsLoad.GetString("CAB123");
        } else {
          Link_PSZTLCSMPB("Load");
        }
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_NOTE = l_rsLoad.GetString("NOTE");
        w_CODORO = l_rsLoad.GetString("CODORO");
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        w_TIPOPERS = l_rsLoad.GetString("TIPOPERS");
        w_IDCITTA = l_rsLoad.GetString("IDCITTA");
        w_DATAVALI = l_rsLoad.GetDate("DATAVALI");
        w_CONTATORE = l_rsLoad.GetDouble("CONTATORE");
        w_CFINVIO = l_rsLoad.GetString("CFINVIO");
        w_CAFINVIO = l_rsLoad.GetString("CAFINVIO");
        w_FILEINVIO = l_rsLoad.GetString("FILEINVIO");
        w_DATAINVIO = l_rsLoad.GetDate("DATAINVIO");
        w_IDSID = l_rsLoad.GetString("IDSID");
        w_SIDPASS = l_rsLoad.GetString("SIDPASS");
        w_PATHJAVA = l_rsLoad.GetString("PATHJAVA");
        w_TIPOINST = l_rsLoad.GetString("TIPOINST");
        w_FLGSIDAUTO = l_rsLoad.GetDouble("FLGSIDAUTO");
        w_TIPOSV = l_rsLoad.GetString("TIPOSV");
        w_LIMITE20 = l_rsLoad.GetDate("LIMITE20");
        w_CODVASP = l_rsLoad.GetString("CODVASP");
        w_ART1 = l_rsLoad.GetDouble("ART1");
        w_URLAPPL = l_rsLoad.GetString("URLAPPL");
        w_FLGLOG = l_rsLoad.GetString("FLGLOG");
        w_FLGAOS = l_rsLoad.GetString("FLGAOS");
        w_FLGEAOS = l_rsLoad.GetString("FLGEAOS");
        w_FLGCDOC = l_rsLoad.GetString("FLGCDOC");
        w_FLGFRAZ = l_rsLoad.GetString("FLGFRAZ");
        w_FLGAPERS = l_rsLoad.GetString("FLGAPERS");
        w_DTINIATT = l_rsLoad.GetDate("DTINIATT");
        w_FLGTIPIMP = l_rsLoad.GetString("FLGTIPIMP");
        w_FLGSTPCON = l_rsLoad.GetString("FLGSTPCON");
        w_FLGIMPAGE = l_rsLoad.GetString("FLGIMPAGE");
        w_FLGWU = l_rsLoad.GetString("FLGWU");
        w_IMPINTOPE = l_rsLoad.GetDouble("IMPINTOPE");
        w_FLGOPEXTR = l_rsLoad.GetString("FLGOPEXTR");
        w_FLGRAPCLI = l_rsLoad.GetString("FLGRAPCLI");
        w_FLGDATAIM = l_rsLoad.GetDouble("FLGDATAIM");
        w_FLGDATATP = l_rsLoad.GetDouble("FLGDATATP");
        w_NOCODFISC = l_rsLoad.GetDouble("NOCODFISC");
        w_FLGCHK = l_rsLoad.GetString("FLGCHK");
        w_CODAGE = l_rsLoad.GetString("CODAGE");
        w_SOSPMAF = l_rsLoad.GetString("SOSPMAF");
        w_FLGRITORNO = l_rsLoad.GetString("FLGRITORNO");
        w_FLGCREAAGE = l_rsLoad.GetString("FLGCREAAGE");
        w_DTTITAGE = l_rsLoad.GetDate("DTTITAGE");
        w_SCADSALDI = l_rsLoad.GetDate("SCADSALDI");
        w_FLGIPMT = l_rsLoad.GetString("FLGIPMT");
        w_LIMITEFRZ = l_rsLoad.GetDouble("LIMITEFRZ");
        w_LIMITEFRZ = l_rsLoad.GetDouble("LIMITEFRZ");
        w_DBPROT = l_rsLoad.GetString("DBPROT");
        w_OAMTPDOC = l_rsLoad.GetDouble("OAMTPDOC");
        w_DAYSIMPORT = l_rsLoad.GetDouble("DAYSIMPORT");
        w_DAYSIMPCMB = l_rsLoad.GetDouble("DAYSIMPCMB");
        w_FLGAWUPOS = l_rsLoad.GetString("FLGAWUPOS");
        w_WUGIOSCA = l_rsLoad.GetDouble("WUGIOSCA");
        w_WUGGALERT = l_rsLoad.GetDouble("WUGGALERT");
        w_RICEVUTE = l_rsLoad.GetString("RICEVUTE");
        w_OGGI3I4 = l_rsLoad.GetString("OGGI3I4");
        w_CGOTGDEFMUL = l_rsLoad.GetString("CGOTGDEFMUL");
        w_AUTOSARA = l_rsLoad.GetString("AUTOSARA");
        w_FLGCGOOTP = l_rsLoad.GetString("FLGCGOOTP");
        w_ITFLGPEP = l_rsLoad.GetString("ITFLGPEP");
        w_ITPWDPEP = l_rsLoad.GetString("ITPWDPEP");
        w_ITUSRPEP = l_rsLoad.GetString("ITUSRPEP");
        w_FLGAGGFAM = l_rsLoad.GetString("FLGAGGFAM");
        w_ALTSRVMAIL = l_rsLoad.GetString("ALTSRVMAIL");
        w_ALTPRTMAIL = l_rsLoad.GetString("ALTPRTMAIL");
        w_ALTEMLMAIL = l_rsLoad.GetString("ALTEMLMAIL");
        w_ALTUSRMAIL = l_rsLoad.GetString("ALTUSRMAIL");
        w_ALTPWDMAIL = l_rsLoad.GetString("ALTPWDMAIL");
        w_ALTSSLEMAIL = l_rsLoad.GetString("ALTSSLEMAIL");
        w_PATHIMPORT = l_rsLoad.GetString("PATHIMPORT");
        w_DESTEMAIL = l_rsLoad.GetString("DESTEMAIL");
        w_COGNOME = l_rsLoad.GetString("COGNOME");
        w_NOME = l_rsLoad.GetString("NOME");
        w_SESSO = l_rsLoad.GetString("SESSO");
        w_DNASC = l_rsLoad.GetDate("DNASC");
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        // Link con tbcitta non eseguito: riporta solo campi
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CITTADINA = l_rsLoad.GetString("CITTADINA");
        w_NASCOMUN = l_rsLoad.GetString("NASCOMUN");
        // Link con tbcitta non eseguito: riporta solo campi
        w_NASSTATO = l_rsLoad.GetString("NASSTATO");
        // Link con tbstati non eseguito: riporta solo campi
        w_PRNASC = l_rsLoad.GetString("PRNASC");
        w_SOGCOM = l_rsLoad.GetString("SOGCOM");
        w_TIPODOC = l_rsLoad.GetString("TIPODOC");
        w_BPCODPAT = l_rsLoad.GetString("BPCODPAT");
        w_BPENTSEG = l_rsLoad.GetString("BPENTSEG");
        w_BPCOGSEG = l_rsLoad.GetString("BPCOGSEG");
        w_BPNOMSEG = l_rsLoad.GetString("BPNOMSEG");
        w_BPTELSEG = l_rsLoad.GetString("BPTELSEG");
        w_BPEMLSEG = l_rsLoad.GetString("BPEMLSEG");
        w_ABI = l_rsLoad.GetString("ABI");
        w_CAB = l_rsLoad.GetString("CAB");
        w_GGWARNPRV = l_rsLoad.GetDouble("GGWARNPRV");
        w_GGWARNAUI = l_rsLoad.GetDouble("GGWARNAUI");
        w_SOGLIAMAX = l_rsLoad.GetDouble("SOGLIAMAX");
        w_CODVASP = l_rsLoad.GetString("CODVASP");
        w_IDOAM = l_rsLoad.GetString("IDOAM");
        w_IDOAMR = l_rsLoad.GetString("IDOAMR");
        w_SKT_SERVER = l_rsLoad.GetString("SKT_SERVER");
        w_SKT_PORT = l_rsLoad.GetDouble("SKT_PORT");
        w_SKT_PATHS = l_rsLoad.GetString("SKT_PATHS");
        w_SKT_MODET = l_rsLoad.GetString("SKT_MODET");
        w_RASPAUI = l_rsLoad.GetString("RASPAUI");
        w_RESPAUI = l_rsLoad.GetString("RESPAUI");
        w_TESTIP = l_rsLoad.GetString("TESTIP");
        w_MINFRZSNAI = l_rsLoad.GetDouble("MINFRZSNAI");
        w_FLGSCDFRZ = l_rsLoad.GetString("FLGSCDFRZ");
        w_GIORNIFRZ = l_rsLoad.GetDouble("GIORNIFRZ");
        w_LIMITVLT = l_rsLoad.GetDouble("LIMITVLT");
        w_LIMITVNP = l_rsLoad.GetDouble("LIMITVNP");
        w_FLGSTPDIR = l_rsLoad.GetString("FLGSTPDIR");
        w_FLGNODOC = l_rsLoad.GetString("FLGNODOC");
        w_SNAISTOR = l_rsLoad.GetString("SNAISTOR");
        w_LIMITEFRZ = l_rsLoad.GetDouble("LIMITEFRZ");
        w_FRAZDEL = l_rsLoad.GetString("FRAZDEL");
        w_PATHAPP = l_rsLoad.GetString("PATHAPP");
        w_FLGDDOC = l_rsLoad.GetString("FLGDDOC");
        w_FLGLIGHT = l_rsLoad.GetString("FLGLIGHT");
        w_FLGCGOPWD = l_rsLoad.GetString("FLGCGOPWD");
        w_PATHSID = l_rsLoad.GetString("PATHSID");
        w_PATHCERT = l_rsLoad.GetString("PATHCERT");
        w_PATHFTP = l_rsLoad.GetString("PATHFTP");
        w_FLGUTEAGE = l_rsLoad.GetString("FLGUTEAGE");
        w_PRGAEPATH = l_rsLoad.GetString("PRGAEPATH");
        w_NUMGIORN = l_rsLoad.GetDouble("NUMGIORN");
        w_FLGCGOOTP = l_rsLoad.GetString("FLGCGOOTP");
        w_FLGCGOQADV = l_rsLoad.GetString("FLGCGOQADV");
        w_BLOCCOUSER = l_rsLoad.GetDouble("BLOCCOUSER");
        w_CGOFLGPROF = l_rsLoad.GetString("CGOFLGPROF");
        w_ALTSRVMAIL = l_rsLoad.GetString("ALTSRVMAIL");
        w_ALTPRTMAIL = l_rsLoad.GetString("ALTPRTMAIL");
        w_ALTEMLMAIL = l_rsLoad.GetString("ALTEMLMAIL");
        w_ALTUSRMAIL = l_rsLoad.GetString("ALTUSRMAIL");
        w_ALTPWDMAIL = l_rsLoad.GetString("ALTPWDMAIL");
        w_FLGGESDOC = l_rsLoad.GetString("FLGGESDOC");
        w_USRGESDOC = l_rsLoad.GetString("USRGESDOC");
        w_PWDGESDOC = l_rsLoad.GetString("PWDGESDOC");
        w_URLDESDOC = l_rsLoad.GetString("URLDESDOC");
        w_EMAILDOC = l_rsLoad.GetString("EMAILDOC");
        w_DATADOC = l_rsLoad.GetDate("DATADOC");
        w_PATHDOCBAC = l_rsLoad.GetString("PATHDOCBAC");
        w_IMPPATH = l_rsLoad.GetString("IMPPATH");
        w_CGOTGDEFMUL = l_rsLoad.GetString("CGOTGDEFMUL");
        w_SONUMMESI = l_rsLoad.GetDouble("SONUMMESI");
        w_SOMESIBACK = l_rsLoad.GetDouble("SOMESIBACK");
        w_SOSHELLCMD = l_rsLoad.GetString("SOSHELLCMD");
        w_SOAMBIENTE = l_rsLoad.GetString("SOAMBIENTE");
        w_SOPATHIMPORT = l_rsLoad.GetString("SOPATHIMPORT");
        w_SOORAIMPORT = l_rsLoad.GetDouble("SOORAIMPORT");
        w_QADV_SOGLIA = l_rsLoad.GetDouble("QADV_SOGLIA");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_destwarn = "";
        ardt_destwarn.m_lCtxLoaded = false;
        m_cWv_ardt_cgo_tipall = "";
        ardt_cgo_tipall.m_lCtxLoaded = false;
        m_cWv_ardt_cgo_subnets = "";
        ardt_cgo_subnets.m_lCtxLoaded = false;
        m_cWv_ardt_destemail = "";
        ardt_destemail.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"intermbo")) {
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
    return Load(w_CODINTER);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_intermbo);
      l_cSql = "insert into "+m_oWrInfo_intermbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"TIPINTER,";
      l_cSql = l_cSql+"RAGSOC,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CAP,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"DOMICILIO,";
      l_cSql = l_cSql+"PAESE,";
      l_cSql = l_cSql+"CODFISC,";
      l_cSql = l_cSql+"PARTIVA,";
      l_cSql = l_cSql+"DATANASC,";
      l_cSql = l_cSql+"SOTGRUP,";
      l_cSql = l_cSql+"RAMOGRUP,";
      l_cSql = l_cSql+"SETTSINT,";
      l_cSql = l_cSql+"TIPODOC,";
      l_cSql = l_cSql+"SESSO,";
      l_cSql = l_cSql+"NUMDOCUM,";
      l_cSql = l_cSql+"DATARILASC,";
      l_cSql = l_cSql+"AUTRILASC,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"CONNES,";
      l_cSql = l_cSql+"NOTE,";
      l_cSql = l_cSql+"CODORO,";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"TIPOPERS,";
      l_cSql = l_cSql+"IDCITTA,";
      l_cSql = l_cSql+"DATAVALI,";
      l_cSql = l_cSql+"CONTATORE,";
      l_cSql = l_cSql+"CFINVIO,";
      l_cSql = l_cSql+"CAFINVIO,";
      l_cSql = l_cSql+"FILEINVIO,";
      l_cSql = l_cSql+"DATAINVIO,";
      l_cSql = l_cSql+"IDSID,";
      l_cSql = l_cSql+"SIDPASS,";
      l_cSql = l_cSql+"PATHJAVA,";
      l_cSql = l_cSql+"TIPOINST,";
      l_cSql = l_cSql+"FLGSIDAUTO,";
      l_cSql = l_cSql+"TIPOSV,";
      l_cSql = l_cSql+"LIMITE20,";
      l_cSql = l_cSql+"CODVASP,";
      l_cSql = l_cSql+"ART1,";
      l_cSql = l_cSql+"URLAPPL,";
      l_cSql = l_cSql+"FLGLOG,";
      l_cSql = l_cSql+"FLGAOS,";
      l_cSql = l_cSql+"FLGEAOS,";
      l_cSql = l_cSql+"FLGCDOC,";
      l_cSql = l_cSql+"FLGFRAZ,";
      l_cSql = l_cSql+"FLGAPERS,";
      l_cSql = l_cSql+"DTINIATT,";
      l_cSql = l_cSql+"FLGTIPIMP,";
      l_cSql = l_cSql+"FLGSTPCON,";
      l_cSql = l_cSql+"FLGIMPAGE,";
      l_cSql = l_cSql+"FLGWU,";
      l_cSql = l_cSql+"IMPINTOPE,";
      l_cSql = l_cSql+"FLGOPEXTR,";
      l_cSql = l_cSql+"FLGRAPCLI,";
      l_cSql = l_cSql+"FLGDATAIM,";
      l_cSql = l_cSql+"FLGDATATP,";
      l_cSql = l_cSql+"NOCODFISC,";
      l_cSql = l_cSql+"FLGCHK,";
      l_cSql = l_cSql+"CODAGE,";
      l_cSql = l_cSql+"SOSPMAF,";
      l_cSql = l_cSql+"FLGRITORNO,";
      l_cSql = l_cSql+"FLGCREAAGE,";
      l_cSql = l_cSql+"DTTITAGE,";
      l_cSql = l_cSql+"SCADSALDI,";
      l_cSql = l_cSql+"FLGIPMT,";
      l_cSql = l_cSql+"LIMITEFRZ,";
      l_cSql = l_cSql+"DBPROT,";
      l_cSql = l_cSql+"OAMTPDOC,";
      l_cSql = l_cSql+"DAYSIMPORT,";
      l_cSql = l_cSql+"DAYSIMPCMB,";
      l_cSql = l_cSql+"FLGAWUPOS,";
      l_cSql = l_cSql+"WUGIOSCA,";
      l_cSql = l_cSql+"WUGGALERT,";
      l_cSql = l_cSql+"RICEVUTE,";
      l_cSql = l_cSql+"OGGI3I4,";
      l_cSql = l_cSql+"CGOTGDEFMUL,";
      l_cSql = l_cSql+"AUTOSARA,";
      l_cSql = l_cSql+"FLGCGOOTP,";
      l_cSql = l_cSql+"ITFLGPEP,";
      l_cSql = l_cSql+"ITPWDPEP,";
      l_cSql = l_cSql+"ITUSRPEP,";
      l_cSql = l_cSql+"FLGAGGFAM,";
      l_cSql = l_cSql+"ALTSRVMAIL,";
      l_cSql = l_cSql+"ALTPRTMAIL,";
      l_cSql = l_cSql+"ALTEMLMAIL,";
      l_cSql = l_cSql+"ALTUSRMAIL,";
      l_cSql = l_cSql+"ALTPWDMAIL,";
      l_cSql = l_cSql+"ALTSSLEMAIL,";
      l_cSql = l_cSql+"PATHIMPORT,";
      l_cSql = l_cSql+"DESTEMAIL,";
      l_cSql = l_cSql+"COGNOME,";
      l_cSql = l_cSql+"NOME,";
      l_cSql = l_cSql+"DNASC,";
      l_cSql = l_cSql+"CITTADINA,";
      l_cSql = l_cSql+"NASCOMUN,";
      l_cSql = l_cSql+"NASSTATO,";
      l_cSql = l_cSql+"PRNASC,";
      l_cSql = l_cSql+"SOGCOM,";
      l_cSql = l_cSql+"BPCODPAT,";
      l_cSql = l_cSql+"BPENTSEG,";
      l_cSql = l_cSql+"BPCOGSEG,";
      l_cSql = l_cSql+"BPNOMSEG,";
      l_cSql = l_cSql+"BPTELSEG,";
      l_cSql = l_cSql+"BPEMLSEG,";
      l_cSql = l_cSql+"ABI,";
      l_cSql = l_cSql+"CAB,";
      l_cSql = l_cSql+"GGWARNPRV,";
      l_cSql = l_cSql+"GGWARNAUI,";
      l_cSql = l_cSql+"SOGLIAMAX,";
      l_cSql = l_cSql+"IDOAM,";
      l_cSql = l_cSql+"IDOAMR,";
      l_cSql = l_cSql+"SKT_SERVER,";
      l_cSql = l_cSql+"SKT_PORT,";
      l_cSql = l_cSql+"SKT_PATHS,";
      l_cSql = l_cSql+"SKT_MODET,";
      l_cSql = l_cSql+"RASPAUI,";
      l_cSql = l_cSql+"RESPAUI,";
      l_cSql = l_cSql+"TESTIP,";
      l_cSql = l_cSql+"MINFRZSNAI,";
      l_cSql = l_cSql+"FLGSCDFRZ,";
      l_cSql = l_cSql+"GIORNIFRZ,";
      l_cSql = l_cSql+"LIMITVLT,";
      l_cSql = l_cSql+"LIMITVNP,";
      l_cSql = l_cSql+"FLGSTPDIR,";
      l_cSql = l_cSql+"FLGNODOC,";
      l_cSql = l_cSql+"SNAISTOR,";
      l_cSql = l_cSql+"FRAZDEL,";
      l_cSql = l_cSql+"PATHAPP,";
      l_cSql = l_cSql+"FLGDDOC,";
      l_cSql = l_cSql+"FLGLIGHT,";
      l_cSql = l_cSql+"FLGCGOPWD,";
      l_cSql = l_cSql+"PATHSID,";
      l_cSql = l_cSql+"PATHCERT,";
      l_cSql = l_cSql+"PATHFTP,";
      l_cSql = l_cSql+"FLGUTEAGE,";
      l_cSql = l_cSql+"PRGAEPATH,";
      l_cSql = l_cSql+"NUMGIORN,";
      l_cSql = l_cSql+"FLGCGOQADV,";
      l_cSql = l_cSql+"BLOCCOUSER,";
      l_cSql = l_cSql+"CGOFLGPROF,";
      l_cSql = l_cSql+"FLGGESDOC,";
      l_cSql = l_cSql+"USRGESDOC,";
      l_cSql = l_cSql+"PWDGESDOC,";
      l_cSql = l_cSql+"URLDESDOC,";
      l_cSql = l_cSql+"EMAILDOC,";
      l_cSql = l_cSql+"DATADOC,";
      l_cSql = l_cSql+"PATHDOCBAC,";
      l_cSql = l_cSql+"IMPPATH,";
      l_cSql = l_cSql+"SONUMMESI,";
      l_cSql = l_cSql+"SOMESIBACK,";
      l_cSql = l_cSql+"SOSHELLCMD,";
      l_cSql = l_cSql+"SOAMBIENTE,";
      l_cSql = l_cSql+"SOPATHIMPORT,";
      l_cSql = l_cSql+"SOORAIMPORT,";
      l_cSql = l_cSql+"QADV_SOGLIA,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_intermbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"intermbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPINTER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAGSOC,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODFISC,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PARTIVA,"C",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATANASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOTGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAMOGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SETTSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPODOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMDOCUM,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARILASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTRILASC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNES,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOTE,"M",10,0,m_cServer_intermbo,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODORO,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOPERS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDCITTA,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVALI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONTATORE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFINVIO,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAFINVIO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FILEINVIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAINVIO,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDSID,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SIDPASS,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHJAVA,"C",250,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINST,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGSIDAUTO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOSV,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_LIMITE20,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODVASP,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ART1,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_URLAPPL,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGLOG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGAOS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGEAOS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCDOC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGAPERS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DTINIATT,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGTIPIMP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGSTPCON,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGIMPAGE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGWU,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPINTOPE,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGOPEXTR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGRAPCLI,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGDATAIM,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGDATATP,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOCODFISC,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCHK,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODAGE,"C",7,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSPMAF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGRITORNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCREAAGE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DTTITAGE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SCADSALDI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGIPMT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_LIMITEFRZ,"N",10,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DBPROT,"C",100,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OAMTPDOC,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAYSIMPORT,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAYSIMPCMB,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGAWUPOS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUGIOSCA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUGGALERT,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RICEVUTE,"C",250,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OGGI3I4,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOTGDEFMUL,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTOSARA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCGOOTP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ITFLGPEP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ITPWDPEP,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ITUSRPEP,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGAGGFAM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTSRVMAIL,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTPRTMAIL,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTEMLMAIL,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTUSRMAIL,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTPWDMAIL,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ALTSSLEMAIL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHIMPORT,"C",128,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESTEMAIL,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COGNOME,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOME,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DNASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CITTADINA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_NASCOMUN,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_NASSTATO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRNASC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOGCOM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BPCODPAT,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BPENTSEG,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BPCOGSEG,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BPNOMSEG,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BPTELSEG,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BPEMLSEG,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ABI,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GGWARNPRV,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GGWARNAUI,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOGLIAMAX,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDOAM,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDOAMR,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SKT_SERVER,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SKT_PORT,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SKT_PATHS,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SKT_MODET,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RASPAUI,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RESPAUI,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TESTIP,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MINFRZSNAI,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGSCDFRZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_GIORNIFRZ,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_LIMITVLT,"N",10,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_LIMITVNP,"N",10,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGSTPDIR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGNODOC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SNAISTOR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FRAZDEL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHAPP,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGDDOC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGLIGHT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCGOPWD,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHSID,"C",250,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHCERT,"C",250,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHFTP,"C",128,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGUTEAGE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGAEPATH,"C",250,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMGIORN,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGCGOQADV,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_BLOCCOUSER,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOFLGPROF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGGESDOC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_USRGESDOC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PWDGESDOC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_URLDESDOC,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_EMAILDOC,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATADOC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PATHDOCBAC,"C",128,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPPATH,"C",240,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SONUMMESI,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOMESIBACK,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSHELLCMD,"M",10,0,m_cServer_intermbo,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOAMBIENTE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOPATHIMPORT,"M",10,0,m_cServer_intermbo,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOORAIMPORT,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_SOGLIA,"N",4,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_intermbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"intermbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_intermbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_intermbo);
      l_cSql = "Update "+m_oWrInfo_intermbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TIPINTER = "+CPLib.ToSQLNull(w_TIPINTER,"C",2,0);
      l_cSql = l_cSql+", RAGSOC = "+CPLib.ToSQL(w_RAGSOC,"C",70,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",9,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", DOMICILIO = "+CPLib.ToSQL(w_DOMICILIO,"C",35,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQLNull(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", CODFISC = "+CPLib.ToSQL(w_CODFISC,"C",16,0);
      l_cSql = l_cSql+", PARTIVA = "+CPLib.ToSQL(w_PARTIVA,"C",14,0);
      l_cSql = l_cSql+", DATANASC = "+CPLib.ToSQL(w_DATANASC,"D",8,0);
      l_cSql = l_cSql+", SOTGRUP = "+CPLib.ToSQLNull(w_SOTGRUP,"C",3,0);
      l_cSql = l_cSql+", RAMOGRUP = "+CPLib.ToSQLNull(w_RAMOGRUP,"C",3,0);
      l_cSql = l_cSql+", SETTSINT = "+CPLib.ToSQLNull(w_SETTSINT,"C",3,0);
      l_cSql = l_cSql+", TIPODOC = "+CPLib.ToSQLNull(w_TIPODOC,"C",2,0);
      l_cSql = l_cSql+", SESSO = "+CPLib.ToSQL(w_SESSO,"C",1,0);
      l_cSql = l_cSql+", NUMDOCUM = "+CPLib.ToSQL(w_NUMDOCUM,"C",15,0);
      l_cSql = l_cSql+", DATARILASC = "+CPLib.ToSQL(w_DATARILASC,"D",8,0);
      l_cSql = l_cSql+", AUTRILASC = "+CPLib.ToSQL(w_AUTRILASC,"C",30,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", CONNES = "+CPLib.ToSQL(w_CONNES,"C",16,0);
      l_cSql = l_cSql+", NOTE = "+CPLib.ToSQL(w_NOTE,"M",10,0,m_cServer_intermbo,m_oParameters);
      l_cSql = l_cSql+", CODORO = "+CPLib.ToSQL(w_CODORO,"C",20,0);
      l_cSql = l_cSql+", TIPOPERS = "+CPLib.ToSQL(w_TIPOPERS,"C",1,0);
      l_cSql = l_cSql+", IDCITTA = "+CPLib.ToSQL(w_IDCITTA,"C",10,0);
      l_cSql = l_cSql+", DATAVALI = "+CPLib.ToSQL(w_DATAVALI,"D",8,0);
      l_cSql = l_cSql+", CONTATORE = "+CPLib.ToSQL(w_CONTATORE,"N",15,0);
      l_cSql = l_cSql+", CFINVIO = "+CPLib.ToSQL(w_CFINVIO,"C",16,0);
      l_cSql = l_cSql+", CAFINVIO = "+CPLib.ToSQL(w_CAFINVIO,"C",5,0);
      l_cSql = l_cSql+", FILEINVIO = "+CPLib.ToSQL(w_FILEINVIO,"C",1,0);
      l_cSql = l_cSql+", DATAINVIO = "+CPLib.ToSQL(w_DATAINVIO,"D",8,0);
      l_cSql = l_cSql+", IDSID = "+CPLib.ToSQL(w_IDSID,"C",8,0);
      l_cSql = l_cSql+", SIDPASS = "+CPLib.ToSQL(w_SIDPASS,"C",30,0);
      l_cSql = l_cSql+", PATHJAVA = "+CPLib.ToSQL(w_PATHJAVA,"C",250,0);
      l_cSql = l_cSql+", TIPOINST = "+CPLib.ToSQL(w_TIPOINST,"C",1,0);
      l_cSql = l_cSql+", FLGSIDAUTO = "+CPLib.ToSQL(w_FLGSIDAUTO,"N",1,0);
      l_cSql = l_cSql+", TIPOSV = "+CPLib.ToSQL(w_TIPOSV,"C",3,0);
      l_cSql = l_cSql+", LIMITE20 = "+CPLib.ToSQL(w_LIMITE20,"D",8,0);
      l_cSql = l_cSql+", CODVASP = "+CPLib.ToSQL(w_CODVASP,"C",10,0);
      l_cSql = l_cSql+", ART1 = "+CPLib.ToSQL(w_ART1,"N",1,0);
      l_cSql = l_cSql+", URLAPPL = "+CPLib.ToSQL(w_URLAPPL,"C",80,0);
      l_cSql = l_cSql+", FLGLOG = "+CPLib.ToSQL(w_FLGLOG,"C",1,0);
      l_cSql = l_cSql+", FLGAOS = "+CPLib.ToSQL(w_FLGAOS,"C",1,0);
      l_cSql = l_cSql+", FLGEAOS = "+CPLib.ToSQL(w_FLGEAOS,"C",1,0);
      l_cSql = l_cSql+", FLGCDOC = "+CPLib.ToSQL(w_FLGCDOC,"C",1,0);
      l_cSql = l_cSql+", FLGFRAZ = "+CPLib.ToSQL(w_FLGFRAZ,"C",1,0);
      l_cSql = l_cSql+", FLGAPERS = "+CPLib.ToSQL(w_FLGAPERS,"C",1,0);
      l_cSql = l_cSql+", DTINIATT = "+CPLib.ToSQL(w_DTINIATT,"D",8,0);
      l_cSql = l_cSql+", FLGTIPIMP = "+CPLib.ToSQL(w_FLGTIPIMP,"C",1,0);
      l_cSql = l_cSql+", FLGSTPCON = "+CPLib.ToSQL(w_FLGSTPCON,"C",1,0);
      l_cSql = l_cSql+", FLGIMPAGE = "+CPLib.ToSQL(w_FLGIMPAGE,"C",1,0);
      l_cSql = l_cSql+", FLGWU = "+CPLib.ToSQL(w_FLGWU,"C",1,0);
      l_cSql = l_cSql+", IMPINTOPE = "+CPLib.ToSQL(w_IMPINTOPE,"N",12,2);
      l_cSql = l_cSql+", FLGOPEXTR = "+CPLib.ToSQL(w_FLGOPEXTR,"C",1,0);
      l_cSql = l_cSql+", FLGRAPCLI = "+CPLib.ToSQL(w_FLGRAPCLI,"C",1,0);
      l_cSql = l_cSql+", FLGDATAIM = "+CPLib.ToSQL(w_FLGDATAIM,"N",1,0);
      l_cSql = l_cSql+", FLGDATATP = "+CPLib.ToSQL(w_FLGDATATP,"N",1,0);
      l_cSql = l_cSql+", NOCODFISC = "+CPLib.ToSQL(w_NOCODFISC,"N",1,0);
      l_cSql = l_cSql+", FLGCHK = "+CPLib.ToSQL(w_FLGCHK,"C",1,0);
      l_cSql = l_cSql+", CODAGE = "+CPLib.ToSQL(w_CODAGE,"C",7,0);
      l_cSql = l_cSql+", SOSPMAF = "+CPLib.ToSQL(w_SOSPMAF,"C",1,0);
      l_cSql = l_cSql+", FLGRITORNO = "+CPLib.ToSQL(w_FLGRITORNO,"C",1,0);
      l_cSql = l_cSql+", FLGCREAAGE = "+CPLib.ToSQL(w_FLGCREAAGE,"C",1,0);
      l_cSql = l_cSql+", DTTITAGE = "+CPLib.ToSQL(w_DTTITAGE,"D",8,0);
      l_cSql = l_cSql+", SCADSALDI = "+CPLib.ToSQL(w_SCADSALDI,"D",8,0);
      l_cSql = l_cSql+", FLGIPMT = "+CPLib.ToSQL(w_FLGIPMT,"C",1,0);
      l_cSql = l_cSql+", LIMITEFRZ = "+CPLib.ToSQL(w_LIMITEFRZ,"N",10,2);
      l_cSql = l_cSql+", DBPROT = "+CPLib.ToSQL(w_DBPROT,"C",100,0);
      l_cSql = l_cSql+", OAMTPDOC = "+CPLib.ToSQL(w_OAMTPDOC,"N",1,0);
      l_cSql = l_cSql+", DAYSIMPORT = "+CPLib.ToSQL(w_DAYSIMPORT,"N",2,0);
      l_cSql = l_cSql+", DAYSIMPCMB = "+CPLib.ToSQL(w_DAYSIMPCMB,"N",2,0);
      l_cSql = l_cSql+", FLGAWUPOS = "+CPLib.ToSQL(w_FLGAWUPOS,"C",1,0);
      l_cSql = l_cSql+", WUGIOSCA = "+CPLib.ToSQL(w_WUGIOSCA,"N",3,0);
      l_cSql = l_cSql+", WUGGALERT = "+CPLib.ToSQL(w_WUGGALERT,"N",3,0);
      l_cSql = l_cSql+", RICEVUTE = "+CPLib.ToSQL(w_RICEVUTE,"C",250,0);
      l_cSql = l_cSql+", OGGI3I4 = "+CPLib.ToSQL(w_OGGI3I4,"C",1,0);
      l_cSql = l_cSql+", CGOTGDEFMUL = "+CPLib.ToSQL(w_CGOTGDEFMUL,"C",3,0);
      l_cSql = l_cSql+", AUTOSARA = "+CPLib.ToSQL(w_AUTOSARA,"C",1,0);
      l_cSql = l_cSql+", FLGCGOOTP = "+CPLib.ToSQL(w_FLGCGOOTP,"C",1,0);
      l_cSql = l_cSql+", ITFLGPEP = "+CPLib.ToSQL(w_ITFLGPEP,"C",1,0);
      l_cSql = l_cSql+", ITPWDPEP = "+CPLib.ToSQL(w_ITPWDPEP,"C",50,0);
      l_cSql = l_cSql+", ITUSRPEP = "+CPLib.ToSQL(w_ITUSRPEP,"C",50,0);
      l_cSql = l_cSql+", FLGAGGFAM = "+CPLib.ToSQL(w_FLGAGGFAM,"C",1,0);
      l_cSql = l_cSql+", ALTSRVMAIL = "+CPLib.ToSQL(w_ALTSRVMAIL,"C",50,0);
      l_cSql = l_cSql+", ALTPRTMAIL = "+CPLib.ToSQL(w_ALTPRTMAIL,"C",5,0);
      l_cSql = l_cSql+", ALTEMLMAIL = "+CPLib.ToSQL(w_ALTEMLMAIL,"C",50,0);
      l_cSql = l_cSql+", ALTUSRMAIL = "+CPLib.ToSQL(w_ALTUSRMAIL,"C",50,0);
      l_cSql = l_cSql+", ALTPWDMAIL = "+CPLib.ToSQL(w_ALTPWDMAIL,"C",80,0);
      l_cSql = l_cSql+", ALTSSLEMAIL = "+CPLib.ToSQL(w_ALTSSLEMAIL,"C",1,0);
      l_cSql = l_cSql+", PATHIMPORT = "+CPLib.ToSQL(w_PATHIMPORT,"C",128,0);
      l_cSql = l_cSql+", DESTEMAIL = "+CPLib.ToSQL(w_DESTEMAIL,"C",80,0);
      l_cSql = l_cSql+", COGNOME = "+CPLib.ToSQL(w_COGNOME,"C",30,0);
      l_cSql = l_cSql+", NOME = "+CPLib.ToSQL(w_NOME,"C",30,0);
      l_cSql = l_cSql+", DNASC = "+CPLib.ToSQL(w_DNASC,"D",8,0);
      l_cSql = l_cSql+", CITTADINA = "+CPLib.ToSQL(w_CITTADINA,"C",2,0);
      l_cSql = l_cSql+", NASCOMUN = "+CPLib.ToSQLNull(w_NASCOMUN,"C",30,0);
      l_cSql = l_cSql+", NASSTATO = "+CPLib.ToSQLNull(w_NASSTATO,"C",30,0);
      l_cSql = l_cSql+", PRNASC = "+CPLib.ToSQL(w_PRNASC,"C",2,0);
      l_cSql = l_cSql+", SOGCOM = "+CPLib.ToSQL(w_SOGCOM,"C",1,0);
      l_cSql = l_cSql+", BPCODPAT = "+CPLib.ToSQL(w_BPCODPAT,"C",12,0);
      l_cSql = l_cSql+", BPENTSEG = "+CPLib.ToSQL(w_BPENTSEG,"C",12,0);
      l_cSql = l_cSql+", BPCOGSEG = "+CPLib.ToSQL(w_BPCOGSEG,"C",30,0);
      l_cSql = l_cSql+", BPNOMSEG = "+CPLib.ToSQL(w_BPNOMSEG,"C",30,0);
      l_cSql = l_cSql+", BPTELSEG = "+CPLib.ToSQL(w_BPTELSEG,"C",15,0);
      l_cSql = l_cSql+", BPEMLSEG = "+CPLib.ToSQL(w_BPEMLSEG,"C",50,0);
      l_cSql = l_cSql+", ABI = "+CPLib.ToSQL(w_ABI,"C",6,0);
      l_cSql = l_cSql+", CAB = "+CPLib.ToSQL(w_CAB,"C",6,0);
      l_cSql = l_cSql+", GGWARNPRV = "+CPLib.ToSQL(w_GGWARNPRV,"N",3,0);
      l_cSql = l_cSql+", GGWARNAUI = "+CPLib.ToSQL(w_GGWARNAUI,"N",3,0);
      l_cSql = l_cSql+", SOGLIAMAX = "+CPLib.ToSQL(w_SOGLIAMAX,"N",12,2);
      l_cSql = l_cSql+", IDOAM = "+CPLib.ToSQL(w_IDOAM,"C",8,0);
      l_cSql = l_cSql+", IDOAMR = "+CPLib.ToSQL(w_IDOAMR,"C",8,0);
      l_cSql = l_cSql+", SKT_SERVER = "+CPLib.ToSQL(w_SKT_SERVER,"C",30,0);
      l_cSql = l_cSql+", SKT_PORT = "+CPLib.ToSQL(w_SKT_PORT,"N",5,0);
      l_cSql = l_cSql+", SKT_PATHS = "+CPLib.ToSQL(w_SKT_PATHS,"C",60,0);
      l_cSql = l_cSql+", SKT_MODET = "+CPLib.ToSQL(w_SKT_MODET,"C",5,0);
      l_cSql = l_cSql+", RASPAUI = "+CPLib.ToSQL(w_RASPAUI,"C",50,0);
      l_cSql = l_cSql+", RESPAUI = "+CPLib.ToSQL(w_RESPAUI,"C",50,0);
      l_cSql = l_cSql+", TESTIP = "+CPLib.ToSQL(w_TESTIP,"C",11,0);
      l_cSql = l_cSql+", MINFRZSNAI = "+CPLib.ToSQL(w_MINFRZSNAI,"N",12,2);
      l_cSql = l_cSql+", FLGSCDFRZ = "+CPLib.ToSQL(w_FLGSCDFRZ,"C",1,0);
      l_cSql = l_cSql+", GIORNIFRZ = "+CPLib.ToSQL(w_GIORNIFRZ,"N",3,0);
      l_cSql = l_cSql+", LIMITVLT = "+CPLib.ToSQL(w_LIMITVLT,"N",10,2);
      l_cSql = l_cSql+", LIMITVNP = "+CPLib.ToSQL(w_LIMITVNP,"N",10,2);
      l_cSql = l_cSql+", FLGSTPDIR = "+CPLib.ToSQL(w_FLGSTPDIR,"C",1,0);
      l_cSql = l_cSql+", FLGNODOC = "+CPLib.ToSQL(w_FLGNODOC,"C",1,0);
      l_cSql = l_cSql+", SNAISTOR = "+CPLib.ToSQL(w_SNAISTOR,"C",1,0);
      l_cSql = l_cSql+", FRAZDEL = "+CPLib.ToSQL(w_FRAZDEL,"C",1,0);
      l_cSql = l_cSql+", PATHAPP = "+CPLib.ToSQL(w_PATHAPP,"C",80,0);
      l_cSql = l_cSql+", FLGDDOC = "+CPLib.ToSQL(w_FLGDDOC,"C",1,0);
      l_cSql = l_cSql+", FLGLIGHT = "+CPLib.ToSQL(w_FLGLIGHT,"C",1,0);
      l_cSql = l_cSql+", FLGCGOPWD = "+CPLib.ToSQL(w_FLGCGOPWD,"C",1,0);
      l_cSql = l_cSql+", PATHSID = "+CPLib.ToSQL(w_PATHSID,"C",250,0);
      l_cSql = l_cSql+", PATHCERT = "+CPLib.ToSQL(w_PATHCERT,"C",250,0);
      l_cSql = l_cSql+", PATHFTP = "+CPLib.ToSQL(w_PATHFTP,"C",128,0);
      l_cSql = l_cSql+", FLGUTEAGE = "+CPLib.ToSQL(w_FLGUTEAGE,"C",1,0);
      l_cSql = l_cSql+", PRGAEPATH = "+CPLib.ToSQL(w_PRGAEPATH,"C",250,0);
      l_cSql = l_cSql+", NUMGIORN = "+CPLib.ToSQL(w_NUMGIORN,"N",3,0);
      l_cSql = l_cSql+", FLGCGOQADV = "+CPLib.ToSQL(w_FLGCGOQADV,"C",1,0);
      l_cSql = l_cSql+", BLOCCOUSER = "+CPLib.ToSQL(w_BLOCCOUSER,"N",3,0);
      l_cSql = l_cSql+", CGOFLGPROF = "+CPLib.ToSQL(w_CGOFLGPROF,"C",1,0);
      l_cSql = l_cSql+", FLGGESDOC = "+CPLib.ToSQL(w_FLGGESDOC,"C",1,0);
      l_cSql = l_cSql+", USRGESDOC = "+CPLib.ToSQL(w_USRGESDOC,"C",30,0);
      l_cSql = l_cSql+", PWDGESDOC = "+CPLib.ToSQL(w_PWDGESDOC,"C",30,0);
      l_cSql = l_cSql+", URLDESDOC = "+CPLib.ToSQL(w_URLDESDOC,"C",80,0);
      l_cSql = l_cSql+", EMAILDOC = "+CPLib.ToSQL(w_EMAILDOC,"C",80,0);
      l_cSql = l_cSql+", DATADOC = "+CPLib.ToSQL(w_DATADOC,"D",8,0);
      l_cSql = l_cSql+", PATHDOCBAC = "+CPLib.ToSQL(w_PATHDOCBAC,"C",128,0);
      l_cSql = l_cSql+", IMPPATH = "+CPLib.ToSQL(w_IMPPATH,"C",240,0);
      l_cSql = l_cSql+", SONUMMESI = "+CPLib.ToSQL(w_SONUMMESI,"N",2,0);
      l_cSql = l_cSql+", SOMESIBACK = "+CPLib.ToSQL(w_SOMESIBACK,"N",2,0);
      l_cSql = l_cSql+", SOSHELLCMD = "+CPLib.ToSQL(w_SOSHELLCMD,"M",10,0,m_cServer_intermbo,m_oParameters);
      l_cSql = l_cSql+", SOAMBIENTE = "+CPLib.ToSQL(w_SOAMBIENTE,"C",1,0);
      l_cSql = l_cSql+", SOPATHIMPORT = "+CPLib.ToSQL(w_SOPATHIMPORT,"M",10,0,m_cServer_intermbo,m_oParameters);
      l_cSql = l_cSql+", SOORAIMPORT = "+CPLib.ToSQL(w_SOORAIMPORT,"N",2,0);
      l_cSql = l_cSql+", QADV_SOGLIA = "+CPLib.ToSQL(w_QADV_SOGLIA,"N",4,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"intermbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",11,0),m_cServer_intermbo,w_CODINTER);
      l_cSql = l_cSql+m_oWrInfo_intermbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"intermbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_intermbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_CODINTER) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_CODINTER);
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
          ardt_destwarn.w_DWCODINT = w_CODINTER;
          ardt_destwarn.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_cgo_tipall.w_TACODINT = w_CODINTER;
          ardt_cgo_tipall.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_cgo_subnets.w_SNCODINT = w_CODINTER;
          ardt_cgo_subnets.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_destemail.w_DWCODINT = w_CODINTER;
          ardt_destemail.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_intermbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"C",11,0),m_cServer_intermbo,w_CODINTER);
          l_cSql = l_cSql+m_oWrInfo_intermbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"intermbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_intermbo,l_cSql);
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
    return Delete(w_CODINTER);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"JXOBOAXKRQ")) {
      result.m_TableName = "tbtipint";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tipinte";
      result.m_rdField = new String[]{"TIPOINT"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JXOBOAXKRQ",CPLib.GetLinkedFieldProps("TIPOINT","TIPINTER","C",2,0));
    } else if (CPLib.eq(p_cID,"JCGROGAZTR")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAB" , "PROV" , "CAP" , "PKTBSTATI" , "IDBASE"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JCGROGAZTR",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",30,0));
    } else if (CPLib.eq(p_cID,"IIXRREUEAM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IIXRREUEAM",CPLib.GetLinkedFieldProps("CODSTA","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"LLYIGAMXRH")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI" , "TIPOSOT"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
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
    } else if (CPLib.eq(p_cID,"ZGNLLSFQHC")) {
      result.m_TableName = "tbsetsin";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SETSINT" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZGNLLSFQHC",CPLib.GetLinkedFieldProps("SETSINT","SETTSINT","C",3,0));
    } else if (CPLib.eq(p_cID,"AYYXYNLAUC")) {
      result.m_TableName = "tbtipdoc";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tipdoc";
      result.m_rdField = new String[]{"TIPDOC"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AYYXYNLAUC",CPLib.GetLinkedFieldProps("TIPDOC","TIPODOC","C",2,0));
    } else if (CPLib.eq(p_cID,"PSZTLCSMPB")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ" , "DESCCIT" , "CAB"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("PSZTLCSMPB",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    } else if (CPLib.eq(p_cID,"PZGXGIZQWY")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "armt_citta";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("PZGXGIZQWY",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",30,0));
    } else if (CPLib.eq(p_cID,"DUROREWBNG")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_citta";
      result.m_rdField = new String[]{"CITTA" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DUROREWBNG",CPLib.GetLinkedFieldProps("CITTA","NASCOMUN","C",30,0));
    } else if (CPLib.eq(p_cID,"ZTUIXEONYI")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZTUIXEONYI",CPLib.GetLinkedFieldProps("DESCRI","NASSTATO","C",30,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arrt_calcolasett,arrt_creadir,arrt_creadir_inter,arrt_interstor,arrt_setsblocco,arrt_writelog,
  public static final String i_InvokedRoutines = ",arrt_calcolasett,arrt_creadir,arrt_creadir_inter,arrt_interstor,arrt_setsblocco,arrt_writelog,";
}
