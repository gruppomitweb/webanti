// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_oper_storicoBO extends armt_cgo_oper_storicoBL {
  class SqlLoader {
    public boolean m_bLink_1_28 = false;
    public boolean m_bLink_1_33 = false;
    public boolean m_bLink_1_38 = false;
    public boolean m_bLink_1_60 = false;
    public boolean m_bLink_1_78 = false;
    public boolean m_bLink_1_80 = false;
    public boolean m_bLink_1_109 = false;
    public boolean m_bLink_1_157 = false;
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
        m_cSelect = m_cSelect+" ,link_1_28.CODSTA AS CODSTA128";
        m_cSelect = m_cSelect+" ,link_1_28.DESCRI AS DESCRI128";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_28","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_28","PAESE","CODSTA",true);
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
    public void AddJoinedLink_1_38(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_38.CODICE AS CODICE138";
        m_cSelect = m_cSelect+" ,link_1_38.DESCRI AS DESCRI138";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_38","ATTIV","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_38","ATTIV","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_38 = true;
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
        m_cSelect = m_cSelect+" ,link_1_60.CODICE AS CODICE160";
        m_cSelect = m_cSelect+" ,link_1_60.DES1 AS DES1160";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_60","TIPOOPRAP","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_60","TIPOOPRAP","CODICE",true);
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
    public void AddJoinedLink_1_78(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_78.CODINTER AS CODINTER178";
        m_cSelect = m_cSelect+" ,link_1_78.DATANASC AS DATANASC178";
        m_cSelect = m_cSelect+" ,link_1_78.CODCAB AS CODCAB178";
        m_cSelect = m_cSelect+" ,link_1_78.PROVINCIA AS PROVINCIA178";
        m_cSelect = m_cSelect+" ,link_1_78.DESCCIT AS DESCCIT178";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_78","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_78","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_78 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_80(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_80.CODDIP AS CODDIP180";
        m_cSelect = m_cSelect+" ,link_1_80.DESCRIZ AS DESCRIZ180";
        m_cSelect = m_cSelect+" ,link_1_80.DESCCIT AS DESCCIT180";
        m_cSelect = m_cSelect+" ,link_1_80.PROVINCIA AS PROVINCIA180";
        m_cSelect = m_cSelect+" ,link_1_80.CAB AS CAB180";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_80","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_80","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_80 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_109(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_109.CODVOC AS CODVOC209";
        m_cSelect = m_cSelect+" ,link_1_109.DESCRIZ AS DESCRIZ209";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_109","CODVOC","CODVOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_109","CODVOC","CODVOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_109 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_157(String rightTable,String rightServer) {
      // questo link aggiunge 7 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+7,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_157.CODTPGIO AS CODTPGIO257";
        m_cSelect = m_cSelect+" ,link_1_157.SOGTPGIO AS SOGTPGIO257";
        m_cSelect = m_cSelect+" ,link_1_157.DEFTPGIO AS DEFTPGIO257";
        m_cSelect = m_cSelect+" ,link_1_157.EDTTPGIO AS EDTTPGIO257";
        m_cSelect = m_cSelect+" ,link_1_157.EDTSPGIO AS EDTSPGIO257";
        m_cSelect = m_cSelect+" ,link_1_157.DEFSPGIO AS DEFSPGIO257";
        m_cSelect = m_cSelect+" ,link_1_157.FLGPLGIO AS FLGPLGIO257";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_157","TIPOGIOCO","CODTPGIO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_157","TIPOGIOCO","CODTPGIO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_157 = true;
          m_nColumns = m_nColumns+7;
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
  public armt_cgo_oper_storicoBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_oper_storico");
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
    l_bResult = arfn_form_cfR.Make(m_Ctx,this).Run(w_CODFISC,w_COGNOME,w_NOME,w_DATANASC,w_NASCOMUN,w_NASSTATO,w_SESSO,w_CFESTERO,w_TIPINTER);
    if (l_bResult) {
    } else {
      m_cLastMsgError = "Codice Fiscale non congruente con dati anagrafici";
    }
    if (l_bResult) {
      l_bResult = CanSaveChild(ardt_cgo_oper_storico_multi,m_cWv_ardt_cgo_oper_storico_multi,"m_cWv_ardt_cgo_oper_storico_multi");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_cgo_oper_storico_multi.m_cLastMsgError;
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
          if ( ! (ardt_cgo_oper_storico_multi.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_cgo_oper_storico_multi)) {
            ardt_cgo_oper_storico_multi.SetFromContext(m_cWv_ardt_cgo_oper_storico_multi);
            m_cWv_ardt_cgo_oper_storico_multi = "_not_empty_";
          }
          if (ardt_cgo_oper_storico_multi.IsUpdated()) {
            ardt_cgo_oper_storico_multi.w_SNAINUMOPE = w_SNAINUMOPE;
            if ( ! (ardt_cgo_oper_storico_multi.Save(true))) {
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
  public static String[] m_cLoadParameterNames = {"SNAINUMOPE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_SNAINUMOPE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_operazioni_dl_multi,m_cPhName_cgo_operazioni_dl_multi,m_cVirtName_cgo_operazioni_dl_multi,m_cVirtName_cgo_operazioni_dl_multi+".SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_dl_multi,p_SNAINUMOPE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_28(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_33(m_cPhName_cgo_tipdoc,m_cServer_cgo_tipdoc);
    l_oSqlLoader.AddJoinedLink_1_38(m_cPhName_tbtipatt,m_cServer_tbtipatt);
    l_oSqlLoader.AddJoinedLink_1_60(m_cPhName_tbtipreg,m_cServer_tbtipreg);
    l_oSqlLoader.AddJoinedLink_1_78(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_1_80(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_109(m_cPhName_tbcausin,m_cServer_tbcausin);
    l_oSqlLoader.AddJoinedLink_1_157(m_cPhName_cgo_tbtipgio,m_cServer_cgo_tbtipgio);
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
        w_xSOGTPGIO = 0;
        w_xDEFTPGIO = "";
        w_xEDTTPGIO = "";
        w_dessta = "";
        w_tipsot = "";
        w_STATOREG = "";
        w_IDBASE = "";
        w_NUMPROG = "";
        w_DESCRI = "";
        w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
        w_xDescDipe = "";
        w_datpaseuro = CPLib.NullDate();
        w_xdes1 = "";
        w_desccauana = "";
        w_CITINT = "";
        w_CITDIP = "";
        w_PROVDIP = "";
        w_CABDIP = "";
        w_PROVINT = "";
        w_CABINT = "";
        w_xdesccausin = "";
        w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
        w_idcitta = "";
        w_xdesctipatt = "";
        w_gVLT = m_Ctx.GetGlobalNumber("gVLT");
        w_gVNP = m_Ctx.GetGlobalNumber("gVNP");
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
        w_gStpDwn = m_Ctx.GetGlobalString("gStpDwn");
        w_MIDBIGLIETTO = "";
        w_xFLGPLGIO = "";
        w_xDEFSPGIO = "";
        w_xEDTSPGIO = "";
        w_gGesDoc = m_Ctx.GetGlobalString("gGesDoc");
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_CGOTIPOPE = l_rsLoad.GetString("CGOTIPOPE");
        w_CAIDBIGLIETTO = l_rsLoad.GetString("CAIDBIGLIETTO");
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_FLAGCONT = l_rsLoad.GetString("FLAGCONT");
        w_CACODICE = l_rsLoad.GetDouble("CACODICE");
        w_CAFLGOPE = l_rsLoad.GetString("CAFLGOPE");
        w_TOTLIRE = l_rsLoad.GetDouble("TOTLIRE");
        w_TOTCONT = l_rsLoad.GetDouble("TOTCONT");
        w_CGOFLGVLT = l_rsLoad.GetString("CGOFLGVLT");
        w_CGOFLGVNP = l_rsLoad.GetString("CGOFLGVNP");
        w_MEZPAGAM = l_rsLoad.GetString("MEZPAGAM");
        w_CFESTERO = l_rsLoad.GetDouble("CFESTERO");
        w_CODFISC = l_rsLoad.GetString("CODFISC");
        w_COGNOME = l_rsLoad.GetString("COGNOME");
        w_NOME = l_rsLoad.GetString("NOME");
        w_NASCOMUN = l_rsLoad.GetString("NASCOMUN");
        // Link con tbcitta non eseguito: riporta solo campi
        w_TIPINTER = l_rsLoad.GetString("TIPINTER");
        w_SESSO = l_rsLoad.GetString("SESSO");
        w_NASSTATO = l_rsLoad.GetString("NASSTATO");
        // Link con tbstati non eseguito: riporta solo campi
        w_DATANASC = l_rsLoad.GetDate("DATANASC");
        w_PAESE = l_rsLoad.GetString("PAESE");
        if (l_oSqlLoader.m_bLink_1_28) {
          w_dessta = l_rsLoad.GetString("DESCRI128");
        } else {
          Link_YVIKEGPYPM("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_idcitta = "";
        Link_ODAYKSRECA("Load");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CAP = l_rsLoad.GetString("CAP");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
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
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        if (l_oSqlLoader.m_bLink_1_38) {
          w_xdesctipatt = l_rsLoad.GetString("DESCRI138");
        } else {
          Link_SAQTIHOALW("Load");
        }
        w_TIPOPERS = l_rsLoad.GetString("TIPOPERS");
        w_RAGSOC = l_rsLoad.GetString("RAGSOC");
        w_SOTGRUP = l_rsLoad.GetString("SOTGRUP");
        w_RAMOGRUP = l_rsLoad.GetString("RAMOGRUP");
        w_SETTSINT = l_rsLoad.GetString("SETTSINT");
        w_SNAINUMOPE = l_rsLoad.GetString("SNAINUMOPE");
        op_SNAINUMOPE = w_SNAINUMOPE;
        w_DATAREG = l_rsLoad.GetDate("DATAREG");
        w_TIPOOPRAP = l_rsLoad.GetString("TIPOOPRAP");
        if (l_oSqlLoader.m_bLink_1_60) {
          w_xdes1 = l_rsLoad.GetString("DES1160");
        } else {
          Link_UJRFWINIVQ("Load");
        }
        w_CODANA = l_rsLoad.GetString("CODANA");
        // Link con tbcauana non eseguito: riporta solo campi
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        w_SEGNO = "";
        w_desccauana = "";
        Link_SRWWPHPCUB("Load");
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        w_CAMBIO = l_rsLoad.GetDouble("CAMBIO");
        w_CONNESCLI = l_rsLoad.GetString("CONNESCLI");
        w_CONNESBEN = l_rsLoad.GetString("CONNESBEN");
        // Link con personbo non eseguito: riporta solo campi
        w_C_RAG = l_rsLoad.GetString("C_RAG");
        w_C_CTA = l_rsLoad.GetString("C_CTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_C_PRV = l_rsLoad.GetString("C_PRV");
        w_C_CAP = l_rsLoad.GetString("C_CAP");
        w_C_CAB = l_rsLoad.GetString("C_CAB");
        w_C_IND = l_rsLoad.GetString("C_IND");
        w_C_STA = l_rsLoad.GetString("C_STA");
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        if (l_oSqlLoader.m_bLink_1_78) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC178");
          w_CABINT = l_rsLoad.GetString("CODCAB178");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA178");
          w_CITINT = l_rsLoad.GetString("DESCCIT178");
        } else {
          Link_WJSVGWKSFC("Load");
        }
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_80) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ180");
          w_CITDIP = l_rsLoad.GetString("DESCCIT180");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA180");
          w_CABDIP = l_rsLoad.GetString("CAB180");
        } else {
          Link_AVHTGZTOSZ("Load");
        }
        w_DESCCITDIP = l_rsLoad.GetString("DESCCITDIP");
        w_SEGNO = l_rsLoad.GetString("SEGNO");
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        // Link con operazbo non eseguito: riporta solo campi
        w_PROVINCIADIP = l_rsLoad.GetString("PROVINCIADIP");
        w_CODCABDIP = l_rsLoad.GetString("CODCABDIP");
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        if (l_oSqlLoader.m_bLink_1_109) {
          w_xdesccausin = l_rsLoad.GetString("DESCRIZ209");
        } else {
          Link_LKEDJRUQJU("Load");
        }
        w_CODCAB = "";
        w_PROVINCIA = "";
        w_CAP = "";
        Link_XPSJTIMTNR("Load");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_PEP = l_rsLoad.GetString("PEP");
        w_VLTPLAT = l_rsLoad.GetString("VLTPLAT");
        // Link con cgo_vltplat non eseguito: riporta solo campi
        w_TIPOGIOCO = l_rsLoad.GetString("TIPOGIOCO");
        if (l_oSqlLoader.m_bLink_1_157) {
          w_xSOGTPGIO = l_rsLoad.GetDouble("SOGTPGIO257");
          w_xDEFTPGIO = l_rsLoad.GetString("DEFTPGIO257");
          w_xEDTTPGIO = l_rsLoad.GetString("EDTTPGIO257");
          w_xEDTSPGIO = l_rsLoad.GetString("EDTSPGIO257");
          w_xDEFSPGIO = l_rsLoad.GetString("DEFSPGIO257");
          w_xFLGPLGIO = l_rsLoad.GetString("FLGPLGIO257");
        } else {
          Link_DKNVEJCFAA("Load");
        }
        w_ASSEGNO = l_rsLoad.GetString("ASSEGNO");
        w_IBAN = l_rsLoad.GetString("IBAN");
        w_CC4CIFRE = l_rsLoad.GetString("CC4CIFRE");
        w_CCDATSCA = l_rsLoad.GetString("CCDATSCA");
        w_NUMTEL = l_rsLoad.GetString("NUMTEL");
        w_IDDOCALL = l_rsLoad.GetString("IDDOCALL");
        w_FLGDOCALL = l_rsLoad.GetString("FLGDOCALL");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_cgo_oper_storico_multi = "";
        ardt_cgo_oper_storico_multi.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl_multi")) {
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
    return Load(w_SNAINUMOPE);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_operazioni_dl_multi);
      l_cSql = "insert into "+m_oWrInfo_cgo_operazioni_dl_multi.GetTableWriteName()+" (";
      l_cSql = l_cSql+"CGOTIPOPE,";
      l_cSql = l_cSql+"CAIDBIGLIETTO,";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"FLAGCONT,";
      l_cSql = l_cSql+"CACODICE,";
      l_cSql = l_cSql+"CAFLGOPE,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"TOTCONT,";
      l_cSql = l_cSql+"CGOFLGVLT,";
      l_cSql = l_cSql+"CGOFLGVNP,";
      l_cSql = l_cSql+"MEZPAGAM,";
      l_cSql = l_cSql+"CFESTERO,";
      l_cSql = l_cSql+"CODFISC,";
      l_cSql = l_cSql+"COGNOME,";
      l_cSql = l_cSql+"NOME,";
      l_cSql = l_cSql+"NASCOMUN,";
      l_cSql = l_cSql+"TIPINTER,";
      l_cSql = l_cSql+"SESSO,";
      l_cSql = l_cSql+"NASSTATO,";
      l_cSql = l_cSql+"DATANASC,";
      l_cSql = l_cSql+"PAESE,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CAP,";
      l_cSql = l_cSql+"DOMICILIO,";
      l_cSql = l_cSql+"TIPODOC,";
      l_cSql = l_cSql+"NUMDOCUM,";
      l_cSql = l_cSql+"DATARILASC,";
      l_cSql = l_cSql+"DATAVALI,";
      l_cSql = l_cSql+"AUTRILASC,";
      l_cSql = l_cSql+"ATTIV,";
      l_cSql = l_cSql+"TIPOPERS,";
      l_cSql = l_cSql+"RAGSOC,";
      l_cSql = l_cSql+"SOTGRUP,";
      l_cSql = l_cSql+"RAMOGRUP,";
      l_cSql = l_cSql+"SETTSINT,";
      l_cSql = l_cSql+"SNAINUMOPE,";
      l_cSql = l_cSql+"DATAREG,";
      l_cSql = l_cSql+"TIPOOPRAP,";
      l_cSql = l_cSql+"CODANA,";
      l_cSql = l_cSql+"CODVOC,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"CAMBIO,";
      l_cSql = l_cSql+"CONNESCLI,";
      l_cSql = l_cSql+"CONNESBEN,";
      l_cSql = l_cSql+"C_RAG,";
      l_cSql = l_cSql+"C_CTA,";
      l_cSql = l_cSql+"C_PRV,";
      l_cSql = l_cSql+"C_CAP,";
      l_cSql = l_cSql+"C_CAB,";
      l_cSql = l_cSql+"C_IND,";
      l_cSql = l_cSql+"C_STA,";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"DESCCITDIP,";
      l_cSql = l_cSql+"SEGNO,";
      l_cSql = l_cSql+"FLAGFRAZ,";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"PROVINCIADIP,";
      l_cSql = l_cSql+"CODCABDIP,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"PEP,";
      l_cSql = l_cSql+"VLTPLAT,";
      l_cSql = l_cSql+"TIPOGIOCO,";
      l_cSql = l_cSql+"ASSEGNO,";
      l_cSql = l_cSql+"IBAN,";
      l_cSql = l_cSql+"CC4CIFRE,";
      l_cSql = l_cSql+"CCDATSCA,";
      l_cSql = l_cSql+"NUMTEL,";
      l_cSql = l_cSql+"IDDOCALL,";
      l_cSql = l_cSql+"FLGDOCALL,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl_multi.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl_multi")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOTIPOPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGCONT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CACODICE,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAFLGOPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTCONT,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOFLGVLT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOFLGVNP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MEZPAGAM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFESTERO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODFISC,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COGNOME,"C",26,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOME,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASCOMUN,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPINTER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASSTATO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATANASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPODOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMDOCUM,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARILASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVALI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTRILASC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ATTIV,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOPERS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAGSOC,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOTGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAMOGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SETTSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODANA,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODVOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAMBIO,"N",9,4)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESCLI,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESBEN,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_RAG,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CTA,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_PRV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CAP,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_IND,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_STA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCITDIP,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_COLLEG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIADIP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCABDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VLTPLAT,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOGIOCO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ASSEGNO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IBAN,"C",27,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CC4CIFRE,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CCDATSCA,"C",7,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMTEL,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDDOCALL,"C",36,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGDOCALL,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl_multi.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl_multi")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_dl_multi,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_operazioni_dl_multi);
      l_cSql = "Update "+m_oWrInfo_cgo_operazioni_dl_multi.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CGOTIPOPE = "+CPLib.ToSQL(w_CGOTIPOPE,"C",1,0);
      l_cSql = l_cSql+", CAIDBIGLIETTO = "+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",30,0);
      l_cSql = l_cSql+", DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", FLAGCONT = "+CPLib.ToSQL(w_FLAGCONT,"C",1,0);
      l_cSql = l_cSql+", CACODICE = "+CPLib.ToSQL(w_CACODICE,"N",5,0);
      l_cSql = l_cSql+", CAFLGOPE = "+CPLib.ToSQL(w_CAFLGOPE,"C",1,0);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",15,2);
      l_cSql = l_cSql+", TOTCONT = "+CPLib.ToSQL(w_TOTCONT,"N",15,2);
      l_cSql = l_cSql+", CGOFLGVLT = "+CPLib.ToSQL(w_CGOFLGVLT,"C",1,0);
      l_cSql = l_cSql+", CGOFLGVNP = "+CPLib.ToSQL(w_CGOFLGVNP,"C",1,0);
      l_cSql = l_cSql+", MEZPAGAM = "+CPLib.ToSQL(w_MEZPAGAM,"C",1,0);
      l_cSql = l_cSql+", CFESTERO = "+CPLib.ToSQL(w_CFESTERO,"N",1,0);
      l_cSql = l_cSql+", CODFISC = "+CPLib.ToSQL(w_CODFISC,"C",16,0);
      l_cSql = l_cSql+", COGNOME = "+CPLib.ToSQL(w_COGNOME,"C",26,0);
      l_cSql = l_cSql+", NOME = "+CPLib.ToSQL(w_NOME,"C",25,0);
      l_cSql = l_cSql+", NASCOMUN = "+CPLib.ToSQL(w_NASCOMUN,"C",30,0);
      l_cSql = l_cSql+", TIPINTER = "+CPLib.ToSQL(w_TIPINTER,"C",2,0);
      l_cSql = l_cSql+", SESSO = "+CPLib.ToSQL(w_SESSO,"C",1,0);
      l_cSql = l_cSql+", NASSTATO = "+CPLib.ToSQL(w_NASSTATO,"C",30,0);
      l_cSql = l_cSql+", DATANASC = "+CPLib.ToSQL(w_DATANASC,"D",8,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQLNull(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",40,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",9,0);
      l_cSql = l_cSql+", DOMICILIO = "+CPLib.ToSQL(w_DOMICILIO,"C",35,0);
      l_cSql = l_cSql+", TIPODOC = "+CPLib.ToSQLNull(w_TIPODOC,"C",2,0);
      l_cSql = l_cSql+", NUMDOCUM = "+CPLib.ToSQL(w_NUMDOCUM,"C",15,0);
      l_cSql = l_cSql+", DATARILASC = "+CPLib.ToSQL(w_DATARILASC,"D",8,0);
      l_cSql = l_cSql+", DATAVALI = "+CPLib.ToSQL(w_DATAVALI,"D",8,0);
      l_cSql = l_cSql+", AUTRILASC = "+CPLib.ToSQL(w_AUTRILASC,"C",30,0);
      l_cSql = l_cSql+", ATTIV = "+CPLib.ToSQLNull(w_ATTIV,"C",10,0);
      l_cSql = l_cSql+", TIPOPERS = "+CPLib.ToSQL(w_TIPOPERS,"C",1,0);
      l_cSql = l_cSql+", RAGSOC = "+CPLib.ToSQL(w_RAGSOC,"C",70,0);
      l_cSql = l_cSql+", SOTGRUP = "+CPLib.ToSQL(w_SOTGRUP,"C",3,0);
      l_cSql = l_cSql+", RAMOGRUP = "+CPLib.ToSQL(w_RAMOGRUP,"C",3,0);
      l_cSql = l_cSql+", SETTSINT = "+CPLib.ToSQL(w_SETTSINT,"C",3,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"D",8,0);
      l_cSql = l_cSql+", TIPOOPRAP = "+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0);
      l_cSql = l_cSql+", CODANA = "+CPLib.ToSQLNull(w_CODANA,"C",4,0);
      l_cSql = l_cSql+", CODVOC = "+CPLib.ToSQLNull(w_CODVOC,"C",2,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQL(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", CAMBIO = "+CPLib.ToSQL(w_CAMBIO,"N",9,4);
      l_cSql = l_cSql+", CONNESCLI = "+CPLib.ToSQL(w_CONNESCLI,"C",16,0);
      l_cSql = l_cSql+", CONNESBEN = "+CPLib.ToSQLNull(w_CONNESBEN,"C",16,0);
      l_cSql = l_cSql+", C_RAG = "+CPLib.ToSQL(w_C_RAG,"C",70,0);
      l_cSql = l_cSql+", C_CTA = "+CPLib.ToSQL(w_C_CTA,"C",30,0);
      l_cSql = l_cSql+", C_PRV = "+CPLib.ToSQL(w_C_PRV,"C",2,0);
      l_cSql = l_cSql+", C_CAP = "+CPLib.ToSQL(w_C_CAP,"C",5,0);
      l_cSql = l_cSql+", C_CAB = "+CPLib.ToSQL(w_C_CAB,"C",6,0);
      l_cSql = l_cSql+", C_IND = "+CPLib.ToSQL(w_C_IND,"C",35,0);
      l_cSql = l_cSql+", C_STA = "+CPLib.ToSQL(w_C_STA,"C",3,0);
      l_cSql = l_cSql+", NUMPROG = "+CPLib.ToSQL(w_NUMPROG,"C",11,0);
      l_cSql = l_cSql+", CODINTER = "+CPLib.ToSQLNull(w_CODINTER,"C",11,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", DESCCITDIP = "+CPLib.ToSQL(w_DESCCITDIP,"C",30,0);
      l_cSql = l_cSql+", SEGNO = "+CPLib.ToSQL(w_SEGNO,"C",1,0);
      l_cSql = l_cSql+", FLAGFRAZ = "+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0);
      l_cSql = l_cSql+", COLLEG = "+CPLib.ToSQLNull(w_COLLEG,"C",11,0);
      l_cSql = l_cSql+", PROVINCIADIP = "+CPLib.ToSQL(w_PROVINCIADIP,"C",2,0);
      l_cSql = l_cSql+", CODCABDIP = "+CPLib.ToSQL(w_CODCABDIP,"C",6,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", PEP = "+CPLib.ToSQL(w_PEP,"C",1,0);
      l_cSql = l_cSql+", VLTPLAT = "+CPLib.ToSQLNull(w_VLTPLAT,"C",2,0);
      l_cSql = l_cSql+", TIPOGIOCO = "+CPLib.ToSQLNull(w_TIPOGIOCO,"C",3,0);
      l_cSql = l_cSql+", ASSEGNO = "+CPLib.ToSQL(w_ASSEGNO,"C",25,0);
      l_cSql = l_cSql+", IBAN = "+CPLib.ToSQL(w_IBAN,"C",27,0);
      l_cSql = l_cSql+", CC4CIFRE = "+CPLib.ToSQL(w_CC4CIFRE,"C",4,0);
      l_cSql = l_cSql+", CCDATSCA = "+CPLib.ToSQL(w_CCDATSCA,"C",7,0);
      l_cSql = l_cSql+", NUMTEL = "+CPLib.ToSQL(w_NUMTEL,"C",20,0);
      l_cSql = l_cSql+", IDDOCALL = "+CPLib.ToSQL(w_IDDOCALL,"C",36,0);
      l_cSql = l_cSql+", FLGDOCALL = "+CPLib.ToSQL(w_FLGDOCALL,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl_multi")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_dl_multi,w_SNAINUMOPE);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl_multi.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl_multi")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_dl_multi,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_SNAINUMOPE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_SNAINUMOPE);
    // * --- Area Manuale = BO - Delete Init
    // * --- armt_cgo_oper_storico
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
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_cgo_oper_storico_multi.w_SNAINUMOPE = w_SNAINUMOPE;
          ardt_cgo_oper_storico_multi.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_cgo_operazioni_dl_multi.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_dl_multi,w_SNAINUMOPE);
          l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl_multi.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl_multi")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_dl_multi,l_cSql);
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
    // * --- armt_cgo_oper_storico
    NotifyEvent("Record Deleted");
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_SNAINUMOPE);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a SNAINUMOPE
    w_SNAINUMOPE = CPLib.Left(w_SNAINUMOPE,15)+CPLib.Space(15-CPLib.Len(w_SNAINUMOPE));
    m_Sql.NextTableProg(this,"PRGNUMOPE","i_codazi,w_SNAINUMOPE",m_cServer_cgo_operazioni_dl_multi,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave SNAINUMOPE, altrimenti non si riesce a linkare da zoom
    w_SNAINUMOPE = CPLib.RTrim(w_SNAINUMOPE);
    op_SNAINUMOPE = w_SNAINUMOPE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"NEUBQNUEOJ")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 15;
      result.m_rdField = new String[]{"CITTA" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NEUBQNUEOJ",CPLib.GetLinkedFieldProps("CITTA","NASCOMUN","C",30,0));
    } else if (CPLib.eq(p_cID,"HODZKKOSYW")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 15;
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HODZKKOSYW",CPLib.GetLinkedFieldProps("DESCRI","NASSTATO","C",30,0));
    } else if (CPLib.eq(p_cID,"YVIKEGPYPM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 15;
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
      result.m_SuggestRows = 15;
      result.m_rdField = new String[]{"CITTA" , "IDBASE"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{"PKTBSTATI"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",40,0),CPLib.GetLinkedFieldProps("PKTBSTATI","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"MBGANUUHRA")) {
      result.m_TableName = "cgo_tipdoc";
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
    } else if (CPLib.eq(p_cID,"SAQTIHOALW")) {
      result.m_TableName = "tbtipatt";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SAQTIHOALW",CPLib.GetLinkedFieldProps("CODICE","ATTIV","C",10,0));
    } else if (CPLib.eq(p_cID,"UJRFWINIVQ")) {
      result.m_TableName = "tbtipreg";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DES1"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UJRFWINIVQ",CPLib.GetLinkedFieldProps("CODICE","TIPOOPRAP","C",2,0));
    } else if (CPLib.eq(p_cID,"SQVJLYRFKQ")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODCAU"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SQVJLYRFKQ",CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"SRWWPHPCUB")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAUSINT" , "SEGNO" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{"CODCAU"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("SRWWPHPCUB",CPLib.GetLinkedFieldProps("CAUSINT","CODVOC","C",2,0),CPLib.GetLinkedFieldProps("SEGNO","SEGNO","C",1,0),CPLib.GetLinkedFieldProps("DESCRI","desccauana","C",165,0),CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"ULVCBLFVEU")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "DOMICILIO" , "DESCCIT" , "PROVINCIA" , "PAESE" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ULVCBLFVEU",CPLib.GetLinkedFieldProps("CONNES","CONNESBEN","C",16,0));
    } else if (CPLib.eq(p_cID,"KUPRRTVLKH")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAB" , "PROV" , "PKTBSTATI" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KUPRRTVLKH",CPLib.GetLinkedFieldProps("CITTA","C_CTA","C",30,0));
    } else if (CPLib.eq(p_cID,"WJSVGWKSFC")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER" , "DATANASC" , "CODCAB" , "PROVINCIA" , "DESCCIT"};
      result.m_rdTypes = new String[]{"C" , "D" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("WJSVGWKSFC",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0));
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
      result.AppendFieldsHash("AVHTGZTOSZ",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0),CPLib.GetLinkedFieldProps("DESCRIZ","xDescDipe","C",30,0),CPLib.GetLinkedFieldProps("DESCCIT","CITDIP","C",30,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVDIP","C",2,0),CPLib.GetLinkedFieldProps("CAB","CABDIP","C",6,0));
    } else if (CPLib.eq(p_cID,"MSGBKOOAOY")) {
      result.m_TableName = "operazbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_operazioni";
      result.m_rdField = new String[]{"NUMPROG"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MSGBKOOAOY",CPLib.GetLinkedFieldProps("NUMPROG","COLLEG","C",11,0));
    } else if (CPLib.eq(p_cID,"LKEDJRUQJU")) {
      result.m_TableName = "tbcausin";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODVOC" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LKEDJRUQJU",CPLib.GetLinkedFieldProps("CODVOC","CODVOC","C",2,0));
    } else if (CPLib.eq(p_cID,"XPSJTIMTNR")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "CAB" , "PROV" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XPSJTIMTNR",CPLib.GetLinkedFieldProps("IDBASE","idcitta","C",10,0));
    } else if (CPLib.eq(p_cID,"LVYFMQXNZH")) {
      result.m_TableName = "cgo_vltplat";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_cgo_vltplat";
      result.m_rdField = new String[]{"VPCODICE"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LVYFMQXNZH",CPLib.GetLinkedFieldProps("VPCODICE","VLTPLAT","C",2,0));
    } else if (CPLib.eq(p_cID,"DKNVEJCFAA")) {
      result.m_TableName = "cgo_tbtipgio";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_cgo_tbtipgio";
      result.m_rdField = new String[]{"CODTPGIO" , "SOGTPGIO" , "DEFTPGIO" , "EDTTPGIO" , "EDTSPGIO" , "DEFSPGIO" , "FLGPLGIO"};
      result.m_rdTypes = new String[]{"C" , "N" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DKNVEJCFAA",CPLib.GetLinkedFieldProps("CODTPGIO","TIPOGIOCO","C",3,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkcodfis,arfn_form_cf,arrt_cgo_delete_doc,arrt_cgo_read_flgope,arrt_cgo_save_multi_dl,arrt_cgo_setpagatore_m_dc,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkcodfis,arfn_form_cf,arrt_cgo_delete_doc,arrt_cgo_read_flgope,arrt_cgo_save_multi_dl,arrt_cgo_setpagatore_m_dc,arrt_writelog,";
}
