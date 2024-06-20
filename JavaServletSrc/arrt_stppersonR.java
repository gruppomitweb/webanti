// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stppersonR implements CallerWithObjs {
  // gestori associati a particolari eventi ('Routine start')
  public static volatile java.util.Map<String,java.util.List<com.zucchetti.sitepainter.EventHandler>> specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile java.util.List<com.zucchetti.sitepainter.EventHandler> allEventsHandlers;
  // indica se si sta gestendo un evento scatenato da questa routine per restituire il valore corretto di i_EntityName ed i_EntityType
  static boolean m_bEventRunning;
  public String m_cLastMsgError;
  public boolean m_bError;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabile di caller (variabili di caller): passata nel costruttore
  public CallerWithObjs m_Caller;
  public String m_cPhName_tmp_stovaria;
  public String m_cServer_tmp_stovaria;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tmp_pers82;
  public String m_cServer_tmp_pers82;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  String m_cServer;
  String m_cPhName;
  CPPhTableWrInfo m_oWrInfo;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public java.sql.Date w_daData;
  public java.sql.Date w_aData;
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_tipstp;
  public String w_ChkSoloVar;
  public String w_elenco;
  public String w_stpatt;
  public String w_chktit;
  public String w_chknotit;
  public String gDescAzi;
  public String gMsgImp;
  public double _attivo;
  public String _txterr;
  public String _txterr2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stppersonR (CPContext p_ContextObject, Caller caller) {
    if (caller == null)
      m_Caller = CallerWithObjsImpl.EMPTY;
    else if (caller instanceof CallerWithObjs)
      m_Caller = (CallerWithObjs)caller;
    else
      m_Caller = new CallerWithObjsImpl(caller);
    m_Ctx=p_ContextObject;
    // Assegnazione della variabile di collegamento con il database
    m_Sql=m_Ctx.GetSql();
    /*  Impostazione dell'ambiente globale: il businness object si collega
                                all'oggetto globale (unico per più istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda è contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_stpperson",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stovaria")) {
      m_cPhName_tmp_stovaria = p_ContextObject.GetPhName("tmp_stovaria");
      if (m_cPhName_tmp_stovaria.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stovaria = m_cPhName_tmp_stovaria+" "+m_Ctx.GetWritePhName("tmp_stovaria");
      }
      m_cServer_tmp_stovaria = p_ContextObject.GetServer("tmp_stovaria");
    }
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_pers82")) {
      m_cPhName_tmp_pers82 = p_ContextObject.GetPhName("tmp_pers82");
      if (m_cPhName_tmp_pers82.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_pers82 = m_cPhName_tmp_pers82+" "+m_Ctx.GetWritePhName("tmp_pers82");
      }
      m_cServer_tmp_pers82 = p_ContextObject.GetServer("tmp_pers82");
    }
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_attivo",p_cVarName)) {
      return _attivo;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stpperson";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("tipstp",p_cVarName)) {
      return w_tipstp;
    }
    if (CPLib.eqr("ChkSoloVar",p_cVarName)) {
      return w_ChkSoloVar;
    }
    if (CPLib.eqr("elenco",p_cVarName)) {
      return w_elenco;
    }
    if (CPLib.eqr("stpatt",p_cVarName)) {
      return w_stpatt;
    }
    if (CPLib.eqr("chktit",p_cVarName)) {
      return w_chktit;
    }
    if (CPLib.eqr("chknotit",p_cVarName)) {
      return w_chknotit;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("_txterr",p_cVarName)) {
      return _txterr;
    }
    if (CPLib.eqr("_txterr2",p_cVarName)) {
      return _txterr2;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("daData",p_cVarName)) {
      return w_daData;
    }
    if (CPLib.eqr("aData",p_cVarName)) {
      return w_aData;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_attivo",p_cVarName)) {
      _attivo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("tipstp",p_cVarName)) {
      w_tipstp = value;
      return;
    }
    if (CPLib.eqr("ChkSoloVar",p_cVarName)) {
      w_ChkSoloVar = value;
      return;
    }
    if (CPLib.eqr("elenco",p_cVarName)) {
      w_elenco = value;
      return;
    }
    if (CPLib.eqr("stpatt",p_cVarName)) {
      w_stpatt = value;
      return;
    }
    if (CPLib.eqr("chktit",p_cVarName)) {
      w_chktit = value;
      return;
    }
    if (CPLib.eqr("chknotit",p_cVarName)) {
      w_chknotit = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("_txterr",p_cVarName)) {
      _txterr = value;
      return;
    }
    if (CPLib.eqr("_txterr2",p_cVarName)) {
      _txterr2 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("daData",p_cVarName)) {
      w_daData = value;
      return;
    }
    if (CPLib.eqr("aData",p_cVarName)) {
      w_aData = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_intestit=null;
    try {
      /* w_daData Date */
      /* w_aData Date */
      /* w_daCodCli Char(16) */
      /* w_aCodCli Char(16) */
      /* w_tipstp Char(1) // Stampa Storico Variazioni */
      /* w_ChkSoloVar Char(1) // Solo soggetti con Variazioni */
      /* w_elenco Char(1) // Stampa Elenco */
      /* w_stpatt Char(1) // Solo soggetti attivi */
      /* w_chktit Char(1) // Stampa legami tra soggetti (Titolare effettivo/Fiduciante) */
      /* w_chknotit Char(1) // Stampa le persone giuridiche che non presentano nessuna informazione di titolare effettivo */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      // * --- Drop temporary table tmp_pers82
      if (m_Ctx.IsSharedTemp("tmp_pers82")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_pers82")) {
          m_cServer = m_Ctx.GetServer("tmp_pers82");
          m_cPhName = m_Ctx.GetPhName("tmp_pers82");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_pers82");
      }
      // * --- Create temporary table tmp_pers82
      if (m_Ctx.IsSharedTemp("tmp_pers82")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_pers82")) {
          m_cServer = m_Ctx.GetServer("tmp_pers82");
          m_cPhName = m_Ctx.GetPhName("tmp_pers82");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_pers82");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_pers82");
      if ( ! (m_Ctx.IsSharedTemp("tmp_pers82"))) {
        m_cServer = m_Ctx.GetServer("tmp_pers82");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_pers82",m_cServer,"proto")),m_cPhName,"tmp_pers82",m_Ctx);
      }
      m_cPhName_tmp_pers82 = m_cPhName;
      /* _attivo Numeric(1, 0) */
      /* _txterr Memo */
      /* _txterr2 Memo */
      /* Lancio la stampa */
      /* If w_elenco = 'S' */
      if (CPLib.eqr(w_elenco,"S")) {
        /* Stop arrp_stpperson_elenco.vrp */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("daCodCli",w_daCodCli);
        f.SetParameter("aCodCli",w_aCodCli);
        f.SetParameter("descazi",gDescAzi);
        f.SetParameter("ReportName","arrp_stpperson_elenco.vrp");
        f.SetParameter("m_cParameterSequence","daCodCli"+","+"aCodCli"+","+"descazi"+","+"ReportName");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* If w_stpatt='S' */
        if (CPLib.eqr(w_stpatt,"S")) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* gMsgImp := 'Esamino il soggetto con codice: '+LRTrim(personbo->CONNES) // Messaggio Import */
            gMsgImp = "Esamino il soggetto con codice: "+CPLib.LRTrim(Cursor_personbo.GetString("CONNES"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If (Empty(w_daCodCli) or personbo->CONNES>=w_daCodCli) and (Empty(w_aCodCli) or personbo->CONNES<=w_aCodCli) */
            if ((CPLib.Empty(w_daCodCli) || CPLib.ge(Cursor_personbo.GetString("CONNES"),w_daCodCli)) && (CPLib.Empty(w_aCodCli) || CPLib.le(Cursor_personbo.GetString("CONNES"),w_aCodCli))) {
              /* _attivo := 0 */
              _attivo = CPLib.Round(0,0);
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+"  and  (STATOREG<>'2'  and  STATOREG<>'3') "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If Empty(intestbo->DATAFINE) */
                if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
                  /* _attivo := 1 */
                  _attivo = CPLib.Round(1,0);
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If _attivo=0 */
              if (CPLib.eqr(_attivo,0)) {
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+"  and  (STATOREG<>'2'  and  STATOREG<>'3') "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* If  Empty(delegabo->DATAFINE) */
                  if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE"))) {
                    /* _attivo := 1 */
                    _attivo = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } // End If
              /* If _attivo=0 */
              if (CPLib.eqr(_attivo,0)) {
                // * --- Select from intestit
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                if (Cursor_intestit!=null)
                  Cursor_intestit.Close();
                Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+"  and  (STATOREG<>'2'  and  STATOREG<>'3') "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestit.Eof())) {
                  /* If Empty(intestit->DATAFINE) */
                  if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) {
                    /* _attivo := 1 */
                    _attivo = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                  Cursor_intestit.Next();
                }
                m_cConnectivityError = Cursor_intestit.ErrorMessage();
                Cursor_intestit.Close();
                // * --- End Select
              } // End If
              /* If _attivo=1 */
              if (CPLib.eqr(_attivo,1)) {
                // * --- Insert into tmp_pers82 from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_pers82");
                m_cPhName = m_Ctx.GetPhName("tmp_pers82");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_pers82",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpperson",59,"0000002D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000002D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_pers82",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } // End If
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* gMsgImp := 'Esame completato' // Messaggio Import */
          gMsgImp = "Esame completato";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If w_tipstp = 'S' */
        if (CPLib.eqr(w_tipstp,"S")) {
          /* Exec "Crea file per stampa variazioni" Page 2:Page_2 */
          Page_2();
          /* Stop arrp_stppersonsto.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("daData",w_daData);
          f.SetParameter("aData",w_aData);
          f.SetParameter("daCodCli",w_daCodCli);
          f.SetParameter("aCodCli",w_aCodCli);
          f.SetParameter("descazi",gDescAzi);
          f.SetParameter("ChkSoloVar",w_ChkSoloVar);
          f.SetParameter("stpatt",w_stpatt);
          f.SetParameter("chktit",w_chktit);
          f.SetParameter("chknotit",w_chknotit);
          f.SetParameter("OrderBy","RAGSOC asc");
          f.SetParameter("showParameterMask",false);
          f.SetParameter("ReportName","arrp_stppersonsto.vrp");
          f.SetParameter("m_cParameterSequence","daData"+","+"aData"+","+"daCodCli"+","+"aCodCli"+","+"descazi"+","+"ChkSoloVar"+","+"stpatt"+","+"chktit"+","+"chknotit"+","+"OrderBy"+","+"showParameterMask"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          /* Stop arrp_stpperson.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("daCodCli",w_daCodCli);
          f.SetParameter("aCodCli",w_aCodCli);
          f.SetParameter("descazi",gDescAzi);
          f.SetParameter("chktit",w_chktit);
          f.SetParameter("chknotit",w_chknotit);
          f.SetParameter("stpatt",w_stpatt);
          f.SetParameter("OrderBy","RAGSOC asc");
          f.SetParameter("showParameterMask",false);
          f.SetParameter("ReportName","arrp_stpperson.vrp");
          f.SetParameter("m_cParameterSequence","daCodCli"+","+"aCodCli"+","+"descazi"+","+"chktit"+","+"chknotit"+","+"stpatt"+","+"OrderBy"+","+"showParameterMask"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_stppersonbo1=null;
    CPResultSet Cursor_wersonbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file d'appoggio */
      // * --- Drop temporary table tmp_stovaria
      if (m_Ctx.IsSharedTemp("tmp_stovaria")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stovaria")) {
          m_cServer = m_Ctx.GetServer("tmp_stovaria");
          m_cPhName = m_Ctx.GetPhName("tmp_stovaria");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stovaria");
      }
      // * --- Create temporary table tmp_stovaria
      if (m_Ctx.IsSharedTemp("tmp_stovaria")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stovaria")) {
          m_cServer = m_Ctx.GetServer("tmp_stovaria");
          m_cPhName = m_Ctx.GetPhName("tmp_stovaria");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stovaria");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stovaria");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stovaria"))) {
        m_cServer = m_Ctx.GetServer("tmp_stovaria");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stovaria",m_cServer,"proto")),m_cPhName,"tmp_stovaria",m_Ctx,new String[]{"CONNES,NUMVARIA","CONNES","NUMVARIA","DATVARIA"});
      }
      m_cPhName_tmp_stovaria = m_cPhName;
      // * --- Select from qbe_stppersonbo1
      SPBridge.HMCaller _h00000036;
      _h00000036 = new SPBridge.HMCaller();
      _h00000036.Set("m_cVQRList",m_cVQRList);
      _h00000036.Set("daCodCli",w_daCodCli);
      _h00000036.Set("aCodCli",w_aCodCli);
      _h00000036.Set("chktit",w_chktit);
      _h00000036.Set("chktit",w_chktit);
      _h00000036.Set("chknotit",w_chknotit);
      _h00000036.Set("stpatt",w_stpatt);
      _h00000036.Set("OrderBy","CONNES asc");
      if (Cursor_qbe_stppersonbo1!=null)
        Cursor_qbe_stppersonbo1.Close();
      Cursor_qbe_stppersonbo1 = new VQRHolder("qbe_stppersonbo1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000036,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_stppersonbo1.Eof())) {
        /* _txterr2 := '' */
        _txterr2 = "";
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_stppersonbo1.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"datamodi desc ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* _txterr := '' */
          _txterr = "";
          /* If wersonbo->AUTRILASC <> qbe_stppersonbo1->AUTRILASC */
          if (CPLib.ne(Cursor_wersonbo.GetString("AUTRILASC"),Cursor_qbe_stppersonbo1.GetString("AUTRILASC"))) {
            /* _txterr := _txterr + '+ Autorità Rilascio: '+wersonbo->AUTRILASC + NL */
            _txterr = _txterr+"+ Autorità Rilascio: "+Cursor_wersonbo.GetString("AUTRILASC")+"\n";
          } // End If
          /* If wersonbo->CAP <> qbe_stppersonbo1->CAP */
          if (CPLib.ne(Cursor_wersonbo.GetString("CAP"),Cursor_qbe_stppersonbo1.GetString("CAP"))) {
            /* _txterr := _txterr + '+ CAP Residenza: '+wersonbo->CAP + NL */
            _txterr = _txterr+"+ CAP Residenza: "+Cursor_wersonbo.GetString("CAP")+"\n";
          } // End If
          /* If wersonbo->CODCAB <> qbe_stppersonbo1->CODCAB */
          if (CPLib.ne(Cursor_wersonbo.GetString("CODCAB"),Cursor_qbe_stppersonbo1.GetString("CODCAB"))) {
            /* _txterr := _txterr + '+ CAB Residenza: '+wersonbo->CODCAB + NL */
            _txterr = _txterr+"+ CAB Residenza: "+Cursor_wersonbo.GetString("CODCAB")+"\n";
          } // End If
          /* If wersonbo->CODFISC <> qbe_stppersonbo1->CODFISC */
          if (CPLib.ne(Cursor_wersonbo.GetString("CODFISC"),Cursor_qbe_stppersonbo1.GetString("CODFISC"))) {
            /* _txterr := _txterr + '+Codice Fiscale: '+wersonbo->CODFISC + NL */
            _txterr = _txterr+"+Codice Fiscale: "+Cursor_wersonbo.GetString("CODFISC")+"\n";
          } // End If
          /* If wersonbo->COGNOME <> qbe_stppersonbo1->COGNOME */
          if (CPLib.ne(Cursor_wersonbo.GetString("COGNOME"),Cursor_qbe_stppersonbo1.GetString("COGNOME"))) {
            /* _txterr := _txterr + '+Cognome: '+wersonbo->COGNOME + NL */
            _txterr = _txterr+"+Cognome: "+Cursor_wersonbo.GetString("COGNOME")+"\n";
          } // End If
          /* If wersonbo->DATANASC <> qbe_stppersonbo1->DATANASC */
          if (CPLib.ne(Cursor_wersonbo.GetDate("DATANASC"),Cursor_qbe_stppersonbo1.GetDate("DATANASC"))) {
            /* _txterr := _txterr + '+Data di Nascita: '+arfn_fdate(wersonbo->DATANASC) + NL */
            _txterr = _txterr+"+Data di Nascita: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetDate("DATANASC"))+"\n";
          } // End If
          /* If wersonbo->DATARILASC <> qbe_stppersonbo1->DATARILASC */
          if (CPLib.ne(Cursor_wersonbo.GetDate("DATARILASC"),Cursor_qbe_stppersonbo1.GetDate("DATARILASC"))) {
            /* _txterr := _txterr + '+Data Rilascio Documento: '+arfn_fdate(wersonbo->DATARILASC) + NL */
            _txterr = _txterr+"+Data Rilascio Documento: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetDate("DATARILASC"))+"\n";
          } // End If
          /* If wersonbo->DATAVALI <> qbe_stppersonbo1->DATAVALI */
          if (CPLib.ne(Cursor_wersonbo.GetDate("DATAVALI"),Cursor_qbe_stppersonbo1.GetDate("DATAVALI"))) {
            /* _txterr := _txterr + '+Data Scadenza Documento: '+arfn_fdate(wersonbo->DATAVALI) + NL */
            _txterr = _txterr+"+Data Scadenza Documento: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetDate("DATAVALI"))+"\n";
          } // End If
          /* If wersonbo->DESCCIT <> qbe_stppersonbo1->DESCCIT */
          if (CPLib.ne(Cursor_wersonbo.GetString("DESCCIT"),Cursor_qbe_stppersonbo1.GetString("DESCCIT"))) {
            /* _txterr := _txterr + '+Città Residenza: '+wersonbo->DESCCIT + NL */
            _txterr = _txterr+"+Città Residenza: "+Cursor_wersonbo.GetString("DESCCIT")+"\n";
          } // End If
          /* If wersonbo->DOMICILIO <> qbe_stppersonbo1->DOMICILIO */
          if (CPLib.ne(Cursor_wersonbo.GetString("DOMICILIO"),Cursor_qbe_stppersonbo1.GetString("DOMICILIO"))) {
            /* _txterr := _txterr + '+Indirizzo Residenza: '+wersonbo->DOMICILIO + NL */
            _txterr = _txterr+"+Indirizzo Residenza: "+Cursor_wersonbo.GetString("DOMICILIO")+"\n";
          } // End If
          /* If wersonbo->NASCOMUN <> qbe_stppersonbo1->NASCOMUN */
          if (CPLib.ne(Cursor_wersonbo.GetString("NASCOMUN"),Cursor_qbe_stppersonbo1.GetString("NASCOMUN"))) {
            /* _txterr := _txterr + '+Comune di Nascita: '+wersonbo->NASCOMUN + NL */
            _txterr = _txterr+"+Comune di Nascita: "+Cursor_wersonbo.GetString("NASCOMUN")+"\n";
          } // End If
          /* If wersonbo->NASSTATO <> qbe_stppersonbo1->NASSTATO */
          if (CPLib.ne(Cursor_wersonbo.GetString("NASSTATO"),Cursor_qbe_stppersonbo1.GetString("NASSTATO"))) {
            /* _txterr := _txterr + '+Stato di Nascita: '+wersonbo->NASSTATO + NL */
            _txterr = _txterr+"+Stato di Nascita: "+Cursor_wersonbo.GetString("NASSTATO")+"\n";
          } // End If
          /* If wersonbo->NOME <> qbe_stppersonbo1->NOME */
          if (CPLib.ne(Cursor_wersonbo.GetString("NOME"),Cursor_qbe_stppersonbo1.GetString("NOME"))) {
            /* _txterr := _txterr + '+Nome: '+wersonbo->NOME + NL */
            _txterr = _txterr+"+Nome: "+Cursor_wersonbo.GetString("NOME")+"\n";
          } // End If
          /* If wersonbo->NUMDOCUM <> qbe_stppersonbo1->NUMDOCUM */
          if (CPLib.ne(Cursor_wersonbo.GetString("NUMDOCUM"),Cursor_qbe_stppersonbo1.GetString("NUMDOCUM"))) {
            /* _txterr := _txterr + '+Numero Documento: '+wersonbo->NUMDOCUM + NL */
            _txterr = _txterr+"+Numero Documento: "+Cursor_wersonbo.GetString("NUMDOCUM")+"\n";
          } // End If
          /* If wersonbo->PAESE <> qbe_stppersonbo1->PAESE */
          if (CPLib.ne(Cursor_wersonbo.GetString("PAESE"),Cursor_qbe_stppersonbo1.GetString("PAESE"))) {
            /* _txterr := _txterr + '+Stato Residenza: '+wersonbo->PAESE + NL */
            _txterr = _txterr+"+Stato Residenza: "+Cursor_wersonbo.GetString("PAESE")+"\n";
          } // End If
          /* If wersonbo->PARTIVA <> qbe_stppersonbo1->PARTIVA */
          if (CPLib.ne(Cursor_wersonbo.GetString("PARTIVA"),Cursor_qbe_stppersonbo1.GetString("PARTIVA"))) {
            /* _txterr := _txterr + '+Partita IVA: '+wersonbo->PARTIVA + NL */
            _txterr = _txterr+"+Partita IVA: "+Cursor_wersonbo.GetString("PARTIVA")+"\n";
          } // End If
          /* If wersonbo->PROVINCIA <> qbe_stppersonbo1->PROVINCIA */
          if (CPLib.ne(Cursor_wersonbo.GetString("PROVINCIA"),Cursor_qbe_stppersonbo1.GetString("PROVINCIA"))) {
            /* _txterr := _txterr + '+Provincia Residenza: '+wersonbo->PROVINCIA + NL */
            _txterr = _txterr+"+Provincia Residenza: "+Cursor_wersonbo.GetString("PROVINCIA")+"\n";
          } // End If
          /* If wersonbo->RAGSOC <> qbe_stppersonbo1->RAGSOC */
          if (CPLib.ne(Cursor_wersonbo.GetString("RAGSOC"),Cursor_qbe_stppersonbo1.GetString("RAGSOC"))) {
            /* _txterr := _txterr + '+Ragione Sociale: '+wersonbo->RAGSOC + NL */
            _txterr = _txterr+"+Ragione Sociale: "+Cursor_wersonbo.GetString("RAGSOC")+"\n";
          } // End If
          /* If wersonbo->RAMOGRUP <> qbe_stppersonbo1->RAMOGRUP */
          if (CPLib.ne(Cursor_wersonbo.GetString("RAMOGRUP"),Cursor_qbe_stppersonbo1.GetString("RAMOGRUP"))) {
            /* _txterr := _txterr + '+Ramo Attività Economica: '+wersonbo->RAMOGRUP + NL */
            _txterr = _txterr+"+Ramo Attività Economica: "+Cursor_wersonbo.GetString("RAMOGRUP")+"\n";
          } // End If
          /* If wersonbo->SESSO <> qbe_stppersonbo1->SESSO */
          if (CPLib.ne(Cursor_wersonbo.GetString("SESSO"),Cursor_qbe_stppersonbo1.GetString("SESSO"))) {
            /* _txterr := _txterr + '+Sesso: '+wersonbo->SESSO + NL */
            _txterr = _txterr+"+Sesso: "+Cursor_wersonbo.GetString("SESSO")+"\n";
          } // End If
          /* If wersonbo->SETTSINT <> qbe_stppersonbo1->SETTSINT */
          if (CPLib.ne(Cursor_wersonbo.GetString("SETTSINT"),Cursor_qbe_stppersonbo1.GetString("SETTSINT"))) {
            /* _txterr := _txterr + '+Settore Sintetico: '+wersonbo->SETTSINT + NL */
            _txterr = _txterr+"+Settore Sintetico: "+Cursor_wersonbo.GetString("SETTSINT")+"\n";
          } // End If
          /* If wersonbo->SOTGRUP <> qbe_stppersonbo1->SOTGRUP */
          if (CPLib.ne(Cursor_wersonbo.GetString("SOTGRUP"),Cursor_qbe_stppersonbo1.GetString("SOTGRUP"))) {
            /* _txterr := _txterr + '+Sottogruppo Attività Economica: '+wersonbo->SOTGRUP + NL */
            _txterr = _txterr+"+Sottogruppo Attività Economica: "+Cursor_wersonbo.GetString("SOTGRUP")+"\n";
          } // End If
          /* If wersonbo->TIPINTER <> qbe_stppersonbo1->TIPINTER */
          if (CPLib.ne(Cursor_wersonbo.GetString("TIPINTER"),Cursor_qbe_stppersonbo1.GetString("TIPINTER"))) {
            /* _txterr := _txterr + '+Provincia di Nascita: '+wersonbo->TIPINTER + NL */
            _txterr = _txterr+"+Provincia di Nascita: "+Cursor_wersonbo.GetString("TIPINTER")+"\n";
          } // End If
          /* If wersonbo->TIPODOC <> qbe_stppersonbo1->TIPODOC */
          if (CPLib.ne(Cursor_wersonbo.GetString("TIPODOC"),Cursor_qbe_stppersonbo1.GetString("TIPODOC"))) {
            /* _txterr := _txterr + '+Tipo Documento: '+wersonbo->TIPODOC + NL */
            _txterr = _txterr+"+Tipo Documento: "+Cursor_wersonbo.GetString("TIPODOC")+"\n";
          } // End If
          /* If wersonbo->PEP <> qbe_stppersonbo1->PEP */
          if (CPLib.ne(Cursor_wersonbo.GetString("PEP"),Cursor_qbe_stppersonbo1.GetString("PEP"))) {
            /* _txterr := _txterr + '+Pers. Esposta Politicamente: '+wersonbo->PEP + NL */
            _txterr = _txterr+"+Pers. Esposta Politicamente: "+Cursor_wersonbo.GetString("PEP")+"\n";
          } // End If
          /* If _txterr=_txterr2 */
          if (CPLib.eqr(_txterr,_txterr2)) {
            /* _txterr2 := _txterr */
            _txterr2 = _txterr;
            /* _txterr := '' */
            _txterr = "";
          } // End If
          /* If Len(LRTrim(_txterr)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_txterr)),0)) {
            // * --- Insert into tmp_stovaria from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stovaria");
            m_cPhName = m_Ctx.GetPhName("tmp_stovaria");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stovaria",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpperson",59,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetString("sanumpro"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wersonbo.GetDate("datamodi"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stovaria",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* _txterr2 := _txterr */
            _txterr2 = _txterr;
          } // End If
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
        Cursor_qbe_stppersonbo1.Next();
      }
      m_cConnectivityError = Cursor_qbe_stppersonbo1.ErrorMessage();
      Cursor_qbe_stppersonbo1.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_stppersonbo1!=null)
          Cursor_qbe_stppersonbo1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_daData,java.sql.Date p_w_aData,String p_w_daCodCli,String p_w_aCodCli,String p_w_tipstp,String p_w_ChkSoloVar,String p_w_elenco,String p_w_stpatt,String p_w_chktit,String p_w_chknotit) {
    w_daData = p_w_daData;
    w_aData = p_w_aData;
    w_daCodCli = p_w_daCodCli;
    w_aCodCli = p_w_aCodCli;
    w_tipstp = p_w_tipstp;
    w_ChkSoloVar = p_w_ChkSoloVar;
    w_elenco = p_w_elenco;
    w_stpatt = p_w_stpatt;
    w_chktit = p_w_chktit;
    w_chknotit = p_w_chknotit;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=Run();
        } finally {
          //evito di tenere nell'heap della virtual machine riferimenti non piu' usati
          m_Caller = null;
          m_Sql = null;
          m_Ctx = null;
        }
      }
    }
    );
  }
  public Forward Run(java.sql.Date p_w_daData,java.sql.Date p_w_aData,String p_w_daCodCli,String p_w_aCodCli,String p_w_tipstp,String p_w_ChkSoloVar,String p_w_elenco,String p_w_stpatt,String p_w_chktit,String p_w_chknotit) {
    w_daData = p_w_daData;
    w_aData = p_w_aData;
    w_daCodCli = p_w_daCodCli;
    w_aCodCli = p_w_aCodCli;
    w_tipstp = p_w_tipstp;
    w_ChkSoloVar = p_w_ChkSoloVar;
    w_elenco = p_w_elenco;
    w_stpatt = p_w_stpatt;
    w_chktit = p_w_chktit;
    w_chknotit = p_w_chknotit;
    return Run();
  }
  public Forward Run() {
    Forward f;
    f = Forward.Unforwarded;
    m_Ctx = m_Ctx.DisabledDataFilteringVersion();
    try {
      try {
        try {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent("Run start",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
          Page_1();
        } finally {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent(com.zucchetti.sitepainter.EventHandler.RUN_END,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        }
      } catch(Forward forward) {
        f=forward;
      } catch(Stop stop_value) {
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        CPStdCounter.Error(fault);
        CallerExImpl l_oTraceSink;
        l_oTraceSink = new CallerExImpl(m_Caller,"");
        if (l_oTraceSink.HasWorkingVar("m_cFaultTrace")) {
          if ( ! (CPLib.IsAdministrator(m_Ctx)) && m_Ctx.HasAdministeredUsers()) {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,"MSG_ADMIN_REQUIRED");
          } else {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,CPLib.DumpException(fault));
          }
        }
      }
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stppersonR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stppersonR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daData = CPLib.NullDate();
    w_aData = CPLib.NullDate();
    w_daCodCli = CPLib.Space(16);
    w_aCodCli = CPLib.Space(16);
    w_tipstp = CPLib.Space(1);
    w_ChkSoloVar = CPLib.Space(1);
    w_elenco = CPLib.Space(1);
    w_stpatt = CPLib.Space(1);
    w_chktit = CPLib.Space(1);
    w_chknotit = CPLib.Space(1);
    _attivo = 0;
    _txterr = "";
    _txterr2 = "";
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_stppersonbo1,
  public static final String m_cVQRList = ",qbe_stppersonbo1,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"w_daData","w_aData","w_daCodCli","w_aCodCli","w_tipstp","w_ChkSoloVar","w_elenco","w_stpatt","w_chktit","w_chknotit"};
  protected static String GetFieldsName_0000002D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_pers82",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"NUMVARIA,";
    p_cSql = p_cSql+"DATVARIA,";
    p_cSql = p_cSql+"ELEVARIA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stovaria",true);
    return p_cSql;
  }
}
