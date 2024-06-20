// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_startlogoR implements CallerWithObjs {
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
  public String m_cPhName_webaos_agg_soggetti;
  public String m_cServer_webaos_agg_soggetti;
  public String m_cPhName_tbtipleg;
  public String m_cServer_tbtipleg;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
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
  public double gUserCode;
  public java.sql.Date gDatDel;
  public java.sql.Date gDatTra;
  public java.sql.Date gDatTER;
  public String gIntemediario;
  public String gTipInter;
  public String gPathApp;
  public String gUrlApp;
  public String cActLog;
  public String gFlgWU;
  public String gSeekAos;
  public String gSblocco;
  public String gEmail;
  public String gDescAzi;
  public String gChkDate;
  public String gAzienda;
  public String gFatRis;
  public String gTelepass;
  public String gFlgDoc;
  public String gCodDip;
  public String gFlgCMod;
  public double gFlgDTP;
  public double gVLT;
  public double gVNP;
  public String gStpDwn;
  public String gWebCHK;
  public String gIPC;
  public String gIPS;
  public String gIPSP;
  public String gIPP;
  public String gFlgRet;
  public java.sql.Date gDataTito;
  public java.sql.Date gScadSaldi;
  public String gFlgIPMT;
  public String cAnno;
  public double nMese;
  public String cMese;
  public String cGiorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_startlogoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_startlogo",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_webaos_agg_soggetti = p_ContextObject.GetPhName("webaos_agg_soggetti");
    if (m_cPhName_webaos_agg_soggetti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webaos_agg_soggetti = m_cPhName_webaos_agg_soggetti+" "+m_Ctx.GetWritePhName("webaos_agg_soggetti");
    }
    m_cServer_webaos_agg_soggetti = p_ContextObject.GetServer("webaos_agg_soggetti");
    m_cPhName_tbtipleg = p_ContextObject.GetPhName("tbtipleg");
    if (m_cPhName_tbtipleg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipleg = m_cPhName_tbtipleg+" "+m_Ctx.GetWritePhName("tbtipleg");
    }
    m_cServer_tbtipleg = p_ContextObject.GetServer("tbtipleg");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      return gFlgDTP;
    }
    if (CPLib.eqr("gVLT",p_cVarName)) {
      return gVLT;
    }
    if (CPLib.eqr("gVNP",p_cVarName)) {
      return gVNP;
    }
    if (CPLib.eqr("nMese",p_cVarName)) {
      return nMese;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_startlogo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    if (CPLib.eqr("gSeekAos",p_cVarName)) {
      return gSeekAos;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      return gSblocco;
    }
    if (CPLib.eqr("gEmail",p_cVarName)) {
      return gEmail;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gChkDate",p_cVarName)) {
      return gChkDate;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gFatRis",p_cVarName)) {
      return gFatRis;
    }
    if (CPLib.eqr("gTelepass",p_cVarName)) {
      return gTelepass;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      return gFlgDoc;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("gFlgCMod",p_cVarName)) {
      return gFlgCMod;
    }
    if (CPLib.eqr("gStpDwn",p_cVarName)) {
      return gStpDwn;
    }
    if (CPLib.eqr("gWebCHK",p_cVarName)) {
      return gWebCHK;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      return gIPS;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      return gIPSP;
    }
    if (CPLib.eqr("gIPP",p_cVarName)) {
      return gIPP;
    }
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      return gFlgRet;
    }
    if (CPLib.eqr("gFlgIPMT",p_cVarName)) {
      return gFlgIPMT;
    }
    if (CPLib.eqr("cAnno",p_cVarName)) {
      return cAnno;
    }
    if (CPLib.eqr("cMese",p_cVarName)) {
      return cMese;
    }
    if (CPLib.eqr("cGiorno",p_cVarName)) {
      return cGiorno;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      return gDatDel;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      return gDatTra;
    }
    if (CPLib.eqr("gDatTER",p_cVarName)) {
      return gDatTER;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      return gDataTito;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      return gScadSaldi;
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      gFlgDTP = value;
      return;
    }
    if (CPLib.eqr("gVLT",p_cVarName)) {
      gVLT = value;
      return;
    }
    if (CPLib.eqr("gVNP",p_cVarName)) {
      gVNP = value;
      return;
    }
    if (CPLib.eqr("nMese",p_cVarName)) {
      nMese = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
      return;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
    if (CPLib.eqr("gSeekAos",p_cVarName)) {
      gSeekAos = value;
      return;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      gSblocco = value;
      return;
    }
    if (CPLib.eqr("gEmail",p_cVarName)) {
      gEmail = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gChkDate",p_cVarName)) {
      gChkDate = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gFatRis",p_cVarName)) {
      gFatRis = value;
      return;
    }
    if (CPLib.eqr("gTelepass",p_cVarName)) {
      gTelepass = value;
      return;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      gFlgDoc = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("gFlgCMod",p_cVarName)) {
      gFlgCMod = value;
      return;
    }
    if (CPLib.eqr("gStpDwn",p_cVarName)) {
      gStpDwn = value;
      return;
    }
    if (CPLib.eqr("gWebCHK",p_cVarName)) {
      gWebCHK = value;
      return;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      gIPS = value;
      return;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      gIPSP = value;
      return;
    }
    if (CPLib.eqr("gIPP",p_cVarName)) {
      gIPP = value;
      return;
    }
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      gFlgRet = value;
      return;
    }
    if (CPLib.eqr("gFlgIPMT",p_cVarName)) {
      gFlgIPMT = value;
      return;
    }
    if (CPLib.eqr("cAnno",p_cVarName)) {
      cAnno = value;
      return;
    }
    if (CPLib.eqr("cMese",p_cVarName)) {
      cMese = value;
      return;
    }
    if (CPLib.eqr("cGiorno",p_cVarName)) {
      cGiorno = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      gDatDel = value;
      return;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      gDatTra = value;
      return;
    }
    if (CPLib.eqr("gDatTER",p_cVarName)) {
      gDatTER = value;
      return;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      gDataTito = value;
      return;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      gScadSaldi = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_webaos_agg_soggetti=null;
    try {
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      /* gDatDel Date // Data Massima Cancellazione Operazioni */
      /* gDatTra Date // Data Massima Trasf a Storico */
      /* gDatTER Date // Data Massima Trasf a Storico */
      /* gIntemediario Char(11) // Intermediario */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* cActLog Char(1) // Log Applicazione */
      /* gFlgWU Char(1) // Gestione WU */
      /* gSeekAos Char(1) // Collegamento con AOS */
      /* gSblocco Char(1) // Sblocco controllo */
      /* gEmail Char(40) // Email Utente */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gChkDate Char(1) // Controllo Date */
      /* gAzienda Char(10) // Azienda */
      /* gFatRis Char(1) // Fattore Rischio */
      /* gTelepass Char(1) // Versione Telepass */
      /* gFlgDoc Char(1) // Collegamento con storico documenti */
      /* gCodDip Char(6) // Dipendenza */
      /* gFlgCMod Char(1) // Crea Record Modifica */
      /* gFlgDTP Numeric(1, 0) // Forza Data Trasferimento Provvisorie */
      /* gVLT Numeric(10, 2) // Limite VLT */
      /* gVNP Numeric(10, 2) // Limite VNT */
      /* gStpDwn Char(1) // Stampa Download */
      /* gWebCHK Char(1) // Collegamento a WEBCHK */
      /* gIPC Char(20) // IPClient */
      /* gIPS Char(120) // IPServer */
      /* gIPSP Char(20) // Porta Server */
      /* gIPP Char(10) // Protocollo URL */
      /* gFlgRet Char(1) // Flag Creazione File di Ritorno */
      /* gDataTito Date // Data per Titolari Effettivi */
      /* gScadSaldi Date // Scadenza Invio Saldi */
      /* gFlgIPMT Char(1) // IP MoneyTrasfer */
      /* Variabili locali */
      /* cAnno Char(4) */
      /* nMese Numeric(2, 0) */
      /* cMese Char(2) */
      /* cGiorno Char(2) */
      /* gSblocco := 'N' // Sblocco controllo */
      gSblocco = "N";
      m_Ctx.SetGlobalString("gSblocco",gSblocco);
      /* cAnno := Str(Year(Date()),4,0) */
      cAnno = CPLib.Str(CPLib.Year(CPLib.Date()),4,0);
      /* nMese := Month(Date()) */
      nMese = CPLib.Round(CPLib.Month(CPLib.Date()),0);
      /* Case nMese = 1 */
      if (CPLib.eqr(nMese,1)) {
        /* cMese := '10' */
        cMese = "10";
        /* Case nMese = 2 */
      } else if (CPLib.eqr(nMese,2)) {
        /* cMese := '11' */
        cMese = "11";
        /* Case nMese = 3 */
      } else if (CPLib.eqr(nMese,3)) {
        /* cMese := '12' */
        cMese = "12";
      } else { // Otherwise
        /* cMese := Right('00'+LRTrim(Str(nMese - 3,2,0)),2) */
        cMese = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(nMese-3,2,0)),2);
      } // End Case
      /* cGiorno := Right('00'+LRTrim(Str(Day(Date()),2,0)),2) */
      cGiorno = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Day(CPLib.Date()),2,0)),2);
      /* gDatTra := CharToDate(cAnno+cMese+cGiorno) // Data Massima Trasf a Storico */
      gDatTra = CPLib.CharToDate(cAnno+cMese+cGiorno);
      m_Ctx.SetGlobalDate("gDatTra",gDatTra);
      /* cAnno := Str(Year(Date()) - 10,4,0) */
      cAnno = CPLib.Str(CPLib.Year(CPLib.Date())-10,4,0);
      /* cMese := Right('00'+LRTrim(Str(Month(Date()),2,0)),2) */
      cMese = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(CPLib.Date()),2,0)),2);
      /* cGiorno := Right('00'+LRTrim(Str(Day(Date()),2,0)),2) */
      cGiorno = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Day(CPLib.Date()),2,0)),2);
      /* gDatDel := CharToDate(cAnno+cMese+cGiorno) // Data Massima Cancellazione Operazioni */
      gDatDel = CPLib.CharToDate(cAnno+cMese+cGiorno);
      m_Ctx.SetGlobalDate("gDatDel",gDatDel);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* gIntemediario := intermbo->CODINTER // Intermediario */
        gIntemediario = Cursor_intermbo.GetString("CODINTER");
        m_Ctx.SetGlobalString("gIntemediario",gIntemediario);
        /* gTipInter := intermbo->TIPINTER // Tipo Intermediario */
        gTipInter = Cursor_intermbo.GetString("TIPINTER");
        m_Ctx.SetGlobalString("gTipInter",gTipInter);
        /* cActLog := intermbo->FLGLOG // Log Applicazione */
        cActLog = Cursor_intermbo.GetString("FLGLOG");
        m_Ctx.SetGlobalString("cActLog",cActLog);
        /* gSeekAos := intermbo->FLGAOS // Collegamento con AOS */
        gSeekAos = Cursor_intermbo.GetString("FLGAOS");
        m_Ctx.SetGlobalString("gSeekAos",gSeekAos);
        /* gDescAzi := intermbo->RAGSOC // Descrizione Intermediario */
        gDescAzi = Cursor_intermbo.GetString("RAGSOC");
        m_Ctx.SetGlobalString("gDescAzi",gDescAzi);
        /* gChkDate := intermbo->SOSPMAF // Controllo Date */
        gChkDate = Cursor_intermbo.GetString("SOSPMAF");
        m_Ctx.SetGlobalString("gChkDate",gChkDate);
        /* gFatRis := intermbo->FLGEAOS // Fattore Rischio */
        gFatRis = Cursor_intermbo.GetString("FLGEAOS");
        m_Ctx.SetGlobalString("gFatRis",gFatRis);
        /* gFlgDoc := intermbo->FLGCDOC // Collegamento con storico documenti */
        gFlgDoc = Cursor_intermbo.GetString("FLGCDOC");
        m_Ctx.SetGlobalString("gFlgDoc",gFlgDoc);
        /* gTelepass := intermbo->FLGAPERS // Versione Telepass */
        gTelepass = Cursor_intermbo.GetString("FLGAPERS");
        m_Ctx.SetGlobalString("gTelepass",gTelepass);
        /* gFlgWU := intermbo->FLGWU // Gestione WU */
        gFlgWU = Cursor_intermbo.GetString("FLGWU");
        m_Ctx.SetGlobalString("gFlgWU",gFlgWU);
        /* gFlgCMod := intermbo->FLGOPEXTR // Crea Record Modifica */
        gFlgCMod = Cursor_intermbo.GetString("FLGOPEXTR");
        m_Ctx.SetGlobalString("gFlgCMod",gFlgCMod);
        /* gFlgDTP := intermbo->FLGDATATP // Forza Data Trasferimento Provvisorie */
        gFlgDTP = CPLib.Round(Cursor_intermbo.GetDouble("FLGDATATP"),0);
        m_Ctx.SetGlobalNumber("gFlgDTP",gFlgDTP);
        /* gVLT := intermbo->LIMITVLT // Limite VLT */
        gVLT = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVLT"),2);
        m_Ctx.SetGlobalNumber("gVLT",gVLT);
        /* gVNP := intermbo->LIMITVNP // Limite VNT */
        gVNP = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVNP"),2);
        m_Ctx.SetGlobalNumber("gVNP",gVNP);
        /* gStpDwn := intermbo->FLGSTPDIR // Stampa Download */
        gStpDwn = Cursor_intermbo.GetString("FLGSTPDIR");
        m_Ctx.SetGlobalString("gStpDwn",gStpDwn);
        /* gWebCHK := intermbo->FLGCHK // Collegamento a WEBCHK */
        gWebCHK = Cursor_intermbo.GetString("FLGCHK");
        m_Ctx.SetGlobalString("gWebCHK",gWebCHK);
        /* gUrlApp := LRTrim(gIPP)+'://'+LRTrim(gIPS)+":"+LRTrim(gIPSP)+"/"+LRTrim(intermbo->URLAPPL)+"/" // URL Applicazione */
        gUrlApp = CPLib.LRTrim(gIPP)+"://"+CPLib.LRTrim(gIPS)+":"+CPLib.LRTrim(gIPSP)+"/"+CPLib.LRTrim(Cursor_intermbo.GetString("URLAPPL"))+"/";
        m_Ctx.SetGlobalString("gUrlApp",gUrlApp);
        /* gPathApp := Strtran(FileLibMit.GetLocation(),'\','/') // Path Applicazione */
        gPathApp = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
        m_Ctx.SetGlobalString("gPathApp",gPathApp);
        /* gFlgRet := intermbo->FLGRITORNO // Flag Creazione File di Ritorno */
        gFlgRet = Cursor_intermbo.GetString("FLGRITORNO");
        m_Ctx.SetGlobalString("gFlgRet",gFlgRet);
        /* gDataTito := intermbo->DTTITAGE // Data per Titolari Effettivi */
        gDataTito = Cursor_intermbo.GetDate("DTTITAGE");
        m_Ctx.SetGlobalDate("gDataTito",gDataTito);
        /* gScadSaldi := intermbo->SCADSALDI // Scadenza Invio Saldi */
        gScadSaldi = Cursor_intermbo.GetDate("SCADSALDI");
        m_Ctx.SetGlobalDate("gScadSaldi",gScadSaldi);
        /* gFlgIPMT := intermbo->FLGIPMT // IP MoneyTrasfer */
        gFlgIPMT = Cursor_intermbo.GetString("FLGIPMT");
        m_Ctx.SetGlobalString("gFlgIPMT",gFlgIPMT);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* gPathApp := Left(gPathApp,Len(LRTrim(gPathApp))-1) // Path Applicazione */
      gPathApp = CPLib.Left(gPathApp,CPLib.Len(CPLib.LRTrim(gPathApp))-1);
      m_Ctx.SetGlobalString("gPathApp",gPathApp);
      /* If gSeekAos='S' */
      if (CPLib.eqr(gSeekAos,"S")) {
        // * --- Select from webaos_agg_soggetti
        m_cServer = m_Ctx.GetServer("webaos_agg_soggetti");
        m_cPhName = m_Ctx.GetPhName("webaos_agg_soggetti");
        if (Cursor_webaos_agg_soggetti!=null)
          Cursor_webaos_agg_soggetti.Close();
        Cursor_webaos_agg_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("webaos_agg_soggetti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webaos_agg_soggetti.Eof())) {
          /* gDatTER := webaos_agg_soggetti->ULTAGGSOG // Ultimo Aggiornamento TER */
          gDatTER = Cursor_webaos_agg_soggetti.GetDate("ULTAGGSOG");
          m_Ctx.SetGlobalDate("gDatTER",gDatTER);
          Cursor_webaos_agg_soggetti.Next();
        }
        m_cConnectivityError = Cursor_webaos_agg_soggetti.ErrorMessage();
        Cursor_webaos_agg_soggetti.Close();
        // * --- End Select
      } // End If
      /* Stop jsp/start_page_logo_portlet.jsp */
      Forward f;
      f=new Forward("../jsp/start_page_logo_portlet.jsp",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webaos_agg_soggetti!=null)
          Cursor_webaos_agg_soggetti.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_startlogoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_startlogoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cAnno = CPLib.Space(4);
    nMese = 0;
    cMese = CPLib.Space(2);
    cGiorno = CPLib.Space(2);
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
    gDatDel=m_Ctx.GetGlobalDate("gDatDel");
    gDatTra=m_Ctx.GetGlobalDate("gDatTra");
    gDatTER=m_Ctx.GetGlobalDate("gDatTER");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    cActLog=m_Ctx.GetGlobalString("cActLog");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
    gSeekAos=m_Ctx.GetGlobalString("gSeekAos");
    gSblocco=m_Ctx.GetGlobalString("gSblocco");
    gEmail=m_Ctx.GetGlobalString("gEmail");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gChkDate=m_Ctx.GetGlobalString("gChkDate");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gFatRis=m_Ctx.GetGlobalString("gFatRis");
    gTelepass=m_Ctx.GetGlobalString("gTelepass");
    gFlgDoc=m_Ctx.GetGlobalString("gFlgDoc");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
    gFlgCMod=m_Ctx.GetGlobalString("gFlgCMod");
    gFlgDTP=m_Ctx.GetGlobalNumber("gFlgDTP");
    gVLT=m_Ctx.GetGlobalNumber("gVLT");
    gVNP=m_Ctx.GetGlobalNumber("gVNP");
    gStpDwn=m_Ctx.GetGlobalString("gStpDwn");
    gWebCHK=m_Ctx.GetGlobalString("gWebCHK");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
    gIPP=m_Ctx.GetGlobalString("gIPP");
    gFlgRet=m_Ctx.GetGlobalString("gFlgRet");
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
    gFlgIPMT=m_Ctx.GetGlobalString("gFlgIPMT");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
