// * --- Area Manuale = BO - Header
// * --- arrt_pbprocessi
import java.lang.reflect.Method;
// * --- Fine Area Manuale
public class arrt_pbprocessiR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_bckprocessi;
  public String m_cServer_bckprocessi;
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
  public String _oldazi;
  public String _gAzienda;
  public String _valore;
  public String _tipov;
  public String _param;
  public String _routine;
  public double _nparam;
  public double _index;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_pbprocessi
  public Class[] paramTypes;
  public Object[] paramValues;
  // * --- Fine Area Manuale
  public arrt_pbprocessiR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_pbprocessi",m_Caller);
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_bckprocessi = p_ContextObject.GetPhName("bckprocessi");
    if (m_cPhName_bckprocessi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_bckprocessi = m_cPhName_bckprocessi+" "+m_Ctx.GetWritePhName("bckprocessi");
    }
    m_cServer_bckprocessi = p_ContextObject.GetServer("bckprocessi");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_nparam",p_cVarName)) {
      return _nparam;
    }
    if (CPLib.eqr("_index",p_cVarName)) {
      return _index;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_pbprocessi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_valore",p_cVarName)) {
      return _valore;
    }
    if (CPLib.eqr("_tipov",p_cVarName)) {
      return _tipov;
    }
    if (CPLib.eqr("_param",p_cVarName)) {
      return _param;
    }
    if (CPLib.eqr("_routine",p_cVarName)) {
      return _routine;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_nparam",p_cVarName)) {
      _nparam = value;
      return;
    }
    if (CPLib.eqr("_index",p_cVarName)) {
      _index = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_valore",p_cVarName)) {
      _valore = value;
      return;
    }
    if (CPLib.eqr("_tipov",p_cVarName)) {
      _tipov = value;
      return;
    }
    if (CPLib.eqr("_param",p_cVarName)) {
      _param = value;
      return;
    }
    if (CPLib.eqr("_routine",p_cVarName)) {
      _routine = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_bckprocessi=null;
    try {
      /* _oldazi Char(10) */
      /* _gAzienda Char(10) // Azienda */
      /* _valore Char(128) */
      /* _tipov Char(1) */
      /* _param Char(130) */
      /* _routine Char(128) */
      /* _nparam Numeric(10, 0) */
      /* _index Numeric(2, 0) */
      /* Utilities.SetUserCode(1) */
      Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
      /* _oldazi := Utilities.GetCompany() */
      _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      /* Info Msg 'Lancio Verifica Processi' */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log(CPLib.FormatMsg(m_Ctx,"Lancio Verifica Processi"));
      }
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
        /* _nparam := 0 */
        _nparam = CPLib.Round(0,0);
        /* _routine := '' */
        _routine = "";
        // * --- Select from bckprocessi
        m_cServer = m_Ctx.GetServer("bckprocessi");
        m_cPhName = m_Ctx.GetPhName("bckprocessi");
        if (Cursor_bckprocessi!=null)
          Cursor_bckprocessi.Close();
        Cursor_bckprocessi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PBSTATO='N' "+")"+(m_Ctx.IsSharedTemp("bckprocessi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_bckprocessi.Eof())) {
          /* _nparam := bckprocessi->PBNUMPAR */
          _nparam = CPLib.Round(Cursor_bckprocessi.GetDouble("PBNUMPAR"),0);
          /* _routine := LRTrim(bckprocessi->PBSERVLET)+"R" */
          _routine = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBSERVLET"))+"R";
          // Crea array per i parametri     			
          paramTypes=new Class[(int)_nparam];
          paramValues=new Object[(int)_nparam];
          /* If bckprocessi->PBNUMPAR >= 1 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),1)) {
            /* _index := 0 */
            _index = CPLib.Round(0,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM01) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM01"));
            /* _tipov := bckprocessi->PBTIPOP01 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP01");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 2 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),2)) {
            /* _index := 1 */
            _index = CPLib.Round(1,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM02) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM02"));
            /* _tipov := bckprocessi->PBTIPOP02 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP02");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 3 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),3)) {
            /* _index := 2 */
            _index = CPLib.Round(2,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM03) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM03"));
            /* _tipov := bckprocessi->PBTIPOP03 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP03");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 4 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),4)) {
            /* _index := 3 */
            _index = CPLib.Round(3,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM04) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM04"));
            /* _tipov := bckprocessi->PBTIPOP04 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP04");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 5 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),5)) {
            /* _index := 4 */
            _index = CPLib.Round(4,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM05) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM05"));
            /* _tipov := bckprocessi->PBTIPOP05 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP05");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 6 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),6)) {
            /* _index := 5 */
            _index = CPLib.Round(5,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM06) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM06"));
            /* _tipov := bckprocessi->PBTIPOP06 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP06");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 7 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),7)) {
            /* _index := 6 */
            _index = CPLib.Round(6,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM07) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM07"));
            /* _tipov := bckprocessi->PBTIPOP07 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP07");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 8 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),8)) {
            /* _index := 7 */
            _index = CPLib.Round(7,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM08) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM08"));
            /* _tipov := bckprocessi->PBTIPOP08 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP08");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 9 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),9)) {
            /* _index := 8 */
            _index = CPLib.Round(8,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM09) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM09"));
            /* _tipov := bckprocessi->PBTIPOP09 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP09");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 10 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),10)) {
            /* _index := 9 */
            _index = CPLib.Round(9,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM10) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM10"));
            /* _tipov := bckprocessi->PBTIPOP10 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP10");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 11 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),11)) {
            /* _index := 10 */
            _index = CPLib.Round(10,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM11) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM11"));
            /* _tipov := bckprocessi->PBTIPOP11 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP11");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 12 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),12)) {
            /* _index := 11 */
            _index = CPLib.Round(11,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM12) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM12"));
            /* _tipov := bckprocessi->PBTIPOP12 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP12");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 13 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),13)) {
            /* _index := 12 */
            _index = CPLib.Round(12,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM13) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM13"));
            /* _tipov := bckprocessi->PBTIPOP13 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP13");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 14 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),14)) {
            /* _index := 13 */
            _index = CPLib.Round(13,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM14) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM14"));
            /* _tipov := bckprocessi->PBTIPOP14 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP14");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 15 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),15)) {
            /* _index := 14 */
            _index = CPLib.Round(14,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM15) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM15"));
            /* _tipov := bckprocessi->PBTIPOP15 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP15");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 16 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),16)) {
            /* _index := 15 */
            _index = CPLib.Round(15,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM16) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM16"));
            /* _tipov := bckprocessi->PBTIPOP16 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP16");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 17 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),17)) {
            /* _index := 16 */
            _index = CPLib.Round(16,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM17) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM17"));
            /* _tipov := bckprocessi->PBTIPOP17 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP17");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 18 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),18)) {
            /* _index := 17 */
            _index = CPLib.Round(17,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM18) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM18"));
            /* _tipov := bckprocessi->PBTIPOP18 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP18");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 19 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),19)) {
            /* _index := 18 */
            _index = CPLib.Round(18,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM19) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM19"));
            /* _tipov := bckprocessi->PBTIPOP19 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP19");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 20 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),20)) {
            /* _index := 19 */
            _index = CPLib.Round(19,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM20) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM20"));
            /* _tipov := bckprocessi->PBTIPOP20 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP20");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 21 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),21)) {
            /* _index := 20 */
            _index = CPLib.Round(20,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM21) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM21"));
            /* _tipov := bckprocessi->PBTIPOP21 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP21");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 22 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),22)) {
            /* _index := 21 */
            _index = CPLib.Round(21,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM22) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM22"));
            /* _tipov := bckprocessi->PBTIPOP22 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP22");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 23 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),23)) {
            /* _index := 22 */
            _index = CPLib.Round(22,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM23) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM23"));
            /* _tipov := bckprocessi->PBTIPOP23 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP23");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 24 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),24)) {
            /* _index := 23 */
            _index = CPLib.Round(23,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM24) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM24"));
            /* _tipov := bckprocessi->PBTIPOP24 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP24");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 25 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),25)) {
            /* _index := 24 */
            _index = CPLib.Round(24,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM25) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM25"));
            /* _tipov := bckprocessi->PBTIPOP25 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP25");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 26 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),26)) {
            /* _index := 25 */
            _index = CPLib.Round(25,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM26) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM26"));
            /* _tipov := bckprocessi->PBTIPOP26 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP26");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 27 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),27)) {
            /* _index := 26 */
            _index = CPLib.Round(26,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM27) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM27"));
            /* _tipov := bckprocessi->PBTIPOP27 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP27");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 28 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),28)) {
            /* _index := 27 */
            _index = CPLib.Round(27,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM28) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM28"));
            /* _tipov := bckprocessi->PBTIPOP28 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP28");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 29 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),29)) {
            /* _index := 28 */
            _index = CPLib.Round(28,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM29) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM29"));
            /* _tipov := bckprocessi->PBTIPOP29 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP29");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 30 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),30)) {
            /* _index := 29 */
            _index = CPLib.Round(29,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM30) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM30"));
            /* _tipov := bckprocessi->PBTIPOP30 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP30");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 31 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),31)) {
            /* _index := 30 */
            _index = CPLib.Round(30,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM31) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM31"));
            /* _tipov := bckprocessi->PBTIPOP31 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP31");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 32 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),32)) {
            /* _index := 31 */
            _index = CPLib.Round(31,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM32) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM32"));
            /* _tipov := bckprocessi->PBTIPOP32 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP32");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 33 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),33)) {
            /* _index := 32 */
            _index = CPLib.Round(32,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM33) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM33"));
            /* _tipov := bckprocessi->PBTIPOP33 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP33");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR >= 34 */
          if (CPLib.ge(Cursor_bckprocessi.GetDouble("PBNUMPAR"),34)) {
            /* _index := 33 */
            _index = CPLib.Round(33,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM34) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM34"));
            /* _tipov := bckprocessi->PBTIPOP34 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP34");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          /* If bckprocessi->PBNUMPAR = 35 */
          if (CPLib.eqr(Cursor_bckprocessi.GetDouble("PBNUMPAR"),35)) {
            /* _index := 34 */
            _index = CPLib.Round(34,0);
            /* _valore := LRTrim(bckprocessi->PBPARAM35) */
            _valore = CPLib.LRTrim(Cursor_bckprocessi.GetString("PBPARAM35"));
            /* _tipov := bckprocessi->PBTIPOP35 */
            _tipov = Cursor_bckprocessi.GetString("PBTIPOP35");
            /* Exec "Costruisce passaggio parametro" Page 2:Page_2 */
            Page_2();
          } // End If
          // * --- Write into bckprocessi from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("bckprocessi");
          m_cPhName = m_Ctx.GetPhName("bckprocessi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"bckprocessi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_pbprocessi",64,"000000C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PBSTATO = "+CPLib.ToSQL("E","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"bckprocessi",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"PBCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_bckprocessi.GetString("PBCODICE"),"?",0,0,m_cServer),m_cServer,Cursor_bckprocessi.GetString("PBCODICE"))+"";
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
          //Tenta di lanciare la routine
          try {
            System.out.println(_routine);
            Class objToStart = Class.forName(_routine);
                     
            Class[] makeParTypes=new Class[2];
            makeParTypes[0]=CPContext.class;
            makeParTypes[1]=Caller.class;
            Method Make = objToStart.getMethod("Make",makeParTypes);
          							
            Object[] makeParms=new Object[2];
            makeParms[0]=m_Ctx;
            makeParms[1]=m_Caller;
            
            Object objToStartO = Make.invoke(null,makeParms);
            Method objToStartR=objToStart.getMethod("RunAsync",paramTypes);
            String m_cLastAsyncRoutineRun = (String)(objToStartR.invoke(objToStartO,paramValues));
          
          } catch(Exception e) {
          
            System.out.println(e.toString());
          
          }
          /* Utilities.SetTimeout(1440) */
          Utilities.Make(m_Ctx,m_Caller).SetTimeout(1440);
          Cursor_bckprocessi.Next();
        }
        m_cConnectivityError = Cursor_bckprocessi.ErrorMessage();
        Cursor_bckprocessi.Close();
        // * --- End Select
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(_oldazi) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_bckprocessi!=null)
          Cursor_bckprocessi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Case _tipov='C' */
    if (CPLib.eqr(_tipov,"C")) {
      // Crea array per i parametri     			
      paramTypes[(int)_index]=String.class;
      paramValues[(int)_index]=CPLib.LRTrim(_valore);
      /* Case _tipov='D' */
    } else if (CPLib.eqr(_tipov,"D")) {
      // Crea array per i parametri     			
      paramTypes[(int)_index]=java.sql.Date.class;
      paramValues[(int)_index]=CPLib.CharToDate(_valore);
      /* Case _tipov='N' */
    } else if (CPLib.eqr(_tipov,"N")) {
      // Crea array per i parametri     			
      paramTypes[(int)_index]=double.class;
      paramValues[(int)_index]=CPLib.Val(_valore);
    } // End Case
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_pbprocessiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_pbprocessiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _oldazi = CPLib.Space(10);
    _gAzienda = CPLib.Space(10);
    _valore = CPLib.Space(128);
    _tipov = CPLib.Space(1);
    _param = CPLib.Space(130);
    _routine = CPLib.Space(128);
    _nparam = 0;
    _index = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
