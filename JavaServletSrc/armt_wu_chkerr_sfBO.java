// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_wu_chkerr_sfBO extends armt_wu_chkerr_sfBL {
  class SqlLoader {
    public boolean m_bLink_1_76 = false;
    public boolean m_bLink_1_80 = false;
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
    public void AddJoinedLink_1_76(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_76.MACODICE AS MACODICE176";
        m_cSelect = m_cSelect+" ,link_1_76.MADESCRI AS MADESCRI176";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_76","WUCODMAGE","MACODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_76","WUCODMAGE","MACODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_76 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_80(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_80.CODDIP AS CODDIP180";
        m_cSelect = m_cSelect+" ,link_1_80.DESCCIT AS DESCCIT180";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_80","WUCODDIP","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_80","WUCODDIP","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_80 = true;
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
  public armt_wu_chkerr_sfBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_wu_chkerr_sf");
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
  public static String[] m_cLoadParameterNames = {"WUCODICE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_WUCODICE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_wuchkimp_sf,m_cPhName_wuchkimp_sf,m_cVirtName_wuchkimp_sf,m_cVirtName_wuchkimp_sf+".WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_WUCODICE,"N",10,0),m_cServer_wuchkimp_sf,p_WUCODICE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_76(m_cPhName_tbmacage,m_cServer_tbmacage);
    l_oSqlLoader.AddJoinedLink_1_80(m_cPhName_anadip,m_cServer_anadip);
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
        w_xMADESCRI = "";
        w_xDESDIP = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_WUNOMEFILE = l_rsLoad.GetString("WUNOMEFILE");
        w_WURIFMTCN = l_rsLoad.GetString("WURIFMTCN");
        w_WUTIPOPE = l_rsLoad.GetString("WUTIPOPE");
        w_WUCODDIP = l_rsLoad.GetString("WUCODDIP");
        w_WUDATOPE = l_rsLoad.GetDate("WUDATOPE");
        w_WUIMPORTO = l_rsLoad.GetDouble("WUIMPORTO");
        w_WUSTADES = l_rsLoad.GetString("WUSTADES");
        w_WUTIPERR = l_rsLoad.GetString("WUTIPERR");
        w_WUCODICE = l_rsLoad.GetDouble("WUCODICE");
        w_WUNDATOPE = l_rsLoad.GetDate("WUNDATOPE");
        w_WUNCAPCLI = l_rsLoad.GetString("WUNCAPCLI");
        w_WUNDATNAS = l_rsLoad.GetDate("WUNDATNAS");
        w_WUNRDOCCLI = l_rsLoad.GetDate("WUNRDOCCLI");
        w_WUNSDOCCLI = l_rsLoad.GetDate("WUNSDOCCLI");
        w_WUNTDOCCLI = l_rsLoad.GetString("WUNTDOCCLI");
        w_WUNSTADES = l_rsLoad.GetString("WUNSTADES");
        w_WUNCODDIP = l_rsLoad.GetString("WUNCODDIP");
        // Link con anadip non eseguito: riporta solo campi
        w_WUNCITCLI = l_rsLoad.GetString("WUNCITCLI");
        // Link con tbcitta non eseguito: riporta solo campi
        w_WUNBSTACLI = l_rsLoad.GetString("WUNBSTACLI");
        // Link con tbstati non eseguito: riporta solo campi
        w_WUNBCITCLI = l_rsLoad.GetString("WUNBCITCLI");
        // Link con tbcitta non eseguito: riporta solo campi
        w_WUNOMCLI = l_rsLoad.GetString("WUNOMCLI");
        w_WUCOGCLI = l_rsLoad.GetString("WUCOGCLI");
        w_WUCITCLI = l_rsLoad.GetString("WUCITCLI");
        w_WUCAPCLI = l_rsLoad.GetString("WUCAPCLI");
        w_WUINDCLI = l_rsLoad.GetString("WUINDCLI");
        w_WUNOMCON = l_rsLoad.GetString("WUNOMCON");
        w_WUCOGCON = l_rsLoad.GetString("WUCOGCON");
        w_WUBCITCLI = l_rsLoad.GetString("WUBCITCLI");
        w_WUDATNAS = l_rsLoad.GetString("WUDATNAS");
        w_WUCODFIS = l_rsLoad.GetString("WUCODFIS");
        w_WUNDOCCLI = l_rsLoad.GetString("WUNDOCCLI");
        w_WUADOCRIL = l_rsLoad.GetString("WUADOCRIL");
        w_WURDOCCLI = l_rsLoad.GetDate("WURDOCCLI");
        w_WUSDOCCLI = l_rsLoad.GetDate("WUSDOCCLI");
        w_WUSEXCLI = l_rsLoad.GetString("WUSEXCLI");
        w_WUTDOCCLI = l_rsLoad.GetString("WUTDOCCLI");
        w_WUFLGALL = l_rsLoad.GetString("WUFLGALL");
        w_WUNCODFIS = l_rsLoad.GetString("WUNCODFIS");
        w_WUCODMAGE = l_rsLoad.GetString("WUCODMAGE");
        if (l_oSqlLoader.m_bLink_1_76) {
          w_xMADESCRI = l_rsLoad.GetString("MADESCRI176");
        } else {
          Link_FHWIGGJJLC("Load");
        }
        w_WUCODDIP = l_rsLoad.GetString("WUCODDIP");
        if (l_oSqlLoader.m_bLink_1_80) {
          w_xDESDIP = l_rsLoad.GetString("DESCCIT180");
        } else {
          Link_HHRNUENTOX("Load");
        }
        w_WUNOTE = l_rsLoad.GetString("WUNOTE");
        w_WUFLGFRC = l_rsLoad.GetString("WUFLGFRC");
        w_WUORIGCF = l_rsLoad.GetString("WUORIGCF");
        w_WUSTACLI = l_rsLoad.GetString("WUSTACLI");
        w_WUNSTACLI = l_rsLoad.GetString("WUNSTACLI");
        // Link con tbstati non eseguito: riporta solo campi
        w_WUCONTANTI = l_rsLoad.GetDouble("WUCONTANTI");
        w_WUOPETYPE = l_rsLoad.GetString("WUOPETYPE");
        w_WUCODCLC = l_rsLoad.GetDouble("WUCODCLC");
        w_WUNSEXCLI = l_rsLoad.GetString("WUNSEXCLI");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"wuchkimp_sf")) {
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
    return Load(w_WUCODICE);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_wuchkimp_sf);
      l_cSql = "insert into "+m_oWrInfo_wuchkimp_sf.GetTableWriteName()+" (";
      l_cSql = l_cSql+"WUNOMEFILE,";
      l_cSql = l_cSql+"WURIFMTCN,";
      l_cSql = l_cSql+"WUTIPOPE,";
      l_cSql = l_cSql+"WUCODDIP,";
      l_cSql = l_cSql+"WUDATOPE,";
      l_cSql = l_cSql+"WUIMPORTO,";
      l_cSql = l_cSql+"WUSTADES,";
      l_cSql = l_cSql+"WUTIPERR,";
      l_cSql = l_cSql+"WUCODICE,";
      l_cSql = l_cSql+"WUNDATOPE,";
      l_cSql = l_cSql+"WUNCAPCLI,";
      l_cSql = l_cSql+"WUNDATNAS,";
      l_cSql = l_cSql+"WUNRDOCCLI,";
      l_cSql = l_cSql+"WUNSDOCCLI,";
      l_cSql = l_cSql+"WUNTDOCCLI,";
      l_cSql = l_cSql+"WUNSTADES,";
      l_cSql = l_cSql+"WUNCODDIP,";
      l_cSql = l_cSql+"WUNCITCLI,";
      l_cSql = l_cSql+"WUNBSTACLI,";
      l_cSql = l_cSql+"WUNBCITCLI,";
      l_cSql = l_cSql+"WUNOMCLI,";
      l_cSql = l_cSql+"WUCOGCLI,";
      l_cSql = l_cSql+"WUCITCLI,";
      l_cSql = l_cSql+"WUCAPCLI,";
      l_cSql = l_cSql+"WUINDCLI,";
      l_cSql = l_cSql+"WUNOMCON,";
      l_cSql = l_cSql+"WUCOGCON,";
      l_cSql = l_cSql+"WUBCITCLI,";
      l_cSql = l_cSql+"WUDATNAS,";
      l_cSql = l_cSql+"WUCODFIS,";
      l_cSql = l_cSql+"WUNDOCCLI,";
      l_cSql = l_cSql+"WUADOCRIL,";
      l_cSql = l_cSql+"WURDOCCLI,";
      l_cSql = l_cSql+"WUSDOCCLI,";
      l_cSql = l_cSql+"WUSEXCLI,";
      l_cSql = l_cSql+"WUTDOCCLI,";
      l_cSql = l_cSql+"WUFLGALL,";
      l_cSql = l_cSql+"WUNCODFIS,";
      l_cSql = l_cSql+"WUCODMAGE,";
      l_cSql = l_cSql+"WUNOTE,";
      l_cSql = l_cSql+"WUFLGFRC,";
      l_cSql = l_cSql+"WUORIGCF,";
      l_cSql = l_cSql+"WUSTACLI,";
      l_cSql = l_cSql+"WUNSTACLI,";
      l_cSql = l_cSql+"WUCONTANTI,";
      l_cSql = l_cSql+"WUOPETYPE,";
      l_cSql = l_cSql+"WUCODCLC,";
      l_cSql = l_cSql+"WUNSEXCLI,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_wuchkimp_sf.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuchkimp_sf")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNOMEFILE,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WURIFMTCN,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUTIPOPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCODDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUDATOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUIMPORTO,"N",10,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUSTADES,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUTIPERR,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCODICE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNDATOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNCAPCLI,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNDATNAS,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNRDOCCLI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNSDOCCLI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNTDOCCLI,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNSTADES,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_WUNCODDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_WUNCITCLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_WUNBSTACLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_WUNBCITCLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNOMCLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCOGCLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCITCLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCAPCLI,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUINDCLI,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNOMCON,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCOGCON,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUBCITCLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUDATNAS,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCODFIS,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNDOCCLI,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUADOCRIL,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WURDOCCLI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUSDOCCLI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUSEXCLI,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUTDOCCLI,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUFLGALL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNCODFIS,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_WUCODMAGE,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNOTE,"M",10,0,m_cServer_wuchkimp_sf,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUFLGFRC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUORIGCF,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUSTACLI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_WUNSTACLI,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCONTANTI,"N",10,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUOPETYPE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUCODCLC,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_WUNSEXCLI,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_wuchkimp_sf.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuchkimp_sf")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_wuchkimp_sf,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_wuchkimp_sf);
      l_cSql = "Update "+m_oWrInfo_wuchkimp_sf.GetTableWriteName()+" set";
      l_cSql = l_cSql+" WUNOMEFILE = "+CPLib.ToSQL(w_WUNOMEFILE,"C",20,0);
      l_cSql = l_cSql+", WURIFMTCN = "+CPLib.ToSQL(w_WURIFMTCN,"C",10,0);
      l_cSql = l_cSql+", WUTIPOPE = "+CPLib.ToSQL(w_WUTIPOPE,"C",1,0);
      l_cSql = l_cSql+", WUCODDIP = "+CPLib.ToSQL(w_WUCODDIP,"C",6,0);
      l_cSql = l_cSql+", WUDATOPE = "+CPLib.ToSQL(w_WUDATOPE,"D",8,0);
      l_cSql = l_cSql+", WUIMPORTO = "+CPLib.ToSQL(w_WUIMPORTO,"N",10,2);
      l_cSql = l_cSql+", WUSTADES = "+CPLib.ToSQL(w_WUSTADES,"C",3,0);
      l_cSql = l_cSql+", WUTIPERR = "+CPLib.ToSQL(w_WUTIPERR,"C",2,0);
      l_cSql = l_cSql+", WUNDATOPE = "+CPLib.ToSQL(w_WUNDATOPE,"D",8,0);
      l_cSql = l_cSql+", WUNCAPCLI = "+CPLib.ToSQL(w_WUNCAPCLI,"C",5,0);
      l_cSql = l_cSql+", WUNDATNAS = "+CPLib.ToSQL(w_WUNDATNAS,"D",8,0);
      l_cSql = l_cSql+", WUNRDOCCLI = "+CPLib.ToSQL(w_WUNRDOCCLI,"D",8,0);
      l_cSql = l_cSql+", WUNSDOCCLI = "+CPLib.ToSQL(w_WUNSDOCCLI,"D",8,0);
      l_cSql = l_cSql+", WUNTDOCCLI = "+CPLib.ToSQL(w_WUNTDOCCLI,"C",2,0);
      l_cSql = l_cSql+", WUNSTADES = "+CPLib.ToSQL(w_WUNSTADES,"C",3,0);
      l_cSql = l_cSql+", WUNCODDIP = "+CPLib.ToSQLNull(w_WUNCODDIP,"C",6,0);
      l_cSql = l_cSql+", WUNCITCLI = "+CPLib.ToSQLNull(w_WUNCITCLI,"C",40,0);
      l_cSql = l_cSql+", WUNBSTACLI = "+CPLib.ToSQLNull(w_WUNBSTACLI,"C",40,0);
      l_cSql = l_cSql+", WUNBCITCLI = "+CPLib.ToSQLNull(w_WUNBCITCLI,"C",40,0);
      l_cSql = l_cSql+", WUNOMCLI = "+CPLib.ToSQL(w_WUNOMCLI,"C",40,0);
      l_cSql = l_cSql+", WUCOGCLI = "+CPLib.ToSQL(w_WUCOGCLI,"C",40,0);
      l_cSql = l_cSql+", WUCITCLI = "+CPLib.ToSQL(w_WUCITCLI,"C",40,0);
      l_cSql = l_cSql+", WUCAPCLI = "+CPLib.ToSQL(w_WUCAPCLI,"C",5,0);
      l_cSql = l_cSql+", WUINDCLI = "+CPLib.ToSQL(w_WUINDCLI,"C",60,0);
      l_cSql = l_cSql+", WUNOMCON = "+CPLib.ToSQL(w_WUNOMCON,"C",40,0);
      l_cSql = l_cSql+", WUCOGCON = "+CPLib.ToSQL(w_WUCOGCON,"C",40,0);
      l_cSql = l_cSql+", WUBCITCLI = "+CPLib.ToSQL(w_WUBCITCLI,"C",40,0);
      l_cSql = l_cSql+", WUDATNAS = "+CPLib.ToSQL(w_WUDATNAS,"C",10,0);
      l_cSql = l_cSql+", WUCODFIS = "+CPLib.ToSQL(w_WUCODFIS,"C",16,0);
      l_cSql = l_cSql+", WUNDOCCLI = "+CPLib.ToSQL(w_WUNDOCCLI,"C",25,0);
      l_cSql = l_cSql+", WUADOCRIL = "+CPLib.ToSQL(w_WUADOCRIL,"C",30,0);
      l_cSql = l_cSql+", WURDOCCLI = "+CPLib.ToSQL(w_WURDOCCLI,"D",8,0);
      l_cSql = l_cSql+", WUSDOCCLI = "+CPLib.ToSQL(w_WUSDOCCLI,"D",8,0);
      l_cSql = l_cSql+", WUSEXCLI = "+CPLib.ToSQL(w_WUSEXCLI,"C",1,0);
      l_cSql = l_cSql+", WUTDOCCLI = "+CPLib.ToSQL(w_WUTDOCCLI,"C",2,0);
      l_cSql = l_cSql+", WUFLGALL = "+CPLib.ToSQL(w_WUFLGALL,"C",1,0);
      l_cSql = l_cSql+", WUNCODFIS = "+CPLib.ToSQL(w_WUNCODFIS,"C",16,0);
      l_cSql = l_cSql+", WUCODMAGE = "+CPLib.ToSQLNull(w_WUCODMAGE,"C",5,0);
      l_cSql = l_cSql+", WUNOTE = "+CPLib.ToSQL(w_WUNOTE,"M",10,0,m_cServer_wuchkimp_sf,m_oParameters);
      l_cSql = l_cSql+", WUFLGFRC = "+CPLib.ToSQL(w_WUFLGFRC,"C",1,0);
      l_cSql = l_cSql+", WUORIGCF = "+CPLib.ToSQL(w_WUORIGCF,"C",16,0);
      l_cSql = l_cSql+", WUSTACLI = "+CPLib.ToSQL(w_WUSTACLI,"C",40,0);
      l_cSql = l_cSql+", WUNSTACLI = "+CPLib.ToSQLNull(w_WUNSTACLI,"C",50,0);
      l_cSql = l_cSql+", WUCONTANTI = "+CPLib.ToSQL(w_WUCONTANTI,"N",10,2);
      l_cSql = l_cSql+", WUOPETYPE = "+CPLib.ToSQL(w_WUOPETYPE,"C",1,0);
      l_cSql = l_cSql+", WUCODCLC = "+CPLib.ToSQL(w_WUCODCLC,"N",1,0);
      l_cSql = l_cSql+", WUNSEXCLI = "+CPLib.ToSQL(w_WUNSEXCLI,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuchkimp_sf")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"N",10,0),m_cServer_wuchkimp_sf,w_WUCODICE);
      l_cSql = l_cSql+m_oWrInfo_wuchkimp_sf.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuchkimp_sf")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_wuchkimp_sf,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_WUCODICE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_WUCODICE);
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
          l_cSql = "Delete from "+m_oWrInfo_wuchkimp_sf.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"WUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_WUCODICE,"N",10,0),m_cServer_wuchkimp_sf,w_WUCODICE);
          l_cSql = l_cSql+m_oWrInfo_wuchkimp_sf.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"wuchkimp_sf")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_wuchkimp_sf,l_cSql);
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
    return Delete(w_WUCODICE);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"RPXEDSQTUE")) {
      result.m_TableName = "anadip";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RPXEDSQTUE",CPLib.GetLinkedFieldProps("CODDIP","WUNCODDIP","C",6,0));
    } else if (CPLib.eq(p_cID,"AZSYSFMRUL")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_citta";
      result.m_rdField = new String[]{"CITTA" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AZSYSFMRUL",CPLib.GetLinkedFieldProps("CITTA","WUNCITCLI","C",40,0));
    } else if (CPLib.eq(p_cID,"GPWUEBYSIT")) {
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
      result.AppendFieldsHash("GPWUEBYSIT",CPLib.GetLinkedFieldProps("DESCRI","WUNBSTACLI","C",40,0));
    } else if (CPLib.eq(p_cID,"SQSTTNXNEF")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SQSTTNXNEF",CPLib.GetLinkedFieldProps("CITTA","WUNBCITCLI","C",40,0));
    } else if (CPLib.eq(p_cID,"FHWIGGJJLC")) {
      result.m_TableName = "tbmacage";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_tbmacage";
      result.m_rdField = new String[]{"MACODICE" , "MADESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("FHWIGGJJLC",CPLib.GetLinkedFieldProps("MACODICE","WUCODMAGE","C",5,0));
    } else if (CPLib.eq(p_cID,"HHRNUENTOX")) {
      result.m_TableName = "anadip";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_anadip";
      result.m_rdField = new String[]{"CODDIP" , "DESCCIT"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HHRNUENTOX",CPLib.GetLinkedFieldProps("CODDIP","WUCODDIP","C",6,0));
    } else if (CPLib.eq(p_cID,"WVLDFVKALY")) {
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
      result.AppendFieldsHash("WVLDFVKALY",CPLib.GetLinkedFieldProps("DESCRI","WUNSTACLI","C",50,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arrt_start_wusf_ok,
  public static final String i_InvokedRoutines = ",arrt_start_wusf_ok,";
}
