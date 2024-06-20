// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_dlgspecifici_telepassR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_tmp_apecod;
  public String m_cServer_tmp_apecod;
  public String m_cPhName_tmp_stpfileage;
  public String m_cServer_tmp_stpfileage;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_qbe_rapopebo_uic;
  public String m_cServer_qbe_rapopebo_uic;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
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
  public String w_codinter;
  public String w_tipinter;
  public String gPathApp;
  public String gIntemediario;
  public String gUrlApp;
  public String gAzienda;
  public String gMsgImp;
  public String w_codcab;
  public String w_cabcod;
  public String w_cabper;
  public String w_desccit;
  public String w_citdesc;
  public String w_provin;
  public String w_provind;
  public String w_coddipe;
  public String _note;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public double nTotRec;
  public double nTotReg;
  public double nNumRec;
  public double _avanza;
  public String _codrif;
  public double _conta;
  public double _max;
  public double _min;
  public double _top;
  public double _bottom;
  public double _cicli;
  public double _contacilci;
  public double _ctotale;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_dlgspecifici_telepassR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_dlgspecifici_telepass",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_tmp_apecod = p_ContextObject.GetPhName("tmp_apecod");
    if (m_cPhName_tmp_apecod.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_apecod = m_cPhName_tmp_apecod+" "+m_Ctx.GetWritePhName("tmp_apecod");
    }
    m_cServer_tmp_apecod = p_ContextObject.GetServer("tmp_apecod");
    m_cPhName_tmp_stpfileage = p_ContextObject.GetPhName("tmp_stpfileage");
    if (m_cPhName_tmp_stpfileage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stpfileage = m_cPhName_tmp_stpfileage+" "+m_Ctx.GetWritePhName("tmp_stpfileage");
    }
    m_cServer_tmp_stpfileage = p_ContextObject.GetServer("tmp_stpfileage");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_qbe_rapopebo_uic = p_ContextObject.GetPhName("qbe_rapopebo_uic");
    if (m_cPhName_qbe_rapopebo_uic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_qbe_rapopebo_uic = m_cPhName_qbe_rapopebo_uic+" "+m_Ctx.GetWritePhName("qbe_rapopebo_uic");
    }
    m_cServer_qbe_rapopebo_uic = p_ContextObject.GetServer("qbe_rapopebo_uic");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      return nTotRec;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      return nTotReg;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      return nNumRec;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_dlgspecifici_telepass";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("codinter",p_cVarName)) {
      return w_codinter;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return w_tipinter;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return w_codcab;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      return w_cabcod;
    }
    if (CPLib.eqr("cabper",p_cVarName)) {
      return w_cabper;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return w_desccit;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      return w_citdesc;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      return w_provin;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      return w_provind;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      return w_coddipe;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      return _note;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_codrif",p_cVarName)) {
      return _codrif;
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
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      nTotRec = value;
      return;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      nTotReg = value;
      return;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      nNumRec = value;
      return;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      _avanza = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("codinter",p_cVarName)) {
      w_codinter = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      w_tipinter = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      w_codcab = value;
      return;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      w_cabcod = value;
      return;
    }
    if (CPLib.eqr("cabper",p_cVarName)) {
      w_cabper = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      w_desccit = value;
      return;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      w_citdesc = value;
      return;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      w_provin = value;
      return;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      w_provind = value;
      return;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      w_coddipe = value;
      return;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      _note = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("_codrif",p_cVarName)) {
      _codrif = value;
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
    /* w_codinter Char(11) */
    /* w_tipinter Char(2) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gIntemediario Char(11) // Intermediario */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio Import */
    /* w_codcab Char(6) */
    /* w_cabcod Char(6) */
    /* w_cabper Char(6) */
    /* w_desccit Char(30) */
    /* w_citdesc Char(30) */
    /* w_provin Char(2) */
    /* w_provind Char(2) */
    /* w_coddipe Char(6) */
    /* _note Memo */
    /* fhand Char(10) */
    /* _nomefile Char(15) */
    /* cNomeFile Char(30) */
    /* cOnlyNomeFile Char(30) */
    /* cNomeFileZip Char(30) */
    /* nTotRec Numeric(10, 0) */
    /* nTotReg Numeric(10, 0) */
    /* nNumRec Numeric(10, 0) */
    /* _avanza Numeric(1, 0) */
    /* _codrif Char(16) */
    /* _conta Numeric(4, 0) */
    /* _max Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _contacilci Numeric(15, 0) */
    /* _ctotale Numeric(15, 0) */
    /* Apre il file di scrittura (campioni.txt) */
    /* _conta := 1 */
    _conta = CPLib.Round(1,0);
    /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
    _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
    /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
    fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
    /* _codrif := '' */
    _codrif = "";
    /* _ctotale := 0 */
    _ctotale = CPLib.Round(0,0);
    /* Exec "Operazioni" Page 2 */
    Page_2();
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* Exec "Informazioni" Page 3 */
    Page_3();
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* Cicla sulle operazioni */
      // * --- Select from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("operazbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_operazbo.Eof())) {
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _note := w_tipinter + w_codinter + '1' */
        _note = w_tipinter+w_codinter+"1";
        /* _note := _note + DateToChar(operazbo->DATAOPE) + operazbo->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',operazbo->STATOREG) */
        _note = _note+CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE"))+Cursor_operazbo.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_operazbo.GetString("STATOREG"));
        /* If Empty(operazbo->CODDIPE) or Empty(operazbo->CODCAB) */
        if (CPLib.Empty(Cursor_operazbo.GetString("CODDIPE")) || CPLib.Empty(Cursor_operazbo.GetString("CODCAB"))) {
          // * --- Read from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
          if (m_Ctx.IsSharedTemp("intermbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            w_codcab = Read_Cursor.GetString("CODCAB");
            w_desccit = Read_Cursor.GetString("DESCCIT");
            w_provin = Read_Cursor.GetString("PROVINCIA");
            w_coddipe = Read_Cursor.GetString("CODDIPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            w_codcab = "";
            w_desccit = "";
            w_provin = "";
            w_coddipe = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(w_coddipe) */
          if (CPLib.Empty(w_coddipe)) {
            /* _note := _note + '000000' + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
            _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
          } else { // Else
            /* _note := _note + w_coddipe */
            _note = _note+w_coddipe;
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_cabcod = Read_Cursor.GetString("CAB");
              w_citdesc = Read_Cursor.GetString("DESCCIT");
              w_provind = Read_Cursor.GetString("PROVINCIA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_cabcod = "";
              w_citdesc = "";
              w_provind = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_cabcod) */
            if (CPLib.Empty(w_cabcod)) {
              /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
            } // End If
          } // End If
        } else { // Else
          /* _note := _note + operazbo->CODDIPE + operazbo->CODCAB + operazbo->DESCCIT + operazbo->PROVINCIA */
          _note = _note+Cursor_operazbo.GetString("CODDIPE")+Cursor_operazbo.GetString("CODCAB")+Cursor_operazbo.GetString("DESCCIT")+Cursor_operazbo.GetString("PROVINCIA");
        } // End If
        /* _note := _note + Left(DateToChar(operazbo->DATAOPE)+Space(8),8) + Left(LRTrim(operazbo->FLAGFRAZ)+" ",1) + Left(LRTrim(operazbo->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(operazbo->CODANA)+Space(4),4) + Left(LRTrim(operazbo->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(operazbo->TIPOINT2)+Space(2),2) + Left(LRTrim(operazbo->CODINT2)+Space(11),11) + Left(LRTrim(operazbo->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(operazbo->CODCAB2)+Space(6),6) + Left(LRTrim(operazbo->DESC2)+Space(30),30) + Left(LRTrim(operazbo->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(operazbo->DESCINTER)+Space(50),50) + Left(LRTrim(operazbo->RAPPORTO)+Space(25),25) + Left(LRTrim(operazbo->FLAGRAP)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("FLAGRAP"))+" ",1);
        /* _note := _note + Left(LRTrim(operazbo->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(operazbo->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_operazbo.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(operazbo->TIPOOPRAP)+Space(2),2) + Left(LRTrim(operazbo->COLLEG)+Space(11),11) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("COLLEG"))+CPLib.Space(11),11);
        /* _note := _note + " " + Left(LRTrim(operazbo->STATOREG)+" ",1)  */
        _note = _note+" "+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("STATOREG"))+" ",1);
        /* If Empty(operazbo->DATARETT) or DateToChar(operazbo->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_operazbo.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_operazbo.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(operazbo->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_operazbo.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* _note := _note + Left(LRTrim(operazbo->OPERAZMOD)+Space(20),20) + Left(LRTrim(operazbo->FLAGLIRE)+" ",1) + Left(LRTrim(operazbo->VALUTA)+Space(3),3) + Left(LRTrim(operazbo->SEGNO)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("OPERAZMOD"))+CPLib.Space(20),20)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(operazbo->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(operazbo->TOTCONT,15,0)),15) + Space(69) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_operazbo.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_operazbo.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
        /* FileLibMit.WriteLine(fhand,_note) */
        FileLibMit.WriteLine(fhand,_note);
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(operazbo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESCLI")))) {
          /* _codrif := operazbo->CONNESCLI */
          _codrif = Cursor_operazbo.GetString("CONNESCLI");
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* _note := w_tipinter + w_codinter */
            _note = w_tipinter+w_codinter;
            /* If Empty(operazbo->CONNESOPER) or (operazbo->CONNESOPER=operazbo->CONNESCLI) */
            if (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_operazbo.GetString("CONNESOPER"),Cursor_operazbo.GetString("CONNESCLI")))) {
              /* _note := _note + '2' */
              _note = _note+"2";
            } else { // Else
              /* _note := _note + '3' */
              _note = _note+"3";
            } // End If
            /* w_cabper := '' */
            w_cabper = "";
            /* If Empty(LRTrim(personbo->CODCAB)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabper = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabper = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* w_cabper := personbo->CODCAB */
              w_cabper = Cursor_personbo.GetString("CODCAB");
            } // End If
            /* _note := _note + Left(LRTrim(DateToChar(operazbo->DATAOPE))+Space(8),8) + operazbo->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',operazbo->STATOREG) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_operazbo.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_operazbo.GetString("STATOREG"));
            /* _note := _note + Left(LRTrim(operazbo->CONNESCLI)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(w_cabper)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
            /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
            /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
            if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
            } // End If
            /* If not(Empty(personbo->NASSTATO)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
              /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
            } else { // Else
              /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
            } // End If
            /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(operazbo->RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Left(LRTrim(operazbo->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
            /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
            if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
            } // End If
            /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } else { // Else
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If (operazbo->RAPPORTO+'P') = (intestbo->RAPPORTO+intestbo->TIPOPERS) */
            if (CPLib.eqr((Cursor_operazbo.GetString("RAPPORTO")+"P"),(Cursor_intestbo.GetString("RAPPORTO")+Cursor_intestbo.GetString("TIPOPERS")))) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If intestbo->DATAINI > operazbo->DATAOPE */
              if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_operazbo.GetDate("DATAOPE"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < operazbo->DATAOPE */
              if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_operazbo.GetDate("DATAOPE"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza = 0 */
              if (CPLib.eqr(_avanza,0)) {
                /* _codrif := intestbo->CODINTER */
                _codrif = Cursor_intestbo.GetString("CODINTER");
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter */
                  _note = w_tipinter+w_codinter;
                  /* If Empty(operazbo->CONNESOPER) or (operazbo->CONNESOPER=operazbo->CONNESCLI) */
                  if (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_operazbo.GetString("CONNESOPER"),Cursor_operazbo.GetString("CONNESCLI")))) {
                    /* _note := _note + '2' */
                    _note = _note+"2";
                  } else { // Else
                    /* _note := _note + '3' */
                    _note = _note+"3";
                  } // End If
                  /* w_cabper := '' */
                  w_cabper = "";
                  /* If Empty(LRTrim(personbo->CODCAB)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      w_cabper = Read_Cursor.GetString("CAB");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      w_cabper = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    /* w_cabper := personbo->CODCAB */
                    w_cabper = Cursor_personbo.GetString("CODCAB");
                  } // End If
                  /* _note := _note + Left(LRTrim(DateToChar(operazbo->DATAOPE))+Space(8),8) + operazbo->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',operazbo->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_operazbo.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_operazbo.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(intestbo->CODINTER)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(w_cabper)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(operazbo->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(operazbo->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_operazbo.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(operazbo->CONNESOPER)) and operazbo->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER"))) && CPLib.ne(Cursor_operazbo.GetString("CONNESOPER"),_codrif)) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* w_cabper := '' */
            w_cabper = "";
            /* If Empty(LRTrim(personbo->CODCAB)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabper = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabper = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* w_cabper := personbo->CODCAB */
              w_cabper = Cursor_personbo.GetString("CODCAB");
            } // End If
            /* _note := w_tipinter + w_codinter+'4' */
            _note = w_tipinter+w_codinter+"4";
            /* _note := _note + DateToChar(operazbo->DATAOPE) + operazbo->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',operazbo->STATOREG) */
            _note = _note+CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE"))+Cursor_operazbo.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_operazbo.GetString("STATOREG"));
            /* _note := _note + operazbo->CONNESOPER + personbo->RAGSOC + personbo->PAESE + Left(LRTrim(w_cabper)+Space(6),6) + personbo->DESCCIT + personbo->PROVINCIA */
            _note = _note+Cursor_operazbo.GetString("CONNESOPER")+Cursor_personbo.GetString("RAGSOC")+Cursor_personbo.GetString("PAESE")+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+Cursor_personbo.GetString("DESCCIT")+Cursor_personbo.GetString("PROVINCIA");
            /* _note := _note + personbo->DOMICILIO + Left(LRTrim(personbo->CAP)+ Space(5),5) + personbo->CODFISC + DateToChar(personbo->DATANASC) */
            _note = _note+Cursor_personbo.GetString("DOMICILIO")+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5)+Cursor_personbo.GetString("CODFISC")+CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC"));
            /* _note := _note + personbo->NASCOMUN + Space(35) */
            _note = _note+Cursor_personbo.GetString("NASCOMUN")+CPLib.Space(35);
            /* _note := _note + personbo->TIPODOC + personbo->NUMDOCUM + DateToChar(personbo->DATARILASC) + personbo->AUTRILASC */
            _note = _note+Cursor_personbo.GetString("TIPODOC")+Cursor_personbo.GetString("NUMDOCUM")+CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC"))+Cursor_personbo.GetString("AUTRILASC");
            /* _note := _note + personbo->SESSO + Space(34) */
            _note = _note+Cursor_personbo.GetString("SESSO")+CPLib.Space(34);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(operazbo->CONNESBEN)) and (operazbo->CODVOC='16' or operazbo->CODVOC='17' or operazbo->CODVOC='30' or operazbo->CODVOC='35') */
        if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESBEN"))) && (CPLib.eqr(Cursor_operazbo.GetString("CODVOC"),"16") || CPLib.eqr(Cursor_operazbo.GetString("CODVOC"),"17") || CPLib.eqr(Cursor_operazbo.GetString("CODVOC"),"30") || CPLib.eqr(Cursor_operazbo.GetString("CODVOC"),"35"))) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* w_cabper := '' */
            w_cabper = "";
            /* If Empty(LRTrim(personbo->CODCAB)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabper = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabper = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* w_cabper := personbo->CODCAB */
              w_cabper = Cursor_personbo.GetString("CODCAB");
            } // End If
            /* _note := w_tipinter + w_codinter+'5' */
            _note = w_tipinter+w_codinter+"5";
            /* _note := _note + DateToChar(operazbo->DATAOPE) + operazbo->NUMPROG + LibreriaMit.StatoReg('OPERAZBO',operazbo->STATOREG) */
            _note = _note+CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE"))+Cursor_operazbo.GetString("NUMPROG")+LibreriaMit.StatoReg("OPERAZBO",Cursor_operazbo.GetString("STATOREG"));
            /* _note := _note + operazbo->CONNESBEN + personbo->RAGSOC + personbo->PAESE +  Left(LRTrim(w_cabper)+Space(6),6) + personbo->DESCCIT + personbo->PROVINCIA */
            _note = _note+Cursor_operazbo.GetString("CONNESBEN")+Cursor_personbo.GetString("RAGSOC")+Cursor_personbo.GetString("PAESE")+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+Cursor_personbo.GetString("DESCCIT")+Cursor_personbo.GetString("PROVINCIA");
            /* _note := _note + personbo->DOMICILIO + Left(LRTrim(personbo->CAP)+ Space(5),5) + Space(63) + operazbo->RAPPORTBEN + Space(91) */
            _note = _note+Cursor_personbo.GetString("DOMICILIO")+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5)+CPLib.Space(63)+Cursor_operazbo.GetString("RAPPORTBEN")+CPLib.Space(91);
            /* FileLibMit.WriteLine(fhand,_note) */
            FileLibMit.WriteLine(fhand,_note);
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        Cursor_operazbo.Next();
      }
      m_cConnectivityError = Cursor_operazbo.ErrorMessage();
      Cursor_operazbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_uic_minmax=null;
    CPResultSet Cursor_qbe_rapopebo_uic=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle informazioni sui rapporti */
      /* gMsgImp := 'Verifica Rapporti da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Rapporti da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_uic_minmax
      if (Cursor_qbe_uic_minmax!=null)
        Cursor_qbe_uic_minmax.Close();
      Cursor_qbe_uic_minmax = new VQRHolder("qbe_uic_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_uic_minmax.Eof())) {
        /* _max := qbe_uic_minmax->MASSIMO */
        _max = CPLib.Round(Cursor_qbe_uic_minmax.GetDouble("MASSIMO"),0);
        /* _min := qbe_uic_minmax->MINIMO */
        _min = CPLib.Round(Cursor_qbe_uic_minmax.GetDouble("MINIMO"),0);
        Cursor_qbe_uic_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_uic_minmax.ErrorMessage();
      Cursor_qbe_uic_minmax.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura rapporti in corso ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _bottom := ((_contacilci -1 ) * 15000) + 1 */
        _bottom = CPLib.Round(((_contacilci-1)*15000)+1,0);
        /* _top := _contacilci * 15000 */
        _top = CPLib.Round(_contacilci*15000,0);
        /* gMsgImp := 'Lettura rapporti in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura rapporti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _nomefile := 'campione.txt.'+Right('0000'+LRTrim(Str(_conta,4,0)),4) */
        _nomefile = "campione.txt."+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(_conta,4,0)),4);
        /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
        fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
        // * --- Select from qbe_rapopebo_uic
        if (Cursor_qbe_rapopebo_uic!=null)
          Cursor_qbe_rapopebo_uic.Close();
        Cursor_qbe_rapopebo_uic = new VQRHolder("qbe_rapopebo_uic",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapopebo_uic.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _note := w_tipinter + w_codinter + '1' */
          _note = w_tipinter+w_codinter+"1";
          /* _note := _note + DateToChar(qbe_rapopebo_uic->DATAOPE) + qbe_rapopebo_uic->NUMPROG + LibreriaMit.StatoReg('qbe_rapopebo_uic',qbe_rapopebo_uic->STATOREG) */
          _note = _note+CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAOPE"))+Cursor_qbe_rapopebo_uic.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapopebo_uic",Cursor_qbe_rapopebo_uic.GetString("STATOREG"));
          /* If Empty(qbe_rapopebo_uic->CODDIPE) or Empty(qbe_rapopebo_uic->CODCAB) */
          if (CPLib.Empty(Cursor_qbe_rapopebo_uic.GetString("CODDIPE")) || CPLib.Empty(Cursor_qbe_rapopebo_uic.GetString("CODCAB"))) {
            // * --- Read from intermbo
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codinter,"C",11,0,m_cServer),m_cServer,w_codinter);
            if (m_Ctx.IsSharedTemp("intermbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_codcab = Read_Cursor.GetString("CODCAB");
              w_desccit = Read_Cursor.GetString("DESCCIT");
              w_provin = Read_Cursor.GetString("PROVINCIA");
              w_coddipe = Read_Cursor.GetString("CODDIPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on intermbo into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_codcab = "";
              w_desccit = "";
              w_provin = "";
              w_coddipe = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(w_coddipe) */
            if (CPLib.Empty(w_coddipe)) {
              /* _note := _note + "000000" + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
              _note = _note+"000000"+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
            } else { // Else
              /* _note := _note + Left(LRTrim(w_coddipe)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_coddipe)+CPLib.Space(6),6);
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_coddipe,"C",6,0,m_cServer),m_cServer,w_coddipe);
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                w_cabcod = Read_Cursor.GetString("CAB");
                w_citdesc = Read_Cursor.GetString("DESCCIT");
                w_provind = Read_Cursor.GetString("PROVINCIA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                w_cabcod = "";
                w_citdesc = "";
                w_provind = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(w_cabcod) */
              if (CPLib.Empty(w_cabcod)) {
                /* _note := _note + Left(LRTrim(w_codcab)+Space(6),6) + Left(LRTrim(w_desccit)+Space(30),30) + Left(LRTrim(w_provin)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provin)+CPLib.Space(2),2);
              } else { // Else
                /* _note := _note + Left(LRTrim(w_cabcod)+Space(6),6) + Left(LRTrim(w_citdesc)+Space(30),30) + Left(LRTrim(w_provind)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(w_cabcod)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(w_citdesc)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(w_provind)+CPLib.Space(2),2);
              } // End If
            } // End If
          } else { // Else
            /* _note := _note + qbe_rapopebo_uic->CODDIPE + qbe_rapopebo_uic->CODCAB + qbe_rapopebo_uic->DESCCIT + qbe_rapopebo_uic->PROVINCIA */
            _note = _note+Cursor_qbe_rapopebo_uic.GetString("CODDIPE")+Cursor_qbe_rapopebo_uic.GetString("CODCAB")+Cursor_qbe_rapopebo_uic.GetString("DESCCIT")+Cursor_qbe_rapopebo_uic.GetString("PROVINCIA");
          } // End If
          /* _note := _note + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapopebo_uic->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_rapopebo_uic->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->CODANA)+Space(4),4) + Left(LRTrim(qbe_rapopebo_uic->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_rapopebo_uic->CODINT2)+Space(11),11) + Left(LRTrim(qbe_rapopebo_uic->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_rapopebo_uic->DESC2)+Space(30),30) + Left(LRTrim(qbe_rapopebo_uic->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Space(50) + Left(LRTrim(qbe_rapopebo_uic->RAPPORTO)+Space(25),25) + Left(LRTrim(qbe_rapopebo_uic->FLAGRAP)+" ",1) */
          _note = _note+CPLib.Space(50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("FLAGRAP"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_rapopebo_uic->COLLEG)+Space(12),12) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("COLLEG"))+CPLib.Space(12),12);
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->STATOREG)+" ",1)  */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_rapopebo_uic->DATARETT) or DateToChar(qbe_rapopebo_uic->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_rapopebo_uic.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->OPERAZMOD)+Space(20),20) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("OPERAZMOD"))+CPLib.Space(20),20);
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* Case anarapbo->FLAGLIRE='1' or anarapbo->FLAGLIRE='L' */
            if (CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"L")) {
              /* _note := _note + '1' + '018' */
              _note = _note+"1"+"018";
              /* Case anarapbo->FLAGLIRE='2' or anarapbo->FLAGLIRE='V' */
            } else if (CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"2") || CPLib.eqr(Cursor_anarapbo.GetString("FLAGLIRE"),"V")) {
              /* _note := _note + '2' + Left(LRTrim(anarapbo->VALUTA)+Space(3),3) */
              _note = _note+"2"+CPLib.Left(CPLib.LRTrim(Cursor_anarapbo.GetString("VALUTA"))+CPLib.Space(3),3);
            } else { // Otherwise
              /* _note := _note + '3' + '242' */
              _note = _note+"3"+"242";
            } // End Case
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->SEGNO)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_rapopebo_uic->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_rapopebo_uic->TOTCONT,15,0)),15) + Space(69) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapopebo_uic.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapopebo_uic.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(69);
          /* FileLibMit.WriteLine(fhand,_note) */
          FileLibMit.WriteLine(fhand,_note);
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* Case qbe_rapopebo_uic->TIPOOPRAP='25' or qbe_rapopebo_uic->TIPOOPRAP='28' */
          if (CPLib.eqr(Cursor_qbe_rapopebo_uic.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapopebo_uic.GetString("TIPOOPRAP"),"28")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* w_cabper := '' */
                  w_cabper = "";
                  /* If Empty(LRTrim(personbo->CODCAB)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      w_cabper = Read_Cursor.GetString("CAB");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      w_cabper = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    /* w_cabper := personbo->CODCAB */
                    w_cabper = Cursor_personbo.GetString("CODCAB");
                  } // End If
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATAOPE))+Space(8),8) + qbe_rapopebo_uic->NUMPROG + LibreriaMit.StatoReg('qbe_rapopebo_uic',qbe_rapopebo_uic->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapopebo_uic.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapopebo_uic",Cursor_qbe_rapopebo_uic.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(w_cabper)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapopebo_uic->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* Case Right(qbe_rapopebo_uic->TIPOOPRAP,1)='6' */
          } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapopebo_uic.GetString("TIPOOPRAP"),1),"6")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* w_cabper := '' */
                  w_cabper = "";
                  /* If Empty(LRTrim(personbo->CODCAB)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      w_cabper = Read_Cursor.GetString("CAB");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      w_cabper = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    /* w_cabper := personbo->CODCAB */
                    w_cabper = Cursor_personbo.GetString("CODCAB");
                  } // End If
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATAOPE))+Space(8),8) + qbe_rapopebo_uic->NUMPROG + LibreriaMit.StatoReg('qbe_rapopebo_uic',qbe_rapopebo_uic->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapopebo_uic.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapopebo_uic",Cursor_qbe_rapopebo_uic.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(w_cabper)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapopebo_uic->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Otherwise
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If intestbo->TIPOPERS='D' */
              if (CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"D")) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If Empty(intestbo->CODINTER) */
              if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* w_cabper := '' */
                  w_cabper = "";
                  /* If Empty(LRTrim(personbo->CODCAB)) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      w_cabper = Read_Cursor.GetString("CAB");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      w_cabper = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    /* w_cabper := personbo->CODCAB */
                    w_cabper = Cursor_personbo.GetString("CODCAB");
                  } // End If
                  /* _note := w_tipinter + w_codinter+'2' */
                  _note = w_tipinter+w_codinter+"2";
                  /* _note := _note + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATAOPE))+Space(8),8) + qbe_rapopebo_uic->NUMPROG + LibreriaMit.StatoReg('qbe_rapopebo_uic',qbe_rapopebo_uic->STATOREG) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAOPE")))+CPLib.Space(8),8)+Cursor_qbe_rapopebo_uic.GetString("NUMPROG")+LibreriaMit.StatoReg("qbe_rapopebo_uic",Cursor_qbe_rapopebo_uic.GetString("STATOREG"));
                  /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
                  /* _note := _note + Left(LRTrim(w_cabper)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                  /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
                  /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
                  /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                  } // End If
                  /* If not(Empty(personbo->NASSTATO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                    /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Left(LRTrim(personbo->SOTGRUP)+Space(3),3) + Left(LRTrim(personbo->RAMOGRUP)+Space(3),3) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAMOGRUP"))+CPLib.Space(3),3);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->SETTSINT)+Space(3),3) + Left(LRTrim(qbe_rapopebo_uic->RAPPORTO)+Space(25),25) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("RAPPORTO"))+CPLib.Space(25),25);
                  /* _note := _note + Left(LRTrim(qbe_rapopebo_uic->FLAGRAP)+" ",1) + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                  /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
                  if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                    /* _note := _note + Space(8) */
                    _note = _note+CPLib.Space(8);
                  } else { // Else
                    /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                    _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                  } // End If
                  /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                  /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                  /* FileLibMit.WriteLine(fhand,_note) */
                  FileLibMit.WriteLine(fhand,_note);
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End Case
          /* If not(Empty(qbe_rapopebo_uic->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapopebo_uic.GetString("CONNESOPER")))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_rapopebo_uic.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* w_cabper := '' */
              w_cabper = "";
              /* If Empty(LRTrim(personbo->CODCAB)) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")))) {
                // * --- Read from tbcitta
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_cSql = "";
                m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",60,0,m_cServer),m_cServer,Cursor_personbo.GetString("DESCCIT"));
                if (m_Ctx.IsSharedTemp("tbcitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  w_cabper = Read_Cursor.GetString("CAB");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_dlgspecifici_telepass returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  w_cabper = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                /* w_cabper := personbo->CODCAB */
                w_cabper = Cursor_personbo.GetString("CODCAB");
              } // End If
              /* _note := w_tipinter + w_codinter+'4' */
              _note = w_tipinter+w_codinter+"4";
              /* _note := _note + Left(LRTrim(DateToChar(qbe_rapopebo_uic->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapopebo_uic->NUMPROG)+Space(11),11) + LibreriaMit.StatoReg('qbe_rapopebo_uic',qbe_rapopebo_uic->STATOREG) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapopebo_uic.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapopebo_uic.GetString("NUMPROG"))+CPLib.Space(11),11)+LibreriaMit.StatoReg("qbe_rapopebo_uic",Cursor_qbe_rapopebo_uic.GetString("STATOREG"));
              /* _note := _note + Left(LRTrim(personbo->CONNES)+Space(16),16) + Left(LRTrim(personbo->RAGSOC)+Space(70),70) + Left(LRTrim(personbo->PAESE)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3);
              /* _note := _note + Left(LRTrim(w_cabper)+Space(6),6) + Left(LRTrim(personbo->DESCCIT)+Space(30),30) + Left(LRTrim(personbo->PROVINCIA)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(w_cabper)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(personbo->DOMICILIO)+Space(35),35) + Left(LRTrim(personbo->CAP)+ Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5);
              /* _note := _note + Left(LRTrim(personbo->CODFISC)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))+CPLib.Space(16),16);
              /* If Empty(personbo->DATANASC) or DateToChar(personbo->DATANASC)='01000101' */
              if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(personbo->DATANASC))+Space(8),8) */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")))+CPLib.Space(8),8);
              } // End If
              /* If not(Empty(personbo->NASSTATO)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) {
                /* _note := _note + Left(LRTrim(personbo->NASSTATO)+Space(30),30) + Space(35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Space(35);
              } else { // Else
                /* _note := _note + Left(LRTrim(personbo->NASCOMUN)+Space(30),30) + Space(35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Space(35);
              } // End If
              /* _note := _note + Left(LRTrim(personbo->TIPODOC)+Space(2),2) + Left(LRTrim(personbo->NUMDOCUM)+Space(15),15) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
              /* If Empty(personbo->DATARILASC) or DateToChar(personbo->DATARILASC)='01000101' */
              if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")) {
                /* _note := _note + Space(8) */
                _note = _note+CPLib.Space(8);
              } else { // Else
                /* _note := _note + Left(LRTrim(DateToChar(personbo->DATARILASC))+Space(8),8)  */
                _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
              } // End If
              /* _note := _note + Left(LRTrim(personbo->AUTRILASC)+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(personbo->SESSO)+" ",1) + Space(34) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
              /* FileLibMit.WriteLine(fhand,_note) */
              FileLibMit.WriteLine(fhand,_note);
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } // End If
          Cursor_qbe_rapopebo_uic.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapopebo_uic.ErrorMessage();
        Cursor_qbe_rapopebo_uic.Close();
        // * --- End Select
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_uic_minmax!=null)
          Cursor_qbe_uic_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapopebo_uic!=null)
          Cursor_qbe_rapopebo_uic.Close();
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
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
      m_Caller.SetString("codinter","C",11,0,w_codinter);
      m_Caller.SetString("tipinter","C",2,0,w_tipinter);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_dlgspecifici_telepassR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_dlgspecifici_telepassR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_codinter = m_Caller.GetString("codinter","C",11,0);
    w_tipinter = m_Caller.GetString("tipinter","C",2,0);
    w_codcab = CPLib.Space(6);
    w_cabcod = CPLib.Space(6);
    w_cabper = CPLib.Space(6);
    w_desccit = CPLib.Space(30);
    w_citdesc = CPLib.Space(30);
    w_provin = CPLib.Space(2);
    w_provind = CPLib.Space(2);
    w_coddipe = CPLib.Space(6);
    _note = "";
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(15);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    nTotRec = 0;
    nTotReg = 0;
    nNumRec = 0;
    _avanza = 0;
    _codrif = CPLib.Space(16);
    _conta = 0;
    _max = 0;
    _min = 0;
    _top = 0;
    _bottom = 0;
    _cicli = 0;
    _contacilci = 0;
    _ctotale = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_uic_minmax,qbe_rapopebo_uic,
  public static final String m_cVQRList = ",qbe_uic_minmax,qbe_rapopebo_uic,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
