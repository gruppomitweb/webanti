// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_calccodfis_objR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public armt_personboBO pObj;
  public String apporagsoc;
  public String Mese;
  public String Giorno;
  public String Anno;
  public String cData;
  public String cSigla;
  public String cognome;
  public String nome;
  public double c1;
  public double c2;
  public String cCog;
  public String cNom;
  public double nCheck;
  public String cCheck;
  public String cChar;
  public double nChar;
  public double nocf;
  public String cSiglaN;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_calccodfis_objR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_calccodfis_obj",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("c1",p_cVarName)) {
      return c1;
    }
    if (CPLib.eqr("c2",p_cVarName)) {
      return c2;
    }
    if (CPLib.eqr("nCheck",p_cVarName)) {
      return nCheck;
    }
    if (CPLib.eqr("nChar",p_cVarName)) {
      return nChar;
    }
    if (CPLib.eqr("nocf",p_cVarName)) {
      return nocf;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_calccodfis_obj";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("apporagsoc",p_cVarName)) {
      return apporagsoc;
    }
    if (CPLib.eqr("Mese",p_cVarName)) {
      return Mese;
    }
    if (CPLib.eqr("Giorno",p_cVarName)) {
      return Giorno;
    }
    if (CPLib.eqr("Anno",p_cVarName)) {
      return Anno;
    }
    if (CPLib.eqr("cData",p_cVarName)) {
      return cData;
    }
    if (CPLib.eqr("cSigla",p_cVarName)) {
      return cSigla;
    }
    if (CPLib.eqr("cognome",p_cVarName)) {
      return cognome;
    }
    if (CPLib.eqr("nome",p_cVarName)) {
      return nome;
    }
    if (CPLib.eqr("cCog",p_cVarName)) {
      return cCog;
    }
    if (CPLib.eqr("cNom",p_cVarName)) {
      return cNom;
    }
    if (CPLib.eqr("cCheck",p_cVarName)) {
      return cCheck;
    }
    if (CPLib.eqr("cChar",p_cVarName)) {
      return cChar;
    }
    if (CPLib.eqr("cSiglaN",p_cVarName)) {
      return cSiglaN;
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
    if (CPLib.eqr("c1",p_cVarName)) {
      c1 = value;
      return;
    }
    if (CPLib.eqr("c2",p_cVarName)) {
      c2 = value;
      return;
    }
    if (CPLib.eqr("nCheck",p_cVarName)) {
      nCheck = value;
      return;
    }
    if (CPLib.eqr("nChar",p_cVarName)) {
      nChar = value;
      return;
    }
    if (CPLib.eqr("nocf",p_cVarName)) {
      nocf = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("apporagsoc",p_cVarName)) {
      apporagsoc = value;
      return;
    }
    if (CPLib.eqr("Mese",p_cVarName)) {
      Mese = value;
      return;
    }
    if (CPLib.eqr("Giorno",p_cVarName)) {
      Giorno = value;
      return;
    }
    if (CPLib.eqr("Anno",p_cVarName)) {
      Anno = value;
      return;
    }
    if (CPLib.eqr("cData",p_cVarName)) {
      cData = value;
      return;
    }
    if (CPLib.eqr("cSigla",p_cVarName)) {
      cSigla = value;
      return;
    }
    if (CPLib.eqr("cognome",p_cVarName)) {
      cognome = value;
      return;
    }
    if (CPLib.eqr("nome",p_cVarName)) {
      nome = value;
      return;
    }
    if (CPLib.eqr("cCog",p_cVarName)) {
      cCog = value;
      return;
    }
    if (CPLib.eqr("cNom",p_cVarName)) {
      cNom = value;
      return;
    }
    if (CPLib.eqr("cCheck",p_cVarName)) {
      cCheck = value;
      return;
    }
    if (CPLib.eqr("cChar",p_cVarName)) {
      cChar = value;
      return;
    }
    if (CPLib.eqr("cSiglaN",p_cVarName)) {
      cSiglaN = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Variabili del caller */
      /* pObj Object(armt_personboBO) */
      /* Variabili d'appoggio */
      /* apporagsoc Char(70) */
      /* Mese Char(1) */
      /* Giorno Char(2) */
      /* Anno Char(2) */
      /* cData Char(8) // La data in formato carattere */
      /* cSigla Char(4) // La sigla del comune per il codice fiscale */
      /* cognome Char(35) // Contienen il cognom */
      /* nome Char(35) // Contiene il nome */
      /* c1 Numeric(3, 0) // contatore 1 */
      /* c2 Numeric(3, 0) // Contatore 2 */
      /* cCog Char(3) // parte del Cognome per CF */
      /* cNom Char(3) // Parte del nome per CF */
      /* nCheck Numeric(10, 0) */
      /* cCheck Char(1) */
      /* cChar Char(1) */
      /* nChar Numeric(10, 0) */
      /* nocf Numeric(1, 0) */
      /* cSiglaN Char(4) */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* nocf := intermbo->NOCODFISC */
        nocf = CPLib.Round(Cursor_intermbo.GetDouble("NOCODFISC"),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If nocf=0 */
      if (CPLib.eqr(nocf,0)) {
        /* Calcola variabile Mese */
        /* cData := DateToChar(pObj.w_DATANASC) */
        cData = CPLib.DateToChar(pObj.w_DATANASC);
        /* Exec "Data Di Nascita" Page 2:Page_2 */
        Page_2();
        /* Verifica Codice Comune */
        /* If not(Empty(LRTrim(pObj.w_NASSTATO))) and (LRTrim(pObj.w_NASSTATO)  <> 'ITALIA' and LRTrim(pObj.w_NASSTATO)  <> 'ITALY') */
        if ( ! (CPLib.Empty(CPLib.LRTrim(pObj.w_NASSTATO))) && (CPLib.ne(CPLib.LRTrim(pObj.w_NASSTATO),"ITALIA") && CPLib.ne(CPLib.LRTrim(pObj.w_NASSTATO),"ITALY"))) {
          /* If not(Empty(pObj.w_IDNASSTATO)) */
          if ( ! (CPLib.Empty(pObj.w_IDNASSTATO))) {
            // * --- Read from tbstatna
            m_cServer = m_Ctx.GetServer("tbstatna");
            m_cPhName = m_Ctx.GetPhName("tbstatna");
            m_cSql = "";
            m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(pObj.w_IDNASSTATO),"C",10,0,m_cServer),m_cServer,CPLib.Upper(pObj.w_IDNASSTATO));
            if (m_Ctx.IsSharedTemp("tbstatna")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SIGLANEW",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSigla = Read_Cursor.GetString("SIGLA");
              cSiglaN = Read_Cursor.GetString("SIGLANEW");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstatna into routine arrt_calccodfis_obj returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSigla = "";
              cSiglaN = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            // * --- Read from tbstatna
            m_cServer = m_Ctx.GetServer("tbstatna");
            m_cPhName = m_Ctx.GetPhName("tbstatna");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(pObj.w_NASSTATO)),"C",50,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(pObj.w_NASSTATO)));
            if (m_Ctx.IsSharedTemp("tbstatna")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SIGLANEW",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSigla = Read_Cursor.GetString("SIGLA");
              cSiglaN = Read_Cursor.GetString("SIGLANEW");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstatna into routine arrt_calccodfis_obj returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSigla = "";
              cSiglaN = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(cSigla) */
            if (CPLib.Empty(cSigla)) {
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(pObj.w_NASSTATO)),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(pObj.w_NASSTATO)));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                cSigla = Read_Cursor.GetString("SIGLA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_calccodfis_obj returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                cSigla = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
          } // End If
        } else { // Else
          /* If not(Empty(pObj.w_IDNASCOMUN)) */
          if ( ! (CPLib.Empty(pObj.w_IDNASCOMUN))) {
            // * --- Read from tbcittna
            m_cServer = m_Ctx.GetServer("tbcittna");
            m_cPhName = m_Ctx.GetPhName("tbcittna");
            m_cSql = "";
            m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(pObj.w_IDNASCOMUN)),"C",40,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(pObj.w_IDNASCOMUN)));
            if (m_Ctx.IsSharedTemp("tbcittna")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSigla = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcittna into routine arrt_calccodfis_obj returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSigla = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            // * --- Read from tbcittna
            m_cServer = m_Ctx.GetServer("tbcittna");
            m_cPhName = m_Ctx.GetPhName("tbcittna");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(pObj.w_NASCOMUN)),"C",60,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(pObj.w_NASCOMUN)));
            m_cSql = m_cSql+" and PROV="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_TIPINTER,"C",2,0,m_cServer),m_cServer,pObj.w_TIPINTER);
            if (m_Ctx.IsSharedTemp("tbcittna")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSigla = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcittna into routine arrt_calccodfis_obj returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSigla = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(cSigla) */
            if (CPLib.Empty(cSigla)) {
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.LRTrim(pObj.w_NASCOMUN)),"C",60,0,m_cServer),m_cServer,CPLib.Upper(CPLib.LRTrim(pObj.w_NASCOMUN)));
              m_cSql = m_cSql+" and PROV="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_TIPINTER,"C",2,0,m_cServer),m_cServer,pObj.w_TIPINTER);
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                cSigla = Read_Cursor.GetString("SIGLA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_calccodfis_obj returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                cSigla = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
          } // End If
        } // End If
        /* Codice Fiscale */
        /* Exec "Cognome" Page 3:Page_3 */
        Page_3();
        /* Exec "Nome" Page 4:Page_4 */
        Page_4();
        /* Exec "Carattere di controllo" Page 5:Page_5 */
        Page_5();
        /* pObj.Set_CODFISC(cCog + cNom + Anno + Mese + Giorno + iif(Empty(cSiglaN),cSigla,cSiglaN) + cCheck) */
        pObj.Set_CODFISC(cCog+cNom+Anno+Mese+Giorno+(CPLib.Empty(cSiglaN)?cSigla:cSiglaN)+cCheck);
        /* pObj.SetUpdated() */
        pObj.SetUpdated();
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
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
  void Page_2() throws Exception {
    /* Variabile del mese */
    /* Case Month(pObj.w_DATANASC) = 1 */
    if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),1)) {
      /* Mese := 'A' */
      Mese = "A";
      /* Case Month(pObj.w_DATANASC) = 2 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),2)) {
      /* Mese := 'B' */
      Mese = "B";
      /* Case Month(pObj.w_DATANASC) = 3 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),3)) {
      /* Mese := 'C' */
      Mese = "C";
      /* Case Month(pObj.w_DATANASC) = 4 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),4)) {
      /* Mese := 'D' */
      Mese = "D";
      /* Case Month(pObj.w_DATANASC) = 5 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),5)) {
      /* Mese := 'E' */
      Mese = "E";
      /* Case Month(pObj.w_DATANASC) = 6 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),6)) {
      /* Mese := 'H' */
      Mese = "H";
      /* Case Month(pObj.w_DATANASC) = 7 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),7)) {
      /* Mese := 'L' */
      Mese = "L";
      /* Case Month(pObj.w_DATANASC) = 8 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),8)) {
      /* Mese := 'M' */
      Mese = "M";
      /* Case Month(pObj.w_DATANASC) = 9 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),9)) {
      /* Mese := 'P' */
      Mese = "P";
      /* Case Month(pObj.w_DATANASC) = 10 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),10)) {
      /* Mese := 'R' */
      Mese = "R";
      /* Case Month(pObj.w_DATANASC) = 11 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),11)) {
      /* Mese := 'S' */
      Mese = "S";
      /* Case Month(pObj.w_DATANASC) = 12 */
    } else if (CPLib.eqr(CPLib.Month(pObj.w_DATANASC),12)) {
      /* Mese := 'T' */
      Mese = "T";
    } // End Case
    /* Variabile del giorno */
    /* Giorno := iif(pObj.w_SESSO='1',Right(cData,2),Str(Day(pObj.w_DATANASC) + 40,2)) */
    Giorno = (CPLib.eqr(pObj.w_SESSO,"1")?CPLib.Right(cData,2):CPLib.Str(CPLib.Day(pObj.w_DATANASC)+40,2));
    /* Variabile anno */
    /* Anno := Substr(cData,3,2) */
    Anno = CPLib.Substr(cData,3,2);
  }
  void Page_3() throws Exception {
    /* Calcolo cognome */
    /* cognome := pObj.w_COGNOME */
    cognome = pObj.w_COGNOME;
    /* apporagsoc := Substr(pObj.w_RAGSOC,At(' ',pObj.w_RAGSOC)+1,70 - (Len(cognome)+1)) */
    apporagsoc = CPLib.Substr(pObj.w_RAGSOC,CPLib.At(" ",pObj.w_RAGSOC)+1,70-(CPLib.Len(cognome)+1));
    /* Consonanti */
    /* c1 := 1 // contatore 1 */
    c1 = CPLib.Round(1,0);
    /* c2 := 0 // contatore 1 */
    c2 = CPLib.Round(0,0);
    /* cCog := '' // parte del Cognome per CF */
    cCog = "";
    /* While c1 <= Len(LRTrim(cognome)) */
    while (CPLib.le(c1,CPLib.Len(CPLib.LRTrim(cognome)))) {
      /* If (Asc(Upper(Substr(cognome,c1,1)))>64 and Asc(Upper(Substr(cognome,c1,1)))<91) and (Substr(cognome,c1,1) <> 'A' and Substr(cognome,c1,1) <> 'E' and Substr(cognome,c1,1) <> 'I' and Substr(cognome,c1,1) <> 'O' and Substr(cognome,c1,1) <> 'U' and Substr(cognome,c1,1) <> ' ') */
      if ((CPLib.gt(CPLib.Asc(CPLib.Upper(CPLib.Substr(cognome,c1,1))),64) && CPLib.lt(CPLib.Asc(CPLib.Upper(CPLib.Substr(cognome,c1,1))),91)) && (CPLib.ne(CPLib.Substr(cognome,c1,1),"A") && CPLib.ne(CPLib.Substr(cognome,c1,1),"E") && CPLib.ne(CPLib.Substr(cognome,c1,1),"I") && CPLib.ne(CPLib.Substr(cognome,c1,1),"O") && CPLib.ne(CPLib.Substr(cognome,c1,1),"U") && CPLib.ne(CPLib.Substr(cognome,c1,1)," "))) {
        /* If c2 < 3 */
        if (CPLib.lt(c2,3)) {
          /* cCog := cCog + Substr(cognome,c1,1) // parte del Cognome per CF */
          cCog = cCog+CPLib.Substr(cognome,c1,1);
          /* c2 := c2 + 1 // Contatore 2 */
          c2 = CPLib.Round(c2+1,0);
        } // End If
      } // End If
      /* c1 := c1 + 1 // contatore 1 */
      c1 = CPLib.Round(c1+1,0);
    } // End While
    /* If c2 < 3 */
    if (CPLib.lt(c2,3)) {
      /* c1 := 1 // contatore 1 */
      c1 = CPLib.Round(1,0);
      /* While c1 <= Len(LRTrim(cognome)) */
      while (CPLib.le(c1,CPLib.Len(CPLib.LRTrim(cognome)))) {
        /* If (Asc(Upper(Substr(cognome,c1,1)))>64 and Asc(Upper(Substr(cognome,c1,1)))<91) and ((Substr(cognome,c1,1) = 'A' or Substr(cognome,c1,1) = 'E' or Substr(cognome,c1,1) = 'I' or Substr(cognome,c1,1) = 'O' or Substr(cognome,c1,1) = 'U') and Substr(cognome,c1,1) <> ' ') */
        if ((CPLib.gt(CPLib.Asc(CPLib.Upper(CPLib.Substr(cognome,c1,1))),64) && CPLib.lt(CPLib.Asc(CPLib.Upper(CPLib.Substr(cognome,c1,1))),91)) && ((CPLib.eqr(CPLib.Substr(cognome,c1,1),"A") || CPLib.eqr(CPLib.Substr(cognome,c1,1),"E") || CPLib.eqr(CPLib.Substr(cognome,c1,1),"I") || CPLib.eqr(CPLib.Substr(cognome,c1,1),"O") || CPLib.eqr(CPLib.Substr(cognome,c1,1),"U")) && CPLib.ne(CPLib.Substr(cognome,c1,1)," "))) {
          /* If c2 < 3 */
          if (CPLib.lt(c2,3)) {
            /* cCog := cCog + Substr(cognome,c1,1) // parte del Cognome per CF */
            cCog = cCog+CPLib.Substr(cognome,c1,1);
            /* c2 := c2 + 1 // Contatore 2 */
            c2 = CPLib.Round(c2+1,0);
          } // End If
        } // End If
        /* c1 := c1 + 1 // contatore 1 */
        c1 = CPLib.Round(c1+1,0);
      } // End While
    } // End If
    /* If c2 < 3 */
    if (CPLib.lt(c2,3)) {
      /* While c2 < 3 */
      while (CPLib.lt(c2,3)) {
        /* cCog := cCog + 'X' // parte del Cognome per CF */
        cCog = cCog+"X";
        /* c2 := c2 + 1 // Contatore 2 */
        c2 = CPLib.Round(c2+1,0);
      } // End While
    } // End If
  }
  void Page_4() throws Exception {
    /* Calcolo cognome */
    /* nome := pObj.w_NOME */
    nome = pObj.w_NOME;
    /* Consonanti */
    /* c1 := 1 // contatore 1 */
    c1 = CPLib.Round(1,0);
    /* c2 := 0 // contatore 1 */
    c2 = CPLib.Round(0,0);
    /* cNom := '' // Parte del nome per CF */
    cNom = "";
    /* While c1 <= Len(LRTrim(nome)) */
    while (CPLib.le(c1,CPLib.Len(CPLib.LRTrim(nome)))) {
      /* If (Asc(Upper(Substr(nome,c1,1)))>64 and Asc(Upper(Substr(nome,c1,1)))<91) and (Substr(nome,c1,1) <> 'A' and Substr(nome,c1,1) <> 'E' and Substr(nome,c1,1) <> 'I' and Substr(nome,c1,1) <> 'O' and Substr(nome,c1,1) <> 'U' and Substr(nome,c1,1) <> ' ') */
      if ((CPLib.gt(CPLib.Asc(CPLib.Upper(CPLib.Substr(nome,c1,1))),64) && CPLib.lt(CPLib.Asc(CPLib.Upper(CPLib.Substr(nome,c1,1))),91)) && (CPLib.ne(CPLib.Substr(nome,c1,1),"A") && CPLib.ne(CPLib.Substr(nome,c1,1),"E") && CPLib.ne(CPLib.Substr(nome,c1,1),"I") && CPLib.ne(CPLib.Substr(nome,c1,1),"O") && CPLib.ne(CPLib.Substr(nome,c1,1),"U") && CPLib.ne(CPLib.Substr(nome,c1,1)," "))) {
        /* If c2 < 4 */
        if (CPLib.lt(c2,4)) {
          /* cNom := cNom + Substr(nome,c1,1) // Parte del nome per CF */
          cNom = cNom+CPLib.Substr(nome,c1,1);
          /* c2 := c2 + 1 // Contatore 2 */
          c2 = CPLib.Round(c2+1,0);
        } // End If
      } // End If
      /* c1 := c1 + 1 // contatore 1 */
      c1 = CPLib.Round(c1+1,0);
    } // End While
    /* If c2 < 3 */
    if (CPLib.lt(c2,3)) {
      /* c1 := 1 // contatore 1 */
      c1 = CPLib.Round(1,0);
      /* While c1 <= Len(LRTrim(nome)) */
      while (CPLib.le(c1,CPLib.Len(CPLib.LRTrim(nome)))) {
        /* If (Asc(Upper(Substr(nome,c1,1)))>64 and Asc(Upper(Substr(nome,c1,1)))<91) and ((Substr(nome,c1,1) = 'A' or Substr(nome,c1,1) = 'E' or Substr(nome,c1,1) = 'I' or Substr(nome,c1,1) = 'O' or Substr(nome,c1,1) = 'U') and Substr(nome,c1,1) <> ' ') */
        if ((CPLib.gt(CPLib.Asc(CPLib.Upper(CPLib.Substr(nome,c1,1))),64) && CPLib.lt(CPLib.Asc(CPLib.Upper(CPLib.Substr(nome,c1,1))),91)) && ((CPLib.eqr(CPLib.Substr(nome,c1,1),"A") || CPLib.eqr(CPLib.Substr(nome,c1,1),"E") || CPLib.eqr(CPLib.Substr(nome,c1,1),"I") || CPLib.eqr(CPLib.Substr(nome,c1,1),"O") || CPLib.eqr(CPLib.Substr(nome,c1,1),"U")) && CPLib.ne(CPLib.Substr(nome,c1,1)," "))) {
          /* If c2 < 3 */
          if (CPLib.lt(c2,3)) {
            /* cNom := cNom + Substr(nome,c1,1) // Parte del nome per CF */
            cNom = cNom+CPLib.Substr(nome,c1,1);
            /* c2 := c2 + 1 // Contatore 2 */
            c2 = CPLib.Round(c2+1,0);
          } // End If
        } // End If
        /* c1 := c1 + 1 // contatore 1 */
        c1 = CPLib.Round(c1+1,0);
      } // End While
    } // End If
    /* If c2 < 3 */
    if (CPLib.lt(c2,3)) {
      /* While c2 < 3 */
      while (CPLib.lt(c2,3)) {
        /* cNom := cNom + 'X' // Parte del nome per CF */
        cNom = cNom+"X";
        /* c2 := c2 + 1 // Contatore 2 */
        c2 = CPLib.Round(c2+1,0);
      } // End While
    } // End If
    /* If c2 = 4 */
    if (CPLib.eqr(c2,4)) {
      /* cNom := Left(cNom,1)+Substr(cNom,3,1)+Right(cNom,1) // Parte del nome per CF */
      cNom = CPLib.Left(cNom,1)+CPLib.Substr(cNom,3,1)+CPLib.Right(cNom,1);
    } // End If
  }
  void Page_5() throws Exception {
    /* Cicla sulla stringa e calcola il controllo */
    /* c1 := 1 // contatore 1 */
    c1 = CPLib.Round(1,0);
    /* nCheck := 0 */
    nCheck = CPLib.Round(0,0);
    /* While c1 <= Len(cCog+cNom+Anno+Mese+Giorno+iif(Empty(cSiglaN),cSigla,cSiglaN)) */
    while (CPLib.le(c1,CPLib.Len(cCog+cNom+Anno+Mese+Giorno+(CPLib.Empty(cSiglaN)?cSigla:cSiglaN)))) {
      /* cChar := Substr(cCog+cNom+Anno+Mese+Giorno+iif(Empty(cSiglaN),cSigla,cSiglaN),c1,1) */
      cChar = CPLib.Substr(cCog+cNom+Anno+Mese+Giorno+(CPLib.Empty(cSiglaN)?cSigla:cSiglaN),c1,1);
      /* If Mod(c1,2)=0 */
      if (CPLib.eqr(CPLib.Mod(c1,2),0)) {
        /* Exec "Caratteri Pari" Page 7:Page_7 */
        Page_7();
      } else { // Else
        /* Exec "Caratteri Dispari" Page 6:Page_6 */
        Page_6();
      } // End If
      /* c1 := c1 + 1 // contatore 1 */
      c1 = CPLib.Round(c1+1,0);
    } // End While
    /* nCheck := Mod(nCheck,26) */
    nCheck = CPLib.Round(CPLib.Mod(nCheck,26),0);
    /* Exec "Ritorna carattere check" Page 8:Page_8 */
    Page_8();
  }
  void Page_6() throws Exception {
    /* Seglie la cifra per i caratteri dispari */
    /* nChar := -1 */
    nChar = CPLib.Round(-1,0);
    /* Case cChar = '0' */
    if (CPLib.eqr(cChar,"0")) {
      /* nChar := 1 */
      nChar = CPLib.Round(1,0);
      /* Case cChar = '1' */
    } else if (CPLib.eqr(cChar,"1")) {
      /* nChar := 0 */
      nChar = CPLib.Round(0,0);
      /* Case cChar = '2' */
    } else if (CPLib.eqr(cChar,"2")) {
      /* nChar := 5 */
      nChar = CPLib.Round(5,0);
      /* Case cChar = '3' */
    } else if (CPLib.eqr(cChar,"3")) {
      /* nChar := 7 */
      nChar = CPLib.Round(7,0);
      /* Case cChar = '4' */
    } else if (CPLib.eqr(cChar,"4")) {
      /* nChar := 9 */
      nChar = CPLib.Round(9,0);
      /* Case cChar = '5' */
    } else if (CPLib.eqr(cChar,"5")) {
      /* nChar := 13 */
      nChar = CPLib.Round(13,0);
      /* Case cChar = '6' */
    } else if (CPLib.eqr(cChar,"6")) {
      /* nChar := 15 */
      nChar = CPLib.Round(15,0);
      /* Case cChar = '7' */
    } else if (CPLib.eqr(cChar,"7")) {
      /* nChar := 17 */
      nChar = CPLib.Round(17,0);
      /* Case cChar='8' */
    } else if (CPLib.eqr(cChar,"8")) {
      /* nChar := 19 */
      nChar = CPLib.Round(19,0);
      /* Case cChar = '9' */
    } else if (CPLib.eqr(cChar,"9")) {
      /* nChar := 21 */
      nChar = CPLib.Round(21,0);
      /* Case cChar='A' */
    } else if (CPLib.eqr(cChar,"A")) {
      /* nChar := 1 */
      nChar = CPLib.Round(1,0);
      /* Case cChar='B' */
    } else if (CPLib.eqr(cChar,"B")) {
      /* nChar := 0 */
      nChar = CPLib.Round(0,0);
      /* Case cChar='C' */
    } else if (CPLib.eqr(cChar,"C")) {
      /* nChar := 5 */
      nChar = CPLib.Round(5,0);
      /* Case cChar='D' */
    } else if (CPLib.eqr(cChar,"D")) {
      /* nChar := 7 */
      nChar = CPLib.Round(7,0);
      /* Case cChar='E' */
    } else if (CPLib.eqr(cChar,"E")) {
      /* nChar := 9 */
      nChar = CPLib.Round(9,0);
      /* Case cChar='F' */
    } else if (CPLib.eqr(cChar,"F")) {
      /* nChar := 13 */
      nChar = CPLib.Round(13,0);
      /* Case cChar='G' */
    } else if (CPLib.eqr(cChar,"G")) {
      /* nChar := 15 */
      nChar = CPLib.Round(15,0);
      /* Case cChar='H' */
    } else if (CPLib.eqr(cChar,"H")) {
      /* nChar := 17 */
      nChar = CPLib.Round(17,0);
      /* Case cChar='I' */
    } else if (CPLib.eqr(cChar,"I")) {
      /* nChar := 19 */
      nChar = CPLib.Round(19,0);
      /* Case cChar='J' */
    } else if (CPLib.eqr(cChar,"J")) {
      /* nChar := 21 */
      nChar = CPLib.Round(21,0);
      /* Case cChar='K' */
    } else if (CPLib.eqr(cChar,"K")) {
      /* nChar := 2 */
      nChar = CPLib.Round(2,0);
      /* Case cChar='L' */
    } else if (CPLib.eqr(cChar,"L")) {
      /* nChar := 4 */
      nChar = CPLib.Round(4,0);
      /* Case cChar='M' */
    } else if (CPLib.eqr(cChar,"M")) {
      /* nChar := 18 */
      nChar = CPLib.Round(18,0);
      /* Case cChar='N' */
    } else if (CPLib.eqr(cChar,"N")) {
      /* nChar := 20 */
      nChar = CPLib.Round(20,0);
      /* Case cChar='O' */
    } else if (CPLib.eqr(cChar,"O")) {
      /* nChar := 11 */
      nChar = CPLib.Round(11,0);
      /* Case cChar='P' */
    } else if (CPLib.eqr(cChar,"P")) {
      /* nChar := 3 */
      nChar = CPLib.Round(3,0);
      /* Case cChar='Q' */
    } else if (CPLib.eqr(cChar,"Q")) {
      /* nChar := 6 */
      nChar = CPLib.Round(6,0);
      /* Case cChar='R' */
    } else if (CPLib.eqr(cChar,"R")) {
      /* nChar := 8 */
      nChar = CPLib.Round(8,0);
      /* Case cChar='S' */
    } else if (CPLib.eqr(cChar,"S")) {
      /* nChar := 12 */
      nChar = CPLib.Round(12,0);
      /* Case cChar='T' */
    } else if (CPLib.eqr(cChar,"T")) {
      /* nChar := 14 */
      nChar = CPLib.Round(14,0);
      /* Case cChar='U' */
    } else if (CPLib.eqr(cChar,"U")) {
      /* nChar := 16 */
      nChar = CPLib.Round(16,0);
      /* Case cChar='V' */
    } else if (CPLib.eqr(cChar,"V")) {
      /* nChar := 10 */
      nChar = CPLib.Round(10,0);
      /* Case cChar='W' */
    } else if (CPLib.eqr(cChar,"W")) {
      /* nChar := 22 */
      nChar = CPLib.Round(22,0);
      /* Case cChar='X' */
    } else if (CPLib.eqr(cChar,"X")) {
      /* nChar := 25 */
      nChar = CPLib.Round(25,0);
      /* Case cChar='Y' */
    } else if (CPLib.eqr(cChar,"Y")) {
      /* nChar := 24 */
      nChar = CPLib.Round(24,0);
      /* Case cChar='Z' */
    } else if (CPLib.eqr(cChar,"Z")) {
      /* nChar := 23 */
      nChar = CPLib.Round(23,0);
    } // End Case
    /* If nChar > -1 */
    if (CPLib.gt(nChar,-1)) {
      /* nCheck := nCheck + nChar */
      nCheck = CPLib.Round(nCheck+nChar,0);
    } // End If
  }
  void Page_7() throws Exception {
    /* Seglie la cifra per i caratteri pari */
    /* nChar := -1 */
    nChar = CPLib.Round(-1,0);
    /* Case cChar = '0' */
    if (CPLib.eqr(cChar,"0")) {
      /* nChar := 0 */
      nChar = CPLib.Round(0,0);
      /* Case cChar = '1' */
    } else if (CPLib.eqr(cChar,"1")) {
      /* nChar := 1 */
      nChar = CPLib.Round(1,0);
      /* Case cChar = '2' */
    } else if (CPLib.eqr(cChar,"2")) {
      /* nChar := 2 */
      nChar = CPLib.Round(2,0);
      /* Case cChar = '3' */
    } else if (CPLib.eqr(cChar,"3")) {
      /* nChar := 3 */
      nChar = CPLib.Round(3,0);
      /* Case cChar = '4' */
    } else if (CPLib.eqr(cChar,"4")) {
      /* nChar := 4 */
      nChar = CPLib.Round(4,0);
      /* Case cChar = '5' */
    } else if (CPLib.eqr(cChar,"5")) {
      /* nChar := 5 */
      nChar = CPLib.Round(5,0);
      /* Case cChar = '6' */
    } else if (CPLib.eqr(cChar,"6")) {
      /* nChar := 6 */
      nChar = CPLib.Round(6,0);
      /* Case cChar = '7' */
    } else if (CPLib.eqr(cChar,"7")) {
      /* nChar := 7 */
      nChar = CPLib.Round(7,0);
      /* Case cChar='8' */
    } else if (CPLib.eqr(cChar,"8")) {
      /* nChar := 8 */
      nChar = CPLib.Round(8,0);
      /* Case cChar = '9' */
    } else if (CPLib.eqr(cChar,"9")) {
      /* nChar := 9 */
      nChar = CPLib.Round(9,0);
      /* Case cChar='A' */
    } else if (CPLib.eqr(cChar,"A")) {
      /* nChar := 0 */
      nChar = CPLib.Round(0,0);
      /* Case cChar='B' */
    } else if (CPLib.eqr(cChar,"B")) {
      /* nChar := 1 */
      nChar = CPLib.Round(1,0);
      /* Case cChar='C' */
    } else if (CPLib.eqr(cChar,"C")) {
      /* nChar := 2 */
      nChar = CPLib.Round(2,0);
      /* Case cChar='D' */
    } else if (CPLib.eqr(cChar,"D")) {
      /* nChar := 3 */
      nChar = CPLib.Round(3,0);
      /* Case cChar='E' */
    } else if (CPLib.eqr(cChar,"E")) {
      /* nChar := 4 */
      nChar = CPLib.Round(4,0);
      /* Case cChar='F' */
    } else if (CPLib.eqr(cChar,"F")) {
      /* nChar := 5 */
      nChar = CPLib.Round(5,0);
      /* Case cChar='G' */
    } else if (CPLib.eqr(cChar,"G")) {
      /* nChar := 6 */
      nChar = CPLib.Round(6,0);
      /* Case cChar='H' */
    } else if (CPLib.eqr(cChar,"H")) {
      /* nChar := 7 */
      nChar = CPLib.Round(7,0);
      /* Case cChar='I' */
    } else if (CPLib.eqr(cChar,"I")) {
      /* nChar := 8 */
      nChar = CPLib.Round(8,0);
      /* Case cChar='J' */
    } else if (CPLib.eqr(cChar,"J")) {
      /* nChar := 9 */
      nChar = CPLib.Round(9,0);
      /* Case cChar='K' */
    } else if (CPLib.eqr(cChar,"K")) {
      /* nChar := 10 */
      nChar = CPLib.Round(10,0);
      /* Case cChar='L' */
    } else if (CPLib.eqr(cChar,"L")) {
      /* nChar := 11 */
      nChar = CPLib.Round(11,0);
      /* Case cChar='M' */
    } else if (CPLib.eqr(cChar,"M")) {
      /* nChar := 12 */
      nChar = CPLib.Round(12,0);
      /* Case cChar='N' */
    } else if (CPLib.eqr(cChar,"N")) {
      /* nChar := 13 */
      nChar = CPLib.Round(13,0);
      /* Case cChar='O' */
    } else if (CPLib.eqr(cChar,"O")) {
      /* nChar := 14 */
      nChar = CPLib.Round(14,0);
      /* Case cChar='P' */
    } else if (CPLib.eqr(cChar,"P")) {
      /* nChar := 15 */
      nChar = CPLib.Round(15,0);
      /* Case cChar='Q' */
    } else if (CPLib.eqr(cChar,"Q")) {
      /* nChar := 16 */
      nChar = CPLib.Round(16,0);
      /* Case cChar='R' */
    } else if (CPLib.eqr(cChar,"R")) {
      /* nChar := 17 */
      nChar = CPLib.Round(17,0);
      /* Case cChar='S' */
    } else if (CPLib.eqr(cChar,"S")) {
      /* nChar := 18 */
      nChar = CPLib.Round(18,0);
      /* Case cChar='T' */
    } else if (CPLib.eqr(cChar,"T")) {
      /* nChar := 19 */
      nChar = CPLib.Round(19,0);
      /* Case cChar='U' */
    } else if (CPLib.eqr(cChar,"U")) {
      /* nChar := 20 */
      nChar = CPLib.Round(20,0);
      /* Case cChar='V' */
    } else if (CPLib.eqr(cChar,"V")) {
      /* nChar := 21 */
      nChar = CPLib.Round(21,0);
      /* Case cChar='W' */
    } else if (CPLib.eqr(cChar,"W")) {
      /* nChar := 22 */
      nChar = CPLib.Round(22,0);
      /* Case cChar='X' */
    } else if (CPLib.eqr(cChar,"X")) {
      /* nChar := 23 */
      nChar = CPLib.Round(23,0);
      /* Case cChar='Y' */
    } else if (CPLib.eqr(cChar,"Y")) {
      /* nChar := 24 */
      nChar = CPLib.Round(24,0);
      /* Case cChar='Z' */
    } else if (CPLib.eqr(cChar,"Z")) {
      /* nChar := 25 */
      nChar = CPLib.Round(25,0);
    } // End Case
    /* If nChar > -1 */
    if (CPLib.gt(nChar,-1)) {
      /* nCheck := nCheck + nChar */
      nCheck = CPLib.Round(nCheck+nChar,0);
    } // End If
  }
  void Page_8() throws Exception {
    /* Carattere controllo */
    /* Case nCheck = 0 */
    if (CPLib.eqr(nCheck,0)) {
      /* cCheck := 'A' */
      cCheck = "A";
      /* Case nCheck = 1 */
    } else if (CPLib.eqr(nCheck,1)) {
      /* cCheck := 'B' */
      cCheck = "B";
      /* Case nCheck = 2 */
    } else if (CPLib.eqr(nCheck,2)) {
      /* cCheck := 'C' */
      cCheck = "C";
      /* Case nCheck = 3 */
    } else if (CPLib.eqr(nCheck,3)) {
      /* cCheck := 'D' */
      cCheck = "D";
      /* Case nCheck = 4 */
    } else if (CPLib.eqr(nCheck,4)) {
      /* cCheck := 'E' */
      cCheck = "E";
      /* Case nCheck = 5 */
    } else if (CPLib.eqr(nCheck,5)) {
      /* cCheck := 'F' */
      cCheck = "F";
      /* Case nCheck = 6 */
    } else if (CPLib.eqr(nCheck,6)) {
      /* cCheck := 'G' */
      cCheck = "G";
      /* Case nCheck = 7 */
    } else if (CPLib.eqr(nCheck,7)) {
      /* cCheck := 'H' */
      cCheck = "H";
      /* Case nCheck = 8 */
    } else if (CPLib.eqr(nCheck,8)) {
      /* cCheck := 'I' */
      cCheck = "I";
      /* Case nCheck = 9 */
    } else if (CPLib.eqr(nCheck,9)) {
      /* cCheck := 'J' */
      cCheck = "J";
      /* Case nCheck = 10 */
    } else if (CPLib.eqr(nCheck,10)) {
      /* cCheck := 'K' */
      cCheck = "K";
      /* Case nCheck = 11 */
    } else if (CPLib.eqr(nCheck,11)) {
      /* cCheck := 'L' */
      cCheck = "L";
      /* Case nCheck = 12 */
    } else if (CPLib.eqr(nCheck,12)) {
      /* cCheck := 'M' */
      cCheck = "M";
      /* Case nCheck = 13 */
    } else if (CPLib.eqr(nCheck,13)) {
      /* cCheck := 'N' */
      cCheck = "N";
      /* Case nCheck = 14 */
    } else if (CPLib.eqr(nCheck,14)) {
      /* cCheck := 'O' */
      cCheck = "O";
      /* Case nCheck = 15 */
    } else if (CPLib.eqr(nCheck,15)) {
      /* cCheck := 'P' */
      cCheck = "P";
      /* Case nCheck = 16 */
    } else if (CPLib.eqr(nCheck,16)) {
      /* cCheck := 'Q' */
      cCheck = "Q";
      /* Case nCheck = 17 */
    } else if (CPLib.eqr(nCheck,17)) {
      /* cCheck := 'R' */
      cCheck = "R";
      /* Case nCheck = 18 */
    } else if (CPLib.eqr(nCheck,18)) {
      /* cCheck := 'S' */
      cCheck = "S";
      /* Case nCheck = 19 */
    } else if (CPLib.eqr(nCheck,19)) {
      /* cCheck := 'T' */
      cCheck = "T";
      /* Case nCheck = 20 */
    } else if (CPLib.eqr(nCheck,20)) {
      /* cCheck := 'U' */
      cCheck = "U";
      /* Case nCheck = 21 */
    } else if (CPLib.eqr(nCheck,21)) {
      /* cCheck := 'V' */
      cCheck = "V";
      /* Case nCheck = 22 */
    } else if (CPLib.eqr(nCheck,22)) {
      /* cCheck := 'W' */
      cCheck = "W";
      /* Case nCheck = 23 */
    } else if (CPLib.eqr(nCheck,23)) {
      /* cCheck := 'X' */
      cCheck = "X";
      /* Case nCheck = 24 */
    } else if (CPLib.eqr(nCheck,24)) {
      /* cCheck := 'Y' */
      cCheck = "Y";
      /* Case nCheck = 25 */
    } else if (CPLib.eqr(nCheck,25)) {
      /* cCheck := 'Z' */
      cCheck = "Z";
    } // End Case
  }
  void _init_() {
  }
  public String RunAsync(armt_personboBO p_pObj) {
    pObj = p_pObj;
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
  public Forward Run(armt_personboBO p_pObj) {
    pObj = p_pObj;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_calccodfis_objR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_calccodfis_objR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    apporagsoc = CPLib.Space(70);
    Mese = CPLib.Space(1);
    Giorno = CPLib.Space(2);
    Anno = CPLib.Space(2);
    cData = CPLib.Space(8);
    cSigla = CPLib.Space(4);
    cognome = CPLib.Space(35);
    nome = CPLib.Space(35);
    c1 = 0;
    c2 = 0;
    cCog = CPLib.Space(3);
    cNom = CPLib.Space(3);
    nCheck = 0;
    cCheck = CPLib.Space(1);
    cChar = CPLib.Space(1);
    nChar = 0;
    nocf = 0;
    cSiglaN = CPLib.Space(4);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}
