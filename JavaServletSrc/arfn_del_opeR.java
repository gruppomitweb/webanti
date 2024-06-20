// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_del_opeR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
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
  public MemoryCursor_mcparametri_pg_del_ope_mcrdef mcParam;
  public String gMsgImp;
  public String gMsgProc;
  public boolean _mono;
  public double _cicli;
  public double _reccount;
  public double _contacicli;
  public double _tot;
  public double _min;
  public double _max;
  public double _bottom;
  public double _top;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_del_opeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_del_ope",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_del_ope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcParam",p_cVarName)) {
      return mcParam;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcParam",p_cVarName)) {
      mcParam = (MemoryCursor_mcparametri_pg_del_ope_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc_da_a_data_filter=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_fraziobo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* mcParam MemoryCursor(mcParametri_pg_del_ope.MCRDef) // Memory Cursor parametri */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* _mono Bool // risultato verifica se mono ciclo */
      /* _cicli Numeric(15, 0) // numero di cicli totali da effettuare */
      /* _reccount Numeric(0, 0) // numero di record totali tra min e max */
      /* _contacicli Numeric(15, 0) // contatore dei cicli */
      /* _tot Numeric(15, 0) // totale operazioni intervallo */
      /* _min Numeric(15, 0) // minimo operazioni intervallo */
      /* _max Numeric(15, 0) // max operazioni intervallo */
      /* _bottom Numeric(15, 0) // limite inferiore da passare alla query */
      /* _top Numeric(15, 0) // limite superiore da passare alla query */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000011status;
      nTry00000011status = m_Sql.GetTransactionStatus();
      String cTry00000011msg;
      cTry00000011msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := 'Inizio procedura: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = "Inizio procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If mcParam.fonte='O' or mcParam.fonte='T' */
        if (CPLib.eqr(mcParam.row.fonte,"O") || CPLib.eqr(mcParam.row.fonte,"T")) {
          /* gMsgImp := 'Preparazione annullamento operazioni...' // Messaggio Import */
          gMsgImp = "Preparazione annullamento operazioni...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_tab_mmc_da_a_data_filter
          SPBridge.HMCaller _h00000015;
          _h00000015 = new SPBridge.HMCaller();
          _h00000015.Set("m_cVQRList",m_cVQRList);
          _h00000015.Set("tbname","OPERAZBO");
          _h00000015.Set("fldname","PRGIMPOPE");
          _h00000015.Set("parname","DATAOPE");
          _h00000015.Set("parval",mcParam.row.da_data);
          _h00000015.Set("parval2",mcParam.row.a_data);
          if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
            Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          Cursor_qbe_tab_mmc_da_a_data_filter = new VQRHolder("qbe_tab_mmc_da_a_data_filter",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000015,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tab_mmc_da_a_data_filter.Eof())) {
            /* _tot := qbe_tab_mmc_da_a_data_filter->tot // totale operazioni intervallo */
            _tot = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("tot"),0);
            /* _min := qbe_tab_mmc_da_a_data_filter->min // minimo operazioni intervallo */
            _min = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("min"),0);
            /* _max := qbe_tab_mmc_da_a_data_filter->max // max operazioni intervallo */
            _max = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("max"),0);
            Cursor_qbe_tab_mmc_da_a_data_filter.Next();
          }
          m_cConnectivityError = Cursor_qbe_tab_mmc_da_a_data_filter.ErrorMessage();
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          // * --- End Select
          /* gMsgProc := gMsgProc+'Inizio procedura annullamento operazioni: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Inizio procedura annullamento operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _mono := True // risultato verifica se mono ciclo */
          _mono = true;
          /* _mono := iif(_tot>15000,False,True) // risultato verifica se mono ciclo */
          _mono = (CPLib.gt(_tot,15000)?false:true);
          /* If _mono */
          if (_mono) {
            /* If _tot = 0 */
            if (CPLib.eqr(_tot,0)) {
              /* _cicli := 0 // numero di cicli totali da effettuare */
              _cicli = CPLib.Round(0,0);
            } else { // Else
              /* _cicli := 1 // numero di cicli totali da effettuare */
              _cicli = CPLib.Round(1,0);
            } // End If
          } else { // Else
            /* _reccount := _max - _min // numero di record totali tra min e max */
            _reccount = CPLib.Round(_max-_min,0);
            /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) // numero di cicli totali da effettuare */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
          } // End If
          /* _contacicli := 1 // contatore dei cicli */
          _contacicli = CPLib.Round(1,0);
          /* While _contacicli <= _cicli */
          while (CPLib.le(_contacicli,_cicli)) {
            /* If _mono */
            if (_mono) {
              /* _bottom := _min // limite inferiore da passare alla query */
              _bottom = CPLib.Round(_min,0);
              /* _top := _max // limite superiore da passare alla query */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* If _contacicli=1 */
              if (CPLib.eqr(_contacicli,1)) {
                /* _bottom := _min // limite inferiore da passare alla query */
                _bottom = CPLib.Round(_min,0);
                /* _top := _min + 4999 // limite superiore da passare alla query */
                _top = CPLib.Round(_min+4999,0);
                /* ElseIf _contacicli = _cicli */
              } else if (CPLib.eqr(_contacicli,_cicli)) {
                /* _bottom := _top + 1 // limite inferiore da passare alla query */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _max // limite superiore da passare alla query */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := _top + 1 // limite inferiore da passare alla query */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _bottom + 4999 // limite superiore da passare alla query */
                _top = CPLib.Round(_bottom+4999,0);
              } // End If
            } // End If
            // * --- Select from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            if (Cursor_operazbo!=null)
              Cursor_operazbo.Close();
            Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PRGIMPOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  DATAOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcParam.row.da_data,"?",0,0,m_cServer, m_oParameters),m_cServer,mcParam.row.da_data)+"  and  DATAOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcParam.row.a_data,"?",0,0,m_cServer, m_oParameters),m_cServer,mcParam.row.a_data)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_operazbo.Eof())) {
              /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
              gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              Cursor_operazbo.Next();
            }
            m_cConnectivityError = Cursor_operazbo.ErrorMessage();
            Cursor_operazbo.Close();
            // * --- End Select
          } // End While
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End If
        /* gMsgProc := gMsgProc+'Fine procedura annullamento operazioni: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine procedura annullamento operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If mcParam.fonte='F' or mcParam.fonte='T' */
        if (CPLib.eqr(mcParam.row.fonte,"F") || CPLib.eqr(mcParam.row.fonte,"T")) {
          /* gMsgImp := 'Preparazione annullamento frazionate...' // Messaggio Import */
          gMsgImp = "Preparazione annullamento frazionate...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_tab_mmc_da_a_data_filter
          SPBridge.HMCaller _h00000036;
          _h00000036 = new SPBridge.HMCaller();
          _h00000036.Set("m_cVQRList",m_cVQRList);
          _h00000036.Set("tbname","FRAZIOBO");
          _h00000036.Set("fldname","PRGIMPFRZ");
          _h00000036.Set("parname","DATAOPE");
          _h00000036.Set("parval",mcParam.row.da_data);
          _h00000036.Set("parval2",mcParam.row.a_data);
          if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
            Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          Cursor_qbe_tab_mmc_da_a_data_filter = new VQRHolder("qbe_tab_mmc_da_a_data_filter",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000036,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tab_mmc_da_a_data_filter.Eof())) {
            /* _tot := qbe_tab_mmc_da_a_data_filter->tot // totale operazioni intervallo */
            _tot = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("tot"),0);
            /* _min := qbe_tab_mmc_da_a_data_filter->min // minimo operazioni intervallo */
            _min = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("min"),0);
            /* _max := qbe_tab_mmc_da_a_data_filter->max // max operazioni intervallo */
            _max = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("max"),0);
            Cursor_qbe_tab_mmc_da_a_data_filter.Next();
          }
          m_cConnectivityError = Cursor_qbe_tab_mmc_da_a_data_filter.ErrorMessage();
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          // * --- End Select
          /* gMsgProc := gMsgProc+'Inizio procedura annullamento frazionate: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Inizio procedura annullamento frazionate: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _mono := True // risultato verifica se mono ciclo */
          _mono = true;
          /* _mono := iif(_tot>15000,False,True) // risultato verifica se mono ciclo */
          _mono = (CPLib.gt(_tot,15000)?false:true);
          /* If _mono */
          if (_mono) {
            /* If _tot = 0 */
            if (CPLib.eqr(_tot,0)) {
              /* _cicli := 0 // numero di cicli totali da effettuare */
              _cicli = CPLib.Round(0,0);
            } else { // Else
              /* _cicli := 1 // numero di cicli totali da effettuare */
              _cicli = CPLib.Round(1,0);
            } // End If
          } else { // Else
            /* _reccount := _max - _min // numero di record totali tra min e max */
            _reccount = CPLib.Round(_max-_min,0);
            /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) // numero di cicli totali da effettuare */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
          } // End If
          /* _contacicli := 1 // contatore dei cicli */
          _contacicli = CPLib.Round(1,0);
          /* While _contacicli <= _cicli */
          while (CPLib.le(_contacicli,_cicli)) {
            /* If _mono */
            if (_mono) {
              /* _bottom := _min // limite inferiore da passare alla query */
              _bottom = CPLib.Round(_min,0);
              /* _top := _max // limite superiore da passare alla query */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* If _contacicli=1 */
              if (CPLib.eqr(_contacicli,1)) {
                /* _bottom := _min // limite inferiore da passare alla query */
                _bottom = CPLib.Round(_min,0);
                /* _top := _min + 4999 // limite superiore da passare alla query */
                _top = CPLib.Round(_min+4999,0);
                /* ElseIf _contacicli = _cicli */
              } else if (CPLib.eqr(_contacicli,_cicli)) {
                /* _bottom := _top + 1 // limite inferiore da passare alla query */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _max // limite superiore da passare alla query */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := _top + 1 // limite inferiore da passare alla query */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _bottom + 4999 // limite superiore da passare alla query */
                _top = CPLib.Round(_bottom+4999,0);
              } // End If
            } // End If
            // * --- Select from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            if (Cursor_fraziobo!=null)
              Cursor_fraziobo.Close();
            Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPFRZ>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PRGIMPFRZ<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  DATAOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcParam.row.da_data,"?",0,0,m_cServer, m_oParameters),m_cServer,mcParam.row.da_data)+"  and  DATAOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcParam.row.a_data,"?",0,0,m_cServer, m_oParameters),m_cServer,mcParam.row.a_data)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_fraziobo.Eof())) {
              /* gMsgImp := 'Lettura operazioni frazionate in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
              gMsgImp = "Lettura operazioni frazionate in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              Cursor_fraziobo.Next();
            }
            m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
            Cursor_fraziobo.Close();
            // * --- End Select
            /* _contacicli := _contacicli+1 */
            _contacicli = CPLib.Round(_contacicli+1,0);
          } // End While
          /* gMsgProc := gMsgProc+'Fine procedura annullamento frazionate: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Fine procedura annullamento frazionate: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc+'Fine procedura: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Return True  */
        throw new Stop(true);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* Return False */
        throw new Stop(false);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000011status,0)) {
          m_Sql.SetTransactionStatus(nTry00000011status,cTry00000011msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursor_mcparametri_pg_del_ope_mcrdef p_mcParam) {
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
  public boolean Run(MemoryCursor_mcparametri_pg_del_ope_mcrdef p_mcParam) {
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
  public static arfn_del_opeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_del_opeR(p_Ctx, p_Caller);
  }
  public static arfn_del_opeR Make(CPContext p_Ctx) {
    return new arfn_del_opeR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcParam = new MemoryCursor_mcparametri_pg_del_ope_mcrdef();
    _mono = false;
    _cicli = 0;
    _reccount = 0;
    _contacicli = 0;
    _tot = 0;
    _min = 0;
    _max = 0;
    _bottom = 0;
    _top = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc_da_a_data_filter,qbe_tab_mmc_da_a_data_filter,
  public static final String m_cVQRList = ",qbe_tab_mmc_da_a_data_filter,qbe_tab_mmc_da_a_data_filter,";
  // ENTITY_BATCHES: ,arfn_del_ope,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_del_ope,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"mcParam"};
}
