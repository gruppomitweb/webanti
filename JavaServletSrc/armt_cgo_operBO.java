// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_operBO extends armt_cgo_operBL {
  class SqlLoader {
    public boolean m_bLink_1_5 = false;
    public boolean m_bLink_1_13 = false;
    public boolean m_bLink_1_45 = false;
    public boolean m_bLink_1_53 = false;
    public boolean m_bLink_1_75 = false;
    public boolean m_bLink_1_92 = false;
    public boolean m_bLink_1_179 = false;
    public boolean m_bLink_1_183 = false;
    public boolean m_bLink_1_191 = false;
    public boolean m_bLink_1_227 = false;
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
      // questo link aggiunge 9 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+9,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_5.CODTPGIO AS CODTPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.SOGTPGIO AS SOGTPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.DEFTPGIO AS DEFTPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.EDTTPGIO AS EDTTPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.EDTSPGIO AS EDTSPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.DEFSPGIO AS DEFSPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.FLGPLGIO AS FLGPLGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.FLTIPGIO AS FLTIPGIO105";
        m_cSelect = m_cSelect+" ,link_1_5.IMPMINGIO AS IMPMINGIO105";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_5","TIPOGIOCO","CODTPGIO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_5","TIPOGIOCO","CODTPGIO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_5 = true;
          m_nColumns = m_nColumns+9;
        }
      }
    }
    public void AddJoinedLink_1_13(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_13.VPCODICE AS VPCODICE113";
        m_cSelect = m_cSelect+" ,link_1_13.VPFLGATT AS VPFLGATT113";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_13","VLTPLAT","VPCODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_13","VLTPLAT","VPCODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_13 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_45(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_45.CODSTA AS CODSTA145";
        m_cSelect = m_cSelect+" ,link_1_45.DESCRI AS DESCRI145";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_45","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_45","PAESE","CODSTA",true);
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
    public void AddJoinedLink_1_53(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_53.CODICE AS CODICE153";
        m_cSelect = m_cSelect+" ,link_1_53.DESCRI AS DESCRI153";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_53","ATTIV","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_53","ATTIV","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_53 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_75(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_75.CODICE AS CODICE175";
        m_cSelect = m_cSelect+" ,link_1_75.DES1 AS DES1175";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_75","TIPOOPRAP","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_75","TIPOOPRAP","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_75 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_92(String rightTable,String rightServer) {
      // questo link aggiunge 6 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+6,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_92.CODINTER AS CODINTER192";
        m_cSelect = m_cSelect+" ,link_1_92.DATANASC AS DATANASC192";
        m_cSelect = m_cSelect+" ,link_1_92.CODCAB AS CODCAB192";
        m_cSelect = m_cSelect+" ,link_1_92.PROVINCIA AS PROVINCIA192";
        m_cSelect = m_cSelect+" ,link_1_92.DESCCIT AS DESCCIT192";
        m_cSelect = m_cSelect+" ,link_1_92.CGOFLGPROF AS CGOFLGPROF192";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_92","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_92","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_92 = true;
          m_nColumns = m_nColumns+6;
        }
      }
    }
    public void AddJoinedLink_1_179(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_179.TIPDOC AS TIPDOC279";
        m_cSelect = m_cSelect+" ,link_1_179.DESCRI AS DESCRI279";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_179","TIPODOC","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_179","TIPODOC","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_179 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_183(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_183.ARCODICE AS ARCODICE283";
        m_cSelect = m_cSelect+" ,link_1_183.ARDESCRI AS ARDESCRI283";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_183","RDCODAUT","ARCODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_183","RDCODAUT","ARCODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_183 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_191(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_191.CODSTA AS CODSTA291";
        m_cSelect = m_cSelect+" ,link_1_191.DESCRI AS DESCRI291";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_191","PAESE2","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_191","PAESE2","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_191 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_227(String rightTable,String rightServer) {
      // questo link aggiunge 7 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+7,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_227.CODDIP AS CODDIP327";
        m_cSelect = m_cSelect+" ,link_1_227.DESCRIZ AS DESCRIZ327";
        m_cSelect = m_cSelect+" ,link_1_227.DESCCIT AS DESCCIT327";
        m_cSelect = m_cSelect+" ,link_1_227.PROVINCIA AS PROVINCIA327";
        m_cSelect = m_cSelect+" ,link_1_227.CAB AS CAB327";
        m_cSelect = m_cSelect+" ,link_1_227.TELEFONO AS TELEFONO327";
        m_cSelect = m_cSelect+" ,link_1_227.CODLOC AS CODLOC327";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_227","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_227","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_227 = true;
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
  public armt_cgo_operBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_oper");
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
    l_bResult = arfn_form_cfR.Make(m_Ctx,this).Run(w_CODFISC,w_COGNOME,w_NOME,w_DATANASC,w_NASCOMUN,w_NASSTATO,w_SESSO,w_CFESTERO,w_TIPINTER) && arfn_cgo_chkcapR.Make(m_Ctx,this).Run(w_CAP,"R") && arfn_cgo_chkcapR.Make(m_Ctx,this).Run(w_CAP2,"D");
    if (l_bResult) {
    } else {
      m_cLastMsgError = CPLib.Strtran("%ERRORMESSAGE%","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if (l_bResult) {
      l_bResult = CanSaveChild(armt_cgo_qadv_operazioni_dl,m_cWv_armt_cgo_qadv_operazioni_dl,"m_cWv_armt_cgo_qadv_operazioni_dl");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = armt_cgo_qadv_operazioni_dl.m_cLastMsgError;
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
          if ( ! (armt_cgo_qadv_operazioni_dl.IsUpdated()) && CPLib.IsUpdated(m_cWv_armt_cgo_qadv_operazioni_dl)) {
            armt_cgo_qadv_operazioni_dl.SetFromContext(m_cWv_armt_cgo_qadv_operazioni_dl);
            m_cWv_armt_cgo_qadv_operazioni_dl = "_not_empty_";
          }
          if (armt_cgo_qadv_operazioni_dl.IsUpdated()) {
            armt_cgo_qadv_operazioni_dl.w_SNAINUMOPE = w_SNAINUMOPE;
            if ( ! (armt_cgo_qadv_operazioni_dl.Save(true))) {
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
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_operazioni_dl,m_cPhName_cgo_operazioni_dl,m_cVirtName_cgo_operazioni_dl,m_cVirtName_cgo_operazioni_dl+".SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_dl,p_SNAINUMOPE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_5(m_cPhName_cgo_tbtipgio,m_cServer_cgo_tbtipgio);
    l_oSqlLoader.AddJoinedLink_1_13(m_cPhName_cgo_vltplat,m_cServer_cgo_vltplat);
    l_oSqlLoader.AddJoinedLink_1_45(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_53(m_cPhName_tbtipatt,m_cServer_tbtipatt);
    l_oSqlLoader.AddJoinedLink_1_75(m_cPhName_tbtipreg,m_cServer_tbtipreg);
    l_oSqlLoader.AddJoinedLink_1_92(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_1_179(m_cPhName_cgo_tipdoc,m_cServer_cgo_tipdoc);
    l_oSqlLoader.AddJoinedLink_1_183(m_cPhName_cgo_autorita,m_cServer_cgo_autorita);
    l_oSqlLoader.AddJoinedLink_1_191(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_227(m_cPhName_anadip,m_cServer_anadip);
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
        w_xSOGTPGIO = 0;
        w_xDEFTPGIO = "";
        w_xEDTTPGIO = "";
        w_xEDTSPGIO = "";
        w_xDEFSPGIO = "";
        w_xFLGPLGIO = "";
        w_idcitta = "";
        w_xARDESCRI = "";
        w_dessta = "";
        w_tipsot = "";
        w_STATOREG = "";
        w_IDBASE = "";
        w_NUMPROG = "";
        w_DESCRI = "";
        w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
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
        w_xdesctipatt = "";
        w_gVLT = m_Ctx.GetGlobalNumber("gVLT");
        w_gVNP = m_Ctx.GetGlobalNumber("gVNP");
        w_gStpDwn = m_Ctx.GetGlobalString("gStpDwn");
        w_MIDBIGLIETTO = "";
        w_MIDBIGLIETTO1 = "";
        w_MIDBIGLIETTO4 = "";
        w_MIDBIGLIETTO2 = "";
        w_MIDBIGLIETTO3 = "";
        w_gPathApp = m_Ctx.GetGlobalString("gPathApp");
        w_xVPFLGATT = "";
        w_DOC03 = "";
        w_DOC04 = "";
        w_gGesDoc = m_Ctx.GetGlobalString("gGesDoc");
        w_xIMPMINGIO = 0;
        w_idcitta2 = "";
        w_dessta2 = "";
        w_gTipMul = m_Ctx.GetGlobalString("gTipMul");
        w_FLGQADVFULL = "";
        w_gQADV = m_Ctx.GetGlobalString("gQADV");
        w_xCGOFLGPROF = "";
        w_TELDIP = "";
        w_CODLOC = "";
        w_ANA_FOUND = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_TIPOGIOCO = l_rsLoad.GetString("TIPOGIOCO");
        if (l_oSqlLoader.m_bLink_1_5) {
          w_xSOGTPGIO = l_rsLoad.GetDouble("SOGTPGIO105");
          w_xDEFTPGIO = l_rsLoad.GetString("DEFTPGIO105");
          w_xEDTTPGIO = l_rsLoad.GetString("EDTTPGIO105");
          w_xEDTSPGIO = l_rsLoad.GetString("EDTSPGIO105");
          w_xDEFSPGIO = l_rsLoad.GetString("DEFSPGIO105");
          w_xFLGPLGIO = l_rsLoad.GetString("FLGPLGIO105");
          w_CGOTIPOPE = l_rsLoad.GetString("FLTIPGIO105");
          w_xIMPMINGIO = l_rsLoad.GetDouble("IMPMINGIO105");
        } else {
          Link_QZTTRBWAQL("Load");
        }
        w_CGOTIPOPE = l_rsLoad.GetString("CGOTIPOPE");
        w_VLTPLAT = l_rsLoad.GetString("VLTPLAT");
        if (l_oSqlLoader.m_bLink_1_13) {
          w_xVPFLGATT = l_rsLoad.GetString("VPFLGATT113");
        } else {
          Link_LVYFMQXNZH("Load");
        }
        w_CAIDBIGLIETTO = l_rsLoad.GetString("CAIDBIGLIETTO");
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_FLAGCONT = l_rsLoad.GetString("FLAGCONT");
        w_FLAGWALLET = l_rsLoad.GetString("FLAGWALLET");
        w_CAFLGOPE = l_rsLoad.GetString("CAFLGOPE");
        w_TOTLIRE = l_rsLoad.GetDouble("TOTLIRE");
        w_TOTCONT = l_rsLoad.GetDouble("TOTCONT");
        w_IMPWALLET = l_rsLoad.GetDouble("IMPWALLET");
        w_CODWALLET = l_rsLoad.GetString("CODWALLET");
        w_CODTRANSZ = l_rsLoad.GetString("CODTRANSZ");
        w_FILTROMP = (CPLib.ne((w_TOTCONT+w_IMPWALLET),w_TOTLIRE)?"'I','E','P','B','C','V'":"'I','E','P','B','C','V','S','W'");
        w_CGOFLGVLT = l_rsLoad.GetString("CGOFLGVLT");
        w_FLGPAGAM = w_CGOFLGVLT;
        w_CGOFLGVNP = l_rsLoad.GetString("CGOFLGVNP");
        w_MEZPAGAM = l_rsLoad.GetString("MEZPAGAM");
        w_CC4CIFRE = l_rsLoad.GetString("CC4CIFRE");
        w_CCMESSCA = l_rsLoad.GetDouble("CCMESSCA");
        w_CCANNSCA = l_rsLoad.GetDouble("CCANNSCA");
        w_ASSEGNO = l_rsLoad.GetString("ASSEGNO");
        w_IBAN = l_rsLoad.GetString("IBAN");
        w_CCDATSCA = l_rsLoad.GetString("CCDATSCA");
        w_CFESTERO = l_rsLoad.GetDouble("CFESTERO");
        w_PEP = l_rsLoad.GetString("PEP");
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
        if (l_oSqlLoader.m_bLink_1_45) {
          w_dessta = l_rsLoad.GetString("DESCRI145");
        } else {
          Link_YVIKEGPYPM("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_idcitta = "";
        Link_ODAYKSRECA("Load");
        w_CODCAB = "";
        w_PROVINCIA = "";
        w_CAP = "";
        Link_XPSJTIMTNR("Load");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CAP = l_rsLoad.GetString("CAP");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
        w_NUMTEL = l_rsLoad.GetString("NUMTEL");
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        if (l_oSqlLoader.m_bLink_1_53) {
          w_xdesctipatt = l_rsLoad.GetString("DESCRI153");
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
        if (l_oSqlLoader.m_bLink_1_75) {
          w_xdes1 = l_rsLoad.GetString("DES1175");
        } else {
          Link_UJRFWINIVQ("Load");
        }
        w_CODANA = l_rsLoad.GetString("CODANA");
        w_CODVOC = l_rsLoad.GetString("CODVOC");
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
        if (l_oSqlLoader.m_bLink_1_92) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC192");
          w_CABINT = l_rsLoad.GetString("CODCAB192");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA192");
          w_CITINT = l_rsLoad.GetString("DESCCIT192");
          w_xCGOFLGPROF = l_rsLoad.GetString("CGOFLGPROF192");
        } else {
          Link_WJSVGWKSFC("Load");
        }
        w_SEGNO = l_rsLoad.GetString("SEGNO");
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        // Link con operazbo non eseguito: riporta solo campi
        w_CACODICE = l_rsLoad.GetDouble("CACODICE");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_IDDOCALL = l_rsLoad.GetString("IDDOCALL");
        w_FLGDOCALL = l_rsLoad.GetString("FLGDOCALL");
        w_edtdoc = CPLib.Empty(w_IDDOCALL) || CPLib.Empty(w_TIPOGIOCO) || CPLib.le(w_TOTLIRE,0) || (CPLib.eq(w_FLAGCONT,"1") && CPLib.le(w_TOTCONT,0)) || (CPLib.eq(w_FLAGWALLET,"1") && CPLib.le(w_IMPWALLET,0));
        w_saveddoc = "N";
        w_TIPODOC = l_rsLoad.GetString("TIPODOC");
        if (l_oSqlLoader.m_bLink_1_179) {
          w_DESCRI = l_rsLoad.GetString("DESCRI279");
        } else {
          Link_MBGANUUHRA("Load");
        }
        w_NUMDOCUM = l_rsLoad.GetString("NUMDOCUM");
        w_DATARILASC = l_rsLoad.GetDate("DATARILASC");
        w_DATAVALI = l_rsLoad.GetDate("DATAVALI");
        w_RDCODAUT = l_rsLoad.GetString("RDCODAUT");
        if (l_oSqlLoader.m_bLink_1_183) {
          w_xARDESCRI = l_rsLoad.GetString("ARDESCRI283");
        } else {
          Link_YDUQCBNYFV("Load");
        }
        w_RDLOCAUT = l_rsLoad.GetString("RDLOCAUT");
        w_AUTRILASC = l_rsLoad.GetString("AUTRILASC");
        w_PEPDESCRI = l_rsLoad.GetString("PEPDESCRI");
        w_PAESE2 = l_rsLoad.GetString("PAESE2");
        if (l_oSqlLoader.m_bLink_1_191) {
          w_dessta2 = l_rsLoad.GetString("DESCRI291");
        } else {
          Link_UOOQYQWWNG("Load");
        }
        w_DESCCIT2 = l_rsLoad.GetString("DESCCIT2");
        w_idcitta2 = "";
        Link_BVEIQEJCLQ("Load");
        w_PROVINCIA2 = "";
        w_CAP2 = "";
        Link_HNAYMCHXMY("Load");
        w_PROVINCIA2 = l_rsLoad.GetString("PROVINCIA2");
        w_CAP2 = l_rsLoad.GetString("CAP2");
        w_DOMICILIO2 = l_rsLoad.GetString("DOMICILIO2");
        w_FLGDOM = l_rsLoad.GetString("FLGDOM");
        w_PROFESSIONE = l_rsLoad.GetString("PROFESSIONE");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_227) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ327");
          w_CITDIP = l_rsLoad.GetString("DESCCIT327");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA327");
          w_CABDIP = l_rsLoad.GetString("CAB327");
          w_TELDIP = l_rsLoad.GetString("TELEFONO327");
          w_CODLOC = l_rsLoad.GetString("CODLOC327");
        } else {
          Link_AVHTGZTOSZ("Load");
        }
        w_DESCCITDIP = l_rsLoad.GetString("DESCCITDIP");
        w_PROVINCIADIP = l_rsLoad.GetString("PROVINCIADIP");
        w_CODCABDIP = l_rsLoad.GetString("CODCABDIP");
        w_dirupl = CPLib.LRTrim(w_gPathApp)+"/appo";
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_armt_cgo_qadv_operazioni_dl = "";
        armt_cgo_qadv_operazioni_dl.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl")) {
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
    // * --- armt_cgo_oper
    SetUpdated();
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_operazioni_dl);
      l_cSql = "insert into "+m_oWrInfo_cgo_operazioni_dl.GetTableWriteName()+" (";
      l_cSql = l_cSql+"TIPOGIOCO,";
      l_cSql = l_cSql+"CGOTIPOPE,";
      l_cSql = l_cSql+"VLTPLAT,";
      l_cSql = l_cSql+"CAIDBIGLIETTO,";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"FLAGCONT,";
      l_cSql = l_cSql+"FLAGWALLET,";
      l_cSql = l_cSql+"CAFLGOPE,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"TOTCONT,";
      l_cSql = l_cSql+"IMPWALLET,";
      l_cSql = l_cSql+"CODWALLET,";
      l_cSql = l_cSql+"CODTRANSZ,";
      l_cSql = l_cSql+"CGOFLGVLT,";
      l_cSql = l_cSql+"CGOFLGVNP,";
      l_cSql = l_cSql+"MEZPAGAM,";
      l_cSql = l_cSql+"CC4CIFRE,";
      l_cSql = l_cSql+"CCMESSCA,";
      l_cSql = l_cSql+"CCANNSCA,";
      l_cSql = l_cSql+"ASSEGNO,";
      l_cSql = l_cSql+"IBAN,";
      l_cSql = l_cSql+"CCDATSCA,";
      l_cSql = l_cSql+"CFESTERO,";
      l_cSql = l_cSql+"PEP,";
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
      l_cSql = l_cSql+"NUMTEL,";
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
      l_cSql = l_cSql+"SEGNO,";
      l_cSql = l_cSql+"FLAGFRAZ,";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"CACODICE,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"IDDOCALL,";
      l_cSql = l_cSql+"FLGDOCALL,";
      l_cSql = l_cSql+"TIPODOC,";
      l_cSql = l_cSql+"NUMDOCUM,";
      l_cSql = l_cSql+"DATARILASC,";
      l_cSql = l_cSql+"DATAVALI,";
      l_cSql = l_cSql+"RDCODAUT,";
      l_cSql = l_cSql+"RDLOCAUT,";
      l_cSql = l_cSql+"AUTRILASC,";
      l_cSql = l_cSql+"PEPDESCRI,";
      l_cSql = l_cSql+"PAESE2,";
      l_cSql = l_cSql+"DESCCIT2,";
      l_cSql = l_cSql+"PROVINCIA2,";
      l_cSql = l_cSql+"CAP2,";
      l_cSql = l_cSql+"DOMICILIO2,";
      l_cSql = l_cSql+"FLGDOM,";
      l_cSql = l_cSql+"PROFESSIONE,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"DESCCITDIP,";
      l_cSql = l_cSql+"PROVINCIADIP,";
      l_cSql = l_cSql+"CODCABDIP,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOGIOCO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOTIPOPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VLTPLAT,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGCONT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGWALLET,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAFLGOPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTCONT,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPWALLET,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODWALLET,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODTRANSZ,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOFLGVLT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CGOFLGVNP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MEZPAGAM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CC4CIFRE,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CCMESSCA,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CCANNSCA,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ASSEGNO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IBAN,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CCDATSCA,"C",7,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFESTERO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEP,"C",1,0)+", ";
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
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMTEL,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ATTIV,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOPERS,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAGSOC,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOTGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAMOGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SETTSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODANA,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODVOC,"C",2,0)+", ";
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
      l_cSql = l_cSql+CPLib.ToSQL(w_SEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_COLLEG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CACODICE,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDDOCALL,"C",36,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGDOCALL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPODOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMDOCUM,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARILASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVALI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RDCODAUT,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RDLOCAUT,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTRILASC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEPDESCRI,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT2,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP2,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO2,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGDOM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROFESSIONE,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCITDIP,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIADIP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCABDIP,"C",6,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_dl,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_operazioni_dl);
      l_cSql = "Update "+m_oWrInfo_cgo_operazioni_dl.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TIPOGIOCO = "+CPLib.ToSQLNull(w_TIPOGIOCO,"C",3,0);
      l_cSql = l_cSql+", CGOTIPOPE = "+CPLib.ToSQL(w_CGOTIPOPE,"C",1,0);
      l_cSql = l_cSql+", VLTPLAT = "+CPLib.ToSQLNull(w_VLTPLAT,"C",2,0);
      l_cSql = l_cSql+", CAIDBIGLIETTO = "+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",30,0);
      l_cSql = l_cSql+", DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", FLAGCONT = "+CPLib.ToSQL(w_FLAGCONT,"C",1,0);
      l_cSql = l_cSql+", FLAGWALLET = "+CPLib.ToSQL(w_FLAGWALLET,"C",1,0);
      l_cSql = l_cSql+", CAFLGOPE = "+CPLib.ToSQL(w_CAFLGOPE,"C",1,0);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",15,2);
      l_cSql = l_cSql+", TOTCONT = "+CPLib.ToSQL(w_TOTCONT,"N",15,2);
      l_cSql = l_cSql+", IMPWALLET = "+CPLib.ToSQL(w_IMPWALLET,"N",12,2);
      l_cSql = l_cSql+", CODWALLET = "+CPLib.ToSQL(w_CODWALLET,"C",20,0);
      l_cSql = l_cSql+", CODTRANSZ = "+CPLib.ToSQL(w_CODTRANSZ,"C",50,0);
      l_cSql = l_cSql+", CGOFLGVLT = "+CPLib.ToSQL(w_CGOFLGVLT,"C",1,0);
      l_cSql = l_cSql+", CGOFLGVNP = "+CPLib.ToSQL(w_CGOFLGVNP,"C",1,0);
      l_cSql = l_cSql+", MEZPAGAM = "+CPLib.ToSQL(w_MEZPAGAM,"C",1,0);
      l_cSql = l_cSql+", CC4CIFRE = "+CPLib.ToSQL(w_CC4CIFRE,"C",4,0);
      l_cSql = l_cSql+", CCMESSCA = "+CPLib.ToSQL(w_CCMESSCA,"N",2,0);
      l_cSql = l_cSql+", CCANNSCA = "+CPLib.ToSQL(w_CCANNSCA,"N",4,0);
      l_cSql = l_cSql+", ASSEGNO = "+CPLib.ToSQL(w_ASSEGNO,"C",25,0);
      l_cSql = l_cSql+", IBAN = "+CPLib.ToSQL(w_IBAN,"C",40,0);
      l_cSql = l_cSql+", CCDATSCA = "+CPLib.ToSQL(w_CCDATSCA,"C",7,0);
      l_cSql = l_cSql+", CFESTERO = "+CPLib.ToSQL(w_CFESTERO,"N",1,0);
      l_cSql = l_cSql+", PEP = "+CPLib.ToSQL(w_PEP,"C",1,0);
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
      l_cSql = l_cSql+", NUMTEL = "+CPLib.ToSQL(w_NUMTEL,"C",20,0);
      l_cSql = l_cSql+", ATTIV = "+CPLib.ToSQLNull(w_ATTIV,"C",10,0);
      l_cSql = l_cSql+", TIPOPERS = "+CPLib.ToSQL(w_TIPOPERS,"C",1,0);
      l_cSql = l_cSql+", RAGSOC = "+CPLib.ToSQL(w_RAGSOC,"C",70,0);
      l_cSql = l_cSql+", SOTGRUP = "+CPLib.ToSQL(w_SOTGRUP,"C",3,0);
      l_cSql = l_cSql+", RAMOGRUP = "+CPLib.ToSQL(w_RAMOGRUP,"C",3,0);
      l_cSql = l_cSql+", SETTSINT = "+CPLib.ToSQL(w_SETTSINT,"C",3,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"D",8,0);
      l_cSql = l_cSql+", TIPOOPRAP = "+CPLib.ToSQLNull(w_TIPOOPRAP,"C",2,0);
      l_cSql = l_cSql+", CODANA = "+CPLib.ToSQL(w_CODANA,"C",4,0);
      l_cSql = l_cSql+", CODVOC = "+CPLib.ToSQL(w_CODVOC,"C",2,0);
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
      l_cSql = l_cSql+", SEGNO = "+CPLib.ToSQL(w_SEGNO,"C",1,0);
      l_cSql = l_cSql+", FLAGFRAZ = "+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0);
      l_cSql = l_cSql+", COLLEG = "+CPLib.ToSQLNull(w_COLLEG,"C",11,0);
      l_cSql = l_cSql+", CACODICE = "+CPLib.ToSQL(w_CACODICE,"N",5,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", IDDOCALL = "+CPLib.ToSQL(w_IDDOCALL,"C",36,0);
      l_cSql = l_cSql+", FLGDOCALL = "+CPLib.ToSQL(w_FLGDOCALL,"C",1,0);
      l_cSql = l_cSql+", TIPODOC = "+CPLib.ToSQLNull(w_TIPODOC,"C",2,0);
      l_cSql = l_cSql+", NUMDOCUM = "+CPLib.ToSQL(w_NUMDOCUM,"C",15,0);
      l_cSql = l_cSql+", DATARILASC = "+CPLib.ToSQL(w_DATARILASC,"D",8,0);
      l_cSql = l_cSql+", DATAVALI = "+CPLib.ToSQL(w_DATAVALI,"D",8,0);
      l_cSql = l_cSql+", RDCODAUT = "+CPLib.ToSQLNull(w_RDCODAUT,"C",2,0);
      l_cSql = l_cSql+", RDLOCAUT = "+CPLib.ToSQL(w_RDLOCAUT,"C",20,0);
      l_cSql = l_cSql+", AUTRILASC = "+CPLib.ToSQL(w_AUTRILASC,"C",30,0);
      l_cSql = l_cSql+", PEPDESCRI = "+CPLib.ToSQL(w_PEPDESCRI,"C",80,0);
      l_cSql = l_cSql+", PAESE2 = "+CPLib.ToSQLNull(w_PAESE2,"C",3,0);
      l_cSql = l_cSql+", DESCCIT2 = "+CPLib.ToSQL(w_DESCCIT2,"C",40,0);
      l_cSql = l_cSql+", PROVINCIA2 = "+CPLib.ToSQL(w_PROVINCIA2,"C",2,0);
      l_cSql = l_cSql+", CAP2 = "+CPLib.ToSQL(w_CAP2,"C",9,0);
      l_cSql = l_cSql+", DOMICILIO2 = "+CPLib.ToSQL(w_DOMICILIO2,"C",35,0);
      l_cSql = l_cSql+", FLGDOM = "+CPLib.ToSQL(w_FLGDOM,"C",1,0);
      l_cSql = l_cSql+", PROFESSIONE = "+CPLib.ToSQL(w_PROFESSIONE,"C",40,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", DESCCITDIP = "+CPLib.ToSQL(w_DESCCITDIP,"C",30,0);
      l_cSql = l_cSql+", PROVINCIADIP = "+CPLib.ToSQL(w_PROVINCIADIP,"C",2,0);
      l_cSql = l_cSql+", CODCABDIP = "+CPLib.ToSQL(w_CODCABDIP,"C",6,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_dl,w_SNAINUMOPE);
      l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_dl,l_cSql,m_oParameters);
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
    // * --- armt_cgo_oper
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
          armt_cgo_qadv_operazioni_dl.w_SNAINUMOPE = w_SNAINUMOPE;
          armt_cgo_qadv_operazioni_dl.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_cgo_operazioni_dl.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_operazioni_dl,w_SNAINUMOPE);
          l_cSql = l_cSql+m_oWrInfo_cgo_operazioni_dl.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_operazioni_dl")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_operazioni_dl,l_cSql);
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
    // * --- armt_cgo_oper
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
    m_Sql.NextTableProg(this,"PRGNUMOPE","i_codazi,w_SNAINUMOPE",m_cServer_cgo_operazioni_dl,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave SNAINUMOPE, altrimenti non si riesce a linkare da zoom
    w_SNAINUMOPE = CPLib.RTrim(w_SNAINUMOPE);
    op_SNAINUMOPE = w_SNAINUMOPE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"QZTTRBWAQL")) {
      result.m_TableName = "cgo_tbtipgio";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_cgo_tbtipgio";
      result.m_rdField = new String[]{"CODTPGIO" , "SOGTPGIO" , "DEFTPGIO" , "EDTTPGIO" , "EDTSPGIO" , "DEFSPGIO" , "FLGPLGIO" , "FLTIPGIO" , "IMPMINGIO"};
      result.m_rdTypes = new String[]{"C" , "N" , "C" , "C" , "C" , "C" , "C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QZTTRBWAQL",CPLib.GetLinkedFieldProps("CODTPGIO","TIPOGIOCO","C",3,0));
    } else if (CPLib.eq(p_cID,"LVYFMQXNZH")) {
      result.m_TableName = "cgo_vltplat";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_cgo_vltplat";
      result.m_rdField = new String[]{"VPCODICE" , "VPFLGATT"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LVYFMQXNZH",CPLib.GetLinkedFieldProps("VPCODICE","VLTPLAT","C",2,0));
    } else if (CPLib.eq(p_cID,"NEUBQNUEOJ")) {
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
      result.m_rdField = new String[]{"CODINTER" , "DATANASC" , "CODCAB" , "PROVINCIA" , "DESCCIT" , "CGOFLGPROF"};
      result.m_rdTypes = new String[]{"C" , "D" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("WJSVGWKSFC",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0),CPLib.GetLinkedFieldProps("CGOFLGPROF","xCGOFLGPROF","C",1,0));
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
    } else if (CPLib.eq(p_cID,"YDUQCBNYFV")) {
      result.m_TableName = "cgo_autorita";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_cgo_autorita";
      result.m_rdField = new String[]{"ARCODICE" , "ARDESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YDUQCBNYFV",CPLib.GetLinkedFieldProps("ARCODICE","RDCODAUT","C",2,0));
    } else if (CPLib.eq(p_cID,"UOOQYQWWNG")) {
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
      result.AppendFieldsHash("UOOQYQWWNG",CPLib.GetLinkedFieldProps("CODSTA","PAESE2","C",3,0));
    } else if (CPLib.eq(p_cID,"BVEIQEJCLQ")) {
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
      result.AppendFieldsHash("BVEIQEJCLQ",CPLib.GetLinkedFieldProps("CITTA","DESCCIT2","C",40,0),CPLib.GetLinkedFieldProps("PKTBSTATI","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"HNAYMCHXMY")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "PROV" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HNAYMCHXMY",CPLib.GetLinkedFieldProps("IDBASE","idcitta2","C",10,0));
    } else if (CPLib.eq(p_cID,"AVHTGZTOSZ")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ" , "DESCCIT" , "PROVINCIA" , "CAB" , "TELEFONO" , "CODLOC"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AVHTGZTOSZ",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_agechar,arfn_cgo_chkcap,arfn_cgo_chkcc,arfn_cgo_chkdata,arfn_cgo_chkdocs,arfn_cgo_chkidb,arfn_chk_docaut,arfn_chkcodfis,arfn_chkiban,arfn_chktotalelire_cont,arfn_form_cf,arfn_maggiorenne,arrt_cgo_confirm_doc,arrt_cgo_qadv_mail,arrt_cgo_setpagatore,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_cgo_chkcap,arfn_cgo_chkcc,arfn_cgo_chkdata,arfn_cgo_chkdocs,arfn_cgo_chkidb,arfn_chk_docaut,arfn_chkcodfis,arfn_chkiban,arfn_chktotalelire_cont,arfn_form_cf,arfn_maggiorenne,arrt_cgo_confirm_doc,arrt_cgo_qadv_mail,arrt_cgo_setpagatore,arrt_writelog,";
}
