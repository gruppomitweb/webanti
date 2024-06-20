// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_moneygram_allineamentiR implements CallerWithObjs {
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
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef mcParam;
  public String gMsgImp;
  public String gMsgProc;
  public MemoryCursor_mcconnes_mcrdef conness;
  public java.sql.Date data_alliena;
  public double conta;
  public double tot_record;
  public String tot_record_str;
  public String messaggio;
  public boolean ritorno;
  public String _sanumpro;
  public String _connes;
  public double _num_clear;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_moneygram_allineamentiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_moneygram_allineamenti",m_Caller);
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("tot_record",p_cVarName)) {
      return tot_record;
    }
    if (CPLib.eqr("_num_clear",p_cVarName)) {
      return _num_clear;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_moneygram_allineamenti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("tot_record_str",p_cVarName)) {
      return tot_record_str;
    }
    if (CPLib.eqr("messaggio",p_cVarName)) {
      return messaggio;
    }
    if (CPLib.eqr("_sanumpro",p_cVarName)) {
      return _sanumpro;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("data_alliena",p_cVarName)) {
      return data_alliena;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("ritorno",p_cVarName)) {
      return ritorno;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcParam",p_cVarName)) {
      return mcParam;
    }
    if (CPLib.eqr("conness",p_cVarName)) {
      return conness;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("tot_record",p_cVarName)) {
      tot_record = value;
      return;
    }
    if (CPLib.eqr("_num_clear",p_cVarName)) {
      _num_clear = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("tot_record_str",p_cVarName)) {
      tot_record_str = value;
      return;
    }
    if (CPLib.eqr("messaggio",p_cVarName)) {
      messaggio = value;
      return;
    }
    if (CPLib.eqr("_sanumpro",p_cVarName)) {
      _sanumpro = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("data_alliena",p_cVarName)) {
      data_alliena = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("ritorno",p_cVarName)) {
      ritorno = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcParam",p_cVarName)) {
      mcParam = (MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef)value;
      return;
    }
    if (CPLib.eqr("conness",p_cVarName)) {
      conness = (MemoryCursor_mcconnes_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_qbe_tab_mmc_da_a_data_filter=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* mcParam MemoryCursor(mcParametri_pg_moneygram_allineamenti.MCRDef) // Memory Cursor parametri */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* conness MemoryCursor(mcConnes.MCRDef) // MC dei connes nel giorno di variazione */
      /* data_alliena Date // Data a cui alienare tutte le variazioni successive */
      /* conta Numeric(10, 0) // conteggio */
      /* tot_record Numeric(10, 0) // numero totale dei record da prendere in esame */
      /* tot_record_str Char(13) // numero totale dei record da prendere in esame su stringa */
      /* messaggio Char(120) // messaggio per errore */
      /* ritorno Bool // ritorno della funzione */
      /* _sanumpro Char(15) // progressivo a cui sono arrivato */
      /* _connes Char(16) // conness letto */
      /* _num_clear Numeric(10, 0) // numero massimo di recod del MC di controllo (conness) */
      /* _num_clear := 120000 // numero massimo di recod del MC di controllo (conness) */
      _num_clear = CPLib.Round(120000,0);
      /* conta := 0 // conteggio */
      conta = CPLib.Round(0,0);
      /* ritorno := True // ritorno della funzione */
      ritorno = true;
      /* data_alliena := mcParam.data_allienamento // Data a cui alienare tutte le variazioni successive */
      data_alliena = mcParam.row.data_allienamento;
      /* gMsgProc := 'Inizio procedura: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Inizio procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+'Data allineamento: '+arfn_fdate(data_alliena)+ NL // Messaggio */
      gMsgProc = gMsgProc+"Data allineamento: "+arfn_fdateR.Make(m_Ctx,this).Run(data_alliena)+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000017status;
      nTry00000017status = m_Sql.GetTransactionStatus();
      String cTry00000017msg;
      cTry00000017msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Preparazione elenco conness...' // Messaggio Import */
        gMsgImp = "Preparazione elenco conness...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Fill memory cursor conness on wersonbo
        conness.Zap();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(data_alliena,"?",0,0,m_cServer, m_oParameters),m_cServer,data_alliena)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CONNES ",m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_wersonbo;
          Cursor_wersonbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_moneygram_allineamenti: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_wersonbo.Eof())) {
          conness.AppendWithTrimmedKey(Cursor_wersonbo.GetString("CONNES"));
          conness.row.connes = "";
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        conness.GoTop();
        /* _sanumpro := '000000000000001' // progressivo a cui sono arrivato */
        _sanumpro = "000000000000001";
        /* Levo subito quelli che non hanno modifiche successive cosi è più rapido */
        /* gMsgImp := 'Verifica dei dati...' // Messaggio Import */
        gMsgImp = "Verifica dei dati...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_tab_mmc_da_a_data_filter
        SPBridge.HMCaller _h0000001D;
        _h0000001D = new SPBridge.HMCaller();
        _h0000001D.Set("m_cVQRList",m_cVQRList);
        _h0000001D.Set("tbname","wersonbo");
        _h0000001D.Set("fldname","sanumpro");
        _h0000001D.Set("parname","datamodi");
        _h0000001D.Set("parval",arfn_datesumR.Make(m_Ctx,this).Run(data_alliena,1));
        if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
        Cursor_qbe_tab_mmc_da_a_data_filter = new VQRHolder("qbe_tab_mmc_da_a_data_filter",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001D,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc_da_a_data_filter.Eof())) {
          /* tot_record := qbe_tab_mmc_da_a_data_filter->tot // numero totale dei record da prendere in esame */
          tot_record = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc_da_a_data_filter.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc_da_a_data_filter.ErrorMessage();
        Cursor_qbe_tab_mmc_da_a_data_filter.Close();
        // * --- End Select
        /* tot_record_str := Right(Replicate(' ',10)+Str(tot_record,10,0),10) // numero totale dei record da prendere in esame su stringa */
        tot_record_str = CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(tot_record,10,0),10);
        /* tot_record<200000 uso sepre il nuovo metodo */
        /* If False */
        if (false) {
          /* Nel  Mc connes ho tutti i connes già presenti in data allienamento
             Mentre la select estrae i dati successivi alla data allienamento e li mette in ordine di modifca cosi da prendere la più vecchia ed eliminare le successive. */
          // * --- Select from wersonbo
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          if (Cursor_wersonbo!=null)
            Cursor_wersonbo.Close();
          Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro,CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"datamodi>"+CPSql.SQLValueAdapter(CPLib.ToSQL(data_alliena,"?",0,0,m_cServer, m_oParameters),m_cServer,data_alliena)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"sanumpro ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_wersonbo.Eof())) {
            /* conta := conta+1 // conteggio */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Elaborazione conness: '+LRTrim(wersonbo->CONNES)+' '+Right(Replicate(' ',10)+Str(conta,10,0),10)+' / '+tot_record_str // Messaggio Import */
            gMsgImp = "Elaborazione conness: "+CPLib.LRTrim(Cursor_wersonbo.GetString("CONNES"))+" "+CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(conta,10,0),10)+" / "+tot_record_str;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If conness.GoToKey(wersonbo->CONNES) */
            if (conness.GoToKey(Cursor_wersonbo.GetString("CONNES"))) {
              /* gMsgProc := gMsgProc+'Conness già presente: '+LRTrim(wersonbo->connes)+' '+Right(Replicate(' ',10)+Str(conta,10,0),10)+' / '+tot_record_str+' '+Str(conness.RecCount(),10,0)+ NL // Messaggio */
              gMsgProc = gMsgProc+"Conness già presente: "+CPLib.LRTrim(Cursor_wersonbo.GetString("connes"))+" "+CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(conta,10,0),10)+" / "+tot_record_str+" "+CPLib.Str(conness.RecCount(),10,0)+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* conness.AppendBlank() // MC dei connes nel giorno di variazione */
              conness.AppendBlank();
              /* conness.connes := wersonbo->CONNES // MC dei connes nel giorno di variazione */
              conness.row.connes = Cursor_wersonbo.GetString("CONNES");
              /* conness.SetKey(wersonbo->CONNES) // MC dei connes nel giorno di variazione */
              conness.SetKey(Cursor_wersonbo.GetString("CONNES"));
              /* conness.SaveRow() // MC dei connes nel giorno di variazione */
              conness.SaveRow();
              /* gMsgProc := gMsgProc+'Conness non presente: '+LRTrim(wersonbo->connes)+' '+Right(Replicate(' ',10)+Str(conta,10,0),10)+' / '+tot_record_str+' '+Str(conness.RecCount(),10,0)+ NL // Messaggio */
              gMsgProc = gMsgProc+"Conness non presente: "+CPLib.LRTrim(Cursor_wersonbo.GetString("connes"))+" "+CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(conta,10,0),10)+" / "+tot_record_str+" "+CPLib.Str(conness.RecCount(),10,0)+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              // * --- Write into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_moneygram_allineamenti",59,"0000002D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"datamodi = "+CPLib.ToSQL(data_alliena,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"sanumpro = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wersonbo.GetString("sanumpro"),"?",0,0,m_cServer),m_cServer,Cursor_wersonbo.GetString("sanumpro"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                m_cLastMsgError = "1";
                throw new RoutineException();
              }
              /* Levo quelli che non hanno modifiche successive cosi è più rapido e non si appesantisce troppo */
              /* If conness.RecCount()>_num_clear */
              if (CPLib.gt(conness.RecCount(),_num_clear)) {
                /* _sanumpro := wersonbo->sanumpro // progressivo a cui sono arrivato */
                _sanumpro = Cursor_wersonbo.GetString("sanumpro");
                /* Exec "Pulizia" Page 2:Page_2 */
                Page_2();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* If conness.RecCount()>=_num_clear */
                if (CPLib.ge(conness.RecCount(),_num_clear)) {
                  /* _num_clear := conness.RecCount()+10000 */
                  _num_clear = CPLib.Round(conness.RecCount()+10000,0);
                } // End If
              } // End If
            } // End If
            Cursor_wersonbo.Next();
          }
          m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
          Cursor_wersonbo.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Allineamento singole modifiche in corso...' // Messaggio Import */
          gMsgImp = "Allineamento singole modifiche in corso...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc+'Inizio allineamento singole modifiche '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Inizio allineamento singole modifiche "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* quelli che ci sono una volta solo dalla data di allineamento in poi li allineo tutti alla data di allineamento */
          // * --- Write into wersonbo from query
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
          SPBridge.HMCaller _h00000037;
          _h00000037 = new SPBridge.HMCaller();
          _h00000037.Set("m_cVQRList",m_cVQRList);
          _h00000037.Set("pdatamodi",data_alliena);
          try {
            l_VQRHolder = new VQRHolder("qbe_count_mod_post_data",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000037,true);
            m_cQuery = l_VQRHolder.GetQueryMakingTempTables(m_Ctx,m_Sql,m_cServer,true);
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_nUpdatedRows = m_Sql.WriteFromSql(CPLib.GetSQLPrefixComment("arfn_moneygram_allineamenti",59,"00000037"),"wersonbo",m_cQuery,CPSql.NewMultipleStringValues("sanumpro"),CPSql.NewMultipleStringValues("datamodi"),CPSql.NewMultipleStringValues("="),CPSql.NewMultipleStringValues(m_oParameters,""+CPLib.ToSQL(data_alliena,"?",0,0)+""),m_Ctx,m_oWrInfo);
          } finally {
            if (l_VQRHolder!=null)
              l_VQRHolder.DropTempTables(m_Ctx);
          }
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "1";
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc+'Fine allineamento singole modifiche '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Fine allineamento singole modifiche "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc+'Inizio eliminazioni delle modifiche successive per i soggetti già presenti '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Inizio eliminazioni delle modifiche successive per i soggetti già presenti "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Elimino subito tutti quelli che avevano già una modifica in data di allienamento cosi da lavorare solo su quelli che sono successivi e doppi */
          for (MemoryCursorRow_mcconnes_mcrdef rwconness : conness._iterable_()) {
            /* gMsgImp := 'Eliminazioni delle modifiche successive per i soggetti già presenti '+rwconness.connes // Messaggio Import */
            gMsgImp = "Eliminazioni delle modifiche successive per i soggetti già presenti "+rwconness.connes;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Delete from wersonbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_moneygram_allineamenti",59,"0000003D")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwconness.connes,"?",0,0,m_cServer),m_cServer,rwconness.connes)+"";
            m_cSql = m_cSql+" and datamodi > "+CPSql.SQLValueAdapter(CPLib.ToSQL(data_alliena,"?",0,0,m_cServer),m_cServer,data_alliena)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          }
          /* gMsgProc := gMsgProc+'Fine eliminazioni delle modifiche successive per i soggetti già presenti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Fine eliminazioni delle modifiche successive per i soggetti già presenti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* conness.Zap() // MC dei connes nel giorno di variazione */
          conness.Zap();
          /* _connes := '' // conness letto */
          _connes = "";
          /* Di quelle che hanno più di una modifica, prendo la modifca più vecchia allineandole alla data */
          /* gMsgProc := gMsgProc+'Inizio selezione dei soggetti con più di una modifica post data '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Inizio selezione dei soggetti con più di una modifica post data "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from wersonbo
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          if (Cursor_wersonbo!=null)
            Cursor_wersonbo.Close();
          Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro,CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"datamodi>"+CPSql.SQLValueAdapter(CPLib.ToSQL(data_alliena,"?",0,0,m_cServer, m_oParameters),m_cServer,data_alliena)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CONNES,datamodi,sanumpro ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_wersonbo.Eof())) {
            /* conta := conta+1 // conteggio */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Elaborazione conness: '+LRTrim(wersonbo->CONNES)+' '+Right(Replicate(' ',10)+Str(conta,10,0),10)+' / '+tot_record_str // Messaggio Import */
            gMsgImp = "Elaborazione conness: "+CPLib.LRTrim(Cursor_wersonbo.GetString("CONNES"))+" "+CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(conta,10,0),10)+" / "+tot_record_str;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* gMsgProc := gMsgProc+'Elaborazione conness: '+LRTrim(wersonbo->CONNES)+' '+Right(Replicate(' ',10)+Str(conta,10,0),10)+' / '+tot_record_str+ NL // Messaggio */
            gMsgProc = gMsgProc+"Elaborazione conness: "+CPLib.LRTrim(Cursor_wersonbo.GetString("CONNES"))+" "+CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(conta,10,0),10)+" / "+tot_record_str+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* If conta=1 or wersonbo->CONNES<>_connes */
            if (CPLib.eqr(conta,1) || CPLib.ne(Cursor_wersonbo.GetString("CONNES"),_connes)) {
              /* _connes := wersonbo->CONNES // conness letto */
              _connes = Cursor_wersonbo.GetString("CONNES");
              // * --- Write into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_moneygram_allineamenti",59,"00000049")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"datamodi = "+CPLib.ToSQL(data_alliena,"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"sanumpro = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wersonbo.GetString("sanumpro"),"?",0,0,m_cServer),m_cServer,Cursor_wersonbo.GetString("sanumpro"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                m_cLastMsgError = "1";
                throw new RoutineException();
              }
            } // End If
            Cursor_wersonbo.Next();
          }
          m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
          Cursor_wersonbo.Close();
          // * --- End Select
        } // End If
        /* gMsgProc := gMsgProc+'Sogggetti allineati '+Str(conta,10,0)+' '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Sogggetti allineati "+CPLib.Str(conta,10,0)+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc+'Fine selezione dei soggetti con più di una modifica post data '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine selezione dei soggetti con più di una modifica post data "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Eliminazione modifiche successive inutili... ' // Messaggio Import */
        gMsgImp = "Eliminazione modifiche successive inutili... ";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Delete from wersonbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arfn_moneygram_allineamenti",59,"0000004D")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"datamodi > "+CPSql.SQLValueAdapter(CPLib.ToSQL(data_alliena,"?",0,0,m_cServer),m_cServer,data_alliena)+"";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
        /* conness.Zap() // MC dei connes nel giorno di variazione */
        conness.Zap();
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione conclusa' // Messaggio Import */
        gMsgImp = "Elaborazione conclusa";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc+'Fine procedura: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* ritorno := False // ritorno della funzione */
        ritorno = false;
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000017status,0)) {
          m_Sql.SetTransactionStatus(nTry00000017status,cTry00000017msg);
        }
      }
      /* Return ritorno */
      throw new Stop(ritorno);
    } finally {
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_wersonbo=null;
    try {
      /* _nofind Bool // non trovate altre variazioni */
      boolean _nofind;
      _nofind = false;
      /* connessdel MemoryCursor(mcConnes.MCRDef) // MC dei connes nel giorno di variazione da togliere */
      MemoryCursor_mcconnes_mcrdef connessdel;
      connessdel = new MemoryCursor_mcconnes_mcrdef();
      for (MemoryCursorRow_mcconnes_mcrdef rwconness : conness._iterable_()) {
        /* gMsgImp := 'Preparazione elenco conness... '+rwconness.connes // Messaggio Import */
        gMsgImp = "Preparazione elenco conness... "+rwconness.connes;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _nofind := True // non trovate altre variazioni */
        _nofind = true;
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro>"+CPSql.SQLValueAdapter(CPLib.ToSQL(_sanumpro,"?",0,0,m_cServer, m_oParameters),m_cServer,_sanumpro)+"  and  "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwconness.connes,"?",0,0,m_cServer, m_oParameters),m_cServer,rwconness.connes)+"=CONNES  and  datamodi>"+CPSql.SQLValueAdapter(CPLib.ToSQL(data_alliena,"?",0,0,m_cServer, m_oParameters),m_cServer,data_alliena)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* _nofind := False // non trovate altre variazioni */
          _nofind = false;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
        /* If _nofind */
        if (_nofind) {
          /* connessdel.AppendRow(rwconness) // MC dei connes nel giorno di variazione */
          connessdel.AppendRow(rwconness);
        } // End If
      }
      /* Se il numero record è ugual si zappa il MC e via */
      /* If conness.RecCount()=connessdel.RecCount() */
      if (CPLib.eqr(conness.RecCount(),connessdel.RecCount())) {
        /* conness.Zap() // MC dei connes nel giorno di variazione */
        conness.Zap();
      } else { // Else
        for (MemoryCursorRow_mcconnes_mcrdef rwconnesdel : connessdel._iterable_()) {
          /* gMsgImp := "Eliminazione dall'elenco conness... "+rwconnesdel.connes // Messaggio Import */
          gMsgImp = "Eliminazione dall'elenco conness... "+rwconnesdel.connes;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* conness.GoToKey(rwconnesdel.connes) // MC dei connes nel giorno di variazione */
          conness.GoToKey(rwconnesdel.connes);
          /* conness.Delete() // MC dei connes nel giorno di variazione */
          conness.Delete();
        }
      } // End If
      /* connessdel.Zap() // MC dei connes nel giorno di variazione da togliere */
      connessdel.Zap();
    } finally {
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
  public String RunAsync(MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef p_mcParam) {
    mcParam = p_mcParam;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public boolean Run(MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef p_mcParam) {
    mcParam = p_mcParam;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
    return l_result;
  }
  public static arfn_moneygram_allineamentiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_moneygram_allineamentiR(p_Ctx, p_Caller);
  }
  public static arfn_moneygram_allineamentiR Make(CPContext p_Ctx) {
    return new arfn_moneygram_allineamentiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcParam = new MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef();
    conness = new MemoryCursor_mcconnes_mcrdef();
    data_alliena = CPLib.NullDate();
    conta = 0;
    tot_record = 0;
    tot_record_str = CPLib.Space(13);
    messaggio = CPLib.Space(120);
    ritorno = false;
    _sanumpro = CPLib.Space(15);
    _connes = CPLib.Space(16);
    _num_clear = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc_da_a_data_filter,qbe_count_mod_post_data,
  public static final String m_cVQRList = ",qbe_tab_mmc_da_a_data_filter,qbe_count_mod_post_data,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,arfn_moneygram_allineamenti,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,arfn_moneygram_allineamenti,";
  public static String[] m_cRunParameterNames={"mcParam"};
}
