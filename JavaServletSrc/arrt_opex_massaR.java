// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_opex_massaR implements CallerWithObjs {
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
  public String w_flgoef;
  public String w_flgoag;
  public String w_flgdel;
  public double _max;
  public double _min;
  public double _top;
  public double _bottom;
  public double _cicli;
  public double _contacilci;
  public double _ctotale;
  public String _anno;
  public String _annoread;
  public java.sql.Date _dataread;
  public String _prog;
  public double _conta;
  public String gMsgImp;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_opex_massaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_opex_massa",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      return _ctotale;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_opex_massa";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("flgoef",p_cVarName)) {
      return w_flgoef;
    }
    if (CPLib.eqr("flgoag",p_cVarName)) {
      return w_flgoag;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_annoread",p_cVarName)) {
      return _annoread;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataread",p_cVarName)) {
      return _dataread;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
      return;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      _ctotale = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("flgoef",p_cVarName)) {
      w_flgoef = value;
      return;
    }
    if (CPLib.eqr("flgoag",p_cVarName)) {
      w_flgoag = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_annoread",p_cVarName)) {
      _annoread = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataread",p_cVarName)) {
      _dataread = value;
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
    /* w_flgoef Char(1) */
    /* w_flgoag Char(1) */
    /* w_flgdel Char(1) */
    /* _max Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _contacilci Numeric(15, 0) */
    /* _ctotale Numeric(15, 0) */
    /* _anno Char(4) */
    /* _annoread Char(4) */
    /* _dataread Date */
    /* _prog Char(10) */
    /* _conta Numeric(4, 0) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gAzienda Char(10) // Azienda */
    /* Cicla sulle informazioni sui rapporti */
    /* If w_flgdel = 'S' */
    if (CPLib.eqr(w_flgdel,"S")) {
      /* gMsgImp := 'Cancellazione operazioni extraconto esistenti ...' // Messaggio Import */
      gMsgImp = "Cancellazione operazioni extraconto esistenti ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from opextrbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("opextrbo");
      m_cPhName = m_Ctx.GetPhName("opextrbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000017")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
    /* If w_flgoef = 'S' */
    if (CPLib.eqr(w_flgoef,"S")) {
      /* Exec "Operazioni AUI" Page 2:Page_2 */
      Page_2();
      /* Exec "Frazionate AUI" Page 3:Page_3 */
      Page_3();
    } // End If
    /* If w_flgoag = 'S' */
    if (CPLib.eqr(w_flgoag,"S")) {
      /* Exec "Operazioni AGE" Page 4:Page_4 */
      Page_4();
    } // End If
    /* gMsgImp := 'Elaborazione Terminata' // Messaggio Import */
    gMsgImp = "Elaborazione Terminata";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_uic_ope_minmax=null;
    CPResultSet Cursor_qbe_operazbo_uic=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgImp := 'Verifica Operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_uic_ope_minmax
      if (Cursor_qbe_uic_ope_minmax!=null)
        Cursor_qbe_uic_ope_minmax.Close();
      Cursor_qbe_uic_ope_minmax = new VQRHolder("qbe_uic_ope_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_uic_ope_minmax.Eof())) {
        /* _max := qbe_uic_ope_minmax->MASSIMO */
        _max = CPLib.Round(Cursor_qbe_uic_ope_minmax.GetDouble("MASSIMO"),0);
        /* _min := qbe_uic_ope_minmax->MINIMO */
        _min = CPLib.Round(Cursor_qbe_uic_ope_minmax.GetDouble("MINIMO"),0);
        Cursor_qbe_uic_ope_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_uic_ope_minmax.ErrorMessage();
      Cursor_qbe_uic_ope_minmax.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
        _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_operazbo_uic
        SPBridge.HMCaller _h0000002E;
        _h0000002E = new SPBridge.HMCaller();
        _h0000002E.Set("m_cVQRList",m_cVQRList);
        _h0000002E.Set("_bottom",_bottom);
        _h0000002E.Set("_top",_top);
        if (Cursor_qbe_operazbo_uic!=null)
          Cursor_qbe_operazbo_uic.Close();
        Cursor_qbe_operazbo_uic = new VQRHolder("qbe_operazbo_uic",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002E,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_operazbo_uic.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _annoread := '' */
          _annoread = "";
          /* _dataread := NullDate() */
          _dataread = CPLib.NullDate();
          /* _anno := Str(Year(qbe_operazbo_uic->DATAOPE),4,0) */
          _anno = CPLib.Str(CPLib.Year(Cursor_qbe_operazbo_uic.GetDate("DATAOPE")),4,0);
          // * --- Read from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_cSql = "";
          m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_operazbo_uic.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_operazbo_uic.GetString("CONNESCLI"));
          m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"C",4,0,m_cServer),m_cServer,_anno);
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ANNO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _annoread = Read_Cursor.GetString("ANNO");
            _dataread = Read_Cursor.GetDate("DATAOPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_opex_massa returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _annoread = "";
            _dataread = CPLib.NullDate();
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_annoread)) */
          if (CPLib.Empty(CPLib.LRTrim(_annoread))) {
            /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
            _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000037")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000037(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_operazbo_uic.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_operazbo_uic.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_operazbo_uic.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
          } else { // Else
            /* If _dataread > qbe_operazbo_uic->DATAOPE */
            if (CPLib.gt(_dataread,Cursor_qbe_operazbo_uic.GetDate("DATAOPE"))) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000039")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_operazbo_uic.GetDate("DATAOPE"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_operazbo_uic.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_operazbo_uic.GetString("CONNESCLI"))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          Cursor_qbe_operazbo_uic.Next();
        }
        m_cConnectivityError = Cursor_qbe_operazbo_uic.ErrorMessage();
        Cursor_qbe_operazbo_uic.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_uic_ope_minmax!=null)
          Cursor_qbe_uic_ope_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_operazbo_uic!=null)
          Cursor_qbe_operazbo_uic.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_uic_frz_minmax=null;
    CPResultSet Cursor_qbe_fraziobo_uic=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgImp := 'Verifica Operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_uic_frz_minmax
      if (Cursor_qbe_uic_frz_minmax!=null)
        Cursor_qbe_uic_frz_minmax.Close();
      Cursor_qbe_uic_frz_minmax = new VQRHolder("qbe_uic_frz_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_uic_frz_minmax.Eof())) {
        /* _max := qbe_uic_frz_minmax->MASSIMO */
        _max = CPLib.Round(Cursor_qbe_uic_frz_minmax.GetDouble("MASSIMO"),0);
        /* _min := qbe_uic_frz_minmax->MINIMO */
        _min = CPLib.Round(Cursor_qbe_uic_frz_minmax.GetDouble("MINIMO"),0);
        Cursor_qbe_uic_frz_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_uic_frz_minmax.ErrorMessage();
      Cursor_qbe_uic_frz_minmax.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura frazionate in corso ...' // Messaggio Import */
      gMsgImp = "Lettura frazionate in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
        _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* gMsgImp := 'Lettura frazionate in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura frazionate in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_fraziobo_uic
        SPBridge.HMCaller _h0000004B;
        _h0000004B = new SPBridge.HMCaller();
        _h0000004B.Set("m_cVQRList",m_cVQRList);
        _h0000004B.Set("_bottom",_bottom);
        _h0000004B.Set("_top",_top);
        if (Cursor_qbe_fraziobo_uic!=null)
          Cursor_qbe_fraziobo_uic.Close();
        Cursor_qbe_fraziobo_uic = new VQRHolder("qbe_fraziobo_uic",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_fraziobo_uic.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _annoread := '' */
          _annoread = "";
          /* _dataread := NullDate() */
          _dataread = CPLib.NullDate();
          /* _anno := Str(Year(qbe_fraziobo_uic->DATAOPE),4,0) */
          _anno = CPLib.Str(CPLib.Year(Cursor_qbe_fraziobo_uic.GetDate("DATAOPE")),4,0);
          // * --- Read from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_cSql = "";
          m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_fraziobo_uic.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_fraziobo_uic.GetString("CONNESCLI"));
          m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"C",4,0,m_cServer),m_cServer,_anno);
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ANNO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _annoread = Read_Cursor.GetString("ANNO");
            _dataread = Read_Cursor.GetDate("DATAOPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_opex_massa returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _annoread = "";
            _dataread = CPLib.NullDate();
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_annoread)) */
          if (CPLib.Empty(CPLib.LRTrim(_annoread))) {
            /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
            _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000054")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000054(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fraziobo_uic.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fraziobo_uic.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fraziobo_uic.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
          } else { // Else
            /* If _dataread > qbe_fraziobo_uic->DATAOPE */
            if (CPLib.gt(_dataread,Cursor_qbe_fraziobo_uic.GetDate("DATAOPE"))) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000056")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_fraziobo_uic.GetDate("DATAOPE"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_fraziobo_uic.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_fraziobo_uic.GetString("CONNESCLI"))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          Cursor_qbe_fraziobo_uic.Next();
        }
        m_cConnectivityError = Cursor_qbe_fraziobo_uic.ErrorMessage();
        Cursor_qbe_fraziobo_uic.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_uic_frz_minmax!=null)
          Cursor_qbe_uic_frz_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fraziobo_uic!=null)
          Cursor_qbe_fraziobo_uic.Close();
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
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_age_ope_minmax=null;
    CPResultSet Cursor_qbe_jperazbo_uic=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgImp := 'Verifica Operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_age_ope_minmax
      if (Cursor_qbe_age_ope_minmax!=null)
        Cursor_qbe_age_ope_minmax.Close();
      Cursor_qbe_age_ope_minmax = new VQRHolder("qbe_age_ope_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_age_ope_minmax.Eof())) {
        /* _max := qbe_age_ope_minmax->MASSIMO */
        _max = CPLib.Round(Cursor_qbe_age_ope_minmax.GetDouble("MASSIMO"),0);
        /* _min := qbe_age_ope_minmax->MINIMO */
        _min = CPLib.Round(Cursor_qbe_age_ope_minmax.GetDouble("MINIMO"),0);
        Cursor_qbe_age_ope_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_age_ope_minmax.ErrorMessage();
      Cursor_qbe_age_ope_minmax.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura operazioni AGE in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni AGE in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _bottom := ((_contacilci -1 ) * 5000) + 1 */
        _bottom = CPLib.Round(((_contacilci-1)*5000)+1,0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* gMsgImp := 'Lettura operazioni age in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni age in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_jperazbo_uic
        SPBridge.HMCaller _h00000068;
        _h00000068 = new SPBridge.HMCaller();
        _h00000068.Set("m_cVQRList",m_cVQRList);
        _h00000068.Set("_bottom",_bottom);
        _h00000068.Set("_top",_top);
        if (Cursor_qbe_jperazbo_uic!=null)
          Cursor_qbe_jperazbo_uic.Close();
        Cursor_qbe_jperazbo_uic = new VQRHolder("qbe_jperazbo_uic",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000068,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_jperazbo_uic.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Operazione AGE N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione AGE N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _annoread := '' */
          _annoread = "";
          /* _dataread := NullDate() */
          _dataread = CPLib.NullDate();
          /* _anno := Str(Year(qbe_jperazbo_uic->DATAOPE),4,0) */
          _anno = CPLib.Str(CPLib.Year(Cursor_qbe_jperazbo_uic.GetDate("DATAOPE")),4,0);
          // * --- Read from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_cSql = "";
          m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_jperazbo_uic.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_jperazbo_uic.GetString("CONNESCLI"));
          m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"C",4,0,m_cServer),m_cServer,_anno);
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ANNO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _annoread = Read_Cursor.GetString("ANNO");
            _dataread = Read_Cursor.GetDate("DATAOPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_opex_massa returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _annoread = "";
            _dataread = CPLib.NullDate();
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_annoread)) */
          if (CPLib.Empty(CPLib.LRTrim(_annoread))) {
            /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
            _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000071")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000071(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_jperazbo_uic.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_jperazbo_uic.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_jperazbo_uic.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
          } else { // Else
            /* If _dataread > qbe_jperazbo_uic->DATAOPE */
            if (CPLib.gt(_dataread,Cursor_qbe_jperazbo_uic.GetDate("DATAOPE"))) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_opex_massa",92,"00000073")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_jperazbo_uic.GetDate("DATAOPE"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_jperazbo_uic.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_jperazbo_uic.GetString("CONNESCLI"))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          Cursor_qbe_jperazbo_uic.Next();
        }
        m_cConnectivityError = Cursor_qbe_jperazbo_uic.ErrorMessage();
        Cursor_qbe_jperazbo_uic.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_age_ope_minmax!=null)
          Cursor_qbe_age_ope_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_jperazbo_uic!=null)
          Cursor_qbe_jperazbo_uic.Close();
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
      m_Caller.SetString("flgoef","C",1,0,w_flgoef);
      m_Caller.SetString("flgoag","C",1,0,w_flgoag);
      m_Caller.SetString("flgdel","C",1,0,w_flgdel);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_opex_massaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_opex_massaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_flgoef = m_Caller.GetString("flgoef","C",1,0);
    w_flgoag = m_Caller.GetString("flgoag","C",1,0);
    w_flgdel = m_Caller.GetString("flgdel","C",1,0);
    _max = 0;
    _min = 0;
    _top = 0;
    _bottom = 0;
    _cicli = 0;
    _contacilci = 0;
    _ctotale = 0;
    _anno = CPLib.Space(4);
    _annoread = CPLib.Space(4);
    _dataread = CPLib.NullDate();
    _prog = CPLib.Space(10);
    _conta = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_uic_ope_minmax,qbe_operazbo_uic,qbe_uic_frz_minmax,qbe_fraziobo_uic,qbe_age_ope_minmax,qbe_jperazbo_uic,
  public static final String m_cVQRList = ",qbe_uic_ope_minmax,qbe_operazbo_uic,qbe_uic_frz_minmax,qbe_fraziobo_uic,qbe_age_ope_minmax,qbe_jperazbo_uic,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000037(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000054(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000071(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
}
