// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_imp_frischioR implements CallerWithObjs {
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
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
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
  public String pTipo;
  public String w_CONNESCLI;
  public String w_RAPPORTO;
  public String w_DURAT;
  public String w_AMMONT;
  public String w_AREAGEO;
  public String w_MODSVOL;
  public String w_RAGIO;
  public String w_TIPO;
  public double w_RAREA;
  public double w_RCOMP;
  public double w_RRAGIO;
  public double w_RTIPO;
  public double w_RFREQ;
  public double w_RIMP;
  public String _tiporap;
  public String gFatRis;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_imp_frischioR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_frischio",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("RAREA",p_cVarName)) {
      return w_RAREA;
    }
    if (CPLib.eqr("RCOMP",p_cVarName)) {
      return w_RCOMP;
    }
    if (CPLib.eqr("RRAGIO",p_cVarName)) {
      return w_RRAGIO;
    }
    if (CPLib.eqr("RTIPO",p_cVarName)) {
      return w_RTIPO;
    }
    if (CPLib.eqr("RFREQ",p_cVarName)) {
      return w_RFREQ;
    }
    if (CPLib.eqr("RIMP",p_cVarName)) {
      return w_RIMP;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_frischio";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      return w_CONNESCLI;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("DURAT",p_cVarName)) {
      return w_DURAT;
    }
    if (CPLib.eqr("AMMONT",p_cVarName)) {
      return w_AMMONT;
    }
    if (CPLib.eqr("AREAGEO",p_cVarName)) {
      return w_AREAGEO;
    }
    if (CPLib.eqr("MODSVOL",p_cVarName)) {
      return w_MODSVOL;
    }
    if (CPLib.eqr("RAGIO",p_cVarName)) {
      return w_RAGIO;
    }
    if (CPLib.eqr("TIPO",p_cVarName)) {
      return w_TIPO;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      return _tiporap;
    }
    if (CPLib.eqr("gFatRis",p_cVarName)) {
      return gFatRis;
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
    if (CPLib.eqr("RAREA",p_cVarName)) {
      w_RAREA = value;
      return;
    }
    if (CPLib.eqr("RCOMP",p_cVarName)) {
      w_RCOMP = value;
      return;
    }
    if (CPLib.eqr("RRAGIO",p_cVarName)) {
      w_RRAGIO = value;
      return;
    }
    if (CPLib.eqr("RTIPO",p_cVarName)) {
      w_RTIPO = value;
      return;
    }
    if (CPLib.eqr("RFREQ",p_cVarName)) {
      w_RFREQ = value;
      return;
    }
    if (CPLib.eqr("RIMP",p_cVarName)) {
      w_RIMP = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      w_CONNESCLI = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("DURAT",p_cVarName)) {
      w_DURAT = value;
      return;
    }
    if (CPLib.eqr("AMMONT",p_cVarName)) {
      w_AMMONT = value;
      return;
    }
    if (CPLib.eqr("AREAGEO",p_cVarName)) {
      w_AREAGEO = value;
      return;
    }
    if (CPLib.eqr("MODSVOL",p_cVarName)) {
      w_MODSVOL = value;
      return;
    }
    if (CPLib.eqr("RAGIO",p_cVarName)) {
      w_RAGIO = value;
      return;
    }
    if (CPLib.eqr("TIPO",p_cVarName)) {
      w_TIPO = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      _tiporap = value;
      return;
    }
    if (CPLib.eqr("gFatRis",p_cVarName)) {
      gFatRis = value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* Parametro */
      /* pTipo Char(1) */
      /* w_CONNESCLI Char(16) */
      /* w_RAPPORTO Char(25) */
      /* w_DURAT Char(5) */
      /* w_AMMONT Char(5) */
      /* w_AREAGEO Char(5) */
      /* w_MODSVOL Char(5) */
      /* w_RAGIO Char(5) */
      /* w_TIPO Char(3) */
      /* w_RAREA Numeric(3, 0) */
      /* w_RCOMP Numeric(3, 0) */
      /* w_RRAGIO Numeric(3, 0) */
      /* w_RTIPO Numeric(3, 0) */
      /* w_RFREQ Numeric(3, 0) */
      /* w_RIMP Numeric(3, 0) */
      /* Definizione variabili locali e globali */
      /* _tiporap Char(1) */
      /* gFatRis Char(1) // Fattore Rischio */
      /* Verifica se cliente occasionale o rapporto */
      /* If LRTrim(gFatRis) = 'S' */
      if (CPLib.eqr(CPLib.LRTrim(gFatRis),"S")) {
        /* If not(Empty(LRTrim(w_CONNESCLI))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(w_CONNESCLI)))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNESCLI,"C",16,0,m_cServer),m_cServer,w_CONNESCLI);
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AREAGEO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAREA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_AREAGEO = Read_Cursor.GetString("AREAGEO");
            w_RAREA = CPLib.Round(Read_Cursor.GetDouble("RAREA"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_frischio returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_AREAGEO = "";
            w_RAREA = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* ElseIf not(Empty(LRTrim(w_RAPPORTO))) */
        } else if ( ! (CPLib.Empty(CPLib.LRTrim(w_RAPPORTO)))) {
          /* _tiporap := '' */
          _tiporap = "";
          /* If pTipo='A' */
          if (CPLib.eqr(pTipo,"A")) {
            // * --- Read from jnarapbo
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0,m_cServer),m_cServer,w_RAPPORTO);
            if (m_Ctx.IsSharedTemp("jnarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MODSVOL",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AREAGEO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AMMONT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DURAT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RTIPO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RCOMP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RIMP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RFREQ",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RRAGIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAREA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_RAGIO = Read_Cursor.GetString("RAGIO");
              w_MODSVOL = Read_Cursor.GetString("MODSVOL");
              w_AREAGEO = Read_Cursor.GetString("AREAGEO");
              w_TIPO = Read_Cursor.GetString("TIPO");
              w_AMMONT = Read_Cursor.GetString("AMMONT");
              w_DURAT = Read_Cursor.GetString("DURAT");
              w_RTIPO = CPLib.Round(Read_Cursor.GetDouble("RTIPO"),0);
              w_RCOMP = CPLib.Round(Read_Cursor.GetDouble("RCOMP"),0);
              w_RIMP = CPLib.Round(Read_Cursor.GetDouble("RIMP"),0);
              w_RFREQ = CPLib.Round(Read_Cursor.GetDouble("RFREQ"),0);
              w_RRAGIO = CPLib.Round(Read_Cursor.GetDouble("RRAGIO"),0);
              w_RAREA = CPLib.Round(Read_Cursor.GetDouble("RAREA"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_imp_frischio returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_RAGIO = "";
              w_MODSVOL = "";
              w_AREAGEO = "";
              w_TIPO = "";
              w_AMMONT = "";
              w_DURAT = "";
              w_RTIPO = 0;
              w_RCOMP = 0;
              w_RIMP = 0;
              w_RFREQ = 0;
              w_RRAGIO = 0;
              w_RAREA = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0,m_cServer),m_cServer,w_RAPPORTO);
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tiporap = Read_Cursor.GetString("TIPORAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_imp_frischio returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tiporap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _tiporap ='D' */
            if (CPLib.eqr(_tiporap,"D")) {
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0,m_cServer),m_cServer,w_RAPPORTO);
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MODSVOL",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AREAGEO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AMMONT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DURAT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RTIPO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RCOMP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RIMP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RFREQ",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RRAGIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAREA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_RAGIO = Read_Cursor.GetString("RAGIO");
                w_MODSVOL = Read_Cursor.GetString("MODSVOL");
                w_AREAGEO = Read_Cursor.GetString("AREAGEO");
                w_TIPO = Read_Cursor.GetString("TIPO");
                w_AMMONT = Read_Cursor.GetString("AMMONT");
                w_DURAT = Read_Cursor.GetString("DURAT");
                w_RTIPO = CPLib.Round(Read_Cursor.GetDouble("RTIPO"),0);
                w_RCOMP = CPLib.Round(Read_Cursor.GetDouble("RCOMP"),0);
                w_RIMP = CPLib.Round(Read_Cursor.GetDouble("RIMP"),0);
                w_RFREQ = CPLib.Round(Read_Cursor.GetDouble("RFREQ"),0);
                w_RRAGIO = CPLib.Round(Read_Cursor.GetDouble("RRAGIO"),0);
                w_RAREA = CPLib.Round(Read_Cursor.GetDouble("RAREA"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_frischio returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_RAGIO = "";
                w_MODSVOL = "";
                w_AREAGEO = "";
                w_TIPO = "";
                w_AMMONT = "";
                w_DURAT = "";
                w_RTIPO = 0;
                w_RCOMP = 0;
                w_RIMP = 0;
                w_RFREQ = 0;
                w_RRAGIO = 0;
                w_RAREA = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* ElseIf _tiporap ='P' */
            } else if (CPLib.eqr(_tiporap,"P")) {
              // * --- Read from xnarapbo
              m_cServer = m_Ctx.GetServer("xnarapbo");
              m_cPhName = m_Ctx.GetPhName("xnarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0,m_cServer),m_cServer,w_RAPPORTO);
              if (m_Ctx.IsSharedTemp("xnarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MODSVOL",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AREAGEO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AMMONT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DURAT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RTIPO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RCOMP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RIMP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RFREQ",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RRAGIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAREA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_RAGIO = Read_Cursor.GetString("RAGIO");
                w_MODSVOL = Read_Cursor.GetString("MODSVOL");
                w_AREAGEO = Read_Cursor.GetString("AREAGEO");
                w_TIPO = Read_Cursor.GetString("TIPO");
                w_AMMONT = Read_Cursor.GetString("AMMONT");
                w_DURAT = Read_Cursor.GetString("DURAT");
                w_RTIPO = CPLib.Round(Read_Cursor.GetDouble("RTIPO"),0);
                w_RCOMP = CPLib.Round(Read_Cursor.GetDouble("RCOMP"),0);
                w_RIMP = CPLib.Round(Read_Cursor.GetDouble("RIMP"),0);
                w_RFREQ = CPLib.Round(Read_Cursor.GetDouble("RFREQ"),0);
                w_RRAGIO = CPLib.Round(Read_Cursor.GetDouble("RRAGIO"),0);
                w_RAREA = CPLib.Round(Read_Cursor.GetDouble("RAREA"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_frischio returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_RAGIO = "";
                w_MODSVOL = "";
                w_AREAGEO = "";
                w_TIPO = "";
                w_AMMONT = "";
                w_DURAT = "";
                w_RTIPO = 0;
                w_RCOMP = 0;
                w_RIMP = 0;
                w_RFREQ = 0;
                w_RRAGIO = 0;
                w_RAREA = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
          } // End If
        } // End If
      } // End If
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
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
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
      m_Caller.SetString("CONNESCLI","C",16,0,w_CONNESCLI);
      m_Caller.SetString("RAPPORTO","C",25,0,w_RAPPORTO);
      m_Caller.SetString("DURAT","C",5,0,w_DURAT);
      m_Caller.SetString("AMMONT","C",5,0,w_AMMONT);
      m_Caller.SetString("AREAGEO","C",5,0,w_AREAGEO);
      m_Caller.SetString("MODSVOL","C",5,0,w_MODSVOL);
      m_Caller.SetString("RAGIO","C",5,0,w_RAGIO);
      m_Caller.SetString("TIPO","C",3,0,w_TIPO);
      m_Caller.SetNumber("RAREA","N",3,0,w_RAREA);
      m_Caller.SetNumber("RCOMP","N",3,0,w_RCOMP);
      m_Caller.SetNumber("RRAGIO","N",3,0,w_RRAGIO);
      m_Caller.SetNumber("RTIPO","N",3,0,w_RTIPO);
      m_Caller.SetNumber("RFREQ","N",3,0,w_RFREQ);
      m_Caller.SetNumber("RIMP","N",3,0,w_RIMP);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_frischioR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_frischioR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_CONNESCLI = m_Caller.GetString("CONNESCLI","C",16,0);
    w_RAPPORTO = m_Caller.GetString("RAPPORTO","C",25,0);
    w_DURAT = m_Caller.GetString("DURAT","C",5,0);
    w_AMMONT = m_Caller.GetString("AMMONT","C",5,0);
    w_AREAGEO = m_Caller.GetString("AREAGEO","C",5,0);
    w_MODSVOL = m_Caller.GetString("MODSVOL","C",5,0);
    w_RAGIO = m_Caller.GetString("RAGIO","C",5,0);
    w_TIPO = m_Caller.GetString("TIPO","C",3,0);
    w_RAREA = m_Caller.GetNumber("RAREA","N",3,0);
    w_RCOMP = m_Caller.GetNumber("RCOMP","N",3,0);
    w_RRAGIO = m_Caller.GetNumber("RRAGIO","N",3,0);
    w_RTIPO = m_Caller.GetNumber("RTIPO","N",3,0);
    w_RFREQ = m_Caller.GetNumber("RFREQ","N",3,0);
    w_RIMP = m_Caller.GetNumber("RIMP","N",3,0);
    _tiporap = CPLib.Space(1);
    gFatRis=m_Ctx.GetGlobalString("gFatRis");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pTipo"};
}
