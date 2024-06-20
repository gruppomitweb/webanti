// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_saldi_oroR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_saldioro;
  public String m_cServer_saldioro;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
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
  public double w_annoope;
  public String w_CONNES;
  public double w_imppagato;
  public double w_impricevuto;
  public double w_numope;
  public String w_risultato;
  public String _rapporto;
  public double _esiste;
  public double _saldi;
  public String _saldiage;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_saldi_oroR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_saldi_oro",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_saldioro = p_ContextObject.GetPhName("saldioro");
    if (m_cPhName_saldioro.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_saldioro = m_cPhName_saldioro+" "+m_Ctx.GetWritePhName("saldioro");
    }
    m_cServer_saldioro = p_ContextObject.GetServer("saldioro");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("annoope",p_cVarName)) {
      return w_annoope;
    }
    if (CPLib.eqr("imppagato",p_cVarName)) {
      return w_imppagato;
    }
    if (CPLib.eqr("impricevuto",p_cVarName)) {
      return w_impricevuto;
    }
    if (CPLib.eqr("numope",p_cVarName)) {
      return w_numope;
    }
    if (CPLib.eqr("_esiste",p_cVarName)) {
      return _esiste;
    }
    if (CPLib.eqr("_saldi",p_cVarName)) {
      return _saldi;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_saldi_oro";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("risultato",p_cVarName)) {
      return w_risultato;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_saldiage",p_cVarName)) {
      return _saldiage;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("annoope",p_cVarName)) {
      w_annoope = value;
      return;
    }
    if (CPLib.eqr("imppagato",p_cVarName)) {
      w_imppagato = value;
      return;
    }
    if (CPLib.eqr("impricevuto",p_cVarName)) {
      w_impricevuto = value;
      return;
    }
    if (CPLib.eqr("numope",p_cVarName)) {
      w_numope = value;
      return;
    }
    if (CPLib.eqr("_esiste",p_cVarName)) {
      _esiste = value;
      return;
    }
    if (CPLib.eqr("_saldi",p_cVarName)) {
      _saldi = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("risultato",p_cVarName)) {
      w_risultato = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_saldiage",p_cVarName)) {
      _saldiage = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
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
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_saldioro=null;
    CPResultSet Read_Cursor=null;
    try {
      /* w_annoope Numeric(4, 0) // Anno */
      /* w_CONNES Char(16) */
      /* w_imppagato Numeric(15, 0) // Importo Pagato da cliente per acquisto oro */
      /* w_impricevuto Numeric(15, 0) // Importo Consegnato al Cliente per vendita oro */
      /* w_numope Numeric(6, 0) // Numero Operazioni di Acquisto/Vendita */
      /* w_risultato Char(80) */
      /* _rapporto Char(25) */
      /* _esiste Numeric(1, 0) */
      /* _saldi Numeric(1, 0) */
      /* _saldiage Char(2) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Estatus;
      nTry0000000Estatus = m_Sql.GetTransactionStatus();
      String cTry0000000Emsg;
      cTry0000000Emsg = m_Sql.TransactionErrorMessage();
      try {
        /* _esiste := 0 */
        _esiste = CPLib.Round(0,0);
        /* _saldi := 0 */
        _saldi = CPLib.Round(0,0);
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* If Year(jntestbo->DATAINI)=w_annoope */
          if (CPLib.eqr(CPLib.Year(Cursor_jntestbo.GetDate("DATAINI")),w_annoope)) {
            /* _esiste := _esiste + 1 */
            _esiste = CPLib.Round(_esiste+1,0);
            /* _rapporto := jntestbo->RAPPORTO */
            _rapporto = Cursor_jntestbo.GetString("RAPPORTO");
            /* If Empty(jntestbo->DATAFINE) */
            if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) {
              /* _esiste := -1 */
              _esiste = CPLib.Round(-1,0);
            } // End If
          } // End If
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        /* If _esiste=1 */
        if (CPLib.eqr(_esiste,1)) {
          /* _saldi := 0 */
          _saldi = CPLib.Round(0,0);
          // * --- Select from saldioro
          m_cServer = m_Ctx.GetServer("saldioro");
          m_cPhName = m_Ctx.GetPhName("saldioro");
          if (Cursor_saldioro!=null)
            Cursor_saldioro.Close();
          Cursor_saldioro = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FILEANNO,PROG1,IMPORTO3,IMPORTO4,IMPORTO5  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_annoope,4,0),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Str(w_annoope,4,0))+" "+")"+(m_Ctx.IsSharedTemp("saldioro")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_saldioro.Eof())) {
            /* If (saldioro->IMPORTO3+saldioro->IMPORTO4+saldioro->IMPORTO5) > 0 */
            if (CPLib.gt((Cursor_saldioro.GetDouble("IMPORTO3")+Cursor_saldioro.GetDouble("IMPORTO4")+Cursor_saldioro.GetDouble("IMPORTO5")),0)) {
              /* _saldi := 1 */
              _saldi = CPLib.Round(1,0);
              /* w_risultato := "Esistono già i saldi per l'anno considerato" // Risultato */
              w_risultato = "Esistono già i saldi per l'anno considerato";
            } // End If
            /* If _saldi=0 and (not(Empty(saldioro->FILEANNO)) or not(Empty(saldioro->PROG1))) */
            if (CPLib.eqr(_saldi,0) && ( ! (CPLib.Empty(Cursor_saldioro.GetString("FILEANNO"))) ||  ! (CPLib.Empty(Cursor_saldioro.GetString("PROG1"))))) {
              /* _saldi := 1 */
              _saldi = CPLib.Round(1,0);
              /* w_risultato := "ATTENZIONE i saldi dell'anno in questione risultano già inviarti!" // Risultato */
              w_risultato = "ATTENZIONE i saldi dell'anno in questione risultano già inviarti!";
            } // End If
            Cursor_saldioro.Next();
          }
          m_cConnectivityError = Cursor_saldioro.ErrorMessage();
          Cursor_saldioro.Close();
          // * --- End Select
          /* If _saldi=0 */
          if (CPLib.eqr(_saldi,0)) {
            // * --- Insert into saldioro from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("saldioro");
            m_cPhName = m_Ctx.GetPhName("saldioro");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"saldioro",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_saldi_oro",23,"00000021")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000021(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_annoope,4,0),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_imppagato,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_impricevuto,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_numope,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"saldioro",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            /* _saldiage := '' */
            _saldiage = "";
            // * --- Read from aetesta
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(_rapporto,25),"C",25,0,m_cServer),m_cServer,CPLib.Left(_rapporto,25));
            if (m_Ctx.IsSharedTemp("aetesta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _saldiage = Read_Cursor.GetString("TIPOAG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aetesta into routine arrt_saldi_oro returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _saldiage = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_saldiage))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_saldiage)))) {
              // * --- Insert into aeannora from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeannora");
              m_cPhName = m_Ctx.GetPhName("aeannora");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_saldi_oro",23,"00000025")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000025(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_annoope,4,0),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_imppagato,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_impricevuto,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_numope,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeannora",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
            /* w_risultato := "Creato il record dei saldi per il rapporto:"+LRTrim(_rapporto)+" per l'anno "+Str(w_annoope,4,0) // Risultato */
            w_risultato = "Creato il record dei saldi per il rapporto:"+CPLib.LRTrim(_rapporto)+" per l'anno "+CPLib.Str(w_annoope,4,0);
          } // End If
          /* ElseIf _esiste=0 */
        } else if (CPLib.eqr(_esiste,0)) {
          /* w_risultato := "Non esiste un rapporto per l'anno considerato per l'inserimento dei saldi !" // Risultato */
          w_risultato = "Non esiste un rapporto per l'anno considerato per l'inserimento dei saldi !";
          /* ElseIf _esiste=-1 */
        } else if (CPLib.eqr(_esiste,-1)) {
          /* w_risultato := "E' necessario chiudere il rapporto prime di inserire i saldi !" // Risultato */
          w_risultato = "E' necessario chiudere il rapporto prime di inserire i saldi !";
          /* ElseIf _esiste > 1 */
        } else if (CPLib.gt(_esiste,1)) {
          /* w_risultato := "Esistono più rapporti collegati allo stesso soggetto !" // Risultato */
          w_risultato = "Esistono più rapporti collegati allo stesso soggetto !";
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* w_risultato := "Errore nell'elaborazione" // Risultato */
        w_risultato = "Errore nell'elaborazione";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Estatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Estatus,cTry0000000Emsg);
        }
      }
    } finally {
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_saldioro!=null)
          Cursor_saldioro.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
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
      m_Caller.SetNumber("annoope","N",4,0,w_annoope);
      m_Caller.SetString("CONNES","C",16,0,w_CONNES);
      m_Caller.SetNumber("imppagato","N",15,0,w_imppagato);
      m_Caller.SetNumber("impricevuto","N",15,0,w_impricevuto);
      m_Caller.SetNumber("numope","N",6,0,w_numope);
      m_Caller.SetString("risultato","C",80,0,w_risultato);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_saldi_oroR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_saldi_oroR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_annoope = m_Caller.GetNumber("annoope","N",4,0);
    w_CONNES = m_Caller.GetString("CONNES","C",16,0);
    w_imppagato = m_Caller.GetNumber("imppagato","N",15,0);
    w_impricevuto = m_Caller.GetNumber("impricevuto","N",15,0);
    w_numope = m_Caller.GetNumber("numope","N",6,0);
    w_risultato = m_Caller.GetString("risultato","C",80,0);
    _rapporto = CPLib.Space(25);
    _esiste = 0;
    _saldi = 0;
    _saldiage = CPLib.Space(2);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000021(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPORTO3,";
    p_cSql = p_cSql+"IMPORTO4,";
    p_cSql = p_cSql+"IMPORTO5,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"saldioro",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000025(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPORTO3,";
    p_cSql = p_cSql+"IMPORTO4,";
    p_cSql = p_cSql+"IMPORTO5,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeannora",true);
    return p_cSql;
  }
}
