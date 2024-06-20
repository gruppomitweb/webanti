// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_extrope_variaR implements CallerWithObjs {
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
  public double w_annorif;
  public String pSaldi;
  public double _contaerr;
  public double _min;
  public double _max;
  public double _tot;
  public double _cicli;
  public double _conta;
  public double _bottom;
  public double _top;
  public double _contarec;
  public double _mono;
  public double _reccount;
  public double _contacicli;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public java.sql.Date _datmin;
  public java.sql.Date _datold;
  public String _connes;
  public String w_anno;
  public String _oldmsg;
  public double _totsal;
  public double _numope;
  public String _cdatini;
  public String _cdatfin;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_extrope_variaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_extrope_varia",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("annorif",p_cVarName)) {
      return w_annorif;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      return _contaerr;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_totsal",p_cVarName)) {
      return _totsal;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_extrope_varia";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pSaldi",p_cVarName)) {
      return pSaldi;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_cdatini",p_cVarName)) {
      return _cdatini;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      return _cdatfin;
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
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_datmin",p_cVarName)) {
      return _datmin;
    }
    if (CPLib.eqr("_datold",p_cVarName)) {
      return _datold;
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
    if (CPLib.eqr("annorif",p_cVarName)) {
      w_annorif = value;
      return;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      _contaerr = value;
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
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
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
    if (CPLib.eqr("_totsal",p_cVarName)) {
      _totsal = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pSaldi",p_cVarName)) {
      pSaldi = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_cdatini",p_cVarName)) {
      _cdatini = value;
      return;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      _cdatfin = value;
      return;
    }
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
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_datmin",p_cVarName)) {
      _datmin = value;
      return;
    }
    if (CPLib.eqr("_datold",p_cVarName)) {
      _datold = value;
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
    CPResultSet Cursor_qbe_opxperiodo_minmax=null;
    CPResultSet Cursor_qbe_allinena_opex_ope=null;
    CPResultSet Cursor_qbe_calcsaldi_periodo_o=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_annorif Numeric(4, 0) */
      /* pSaldi Char(1) // Calcolo Saldi */
      /* _contaerr Numeric(10, 0) */
      /* _min Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _contarec Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _reccount Numeric(0, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _datini Date */
      /* _datfin Date */
      /* _datmin Date */
      /* _datold Date */
      /* _connes Char(16) */
      /* w_anno Char(4) */
      /* _oldmsg Char(100) */
      /* _totsal Numeric(12, 2) */
      /* _numope Numeric(10, 0) */
      /* _cdatini Char(8) */
      /* _cdatfin Char(8) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000020status;
      nTry00000020status = m_Sql.GetTransactionStatus();
      String cTry00000020msg;
      cTry00000020msg = m_Sql.TransactionErrorMessage();
      try {
        /* Azzera Variabili */
        /* w_anno := Str(w_annorif,4,0) */
        w_anno = CPLib.Str(w_annorif,4,0);
        /* _contaerr := 0 */
        _contaerr = CPLib.Round(0,0);
        /* _contarec := 0 */
        _contarec = CPLib.Round(0,0);
        /* _datini := CharToDate(w_anno+"0101") */
        _datini = CPLib.CharToDate(w_anno+"0101");
        /* _datfin := CharToDate(w_anno+"1231") */
        _datfin = CPLib.CharToDate(w_anno+"1231");
        /* _cdatini := w_anno+"0101" */
        _cdatini = w_anno+"0101";
        /* _cdatfin := w_anno+"1231" */
        _cdatfin = w_anno+"1231";
        /* gMsgImp := 'Trova i soggetti da esaminare ...' */
        gMsgImp = "Trova i soggetti da esaminare ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _max := 0 */
        _max = CPLib.Round(0,0);
        /* _min := 0 */
        _min = CPLib.Round(0,0);
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_opxperiodo_minmax
        SPBridge.HMCaller _h0000002E;
        _h0000002E = new SPBridge.HMCaller();
        _h0000002E.Set("m_cVQRList",m_cVQRList);
        _h0000002E.Set("anno",w_anno);
        if (Cursor_qbe_opxperiodo_minmax!=null)
          Cursor_qbe_opxperiodo_minmax.Close();
        Cursor_qbe_opxperiodo_minmax = new VQRHolder("qbe_opxperiodo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002E,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_opxperiodo_minmax.Eof())) {
          /* _min := qbe_opxperiodo_minmax->MINPRG */
          _min = CPLib.Round(Cursor_qbe_opxperiodo_minmax.GetDouble("MINPRG"),0);
          /* _max := qbe_opxperiodo_minmax->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_opxperiodo_minmax.GetDouble("MAXPRG"),0);
          /* _tot := qbe_opxperiodo_minmax->TOTPRG */
          _tot = CPLib.Round(Cursor_qbe_opxperiodo_minmax.GetDouble("TOTPRG"),0);
          Cursor_qbe_opxperiodo_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_opxperiodo_minmax.ErrorMessage();
        Cursor_qbe_opxperiodo_minmax.Close();
        // * --- End Select
        /* If _tot > 0 */
        if (CPLib.gt(_tot,0)) {
          /* _mono := 0 */
          _mono = CPLib.Round(0,0);
          /* _oldmsg := '' */
          _oldmsg = "";
          /* _mono := iif(_tot > 5000,0,1) */
          _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* If _tot = 0 */
            if (CPLib.eqr(_tot,0)) {
              /* _cicli := 0 */
              _cicli = CPLib.Round(0,0);
            } else { // Else
              /* _cicli := 1 */
              _cicli = CPLib.Round(1,0);
            } // End If
          } else { // Else
            /* _reccount := _max - _min */
            _reccount = CPLib.Round(_max-_min,0);
            /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
          } // End If
          /* _contacicli := 1 */
          _contacicli = CPLib.Round(1,0);
          /* While _contacicli <= _cicli */
          while (CPLib.le(_contacicli,_cicli)) {
            /* If _mono = 1 */
            if (CPLib.eqr(_mono,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* If _contacicli=1 */
              if (CPLib.eqr(_contacicli,1)) {
                /* _bottom := _min */
                _bottom = CPLib.Round(_min,0);
                /* _top := _min + 999 */
                _top = CPLib.Round(_min+999,0);
                /* ElseIf _contacicli = _cicli */
              } else if (CPLib.eqr(_contacicli,_cicli)) {
                /* _bottom := _top + 1 */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _max */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := _top + 1 */
                _bottom = CPLib.Round(_top+1,0);
                /* _top := _bottom + 999 */
                _top = CPLib.Round(_bottom+999,0);
              } // End If
            } // End If
            /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Periodo: '+w_anno+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio */
              gMsgProc = gMsgProc+"Periodo: "+w_anno+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Periodo: '+w_anno+" - " + LRTrim(gMsgImp)) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Periodo: "+w_anno+" - "+CPLib.LRTrim(gMsgImp));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Periodo: '+w_anno+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
            _oldmsg = "Periodo: "+w_anno+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
              gMsgImp = "Lettura operazioni extraconto in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Select from qbe_allinena_opex_ope
              SPBridge.HMCaller _h00000052;
              _h00000052 = new SPBridge.HMCaller();
              _h00000052.Set("m_cVQRList",m_cVQRList);
              _h00000052.Set("anno",w_anno);
              _h00000052.Set("_bottom",_bottom);
              _h00000052.Set("_top",_top);
              if (Cursor_qbe_allinena_opex_ope!=null)
                Cursor_qbe_allinena_opex_ope.Close();
              Cursor_qbe_allinena_opex_ope = new VQRHolder("qbe_allinena_opex_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000052,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_allinena_opex_ope.Eof())) {
                /* _totsal := 0 */
                _totsal = CPLib.Round(0,2);
                /* _numope := 0 */
                _numope = CPLib.Round(0,0);
                /* _datmin := NullDate() */
                _datmin = CPLib.NullDate();
                /* _datold := qbe_allinena_opex_ope->DATAOPE */
                _datold = Cursor_qbe_allinena_opex_ope.GetDate("DATAOPE");
                /* _connes := qbe_allinena_opex_ope->COLLEG */
                _connes = Cursor_qbe_allinena_opex_ope.GetString("COLLEG");
                /* gMsgImp := 'Elaboro il soggetto con codice (NDG): '+_connes */
                gMsgImp = "Elaboro il soggetto con codice (NDG): "+_connes;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                // * --- Select from qbe_calcsaldi_periodo_o
                SPBridge.HMCaller _h00000059;
                _h00000059 = new SPBridge.HMCaller();
                _h00000059.Set("m_cVQRList",m_cVQRList);
                _h00000059.Set("c_dadata",_cdatini);
                _h00000059.Set("c_a_data",_cdatfin);
                _h00000059.Set("c_ndg",_connes);
                if (Cursor_qbe_calcsaldi_periodo_o!=null)
                  Cursor_qbe_calcsaldi_periodo_o.Close();
                Cursor_qbe_calcsaldi_periodo_o = new VQRHolder("qbe_calcsaldi_periodo_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000059,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_calcsaldi_periodo_o.Eof())) {
                  /* If Empty(_datmin) or qbe_calcsaldi_periodo_o->DATAOPE < _datmin */
                  if (CPLib.Empty(_datmin) || CPLib.lt(Cursor_qbe_calcsaldi_periodo_o.GetDate("DATAOPE"),_datmin)) {
                    /* _datmin := qbe_calcsaldi_periodo_o->DATAOPE */
                    _datmin = Cursor_qbe_calcsaldi_periodo_o.GetDate("DATAOPE");
                  } // End If
                  /* If pSaldi='S' */
                  if (CPLib.eqr(pSaldi,"S")) {
                    /* _totsal := _totsal + (qbe_calcsaldi_periodo_o->TOTLIRE/100) */
                    _totsal = CPLib.Round(_totsal+(Cursor_qbe_calcsaldi_periodo_o.GetDouble("TOTLIRE")/100),2);
                    /* _numope := _numope + 1 */
                    _numope = CPLib.Round(_numope+1,0);
                  } // End If
                  Cursor_qbe_calcsaldi_periodo_o.Next();
                }
                m_cConnectivityError = Cursor_qbe_calcsaldi_periodo_o.ErrorMessage();
                Cursor_qbe_calcsaldi_periodo_o.Close();
                // * --- End Select
                /* If Empty(_datmin) */
                if (CPLib.Empty(_datmin)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  // * --- Write into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_extrope_varia",129,"00000061")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
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
                } else { // Else
                  /* If pSaldi='S' */
                  if (CPLib.eqr(pSaldi,"S")) {
                    /* If _datold <> _datmin or _totsal <> qbe_allinena_opex_ope->SALDO or _numope <> qbe_allinena_opex_ope->QUANTITA */
                    if (CPLib.ne(_datold,_datmin) || CPLib.ne(_totsal,Cursor_qbe_allinena_opex_ope.GetDouble("SALDO")) || CPLib.ne(_numope,Cursor_qbe_allinena_opex_ope.GetDouble("QUANTITA"))) {
                      /* _contarec := _contarec + 1 */
                      _contarec = CPLib.Round(_contarec+1,0);
                      // * --- Write into opextrbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("opextrbo");
                      m_cPhName = m_Ctx.GetPhName("opextrbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_extrope_varia",129,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datmin,"D",8,0)+", ";
                      m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                      m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
                      m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                      m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
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
                    } // End If
                  } else { // Else
                    /* If _datold <> _datmin */
                    if (CPLib.ne(_datold,_datmin)) {
                      /* _contarec := _contarec + 1 */
                      _contarec = CPLib.Round(_contarec+1,0);
                      // * --- Write into opextrbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("opextrbo");
                      m_cPhName = m_Ctx.GetPhName("opextrbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_extrope_varia",129,"00000068")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datmin,"D",8,0)+", ";
                      m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                      m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
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
                    } // End If
                  } // End If
                } // End If
                Cursor_qbe_allinena_opex_ope.Next();
              }
              m_cConnectivityError = Cursor_qbe_allinena_opex_ope.ErrorMessage();
              Cursor_qbe_allinena_opex_ope.Close();
              // * --- End Select
            } else { // Else
              /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
              gMsgImp = "Lettura operazioni extraconto in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* _contacicli := _contacicli+1 */
            _contacicli = CPLib.Round(_contacicli+1,0);
          } // End While
          /* gMsgProc := gMsgProc + NL // Messaggio */
          gMsgProc = gMsgProc+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Terminata. Cancellate: '+LRTrim(Str(_contaerr,10,0))+" - Rettificate: "+LRTrim(Str(_contarec,10,0)) */
        gMsgImp = "Elaborazione Terminata. Cancellate: "+CPLib.LRTrim(CPLib.Str(_contaerr,10,0))+" - Rettificate: "+CPLib.LRTrim(CPLib.Str(_contarec,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Abortita per errori' */
        gMsgImp = "Elaborazione Abortita per errori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000020status,0)) {
          m_Sql.SetTransactionStatus(nTry00000020status,cTry00000020msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_opxperiodo_minmax!=null)
          Cursor_qbe_opxperiodo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_allinena_opex_ope!=null)
          Cursor_qbe_allinena_opex_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_calcsaldi_periodo_o!=null)
          Cursor_qbe_calcsaldi_periodo_o.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_w_annorif,String p_pSaldi) {
    w_annorif = p_w_annorif;
    pSaldi = p_pSaldi;
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
  public String Run(double p_w_annorif,String p_pSaldi) {
    w_annorif = p_w_annorif;
    pSaldi = p_pSaldi;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
  public static arrt_extrope_variaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_extrope_variaR(p_Ctx, p_Caller);
  }
  public static arrt_extrope_variaR Make(CPContext p_Ctx) {
    return new arrt_extrope_variaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_annorif = 0;
    pSaldi = CPLib.Space(1);
    _contaerr = 0;
    _min = 0;
    _max = 0;
    _tot = 0;
    _cicli = 0;
    _conta = 0;
    _bottom = 0;
    _top = 0;
    _contarec = 0;
    _mono = 0;
    _reccount = 0;
    _contacicli = 0;
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    _datmin = CPLib.NullDate();
    _datold = CPLib.NullDate();
    _connes = CPLib.Space(16);
    w_anno = CPLib.Space(4);
    _oldmsg = CPLib.Space(100);
    _totsal = 0;
    _numope = 0;
    _cdatini = CPLib.Space(8);
    _cdatfin = CPLib.Space(8);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_opxperiodo_minmax,qbe_allinena_opex_ope,qbe_calcsaldi_periodo_o,
  public static final String m_cVQRList = ",qbe_opxperiodo_minmax,qbe_allinena_opex_ope,qbe_calcsaldi_periodo_o,";
  // ENTITY_BATCHES: ,arrt_extrope_varia,
  public static final String i_InvokedRoutines = ",arrt_extrope_varia,";
  public static String[] m_cRunParameterNames={"w_annorif","pSaldi"};
}
