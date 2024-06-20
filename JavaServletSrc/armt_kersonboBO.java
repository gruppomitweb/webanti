// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_kersonboBO extends armt_kersonboBL {
  class SqlLoader {
    public boolean m_bLink_1_9 = false;
    public boolean m_bLink_1_21 = false;
    public boolean m_bLink_1_28 = false;
    public boolean m_bLink_1_29 = false;
    public boolean m_bLink_1_76 = false;
    public boolean m_bLink_1_77 = false;
    public boolean m_bLink_1_78 = false;
    public boolean m_bLink_1_79 = false;
    public boolean m_bLink_1_84 = false;
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
    public void AddJoinedLink_1_9(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_9.CODSTA AS CODSTA109";
        m_cSelect = m_cSelect+" ,link_1_9.DESCRI AS DESCRI109";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_9","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_9","PAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_9 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_21(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_21.TIPDOC AS TIPDOC121";
        m_cSelect = m_cSelect+" ,link_1_21.DESCRI AS DESCRI121";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_21","TIPODOC","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_21","TIPODOC","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_21 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_28(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_28.SOTGRU AS SOTGRU128";
        m_cSelect = m_cSelect+" ,link_1_28.DESCRI AS DESCRI128";
        m_cSelect = m_cSelect+" ,link_1_28.TIPOSOT AS TIPOSOT128";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_28","SOTGRUP","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_28","SOTGRUP","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_28 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_29(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_29.RAMGRU AS RAMGRU129";
        m_cSelect = m_cSelect+" ,link_1_29.DESCRI AS DESCRI129";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_29","RAMOGRUP","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_29","RAMOGRUP","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_29 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_76(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_76.CODICE AS CODICE176";
        m_cSelect = m_cSelect+" ,link_1_76.DESCRI AS DESCRI176";
        m_cSelect = m_cSelect+" ,link_1_76.RISCHIO AS RISCHIO176";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_76","AREAGEO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_76","AREAGEO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_76 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_77(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_77.CODSPE AS CODSPE177";
        m_cSelect = m_cSelect+" ,link_1_77.DESCRI AS DESCRI177";
        m_cSelect = m_cSelect+" ,link_1_77.RISCHIO AS RISCHIO177";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_77","PKTBSPECIE","CODSPE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_77","PKTBSPECIE","CODSPE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_77 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_78(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_78.CODICE AS CODICE178";
        m_cSelect = m_cSelect+" ,link_1_78.DESCRI AS DESCRI178";
        m_cSelect = m_cSelect+" ,link_1_78.RISCHIO AS RISCHIO178";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_78","ATTIV","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_78","ATTIV","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_78 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_79(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_79.CODICE AS CODICE179";
        m_cSelect = m_cSelect+" ,link_1_79.DESCRI AS DESCRI179";
        m_cSelect = m_cSelect+" ,link_1_79.RISCHIO AS RISCHIO179";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_79","COMPORT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_79","COMPORT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_79 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_84(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_84.CODICE AS CODICE184";
        m_cSelect = m_cSelect+" ,link_1_84.DESCRI AS DESCRI184";
        m_cSelect = m_cSelect+" ,link_1_84.RISCHIO AS RISCHIO184";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_84","ATTIV","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_84","ATTIV","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_84 = true;
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
  public armt_kersonboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_kersonbo");
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
  public static String[] m_cLoadParameterNames = {"CONNES"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CONNES) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_kersonbo,m_cPhName_kersonbo,m_cVirtName_kersonbo,m_cVirtName_kersonbo+".CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CONNES,"C",50,0),m_cServer_kersonbo,p_CONNES),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_9(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_21(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
    l_oSqlLoader.AddJoinedLink_1_28(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_1_29(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_76(m_cPhName_tbareegeog,m_cServer_tbareegeog);
    l_oSqlLoader.AddJoinedLink_1_77(m_cPhName_tbspecie,m_cServer_tbspecie);
    l_oSqlLoader.AddJoinedLink_1_78(m_cPhName_tbtipatt,m_cServer_tbtipatt);
    l_oSqlLoader.AddJoinedLink_1_79(m_cPhName_tbcondotta,m_cServer_tbcondotta);
    l_oSqlLoader.AddJoinedLink_1_84(m_cPhName_tbtipatt,m_cServer_tbtipatt);
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
        w_DESCSGRU = "";
        w_DESCRAMGRU = "";
        w_DESCUIC = "";
        w_dessta = "";
        w_tipsot = "";
        w_STATOREG = "";
        w_IDBASE = "";
        w_NUMPROG = "";
        w_DESCRI = "";
        w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_xdescareag = "";
        w_xdescnatgiu = "";
        w_xdesctipatt = "";
        w_xdesccomp = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_TIPOPERS = l_rsLoad.GetString("TIPOPERS");
        w_COGNOME = l_rsLoad.GetString("COGNOME");
        w_NOME = l_rsLoad.GetString("NOME");
        w_CFESTERO = l_rsLoad.GetDouble("CFESTERO");
        w_RAGSOC = l_rsLoad.GetString("RAGSOC");
        w_PAESE = l_rsLoad.GetString("PAESE");
        if (l_oSqlLoader.m_bLink_1_9) {
          w_dessta = l_rsLoad.GetString("DESCRI109");
        } else {
          Link_YVIKEGPYPM("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        // Link con tbcitta non eseguito: riporta solo campi
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_idcitta = l_rsLoad.GetString("idcitta");
        // Link con tbcitta non eseguito: riporta solo campi
        w_CAP = l_rsLoad.GetString("CAP");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
        w_NASCOMUN = l_rsLoad.GetString("NASCOMUN");
        // Link con tbcitta non eseguito: riporta solo campi
        w_TIPINTER = l_rsLoad.GetString("TIPINTER");
        w_SESSO = l_rsLoad.GetString("SESSO");
        w_NASSTATO = l_rsLoad.GetString("NASSTATO");
        // Link con tbstati non eseguito: riporta solo campi
        w_DATANASC = l_rsLoad.GetDate("DATANASC");
        w_TIPODOC = l_rsLoad.GetString("TIPODOC");
        if (l_oSqlLoader.m_bLink_1_21) {
          w_DESCRI = l_rsLoad.GetString("DESCRI121");
        } else {
          Link_MBGANUUHRA("Load");
        }
        w_NUMDOCUM = l_rsLoad.GetString("NUMDOCUM");
        w_DATARILASC = l_rsLoad.GetDate("DATARILASC");
        w_DATAVALI = l_rsLoad.GetDate("DATAVALI");
        w_AUTRILASC = l_rsLoad.GetString("AUTRILASC");
        w_CODFISC = l_rsLoad.GetString("CODFISC");
        w_PARTIVA = l_rsLoad.GetString("PARTIVA");
        w_SOTGRUP = l_rsLoad.GetString("SOTGRUP");
        if (l_oSqlLoader.m_bLink_1_28) {
          w_DESCSGRU = l_rsLoad.GetString("DESCRI128");
          w_tipsot = l_rsLoad.GetString("TIPOSOT128");
        } else {
          Link_LLYIGAMXRH("Load");
        }
        w_RAMOGRUP = l_rsLoad.GetString("RAMOGRUP");
        if (l_oSqlLoader.m_bLink_1_29) {
          w_DESCRAMGRU = l_rsLoad.GetString("DESCRI129");
        } else {
          Link_RVNHQCXNEM("Load");
        }
        w_SETTSINT = l_rsLoad.GetString("SETTSINT");
        w_DESCUIC = "";
        Link_ZGNLLSFQHC("Load");
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_PROGIMPORT = l_rsLoad.GetDouble("PROGIMPORT");
        op_PROGIMPORT = w_PROGIMPORT;
        w_PEP = l_rsLoad.GetString("PEP");
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        if (l_oSqlLoader.m_bLink_1_76) {
          w_xdescareag = l_rsLoad.GetString("DESCRI176");
          w_RAREA = l_rsLoad.GetDouble("RISCHIO176");
        } else {
          Link_QJSTZIPOQB("Load");
        }
        w_PKTBSPECIE = l_rsLoad.GetString("PKTBSPECIE");
        if (l_oSqlLoader.m_bLink_1_77) {
          w_xdescnatgiu = l_rsLoad.GetString("DESCRI177");
          w_RNATGIU = l_rsLoad.GetDouble("RISCHIO177");
        } else {
          Link_SFFFOYOWNH("Load");
        }
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        if (l_oSqlLoader.m_bLink_1_78) {
          w_xdesctipatt = l_rsLoad.GetString("DESCRI178");
          w_RATTIV = l_rsLoad.GetDouble("RISCHIO178");
        } else {
          Link_NOBMPHKVTX("Load");
        }
        w_COMPORT = l_rsLoad.GetString("COMPORT");
        if (l_oSqlLoader.m_bLink_1_79) {
          w_xdesccomp = l_rsLoad.GetString("DESCRI179");
          w_RCOMP = l_rsLoad.GetDouble("RISCHIO179");
        } else {
          Link_DJOWYRMDDC("Load");
        }
        w_RAREA = l_rsLoad.GetDouble("RAREA");
        w_RNATGIU = l_rsLoad.GetDouble("RNATGIU");
        w_RATTIV = l_rsLoad.GetDouble("RATTIV");
        w_RCOMP = l_rsLoad.GetDouble("RCOMP");
        w_ATTIV = l_rsLoad.GetString("ATTIV");
        if (l_oSqlLoader.m_bLink_1_84) {
          w_xdesctipatt = l_rsLoad.GetString("DESCRI184");
          w_RATTIV = l_rsLoad.GetDouble("RISCHIO184");
        } else {
          Link_SAQTIHOALW("Load");
        }
        w_datamodi = l_rsLoad.GetDate("datamodi");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"kersonbo")) {
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_kersonbo);
      l_cSql = "insert into "+m_oWrInfo_kersonbo.GetTableWriteName()+" (";
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
      l_cSql = l_cSql+"NASCOMUN,";
      l_cSql = l_cSql+"TIPINTER,";
      l_cSql = l_cSql+"SESSO,";
      l_cSql = l_cSql+"NASSTATO,";
      l_cSql = l_cSql+"DATANASC,";
      l_cSql = l_cSql+"TIPODOC,";
      l_cSql = l_cSql+"NUMDOCUM,";
      l_cSql = l_cSql+"DATARILASC,";
      l_cSql = l_cSql+"DATAVALI,";
      l_cSql = l_cSql+"AUTRILASC,";
      l_cSql = l_cSql+"CODFISC,";
      l_cSql = l_cSql+"PARTIVA,";
      l_cSql = l_cSql+"SOTGRUP,";
      l_cSql = l_cSql+"RAMOGRUP,";
      l_cSql = l_cSql+"SETTSINT,";
      l_cSql = l_cSql+"CONNES,";
      l_cSql = l_cSql+"PROGIMPORT,";
      l_cSql = l_cSql+"PEP,";
      l_cSql = l_cSql+"AREAGEO,";
      l_cSql = l_cSql+"PKTBSPECIE,";
      l_cSql = l_cSql+"ATTIV,";
      l_cSql = l_cSql+"COMPORT,";
      l_cSql = l_cSql+"RAREA,";
      l_cSql = l_cSql+"RNATGIU,";
      l_cSql = l_cSql+"RATTIV,";
      l_cSql = l_cSql+"RCOMP,";
      l_cSql = l_cSql+"datamodi,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_kersonbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kersonbo")) {
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
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_idcitta,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASCOMUN,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPINTER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASSTATO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATANASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPODOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMDOCUM,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARILASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVALI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTRILASC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODFISC,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PARTIVA,"C",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOTGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAMOGRUP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SETTSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNES,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROGIMPORT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AREAGEO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PKTBSPECIE,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ATTIV,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_COMPORT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RNATGIU,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RATTIV,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_datamodi,"D",8,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_kersonbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kersonbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_kersonbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_kersonbo);
      l_cSql = "Update "+m_oWrInfo_kersonbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" TIPOPERS = "+CPLib.ToSQL(w_TIPOPERS,"C",1,0);
      l_cSql = l_cSql+", COGNOME = "+CPLib.ToSQL(w_COGNOME,"C",26,0);
      l_cSql = l_cSql+", NOME = "+CPLib.ToSQL(w_NOME,"C",25,0);
      l_cSql = l_cSql+", CFESTERO = "+CPLib.ToSQL(w_CFESTERO,"N",1,0);
      l_cSql = l_cSql+", RAGSOC = "+CPLib.ToSQL(w_RAGSOC,"C",70,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQLNull(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",40,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", idcitta = "+CPLib.ToSQLNull(w_idcitta,"C",10,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",9,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", DOMICILIO = "+CPLib.ToSQL(w_DOMICILIO,"C",35,0);
      l_cSql = l_cSql+", NASCOMUN = "+CPLib.ToSQL(w_NASCOMUN,"C",30,0);
      l_cSql = l_cSql+", TIPINTER = "+CPLib.ToSQL(w_TIPINTER,"C",2,0);
      l_cSql = l_cSql+", SESSO = "+CPLib.ToSQL(w_SESSO,"C",1,0);
      l_cSql = l_cSql+", NASSTATO = "+CPLib.ToSQL(w_NASSTATO,"C",30,0);
      l_cSql = l_cSql+", DATANASC = "+CPLib.ToSQL(w_DATANASC,"D",8,0);
      l_cSql = l_cSql+", TIPODOC = "+CPLib.ToSQLNull(w_TIPODOC,"C",2,0);
      l_cSql = l_cSql+", NUMDOCUM = "+CPLib.ToSQL(w_NUMDOCUM,"C",15,0);
      l_cSql = l_cSql+", DATARILASC = "+CPLib.ToSQL(w_DATARILASC,"D",8,0);
      l_cSql = l_cSql+", DATAVALI = "+CPLib.ToSQL(w_DATAVALI,"D",8,0);
      l_cSql = l_cSql+", AUTRILASC = "+CPLib.ToSQL(w_AUTRILASC,"C",30,0);
      l_cSql = l_cSql+", CODFISC = "+CPLib.ToSQL(w_CODFISC,"C",16,0);
      l_cSql = l_cSql+", PARTIVA = "+CPLib.ToSQL(w_PARTIVA,"C",14,0);
      l_cSql = l_cSql+", SOTGRUP = "+CPLib.ToSQLNull(w_SOTGRUP,"C",3,0);
      l_cSql = l_cSql+", RAMOGRUP = "+CPLib.ToSQLNull(w_RAMOGRUP,"C",3,0);
      l_cSql = l_cSql+", SETTSINT = "+CPLib.ToSQLNull(w_SETTSINT,"C",3,0);
      l_cSql = l_cSql+", PROGIMPORT = "+CPLib.ToSQL(w_PROGIMPORT,"N",15,0);
      l_cSql = l_cSql+", PEP = "+CPLib.ToSQL(w_PEP,"C",1,0);
      l_cSql = l_cSql+", AREAGEO = "+CPLib.ToSQLNull(w_AREAGEO,"C",5,0);
      l_cSql = l_cSql+", PKTBSPECIE = "+CPLib.ToSQLNull(w_PKTBSPECIE,"C",4,0);
      l_cSql = l_cSql+", ATTIV = "+CPLib.ToSQLNull(w_ATTIV,"C",10,0);
      l_cSql = l_cSql+", COMPORT = "+CPLib.ToSQLNull(w_COMPORT,"C",5,0);
      l_cSql = l_cSql+", RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0);
      l_cSql = l_cSql+", RNATGIU = "+CPLib.ToSQL(w_RNATGIU,"N",3,0);
      l_cSql = l_cSql+", RATTIV = "+CPLib.ToSQL(w_RATTIV,"N",3,0);
      l_cSql = l_cSql+", RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0);
      l_cSql = l_cSql+", datamodi = "+CPLib.ToSQL(w_datamodi,"D",8,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kersonbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",50,0),m_cServer_kersonbo,w_CONNES);
      l_cSql = l_cSql+m_oWrInfo_kersonbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"kersonbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_kersonbo,l_cSql,m_oParameters);
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
    // * --- armt_kersonbo
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
          l_cSql = "Delete from "+m_oWrInfo_kersonbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",50,0),m_cServer_kersonbo,w_CONNES);
          l_cSql = l_cSql+m_oWrInfo_kersonbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"kersonbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_kersonbo,l_cSql);
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
    // * --- armt_kersonbo
    NotifyEvent("Record Deleted");
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_CONNES);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPOCLI","i_codazi,w_PROGIMPORT",m_cServer_kersonbo,m_Ctx.GetCompany());
    op_PROGIMPORT = w_PROGIMPORT;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"YVIKEGPYPM")) {
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
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",40,0),CPLib.GetLinkedFieldProps("PKTBSTATI","PAESE","C",3,0));
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
      result.AppendFieldsHash("TYEDHRZCMA",CPLib.GetLinkedFieldProps("IDBASE","idcitta","C",10,0));
    } else if (CPLib.eq(p_cID,"NEUBQNUEOJ")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
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
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HODZKKOSYW",CPLib.GetLinkedFieldProps("DESCRI","NASSTATO","C",30,0));
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
    } else if (CPLib.eq(p_cID,"QJSTZIPOQB")) {
      result.m_TableName = "tbareegeog";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QJSTZIPOQB",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",5,0));
    } else if (CPLib.eq(p_cID,"SFFFOYOWNH")) {
      result.m_TableName = "tbspecie";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbspecie";
      result.m_rdField = new String[]{"CODSPE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SFFFOYOWNH",CPLib.GetLinkedFieldProps("CODSPE","PKTBSPECIE","C",4,0));
    } else if (CPLib.eq(p_cID,"NOBMPHKVTX")) {
      result.m_TableName = "tbtipatt";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbtipatt";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NOBMPHKVTX",CPLib.GetLinkedFieldProps("CODICE","ATTIV","C",10,0));
    } else if (CPLib.eq(p_cID,"DJOWYRMDDC")) {
      result.m_TableName = "tbcondotta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbcondotta";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DJOWYRMDDC",CPLib.GetLinkedFieldProps("CODICE","COMPORT","C",5,0));
    } else if (CPLib.eq(p_cID,"SAQTIHOALW")) {
      result.m_TableName = "tbtipatt";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbtipatt";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SAQTIHOALW",CPLib.GetLinkedFieldProps("CODICE","ATTIV","C",10,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_chkcodfis,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,";
}
