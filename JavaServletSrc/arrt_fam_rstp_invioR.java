// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fam_rstp_invioR implements CallerWithObjs {
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
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio2;
  public String m_cServer_sid_invio2;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_tmp_sid_invio1;
  public String m_cServer_tmp_sid_invio1;
  public String m_cPhName_tmp_sid_invio2;
  public String m_cServer_tmp_sid_invio2;
  public String m_cPhName_tmp_sid_invio3;
  public String m_cServer_tmp_sid_invio3;
  public String m_cPhName_tmp_sid_invio4;
  public String m_cServer_tmp_sid_invio4;
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
  public String w_stpinvio;
  public java.sql.Date w_xdatinvio;
  public String w_xtipinvio;
  public String w_xtpcinvio;
  public String w_flgdett;
  public double _conta;
  public String _errore;
  public MemoryCursor_tmp_stpperiodo mcTemp;
  public MemoryCursorRow_tmp_stpperiodo rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio2 mcSID2;
  public MemoryCursorRow_sid_invio2 rowSID2;
  public MemoryCursor_sid_invio2 mcSID2r;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public MemoryCursor_sid_invio4 mcSID4;
  public MemoryCursor_sid_invio4 mcSID4r;
  public double _crea;
  public double _stampa;
  public double _okrep;
  public double _asaldi;
  public String w_anno;
  public String w_mese;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public java.sql.Date gScadSaldi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fam_rstp_invioR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_rstp_invio",m_Caller);
    m_cPhName_sid_invio = p_ContextObject.GetPhName("sid_invio");
    if (m_cPhName_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio = m_cPhName_sid_invio+" "+m_Ctx.GetWritePhName("sid_invio");
    }
    m_cServer_sid_invio = p_ContextObject.GetServer("sid_invio");
    m_cPhName_sid_invio1 = p_ContextObject.GetPhName("sid_invio1");
    if (m_cPhName_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio1 = m_cPhName_sid_invio1+" "+m_Ctx.GetWritePhName("sid_invio1");
    }
    m_cServer_sid_invio1 = p_ContextObject.GetServer("sid_invio1");
    m_cPhName_sid_invio2 = p_ContextObject.GetPhName("sid_invio2");
    if (m_cPhName_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio2 = m_cPhName_sid_invio2+" "+m_Ctx.GetWritePhName("sid_invio2");
    }
    m_cServer_sid_invio2 = p_ContextObject.GetServer("sid_invio2");
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
      m_cPhName_tmp_sid_invio1 = p_ContextObject.GetPhName("tmp_sid_invio1");
      if (m_cPhName_tmp_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio1 = m_cPhName_tmp_sid_invio1+" "+m_Ctx.GetWritePhName("tmp_sid_invio1");
      }
      m_cServer_tmp_sid_invio1 = p_ContextObject.GetServer("tmp_sid_invio1");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio2")) {
      m_cPhName_tmp_sid_invio2 = p_ContextObject.GetPhName("tmp_sid_invio2");
      if (m_cPhName_tmp_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio2 = m_cPhName_tmp_sid_invio2+" "+m_Ctx.GetWritePhName("tmp_sid_invio2");
      }
      m_cServer_tmp_sid_invio2 = p_ContextObject.GetServer("tmp_sid_invio2");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
      m_cPhName_tmp_sid_invio3 = p_ContextObject.GetPhName("tmp_sid_invio3");
      if (m_cPhName_tmp_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio3 = m_cPhName_tmp_sid_invio3+" "+m_Ctx.GetWritePhName("tmp_sid_invio3");
      }
      m_cServer_tmp_sid_invio3 = p_ContextObject.GetServer("tmp_sid_invio3");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio4")) {
      m_cPhName_tmp_sid_invio4 = p_ContextObject.GetPhName("tmp_sid_invio4");
      if (m_cPhName_tmp_sid_invio4.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio4 = m_cPhName_tmp_sid_invio4+" "+m_Ctx.GetWritePhName("tmp_sid_invio4");
      }
      m_cServer_tmp_sid_invio4 = p_ContextObject.GetServer("tmp_sid_invio4");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      return _crea;
    }
    if (CPLib.eqr("_stampa",p_cVarName)) {
      return _stampa;
    }
    if (CPLib.eqr("_okrep",p_cVarName)) {
      return _okrep;
    }
    if (CPLib.eqr("_asaldi",p_cVarName)) {
      return _asaldi;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fam_rstp_invio";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("stpinvio",p_cVarName)) {
      return w_stpinvio;
    }
    if (CPLib.eqr("xtipinvio",p_cVarName)) {
      return w_xtipinvio;
    }
    if (CPLib.eqr("xtpcinvio",p_cVarName)) {
      return w_xtpcinvio;
    }
    if (CPLib.eqr("flgdett",p_cVarName)) {
      return w_flgdett;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("xdatinvio",p_cVarName)) {
      return w_xdatinvio;
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
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      return mcTemp;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      return mcSID0;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      return mcSID1;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      return mcSID2;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      return mcSID2r;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      return mcSID3;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      return mcSID3r;
    }
    if (CPLib.eqr("mcSID4",p_cVarName)) {
      return mcSID4;
    }
    if (CPLib.eqr("mcSID4r",p_cVarName)) {
      return mcSID4r;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      return rowSID0;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      return rowSID1;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      return rowSID2;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      return rowSID3;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      _crea = value;
      return;
    }
    if (CPLib.eqr("_stampa",p_cVarName)) {
      _stampa = value;
      return;
    }
    if (CPLib.eqr("_okrep",p_cVarName)) {
      _okrep = value;
      return;
    }
    if (CPLib.eqr("_asaldi",p_cVarName)) {
      _asaldi = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("stpinvio",p_cVarName)) {
      w_stpinvio = value;
      return;
    }
    if (CPLib.eqr("xtipinvio",p_cVarName)) {
      w_xtipinvio = value;
      return;
    }
    if (CPLib.eqr("xtpcinvio",p_cVarName)) {
      w_xtpcinvio = value;
      return;
    }
    if (CPLib.eqr("flgdett",p_cVarName)) {
      w_flgdett = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("xdatinvio",p_cVarName)) {
      w_xdatinvio = value;
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
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      rowSID0 = (MemoryCursorRow_sid_invio)value;
      return;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      rowSID1 = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      rowSID2 = (MemoryCursorRow_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      mcSID0 = (MemoryCursor_sid_invio)value;
      return;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      mcSID1 = (MemoryCursor_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      mcSID2 = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      mcSID2r = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      mcSID3 = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      mcSID3r = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID4",p_cVarName)) {
      mcSID4 = (MemoryCursor_sid_invio4)value;
      return;
    }
    if (CPLib.eqr("mcSID4r",p_cVarName)) {
      mcSID4r = (MemoryCursor_sid_invio4)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_sid_invio=null;
    CPResultSet Cursor_sid_invio1=null;
    CPResultSet Cursor_sid_invio2=null;
    CPResultSet Cursor_sid_invio3=null;
    try {
      /* w_stpinvio Char(10) // Identificativo Invio */
      /* w_xdatinvio Date // Data Creazione */
      /* w_xtipinvio Char(1) // Tipo Invio */
      /* w_xtpcinvio Char(1) // Tipo Comunicazione */
      /* w_flgdett Char(2) */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* mcTemp MemoryCursor(tmp_stpperiodo) */
      /* rowTemp Row(tmp_stpperiodo) */
      /* mcSID0 MemoryCursor(sid_invio) */
      /* rowSID0 Row(sid_invio) */
      /* mcSID1 MemoryCursor(sid_invio1) */
      /* rowSID1 Row(sid_invio1) */
      /* mcSID2 MemoryCursor(sid_invio2) */
      /* rowSID2 Row(sid_invio2) */
      /* mcSID2r MemoryCursor(sid_invio2) */
      /* mcSID3 MemoryCursor(sid_invio3) */
      /* rowSID3 Row(sid_invio3) */
      /* mcSID3r MemoryCursor(sid_invio3) */
      /* mcSID4 MemoryCursor(sid_invio4) */
      /* mcSID4r MemoryCursor(sid_invio4) */
      /* _crea Numeric(1, 0) */
      /* _stampa Numeric(1, 0) */
      /* _okrep Numeric(1, 0) */
      /* _asaldi Numeric(4, 0) */
      /* w_anno Char(4) */
      /* w_mese Char(2) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gScadSaldi Date // Scadenza Invio Saldi */
      /* _okrep := 0 */
      _okrep = CPLib.Round(0,0);
      /* _stampa := 0 */
      _stampa = CPLib.Round(0,0);
      // * --- Create temporary table tmp_sid_invio1
      if (m_Ctx.IsSharedTemp("tmp_sid_invio1")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio1");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio1");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio1"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio1",m_cServer,"proto")),m_cPhName,"tmp_sid_invio1",m_Ctx);
      }
      m_cPhName_tmp_sid_invio1 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio2
      if (m_Ctx.IsSharedTemp("tmp_sid_invio2")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio2")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio2");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio2");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio2");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio2"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio2",m_cServer,"proto")),m_cPhName,"tmp_sid_invio2",m_Ctx);
      }
      m_cPhName_tmp_sid_invio2 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio3
      if (m_Ctx.IsSharedTemp("tmp_sid_invio3")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio3");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio3");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio3");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio3"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio3",m_cServer,"proto")),m_cPhName,"tmp_sid_invio3",m_Ctx);
      }
      m_cPhName_tmp_sid_invio3 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio4
      if (m_Ctx.IsSharedTemp("tmp_sid_invio4")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio4")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio4");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio4");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio4");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio4");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio4"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio4");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio4",m_cServer,"proto")),m_cPhName,"tmp_sid_invio4",m_Ctx);
      }
      m_cPhName_tmp_sid_invio4 = m_cPhName;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000002Bstatus;
      nTry0000002Bstatus = m_Sql.GetTransactionStatus();
      String cTry0000002Bmsg;
      cTry0000002Bmsg = m_Sql.TransactionErrorMessage();
      try {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgProc := 'Ora Inizio Elaborazione Invio: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = "Ora Inizio Elaborazione Invio: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Estrazione dati per l'invio" + w_stpinvio+ NL // Messaggio */
        gMsgProc = gMsgProc+"Estrazione dati per l'invio"+w_stpinvio+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Attendere. Estrazione dati ..." // Messaggio Import */
        gMsgImp = "Attendere. Estrazione dati ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If (w_xtipinvio='1' or w_xtipinvio='2') and w_xtpcinvio='1' */
        if ((CPLib.eqr(w_xtipinvio,"1") || CPLib.eqr(w_xtipinvio,"2")) && CPLib.eqr(w_xtpcinvio,"1")) {
          /* w_anno := Left(w_stpinvio,4) */
          w_anno = CPLib.Left(w_stpinvio,4);
          /* w_mese := Substr(w_stpinvio,5,2) */
          w_mese = CPLib.Substr(w_stpinvio,5,2);
          // * --- Fill memory cursor mcSID0 on sid_invio
          mcSID0.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          if (Cursor_sid_invio!=null)
            Cursor_sid_invio.Close();
          Cursor_sid_invio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio;
            Cursor_sid_invio.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio.Eof())) {
            mcSID0.AppendBlank();
            mcSID0.row.CODINVIO = Cursor_sid_invio.GetString("CODINVIO");
            mcSID0.row.TIPINVIO = Cursor_sid_invio.GetString("TIPINVIO");
            mcSID0.row.TPCINVIO = Cursor_sid_invio.GetString("TPCINVIO");
            mcSID0.row.DATINVIO = Cursor_sid_invio.GetDate("DATINVIO");
            mcSID0.row.ANNINVIO = Cursor_sid_invio.GetString("ANNINVIO");
            mcSID0.row.MESINVIO = Cursor_sid_invio.GetString("MESINVIO");
            mcSID0.row.PRTINVIO = Cursor_sid_invio.GetString("PRTINVIO");
            mcSID0.row.FLEINVIO = Cursor_sid_invio.GetString("FLEINVIO");
            mcSID0.row.FL1INVIO = Cursor_sid_invio.GetString("FL1INVIO");
            mcSID0.row.FL2INVIO = Cursor_sid_invio.GetString("FL2INVIO");
            mcSID0.row.FLGINVIO = Cursor_sid_invio.GetString("FLGINVIO");
            Cursor_sid_invio.Next();
          }
          m_cConnectivityError = Cursor_sid_invio.ErrorMessage();
          Cursor_sid_invio.Close();
          mcSID0.GoTop();
          // * --- Fill memory cursor mcSID1 on sid_invio1
          mcSID1.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          if (Cursor_sid_invio1!=null)
            Cursor_sid_invio1.Close();
          Cursor_sid_invio1 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO1="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio1")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio1;
            Cursor_sid_invio1.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio1.Eof())) {
            mcSID1.AppendBlank();
            mcSID1.row.CODINVIO1 = Cursor_sid_invio1.GetString("CODINVIO1");
            mcSID1.row.RAPINVIO1 = Cursor_sid_invio1.GetString("RAPINVIO1");
            mcSID1.row.TPRINVIO1 = Cursor_sid_invio1.GetString("TPRINVIO1");
            mcSID1.row.INIINVIO1 = Cursor_sid_invio1.GetDate("INIINVIO1");
            mcSID1.row.FININVIO1 = Cursor_sid_invio1.GetDate("FININVIO1");
            mcSID1.row.CABINVIO1 = Cursor_sid_invio1.GetString("CABINVIO1");
            mcSID1.row.ESIINVIO1 = Cursor_sid_invio1.GetString("ESIINVIO1");
            mcSID1.row.TIPINVIO1 = Cursor_sid_invio1.GetString("TIPINVIO1");
            mcSID1.row.TPCINVIO1 = Cursor_sid_invio1.GetString("TPCINVIO1");
            mcSID1.row.UNIQUE1 = Cursor_sid_invio1.GetString("UNIQUE1");
            mcSID1.row.FLGUNQ1 = Cursor_sid_invio1.GetString("FLGUNQ1");
            mcSID1.row.MODINVIO1 = Cursor_sid_invio1.GetDate("MODINVIO1");
            Cursor_sid_invio1.Next();
          }
          m_cConnectivityError = Cursor_sid_invio1.ErrorMessage();
          Cursor_sid_invio1.Close();
          mcSID1.GoTop();
          // * --- Fill memory cursor mcSID2 on sid_invio2
          mcSID2.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio2");
          m_cPhName = m_Ctx.GetPhName("sid_invio2");
          if (Cursor_sid_invio2!=null)
            Cursor_sid_invio2.Close();
          Cursor_sid_invio2 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO2="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio2")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio2;
            Cursor_sid_invio2.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio2 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio2.Eof())) {
            mcSID2.AppendBlank();
            mcSID2.row.CODINVIO2 = Cursor_sid_invio2.GetString("CODINVIO2");
            mcSID2.row.RAPINVIO2 = Cursor_sid_invio2.GetString("RAPINVIO2");
            mcSID2.row.APRINVIO2 = Cursor_sid_invio2.GetDouble("APRINVIO2");
            mcSID2.row.INIINVIO2 = Cursor_sid_invio2.GetDate("INIINVIO2");
            mcSID2.row.FININVIO2 = Cursor_sid_invio2.GetDate("FININVIO2");
            mcSID2.row.FCFINVIO2 = Cursor_sid_invio2.GetDouble("FCFINVIO2");
            mcSID2.row.CFSINVIO2 = Cursor_sid_invio2.GetString("CFSINVIO2");
            mcSID2.row.RUOINVIO2 = Cursor_sid_invio2.GetString("RUOINVIO2");
            mcSID2.row.COGINVIO2 = Cursor_sid_invio2.GetString("COGINVIO2");
            mcSID2.row.NOMINVIO2 = Cursor_sid_invio2.GetString("NOMINVIO2");
            mcSID2.row.SEXINVIO2 = Cursor_sid_invio2.GetString("SEXINVIO2");
            mcSID2.row.DNSINVIO2 = Cursor_sid_invio2.GetDate("DNSINVIO2");
            mcSID2.row.CNSINVIO2 = Cursor_sid_invio2.GetString("CNSINVIO2");
            mcSID2.row.PNSINVIO2 = Cursor_sid_invio2.GetString("PNSINVIO2");
            mcSID2.row.RGSINVIO2 = Cursor_sid_invio2.GetString("RGSINVIO2");
            mcSID2.row.CSLINVIO2 = Cursor_sid_invio2.GetString("CSLINVIO2");
            mcSID2.row.PLSINVIO2 = Cursor_sid_invio2.GetString("PLSINVIO2");
            Cursor_sid_invio2.Next();
          }
          m_cConnectivityError = Cursor_sid_invio2.ErrorMessage();
          Cursor_sid_invio2.Close();
          mcSID2.GoTop();
          // * --- Fill memory cursor mcSID3 on sid_invio3
          mcSID3.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio3");
          m_cPhName = m_Ctx.GetPhName("sid_invio3");
          if (Cursor_sid_invio3!=null)
            Cursor_sid_invio3.Close();
          Cursor_sid_invio3 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO3="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio3")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio3;
            Cursor_sid_invio3.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio3 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio3.Eof())) {
            mcSID3.AppendBlank();
            mcSID3.row.CODINVIO3 = Cursor_sid_invio3.GetString("CODINVIO3");
            mcSID3.row.RAPINVIO3 = Cursor_sid_invio3.GetString("RAPINVIO3");
            mcSID3.row.TPRINVIO3 = Cursor_sid_invio3.GetString("TPRINVIO3");
            mcSID3.row.ANNINVIO3 = Cursor_sid_invio3.GetDouble("ANNINVIO3");
            mcSID3.row.VALINVIO3 = Cursor_sid_invio3.GetString("VALINVIO3");
            mcSID3.row.NATINVIO3 = Cursor_sid_invio3.GetString("NATINVIO3");
            mcSID3.row.IM1INVIO3 = Cursor_sid_invio3.GetDouble("IM1INVIO3");
            mcSID3.row.FI1INVIO3 = Cursor_sid_invio3.GetDouble("FI1INVIO3");
            mcSID3.row.IM2INVIO3 = Cursor_sid_invio3.GetDouble("IM2INVIO3");
            mcSID3.row.FI2INVIO3 = Cursor_sid_invio3.GetDouble("FI2INVIO3");
            mcSID3.row.IM3INVIO3 = Cursor_sid_invio3.GetDouble("IM3INVIO3");
            mcSID3.row.FI3INVIO3 = Cursor_sid_invio3.GetDouble("FI3INVIO3");
            mcSID3.row.IM4INVIO3 = Cursor_sid_invio3.GetDouble("IM4INVIO3");
            mcSID3.row.FI4INVIO3 = Cursor_sid_invio3.GetDouble("FI4INVIO3");
            mcSID3.row.IM5INVIO3 = Cursor_sid_invio3.GetDouble("IM5INVIO3");
            mcSID3.row.FI5INVIO3 = Cursor_sid_invio3.GetDouble("FI5INVIO3");
            mcSID3.row.IM6INVIO3 = Cursor_sid_invio3.GetDouble("IM6INVIO3");
            mcSID3.row.FI6INVIO3 = Cursor_sid_invio3.GetDouble("FI6INVIO3");
            mcSID3.row.UNIQUE3 = Cursor_sid_invio3.GetString("UNIQUE3");
            mcSID3.row.FLGUNQ3 = Cursor_sid_invio3.GetString("FLGUNQ3");
            Cursor_sid_invio3.Next();
          }
          m_cConnectivityError = Cursor_sid_invio3.ErrorMessage();
          Cursor_sid_invio3.Close();
          mcSID3.GoTop();
        } // End If
        /* If w_xtipinvio='1' and w_xtpcinvio='5' */
        if (CPLib.eqr(w_xtipinvio,"1") && CPLib.eqr(w_xtpcinvio,"5")) {
          /* w_anno := Left(w_stpinvio,4) */
          w_anno = CPLib.Left(w_stpinvio,4);
          /* w_mese := Substr(w_stpinvio,5,2) */
          w_mese = CPLib.Substr(w_stpinvio,5,2);
          // * --- Fill memory cursor mcSID0 on sid_invio
          mcSID0.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          if (Cursor_sid_invio!=null)
            Cursor_sid_invio.Close();
          Cursor_sid_invio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio;
            Cursor_sid_invio.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio.Eof())) {
            mcSID0.AppendBlank();
            mcSID0.row.CODINVIO = Cursor_sid_invio.GetString("CODINVIO");
            mcSID0.row.TIPINVIO = Cursor_sid_invio.GetString("TIPINVIO");
            mcSID0.row.TPCINVIO = Cursor_sid_invio.GetString("TPCINVIO");
            mcSID0.row.DATINVIO = Cursor_sid_invio.GetDate("DATINVIO");
            mcSID0.row.ANNINVIO = Cursor_sid_invio.GetString("ANNINVIO");
            mcSID0.row.MESINVIO = Cursor_sid_invio.GetString("MESINVIO");
            mcSID0.row.PRTINVIO = Cursor_sid_invio.GetString("PRTINVIO");
            mcSID0.row.FLEINVIO = Cursor_sid_invio.GetString("FLEINVIO");
            mcSID0.row.FL1INVIO = Cursor_sid_invio.GetString("FL1INVIO");
            mcSID0.row.FL2INVIO = Cursor_sid_invio.GetString("FL2INVIO");
            mcSID0.row.FLGINVIO = Cursor_sid_invio.GetString("FLGINVIO");
            Cursor_sid_invio.Next();
          }
          m_cConnectivityError = Cursor_sid_invio.ErrorMessage();
          Cursor_sid_invio.Close();
          mcSID0.GoTop();
          // * --- Fill memory cursor mcSID1 on sid_invio1
          mcSID1.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          if (Cursor_sid_invio1!=null)
            Cursor_sid_invio1.Close();
          Cursor_sid_invio1 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO1="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio1")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio1;
            Cursor_sid_invio1.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio1.Eof())) {
            mcSID1.AppendBlank();
            mcSID1.row.CODINVIO1 = Cursor_sid_invio1.GetString("CODINVIO1");
            mcSID1.row.RAPINVIO1 = Cursor_sid_invio1.GetString("RAPINVIO1");
            mcSID1.row.TPRINVIO1 = Cursor_sid_invio1.GetString("TPRINVIO1");
            mcSID1.row.INIINVIO1 = Cursor_sid_invio1.GetDate("INIINVIO1");
            mcSID1.row.FININVIO1 = Cursor_sid_invio1.GetDate("FININVIO1");
            mcSID1.row.CABINVIO1 = Cursor_sid_invio1.GetString("CABINVIO1");
            mcSID1.row.ESIINVIO1 = Cursor_sid_invio1.GetString("ESIINVIO1");
            mcSID1.row.TIPINVIO1 = Cursor_sid_invio1.GetString("TIPINVIO1");
            mcSID1.row.TPCINVIO1 = Cursor_sid_invio1.GetString("TPCINVIO1");
            mcSID1.row.UNIQUE1 = Cursor_sid_invio1.GetString("UNIQUE1");
            mcSID1.row.FLGUNQ1 = Cursor_sid_invio1.GetString("FLGUNQ1");
            mcSID1.row.MODINVIO1 = Cursor_sid_invio1.GetDate("MODINVIO1");
            Cursor_sid_invio1.Next();
          }
          m_cConnectivityError = Cursor_sid_invio1.ErrorMessage();
          Cursor_sid_invio1.Close();
          mcSID1.GoTop();
          /* If w_flgdett='S' */
          if (CPLib.eqr(w_flgdett,"S")) {
            // * --- Fill memory cursor mcSID2 on sid_invio2
            mcSID2.Zap();
            m_cServer = m_Ctx.GetServer("sid_invio2");
            m_cPhName = m_Ctx.GetPhName("sid_invio2");
            if (Cursor_sid_invio2!=null)
              Cursor_sid_invio2.Close();
            Cursor_sid_invio2 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO2="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio2")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_sid_invio2;
              Cursor_sid_invio2.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_fam_rstp_invio: query on sid_invio2 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_sid_invio2.Eof())) {
              mcSID2.AppendBlank();
              mcSID2.row.CODINVIO2 = Cursor_sid_invio2.GetString("CODINVIO2");
              mcSID2.row.RAPINVIO2 = Cursor_sid_invio2.GetString("RAPINVIO2");
              mcSID2.row.APRINVIO2 = Cursor_sid_invio2.GetDouble("APRINVIO2");
              mcSID2.row.INIINVIO2 = Cursor_sid_invio2.GetDate("INIINVIO2");
              mcSID2.row.FININVIO2 = Cursor_sid_invio2.GetDate("FININVIO2");
              mcSID2.row.FCFINVIO2 = Cursor_sid_invio2.GetDouble("FCFINVIO2");
              mcSID2.row.CFSINVIO2 = Cursor_sid_invio2.GetString("CFSINVIO2");
              mcSID2.row.RUOINVIO2 = Cursor_sid_invio2.GetString("RUOINVIO2");
              mcSID2.row.COGINVIO2 = Cursor_sid_invio2.GetString("COGINVIO2");
              mcSID2.row.NOMINVIO2 = Cursor_sid_invio2.GetString("NOMINVIO2");
              mcSID2.row.SEXINVIO2 = Cursor_sid_invio2.GetString("SEXINVIO2");
              mcSID2.row.DNSINVIO2 = Cursor_sid_invio2.GetDate("DNSINVIO2");
              mcSID2.row.CNSINVIO2 = Cursor_sid_invio2.GetString("CNSINVIO2");
              mcSID2.row.PNSINVIO2 = Cursor_sid_invio2.GetString("PNSINVIO2");
              mcSID2.row.RGSINVIO2 = Cursor_sid_invio2.GetString("RGSINVIO2");
              mcSID2.row.CSLINVIO2 = Cursor_sid_invio2.GetString("CSLINVIO2");
              mcSID2.row.PLSINVIO2 = Cursor_sid_invio2.GetString("PLSINVIO2");
              Cursor_sid_invio2.Next();
            }
            m_cConnectivityError = Cursor_sid_invio2.ErrorMessage();
            Cursor_sid_invio2.Close();
            mcSID2.GoTop();
          } // End If
        } // End If
        /* If w_xtipinvio='2' and w_xtpcinvio='2' */
        if (CPLib.eqr(w_xtipinvio,"2") && CPLib.eqr(w_xtpcinvio,"2")) {
          /* w_anno := Left(w_stpinvio,4) */
          w_anno = CPLib.Left(w_stpinvio,4);
          /* w_mese := Substr(w_stpinvio,5,2) */
          w_mese = CPLib.Substr(w_stpinvio,5,2);
          // * --- Fill memory cursor mcSID0 on sid_invio
          mcSID0.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          if (Cursor_sid_invio!=null)
            Cursor_sid_invio.Close();
          Cursor_sid_invio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio;
            Cursor_sid_invio.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio.Eof())) {
            mcSID0.AppendBlank();
            mcSID0.row.CODINVIO = Cursor_sid_invio.GetString("CODINVIO");
            mcSID0.row.TIPINVIO = Cursor_sid_invio.GetString("TIPINVIO");
            mcSID0.row.TPCINVIO = Cursor_sid_invio.GetString("TPCINVIO");
            mcSID0.row.DATINVIO = Cursor_sid_invio.GetDate("DATINVIO");
            mcSID0.row.ANNINVIO = Cursor_sid_invio.GetString("ANNINVIO");
            mcSID0.row.MESINVIO = Cursor_sid_invio.GetString("MESINVIO");
            mcSID0.row.PRTINVIO = Cursor_sid_invio.GetString("PRTINVIO");
            mcSID0.row.FLEINVIO = Cursor_sid_invio.GetString("FLEINVIO");
            mcSID0.row.FL1INVIO = Cursor_sid_invio.GetString("FL1INVIO");
            mcSID0.row.FL2INVIO = Cursor_sid_invio.GetString("FL2INVIO");
            mcSID0.row.FLGINVIO = Cursor_sid_invio.GetString("FLGINVIO");
            Cursor_sid_invio.Next();
          }
          m_cConnectivityError = Cursor_sid_invio.ErrorMessage();
          Cursor_sid_invio.Close();
          mcSID0.GoTop();
          // * --- Fill memory cursor mcSID1 on sid_invio1
          mcSID1.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          if (Cursor_sid_invio1!=null)
            Cursor_sid_invio1.Close();
          Cursor_sid_invio1 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO1="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio1")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio1;
            Cursor_sid_invio1.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio1.Eof())) {
            mcSID1.AppendBlank();
            mcSID1.row.CODINVIO1 = Cursor_sid_invio1.GetString("CODINVIO1");
            mcSID1.row.RAPINVIO1 = Cursor_sid_invio1.GetString("RAPINVIO1");
            mcSID1.row.TPRINVIO1 = Cursor_sid_invio1.GetString("TPRINVIO1");
            mcSID1.row.INIINVIO1 = Cursor_sid_invio1.GetDate("INIINVIO1");
            mcSID1.row.FININVIO1 = Cursor_sid_invio1.GetDate("FININVIO1");
            mcSID1.row.CABINVIO1 = Cursor_sid_invio1.GetString("CABINVIO1");
            mcSID1.row.ESIINVIO1 = Cursor_sid_invio1.GetString("ESIINVIO1");
            mcSID1.row.TIPINVIO1 = Cursor_sid_invio1.GetString("TIPINVIO1");
            mcSID1.row.TPCINVIO1 = Cursor_sid_invio1.GetString("TPCINVIO1");
            mcSID1.row.UNIQUE1 = Cursor_sid_invio1.GetString("UNIQUE1");
            mcSID1.row.FLGUNQ1 = Cursor_sid_invio1.GetString("FLGUNQ1");
            mcSID1.row.MODINVIO1 = Cursor_sid_invio1.GetDate("MODINVIO1");
            Cursor_sid_invio1.Next();
          }
          m_cConnectivityError = Cursor_sid_invio1.ErrorMessage();
          Cursor_sid_invio1.Close();
          mcSID1.GoTop();
          // * --- Fill memory cursor mcSID2 on sid_invio2
          mcSID2.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio2");
          m_cPhName = m_Ctx.GetPhName("sid_invio2");
          if (Cursor_sid_invio2!=null)
            Cursor_sid_invio2.Close();
          Cursor_sid_invio2 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO2="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio2")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio2;
            Cursor_sid_invio2.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio2 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio2.Eof())) {
            mcSID2.AppendBlank();
            mcSID2.row.CODINVIO2 = Cursor_sid_invio2.GetString("CODINVIO2");
            mcSID2.row.RAPINVIO2 = Cursor_sid_invio2.GetString("RAPINVIO2");
            mcSID2.row.APRINVIO2 = Cursor_sid_invio2.GetDouble("APRINVIO2");
            mcSID2.row.INIINVIO2 = Cursor_sid_invio2.GetDate("INIINVIO2");
            mcSID2.row.FININVIO2 = Cursor_sid_invio2.GetDate("FININVIO2");
            mcSID2.row.FCFINVIO2 = Cursor_sid_invio2.GetDouble("FCFINVIO2");
            mcSID2.row.CFSINVIO2 = Cursor_sid_invio2.GetString("CFSINVIO2");
            mcSID2.row.RUOINVIO2 = Cursor_sid_invio2.GetString("RUOINVIO2");
            mcSID2.row.COGINVIO2 = Cursor_sid_invio2.GetString("COGINVIO2");
            mcSID2.row.NOMINVIO2 = Cursor_sid_invio2.GetString("NOMINVIO2");
            mcSID2.row.SEXINVIO2 = Cursor_sid_invio2.GetString("SEXINVIO2");
            mcSID2.row.DNSINVIO2 = Cursor_sid_invio2.GetDate("DNSINVIO2");
            mcSID2.row.CNSINVIO2 = Cursor_sid_invio2.GetString("CNSINVIO2");
            mcSID2.row.PNSINVIO2 = Cursor_sid_invio2.GetString("PNSINVIO2");
            mcSID2.row.RGSINVIO2 = Cursor_sid_invio2.GetString("RGSINVIO2");
            mcSID2.row.CSLINVIO2 = Cursor_sid_invio2.GetString("CSLINVIO2");
            mcSID2.row.PLSINVIO2 = Cursor_sid_invio2.GetString("PLSINVIO2");
            Cursor_sid_invio2.Next();
          }
          m_cConnectivityError = Cursor_sid_invio2.ErrorMessage();
          Cursor_sid_invio2.Close();
          mcSID2.GoTop();
          // * --- Fill memory cursor mcSID3 on sid_invio3
          mcSID3.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio3");
          m_cPhName = m_Ctx.GetPhName("sid_invio3");
          if (Cursor_sid_invio3!=null)
            Cursor_sid_invio3.Close();
          Cursor_sid_invio3 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO3="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio3")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio3;
            Cursor_sid_invio3.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio3 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio3.Eof())) {
            mcSID3.AppendBlank();
            mcSID3.row.CODINVIO3 = Cursor_sid_invio3.GetString("CODINVIO3");
            mcSID3.row.RAPINVIO3 = Cursor_sid_invio3.GetString("RAPINVIO3");
            mcSID3.row.TPRINVIO3 = Cursor_sid_invio3.GetString("TPRINVIO3");
            mcSID3.row.ANNINVIO3 = Cursor_sid_invio3.GetDouble("ANNINVIO3");
            mcSID3.row.VALINVIO3 = Cursor_sid_invio3.GetString("VALINVIO3");
            mcSID3.row.NATINVIO3 = Cursor_sid_invio3.GetString("NATINVIO3");
            mcSID3.row.IM1INVIO3 = Cursor_sid_invio3.GetDouble("IM1INVIO3");
            mcSID3.row.FI1INVIO3 = Cursor_sid_invio3.GetDouble("FI1INVIO3");
            mcSID3.row.IM2INVIO3 = Cursor_sid_invio3.GetDouble("IM2INVIO3");
            mcSID3.row.FI2INVIO3 = Cursor_sid_invio3.GetDouble("FI2INVIO3");
            mcSID3.row.IM3INVIO3 = Cursor_sid_invio3.GetDouble("IM3INVIO3");
            mcSID3.row.FI3INVIO3 = Cursor_sid_invio3.GetDouble("FI3INVIO3");
            mcSID3.row.IM4INVIO3 = Cursor_sid_invio3.GetDouble("IM4INVIO3");
            mcSID3.row.FI4INVIO3 = Cursor_sid_invio3.GetDouble("FI4INVIO3");
            mcSID3.row.IM5INVIO3 = Cursor_sid_invio3.GetDouble("IM5INVIO3");
            mcSID3.row.FI5INVIO3 = Cursor_sid_invio3.GetDouble("FI5INVIO3");
            mcSID3.row.IM6INVIO3 = Cursor_sid_invio3.GetDouble("IM6INVIO3");
            mcSID3.row.FI6INVIO3 = Cursor_sid_invio3.GetDouble("FI6INVIO3");
            mcSID3.row.UNIQUE3 = Cursor_sid_invio3.GetString("UNIQUE3");
            mcSID3.row.FLGUNQ3 = Cursor_sid_invio3.GetString("FLGUNQ3");
            Cursor_sid_invio3.Next();
          }
          m_cConnectivityError = Cursor_sid_invio3.ErrorMessage();
          Cursor_sid_invio3.Close();
          mcSID3.GoTop();
        } // End If
        /* If w_xtipinvio='2' and w_xtpcinvio='4' */
        if (CPLib.eqr(w_xtipinvio,"2") && CPLib.eqr(w_xtpcinvio,"4")) {
          /* w_anno := Left(w_stpinvio,4) */
          w_anno = CPLib.Left(w_stpinvio,4);
          /* w_mese := Substr(w_stpinvio,5,2) */
          w_mese = CPLib.Substr(w_stpinvio,5,2);
          // * --- Fill memory cursor mcSID0 on sid_invio
          mcSID0.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          if (Cursor_sid_invio!=null)
            Cursor_sid_invio.Close();
          Cursor_sid_invio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio;
            Cursor_sid_invio.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio.Eof())) {
            mcSID0.AppendBlank();
            mcSID0.row.CODINVIO = Cursor_sid_invio.GetString("CODINVIO");
            mcSID0.row.TIPINVIO = Cursor_sid_invio.GetString("TIPINVIO");
            mcSID0.row.TPCINVIO = Cursor_sid_invio.GetString("TPCINVIO");
            mcSID0.row.DATINVIO = Cursor_sid_invio.GetDate("DATINVIO");
            mcSID0.row.ANNINVIO = Cursor_sid_invio.GetString("ANNINVIO");
            mcSID0.row.MESINVIO = Cursor_sid_invio.GetString("MESINVIO");
            mcSID0.row.PRTINVIO = Cursor_sid_invio.GetString("PRTINVIO");
            mcSID0.row.FLEINVIO = Cursor_sid_invio.GetString("FLEINVIO");
            mcSID0.row.FL1INVIO = Cursor_sid_invio.GetString("FL1INVIO");
            mcSID0.row.FL2INVIO = Cursor_sid_invio.GetString("FL2INVIO");
            mcSID0.row.FLGINVIO = Cursor_sid_invio.GetString("FLGINVIO");
            Cursor_sid_invio.Next();
          }
          m_cConnectivityError = Cursor_sid_invio.ErrorMessage();
          Cursor_sid_invio.Close();
          mcSID0.GoTop();
          // * --- Fill memory cursor mcSID1 on sid_invio1
          mcSID1.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          if (Cursor_sid_invio1!=null)
            Cursor_sid_invio1.Close();
          Cursor_sid_invio1 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO1="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio1")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio1;
            Cursor_sid_invio1.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio1.Eof())) {
            mcSID1.AppendBlank();
            mcSID1.row.CODINVIO1 = Cursor_sid_invio1.GetString("CODINVIO1");
            mcSID1.row.RAPINVIO1 = Cursor_sid_invio1.GetString("RAPINVIO1");
            mcSID1.row.TPRINVIO1 = Cursor_sid_invio1.GetString("TPRINVIO1");
            mcSID1.row.INIINVIO1 = Cursor_sid_invio1.GetDate("INIINVIO1");
            mcSID1.row.FININVIO1 = Cursor_sid_invio1.GetDate("FININVIO1");
            mcSID1.row.CABINVIO1 = Cursor_sid_invio1.GetString("CABINVIO1");
            mcSID1.row.ESIINVIO1 = Cursor_sid_invio1.GetString("ESIINVIO1");
            mcSID1.row.TIPINVIO1 = Cursor_sid_invio1.GetString("TIPINVIO1");
            mcSID1.row.TPCINVIO1 = Cursor_sid_invio1.GetString("TPCINVIO1");
            mcSID1.row.UNIQUE1 = Cursor_sid_invio1.GetString("UNIQUE1");
            mcSID1.row.FLGUNQ1 = Cursor_sid_invio1.GetString("FLGUNQ1");
            mcSID1.row.MODINVIO1 = Cursor_sid_invio1.GetDate("MODINVIO1");
            Cursor_sid_invio1.Next();
          }
          m_cConnectivityError = Cursor_sid_invio1.ErrorMessage();
          Cursor_sid_invio1.Close();
          mcSID1.GoTop();
        } // End If
        /* If w_xtipinvio='1' and w_xtpcinvio='3' */
        if (CPLib.eqr(w_xtipinvio,"1") && CPLib.eqr(w_xtpcinvio,"3")) {
          /* w_anno := Left(w_stpinvio,4) */
          w_anno = CPLib.Left(w_stpinvio,4);
          /* w_mese := Substr(w_stpinvio,5,2) */
          w_mese = CPLib.Substr(w_stpinvio,5,2);
          // * --- Fill memory cursor mcSID0 on sid_invio
          mcSID0.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          if (Cursor_sid_invio!=null)
            Cursor_sid_invio.Close();
          Cursor_sid_invio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio;
            Cursor_sid_invio.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio.Eof())) {
            mcSID0.AppendBlank();
            mcSID0.row.CODINVIO = Cursor_sid_invio.GetString("CODINVIO");
            mcSID0.row.TIPINVIO = Cursor_sid_invio.GetString("TIPINVIO");
            mcSID0.row.TPCINVIO = Cursor_sid_invio.GetString("TPCINVIO");
            mcSID0.row.DATINVIO = Cursor_sid_invio.GetDate("DATINVIO");
            mcSID0.row.ANNINVIO = Cursor_sid_invio.GetString("ANNINVIO");
            mcSID0.row.MESINVIO = Cursor_sid_invio.GetString("MESINVIO");
            mcSID0.row.PRTINVIO = Cursor_sid_invio.GetString("PRTINVIO");
            mcSID0.row.FLEINVIO = Cursor_sid_invio.GetString("FLEINVIO");
            mcSID0.row.FL1INVIO = Cursor_sid_invio.GetString("FL1INVIO");
            mcSID0.row.FL2INVIO = Cursor_sid_invio.GetString("FL2INVIO");
            mcSID0.row.FLGINVIO = Cursor_sid_invio.GetString("FLGINVIO");
            Cursor_sid_invio.Next();
          }
          m_cConnectivityError = Cursor_sid_invio.ErrorMessage();
          Cursor_sid_invio.Close();
          mcSID0.GoTop();
          // * --- Fill memory cursor mcSID1 on sid_invio1
          mcSID1.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          if (Cursor_sid_invio1!=null)
            Cursor_sid_invio1.Close();
          Cursor_sid_invio1 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO1="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio1")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio1;
            Cursor_sid_invio1.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio1.Eof())) {
            mcSID1.AppendBlank();
            mcSID1.row.CODINVIO1 = Cursor_sid_invio1.GetString("CODINVIO1");
            mcSID1.row.RAPINVIO1 = Cursor_sid_invio1.GetString("RAPINVIO1");
            mcSID1.row.TPRINVIO1 = Cursor_sid_invio1.GetString("TPRINVIO1");
            mcSID1.row.INIINVIO1 = Cursor_sid_invio1.GetDate("INIINVIO1");
            mcSID1.row.FININVIO1 = Cursor_sid_invio1.GetDate("FININVIO1");
            mcSID1.row.CABINVIO1 = Cursor_sid_invio1.GetString("CABINVIO1");
            mcSID1.row.ESIINVIO1 = Cursor_sid_invio1.GetString("ESIINVIO1");
            mcSID1.row.TIPINVIO1 = Cursor_sid_invio1.GetString("TIPINVIO1");
            mcSID1.row.TPCINVIO1 = Cursor_sid_invio1.GetString("TPCINVIO1");
            mcSID1.row.UNIQUE1 = Cursor_sid_invio1.GetString("UNIQUE1");
            mcSID1.row.FLGUNQ1 = Cursor_sid_invio1.GetString("FLGUNQ1");
            mcSID1.row.MODINVIO1 = Cursor_sid_invio1.GetDate("MODINVIO1");
            Cursor_sid_invio1.Next();
          }
          m_cConnectivityError = Cursor_sid_invio1.ErrorMessage();
          Cursor_sid_invio1.Close();
          mcSID1.GoTop();
          // * --- Fill memory cursor mcSID3 on sid_invio3
          mcSID3.Zap();
          m_cServer = m_Ctx.GetServer("sid_invio3");
          m_cPhName = m_Ctx.GetPhName("sid_invio3");
          if (Cursor_sid_invio3!=null)
            Cursor_sid_invio3.Close();
          Cursor_sid_invio3 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINVIO3="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_stpinvio,"?",0,0,m_cServer, m_oParameters),m_cServer,w_stpinvio)+" "+")"+(m_Ctx.IsSharedTemp("sid_invio3")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_sid_invio3;
            Cursor_sid_invio3.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_rstp_invio: query on sid_invio3 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_sid_invio3.Eof())) {
            mcSID3.AppendBlank();
            mcSID3.row.CODINVIO3 = Cursor_sid_invio3.GetString("CODINVIO3");
            mcSID3.row.RAPINVIO3 = Cursor_sid_invio3.GetString("RAPINVIO3");
            mcSID3.row.TPRINVIO3 = Cursor_sid_invio3.GetString("TPRINVIO3");
            mcSID3.row.ANNINVIO3 = Cursor_sid_invio3.GetDouble("ANNINVIO3");
            mcSID3.row.VALINVIO3 = Cursor_sid_invio3.GetString("VALINVIO3");
            mcSID3.row.NATINVIO3 = Cursor_sid_invio3.GetString("NATINVIO3");
            mcSID3.row.IM1INVIO3 = Cursor_sid_invio3.GetDouble("IM1INVIO3");
            mcSID3.row.FI1INVIO3 = Cursor_sid_invio3.GetDouble("FI1INVIO3");
            mcSID3.row.IM2INVIO3 = Cursor_sid_invio3.GetDouble("IM2INVIO3");
            mcSID3.row.FI2INVIO3 = Cursor_sid_invio3.GetDouble("FI2INVIO3");
            mcSID3.row.IM3INVIO3 = Cursor_sid_invio3.GetDouble("IM3INVIO3");
            mcSID3.row.FI3INVIO3 = Cursor_sid_invio3.GetDouble("FI3INVIO3");
            mcSID3.row.IM4INVIO3 = Cursor_sid_invio3.GetDouble("IM4INVIO3");
            mcSID3.row.FI4INVIO3 = Cursor_sid_invio3.GetDouble("FI4INVIO3");
            mcSID3.row.IM5INVIO3 = Cursor_sid_invio3.GetDouble("IM5INVIO3");
            mcSID3.row.FI5INVIO3 = Cursor_sid_invio3.GetDouble("FI5INVIO3");
            mcSID3.row.IM6INVIO3 = Cursor_sid_invio3.GetDouble("IM6INVIO3");
            mcSID3.row.FI6INVIO3 = Cursor_sid_invio3.GetDouble("FI6INVIO3");
            mcSID3.row.UNIQUE3 = Cursor_sid_invio3.GetString("UNIQUE3");
            mcSID3.row.FLGUNQ3 = Cursor_sid_invio3.GetString("FLGUNQ3");
            Cursor_sid_invio3.Next();
          }
          m_cConnectivityError = Cursor_sid_invio3.ErrorMessage();
          Cursor_sid_invio3.Close();
          mcSID3.GoTop();
        } // End If
        for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
          /* _stampa := 1 */
          _stampa = CPLib.Round(1,0);
          // * --- Insert into tmp_sid_invio1 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_rstp_invio",84,"00000054")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000054(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio1",true);
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
        }
        for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
          // * --- Insert into tmp_sid_invio2 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio2");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio2",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_rstp_invio",84,"00000056")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000056(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CODINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RAPINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.APRINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.INIINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FININVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FCFINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CFSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RUOINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.COGINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.NOMINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.SEXINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.DNSINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CNSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PNSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RGSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CSLINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PLSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio2",true);
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
        }
        for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
          // * --- Insert into tmp_sid_invio3 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio3");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio3",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_rstp_invio",84,"00000058")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000058(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.CODINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.TPRINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.ANNINVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.VALINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM1INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI1INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM2INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI2INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM3INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI3INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM4INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI4INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM5INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI5INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM6INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI6INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio3",true);
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
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Invio: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione Invio: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Elaborazione Terminata. E' possibile effettuare la stampa" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. E' possibile effettuare la stampa";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* _okrep := 1 */
        _okrep = CPLib.Round(1,0);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000002Bstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000002Bstatus,cTry0000002Bmsg);
        }
      }
      /* If _okrep=0 */
      if (CPLib.eqr(_okrep,0)) {
        /* If _stampa=1 */
        if (CPLib.eqr(_stampa,1)) {
          /* Stop arrp_fam_stpperiodo.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("hideCover",true);
          f.SetParameter("hideLanguage",true);
          f.SetParameter("hideSettings",true);
          f.SetParameter("DescAzi",gDescAzi);
          f.SetParameter("w_annoc",w_anno);
          f.SetParameter("w_mese",w_mese);
          f.SetParameter("w_fgldett",w_flgdett);
          f.SetParameter("ReportName","arrp_fam_stpperiodo.vrp");
          f.SetParameter("m_cParameterSequence","hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"DescAzi"+","+"w_annoc"+","+"w_mese"+","+"w_fgldett"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          // * --- Insert into tmp_sid_invio1 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_rstp_invio",84,"00000062")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000062(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("00000000","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio1",true);
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
          /* Stop arrp_fam_stpperiodo_neg.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("hideCover",true);
          f.SetParameter("hideLanguage",true);
          f.SetParameter("hideSettings",true);
          f.SetParameter("DescAzi",gDescAzi);
          f.SetParameter("w_annoc",w_anno);
          f.SetParameter("w_mese",w_mese);
          f.SetParameter("ReportName","arrp_fam_stpperiodo_neg.vrp");
          f.SetParameter("m_cParameterSequence","hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"DescAzi"+","+"w_annoc"+","+"w_mese"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_sid_invio!=null)
          Cursor_sid_invio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sid_invio1!=null)
          Cursor_sid_invio1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sid_invio2!=null)
          Cursor_sid_invio2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sid_invio3!=null)
          Cursor_sid_invio3.Close();
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
      m_Caller.SetString("stpinvio","C",10,0,w_stpinvio);
      m_Caller.SetDate("xdatinvio","D",8,0,w_xdatinvio);
      m_Caller.SetString("xtipinvio","C",1,0,w_xtipinvio);
      m_Caller.SetString("xtpcinvio","C",1,0,w_xtpcinvio);
      m_Caller.SetString("flgdett","C",2,0,w_flgdett);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_fam_rstp_invioR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_rstp_invioR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_stpinvio = m_Caller.GetString("stpinvio","C",10,0);
    w_xdatinvio = m_Caller.GetDate("xdatinvio","D",8,0);
    w_xtipinvio = m_Caller.GetString("xtipinvio","C",1,0);
    w_xtpcinvio = m_Caller.GetString("xtpcinvio","C",1,0);
    w_flgdett = m_Caller.GetString("flgdett","C",2,0);
    _conta = 0;
    _errore = "";
    mcTemp = new MemoryCursor_tmp_stpperiodo();
    rowTemp = new MemoryCursorRow_tmp_stpperiodo();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID2 = new MemoryCursor_sid_invio2();
    rowSID2 = new MemoryCursorRow_sid_invio2();
    mcSID2r = new MemoryCursor_sid_invio2();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    mcSID4 = new MemoryCursor_sid_invio4();
    mcSID4r = new MemoryCursor_sid_invio4();
    _crea = 0;
    _stampa = 0;
    _okrep = 0;
    _asaldi = 0;
    w_anno = CPLib.Space(4);
    w_mese = CPLib.Space(2);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000054(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000056(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO2,";
    p_cSql = p_cSql+"RAPINVIO2,";
    p_cSql = p_cSql+"APRINVIO2,";
    p_cSql = p_cSql+"INIINVIO2,";
    p_cSql = p_cSql+"FININVIO2,";
    p_cSql = p_cSql+"FCFINVIO2,";
    p_cSql = p_cSql+"CFSINVIO2,";
    p_cSql = p_cSql+"RUOINVIO2,";
    p_cSql = p_cSql+"COGINVIO2,";
    p_cSql = p_cSql+"NOMINVIO2,";
    p_cSql = p_cSql+"SEXINVIO2,";
    p_cSql = p_cSql+"DNSINVIO2,";
    p_cSql = p_cSql+"CNSINVIO2,";
    p_cSql = p_cSql+"PNSINVIO2,";
    p_cSql = p_cSql+"RGSINVIO2,";
    p_cSql = p_cSql+"CSLINVIO2,";
    p_cSql = p_cSql+"PLSINVIO2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio2",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000058(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO3,";
    p_cSql = p_cSql+"RAPINVIO3,";
    p_cSql = p_cSql+"TPRINVIO3,";
    p_cSql = p_cSql+"ANNINVIO3,";
    p_cSql = p_cSql+"VALINVIO3,";
    p_cSql = p_cSql+"IM1INVIO3,";
    p_cSql = p_cSql+"FI1INVIO3,";
    p_cSql = p_cSql+"IM2INVIO3,";
    p_cSql = p_cSql+"FI2INVIO3,";
    p_cSql = p_cSql+"IM3INVIO3,";
    p_cSql = p_cSql+"FI3INVIO3,";
    p_cSql = p_cSql+"IM4INVIO3,";
    p_cSql = p_cSql+"FI4INVIO3,";
    p_cSql = p_cSql+"IM5INVIO3,";
    p_cSql = p_cSql+"FI5INVIO3,";
    p_cSql = p_cSql+"IM6INVIO3,";
    p_cSql = p_cSql+"FI6INVIO3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000062(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio1",true);
    return p_cSql;
  }
}
