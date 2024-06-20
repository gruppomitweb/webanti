// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_import_3dceR implements CallerWithObjs {
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
  public String m_cPhName_tbareegeog;
  public String m_cServer_tbareegeog;
  public String m_cPhName_tbcondotta;
  public String m_cServer_tbcondotta;
  public String m_cPhName_tbplauso;
  public String m_cServer_tbplauso;
  public String m_cPhName_tbspecie;
  public String m_cServer_tbspecie;
  public String m_cPhName_tbsvolgim;
  public String m_cServer_tbsvolgim;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public String m_cPhName_tbtiporisc;
  public String m_cServer_tbtiporisc;
  public String m_cPhName_tbdurata;
  public String m_cServer_tbdurata;
  public String m_cPhName_tbimporto;
  public String m_cServer_tbimporto;
  public String m_cPhName_tbareegeog_p;
  public String m_cServer_tbareegeog_p;
  public String m_cPhName_tbcondotta_p;
  public String m_cServer_tbcondotta_p;
  public String m_cPhName_tbplauso_p;
  public String m_cServer_tbplauso_p;
  public String m_cPhName_tbspecie_p;
  public String m_cServer_tbspecie_p;
  public String m_cPhName_tbsvolgim_p;
  public String m_cServer_tbsvolgim_p;
  public String m_cPhName_tbtipatt_p;
  public String m_cServer_tbtipatt_p;
  public String m_cPhName_tbtiporisc_p;
  public String m_cServer_tbtiporisc_p;
  public String m_cPhName_tbdurata_p;
  public String m_cServer_tbdurata_p;
  public String m_cPhName_tbimporto_p;
  public String m_cServer_tbimporto_p;
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
  public String w_tbareegeog;
  public String w_tbspecie;
  public String w_tbtiporisc;
  public String w_tbsvolgim;
  public String w_tbcondotta;
  public String w_tbimporto;
  public String w_tbdurata;
  public String w_tbplauso;
  public String w_tbtipatt;
  public String fhand;
  public String riga;
  public String _flgpers;
  public String _code5;
  public String _code4;
  public String _code3;
  public String _code10;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_import_3dce
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arfn_import_3dceR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_import_3dce",m_Caller);
    m_cPhName_tbareegeog = p_ContextObject.GetPhName("tbareegeog");
    if (m_cPhName_tbareegeog.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbareegeog = m_cPhName_tbareegeog+" "+m_Ctx.GetWritePhName("tbareegeog");
    }
    m_cServer_tbareegeog = p_ContextObject.GetServer("tbareegeog");
    m_cPhName_tbcondotta = p_ContextObject.GetPhName("tbcondotta");
    if (m_cPhName_tbcondotta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcondotta = m_cPhName_tbcondotta+" "+m_Ctx.GetWritePhName("tbcondotta");
    }
    m_cServer_tbcondotta = p_ContextObject.GetServer("tbcondotta");
    m_cPhName_tbplauso = p_ContextObject.GetPhName("tbplauso");
    if (m_cPhName_tbplauso.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbplauso = m_cPhName_tbplauso+" "+m_Ctx.GetWritePhName("tbplauso");
    }
    m_cServer_tbplauso = p_ContextObject.GetServer("tbplauso");
    m_cPhName_tbspecie = p_ContextObject.GetPhName("tbspecie");
    if (m_cPhName_tbspecie.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbspecie = m_cPhName_tbspecie+" "+m_Ctx.GetWritePhName("tbspecie");
    }
    m_cServer_tbspecie = p_ContextObject.GetServer("tbspecie");
    m_cPhName_tbsvolgim = p_ContextObject.GetPhName("tbsvolgim");
    if (m_cPhName_tbsvolgim.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsvolgim = m_cPhName_tbsvolgim+" "+m_Ctx.GetWritePhName("tbsvolgim");
    }
    m_cServer_tbsvolgim = p_ContextObject.GetServer("tbsvolgim");
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    if (m_cPhName_tbtipatt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipatt = m_cPhName_tbtipatt+" "+m_Ctx.GetWritePhName("tbtipatt");
    }
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_cPhName_tbtiporisc = p_ContextObject.GetPhName("tbtiporisc");
    if (m_cPhName_tbtiporisc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtiporisc = m_cPhName_tbtiporisc+" "+m_Ctx.GetWritePhName("tbtiporisc");
    }
    m_cServer_tbtiporisc = p_ContextObject.GetServer("tbtiporisc");
    m_cPhName_tbdurata = p_ContextObject.GetPhName("tbdurata");
    if (m_cPhName_tbdurata.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbdurata = m_cPhName_tbdurata+" "+m_Ctx.GetWritePhName("tbdurata");
    }
    m_cServer_tbdurata = p_ContextObject.GetServer("tbdurata");
    m_cPhName_tbimporto = p_ContextObject.GetPhName("tbimporto");
    if (m_cPhName_tbimporto.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbimporto = m_cPhName_tbimporto+" "+m_Ctx.GetWritePhName("tbimporto");
    }
    m_cServer_tbimporto = p_ContextObject.GetServer("tbimporto");
    m_cPhName_tbareegeog_p = p_ContextObject.GetPhName("tbareegeog_p");
    if (m_cPhName_tbareegeog_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbareegeog_p = m_cPhName_tbareegeog_p+" "+m_Ctx.GetWritePhName("tbareegeog_p");
    }
    m_cServer_tbareegeog_p = p_ContextObject.GetServer("tbareegeog_p");
    m_cPhName_tbcondotta_p = p_ContextObject.GetPhName("tbcondotta_p");
    if (m_cPhName_tbcondotta_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcondotta_p = m_cPhName_tbcondotta_p+" "+m_Ctx.GetWritePhName("tbcondotta_p");
    }
    m_cServer_tbcondotta_p = p_ContextObject.GetServer("tbcondotta_p");
    m_cPhName_tbplauso_p = p_ContextObject.GetPhName("tbplauso_p");
    if (m_cPhName_tbplauso_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbplauso_p = m_cPhName_tbplauso_p+" "+m_Ctx.GetWritePhName("tbplauso_p");
    }
    m_cServer_tbplauso_p = p_ContextObject.GetServer("tbplauso_p");
    m_cPhName_tbspecie_p = p_ContextObject.GetPhName("tbspecie_p");
    if (m_cPhName_tbspecie_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbspecie_p = m_cPhName_tbspecie_p+" "+m_Ctx.GetWritePhName("tbspecie_p");
    }
    m_cServer_tbspecie_p = p_ContextObject.GetServer("tbspecie_p");
    m_cPhName_tbsvolgim_p = p_ContextObject.GetPhName("tbsvolgim_p");
    if (m_cPhName_tbsvolgim_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsvolgim_p = m_cPhName_tbsvolgim_p+" "+m_Ctx.GetWritePhName("tbsvolgim_p");
    }
    m_cServer_tbsvolgim_p = p_ContextObject.GetServer("tbsvolgim_p");
    m_cPhName_tbtipatt_p = p_ContextObject.GetPhName("tbtipatt_p");
    if (m_cPhName_tbtipatt_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipatt_p = m_cPhName_tbtipatt_p+" "+m_Ctx.GetWritePhName("tbtipatt_p");
    }
    m_cServer_tbtipatt_p = p_ContextObject.GetServer("tbtipatt_p");
    m_cPhName_tbtiporisc_p = p_ContextObject.GetPhName("tbtiporisc_p");
    if (m_cPhName_tbtiporisc_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtiporisc_p = m_cPhName_tbtiporisc_p+" "+m_Ctx.GetWritePhName("tbtiporisc_p");
    }
    m_cServer_tbtiporisc_p = p_ContextObject.GetServer("tbtiporisc_p");
    m_cPhName_tbdurata_p = p_ContextObject.GetPhName("tbdurata_p");
    if (m_cPhName_tbdurata_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbdurata_p = m_cPhName_tbdurata_p+" "+m_Ctx.GetWritePhName("tbdurata_p");
    }
    m_cServer_tbdurata_p = p_ContextObject.GetServer("tbdurata_p");
    m_cPhName_tbimporto_p = p_ContextObject.GetPhName("tbimporto_p");
    if (m_cPhName_tbimporto_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbimporto_p = m_cPhName_tbimporto_p+" "+m_Ctx.GetWritePhName("tbimporto_p");
    }
    m_cServer_tbimporto_p = p_ContextObject.GetServer("tbimporto_p");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_import_3dce";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tbareegeog",p_cVarName)) {
      return w_tbareegeog;
    }
    if (CPLib.eqr("tbspecie",p_cVarName)) {
      return w_tbspecie;
    }
    if (CPLib.eqr("tbtiporisc",p_cVarName)) {
      return w_tbtiporisc;
    }
    if (CPLib.eqr("tbsvolgim",p_cVarName)) {
      return w_tbsvolgim;
    }
    if (CPLib.eqr("tbcondotta",p_cVarName)) {
      return w_tbcondotta;
    }
    if (CPLib.eqr("tbimporto",p_cVarName)) {
      return w_tbimporto;
    }
    if (CPLib.eqr("tbdurata",p_cVarName)) {
      return w_tbdurata;
    }
    if (CPLib.eqr("tbplauso",p_cVarName)) {
      return w_tbplauso;
    }
    if (CPLib.eqr("tbtipatt",p_cVarName)) {
      return w_tbtipatt;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_flgpers",p_cVarName)) {
      return _flgpers;
    }
    if (CPLib.eqr("_code5",p_cVarName)) {
      return _code5;
    }
    if (CPLib.eqr("_code4",p_cVarName)) {
      return _code4;
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      return _code3;
    }
    if (CPLib.eqr("_code10",p_cVarName)) {
      return _code10;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tbareegeog",p_cVarName)) {
      w_tbareegeog = value;
      return;
    }
    if (CPLib.eqr("tbspecie",p_cVarName)) {
      w_tbspecie = value;
      return;
    }
    if (CPLib.eqr("tbtiporisc",p_cVarName)) {
      w_tbtiporisc = value;
      return;
    }
    if (CPLib.eqr("tbsvolgim",p_cVarName)) {
      w_tbsvolgim = value;
      return;
    }
    if (CPLib.eqr("tbcondotta",p_cVarName)) {
      w_tbcondotta = value;
      return;
    }
    if (CPLib.eqr("tbimporto",p_cVarName)) {
      w_tbimporto = value;
      return;
    }
    if (CPLib.eqr("tbdurata",p_cVarName)) {
      w_tbdurata = value;
      return;
    }
    if (CPLib.eqr("tbplauso",p_cVarName)) {
      w_tbplauso = value;
      return;
    }
    if (CPLib.eqr("tbtipatt",p_cVarName)) {
      w_tbtipatt = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_flgpers",p_cVarName)) {
      _flgpers = value;
      return;
    }
    if (CPLib.eqr("_code5",p_cVarName)) {
      _code5 = value;
      return;
    }
    if (CPLib.eqr("_code4",p_cVarName)) {
      _code4 = value;
      return;
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      _code3 = value;
      return;
    }
    if (CPLib.eqr("_code10",p_cVarName)) {
      _code10 = value;
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
    /* Dichiarazione variabili del caller */
    /* w_tbareegeog Char(1) */
    /* w_tbspecie Char(1) */
    /* w_tbtiporisc Char(1) */
    /* w_tbsvolgim Char(1) */
    /* w_tbcondotta Char(1) */
    /* w_tbimporto Char(1) */
    /* w_tbdurata Char(1) */
    /* w_tbplauso Char(1) */
    /* w_tbtipatt Char(1) */
    /* Definizione variabili locali */
    /* fhand Char(1) */
    /* riga Memo */
    /* _flgpers Char(1) */
    /* _code5 Char(5) */
    /* _code4 Char(4) */
    /* _code3 Char(3) */
    /* _code10 Char(10) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Char(120) */
    /* Lancia la pagina appropriata */
    /* If w_tbareegeog='S' */
    if (CPLib.eqr(w_tbareegeog,"S")) {
      /* Exec "Aree Geografiche" Page 2:Page_2 */
      Page_2();
    } // End If
    /* If w_tbcondotta='S' */
    if (CPLib.eqr(w_tbcondotta,"S")) {
      /* Exec "Condotta" Page 3:Page_3 */
      Page_3();
    } // End If
    /* If w_tbplauso='S' */
    if (CPLib.eqr(w_tbplauso,"S")) {
      /* Exec "Plauso" Page 4:Page_4 */
      Page_4();
    } // End If
    /* If w_tbspecie='S' */
    if (CPLib.eqr(w_tbspecie,"S")) {
      /* Exec "Specie Giuridica" Page 5:Page_5 */
      Page_5();
    } // End If
    /* If w_tbsvolgim='S' */
    if (CPLib.eqr(w_tbsvolgim,"S")) {
      /* Exec "Svolgimento" Page 6:Page_6 */
      Page_6();
    } // End If
    /* If w_tbtipatt='S' */
    if (CPLib.eqr(w_tbtipatt,"S")) {
      /* Exec "Tipo Attività" Page 7:Page_7 */
      Page_7();
    } // End If
    /* If w_tbtiporisc='S' */
    if (CPLib.eqr(w_tbtiporisc,"S")) {
      /* Exec "Tipo Rischio" Page 8:Page_8 */
      Page_8();
    } // End If
    /* If w_tbdurata='S' */
    if (CPLib.eqr(w_tbdurata,"S")) {
      /* Exec "Durata" Page 9:Page_9 */
      Page_9();
    } // End If
    /* If w_tbimporto='S' */
    if (CPLib.eqr(w_tbimporto,"S")) {
      /* Exec "Importo" Page 10:Page_10 */
      Page_10();
    } // End If
    /* gMsgImp := 'ELABORAZIONE TERMINATA' */
    gMsgImp = "ELABORAZIONE TERMINATA";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbareegeog.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbareegeog.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbareegeog.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbareegeog.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBAREEGEOG - Inserimento codice '+ Left(riga,5) */
          gMsgImp = "TBAREEGEOG - Inserimento codice "+CPLib.Left(riga,5);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry00000033status;
          nTry00000033status = m_Sql.GetTransactionStatus();
          String cTry00000033msg;
          cTry00000033msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbareegeog from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbareegeog");
            m_cPhName = m_Ctx.GetPhName("tbareegeog");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbareegeog",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,67,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,70,1),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,71,8)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbareegeog",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbareegeog from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbareegeog");
            m_cPhName = m_Ctx.GetPhName("tbareegeog");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbareegeog",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000036")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,50),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,67,3)),"N",3,0)+", ";
            m_cSql = m_cSql+"NONCOOP = "+CPLib.ToSQL(CPLib.Substr(riga,70,1),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"ELNONCOP = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,71,8)),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbareegeog",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000033status,0)) {
              m_Sql.SetTransactionStatus(nTry00000033status,cTry00000033msg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code5 := '' */
          _code5 = "";
          // * --- Read from tbareegeog_p
          m_cServer = m_Ctx.GetServer("tbareegeog_p");
          m_cPhName = m_Ctx.GetPhName("tbareegeog_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5));
          if (m_Ctx.IsSharedTemp("tbareegeog_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code5 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbareegeog_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code5 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code5)) */
          if (CPLib.Empty(CPLib.LRTrim(_code5))) {
            // * --- Insert into tbareegeog_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbareegeog_p");
            m_cPhName = m_Ctx.GetPhName("tbareegeog_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbareegeog_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000003B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,67,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbareegeog_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbareegeog_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbareegeog_p");
              m_cPhName = m_Ctx.GetPhName("tbareegeog_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbareegeog_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000003D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,67,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbareegeog_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbareegeog.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbareegeog.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
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
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcondotta.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcondotta.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbcondotta.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbcondotta.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBCONDOTTA - Inserimento codice '+ Left(riga,5) */
          gMsgImp = "TBCONDOTTA - Inserimento codice "+CPLib.Left(riga,5);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry00000047status;
          nTry00000047status = m_Sql.GetTransactionStatus();
          String cTry00000047msg;
          cTry00000047msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbcondotta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbcondotta");
            m_cPhName = m_Ctx.GetPhName("tbcondotta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcondotta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000048")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000048(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,200),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcondotta",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbcondotta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbcondotta");
            m_cPhName = m_Ctx.GetPhName("tbcondotta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcondotta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,200),"C",200,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcondotta",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000047status,0)) {
              m_Sql.SetTransactionStatus(nTry00000047status,cTry00000047msg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code5 := '' */
          _code5 = "";
          // * --- Read from tbcondotta_p
          m_cServer = m_Ctx.GetServer("tbcondotta_p");
          m_cPhName = m_Ctx.GetPhName("tbcondotta_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5));
          if (m_Ctx.IsSharedTemp("tbcondotta_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code5 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcondotta_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code5 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code5)) */
          if (CPLib.Empty(CPLib.LRTrim(_code5))) {
            // * --- Insert into tbcondotta_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbcondotta_p");
            m_cPhName = m_Ctx.GetPhName("tbcondotta_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcondotta_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000004F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000004F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbcondotta_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbcondotta_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbcondotta_p");
              m_cPhName = m_Ctx.GetPhName("tbcondotta_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcondotta_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000051")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbcondotta_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbcondotta.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbcondotta.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
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
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbplauso.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbplauso.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbplauso.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbplauso.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBPLAUSO - Inserimento codice '+ Left(riga,5) */
          gMsgImp = "TBPLAUSO - Inserimento codice "+CPLib.Left(riga,5);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry0000005Bstatus;
          nTry0000005Bstatus = m_Sql.GetTransactionStatus();
          String cTry0000005Bmsg;
          cTry0000005Bmsg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbplauso from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbplauso");
            m_cPhName = m_Ctx.GetPhName("tbplauso");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbplauso",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000005C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,200),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbplauso",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbplauso from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbplauso");
            m_cPhName = m_Ctx.GetPhName("tbplauso");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbplauso",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000005E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,200),"C",200,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbplauso",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000005Bstatus,0)) {
              m_Sql.SetTransactionStatus(nTry0000005Bstatus,cTry0000005Bmsg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code5 := '' */
          _code5 = "";
          // * --- Read from tbplauso_p
          m_cServer = m_Ctx.GetServer("tbplauso_p");
          m_cPhName = m_Ctx.GetPhName("tbplauso_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5));
          if (m_Ctx.IsSharedTemp("tbplauso_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code5 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbplauso_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code5 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code5)) */
          if (CPLib.Empty(CPLib.LRTrim(_code5))) {
            // * --- Insert into tbplauso_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbplauso_p");
            m_cPhName = m_Ctx.GetPhName("tbplauso_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbplauso_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000063")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000063(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbplauso_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbplauso_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbplauso_p");
              m_cPhName = m_Ctx.GetPhName("tbplauso_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbplauso_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbplauso_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbplauso.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbplauso.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbspecie.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbspecie.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbspecie.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbspecie.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBSPECIE - Inserimento codice '+ Left(riga,4) */
          gMsgImp = "TBSPECIE - Inserimento codice "+CPLib.Left(riga,4);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry0000006Fstatus;
          nTry0000006Fstatus = m_Sql.GetTransactionStatus();
          String cTry0000006Fmsg;
          cTry0000006Fmsg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbspecie from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbspecie");
            m_cPhName = m_Ctx.GetPhName("tbspecie");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbspecie",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,4),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,5,60),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,76,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbspecie",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbspecie from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbspecie");
            m_cPhName = m_Ctx.GetPhName("tbspecie");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbspecie",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000072")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,5,60),"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,76,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbspecie",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODSPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,4),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,4))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000006Fstatus,0)) {
              m_Sql.SetTransactionStatus(nTry0000006Fstatus,cTry0000006Fmsg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code4 := '' */
          _code4 = "";
          // * --- Read from tbspecie_p
          m_cServer = m_Ctx.GetServer("tbspecie_p");
          m_cPhName = m_Ctx.GetPhName("tbspecie_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODSPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,1,4));
          if (m_Ctx.IsSharedTemp("tbspecie_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODSPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code4 = Read_Cursor.GetString("CODSPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbspecie_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code4 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code4)) */
          if (CPLib.Empty(CPLib.LRTrim(_code4))) {
            // * --- Insert into tbspecie_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbspecie_p");
            m_cPhName = m_Ctx.GetPhName("tbspecie_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbspecie_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000077")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000077(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,4),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,76,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbspecie_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbspecie_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbspecie_p");
              m_cPhName = m_Ctx.GetPhName("tbspecie_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbspecie_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000079")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,76,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbspecie_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODSPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,4),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,4))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbspecie.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbspecie.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbsvolgim.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbsvolgim.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbsvolgim.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbsvolgim.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBSVOLGIM - Inserimento codice '+ Left(riga,5) */
          gMsgImp = "TBSVOLGIM - Inserimento codice "+CPLib.Left(riga,5);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry00000083status;
          nTry00000083status = m_Sql.GetTransactionStatus();
          String cTry00000083msg;
          cTry00000083msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbsvolgim from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbsvolgim");
            m_cPhName = m_Ctx.GetPhName("tbsvolgim");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsvolgim",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000084")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000084(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,200),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbsvolgim",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbsvolgim from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbsvolgim");
            m_cPhName = m_Ctx.GetPhName("tbsvolgim");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsvolgim",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000086")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,200),"C",200,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbsvolgim",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000083status,0)) {
              m_Sql.SetTransactionStatus(nTry00000083status,cTry00000083msg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code5 := '' */
          _code5 = "";
          // * --- Read from tbsvolgim_p
          m_cServer = m_Ctx.GetServer("tbsvolgim_p");
          m_cPhName = m_Ctx.GetPhName("tbsvolgim_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5));
          if (m_Ctx.IsSharedTemp("tbsvolgim_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code5 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbsvolgim_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code5 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code5)) */
          if (CPLib.Empty(CPLib.LRTrim(_code5))) {
            // * --- Insert into tbsvolgim_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbsvolgim_p");
            m_cPhName = m_Ctx.GetPhName("tbsvolgim_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsvolgim_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000008B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbsvolgim_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbsvolgim_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbsvolgim_p");
              m_cPhName = m_Ctx.GetPhName("tbsvolgim_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbsvolgim_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000008D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbsvolgim_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbsvolgim.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbsvolgim.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipatt.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipatt.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbtipatt.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbtipatt.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBTIPATT - Inserimento codice '+ Left(riga,10) */
          gMsgImp = "TBTIPATT - Inserimento codice "+CPLib.Left(riga,10);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Merge into tbtipatt from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbtipatt");
          m_cPhName = m_Ctx.GetPhName("tbtipatt");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipatt",m_Ctx.GetCompany());
          m_cQuery = "select ";
          m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,1,10)),"?",0,0)+" as CODICE";
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
            m_cQuery = m_cQuery+" from dual";
          }
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cWhere = "tbtipatt.CODICE = cptmp_1xab23.CODICE";
          m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000097")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" tbtipatt USING ";
            m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
            m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,11,250),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,261,3)),"N",3,0)+", ";
            m_cSql = m_cSql+"FLGALTO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,264,1)),"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipatt",true,true);
            m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
            m_cSql = m_cSql+GetFieldsName_00000097(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,1,10)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,11,250),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,261,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,264,1)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipatt",true);
            m_cSql = m_cSql+")";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = m_cSql+";";
            }
          } else {
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000097")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,11,250),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,261,3)),"N",3,0)+", ";
            m_cSql = m_cSql+"FLGALTO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,264,1)),"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipatt",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,1,10)),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Substr(riga,1,10)))+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.eqr(m_nUpdatedRows,0)) {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"00000097")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000097(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,1,10)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,11,250),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,261,3)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,264,1)),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipatt",true);
              m_cSql = m_cSql+")";
            } else {
              m_cSql = "";
            }
          }
          if ( ! (CPLib.Empty(m_cSql))) {
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          }
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code10 := '' */
          _code10 = "";
          // * --- Read from tbtipatt_p
          m_cServer = m_Ctx.GetServer("tbtipatt_p");
          m_cPhName = m_Ctx.GetPhName("tbtipatt_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(riga,1,10));
          if (m_Ctx.IsSharedTemp("tbtipatt_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code10 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbtipatt_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code10 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code10)) */
          if (CPLib.Empty(CPLib.LRTrim(_code10))) {
            // * --- Insert into tbtipatt_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbtipatt_p");
            m_cPhName = m_Ctx.GetPhName("tbtipatt_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipatt_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000009C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000009C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,1,10)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,261,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtipatt_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbtipatt_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbtipatt_p");
              m_cPhName = m_Ctx.GetPhName("tbtipatt_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtipatt_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"0000009E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,261,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtipatt_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,1,10)),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Substr(riga,1,10)))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtipatt.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtipatt.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtiporisc.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtiporisc.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbtiporisc.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbtiporisc.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBTIPORISC - Inserimento codice '+ Left(riga,3) */
          gMsgImp = "TBTIPORISC - Inserimento codice "+CPLib.Left(riga,3);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry000000A8status;
          nTry000000A8status = m_Sql.GetTransactionStatus();
          String cTry000000A8msg;
          cTry000000A8msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbtiporisc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbtiporisc");
            m_cPhName = m_Ctx.GetPhName("tbtiporisc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtiporisc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,100),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,104,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtiporisc",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbtiporisc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbtiporisc");
            m_cPhName = m_Ctx.GetPhName("tbtiporisc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtiporisc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000AB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,4,100),"C",100,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,104,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtiporisc",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,3),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,3))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000A8status,0)) {
              m_Sql.SetTransactionStatus(nTry000000A8status,cTry000000A8msg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code3 := '' */
          _code3 = "";
          // * --- Read from tbtiporisc_p
          m_cServer = m_Ctx.GetServer("tbtiporisc_p");
          m_cPhName = m_Ctx.GetPhName("tbtiporisc_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,1,3));
          if (m_Ctx.IsSharedTemp("tbtiporisc_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code3 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbtiporisc_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code3 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code3)) */
          if (CPLib.Empty(CPLib.LRTrim(_code3))) {
            // * --- Insert into tbtiporisc_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbtiporisc_p");
            m_cPhName = m_Ctx.GetPhName("tbtiporisc_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtiporisc_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000B0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000B0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,3),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,104,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbtiporisc_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbtiporisc_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbtiporisc_p");
              m_cPhName = m_Ctx.GetPhName("tbtiporisc_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbtiporisc_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000B2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,104,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbtiporisc_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,3),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,3))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbtiporisc.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbtiporisc.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbdurata.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbdurata.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbdurata.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbdurata.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBDURATA - Inserimento codice '+ Left(riga,5) */
          gMsgImp = "TBDURATA - Inserimento codice "+CPLib.Left(riga,5);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry000000BCstatus;
          nTry000000BCstatus = m_Sql.GetTransactionStatus();
          String cTry000000BCmsg;
          cTry000000BCmsg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbdurata from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbdurata");
            m_cPhName = m_Ctx.GetPhName("tbdurata");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbdurata",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000BD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000BD(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,200),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbdurata",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbdurata from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbdurata");
            m_cPhName = m_Ctx.GetPhName("tbdurata");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbdurata",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000BF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,200),"C",200,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbdurata",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000BCstatus,0)) {
              m_Sql.SetTransactionStatus(nTry000000BCstatus,cTry000000BCmsg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code5 := '' */
          _code5 = "";
          // * --- Read from tbdurata_p
          m_cServer = m_Ctx.GetServer("tbdurata_p");
          m_cPhName = m_Ctx.GetPhName("tbdurata_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5));
          if (m_Ctx.IsSharedTemp("tbdurata_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code5 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbdurata_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code5 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code5)) */
          if (CPLib.Empty(CPLib.LRTrim(_code5))) {
            // * --- Insert into tbdurata_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbdurata_p");
            m_cPhName = m_Ctx.GetPhName("tbdurata_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbdurata_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C4(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbdurata_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbdurata_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbdurata_p");
              m_cPhName = m_Ctx.GetPhName("tbdurata_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbdurata_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbdurata_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbdurata.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbdurata.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo ed importa le tabelle */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbimporto.txt' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbimporto.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('tabs3d/tbimporto.txt',"UTF-8") */
      fhand = FileLibMit.OpenRead("tabs3d/tbimporto.txt","UTF-8");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* gMsgImp := 'TBIMPORTO - Inserimento codice '+ Left(riga,5) */
          gMsgImp = "TBIMPORTO - Inserimento codice "+CPLib.Left(riga,5);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          double nTry000000D0status;
          nTry000000D0status = m_Sql.GetTransactionStatus();
          String cTry000000D0msg;
          cTry000000D0msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Insert into tbimporto from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbimporto");
            m_cPhName = m_Ctx.GetPhName("tbimporto");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbimporto",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D1(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,6,200),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbimporto",true);
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
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
            // * --- Write into tbimporto from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbimporto");
            m_cPhName = m_Ctx.GetPhName("tbimporto");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbimporto",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000D3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Substr(riga,6,200),"C",200,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbimporto",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000D0status,0)) {
              m_Sql.SetTransactionStatus(nTry000000D0status,cTry000000D0msg);
            }
          }
          /* _flgpers := '' */
          _flgpers = "";
          /* _code5 := '' */
          _code5 = "";
          // * --- Read from tbimporto_p
          m_cServer = m_Ctx.GetServer("tbimporto_p");
          m_cPhName = m_Ctx.GetPhName("tbimporto_p");
          m_cSql = "";
          m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5));
          if (m_Ctx.IsSharedTemp("tbimporto_p")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGPERS",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _flgpers = Read_Cursor.GetString("FLGPERS");
            _code5 = Read_Cursor.GetString("CODICE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbimporto_p into routine arfn_import_3dce returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _flgpers = "";
            _code5 = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_code5)) */
          if (CPLib.Empty(CPLib.LRTrim(_code5))) {
            // * --- Insert into tbimporto_p from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbimporto_p");
            m_cPhName = m_Ctx.GetPhName("tbimporto_p");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbimporto_p",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000D8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D8(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbimporto_p",true);
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
            /* If _flgpers='N' */
            if (CPLib.eqr(_flgpers,"N")) {
              // * --- Write into tbimporto_p from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tbimporto_p");
              m_cPhName = m_Ctx.GetPhName("tbimporto_p");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbimporto_p",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_import_3dce",466,"000000DA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"RISCHIO = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,217,3)),"N",3,0)+", ";
              m_cSql = m_cSql+"FLGPERS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbimporto_p",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,1,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(riga,1,5))+"";
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
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file tbimporto.txt' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file tbimporto.txt"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
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
  public String RunAsync(String p_w_tbareegeog,String p_w_tbspecie,String p_w_tbtiporisc,String p_w_tbsvolgim,String p_w_tbcondotta,String p_w_tbimporto,String p_w_tbdurata,String p_w_tbplauso,String p_w_tbtipatt) {
    w_tbareegeog = p_w_tbareegeog;
    w_tbspecie = p_w_tbspecie;
    w_tbtiporisc = p_w_tbtiporisc;
    w_tbsvolgim = p_w_tbsvolgim;
    w_tbcondotta = p_w_tbcondotta;
    w_tbimporto = p_w_tbimporto;
    w_tbdurata = p_w_tbdurata;
    w_tbplauso = p_w_tbplauso;
    w_tbtipatt = p_w_tbtipatt;
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
  public String Run(String p_w_tbareegeog,String p_w_tbspecie,String p_w_tbtiporisc,String p_w_tbsvolgim,String p_w_tbcondotta,String p_w_tbimporto,String p_w_tbdurata,String p_w_tbplauso,String p_w_tbtipatt) {
    w_tbareegeog = p_w_tbareegeog;
    w_tbspecie = p_w_tbspecie;
    w_tbtiporisc = p_w_tbtiporisc;
    w_tbsvolgim = p_w_tbsvolgim;
    w_tbcondotta = p_w_tbcondotta;
    w_tbimporto = p_w_tbimporto;
    w_tbdurata = p_w_tbdurata;
    w_tbplauso = p_w_tbplauso;
    w_tbtipatt = p_w_tbtipatt;
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
  public static arfn_import_3dceR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_import_3dceR(p_Ctx, p_Caller);
  }
  public static arfn_import_3dceR Make(CPContext p_Ctx) {
    return new arfn_import_3dceR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tbareegeog = CPLib.Space(1);
    w_tbspecie = CPLib.Space(1);
    w_tbtiporisc = CPLib.Space(1);
    w_tbsvolgim = CPLib.Space(1);
    w_tbcondotta = CPLib.Space(1);
    w_tbimporto = CPLib.Space(1);
    w_tbdurata = CPLib.Space(1);
    w_tbplauso = CPLib.Space(1);
    w_tbtipatt = CPLib.Space(1);
    fhand = CPLib.Space(1);
    riga = "";
    _flgpers = CPLib.Space(1);
    _code5 = CPLib.Space(5);
    _code4 = CPLib.Space(4);
    _code3 = CPLib.Space(3);
    _code10 = CPLib.Space(10);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arfn_import_3dce,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arfn_import_3dce,";
  public static String[] m_cRunParameterNames={"w_tbareegeog","w_tbspecie","w_tbtiporisc","w_tbsvolgim","w_tbcondotta","w_tbimporto","w_tbdurata","w_tbplauso","w_tbtipatt"};
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"NONCOOP,";
    p_cSql = p_cSql+"ELNONCOP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbareegeog",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbareegeog_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000048(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcondotta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbcondotta_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbplauso",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000063(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbplauso_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODSPE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbspecie",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000077(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODSPE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbspecie_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000084(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbsvolgim",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbsvolgim_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000097(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGALTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipatt",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtipatt_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtiporisc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbtiporisc_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbdurata",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbdurata_p",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbimporto",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODICE,";
    p_cSql = p_cSql+"RISCHIO,";
    p_cSql = p_cSql+"FLGPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbimporto_p",true);
    return p_cSql;
  }
}
