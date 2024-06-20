// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_datisog_solR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
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
  public String pCli;
  public java.sql.Date pDatOpe;
  public String pRap;
  public String pTRap;
  public String pTipoR;
  public String pRAE;
  public String pSTATO;
  public java.sql.Date pDatRet;
  public String cRitorno;
  public String _numsto;
  public String _ramate;
  public String _tipsot;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_datisog_solR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_datisog_sol",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
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
      return "arfn_datisog_sol";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCli",p_cVarName)) {
      return pCli;
    }
    if (CPLib.eqr("pRap",p_cVarName)) {
      return pRap;
    }
    if (CPLib.eqr("pTRap",p_cVarName)) {
      return pTRap;
    }
    if (CPLib.eqr("pTipoR",p_cVarName)) {
      return pTipoR;
    }
    if (CPLib.eqr("pRAE",p_cVarName)) {
      return pRAE;
    }
    if (CPLib.eqr("pSTATO",p_cVarName)) {
      return pSTATO;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      return _ramate;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      return _tipsot;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pDatRet",p_cVarName)) {
      return pDatRet;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCli",p_cVarName)) {
      pCli = value;
      return;
    }
    if (CPLib.eqr("pRap",p_cVarName)) {
      pRap = value;
      return;
    }
    if (CPLib.eqr("pTRap",p_cVarName)) {
      pTRap = value;
      return;
    }
    if (CPLib.eqr("pTipoR",p_cVarName)) {
      pTipoR = value;
      return;
    }
    if (CPLib.eqr("pRAE",p_cVarName)) {
      pRAE = value;
      return;
    }
    if (CPLib.eqr("pSTATO",p_cVarName)) {
      pSTATO = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      _ramate = value;
      return;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      _tipsot = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pDatRet",p_cVarName)) {
      pDatRet = value;
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
    /* pCli Char(16) // Codice Soggetto */
    /* pDatOpe Date // Data Operazione */
    /* pRap Char(25) // Codice Rapporto */
    /* pTRap Char(1) // Tipo Rapporto */
    /* pTipoR Char(1) // Tipo Riga */
    /* pRAE Char(1) // RAE o ATECO */
    /* pSTATO Char(1) // Stato Registrazione */
    /* pDatRet Date // Data Rettifica */
    /* cRitorno Memo // Stringa di ritorno */
    /* _numsto Char(15) */
    /* _ramate Char(3) */
    /* _tipsot Char(1) */
    /* Verifica il tipo riga */
    /* cRitorno := '' // Stringa di ritorno */
    cRitorno = "";
    /* Case pTipoR='2' or pTipoR='7' */
    if (CPLib.eqr(pTipoR,"2") || CPLib.eqr(pTipoR,"7")) {
      /* Exec "Tipo2/Tipo7" Page 2:Page_2 */
      Page_2();
      /* Case pTipoR='3' */
    } else if (CPLib.eqr(pTipoR,"3")) {
      /* Exec "Tipo3" Page 3:Page_3 */
      Page_3();
      /* Case pTipoR='4' or pTipoR='8' */
    } else if (CPLib.eqr(pTipoR,"4") || CPLib.eqr(pTipoR,"8")) {
      /* Exec "Tipo4/Tipo8" Page 4:Page_4 */
      Page_4();
      /* Case pTipoR='6' */
    } else if (CPLib.eqr(pTipoR,"6")) {
      /* Exec "Tipo6" Page 5:Page_5 */
      Page_5();
      /* Case pTipoR='9' */
    } else if (CPLib.eqr(pTipoR,"9")) {
      /* Exec "Tipo9" Page 6:Page_6 */
      Page_6();
    } // End Case
    /* Return cRitorno */
    throw new Stop(cRitorno);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Record Tipo 2 */
      /* _numsto := arfn_chkspers(pCli,iif(pSTATO='1',pDatRet,pDatOpe)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(pCli,(CPLib.eqr(pSTATO,"1")?pDatRet:pDatOpe));
      /* cRitorno := cRitorno + Left(LRTrim(pCli)+Space(16),16) */
      cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pCli)+CPLib.Space(16),16);
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _tipsot := '' */
          _tipsot = "";
          // * --- Read from tbstgru
          m_cServer = m_Ctx.GetServer("tbstgru");
          m_cPhName = m_Ctx.GetPhName("tbstgru");
          m_cSql = "";
          m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
          if (m_Ctx.IsSharedTemp("tbstgru")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOSOT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tipsot = Read_Cursor.GetString("TIPOSOT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstgru into routine arfn_datisog_sol returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tipsot = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _ramate := iif(pRAE='R',LRTrim(personbo->RAMOGRUP),iif(Left(personbo->ATTIV,1)='P' or Left(personbo->ATTIV,3)='999',Space(3),Left(LRTrim(personbo->ATTIV),3))) */
          _ramate = (CPLib.eqr(pRAE,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):(CPLib.eqr(CPLib.Left(Cursor_personbo.GetString("ATTIV"),1),"P") || CPLib.eqr(CPLib.Left(Cursor_personbo.GetString("ATTIV"),3),"999")?CPLib.Space(3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)));
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,Space(16),Left(LRTrim(personbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(personbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASSTATO,' '))+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + iif(_tipsot='1',Left(LRTrim(_ramate)+Space(3),3),Space(3)) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+(CPLib.eqr(_tipsot,"1")?CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3):CPLib.Space(3));
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASCOMUN,' '))+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + iif(_tipsot='1',Left(LRTrim(_ramate)+Space(3),3),Space(3)) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+(CPLib.eqr(_tipsot,"1")?CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3):CPLib.Space(3));
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(pRap,' '))+Space(25),25) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(pRap," "))+CPLib.Space(25),25);
          /* cRitorno := cRitorno + Left(LRTrim(pTRap)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pTRap)+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->AUTRILASC,' '))+Space(30),30) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(personbo->DATAVALI)),DateToChar(personbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_personbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* _ramate := iif(pRAE='R',LRTrim(wersonbo->RAMOGRUP),iif(Left(wersonbo->ATTIV,1)='P' or Left(wersonbo->ATTIV,3)='999',Space(3),Left(LRTrim(wersonbo->ATTIV),3))) */
          _ramate = (CPLib.eqr(pRAE,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):(CPLib.eqr(CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),1),"P") || CPLib.eqr(CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),3),"999")?CPLib.Space(3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)));
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(wersonbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(wersonbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,Space(16),Left(LRTrim(wersonbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(wersonbo->DATANASC) or DateToChar(wersonbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(wersonbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASSTATO,' '))+Space(30),30) + Left(LRTrim(wersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASCOMUN,' '))+Space(30),30) + Left(LRTrim(wersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(pRap,' '))+Space(25),25) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(pRap," "))+CPLib.Space(25),25);
          /* cRitorno := cRitorno + Left(LRTrim(pTRap)+" ",1) + Left(LRTrim(wersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(wersonbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pTRap)+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(wersonbo->DATARILASC) or DateToChar(wersonbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->AUTRILASC,' '))+Space(30),30) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(wersonbo->DATAVALI)),DateToChar(wersonbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_wersonbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_wersonbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Record Tipo 2 */
      /* _numsto := arfn_chkspers(pCli,iif(pSTATO='1',pDatRet,pDatOpe)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(pCli,(CPLib.eqr(pSTATO,"1")?pDatRet:pDatOpe));
      /* cRitorno := cRitorno + Left(LRTrim(pCli)+Space(16),16) */
      cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pCli)+CPLib.Space(16),16);
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _tipsot := '' */
          _tipsot = "";
          // * --- Read from tbstgru
          m_cServer = m_Ctx.GetServer("tbstgru");
          m_cPhName = m_Ctx.GetPhName("tbstgru");
          m_cSql = "";
          m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("SOTGRUP"));
          if (m_Ctx.IsSharedTemp("tbstgru")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOSOT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tipsot = Read_Cursor.GetString("TIPOSOT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstgru into routine arfn_datisog_sol returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tipsot = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _ramate := iif(pRAE='R',LRTrim(personbo->RAMOGRUP),iif(Left(personbo->ATTIV,1)='P' or Left(personbo->ATTIV,3)='999',Space(3),Left(LRTrim(personbo->ATTIV),3))) */
          _ramate = (CPLib.eqr(pRAE,"R")?CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP")):(CPLib.eqr(CPLib.Left(Cursor_personbo.GetString("ATTIV"),1),"P") || CPLib.eqr(CPLib.Left(Cursor_personbo.GetString("ATTIV"),3),"999")?CPLib.Space(3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),3)));
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,Space(16),Left(LRTrim(personbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(personbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASSTATO,' '))+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + iif(_tipsot='1',Left(LRTrim(_ramate)+Space(3),3),Space(3)) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+(CPLib.eqr(_tipsot,"1")?CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3):CPLib.Space(3));
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASCOMUN,' '))+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + iif(_tipsot='1',Left(LRTrim(_ramate)+Space(3),3),Space(3)) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+(CPLib.eqr(_tipsot,"1")?CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3):CPLib.Space(3));
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(pRap,' '))+Space(25),25) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(pRap," "))+CPLib.Space(25),25);
          /* cRitorno := cRitorno + Left(LRTrim(pTRap)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pTRap)+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->AUTRILASC,' '))+Space(30),30) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(personbo->DATAVALI)),DateToChar(personbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_personbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* _ramate := iif(pRAE='R',LRTrim(wersonbo->RAMOGRUP),iif(Left(wersonbo->ATTIV,1)='P' or Left(wersonbo->ATTIV,3)='999',Space(3),Left(LRTrim(wersonbo->ATTIV),3))) */
          _ramate = (CPLib.eqr(pRAE,"R")?CPLib.LRTrim(Cursor_wersonbo.GetString("RAMOGRUP")):(CPLib.eqr(CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),1),"P") || CPLib.eqr(CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),3),"999")?CPLib.Space(3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("ATTIV")),3)));
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(wersonbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(wersonbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,Space(16),Left(LRTrim(wersonbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(wersonbo->DATANASC) or DateToChar(wersonbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(wersonbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASSTATO,' '))+Space(30),30) + Left(LRTrim(wersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASCOMUN,' '))+Space(30),30) + Left(LRTrim(wersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(pRap,' '))+Space(25),25) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(pRap," "))+CPLib.Space(25),25);
          /* cRitorno := cRitorno + Left(LRTrim(pTRap)+" ",1) + Left(LRTrim(wersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(wersonbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pTRap)+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(wersonbo->DATARILASC) or DateToChar(wersonbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->AUTRILASC,' '))+Space(30),30) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(wersonbo->DATAVALI)),DateToChar(wersonbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_wersonbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_wersonbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
  void Page_4() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Record Tipo 4 */
      /* _numsto := arfn_chkspers(pCli,iif(pSTATO='1',pDatRet,pDatOpe)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(pCli,(CPLib.eqr(pSTATO,"1")?pDatRet:pDatOpe));
      /* cRitorno := cRitorno + Left(LRTrim(pCli)+Space(16),16) */
      cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pCli)+CPLib.Space(16),16);
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,Space(16),Left(LRTrim(personbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(personbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASSTATO,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASCOMUN,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->AUTRILASC,' '))+Space(30),30) + Left(LRTrim(personbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(personbo->DATAVALI)),DateToChar(personbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_personbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(wersonbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(wersonbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,Space(16),Left(LRTrim(wersonbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(wersonbo->DATANASC) or DateToChar(wersonbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(wersonbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASSTATO,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASCOMUN,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(wersonbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(wersonbo->DATARILASC) or DateToChar(wersonbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->AUTRILASC,' '))+Space(30),30) + Left(LRTrim(wersonbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(wersonbo->DATAVALI)),DateToChar(wersonbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_wersonbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_wersonbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
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
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Record Tipo 6 */
      /* _numsto := arfn_chkspers(pCli,iif(pSTATO='1',pDatRet,pDatOpe)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(pCli,(CPLib.eqr(pSTATO,"1")?pDatRet:pDatOpe));
      /* cRitorno := cRitorno + Left(LRTrim(pCli)+Space(16),16) */
      cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pCli)+CPLib.Space(16),16);
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,Space(16),Left(LRTrim(personbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(personbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASSTATO,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASCOMUN,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->AUTRILASC,' '))+Space(30),30) + Left(LRTrim(personbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(personbo->DATAVALI)),DateToChar(personbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_personbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(wersonbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(wersonbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,Space(16),Left(LRTrim(wersonbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(wersonbo->DATANASC) or DateToChar(wersonbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(wersonbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASSTATO,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASCOMUN,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(wersonbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(wersonbo->DATARILASC) or DateToChar(wersonbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->AUTRILASC,' '))+Space(30),30) + Left(LRTrim(wersonbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(wersonbo->DATAVALI)),DateToChar(wersonbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_wersonbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_wersonbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
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
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Record Tipo 4 */
      /* _numsto := arfn_chkspers(pCli,iif(pSTATO='1',pDatRet,pDatOpe)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(pCli,(CPLib.eqr(pSTATO,"1")?pDatRet:pDatOpe));
      /* cRitorno := cRitorno + Left(LRTrim(pCli)+Space(16),16) */
      cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(pCli)+CPLib.Space(16),16);
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(personbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,Space(16),Left(LRTrim(personbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(personbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASSTATO,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->NASCOMUN,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(personbo->AUTRILASC,' '))+Space(30),30) + Left(LRTrim(personbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(personbo->DATAVALI)),DateToChar(personbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_personbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(personbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70) + Left(LRTrim(wersonbo->PAESE)+Space(3),3) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3);
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->CODCAB)+Space(6),6) + Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30) + Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35) + Left(LRTrim(wersonbo->CAP)+ Space(5),5) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5);
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,Space(16),Left(LRTrim(wersonbo->CODFISC)+Space(16),16)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODFISC"))+CPLib.Space(16),16));
          /* If Empty(wersonbo->DATANASC) or DateToChar(wersonbo->DATANASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATANASC))+Space(8),8) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
          } // End If
          /* If not(Empty(wersonbo->NASSTATO)) */
          if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("NASSTATO")))) {
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASSTATO,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASSTATO")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->NASCOMUN,' '))+Space(30),30) + Space(35) */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("NASCOMUN")," "))+CPLib.Space(30),30)+CPLib.Space(35);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(wersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(wersonbo->NUMDOCUM)+Space(15),15) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
          /* If Empty(wersonbo->DATARILASC) or DateToChar(wersonbo->DATARILASC)='01000101' */
          if (CPLib.Empty(Cursor_wersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")),"01000101")) {
            /* cRitorno := cRitorno + Space(8) */
            cRitorno = cRitorno+CPLib.Space(8);
          } else { // Else
            /* cRitorno := cRitorno + Left(LRTrim(DateToChar(wersonbo->DATARILASC))+Space(8),8)  */
            cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_wersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
          } // End If
          /* cRitorno := cRitorno + Left(LRTrim(arfn_agechar(wersonbo->AUTRILASC,' '))+Space(30),30) + Left(LRTrim(wersonbo->SESSO)+" ",1) + Space(22) */
          cRitorno = cRitorno+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("AUTRILASC")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(22);
          /* cRitorno := cRitorno + iif(not(Empty(wersonbo->DATAVALI)),DateToChar(wersonbo->DATAVALI),Space(8)) */
          cRitorno = cRitorno+( ! (CPLib.Empty(Cursor_wersonbo.GetDate("DATAVALI")))?CPLib.DateToChar(Cursor_wersonbo.GetDate("DATAVALI")):CPLib.Space(8));
          /* cRitorno := cRitorno + iif(wersonbo->CFESTERO=1,'NOCF',Space(4)) */
          cRitorno = cRitorno+(CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"NOCF":CPLib.Space(4));
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
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
  public String RunAsync(String p_pCli,java.sql.Date p_pDatOpe,String p_pRap,String p_pTRap,String p_pTipoR,String p_pRAE,String p_pSTATO,java.sql.Date p_pDatRet) {
    pCli = p_pCli;
    pDatOpe = p_pDatOpe;
    pRap = p_pRap;
    pTRap = p_pTRap;
    pTipoR = p_pTipoR;
    pRAE = p_pRAE;
    pSTATO = p_pSTATO;
    pDatRet = p_pDatRet;
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
  public String Run(String p_pCli,java.sql.Date p_pDatOpe,String p_pRap,String p_pTRap,String p_pTipoR,String p_pRAE,String p_pSTATO,java.sql.Date p_pDatRet) {
    pCli = p_pCli;
    pDatOpe = p_pDatOpe;
    pRap = p_pRap;
    pTRap = p_pTRap;
    pTipoR = p_pTipoR;
    pRAE = p_pRAE;
    pSTATO = p_pSTATO;
    pDatRet = p_pDatRet;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_datisog_solR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_datisog_solR(p_Ctx, p_Caller);
  }
  public static arfn_datisog_solR Make(CPContext p_Ctx) {
    return new arfn_datisog_solR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCli = CPLib.Space(16);
    pDatOpe = CPLib.NullDate();
    pRap = CPLib.Space(25);
    pTRap = CPLib.Space(1);
    pTipoR = CPLib.Space(1);
    pRAE = CPLib.Space(1);
    pSTATO = CPLib.Space(1);
    pDatRet = CPLib.NullDate();
    cRitorno = "";
    _numsto = CPLib.Space(15);
    _ramate = CPLib.Space(3);
    _tipsot = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkspers,arfn_datisog_sol,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkspers,arfn_datisog_sol,";
  public static String[] m_cRunParameterNames={"pCli","pDatOpe","pRap","pTRap","pTipoR","pRAE","pSTATO","pDatRet"};
}
