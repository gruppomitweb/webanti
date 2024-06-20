// * --- Area Manuale = BO - Header
// * --- arrt_cgo_import_vlt
import java.io.*;
import java.util.List;
import com.opencsv.*;
// import com.opencsv.CSVReader;
// import com.opencsv.CSVReaderBuilder;
// import com.opencsv.CSVParser;
// import com.opencsv.CSVParserBuilder;
// * --- Fine Area Manuale
public class arrt_cgo_import_vltR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cgo_telematico;
  public String m_cServer_cgo_telematico;
  public String m_cPhName_cgo_vlt_convalidati;
  public String m_cServer_cgo_vlt_convalidati;
  public String m_cPhName_cgo_vlt_emessi;
  public String m_cServer_cgo_vlt_emessi;
  public String m_cPhName_cgo_vlt_impdata;
  public String m_cServer_cgo_vlt_impdata;
  public String m_cPhName_cgo_vlt_report;
  public String m_cServer_cgo_vlt_report;
  public String m_cPhName_cgo_vlt_sessioni;
  public String m_cServer_cgo_vlt_sessioni;
  public String m_cPhName_cgo_vltplat;
  public String m_cServer_cgo_vltplat;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_destwarn;
  public String m_cServer_destwarn;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_cgo_vlt_scarti;
  public String m_cServer_cgo_vlt_scarti;
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
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathDoc;
  public double _tot;
  public String _dirbase;
  public double _orastop;
  public double _rownum;
  public String _nomefile;
  public String _tipofile;
  public String _codiceplat;
  public double _prog;
  public String _prgtele;
  public String _gAzienda;
  public String _gPathDoc;
  public String _oldazi;
  public String _separator;
  public double _intesta;
  public String _platcod;
  public String _coddip;
  public double _rapgino;
  public double _rapgiin;
  public double _rapvino;
  public String _idticket;
  public String _idsala;
  public java.sql.Timestamp _dataemi;
  public String _idvlt;
  public String _piattaforme;
  public String _fileok;
  public String _gMsgProc;
  public String cProg;
  public java.sql.Date _dataoggi;
  public String _vltemi;
  public double _nomemi;
  public double _nomses;
  public double _nomcon;
  public double _nomout;
  public java.sql.Date _dataimp;
  public double _prgscarti;
  public String _srvmail;
  public double _prtmail;
  public String _emlmail;
  public String _usrmail;
  public String _pwdmail;
  public String _esito;
  public MemoryCursor_cgo_vltplat mcVLTPLAT;
  public MemoryCursor_anadip mcANADIP;
  public MemoryCursor_cgo_vlt_report mcVLTREP;
  public MemoryCursorRow_rwcheck_mcrdef rowVLTPLAT;
  public java.sql.Date _datachk;
  public double _trovato;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_import_vlt
  String[] cmdArray = new String[10];
  // * --- Fine Area Manuale
  public arrt_cgo_import_vltR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_import_vlt",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cgo_telematico = p_ContextObject.GetPhName("cgo_telematico");
    if (m_cPhName_cgo_telematico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico = m_cPhName_cgo_telematico+" "+m_Ctx.GetWritePhName("cgo_telematico");
    }
    m_cServer_cgo_telematico = p_ContextObject.GetServer("cgo_telematico");
    m_cPhName_cgo_vlt_convalidati = p_ContextObject.GetPhName("cgo_vlt_convalidati");
    if (m_cPhName_cgo_vlt_convalidati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vlt_convalidati = m_cPhName_cgo_vlt_convalidati+" "+m_Ctx.GetWritePhName("cgo_vlt_convalidati");
    }
    m_cServer_cgo_vlt_convalidati = p_ContextObject.GetServer("cgo_vlt_convalidati");
    m_cPhName_cgo_vlt_emessi = p_ContextObject.GetPhName("cgo_vlt_emessi");
    if (m_cPhName_cgo_vlt_emessi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vlt_emessi = m_cPhName_cgo_vlt_emessi+" "+m_Ctx.GetWritePhName("cgo_vlt_emessi");
    }
    m_cServer_cgo_vlt_emessi = p_ContextObject.GetServer("cgo_vlt_emessi");
    m_cPhName_cgo_vlt_impdata = p_ContextObject.GetPhName("cgo_vlt_impdata");
    if (m_cPhName_cgo_vlt_impdata.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vlt_impdata = m_cPhName_cgo_vlt_impdata+" "+m_Ctx.GetWritePhName("cgo_vlt_impdata");
    }
    m_cServer_cgo_vlt_impdata = p_ContextObject.GetServer("cgo_vlt_impdata");
    m_cPhName_cgo_vlt_report = p_ContextObject.GetPhName("cgo_vlt_report");
    if (m_cPhName_cgo_vlt_report.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vlt_report = m_cPhName_cgo_vlt_report+" "+m_Ctx.GetWritePhName("cgo_vlt_report");
    }
    m_cServer_cgo_vlt_report = p_ContextObject.GetServer("cgo_vlt_report");
    m_cPhName_cgo_vlt_sessioni = p_ContextObject.GetPhName("cgo_vlt_sessioni");
    if (m_cPhName_cgo_vlt_sessioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vlt_sessioni = m_cPhName_cgo_vlt_sessioni+" "+m_Ctx.GetWritePhName("cgo_vlt_sessioni");
    }
    m_cServer_cgo_vlt_sessioni = p_ContextObject.GetServer("cgo_vlt_sessioni");
    m_cPhName_cgo_vltplat = p_ContextObject.GetPhName("cgo_vltplat");
    if (m_cPhName_cgo_vltplat.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vltplat = m_cPhName_cgo_vltplat+" "+m_Ctx.GetWritePhName("cgo_vltplat");
    }
    m_cServer_cgo_vltplat = p_ContextObject.GetServer("cgo_vltplat");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_destwarn = p_ContextObject.GetPhName("destwarn");
    if (m_cPhName_destwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_destwarn = m_cPhName_destwarn+" "+m_Ctx.GetWritePhName("destwarn");
    }
    m_cServer_destwarn = p_ContextObject.GetServer("destwarn");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_cgo_vlt_scarti = p_ContextObject.GetPhName("cgo_vlt_scarti");
    if (m_cPhName_cgo_vlt_scarti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vlt_scarti = m_cPhName_cgo_vlt_scarti+" "+m_Ctx.GetWritePhName("cgo_vlt_scarti");
    }
    m_cServer_cgo_vlt_scarti = p_ContextObject.GetServer("cgo_vlt_scarti");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_orastop",p_cVarName)) {
      return _orastop;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      return _rownum;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    if (CPLib.eqr("_intesta",p_cVarName)) {
      return _intesta;
    }
    if (CPLib.eqr("_rapgino",p_cVarName)) {
      return _rapgino;
    }
    if (CPLib.eqr("_rapgiin",p_cVarName)) {
      return _rapgiin;
    }
    if (CPLib.eqr("_rapvino",p_cVarName)) {
      return _rapvino;
    }
    if (CPLib.eqr("_nomemi",p_cVarName)) {
      return _nomemi;
    }
    if (CPLib.eqr("_nomses",p_cVarName)) {
      return _nomses;
    }
    if (CPLib.eqr("_nomcon",p_cVarName)) {
      return _nomcon;
    }
    if (CPLib.eqr("_nomout",p_cVarName)) {
      return _nomout;
    }
    if (CPLib.eqr("_prgscarti",p_cVarName)) {
      return _prgscarti;
    }
    if (CPLib.eqr("_prtmail",p_cVarName)) {
      return _prtmail;
    }
    if (CPLib.eqr("_trovato",p_cVarName)) {
      return _trovato;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_import_vlt";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("_dirbase",p_cVarName)) {
      return _dirbase;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_tipofile",p_cVarName)) {
      return _tipofile;
    }
    if (CPLib.eqr("_codiceplat",p_cVarName)) {
      return _codiceplat;
    }
    if (CPLib.eqr("_prgtele",p_cVarName)) {
      return _prgtele;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_gPathDoc",p_cVarName)) {
      return _gPathDoc;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_separator",p_cVarName)) {
      return _separator;
    }
    if (CPLib.eqr("_platcod",p_cVarName)) {
      return _platcod;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_idticket",p_cVarName)) {
      return _idticket;
    }
    if (CPLib.eqr("_idsala",p_cVarName)) {
      return _idsala;
    }
    if (CPLib.eqr("_idvlt",p_cVarName)) {
      return _idvlt;
    }
    if (CPLib.eqr("_piattaforme",p_cVarName)) {
      return _piattaforme;
    }
    if (CPLib.eqr("_fileok",p_cVarName)) {
      return _fileok;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_vltemi",p_cVarName)) {
      return _vltemi;
    }
    if (CPLib.eqr("_srvmail",p_cVarName)) {
      return _srvmail;
    }
    if (CPLib.eqr("_emlmail",p_cVarName)) {
      return _emlmail;
    }
    if (CPLib.eqr("_usrmail",p_cVarName)) {
      return _usrmail;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      return _pwdmail;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
    }
    if (CPLib.eqr("_dataimp",p_cVarName)) {
      return _dataimp;
    }
    if (CPLib.eqr("_datachk",p_cVarName)) {
      return _datachk;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataemi",p_cVarName)) {
      return _dataemi;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcVLTPLAT",p_cVarName)) {
      return mcVLTPLAT;
    }
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      return mcANADIP;
    }
    if (CPLib.eqr("mcVLTREP",p_cVarName)) {
      return mcVLTREP;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowVLTPLAT",p_cVarName)) {
      return rowVLTPLAT;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_orastop",p_cVarName)) {
      _orastop = value;
      return;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      _rownum = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
    if (CPLib.eqr("_intesta",p_cVarName)) {
      _intesta = value;
      return;
    }
    if (CPLib.eqr("_rapgino",p_cVarName)) {
      _rapgino = value;
      return;
    }
    if (CPLib.eqr("_rapgiin",p_cVarName)) {
      _rapgiin = value;
      return;
    }
    if (CPLib.eqr("_rapvino",p_cVarName)) {
      _rapvino = value;
      return;
    }
    if (CPLib.eqr("_nomemi",p_cVarName)) {
      _nomemi = value;
      return;
    }
    if (CPLib.eqr("_nomses",p_cVarName)) {
      _nomses = value;
      return;
    }
    if (CPLib.eqr("_nomcon",p_cVarName)) {
      _nomcon = value;
      return;
    }
    if (CPLib.eqr("_nomout",p_cVarName)) {
      _nomout = value;
      return;
    }
    if (CPLib.eqr("_prgscarti",p_cVarName)) {
      _prgscarti = value;
      return;
    }
    if (CPLib.eqr("_prtmail",p_cVarName)) {
      _prtmail = value;
      return;
    }
    if (CPLib.eqr("_trovato",p_cVarName)) {
      _trovato = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_dirbase",p_cVarName)) {
      _dirbase = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_tipofile",p_cVarName)) {
      _tipofile = value;
      return;
    }
    if (CPLib.eqr("_codiceplat",p_cVarName)) {
      _codiceplat = value;
      return;
    }
    if (CPLib.eqr("_prgtele",p_cVarName)) {
      _prgtele = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_gPathDoc",p_cVarName)) {
      _gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_separator",p_cVarName)) {
      _separator = value;
      return;
    }
    if (CPLib.eqr("_platcod",p_cVarName)) {
      _platcod = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_idticket",p_cVarName)) {
      _idticket = value;
      return;
    }
    if (CPLib.eqr("_idsala",p_cVarName)) {
      _idsala = value;
      return;
    }
    if (CPLib.eqr("_idvlt",p_cVarName)) {
      _idvlt = value;
      return;
    }
    if (CPLib.eqr("_piattaforme",p_cVarName)) {
      _piattaforme = value;
      return;
    }
    if (CPLib.eqr("_fileok",p_cVarName)) {
      _fileok = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_vltemi",p_cVarName)) {
      _vltemi = value;
      return;
    }
    if (CPLib.eqr("_srvmail",p_cVarName)) {
      _srvmail = value;
      return;
    }
    if (CPLib.eqr("_emlmail",p_cVarName)) {
      _emlmail = value;
      return;
    }
    if (CPLib.eqr("_usrmail",p_cVarName)) {
      _usrmail = value;
      return;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      _pwdmail = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
      return;
    }
    if (CPLib.eqr("_dataimp",p_cVarName)) {
      _dataimp = value;
      return;
    }
    if (CPLib.eqr("_datachk",p_cVarName)) {
      _datachk = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_dataemi",p_cVarName)) {
      _dataemi = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowVLTPLAT",p_cVarName)) {
      rowVLTPLAT = (MemoryCursorRow_rwcheck_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcVLTPLAT",p_cVarName)) {
      mcVLTPLAT = (MemoryCursor_cgo_vltplat)value;
      return;
    }
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      mcANADIP = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("mcVLTREP",p_cVarName)) {
      mcVLTREP = (MemoryCursor_cgo_vlt_report)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_cgo_vltplat=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cgo_vlt_impdata=null;
    CPResultSet Cursor_destwarn=null;
    try {
      /* pTipo Char(1) // Tipo (Batch - Diretto)  */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) */
      /* gMsgProc Memo */
      /* gPathDoc Memo */
      /* _tot Numeric(10, 0) */
      /* _dirbase Char(120) */
      /* _orastop Numeric(2, 0) */
      /* _rownum Numeric(10, 0) */
      /* _nomefile Memo */
      /* _tipofile Char(1) */
      /* _codiceplat Char(10) */
      /* _prog Numeric(20, 0) */
      /* _prgtele Char(15) */
      /* _gAzienda Char(10) */
      /* _gPathDoc Memo */
      /* _oldazi Char(10) */
      /* _separator Char(1) */
      /* _intesta Numeric(1, 0) */
      /* _platcod Char(2) */
      /* _coddip Char(6) */
      /* _rapgino Numeric(10, 5) */
      /* _rapgiin Numeric(10, 5) */
      /* _rapvino Numeric(10, 5) */
      /* _idticket Char(50) */
      /* _idsala Char(50) */
      /* _dataemi DateTime */
      /* _idvlt Char(50) */
      /* _piattaforme Memo */
      /* _fileok Char(1) */
      /* _gMsgProc Memo */
      /* cProg Char(20) */
      /* _dataoggi Date */
      /* _vltemi Char(50) */
      /* _nomemi Numeric(12, 2) */
      /* _nomses Numeric(12, 2) */
      /* _nomcon Numeric(12, 2) */
      /* _nomout Numeric(12, 2) */
      /* _dataimp Date */
      /* _prgscarti Numeric(20, 0) */
      /* _srvmail Char(50) */
      /* _prtmail Numeric(5, 0) */
      /* _emlmail Char(50) */
      /* _usrmail Char(50) */
      /* _pwdmail Char(30) */
      /* _esito Memo */
      /* mcVLTPLAT MemoryCursor(cgo_vltplat) */
      /* mcANADIP MemoryCursor(anadip) */
      /* mcVLTREP MemoryCursor(cgo_vlt_report) */
      /* rowVLTPLAT Row(rwCHECK.MCRDef) */
      /* If pTipo='B' */
      if (CPLib.eqr(pTipo,"B")) {
        /* Utilities.SetUserCode(1) */
        Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
        /* _oldazi := Utilities.GetCompany() */
        _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
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
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
        /* _gMsgProc := 'Ora inizio procedura di import: '+arfn_fdatetime(DateTime()) + NL */
        _gMsgProc = "Ora inizio procedura di import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      } else { // Else
        /* _oldazi := gAzienda */
        _oldazi = gAzienda;
        /* _gAzienda := gAzienda // Azienda */
        _gAzienda = gAzienda;
        /* gMsgProc := 'Ora inizio procedura di import: '+arfn_fdatetime(DateTime()) */
        gMsgProc = "Ora inizio procedura di import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      // * --- Fill memory cursor mcANADIP on anadip
      mcANADIP.Zap();
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      if (Cursor_anadip!=null)
        Cursor_anadip.Close();
      Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_anadip;
        Cursor_anadip.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_cgo_import_vlt: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_anadip.Eof())) {
        mcANADIP.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_anadip.GetString("CODICEAAMS")));
        mcANADIP.row.CODDIP = Cursor_anadip.GetString("CODDIP");
        mcANADIP.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
        mcANADIP.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
        mcANADIP.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
        mcANADIP.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
        mcANADIP.row.CAB = Cursor_anadip.GetString("CAB");
        mcANADIP.row.IDBASE = Cursor_anadip.GetString("IDBASE");
        mcANADIP.row.AGENTE = Cursor_anadip.GetString("AGENTE");
        mcANADIP.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
        mcANADIP.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
        mcANADIP.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
        mcANADIP.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
        mcANADIP.row.CODLOC = Cursor_anadip.GetString("CODLOC");
        mcANADIP.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
        mcANADIP.row.NUOVO = Cursor_anadip.GetString("NUOVO");
        mcANADIP.row.CAP = Cursor_anadip.GetString("CAP");
        mcANADIP.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
        mcANADIP.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
        mcANADIP.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
        mcANADIP.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
        mcANADIP.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
        mcANADIP.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
        mcANADIP.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
        mcANADIP.row.FLGATT = Cursor_anadip.GetString("FLGATT");
        mcANADIP.row.CODAGE = Cursor_anadip.GetString("CODAGE");
        mcANADIP.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
        mcANADIP.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
        mcANADIP.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
        mcANADIP.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
        mcANADIP.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
        mcANADIP.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
        mcANADIP.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
        mcANADIP.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
        mcANADIP.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
        mcANADIP.row.CAB2 = Cursor_anadip.GetString("CAB2");
        mcANADIP.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
        mcANADIP.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
        mcANADIP.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
        mcANADIP.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
        mcANADIP.row.CODFISC = Cursor_anadip.GetString("CODFISC");
        mcANADIP.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
        mcANADIP.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
        mcANADIP.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
        mcANADIP.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
        mcANADIP.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
        mcANADIP.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
        mcANADIP.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
        Cursor_anadip.Next();
      }
      m_cConnectivityError = Cursor_anadip.ErrorMessage();
      Cursor_anadip.Close();
      mcANADIP.GoTop();
      // * --- Fill memory cursor mcVLTPLAT on cgo_vltplat
      mcVLTPLAT.Zap();
      m_cServer = m_Ctx.GetServer("cgo_vltplat");
      m_cPhName = m_Ctx.GetPhName("cgo_vltplat");
      if (Cursor_cgo_vltplat!=null)
        Cursor_cgo_vltplat.Close();
      Cursor_cgo_vltplat = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_vltplat")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_cgo_vltplat;
        Cursor_cgo_vltplat.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_cgo_import_vlt: query on cgo_vltplat returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_cgo_vltplat.Eof())) {
        mcVLTPLAT.AppendWithTrimmedKey(Cursor_cgo_vltplat.GetString("VPCODICE"));
        mcVLTPLAT.row.VPCODICE = Cursor_cgo_vltplat.GetString("VPCODICE");
        mcVLTPLAT.row.VPDESCRI = Cursor_cgo_vltplat.GetString("VPDESCRI");
        mcVLTPLAT.row.VPFLGATT = Cursor_cgo_vltplat.GetString("VPFLGATT");
        mcVLTPLAT.row.VPIDAAMS = Cursor_cgo_vltplat.GetString("VPIDAAMS");
        mcVLTPLAT.row.VPCODPIAT = Cursor_cgo_vltplat.GetDouble("VPCODPIAT");
        mcVLTPLAT.row.VPSIGLAPIAT = Cursor_cgo_vltplat.GetString("VPSIGLAPIAT");
        mcVLTPLAT.row.VPPROVENIENZA = Cursor_cgo_vltplat.GetString("VPPROVENIENZA");
        mcVLTPLAT.row.VPVLTCODPLAT = Cursor_cgo_vltplat.GetDouble("VPVLTCODPLAT");
        mcVLTPLAT.row.VPFLGCRYPTO = Cursor_cgo_vltplat.GetString("VPFLGCRYPTO");
        mcVLTPLAT.row.VFPKAYCRYPTO = Cursor_cgo_vltplat.GetString("VFPKAYCRYPTO");
        mcVLTPLAT.row.VPDIRFILE = Cursor_cgo_vltplat.GetString("VPDIRFILE");
        mcVLTPLAT.row.VPFILEINTESTA1 = Cursor_cgo_vltplat.GetString("VPFILEINTESTA1");
        mcVLTPLAT.row.VPFFILESPERATOR1 = Cursor_cgo_vltplat.GetString("VPFFILESPERATOR1");
        mcVLTPLAT.row.VPFILEFORDATA1 = Cursor_cgo_vltplat.GetString("VPFILEFORDATA1");
        mcVLTPLAT.row.VPPREFFILE1 = Cursor_cgo_vltplat.GetString("VPPREFFILE1");
        mcVLTPLAT.row.VPFILEINTESTA2 = Cursor_cgo_vltplat.GetString("VPFILEINTESTA2");
        mcVLTPLAT.row.VPFFILESPERATOR2 = Cursor_cgo_vltplat.GetString("VPFFILESPERATOR2");
        mcVLTPLAT.row.VPFILEFORDATA2 = Cursor_cgo_vltplat.GetString("VPFILEFORDATA2");
        mcVLTPLAT.row.VPPREFFILE2 = Cursor_cgo_vltplat.GetString("VPPREFFILE2");
        mcVLTPLAT.row.VPFILEINTESTA3 = Cursor_cgo_vltplat.GetString("VPFILEINTESTA3");
        mcVLTPLAT.row.VPFFILESPERATOR3 = Cursor_cgo_vltplat.GetString("VPFFILESPERATOR3");
        mcVLTPLAT.row.VPFILEFORDATA3 = Cursor_cgo_vltplat.GetString("VPFILEFORDATA3");
        mcVLTPLAT.row.VPPREFFILE3 = Cursor_cgo_vltplat.GetString("VPPREFFILE3");
        mcVLTPLAT.row.VPFLGPRESUF1 = Cursor_cgo_vltplat.GetString("VPFLGPRESUF1");
        mcVLTPLAT.row.VPFLGPRESUF2 = Cursor_cgo_vltplat.GetString("VPFLGPRESUF2");
        mcVLTPLAT.row.VPFLGPRESUF3 = Cursor_cgo_vltplat.GetString("VPFLGPRESUF3");
        mcVLTPLAT.row.VPFLGCONVERSION = Cursor_cgo_vltplat.GetString("VPFLGCONVERSION");
        mcVLTPLAT.row.VFPFLAGIMPORT = Cursor_cgo_vltplat.GetString("VFPFLAGIMPORT");
        mcVLTPLAT.row.VFPTIPOFILE1 = Cursor_cgo_vltplat.GetString("VFPTIPOFILE1");
        mcVLTPLAT.row.VFPTIPOFILE2 = Cursor_cgo_vltplat.GetString("VFPTIPOFILE2");
        mcVLTPLAT.row.VFPTIPOFILE3 = Cursor_cgo_vltplat.GetString("VFPTIPOFILE3");
        Cursor_cgo_vltplat.Next();
      }
      m_cConnectivityError = Cursor_cgo_vltplat.ErrorMessage();
      Cursor_cgo_vltplat.Close();
      mcVLTPLAT.GoTop();
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _dirbase := intermbo->SOPATHIMPORT */
        _dirbase = Cursor_intermbo.GetString("SOPATHIMPORT");
        /* _orastop := intermbo->SOORAIMPORT */
        _orastop = CPLib.Round(Cursor_intermbo.GetDouble("SOORAIMPORT"),0);
        /* _srvmail := intermbo->ALTSRVMAIL */
        _srvmail = Cursor_intermbo.GetString("ALTSRVMAIL");
        /* _prtmail := iif(Empty(LRTrim(intermbo->ALTPRTMAIL)),25,Val(LRTrim(intermbo->ALTPRTMAIL))) */
        _prtmail = CPLib.Round((CPLib.Empty(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))?25:CPLib.Val(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))),0);
        /* _emlmail := intermbo->ALTEMLMAIL */
        _emlmail = Cursor_intermbo.GetString("ALTEMLMAIL");
        /* _usrmail := intermbo->ALTUSRMAIL */
        _usrmail = Cursor_intermbo.GetString("ALTUSRMAIL");
        /* _pwdmail := intermbo->ALTPWDMAIL */
        _pwdmail = Cursor_intermbo.GetString("ALTPWDMAIL");
        /* _gPathDoc := intermbo->RICEVUTE */
        _gPathDoc = Cursor_intermbo.GetString("RICEVUTE");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000051status;
      nTry00000051status = m_Sql.GetTransactionStatus();
      String cTry00000051msg;
      cTry00000051msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from cgo_vltplat
        m_cServer = m_Ctx.GetServer("cgo_vltplat");
        m_cPhName = m_Ctx.GetPhName("cgo_vltplat");
        if (Cursor_cgo_vltplat!=null)
          Cursor_cgo_vltplat.Close();
        Cursor_cgo_vltplat = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VFPFLAGIMPORT='S' "+")"+(m_Ctx.IsSharedTemp("cgo_vltplat")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_vltplat.Eof())) {
          /* _dataoggi := NullDate() */
          _dataoggi = CPLib.NullDate();
          // * --- Read from cgo_vlt_impdata
          m_cServer = m_Ctx.GetServer("cgo_vlt_impdata");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_impdata");
          m_cSql = "";
          m_cSql = m_cSql+"VLTIMPDATE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Date(),"D",8,0,m_cServer),m_cServer,CPLib.Date());
          m_cSql = m_cSql+" and VLTIMPCODPLAT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_vltplat.GetString("VPCODICE"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_vltplat.GetString("VPCODICE"));
          if (m_Ctx.IsSharedTemp("cgo_vlt_impdata")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTIMPDATE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dataoggi = Read_Cursor.GetDate("VLTIMPDATE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cgo_vlt_impdata into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dataoggi = CPLib.NullDate();
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_dataoggi) */
          if (CPLib.Empty(_dataoggi)) {
            // * --- Insert into cgo_vlt_impdata from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_vlt_impdata");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_impdata");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_impdata",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000056")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000056(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vltplat.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(Cursor_cgo_vltplat.GetString("VPPREFFILE1")))?arfn_cgo_nomefile_vltR.Make(m_Ctx,this).Run(Cursor_cgo_vltplat.GetString("VPFLGPRESUF1"),Cursor_cgo_vltplat.GetString("VPPREFFILE1"),Cursor_cgo_vltplat.GetString("VPFILEFORDATA1"),arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),1)):""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(Cursor_cgo_vltplat.GetString("VPPREFFILE2")))?arfn_cgo_nomefile_vltR.Make(m_Ctx,this).Run(Cursor_cgo_vltplat.GetString("VPFLGPRESUF2"),Cursor_cgo_vltplat.GetString("VPPREFFILE2"),Cursor_cgo_vltplat.GetString("VPFILEFORDATA2"),arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),1)):""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(Cursor_cgo_vltplat.GetString("VPPREFFILE3")))?arfn_cgo_nomefile_vltR.Make(m_Ctx,this).Run(Cursor_cgo_vltplat.GetString("VPFLGPRESUF3"),Cursor_cgo_vltplat.GetString("VPPREFFILE3"),Cursor_cgo_vltplat.GetString("VPFILEFORDATA3"),arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),1)):""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_impdata",true);
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
          } // End If
          Cursor_cgo_vltplat.Next();
        }
        m_cConnectivityError = Cursor_cgo_vltplat.ErrorMessage();
        Cursor_cgo_vltplat.Close();
        // * --- End Select
        /* If Hour(DateTime()) > _orastop and _orastop <> 0 */
        if (CPLib.gt(CPLib.Hour(CPLib.DateTime()),_orastop) && CPLib.ne(_orastop,0)) {
          /* _piattaforme := '' */
          _piattaforme = "";
          // * --- Select from cgo_vlt_impdata
          m_cServer = m_Ctx.GetServer("cgo_vlt_impdata");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_impdata");
          if (Cursor_cgo_vlt_impdata!=null)
            Cursor_cgo_vlt_impdata.Close();
          Cursor_cgo_vlt_impdata = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTIMPFLAGOK1='N'  and  VLTIMPFLAGOK2='N'  and  VLTIMPFLAGOK3='N' "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_impdata")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_impdata.Eof())) {
            /* If mcVLTPLAT.GoToKey(cgo_vlt_impdata->VLTIMPCODPLAT) */
            if (mcVLTPLAT.GoToKey(Cursor_cgo_vlt_impdata.GetString("VLTIMPCODPLAT"))) {
              /* _piattaforme := _piattaforme + LRTrim(mcVLTPLAT.VPDESCRI) +" - File: "+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE1)+", "+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE2)+", "+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE3) + NL */
              _piattaforme = _piattaforme+CPLib.LRTrim(mcVLTPLAT.row.VPDESCRI)+" - File: "+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE1"))+", "+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE2"))+", "+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE3"))+"\n";
            } // End If
            Cursor_cgo_vlt_impdata.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_impdata.ErrorMessage();
          Cursor_cgo_vlt_impdata.Close();
          // * --- End Select
          /* If not(Empty(LRTrim(_piattaforme))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_piattaforme)))) {
            /* _piattaforme := 'Non sono stati importati i file delle seguenti piattaforme: '+NL+NL+_piattaforme */
            _piattaforme = "Non sono stati importati i file delle seguenti piattaforme: "+"\n"+"\n"+_piattaforme;
            // * --- Select from destwarn
            m_cServer = m_Ctx.GetServer("destwarn");
            m_cPhName = m_Ctx.GetPhName("destwarn");
            if (Cursor_destwarn!=null)
              Cursor_destwarn.Close();
            Cursor_destwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DWFLGVLT='S' "+")"+(m_Ctx.IsSharedTemp("destwarn")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_destwarn.Eof())) {
              /* _esito := MailLibrary.sendMail(_piattaforme,'TXT','Importazione File VLT',LRTrim(_srvmail),LRTrim(destwarn->DWEMAIL),'','',LRTrim(_emlmail),'',LRTrim(_usrmail),LRTrim(_pwdmail),False,_prtmail,False,0,255,'','',False) */
              _esito = MailLibrary.sendMail(_piattaforme,"TXT","Importazione File VLT",CPLib.LRTrim(_srvmail),CPLib.LRTrim(Cursor_destwarn.GetString("DWEMAIL")),"","",CPLib.LRTrim(_emlmail),"",CPLib.LRTrim(_usrmail),CPLib.LRTrim(_pwdmail),false,_prtmail,false,0,255,"","",false);
              Cursor_destwarn.Next();
            }
            m_cConnectivityError = Cursor_destwarn.ErrorMessage();
            Cursor_destwarn.Close();
            // * --- End Select
          } // End If
        } // End If
        // * --- Select from cgo_vlt_impdata
        m_cServer = m_Ctx.GetServer("cgo_vlt_impdata");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_impdata");
        if (Cursor_cgo_vlt_impdata!=null)
          Cursor_cgo_vlt_impdata.Close();
        Cursor_cgo_vlt_impdata = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTIMPFLAGOK1='N'  and  VLTIMPFLAGOK2='N'  and  VLTIMPFLAGOK3='N' "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_impdata")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"VLTIMPDATE ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_vlt_impdata.Eof())) {
          /* mcVLTREP.Zap() */
          mcVLTREP.Zap();
          /* If mcVLTPLAT.GoToKey(cgo_vlt_impdata->VLTIMPCODPLAT) */
          if (mcVLTPLAT.GoToKey(Cursor_cgo_vlt_impdata.GetString("VLTIMPCODPLAT"))) {
            /* _fileok := 'S' */
            _fileok = "S";
            /* _fileok := CheckPrevFiles(cgo_vlt_impdata->VLTIMPCODPLAT,cgo_vlt_impdata->VLTIMPDATE) */
            _fileok = CheckPrevFiles(Cursor_cgo_vlt_impdata.GetString("VLTIMPCODPLAT"),Cursor_cgo_vlt_impdata.GetDate("VLTIMPDATE"));
            /* If _fileok='S' */
            if (CPLib.eqr(_fileok,"S")) {
              /* If mcVLTPLAT.VPFLGCRYPTO='S' */
              if (CPLib.eqr(mcVLTPLAT.row.VPFLGCRYPTO,"S")) {
                /* rowVLTPLAT.NOMEFILE1 := cgo_vlt_impdata->VLTIMPNOMEFILE1 */
                rowVLTPLAT.NOMEFILE1 = Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE1");
                /* rowVLTPLAT.NOMEFILE2 := cgo_vlt_impdata->VLTIMPNOMEFILE2 */
                rowVLTPLAT.NOMEFILE2 = Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE2");
                /* rowVLTPLAT.NOMEFILE3 := cgo_vlt_impdata->VLTIMPNOMEFILE3 */
                rowVLTPLAT.NOMEFILE3 = Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE3");
                /* rowVLTPLAT.NOMEDIR := mcVLTPLAT.VPDIRFILE */
                rowVLTPLAT.NOMEDIR = mcVLTPLAT.row.VPDIRFILE;
                /* rowVLTPLAT.CRYPPTOKEY := mcVLTPLAT.VFPKAYCRYPTO */
                rowVLTPLAT.CRYPPTOKEY = mcVLTPLAT.row.VFPKAYCRYPTO;
                /* rowVLTPLAT.DIRBASE := _dirbase */
                rowVLTPLAT.DIRBASE = _dirbase;
                /* _fileok := CheckFiles(rowVLTPLAT) */
                _fileok = CheckFiles(rowVLTPLAT);
              } // End If
              /* If _fileok='S' */
              if (CPLib.eqr(_fileok,"S")) {
                /* If FileLibMit.ExistFile(LRTrim(_dirbase)+"/"+LRTrim(mcVLTPLAT.VPDIRFILE)+"/"+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE1)) and FileLibMit.ExistFile(LRTrim(_dirbase)+"/"+LRTrim(mcVLTPLAT.VPDIRFILE)+"/"+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE2)) and FileLibMit.ExistFile(LRTrim(_dirbase)+"/"+LRTrim(mcVLTPLAT.VPDIRFILE)+"/"+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE3)) */
                if (FileLibMit.ExistFile(CPLib.LRTrim(_dirbase)+"/"+CPLib.LRTrim(mcVLTPLAT.row.VPDIRFILE)+"/"+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE1"))) && FileLibMit.ExistFile(CPLib.LRTrim(_dirbase)+"/"+CPLib.LRTrim(mcVLTPLAT.row.VPDIRFILE)+"/"+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE2"))) && FileLibMit.ExistFile(CPLib.LRTrim(_dirbase)+"/"+CPLib.LRTrim(mcVLTPLAT.row.VPDIRFILE)+"/"+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE3")))) {
                  /* _gMsgProc := _gMsgProc + 'Ora inizio Import piattaforma '+LRTrim(mcVLTPLAT.VPDESCRI)+": "+arfn_fdatetime(DateTime()) + NL */
                  _gMsgProc = _gMsgProc+"Ora inizio Import piattaforma "+CPLib.LRTrim(mcVLTPLAT.row.VPDESCRI)+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
                  /* If pTipo='D' */
                  if (CPLib.eqr(pTipo,"D")) {
                    /* gMsgProc := gMsgProc + _gMsgProc */
                    gMsgProc = gMsgProc+_gMsgProc;
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                  /* _codiceplat := mcVLTPLAT.VPIDAAMS */
                  _codiceplat = mcVLTPLAT.row.VPIDAAMS;
                  /* _dataimp := cgo_vlt_impdata->VLTIMPDATE */
                  _dataimp = Cursor_cgo_vlt_impdata.GetDate("VLTIMPDATE");
                  /* _platcod := mcVLTPLAT.VPCODICE */
                  _platcod = mcVLTPLAT.row.VPCODICE;
                  /* _separator := mcVLTPLAT.VPFFILESPERATOR1 */
                  _separator = mcVLTPLAT.row.VPFFILESPERATOR1;
                  /* _intesta := iif(mcVLTPLAT.VPFILEINTESTA1="S",1,0) */
                  _intesta = CPLib.Round((CPLib.eqr(mcVLTPLAT.row.VPFILEINTESTA1,"S")?1:0),0);
                  /* _nomefile := LRTrim(_dirbase)+"/"+LRTrim(mcVLTPLAT.VPDIRFILE)+"/"+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE1) */
                  _nomefile = CPLib.LRTrim(_dirbase)+"/"+CPLib.LRTrim(mcVLTPLAT.row.VPDIRFILE)+"/"+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE1"));
                  /* _tipofile := mcVLTPLAT.VFPTIPOFILE1 */
                  _tipofile = mcVLTPLAT.row.VFPTIPOFILE1;
                  /* Exec "Sessioni" Page 2:Sessioni */
                  Sessioni();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _separator := mcVLTPLAT.VPFFILESPERATOR2 */
                  _separator = mcVLTPLAT.row.VPFFILESPERATOR2;
                  /* _intesta := iif(mcVLTPLAT.VPFILEINTESTA2="S",1,0) */
                  _intesta = CPLib.Round((CPLib.eqr(mcVLTPLAT.row.VPFILEINTESTA2,"S")?1:0),0);
                  /* _nomefile := LRTrim(_dirbase)+"/"+LRTrim(mcVLTPLAT.VPDIRFILE)+"/"+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE2) */
                  _nomefile = CPLib.LRTrim(_dirbase)+"/"+CPLib.LRTrim(mcVLTPLAT.row.VPDIRFILE)+"/"+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE2"));
                  /* _tipofile := mcVLTPLAT.VFPTIPOFILE2 */
                  _tipofile = mcVLTPLAT.row.VFPTIPOFILE2;
                  /* Exec "Biglietti Emessi" Page 3:BigliettiEmessi */
                  BigliettiEmessi();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _separator := mcVLTPLAT.VPFFILESPERATOR3 */
                  _separator = mcVLTPLAT.row.VPFFILESPERATOR3;
                  /* _intesta := iif(mcVLTPLAT.VPFILEINTESTA3="S",1,0) */
                  _intesta = CPLib.Round((CPLib.eqr(mcVLTPLAT.row.VPFILEINTESTA3,"S")?1:0),0);
                  /* _nomefile := LRTrim(_dirbase)+"/"+LRTrim(mcVLTPLAT.VPDIRFILE)+"/"+LRTrim(cgo_vlt_impdata->VLTIMPNOMEFILE3) */
                  _nomefile = CPLib.LRTrim(_dirbase)+"/"+CPLib.LRTrim(mcVLTPLAT.row.VPDIRFILE)+"/"+CPLib.LRTrim(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE3"));
                  /* _tipofile := mcVLTPLAT.VFPTIPOFILE3 */
                  _tipofile = mcVLTPLAT.row.VFPTIPOFILE3;
                  /* Exec "Biglietti Convalidati" Page 4:BigliettiConvalidati */
                  BigliettiConvalidati();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  for (MemoryCursorRow_cgo_vlt_report rwVLTREP : mcVLTREP._iterable_()) {
                    /* _prog := 0 */
                    _prog = CPLib.Round(0,0);
                    // * --- Read from cgo_vlt_report
                    m_cServer = m_Ctx.GetServer("cgo_vlt_report");
                    m_cPhName = m_Ctx.GetPhName("cgo_vlt_report");
                    m_cSql = "";
                    m_cSql = m_cSql+"VLTREP_AAMSSALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwVLTREP.VLTREP_AAMSSALA,"C",50,0,m_cServer),m_cServer,rwVLTREP.VLTREP_AAMSSALA);
                    m_cSql = m_cSql+" and VLTREP_CODPLAT="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwVLTREP.VLTREP_CODPLAT,"C",10,0,m_cServer),m_cServer,rwVLTREP.VLTREP_CODPLAT);
                    m_cSql = m_cSql+" and VLTREP_AAMSVLT="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwVLTREP.VLTREP_AAMSVLT,"C",60,0,m_cServer),m_cServer,rwVLTREP.VLTREP_AAMSVLT);
                    m_cSql = m_cSql+" and VLTREP_IDTICKET="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwVLTREP.VLTREP_IDTICKET,"C",60,0,m_cServer),m_cServer,rwVLTREP.VLTREP_IDTICKET);
                    m_cSql = m_cSql+" and VLTREP_DATAEMI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwVLTREP.VLTREP_DATAEMI,"D",8,0,m_cServer),m_cServer,rwVLTREP.VLTREP_DATAEMI);
                    m_cSql = m_cSql+" and VLTREP_DATACONV="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwVLTREP.VLTREP_DATACONV,"D",8,0,m_cServer),m_cServer,rwVLTREP.VLTREP_DATACONV);
                    if (m_Ctx.IsSharedTemp("cgo_vlt_report")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTREP_IDPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _prog = CPLib.Round(Read_Cursor.GetDouble("VLTREP_IDPROG"),0);
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on cgo_vlt_report into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _prog = 0;
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If _prog=0 */
                    if (CPLib.eqr(_prog,0)) {
                      /* _prog := Utilities.GetAutonumber("PRGVLTREP\'"+LRTrim(_gAzienda)+"'",0,20) */
                      _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTREP\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                      // * --- Insert into cgo_vlt_report from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("cgo_vlt_report");
                      m_cPhName = m_Ctx.GetPhName("cgo_vlt_report");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_report",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000008C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000008C(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_AAMSSALA,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_CODCONC,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_CODPLAT,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_AAMSVLT,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_IDTICKET,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_VALNOM,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_DATAEMI,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_DATACONV,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_IMPBET,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_GROSWIN,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_NETWIN,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_TOTALE,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_RAPPORTO1,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_RAPPORTO2,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_RAPPORTO3,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_TICKET_BC,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rwVLTREP.VLTREP_ORIGINE,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_report",true);
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
                    } else { // Else
                      // * --- Write into cgo_vlt_report from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("cgo_vlt_report");
                      m_cPhName = m_Ctx.GetPhName("cgo_vlt_report");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_report",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000008D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"VLTREP_AAMSSALA = "+CPLib.ToSQL(rwVLTREP.VLTREP_AAMSSALA,"C",50,0,m_cServer)+", ";
                      m_cSql = m_cSql+"VLTREP_CODCONC = "+CPLib.ToSQL(rwVLTREP.VLTREP_CODCONC,"C",50,0,m_cServer)+", ";
                      m_cSql = m_cSql+"VLTREP_CODPLAT = "+CPLib.ToSQL(rwVLTREP.VLTREP_CODPLAT,"C",10,0,m_cServer)+", ";
                      m_cSql = m_cSql+"VLTREP_AAMSVLT = "+CPLib.ToSQL(rwVLTREP.VLTREP_AAMSVLT,"C",60,0,m_cServer)+", ";
                      m_cSql = m_cSql+"VLTREP_IDTICKET = "+CPLib.ToSQL(rwVLTREP.VLTREP_IDTICKET,"C",60,0,m_cServer)+", ";
                      m_cSql = m_cSql+"VLTREP_VALNOM = "+CPLib.ToSQL(rwVLTREP.VLTREP_VALNOM,"N",12,2)+", ";
                      m_cSql = m_cSql+"VLTREP_DATAEMI = "+CPLib.ToSQL(rwVLTREP.VLTREP_DATAEMI,"D",8,0)+", ";
                      m_cSql = m_cSql+"VLTREP_DATACONV = "+CPLib.ToSQL(rwVLTREP.VLTREP_DATACONV,"D",8,0)+", ";
                      m_cSql = m_cSql+"VLTREP_IMPBET = "+CPLib.ToSQL(rwVLTREP.VLTREP_IMPBET,"N",12,2)+", ";
                      m_cSql = m_cSql+"VLTREP_GROSWIN = "+CPLib.ToSQL(rwVLTREP.VLTREP_GROSWIN,"N",12,2)+", ";
                      m_cSql = m_cSql+"VLTREP_NETWIN = "+CPLib.ToSQL(rwVLTREP.VLTREP_NETWIN,"N",12,2)+", ";
                      m_cSql = m_cSql+"VLTREP_TOTALE = "+CPLib.ToSQL(rwVLTREP.VLTREP_TOTALE,"N",12,2)+", ";
                      m_cSql = m_cSql+"VLTREP_RAPPORTO1 = "+CPLib.ToSQL(rwVLTREP.VLTREP_RAPPORTO1,"N",10,2)+", ";
                      m_cSql = m_cSql+"VLTREP_RAPPORTO2 = "+CPLib.ToSQL(rwVLTREP.VLTREP_RAPPORTO2,"N",10,2)+", ";
                      m_cSql = m_cSql+"VLTREP_RAPPORTO3 = "+CPLib.ToSQL(rwVLTREP.VLTREP_RAPPORTO3,"N",10,2)+", ";
                      m_cSql = m_cSql+"VLTREP_TICKET_BC = "+CPLib.ToSQL(rwVLTREP.VLTREP_TICKET_BC,"C",50,0,m_cServer)+", ";
                      m_cSql = m_cSql+"VLTREP_ORIGINE = "+CPLib.ToSQL(rwVLTREP.VLTREP_ORIGINE,"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_vlt_report",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"VLTREP_IDPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_prog,"?",0,0,m_cServer),m_cServer,_prog)+"";
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
                  }
                  // * --- Write into cgo_vlt_impdata from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_vlt_impdata");
                  m_cPhName = m_Ctx.GetPhName("cgo_vlt_impdata");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_impdata",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000008E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"VLTIMPFLAGOK1 = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"VLTIMPFLAGOK2 = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"VLTIMPFLAGOK3 = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_vlt_impdata",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"VLTIMPDATE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_vlt_impdata.GetDate("VLTIMPDATE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_vlt_impdata.GetDate("VLTIMPDATE"))+"";
                  m_cSql = m_cSql+" and VLTIMPCODPLAT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_vlt_impdata.GetString("VLTIMPCODPLAT"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_vlt_impdata.GetString("VLTIMPCODPLAT"))+"";
                  m_cSql = m_cSql+" and VLTIMPNOMEFILE1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE1"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE1"))+"";
                  m_cSql = m_cSql+" and VLTIMPNOMEFILE2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE2"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE2"))+"";
                  m_cSql = m_cSql+" and VLTIMPNOMEFILE3 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE3"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_vlt_impdata.GetString("VLTIMPNOMEFILE3"))+"";
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
                  /* _gMsgProc := _gMsgProc + 'Ora fine Import piattaforma '+LRTrim(mcVLTPLAT.VPDESCRI)+": "+arfn_fdatetime(DateTime()) + NL */
                  _gMsgProc = _gMsgProc+"Ora fine Import piattaforma "+CPLib.LRTrim(mcVLTPLAT.row.VPDESCRI)+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
                  /* If pTipo='D' */
                  if (CPLib.eqr(pTipo,"D")) {
                    /* gMsgProc := gMsgProc + _gMsgProc */
                    gMsgProc = gMsgProc+_gMsgProc;
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                } // End If
              } else { // Else
                /* _piattaforme := _piattaforme + 'Controllo fallito dei file della piattaforma: '+LRTrim(mcVLTPLAT.VPDESCRI) + NL */
                _piattaforme = _piattaforme+"Controllo fallito dei file della piattaforma: "+CPLib.LRTrim(mcVLTPLAT.row.VPDESCRI)+"\n";
              } // End If
            } else { // Else
              /* _piattaforme := 'Esistono vecchi file non importati della seguente piattaforma: '+NL+NL+LRTrim(mcVLTPLAT.VPDESCRI) */
              _piattaforme = "Esistono vecchi file non importati della seguente piattaforma: "+"\n"+"\n"+CPLib.LRTrim(mcVLTPLAT.row.VPDESCRI);
            } // End If
          } // End If
          Cursor_cgo_vlt_impdata.Next();
        }
        m_cConnectivityError = Cursor_cgo_vlt_impdata.ErrorMessage();
        Cursor_cgo_vlt_impdata.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000051status,0)) {
          m_Sql.SetTransactionStatus(nTry00000051status,cTry00000051msg);
        }
      }
      /* If not(Empty(LRTrim(_piattaforme))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(_piattaforme)))) {
        // * --- Select from destwarn
        m_cServer = m_Ctx.GetServer("destwarn");
        m_cPhName = m_Ctx.GetPhName("destwarn");
        if (Cursor_destwarn!=null)
          Cursor_destwarn.Close();
        Cursor_destwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DWFLGVLT='S' "+")"+(m_Ctx.IsSharedTemp("destwarn")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_destwarn.Eof())) {
          /* _esito := MailLibrary.sendMail(_piattaforme,'TXT','Importazione File VLT',LRTrim(_srvmail),LRTrim(destwarn->DWEMAIL),'','',LRTrim(_emlmail),'',LRTrim(_usrmail),LRTrim(_pwdmail),False,_prtmail,False,0,255,'','',False) */
          _esito = MailLibrary.sendMail(_piattaforme,"TXT","Importazione File VLT",CPLib.LRTrim(_srvmail),CPLib.LRTrim(Cursor_destwarn.GetString("DWEMAIL")),"","",CPLib.LRTrim(_emlmail),"",CPLib.LRTrim(_usrmail),CPLib.LRTrim(_pwdmail),false,_prtmail,false,0,255,"","",false);
          Cursor_destwarn.Next();
        }
        m_cConnectivityError = Cursor_destwarn.ErrorMessage();
        Cursor_destwarn.Close();
        // * --- End Select
      } // End If
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgProc := gMsgProc + 'Ora fine procedura di import: '+arfn_fdatetime(DateTime()) */
        gMsgProc = gMsgProc+"Ora fine procedura di import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* _gMsgProc := _gMsgProc + 'Ora fine procedura di import: '+arfn_fdatetime(DateTime()) */
        _gMsgProc = _gMsgProc+"Ora fine procedura di import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      } // End If
      /* Exec Routine arrt_writelog('IMPORT VLT','Scheduler','ESTRAZIONE',iif(pTipo='D',gMsgProc,_gMsgProc),"S") */
      arrt_writelogR.Make(m_Ctx,this).Run("IMPORT VLT","Scheduler","ESTRAZIONE",(CPLib.eqr(pTipo,"D")?gMsgProc:_gMsgProc),"S");
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_vltplat!=null)
          Cursor_cgo_vltplat.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
      try {
        if (Cursor_cgo_vlt_impdata!=null)
          Cursor_cgo_vlt_impdata.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_destwarn!=null)
          Cursor_destwarn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Sessioni() throws Exception {
    // Crea il lettore con i parametri di separatore e testata
    FileReader freader=new FileReader(_nomefile);
    CSVParser parser = new CSVParserBuilder().withSeparator(_separator.charAt(0)).build();
    CSVReader reader = new CSVReaderBuilder(freader).withSkipLines((int)_intesta).withCSVParser(parser).build();
    /* If _tipofile='S' */
    if (CPLib.eqr(_tipofile,"S")) {
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      // Legge il csv e scrive la tabella
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
      /* _prog := Utilities.GetAutonumber("PRGVLTSES\'"+LRTrim(_gAzienda)+"'",0,20) */
      _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSES\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
      // * --- Insert into cgo_vlt_sessioni from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
      m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_sessioni",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000A4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000A4(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[3],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[5],1),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6]),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[7])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[8])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[9])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[10])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[11])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[12])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[13])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[14],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[15],"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(nextLine[16],4)+CPLib.Substr(nextLine[16],6,2)+CPLib.Substr(nextLine[16],9,2)),"?",0,0)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_sessioni",true);
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
      /* _rownum := _rownum + 1 */
      _rownum = CPLib.Round(_rownum+1,0);
      /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' sessioni ...' // Messaggio Trasferimento */
      gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" sessioni ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      }
      // Chiuse il file
      reader.close();
    } // End If
    /* If _tipofile='N' */
    if (CPLib.eqr(_tipofile,"N")) {
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      // Legge il csv e scrive la tabella
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
      /* _prog := Utilities.GetAutonumber("PRGVLTSES\'"+LRTrim(_gAzienda)+"'",0,20) */
      _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSES\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
      // * --- Insert into cgo_vlt_sessioni from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
      m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_sessioni",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000AD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000AD(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[3],1),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[5]),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[7])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[8])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[9])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[10])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[11])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[12])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[13],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[14],"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(nextLine[15],4)+CPLib.Substr(nextLine[15],6,2)+CPLib.Substr(nextLine[15],9,2)),"?",0,0)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_sessioni",true);
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
      /* _rownum := _rownum + 1 */
      _rownum = CPLib.Round(_rownum+1,0);
      /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' sessioni ...' // Messaggio Trasferimento */
      gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" sessioni ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      }
      // Chiuse il file
      reader.close();
    } // End If
    /* If _tipofile='P' */
    if (CPLib.eqr(_tipofile,"P")) {
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      // Legge il csv e scrive la tabella
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
      /* _prog := Utilities.GetAutonumber("PRGVLTSES\'"+LRTrim(_gAzienda)+"'",0,20) */
      _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSES\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
      // * --- Insert into cgo_vlt_sessioni from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
      m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_sessioni",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000B6(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[3],2),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],2),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[5]),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[7])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[8])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[9])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[10])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[11])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[12])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[13],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[14],"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(nextLine[15],4)+CPLib.Substr(nextLine[15],6,2)+CPLib.Substr(nextLine[15],9,2)),"?",0,0)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_sessioni",true);
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
      /* _rownum := _rownum + 1 */
      _rownum = CPLib.Round(_rownum+1,0);
      /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' sessioni ...' // Messaggio Trasferimento */
      gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" sessioni ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      }
      // Chiuse il file
      reader.close();
    } // End If
    /* If _tipofile='I' */
    if (CPLib.eqr(_tipofile,"I")) {
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      // Legge il csv e scrive la tabella
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
      /* _prog := Utilities.GetAutonumber("PRGVLTSES\'"+LRTrim(_gAzienda)+"'",0,20) */
      _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSES\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
      // * --- Insert into cgo_vlt_sessioni from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
      m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_sessioni",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000BF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000BF(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[4],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[6],"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[2],2),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[3],2),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[11]),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[12])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[13])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[14])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[8])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[10])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[9])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[15])/100,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(nextLine[19],7,4)+CPLib.Substr(nextLine[19],4,2)+CPLib.Left(nextLine[19],2)),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(nextLine[7]," ",""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[16],2),"?",0,0)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_sessioni",true);
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
      /* _rownum := _rownum + 1 */
      _rownum = CPLib.Round(_rownum+1,0);
      /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' sessioni ...' // Messaggio Trasferimento */
      gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" sessioni ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      }
      // Chiuse il file
      reader.close();
    } // End If
    /* _gMsgProc := _gMsgProc + 'Sono state importate '+LRTrim(Str(_rownum,10,0)) +' sessioni per la piattaforma '  + LRTrim(_codiceplat) */
    _gMsgProc = _gMsgProc+"Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" sessioni per la piattaforma "+CPLib.LRTrim(_codiceplat);
    /* If pTipo='D' */
    if (CPLib.eqr(pTipo,"D")) {
      /* gMsgProc := gMsgProc + _gMsgProc */
      gMsgProc = gMsgProc+_gMsgProc;
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } // End If
  }
  void BigliettiEmessi() throws Exception {
    CPResultSet Cursor_cgo_vlt_sessioni=null;
    CPResultSet Read_Cursor=null;
    try {
      // Crea il lettore con i parametri di separatore e testata
      FileReader freader=new FileReader(_nomefile);
      CSVParser parser = new CSVParserBuilder().withSeparator(_separator.charAt(0)).build();
      CSVReader reader = new CSVReaderBuilder(freader).withSkipLines((int)_intesta).withCSVParser(parser).build();
      /* If _tipofile='S' */
      if (CPLib.eqr(_tipofile,"S")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* _prog := Utilities.GetAutonumber("PRGVLTEMI\'"+LRTrim(_gAzienda)+"'",0,20) */
        _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTEMI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
        // * --- Insert into cgo_vlt_emessi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_emessi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000CD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000CD(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[5],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[6],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[7],1),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_emessi",true);
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
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* If Empty(LRTrim(nextLine[2])) and (Val(nextLine[3]) / 100) >= 500 */
        if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && CPLib.ge((CPLib.Val(nextLine[3])/100),500)) {
          /* _coddip := '' */
          _coddip = "";
          /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
          if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
            /* _coddip := mcANADIP.CODDIP */
            _coddip = mcANADIP.row.CODDIP;
          } // End If
          /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
          _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          // * --- Insert into cgo_telematico from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000D4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          /* _idticket := LRTrim(nextLine[0]) */
          _idticket = CPLib.LRTrim(nextLine[0]);
          /* _idsala := LRTrim(nextLine[1]) */
          _idsala = CPLib.LRTrim(nextLine[1]);
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
            mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
            /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
            mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
            /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
            mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
            /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
            mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
            /* mcVLTREP.VLTREP_AAMSVLT := nextLine[2] */
            mcVLTREP.row.VLTREP_AAMSVLT = nextLine[2];
            /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
            mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
            /* mcVLTREP.VLTREP_VALNOM := cgo_vlt_sessioni->VLTSES_OUT */
            mcVLTREP.row.VLTREP_VALNOM = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT");
            /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
            mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
            /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
            mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
            /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
            mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
            /* mcVLTREP.VLTREP_DATAEMI := ConvD(nextLine[4],1) */
            mcVLTREP.row.VLTREP_DATAEMI = ConvD(nextLine[4],1);
            /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
            mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
            /* mcVLTREP.VLTREP_RAPPORTO1 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO1 = 0;
            /* mcVLTREP.VLTREP_RAPPORTO2 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO2 = 0;
            /* mcVLTREP.VLTREP_RAPPORTO3 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO3 = 0;
            /* mcVLTREP.VLTREP_ORIGINE := 'E' */
            mcVLTREP.row.VLTREP_ORIGINE = "E";
            /* mcVLTREP.SaveRow() */
            mcVLTREP.SaveRow();
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
        } // End If
        /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' emissioni ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" emissioni ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* If _tipofile='N' */
      if (CPLib.eqr(_tipofile,"N")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* _prog := Utilities.GetAutonumber("PRGVLTEMI\'"+LRTrim(_gAzienda)+"'",0,20) */
        _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTEMI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
        /* _idticket := LRTrim(nextLine[0]) */
        _idticket = CPLib.LRTrim(nextLine[0]);
        /* _idsala := LRTrim(nextLine[1]) */
        _idsala = CPLib.LRTrim(nextLine[1]);
        // * --- Insert into cgo_vlt_emessi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_emessi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000F3(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[5],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[6],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[7],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[8],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_emessi",true);
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
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* If Empty(LRTrim(nextLine[2])) and (Val(nextLine[3]) / 100) >= 500 */
        if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && CPLib.ge((CPLib.Val(nextLine[3])/100),500)) {
          /* _coddip := '' */
          _coddip = "";
          /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
          if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
            /* _coddip := mcANADIP.CODDIP */
            _coddip = mcANADIP.row.CODDIP;
          } // End If
          /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
          _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          // * --- Insert into cgo_telematico from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000000FA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000FA(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
            mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
            /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
            mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
            /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
            mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
            /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
            mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
            /* mcVLTREP.VLTREP_AAMSVLT := nextLine[2] */
            mcVLTREP.row.VLTREP_AAMSVLT = nextLine[2];
            /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
            mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
            /* mcVLTREP.VLTREP_VALNOM := cgo_vlt_sessioni->VLTSES_OUT */
            mcVLTREP.row.VLTREP_VALNOM = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT");
            /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
            mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
            /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
            mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
            /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
            mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
            /* mcVLTREP.VLTREP_DATAEMI := ConvD(nextLine[4],1) */
            mcVLTREP.row.VLTREP_DATAEMI = ConvD(nextLine[4],1);
            /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
            mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
            /* mcVLTREP.VLTREP_RAPPORTO1 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO1 = 0;
            /* mcVLTREP.VLTREP_RAPPORTO2 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO2 = 0;
            /* mcVLTREP.VLTREP_RAPPORTO3 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO3 = 0;
            /* mcVLTREP.VLTREP_ORIGINE := 'E' */
            mcVLTREP.row.VLTREP_ORIGINE = "E";
            /* mcVLTREP.SaveRow() */
            mcVLTREP.SaveRow();
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
        } // End If
        /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' emissioni ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" emissioni ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* If _tipofile='P' */
      if (CPLib.eqr(_tipofile,"P")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* _prog := Utilities.GetAutonumber("PRGVLTEMI\'"+LRTrim(_gAzienda)+"'",0,20) */
        _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTEMI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
        // * --- Insert into cgo_vlt_emessi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_emessi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000115")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000115(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],2),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[5],2),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[6],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[7],2),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_emessi",true);
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
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* If Empty(LRTrim(nextLine[2])) and (Val(nextLine[3]) / 100) >= 500 */
        if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && CPLib.ge((CPLib.Val(nextLine[3])/100),500)) {
          /* _coddip := '' */
          _coddip = "";
          /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
          if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
            /* _coddip := mcANADIP.CODDIP */
            _coddip = mcANADIP.row.CODDIP;
          } // End If
          /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
          _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          // * --- Insert into cgo_telematico from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000011C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000011C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],2),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          /* _idticket := LRTrim(nextLine[0]) */
          _idticket = CPLib.LRTrim(nextLine[0]);
          /* _idsala := LRTrim(nextLine[1]) */
          _idsala = CPLib.LRTrim(nextLine[1]);
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
            mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
            /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
            mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
            /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
            mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
            /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
            mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
            /* mcVLTREP.VLTREP_AAMSVLT := nextLine[2] */
            mcVLTREP.row.VLTREP_AAMSVLT = nextLine[2];
            /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
            mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
            /* mcVLTREP.VLTREP_VALNOM := cgo_vlt_sessioni->VLTSES_OUT */
            mcVLTREP.row.VLTREP_VALNOM = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT");
            /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
            mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
            /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
            mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
            /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
            mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
            /* mcVLTREP.VLTREP_DATAEMI := ConvD(nextLine[4],2) */
            mcVLTREP.row.VLTREP_DATAEMI = ConvD(nextLine[4],2);
            /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
            mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
            /* mcVLTREP.VLTREP_RAPPORTO1 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO1 = 0;
            /* mcVLTREP.VLTREP_RAPPORTO2 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO2 = 0;
            /* mcVLTREP.VLTREP_RAPPORTO3 := 0 */
            mcVLTREP.row.VLTREP_RAPPORTO3 = 0;
            /* mcVLTREP.VLTREP_ORIGINE := 'E' */
            mcVLTREP.row.VLTREP_ORIGINE = "E";
            /* mcVLTREP.SaveRow() */
            mcVLTREP.SaveRow();
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
        } // End If
        /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' emissioni ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" emissioni ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* If _tipofile='I' */
      if (CPLib.eqr(_tipofile,"I")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* If Len(LRTrim(nextLine[0])) = 10 and (LRTrim(nextLine[7])="VALID" or LRTrim(nextLine[7])="REDEEMED") */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(nextLine[0])),10) && (CPLib.eqr(CPLib.LRTrim(nextLine[7]),"VALID") || CPLib.eqr(CPLib.LRTrim(nextLine[7]),"REDEEMED"))) {
          /* _prog := 0 */
          _prog = CPLib.Round(0,0);
          // * --- Read from cgo_vlt_emessi
          m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
          m_cSql = "";
          m_cSql = m_cSql+"VLTEME_TICKET_BC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"C",50,0,m_cServer),m_cServer,CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""));
          if (m_Ctx.IsSharedTemp("cgo_vlt_emessi")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTEME_IDPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _prog = CPLib.Round(Read_Cursor.GetDouble("VLTEME_IDPROG"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cgo_vlt_emessi into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _prog = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _prog=0 */
          if (CPLib.eqr(_prog,0)) {
            /* _prog := Utilities.GetAutonumber("PRGVLTEMI\'"+LRTrim(_gAzienda)+"'",0,20) */
            _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTEMI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
            /* _idticket := Strtran(LRTrim(nextLine[8])," ",'') */
            _idticket = CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ","");
            /* _idsala := LRTrim(nextLine[3]) */
            _idsala = CPLib.LRTrim(nextLine[3]);
            /* _idvlt := LRTrim(nextLine[5]) */
            _idvlt = CPLib.LRTrim(nextLine[5]);
            /* _dataemi := NullDateTime() */
            _dataemi = CPLib.NullDateTime();
            // * --- Read from cgo_vlt_sessioni
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            m_cSql = "";
            m_cSql = m_cSql+"VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"C",10,0,m_cServer),m_cServer,_codiceplat);
            m_cSql = m_cSql+" and VLTSES_TICKET_BC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"C",50,0,m_cServer),m_cServer,_idticket);
            m_cSql = m_cSql+" and VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"C",50,0,m_cServer),m_cServer,_idsala);
            m_cSql = m_cSql+" and VLTSES_IDSESSIONE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[10]),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[10]));
            if (m_Ctx.IsSharedTemp("cgo_vlt_sessioni")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTSES_DATAEMI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dataemi = Read_Cursor.GetDateTime("VLTSES_DATAEMI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_vlt_sessioni into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dataemi = CPLib.NullDateTime();
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Insert into cgo_vlt_emessi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_emessi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000142")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000142(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[3],"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[4],"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dataemi,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[10],"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_emessi",true);
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
            // * --- Write into cgo_vlt_sessioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_sessioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000143")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"VLTSES_IDTICKETOUT = "+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"C",50,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_vlt_sessioni",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"VLTSES_TICKET_BC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer),m_cServer,CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""))+"";
            m_cSql = m_cSql+" and VLTSES_IDSESSIONE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[10]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[10]))+"";
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
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
            /* If (Empty(LRTrim(nextLine[4])) or Left(LRTrim(nextLine[4]),1)='P') and (Val(nextLine[6]) / 100) >= 500  */
            if ((CPLib.Empty(CPLib.LRTrim(nextLine[4])) || CPLib.eqr(CPLib.Left(CPLib.LRTrim(nextLine[4]),1),"P")) && CPLib.ge((CPLib.Val(nextLine[6])/100),500)) {
              /* _coddip := '' */
              _coddip = "";
              /* If mcANADIP.GoToKey(LRTrim(nextLine[3])) */
              if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[3]))) {
                /* _coddip := mcANADIP.CODDIP */
                _coddip = mcANADIP.row.CODDIP;
              } // End If
              /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
              _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
              // * --- Insert into cgo_telematico from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_telematico");
              m_cPhName = m_Ctx.GetPhName("cgo_telematico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000014A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000014A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataemi,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
              // * --- Select from cgo_vlt_sessioni
              m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
              if (Cursor_cgo_vlt_sessioni!=null)
                Cursor_cgo_vlt_sessioni.Close();
              Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_TICKET_BC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
                /* mcVLTREP.AppendWithKey(LRTrim(_idticket)) */
                mcVLTREP.AppendWithKey(CPLib.LRTrim(_idticket));
                /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[3]) */
                mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[3]);
                /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                /* mcVLTREP.VLTREP_AAMSVLT := nextLine[4] */
                mcVLTREP.row.VLTREP_AAMSVLT = nextLine[4];
                /* mcVLTREP.VLTREP_TICKET_BC := LRTrim(nextLine[9]) */
                mcVLTREP.row.VLTREP_TICKET_BC = CPLib.LRTrim(nextLine[9]);
                /* mcVLTREP.VLTREP_IDTICKET := Strtran(LRTrim(nextLine[8])," ",'') */
                mcVLTREP.row.VLTREP_IDTICKET = CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ","");
                /* mcVLTREP.VLTREP_VALNOM := cgo_vlt_sessioni->VLTSES_OUT */
                mcVLTREP.row.VLTREP_VALNOM = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT");
                /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                /* mcVLTREP.VLTREP_RAPPORTO1 := 0 */
                mcVLTREP.row.VLTREP_RAPPORTO1 = 0;
                /* mcVLTREP.VLTREP_RAPPORTO2 := 0 */
                mcVLTREP.row.VLTREP_RAPPORTO2 = 0;
                /* mcVLTREP.VLTREP_RAPPORTO3 := 0 */
                mcVLTREP.row.VLTREP_RAPPORTO3 = 0;
                /* mcVLTREP.VLTREP_ORIGINE := 'E' */
                mcVLTREP.row.VLTREP_ORIGINE = "E";
                /* mcVLTREP.SaveRow() */
                mcVLTREP.SaveRow();
                Cursor_cgo_vlt_sessioni.Next();
              }
              m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
              Cursor_cgo_vlt_sessioni.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* _gMsgProc := _gMsgProc + 'Sono state importati '+LRTrim(Str(_rownum,10,0)) +' biglietti emessi per la piattaforma '  + LRTrim(_codiceplat) */
      _gMsgProc = _gMsgProc+"Sono state importati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" biglietti emessi per la piattaforma "+CPLib.LRTrim(_codiceplat);
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgProc := gMsgProc + _gMsgProc */
        gMsgProc = gMsgProc+_gMsgProc;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_cgo_vlt_sessioni!=null)
          Cursor_cgo_vlt_sessioni.Close();
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
  void BigliettiConvalidati() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cgo_vlt_sessioni=null;
    try {
      // Crea il lettore con i parametri di separatore e testata
      FileReader freader=new FileReader(_nomefile);
      CSVParser parser = new CSVParserBuilder().withSeparator(_separator.charAt(0)).build();
      CSVReader reader = new CSVReaderBuilder(freader).withSkipLines((int)_intesta).withCSVParser(parser).build();
      /* If _tipofile='S' */
      if (CPLib.eqr(_tipofile,"S")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* _prog := Utilities.GetAutonumber("PRGVLTCVD\'"+LRTrim(_gAzienda)+"'",0,20) */
        _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTCVD\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
        /* _idticket := LRTrim(nextLine[0]) */
        _idticket = CPLib.LRTrim(nextLine[0]);
        /* _idsala := LRTrim(nextLine[1]) */
        _idsala = CPLib.LRTrim(nextLine[1]);
        /* _idvlt := LRTrim(nextLine[2]) */
        _idvlt = CPLib.LRTrim(nextLine[2]);
        /* _nomcon := Val(nextLine[3])/100 */
        _nomcon = CPLib.Round(CPLib.Val(nextLine[3])/100,2);
        /* _dataemi := NullDateTime() */
        _dataemi = CPLib.NullDateTime();
        /* _vltemi := '' */
        _vltemi = "";
        /* _nomemi := 0 */
        _nomemi = CPLib.Round(0,2);
        /* _nomout := 0 */
        _nomout = CPLib.Round(0,2);
        // * --- Read from cgo_vlt_emessi
        m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
        m_cSql = "";
        m_cSql = m_cSql+"VLTEME_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"C",10,0,m_cServer),m_cServer,_codiceplat);
        m_cSql = m_cSql+" and VLTEME_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"C",50,0,m_cServer),m_cServer,_idticket);
        m_cSql = m_cSql+" and VLTEME_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"C",50,0,m_cServer),m_cServer,_idsala);
        if (m_Ctx.IsSharedTemp("cgo_vlt_emessi")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTEME_DATEMI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_VLT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_IMPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _dataemi = Read_Cursor.GetDateTime("VLTEME_DATEMI");
          _vltemi = Read_Cursor.GetString("VLTEME_VLT");
          _nomemi = CPLib.Round(Read_Cursor.GetDouble("VLTEME_IMPORTO"),2);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_vlt_emessi into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _dataemi = CPLib.NullDateTime();
          _vltemi = "";
          _nomemi = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into cgo_vlt_convalidati from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_vlt_convalidati");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_convalidati");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_convalidati",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000172")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000172(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[5],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[6],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[7],1),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_convalidati",true);
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
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* If Empty(LRTrim(nextLine[2])) and (Val(nextLine[3]) / 100) >= 500 */
        if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && CPLib.ge((CPLib.Val(nextLine[3])/100),500)) {
          /* _coddip := '' */
          _coddip = "";
          /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
          if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
            /* _coddip := mcANADIP.CODDIP */
            _coddip = mcANADIP.row.CODDIP;
          } // End If
          /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
          _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          // * --- Insert into cgo_telematico from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000179")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000179(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          /* If mcVLTREP.GoToKey(nextLine[0]) */
          if (mcVLTREP.GoToKey(nextLine[0])) {
            /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
            mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
            /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
            mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
            /* mcVLTREP.SaveRow() */
            mcVLTREP.SaveRow();
          } else { // Else
            // * --- Select from cgo_vlt_sessioni
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            if (Cursor_cgo_vlt_sessioni!=null)
              Cursor_cgo_vlt_sessioni.Close();
            Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
              /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
              _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
              /* If _nomses <> 0 */
              if (CPLib.ne(_nomses,0)) {
                /* _nomout := _nomses */
                _nomout = CPLib.Round(_nomses,2);
                /* ElseIf _nomses=0 and _nomemi<>0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
                /* _nomout := _nomemi */
                _nomout = CPLib.Round(_nomemi,2);
                /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
                /* _nomout := _nomcon */
                _nomout = CPLib.Round(_nomcon,2);
              } // End If
              /* If _nomout <> 0 */
              if (CPLib.ne(_nomout,0)) {
                /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
                mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
                /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                /* mcVLTREP.VLTREP_VALNOM := _nomout */
                mcVLTREP.row.VLTREP_VALNOM = _nomout;
                /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                mcVLTREP.row.VLTREP_ORIGINE = "C";
                /* mcVLTREP.SaveRow() */
                mcVLTREP.SaveRow();
              } else { // Else
                /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
                _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                // * --- Insert into cgo_vlt_scarti from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
                m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000195")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000195(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
              } // End If
              Cursor_cgo_vlt_sessioni.Next();
            }
            m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
            Cursor_cgo_vlt_sessioni.Close();
            // * --- End Select
          } // End If
          /* ElseIf Empty(LRTrim(nextLine[2])) and ((Val(nextLine[3]) / 100) >= 400 and (Val(nextLine[3]) / 100) < 500) */
        } else if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && (CPLib.ge((CPLib.Val(nextLine[3])/100),400) && CPLib.lt((CPLib.Val(nextLine[3])/100),500))) {
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
            _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
            /* If _nomses <> 0 */
            if (CPLib.ne(_nomses,0)) {
              /* _nomout := _nomses */
              _nomout = CPLib.Round(_nomses,2);
              /* ElseIf _nomses=0 and _nomemi<>0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
              /* _nomout := _nomemi */
              _nomout = CPLib.Round(_nomemi,2);
              /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
              /* _nomout := _nomcon */
              _nomout = CPLib.Round(_nomcon,2);
            } // End If
            /* If _nomout <> 0 */
            if (CPLib.ne(_nomout,0)) {
              /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
              _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
              /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
              _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
              /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
              _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
              /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
              if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                /* _coddip := '' */
                _coddip = "";
                /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
                if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
                  /* _coddip := mcANADIP.CODDIP */
                  _coddip = mcANADIP.row.CODDIP;
                } // End If
                /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
                _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
                // * --- Insert into cgo_telematico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000001A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001A5(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
                /* If mcVLTREP.GoToKey(nextLine[0]) */
                if (mcVLTREP.GoToKey(nextLine[0])) {
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
                  mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } // End If
              } // End If
            } else { // Else
              /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
              _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
              // * --- Insert into cgo_vlt_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000001C0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001C0(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
            } // End If
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
          /* ElseIf Empty(LRTrim(nextLine[2])) and ((Val(nextLine[3]) / 100) >= 100 and (Val(nextLine[3]) / 100) < 400) */
        } else if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && (CPLib.ge((CPLib.Val(nextLine[3])/100),100) && CPLib.lt((CPLib.Val(nextLine[3])/100),400))) {
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
            _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
            /* If _nomses <> 0 */
            if (CPLib.ne(_nomses,0)) {
              /* _nomout := _nomses */
              _nomout = CPLib.Round(_nomses,2);
              /* ElseIf _nomses=0 and _nomemi<>0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
              /* _nomout := _nomemi */
              _nomout = CPLib.Round(_nomemi,2);
              /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
              /* _nomout := _nomcon */
              _nomout = CPLib.Round(_nomcon,2);
            } // End If
            /* If _nomout <> 0 */
            if (CPLib.ne(_nomout,0)) {
              /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
              _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
              /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
              _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
              /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
              _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
              /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
              if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                /* If mcVLTREP.GoToKey(nextLine[0]) */
                if (mcVLTREP.GoToKey(nextLine[0])) {
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
                  mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
                  /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } // End If
              } // End If
            } else { // Else
              /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
              _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
              // * --- Insert into cgo_vlt_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000001E6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001E6(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
            } // End If
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
        } // End If
        /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' convalide ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" convalide ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* If _tipofile='N' */
      if (CPLib.eqr(_tipofile,"N")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* _prog := Utilities.GetAutonumber("PRGVLTCVD\'"+LRTrim(_gAzienda)+"'",0,20) */
        _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTCVD\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
        /* _idticket := LRTrim(nextLine[0]) */
        _idticket = CPLib.LRTrim(nextLine[0]);
        /* _idsala := LRTrim(nextLine[1]) */
        _idsala = CPLib.LRTrim(nextLine[1]);
        /* _idvlt := LRTrim(nextLine[2]) */
        _idvlt = CPLib.LRTrim(nextLine[2]);
        /* _dataemi := NullDateTime() */
        _dataemi = CPLib.NullDateTime();
        /* _nomcon := Val(nextLine[3])/100 */
        _nomcon = CPLib.Round(CPLib.Val(nextLine[3])/100,2);
        /* _nomemi := 0 */
        _nomemi = CPLib.Round(0,2);
        /* _nomout := 0 */
        _nomout = CPLib.Round(0,2);
        /* _vltemi := '' */
        _vltemi = "";
        // * --- Read from cgo_vlt_emessi
        m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
        m_cSql = "";
        m_cSql = m_cSql+"VLTEME_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"C",10,0,m_cServer),m_cServer,_codiceplat);
        m_cSql = m_cSql+" and VLTEME_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"C",50,0,m_cServer),m_cServer,_idticket);
        m_cSql = m_cSql+" and VLTEME_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"C",50,0,m_cServer),m_cServer,_idsala);
        if (m_Ctx.IsSharedTemp("cgo_vlt_emessi")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTEME_DATEMI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_VLT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_IMPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _dataemi = Read_Cursor.GetDateTime("VLTEME_DATEMI");
          _vltemi = Read_Cursor.GetString("VLTEME_VLT");
          _nomemi = CPLib.Round(Read_Cursor.GetDouble("VLTEME_IMPORTO"),2);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_vlt_emessi into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _dataemi = CPLib.NullDateTime();
          _vltemi = "";
          _nomemi = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into cgo_vlt_convalidati from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_vlt_convalidati");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_convalidati");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_convalidati",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000001F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000001F7(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[5],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[6],1),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_convalidati",true);
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
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* If Empty(LRTrim(nextLine[2])) and (Val(nextLine[3]) / 100) >= 500 */
        if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && CPLib.ge((CPLib.Val(nextLine[3])/100),500)) {
          /* _coddip := '' */
          _coddip = "";
          /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
          if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
            /* _coddip := mcANADIP.CODDIP */
            _coddip = mcANADIP.row.CODDIP;
          } // End If
          /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
          _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          // * --- Insert into cgo_telematico from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000001FE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001FE(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          /* If mcVLTREP.GoToKey(nextLine[0]) */
          if (mcVLTREP.GoToKey(nextLine[0])) {
            /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
            mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
            /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
            mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
            /* mcVLTREP.SaveRow() */
            mcVLTREP.SaveRow();
          } else { // Else
            // * --- Select from cgo_vlt_sessioni
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            if (Cursor_cgo_vlt_sessioni!=null)
              Cursor_cgo_vlt_sessioni.Close();
            Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
              /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
              _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
              /* If _nomses <> 0 */
              if (CPLib.ne(_nomses,0)) {
                /* _nomout := _nomses */
                _nomout = CPLib.Round(_nomses,2);
                /* ElseIf _nomses=0 and _nomemi<>0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
                /* _nomout := _nomemi */
                _nomout = CPLib.Round(_nomemi,2);
                /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
                /* _nomout := _nomcon */
                _nomout = CPLib.Round(_nomcon,2);
              } // End If
              /* If _nomout <> 0 */
              if (CPLib.ne(_nomout,0)) {
                /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
                mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
                /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                /* mcVLTREP.VLTREP_VALNOM := _nomout */
                mcVLTREP.row.VLTREP_VALNOM = _nomout;
                /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                mcVLTREP.row.VLTREP_ORIGINE = "C";
                /* mcVLTREP.SaveRow() */
                mcVLTREP.SaveRow();
              } else { // Else
                /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
                _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                // * --- Insert into cgo_vlt_scarti from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
                m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000021A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000021A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
              } // End If
              Cursor_cgo_vlt_sessioni.Next();
            }
            m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
            Cursor_cgo_vlt_sessioni.Close();
            // * --- End Select
          } // End If
          /* ElseIf Empty(LRTrim(nextLine[2])) and ((Val(nextLine[3]) / 100) >= 400 and (Val(nextLine[3]) / 100) < 500) */
        } else if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && (CPLib.ge((CPLib.Val(nextLine[3])/100),400) && CPLib.lt((CPLib.Val(nextLine[3])/100),500))) {
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
            _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
            /* If _nomses <> 0 */
            if (CPLib.ne(_nomses,0)) {
              /* _nomout := _nomses */
              _nomout = CPLib.Round(_nomses,2);
              /* ElseIf _nomses=0 and _nomemi<>0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
              /* _nomout := _nomemi */
              _nomout = CPLib.Round(_nomemi,2);
              /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
              /* _nomout := _nomcon */
              _nomout = CPLib.Round(_nomcon,2);
            } // End If
            /* If _nomout <> 0 */
            if (CPLib.ne(_nomout,0)) {
              /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
              _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
              /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
              _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
              /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
              _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
              /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
              if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                /* _coddip := '' */
                _coddip = "";
                /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
                if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
                  /* _coddip := mcANADIP.CODDIP */
                  _coddip = mcANADIP.row.CODDIP;
                } // End If
                /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
                _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
                // * --- Insert into cgo_telematico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000022A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000022A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],1),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
                /* If mcVLTREP.GoToKey(nextLine[0]) */
                if (mcVLTREP.GoToKey(nextLine[0])) {
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
                  mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } // End If
              } // End If
            } else { // Else
              /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
              _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
              // * --- Insert into cgo_vlt_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000245")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000245(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
            } // End If
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
          /* ElseIf Empty(LRTrim(nextLine[2])) and ((Val(nextLine[3]) / 100) >= 100 and (Val(nextLine[3]) / 100) < 400) */
        } else if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && (CPLib.ge((CPLib.Val(nextLine[3])/100),100) && CPLib.lt((CPLib.Val(nextLine[3])/100),400))) {
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
            _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
            /* If _nomses <> 0 */
            if (CPLib.ne(_nomses,0)) {
              /* _nomout := _nomses */
              _nomout = CPLib.Round(_nomses,2);
              /* ElseIf _nomses=0 and _nomemi<>0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
              /* _nomout := _nomemi */
              _nomout = CPLib.Round(_nomemi,2);
              /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
              /* _nomout := _nomcon */
              _nomout = CPLib.Round(_nomcon,2);
            } // End If
            /* If _nomout <> 0 */
            if (CPLib.ne(_nomout,0)) {
              /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
              _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
              /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
              _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
              /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
              _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
              /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
              if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                /* If mcVLTREP.GoToKey(nextLine[0]) */
                if (mcVLTREP.GoToKey(nextLine[0])) {
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := iif(At('snai',_nomefile) <> 0,'SNAI','COGETECH') */
                  mcVLTREP.row.VLTREP_CODCONC = (CPLib.ne(CPLib.At("snai",_nomefile),0)?"SNAI":"COGETECH");
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],1);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } // End If
              } // End If
            } else { // Else
              /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
              _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
              // * --- Insert into cgo_vlt_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000026B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000026B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
            } // End If
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
        } // End If
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' convalide ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" convalide ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* If _tipofile='P' */
      if (CPLib.eqr(_tipofile,"P")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* _prog := Utilities.GetAutonumber("PRGVLTCVD\'"+LRTrim(_gAzienda)+"'",0,20) */
        _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTCVD\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
        /* _idticket := LRTrim(nextLine[0]) */
        _idticket = CPLib.LRTrim(nextLine[0]);
        /* _idsala := LRTrim(nextLine[1]) */
        _idsala = CPLib.LRTrim(nextLine[1]);
        /* _idvlt := LRTrim(nextLine[2]) */
        _idvlt = CPLib.LRTrim(nextLine[2]);
        /* _dataemi := NullDateTime() */
        _dataemi = CPLib.NullDateTime();
        /* _vltemi := '' */
        _vltemi = "";
        /* _nomcon := Val(nextLine[3]) / 100 */
        _nomcon = CPLib.Round(CPLib.Val(nextLine[3])/100,2);
        /* _nomemi := 0 */
        _nomemi = CPLib.Round(0,2);
        /* _nomout := 0 */
        _nomout = CPLib.Round(0,2);
        // * --- Read from cgo_vlt_emessi
        m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
        m_cSql = "";
        m_cSql = m_cSql+"VLTEME_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"C",10,0,m_cServer),m_cServer,_codiceplat);
        m_cSql = m_cSql+" and VLTEME_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"C",50,0,m_cServer),m_cServer,_idticket);
        m_cSql = m_cSql+" and VLTEME_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"C",50,0,m_cServer),m_cServer,_idsala);
        if (m_Ctx.IsSharedTemp("cgo_vlt_emessi")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTEME_DATEMI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_VLT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_IMPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _dataemi = Read_Cursor.GetDateTime("VLTEME_DATEMI");
          _vltemi = Read_Cursor.GetString("VLTEME_VLT");
          _nomemi = CPLib.Round(Read_Cursor.GetDouble("VLTEME_IMPORTO"),2);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_vlt_emessi into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _dataemi = CPLib.NullDateTime();
          _vltemi = "";
          _nomemi = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Insert into cgo_vlt_convalidati from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_vlt_convalidati");
        m_cPhName = m_Ctx.GetPhName("cgo_vlt_convalidati");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_convalidati",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000027D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000027D(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[1],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[2],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],2),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[5],"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[6],2),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_convalidati",true);
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
        /* _rownum := _rownum + 1 */
        _rownum = CPLib.Round(_rownum+1,0);
        /* If Empty(LRTrim(nextLine[2])) and (Val(nextLine[3]) / 100) >= 500 */
        if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && CPLib.ge((CPLib.Val(nextLine[3])/100),500)) {
          /* _coddip := '' */
          _coddip = "";
          /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
          if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
            /* _coddip := mcANADIP.CODDIP */
            _coddip = mcANADIP.row.CODDIP;
          } // End If
          /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
          _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
          // * --- Insert into cgo_telematico from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_telematico");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000284")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000284(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],2),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          /* If mcVLTREP.GoToKey(nextLine[0]) */
          if (mcVLTREP.GoToKey(nextLine[0])) {
            /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
            mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
            /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],2) */
            mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],2);
            /* mcVLTREP.SaveRow() */
            mcVLTREP.SaveRow();
          } else { // Else
            // * --- Select from cgo_vlt_sessioni
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            if (Cursor_cgo_vlt_sessioni!=null)
              Cursor_cgo_vlt_sessioni.Close();
            Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
              /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
              _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
              /* If _nomses <> 0 */
              if (CPLib.ne(_nomses,0)) {
                /* _nomout := _nomses */
                _nomout = CPLib.Round(_nomses,2);
                /* ElseIf _nomses=0 and _nomemi<>0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
                /* _nomout := _nomemi */
                _nomout = CPLib.Round(_nomemi,2);
                /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
                /* _nomout := _nomcon */
                _nomout = CPLib.Round(_nomcon,2);
              } // End If
              /* If _nomout <> 0 */
              if (CPLib.ne(_nomout,0)) {
                /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                /* mcVLTREP.VLTREP_VALNOM := _nomout */
                mcVLTREP.row.VLTREP_VALNOM = _nomout;
                /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],2) */
                mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],2);
                /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                mcVLTREP.row.VLTREP_ORIGINE = "C";
                /* mcVLTREP.SaveRow() */
                mcVLTREP.SaveRow();
              } else { // Else
                /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
                _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                // * --- Insert into cgo_vlt_scarti from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
                m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000002A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002A0(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
              } // End If
              Cursor_cgo_vlt_sessioni.Next();
            }
            m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
            Cursor_cgo_vlt_sessioni.Close();
            // * --- End Select
          } // End If
          /* ElseIf Empty(LRTrim(nextLine[2])) and ((Val(nextLine[3]) / 100) >= 400 and (Val(nextLine[3]) / 100) < 500) */
        } else if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && (CPLib.ge((CPLib.Val(nextLine[3])/100),400) && CPLib.lt((CPLib.Val(nextLine[3])/100),500))) {
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
            _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
            /* If _nomses <> 0 */
            if (CPLib.ne(_nomses,0)) {
              /* _nomout := _nomses */
              _nomout = CPLib.Round(_nomses,2);
              /* ElseIf _nomses=0 and _nomemi<>0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
              /* _nomout := _nomemi */
              _nomout = CPLib.Round(_nomemi,2);
              /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
              /* _nomout := _nomcon */
              _nomout = CPLib.Round(_nomcon,2);
            } // End If
            /* If _nomout <> 0 */
            if (CPLib.ne(_nomout,0)) {
              /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
              _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
              /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
              _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
              /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
              _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
              /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
              _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
              /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
              if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                /* _coddip := '' */
                _coddip = "";
                /* If mcANADIP.GoToKey(LRTrim(nextLine[1])) */
                if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[1]))) {
                  /* _coddip := mcANADIP.CODDIP */
                  _coddip = mcANADIP.row.CODDIP;
                } // End If
                /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
                _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
                // * --- Insert into cgo_telematico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_telematico");
                m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000002B1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002B1(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3])/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[4],2),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[0],"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
                /* If mcVLTREP.GoToKey(nextLine[0]) */
                if (mcVLTREP.GoToKey(nextLine[0])) {
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],2) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],2);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                  mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],2) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],2);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } // End If
              } // End If
            } else { // Else
              /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
              _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
              // * --- Insert into cgo_vlt_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000002CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002CC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
            } // End If
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
          /* ElseIf Empty(LRTrim(nextLine[2])) and ((Val(nextLine[3]) / 100) >= 100 and (Val(nextLine[3]) / 100) < 400) */
        } else if (CPLib.Empty(CPLib.LRTrim(nextLine[2])) && (CPLib.ge((CPLib.Val(nextLine[3])/100),100) && CPLib.lt((CPLib.Val(nextLine[3])/100),400))) {
          // * --- Select from cgo_vlt_sessioni
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          if (Cursor_cgo_vlt_sessioni!=null)
            Cursor_cgo_vlt_sessioni.Close();
          Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
            /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
            _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
            /* If _nomses <> 0 */
            if (CPLib.ne(_nomses,0)) {
              /* _nomout := _nomses */
              _nomout = CPLib.Round(_nomses,2);
              /* ElseIf _nomses=0 and _nomemi<>0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
              /* _nomout := _nomemi */
              _nomout = CPLib.Round(_nomemi,2);
              /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
            } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
              /* _nomout := _nomcon */
              _nomout = CPLib.Round(_nomcon,2);
            } // End If
            /* If _nomout <> 0 */
            if (CPLib.ne(_nomout,0)) {
              /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
              _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
              /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
              _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
              /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
              _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
              /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
              if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                /* If mcVLTREP.GoToKey(nextLine[0]) */
                if (mcVLTREP.GoToKey(nextLine[0])) {
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],2) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],2);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* mcVLTREP.AppendWithKey(LRTrim(nextLine[0])) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(nextLine[0]));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[1]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[1]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                  mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_IDTICKET := LRTrim(nextLine[0]) */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.LRTrim(nextLine[0]);
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[4],2) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[4],2);
                  /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                  mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                  /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                  mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                  /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                  mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } // End If
              } // End If
            } else { // Else
              /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
              _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
              // * --- Insert into cgo_vlt_scarti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"000002F2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002F2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
            } // End If
            Cursor_cgo_vlt_sessioni.Next();
          }
          m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
          Cursor_cgo_vlt_sessioni.Close();
          // * --- End Select
        } // End If
        /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' convalide ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" convalide ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* If _tipofile='I' */
      if (CPLib.eqr(_tipofile,"I")) {
        /* _rownum := 0 */
        _rownum = CPLib.Round(0,0);
        // Legge il csv e scrive la tabella
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        /* If Len(LRTrim(nextLine[0])) = 10 and LRTrim(nextLine[7])="REDEEMED" */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(nextLine[0])),10) && CPLib.eqr(CPLib.LRTrim(nextLine[7]),"REDEEMED")) {
          /* _prog := Utilities.GetAutonumber("PRGVLTCVD\'"+LRTrim(_gAzienda)+"'",0,20) */
          _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTCVD\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
          /* _idticket := Strtran(LRTrim(nextLine[8])," ",'') */
          _idticket = CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ","");
          /* _idsala := LRTrim(nextLine[3]) */
          _idsala = CPLib.LRTrim(nextLine[3]);
          /* _idvlt := LRTrim(nextLine[5]) */
          _idvlt = CPLib.LRTrim(nextLine[5]);
          /* _dataemi := NullDateTime() */
          _dataemi = CPLib.NullDateTime();
          /* _nomcon := Val(nextLine[6]) / 100 */
          _nomcon = CPLib.Round(CPLib.Val(nextLine[6])/100,2);
          /* _nomemi := 0 */
          _nomemi = CPLib.Round(0,2);
          /* _nomout := 0 */
          _nomout = CPLib.Round(0,2);
          // * --- Read from cgo_vlt_emessi
          m_cServer = m_Ctx.GetServer("cgo_vlt_emessi");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_emessi");
          m_cSql = "";
          m_cSql = m_cSql+"VLTEME_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"C",10,0,m_cServer),m_cServer,_codiceplat);
          m_cSql = m_cSql+" and VLTEME_TICKET_BC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"C",50,0,m_cServer),m_cServer,_idticket);
          m_cSql = m_cSql+" and VLTEME_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"C",50,0,m_cServer),m_cServer,_idsala);
          if (m_Ctx.IsSharedTemp("cgo_vlt_emessi")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("VLTEME_DATEMI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_VLT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VLTEME_IMPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _dataemi = Read_Cursor.GetDateTime("VLTEME_DATEMI");
            _vltemi = Read_Cursor.GetString("VLTEME_VLT");
            _nomemi = CPLib.Round(Read_Cursor.GetDouble("VLTEME_IMPORTO"),2);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cgo_vlt_emessi into routine arrt_cgo_import_vlt returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _dataemi = CPLib.NullDateTime();
            _vltemi = "";
            _nomemi = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into cgo_vlt_convalidati from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_vlt_convalidati");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_convalidati");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_convalidati",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000303")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000303(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[3],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[5],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(ConvDT(nextLine[20],1),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[10],"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_convalidati",true);
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
          // * --- Write into cgo_vlt_sessioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
          m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_sessioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000304")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"VLTSES_IDTICKETOUT = "+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_vlt_sessioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"VLTSES_TICKET_BC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer),m_cServer,CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""))+"";
          m_cSql = m_cSql+" and VLTSES_IDSESSIONE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[10]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[10]))+"";
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
          /* _rownum := _rownum + 1 */
          _rownum = CPLib.Round(_rownum+1,0);
          /* If (Empty(LRTrim(nextLine[5])) or Left(LRTrim(nextLine[5]),1)='P') and (Val(nextLine[6]) / 100) >= 500 */
          if ((CPLib.Empty(CPLib.LRTrim(nextLine[5])) || CPLib.eqr(CPLib.Left(CPLib.LRTrim(nextLine[5]),1),"P")) && CPLib.ge((CPLib.Val(nextLine[6])/100),500)) {
            /* _coddip := '' */
            _coddip = "";
            /* If mcANADIP.GoToKey(LRTrim(nextLine[3])) */
            if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[3]))) {
              /* _coddip := mcANADIP.CODDIP */
              _coddip = mcANADIP.row.CODDIP;
            } // End If
            /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
            _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
            // * --- Insert into cgo_telematico from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000030B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000030B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(ConvD(nextLine[20],1),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
            /* If mcVLTREP.GoToKey(_idticket) */
            if (mcVLTREP.GoToKey(_idticket)) {
              /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
              mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
              /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[20],1) */
              mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[20],1);
              /* mcVLTREP.SaveRow() */
              mcVLTREP.SaveRow();
            } else { // Else
              // * --- Select from cgo_vlt_sessioni
              m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
              m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
              if (Cursor_cgo_vlt_sessioni!=null)
                Cursor_cgo_vlt_sessioni.Close();
              Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
                /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
                _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
                /* If _nomses <> 0 */
                if (CPLib.ne(_nomses,0)) {
                  /* _nomout := _nomses */
                  _nomout = CPLib.Round(_nomses,2);
                  /* ElseIf _nomses=0 and _nomemi<>0 */
                } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
                  /* _nomout := _nomemi */
                  _nomout = CPLib.Round(_nomemi,2);
                  /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
                } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
                  /* _nomout := _nomcon */
                  _nomout = CPLib.Round(_nomcon,2);
                } // End If
                /* If _nomout <> 0 */
                if (CPLib.ne(_nomout,0)) {
                  /* mcVLTREP.AppendWithKey(LRTrim(_idticket)) */
                  mcVLTREP.AppendWithKey(CPLib.LRTrim(_idticket));
                  /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[3]) */
                  mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[3]);
                  /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                  mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                  /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                  mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                  /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                  mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                  /* mcVLTREP.VLTREP_IDTICKET := Strtran(LRTrim(nextLine[8])," ",'') */
                  mcVLTREP.row.VLTREP_IDTICKET = CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ","");
                  /* mcVLTREP.VLTREP_VALNOM := _nomout */
                  mcVLTREP.row.VLTREP_VALNOM = _nomout;
                  /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                  mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                  /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                  mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                  /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                  mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                  /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                  mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                  /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[20],1) */
                  mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[20],1);
                  /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                  mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                  /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                  mcVLTREP.row.VLTREP_ORIGINE = "C";
                  /* mcVLTREP.SaveRow() */
                  mcVLTREP.SaveRow();
                } else { // Else
                  /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
                  _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                  // * --- Insert into cgo_vlt_scarti from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
                  m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000327")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000327(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
                } // End If
                Cursor_cgo_vlt_sessioni.Next();
              }
              m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
              Cursor_cgo_vlt_sessioni.Close();
              // * --- End Select
            } // End If
            /* ElseIf (Empty(LRTrim(nextLine[5])) or Left(LRTrim(nextLine[5]),1)='P') and ((Val(nextLine[6]) / 100) >= 400 and (Val(nextLine[6]) / 100) < 500) */
          } else if ((CPLib.Empty(CPLib.LRTrim(nextLine[5])) || CPLib.eqr(CPLib.Left(CPLib.LRTrim(nextLine[5]),1),"P")) && (CPLib.ge((CPLib.Val(nextLine[6])/100),400) && CPLib.lt((CPLib.Val(nextLine[6])/100),500))) {
            // * --- Select from cgo_vlt_sessioni
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            if (Cursor_cgo_vlt_sessioni!=null)
              Cursor_cgo_vlt_sessioni.Close();
            Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
              /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
              _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
              /* If _nomses <> 0 */
              if (CPLib.ne(_nomses,0)) {
                /* _nomout := _nomses */
                _nomout = CPLib.Round(_nomses,2);
                /* ElseIf _nomses=0 and _nomemi<>0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
                /* _nomout := _nomemi */
                _nomout = CPLib.Round(_nomemi,2);
                /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
                /* _nomout := _nomcon */
                _nomout = CPLib.Round(_nomcon,2);
              } // End If
              /* If _nomout <> 0 */
              if (CPLib.ne(_nomout,0)) {
                /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
                _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
                /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
                _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
                /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
                _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
                /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
                if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                  /* _coddip := '' */
                  _coddip = "";
                  /* If mcANADIP.GoToKey(LRTrim(nextLine[3])) */
                  if (mcANADIP.GoToKey(CPLib.LRTrim(nextLine[3]))) {
                    /* _coddip := mcANADIP.CODDIP */
                    _coddip = mcANADIP.row.CODDIP;
                  } // End If
                  /* _prgtele := Utilities.GetAutonumber("PRGTELEMATICO\'"+LRTrim(_gAzienda)+"'","",15) */
                  _prgtele = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTELEMATICO\\'"+CPLib.LRTrim(_gAzienda)+"'","",15);
                  // * --- Insert into cgo_telematico from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_telematico");
                  m_cPhName = m_Ctx.GetPhName("cgo_telematico");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000337")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000337(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL("V"+CPLib.Right(CPLib.LRTrim(_prgtele),14),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[6])/100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(ConvD(nextLine[20],1),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("VLT","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_platcod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
                  /* If mcVLTREP.GoToKey(_idticket) */
                  if (mcVLTREP.GoToKey(_idticket)) {
                    /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                    mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                    /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[20],1) */
                    mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[20],1);
                    /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                    mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                    /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                    mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                    /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                    mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                    /* mcVLTREP.SaveRow() */
                    mcVLTREP.SaveRow();
                  } else { // Else
                    // * --- Select from cgo_vlt_sessioni
                    m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
                    m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
                    if (Cursor_cgo_vlt_sessioni!=null)
                      Cursor_cgo_vlt_sessioni.Close();
                    Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
                      /* mcVLTREP.AppendWithKey(LRTrim(_idticket)) */
                      mcVLTREP.AppendWithKey(CPLib.LRTrim(_idticket));
                      /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[3]) */
                      mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[3]);
                      /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                      mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                      /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                      mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                      /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                      mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                      /* mcVLTREP.VLTREP_IDTICKET := Strtran(LRTrim(nextLine[8])," ",'') */
                      mcVLTREP.row.VLTREP_IDTICKET = CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ","");
                      /* mcVLTREP.VLTREP_VALNOM := _nomout */
                      mcVLTREP.row.VLTREP_VALNOM = _nomout;
                      /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                      mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                      /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                      mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                      /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                      mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                      /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                      mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                      /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[20],1) */
                      mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[20],1);
                      /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                      mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                      /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                      mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                      /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                      mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                      /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                      mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                      /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                      mcVLTREP.row.VLTREP_ORIGINE = "C";
                      /* mcVLTREP.SaveRow() */
                      mcVLTREP.SaveRow();
                      Cursor_cgo_vlt_sessioni.Next();
                    }
                    m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
                    Cursor_cgo_vlt_sessioni.Close();
                    // * --- End Select
                  } // End If
                } // End If
              } else { // Else
                /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
                _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                // * --- Insert into cgo_vlt_scarti from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
                m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"00000353")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000353(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
              } // End If
              Cursor_cgo_vlt_sessioni.Next();
            }
            m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
            Cursor_cgo_vlt_sessioni.Close();
            // * --- End Select
            /* ElseIf (Empty(LRTrim(nextLine[5])) or Left(LRTrim(nextLine[5]),1)='P') and ((Val(nextLine[6]) / 100) >= 100 and (Val(nextLine[6]) / 100) < 400) */
          } else if ((CPLib.Empty(CPLib.LRTrim(nextLine[5])) || CPLib.eqr(CPLib.Left(CPLib.LRTrim(nextLine[5]),1),"P")) && (CPLib.ge((CPLib.Val(nextLine[6])/100),100) && CPLib.lt((CPLib.Val(nextLine[6])/100),400))) {
            // * --- Select from cgo_vlt_sessioni
            m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
            m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
            if (Cursor_cgo_vlt_sessioni!=null)
              Cursor_cgo_vlt_sessioni.Close();
            Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
              /* _nomses := cgo_vlt_sessioni->VLTSES_OUT */
              _nomses = CPLib.Round(Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_OUT"),2);
              /* If _nomses <> 0 */
              if (CPLib.ne(_nomses,0)) {
                /* _nomout := _nomses */
                _nomout = CPLib.Round(_nomses,2);
                /* ElseIf _nomses=0 and _nomemi<>0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.ne(_nomemi,0)) {
                /* _nomout := _nomemi */
                _nomout = CPLib.Round(_nomemi,2);
                /* ElseIf _nomses=0 and _nomemi=0 and _nomcon <> 0 */
              } else if (CPLib.eqr(_nomses,0) && CPLib.eqr(_nomemi,0) && CPLib.ne(_nomcon,0)) {
                /* _nomout := _nomcon */
                _nomout = CPLib.Round(_nomcon,2);
              } // End If
              /* If _nomout <> 0 */
              if (CPLib.ne(_nomout,0)) {
                /* _rapgino := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / _nomout */
                _rapgino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/_nomout,5);
                /* _rapgiin := (cgo_vlt_sessioni->VLTSES_BETIMP * 100) / cgo_vlt_sessioni->VLTSES_TOTALIN */
                _rapgiin = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP")*100)/Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN"),5);
                /* _rapvino := (cgo_vlt_sessioni->VLTSES_GROSWIN * 100) / _nomout */
                _rapvino = CPLib.Round((Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN")*100)/_nomout,5);
                /* If _rapgino < 20 or _rapgiin < 20 or _rapvino < 20 */
                if (CPLib.lt(_rapgino,20) || CPLib.lt(_rapgiin,20) || CPLib.lt(_rapvino,20)) {
                  /* If mcVLTREP.GoToKey(_idticket) */
                  if (mcVLTREP.GoToKey(_idticket)) {
                    /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                    mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                    /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[20],1) */
                    mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[20],1);
                    /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                    mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                    /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                    mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                    /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                    mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                    /* mcVLTREP.SaveRow() */
                    mcVLTREP.SaveRow();
                  } else { // Else
                    // * --- Select from cgo_vlt_sessioni
                    m_cServer = m_Ctx.GetServer("cgo_vlt_sessioni");
                    m_cPhName = m_Ctx.GetPhName("cgo_vlt_sessioni");
                    if (Cursor_cgo_vlt_sessioni!=null)
                      Cursor_cgo_vlt_sessioni.Close();
                    Cursor_cgo_vlt_sessioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTSES_IDTICKETOUT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idticket,"?",0,0,m_cServer, m_oParameters),m_cServer,_idticket)+"  and  VLTSES_SALA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idsala,"?",0,0,m_cServer, m_oParameters),m_cServer,_idsala)+"  and  VLTSES_PIATTAFORMA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer, m_oParameters),m_cServer,_codiceplat)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_sessioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_cgo_vlt_sessioni.Eof())) {
                      /* mcVLTREP.AppendWithKey(LRTrim(_idticket)) */
                      mcVLTREP.AppendWithKey(CPLib.LRTrim(_idticket));
                      /* mcVLTREP.VLTREP_AAMSSALA := LRTrim(nextLine[3]) */
                      mcVLTREP.row.VLTREP_AAMSSALA = CPLib.LRTrim(nextLine[3]);
                      /* mcVLTREP.VLTREP_CODPLAT := _codiceplat */
                      mcVLTREP.row.VLTREP_CODPLAT = _codiceplat;
                      /* mcVLTREP.VLTREP_CODCONC := 'COGETECH' */
                      mcVLTREP.row.VLTREP_CODCONC = "COGETECH";
                      /* mcVLTREP.VLTREP_AAMSVLT := _vltemi */
                      mcVLTREP.row.VLTREP_AAMSVLT = _vltemi;
                      /* mcVLTREP.VLTREP_IDTICKET := Strtran(LRTrim(nextLine[8])," ",'') */
                      mcVLTREP.row.VLTREP_IDTICKET = CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ","");
                      /* mcVLTREP.VLTREP_VALNOM := _nomout */
                      mcVLTREP.row.VLTREP_VALNOM = _nomout;
                      /* mcVLTREP.VLTREP_IMPBET := cgo_vlt_sessioni->VLTSES_BETIMP */
                      mcVLTREP.row.VLTREP_IMPBET = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_BETIMP");
                      /* mcVLTREP.VLTREP_GROSWIN := cgo_vlt_sessioni->VLTSES_GROSWIN */
                      mcVLTREP.row.VLTREP_GROSWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_GROSWIN");
                      /* mcVLTREP.VLTREP_NETWIN := cgo_vlt_sessioni->VLTSES_NETWIN */
                      mcVLTREP.row.VLTREP_NETWIN = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_NETWIN");
                      /* mcVLTREP.VLTREP_DATAEMI := arfn_dttod(_dataemi) */
                      mcVLTREP.row.VLTREP_DATAEMI = arfn_dttodR.Make(m_Ctx,this).Run(_dataemi);
                      /* mcVLTREP.VLTREP_DATACONV := ConvD(nextLine[20],1) */
                      mcVLTREP.row.VLTREP_DATACONV = ConvD(nextLine[20],1);
                      /* mcVLTREP.VLTREP_TOTALE := cgo_vlt_sessioni->VLTSES_TOTALIN */
                      mcVLTREP.row.VLTREP_TOTALE = Cursor_cgo_vlt_sessioni.GetDouble("VLTSES_TOTALIN");
                      /* mcVLTREP.VLTREP_RAPPORTO1 := _rapgino */
                      mcVLTREP.row.VLTREP_RAPPORTO1 = _rapgino;
                      /* mcVLTREP.VLTREP_RAPPORTO2 := _rapgiin */
                      mcVLTREP.row.VLTREP_RAPPORTO2 = _rapgiin;
                      /* mcVLTREP.VLTREP_RAPPORTO3 := _rapvino */
                      mcVLTREP.row.VLTREP_RAPPORTO3 = _rapvino;
                      /* mcVLTREP.VLTREP_ORIGINE := 'C' */
                      mcVLTREP.row.VLTREP_ORIGINE = "C";
                      /* mcVLTREP.SaveRow() */
                      mcVLTREP.SaveRow();
                      Cursor_cgo_vlt_sessioni.Next();
                    }
                    m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
                    Cursor_cgo_vlt_sessioni.Close();
                    // * --- End Select
                  } // End If
                } // End If
              } else { // Else
                /* _prgscarti := Utilities.GetAutonumber("PRGVLTSCARTI\'"+LRTrim(_gAzienda)+"'",0,20) */
                _prgscarti = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGVLTSCARTI\\'"+CPLib.LRTrim(_gAzienda)+"'",0,20),0);
                // * --- Insert into cgo_vlt_scarti from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_vlt_scarti");
                m_cPhName = m_Ctx.GetPhName("cgo_vlt_scarti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_vlt_scarti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_import_vlt",157,"0000037A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000037A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prgscarti,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_vlt_sessioni.GetString("VLTSES_IDSESSIONE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codiceplat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[8])," ",""),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Strtran(CPLib.LRTrim(nextLine[9])," ",""),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non è stato valorizzato l'importo out","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_vlt_scarti",true);
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
              } // End If
              /* gMsgImp := 'Sono state inserite '+LRTrim(Str(_rownum,10,0))+' convalide ...' // Messaggio Trasferimento */
              gMsgImp = "Sono state inserite "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" convalide ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              Cursor_cgo_vlt_sessioni.Next();
            }
            m_cConnectivityError = Cursor_cgo_vlt_sessioni.ErrorMessage();
            Cursor_cgo_vlt_sessioni.Close();
            // * --- End Select
          } // End If
        } // End If
        }
        // Chiuse il file
        reader.close();
      } // End If
      /* _gMsgProc := _gMsgProc + 'Sono state importati '+LRTrim(Str(_rownum,10,0)) +' biglietti convalidati per la piattaforma '  + LRTrim(_codiceplat) */
      _gMsgProc = _gMsgProc+"Sono state importati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" biglietti convalidati per la piattaforma "+CPLib.LRTrim(_codiceplat);
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgProc := gMsgProc + _gMsgProc */
        gMsgProc = gMsgProc+_gMsgProc;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_vlt_sessioni!=null)
          Cursor_cgo_vlt_sessioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  java.sql.Timestamp ConvDT(String pDataOra,double pFormato) throws Exception {
    /* pDataOra Char(20) */
    /* pFormato Numeric(1, 0) */
    /* _data Char(8) */
    String _data;
    _data = CPLib.Space(8);
    /* _ora Char(6) */
    String _ora;
    _ora = CPLib.Space(6);
    /* dtRitorno DateTime */
    java.sql.Timestamp dtRitorno;
    dtRitorno = CPLib.NullDateTime();
    /* If pFormato=1 */
    if (CPLib.eqr(pFormato,1)) {
      /* _data := Left(pDataOra,4)+Substr(pDataOra,6,2)+Substr(pDataOra,9,2) */
      _data = CPLib.Left(pDataOra,4)+CPLib.Substr(pDataOra,6,2)+CPLib.Substr(pDataOra,9,2);
    } else { // Else
      /* _data := Substr(pDataOra,7,4)+Substr(pDataOra,4,2)+Left(pDataOra,2) */
      _data = CPLib.Substr(pDataOra,7,4)+CPLib.Substr(pDataOra,4,2)+CPLib.Left(pDataOra,2);
    } // End If
    /* _ora := Substr(pDataOra,12,2)+Substr(pDataOra,15,2)+Substr(pDataOra,18,2) */
    _ora = CPLib.Substr(pDataOra,12,2)+CPLib.Substr(pDataOra,15,2)+CPLib.Substr(pDataOra,18,2);
    /* dtRitorno := CharToDateTime(LRTrim(_data)+LRTrim(_ora)) */
    dtRitorno = CPLib.CharToDateTime(CPLib.LRTrim(_data)+CPLib.LRTrim(_ora));
    /* Page Return dtRitorno */
    return dtRitorno;
  }
  java.sql.Date ConvD(String pDataOra,double pFormato) throws Exception {
    /* pDataOra Char(20) */
    /* pFormato Numeric(1, 0) */
    /* _data Char(8) */
    String _data;
    _data = CPLib.Space(8);
    /* _ora Char(6) */
    String _ora;
    _ora = CPLib.Space(6);
    /* dtRitorno Date */
    java.sql.Date dtRitorno;
    dtRitorno = CPLib.NullDate();
    /* If pFormato=1 */
    if (CPLib.eqr(pFormato,1)) {
      /* _data := Left(pDataOra,4)+Substr(pDataOra,6,2)+Substr(pDataOra,9,2) */
      _data = CPLib.Left(pDataOra,4)+CPLib.Substr(pDataOra,6,2)+CPLib.Substr(pDataOra,9,2);
    } else { // Else
      /* _data := Substr(pDataOra,7,4)+Substr(pDataOra,4,2)+Left(pDataOra,2) */
      _data = CPLib.Substr(pDataOra,7,4)+CPLib.Substr(pDataOra,4,2)+CPLib.Left(pDataOra,2);
    } // End If
    /* dtRitorno := CharToDate(LRTrim(_data)) */
    dtRitorno = CPLib.CharToDate(CPLib.LRTrim(_data));
    /* Page Return dtRitorno */
    return dtRitorno;
  }
  String CheckFiles(MemoryCursorRow_rwcheck_mcrdef pRow) throws Exception {
    /* pRow Row(rwCHECK.MCRDef) */
    /* cReturn Char(1) // Variabile di ritorno */
    String cReturn;
    cReturn = CPLib.Space(1);
    /* _process Object(Process) */
    Process _process;
    _process = null;
    /* exitVal Object(int) */
    int exitVal;
    exitVal = null;
    /* _signedfile Char(256) */
    String _signedfile;
    _signedfile = CPLib.Space(256);
    /* _outfile Char(256) */
    String _outfile;
    _outfile = CPLib.Space(256);
    /* _pemfile Char(256) */
    String _pemfile;
    _pemfile = CPLib.Space(256);
    /* _deffile Char(256) */
    String _deffile;
    _deffile = CPLib.Space(256);
    /* _fhand Char(10) */
    String _fhand;
    _fhand = CPLib.Space(10);
    /* _command Memo */
    String _command;
    _command = "";
    /* cReturn := 'S' // Variabile di ritorno */
    cReturn = "S";
    /* _pemfile := LRTrim(_gPathDoc)+"/VLT/"+LRTrim(_gAzienda)+"/"+LRTrim(pRow.NOMEDIR)+"/public.pem" */
    _pemfile = CPLib.LRTrim(_gPathDoc)+"/VLT/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/public.pem";
    /* _fhand := FileLibMit.OpenWritePath(_pemfile) */
    _fhand = FileLibMit.OpenWritePath(_pemfile);
    /* FileLibMit.WriteLine(_fhand,"-----BEGIN PUBLIC KEY-----") */
    FileLibMit.WriteLine(_fhand,"-----BEGIN PUBLIC KEY-----");
    /* FileLibMit.WriteLine(_fhand,pRow.CRYPPTOKEY) */
    FileLibMit.WriteLine(_fhand,pRow.CRYPPTOKEY);
    /* FileLibMit.Write(_fhand,"-----END PUBLIC KEY-----") */
    FileLibMit.Write(_fhand,"-----END PUBLIC KEY-----");
    /* FileLibMit.Close(_fhand) */
    FileLibMit.Close(_fhand);
    /* _signedfile := LRTrim(pRow.DIRBASE)+"/"+LRTrim(pRow.NOMEDIR)+"/"+Strtran(LRTrim(pRow.NOMEFILE1),'.csv','.signed') */
    _signedfile = CPLib.LRTrim(pRow.DIRBASE)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/"+CPLib.Strtran(CPLib.LRTrim(pRow.NOMEFILE1),".csv",".signed");
    /* If FileLibMit.ExistFile(_signedfile) */
    if (FileLibMit.ExistFile(_signedfile)) {
      /* _deffile := LRTrim(pRow.DIRBASE)+"/"+LRTrim(pRow.NOMEDIR)+"/"+LRTrim(pRow.NOMEFILE1) */
      _deffile = CPLib.LRTrim(pRow.DIRBASE)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/"+CPLib.LRTrim(pRow.NOMEFILE1);
      /* _outfile := LRTrim(_gPathDoc)+"/VLT/"+LRTrim(_gAzienda)+"/"+LRTrim(pRow.NOMEDIR)+"/check.sha256" */
      _outfile = CPLib.LRTrim(_gPathDoc)+"/VLT/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/check.sha256";
      /* _command := "openssl base64 -d -in "+LRTrim(_signedfile)+" -out "+LRTrim(_outfile) */
      _command = "openssl base64 -d -in "+CPLib.LRTrim(_signedfile)+" -out "+CPLib.LRTrim(_outfile);
      /* _process := Runtime.getRuntime().exec(_command) */
      _process = Runtime.getRuntime().exec(_command);
      // Stampa valori
      exitVal = _process.waitFor();
      /* If exitVal=0 */
      if (CPLib.eqr(exitVal,0)) {
        /* _command := "openssl dgst -sha256 -verify "+LRTrim(_pemfile)+" -signature "+LRTrim(_outfile)+" "+LRTrim(_deffile) */
        _command = "openssl dgst -sha256 -verify "+CPLib.LRTrim(_pemfile)+" -signature "+CPLib.LRTrim(_outfile)+" "+CPLib.LRTrim(_deffile);
        /* _process := Runtime.getRuntime().exec(_command) */
        _process = Runtime.getRuntime().exec(_command);
        // Stampa valori
        exitVal = _process.waitFor();
        /* If exitVal=1 */
        if (CPLib.eqr(exitVal,1)) {
          /* cReturn := 'N' // Variabile di ritorno */
          cReturn = "N";
        } // End If
      } // End If
    } else { // Else
      /* cReturn := 'N' // Variabile di ritorno */
      cReturn = "N";
    } // End If
    /* If cReturn='S' */
    if (CPLib.eqr(cReturn,"S")) {
      /* _signedfile := LRTrim(pRow.DIRBASE)+"/"+LRTrim(pRow.NOMEDIR)+"/"+Strtran(LRTrim(pRow.NOMEFILE2),'.csv','.signed') */
      _signedfile = CPLib.LRTrim(pRow.DIRBASE)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/"+CPLib.Strtran(CPLib.LRTrim(pRow.NOMEFILE2),".csv",".signed");
      /* If FileLibMit.ExistFile(_signedfile) */
      if (FileLibMit.ExistFile(_signedfile)) {
        /* _deffile := LRTrim(pRow.DIRBASE)+"/"+LRTrim(pRow.NOMEDIR)+"/"+LRTrim(pRow.NOMEFILE2) */
        _deffile = CPLib.LRTrim(pRow.DIRBASE)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/"+CPLib.LRTrim(pRow.NOMEFILE2);
        /* _outfile := LRTrim(_gPathDoc)+"/VLT/"+LRTrim(_gAzienda)+"/"+LRTrim(pRow.NOMEDIR)+"/check.sha256" */
        _outfile = CPLib.LRTrim(_gPathDoc)+"/VLT/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/check.sha256";
        /* _command := "openssl base64 -d -in "+LRTrim(_signedfile)+" -out "+LRTrim(_outfile) */
        _command = "openssl base64 -d -in "+CPLib.LRTrim(_signedfile)+" -out "+CPLib.LRTrim(_outfile);
        /* _process := Runtime.getRuntime().exec(_command) */
        _process = Runtime.getRuntime().exec(_command);
        // Stampa valori
        exitVal = _process.waitFor();
        /* If exitVal=0 */
        if (CPLib.eqr(exitVal,0)) {
          /* _command := "openssl dgst -sha256 -verify "+LRTrim(_pemfile)+" -signature "+LRTrim(_outfile)+" "+LRTrim(_deffile) */
          _command = "openssl dgst -sha256 -verify "+CPLib.LRTrim(_pemfile)+" -signature "+CPLib.LRTrim(_outfile)+" "+CPLib.LRTrim(_deffile);
          /* _process := Runtime.getRuntime().exec(_command) */
          _process = Runtime.getRuntime().exec(_command);
          // Stampa valori
          exitVal = _process.waitFor();
          /* If exitVal=1 */
          if (CPLib.eqr(exitVal,1)) {
            /* cReturn := 'N' // Variabile di ritorno */
            cReturn = "N";
          } // End If
        } // End If
      } else { // Else
        /* cReturn := 'N' // Variabile di ritorno */
        cReturn = "N";
      } // End If
    } // End If
    /* If cReturn='S' */
    if (CPLib.eqr(cReturn,"S")) {
      /* _signedfile := LRTrim(pRow.DIRBASE)+"/"+LRTrim(pRow.NOMEDIR)+"/"+Strtran(LRTrim(pRow.NOMEFILE3),'.csv','.signed') */
      _signedfile = CPLib.LRTrim(pRow.DIRBASE)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/"+CPLib.Strtran(CPLib.LRTrim(pRow.NOMEFILE3),".csv",".signed");
      /* If FileLibMit.ExistFile(_signedfile) */
      if (FileLibMit.ExistFile(_signedfile)) {
        /* _deffile := LRTrim(pRow.DIRBASE)+"/"+LRTrim(pRow.NOMEDIR)+"/"+LRTrim(pRow.NOMEFILE3) */
        _deffile = CPLib.LRTrim(pRow.DIRBASE)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/"+CPLib.LRTrim(pRow.NOMEFILE3);
        /* _outfile := LRTrim(_gPathDoc)+"/VLT/"+LRTrim(_gAzienda)+"/"+LRTrim(pRow.NOMEDIR)+"/check.sha256" */
        _outfile = CPLib.LRTrim(_gPathDoc)+"/VLT/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(pRow.NOMEDIR)+"/check.sha256";
        /* _command := "openssl base64 -d -in "+LRTrim(_signedfile)+" -out "+LRTrim(_outfile) */
        _command = "openssl base64 -d -in "+CPLib.LRTrim(_signedfile)+" -out "+CPLib.LRTrim(_outfile);
        /* _process := Runtime.getRuntime().exec(_command) */
        _process = Runtime.getRuntime().exec(_command);
        // Stampa valori
        exitVal = _process.waitFor();
        /* If exitVal=0 */
        if (CPLib.eqr(exitVal,0)) {
          /* _command := "openssl dgst -sha256 -verify "+LRTrim(_pemfile)+" -signature "+LRTrim(_outfile)+" "+LRTrim(_deffile) */
          _command = "openssl dgst -sha256 -verify "+CPLib.LRTrim(_pemfile)+" -signature "+CPLib.LRTrim(_outfile)+" "+CPLib.LRTrim(_deffile);
          /* _process := Runtime.getRuntime().exec(_command) */
          _process = Runtime.getRuntime().exec(_command);
          // Stampa valori
          exitVal = _process.waitFor();
          /* If exitVal=1 */
          if (CPLib.eqr(exitVal,1)) {
            /* cReturn := 'N' // Variabile di ritorno */
            cReturn = "N";
          } // End If
        } // End If
      } else { // Else
        /* cReturn := 'N' // Variabile di ritorno */
        cReturn = "N";
      } // End If
    } // End If
    /* Page Return cReturn */
    return cReturn;
  }
  String CheckPrevFiles(String pCodPlat,java.sql.Date pDataImp) throws Exception {
    CPResultSet Cursor_cgo_vlt_impdata=null;
    try {
      /* pCodPlat Char(2) */
      /* pDataImp Date */
      /* cReturn Char(1) // Variabile di ritorno */
      String cReturn;
      cReturn = CPLib.Space(1);
      /* _datachk Date */
      /* _trovato Numeric(1, 0) */
      /* cReturn := 'N' // Variabile di ritorno */
      cReturn = "N";
      /* _trovato := 0 */
      _trovato = CPLib.Round(0,0);
      /* _datachk := arfn_dateminus(pDataImp,1) */
      _datachk = arfn_dateminusR.Make(m_Ctx,this).Run(pDataImp,1);
      // * --- Select from cgo_vlt_impdata
      m_cServer = m_Ctx.GetServer("cgo_vlt_impdata");
      m_cPhName = m_Ctx.GetPhName("cgo_vlt_impdata");
      if (Cursor_cgo_vlt_impdata!=null)
        Cursor_cgo_vlt_impdata.Close();
      Cursor_cgo_vlt_impdata = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"VLTIMPCODPLAT="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodPlat,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodPlat)+"  and  VLTIMPDATE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datachk,"?",0,0,m_cServer, m_oParameters),m_cServer,_datachk)+" "+")"+(m_Ctx.IsSharedTemp("cgo_vlt_impdata")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_vlt_impdata.Eof())) {
        /* If cgo_vlt_impdata->VLTIMPFLAGOK1='S' and cgo_vlt_impdata->VLTIMPFLAGOK2='S' and cgo_vlt_impdata->VLTIMPFLAGOK3='S' */
        if (CPLib.eqr(Cursor_cgo_vlt_impdata.GetString("VLTIMPFLAGOK1"),"S") && CPLib.eqr(Cursor_cgo_vlt_impdata.GetString("VLTIMPFLAGOK2"),"S") && CPLib.eqr(Cursor_cgo_vlt_impdata.GetString("VLTIMPFLAGOK3"),"S")) {
          /* cReturn := 'S' // Variabile di ritorno */
          cReturn = "S";
          /* _trovato := 1 */
          _trovato = CPLib.Round(1,0);
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
        Cursor_cgo_vlt_impdata.Next();
      }
      m_cConnectivityError = Cursor_cgo_vlt_impdata.ErrorMessage();
      Cursor_cgo_vlt_impdata.Close();
      // * --- End Select
      /* Page Return cReturn */
      return cReturn;
    } finally {
      try {
        if (Cursor_cgo_vlt_impdata!=null)
          Cursor_cgo_vlt_impdata.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_import_vltR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_import_vltR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    _tot = 0;
    _dirbase = CPLib.Space(120);
    _orastop = 0;
    _rownum = 0;
    _nomefile = "";
    _tipofile = CPLib.Space(1);
    _codiceplat = CPLib.Space(10);
    _prog = 0;
    _prgtele = CPLib.Space(15);
    _gAzienda = CPLib.Space(10);
    _gPathDoc = "";
    _oldazi = CPLib.Space(10);
    _separator = CPLib.Space(1);
    _intesta = 0;
    _platcod = CPLib.Space(2);
    _coddip = CPLib.Space(6);
    _rapgino = 0;
    _rapgiin = 0;
    _rapvino = 0;
    _idticket = CPLib.Space(50);
    _idsala = CPLib.Space(50);
    _dataemi = CPLib.NullDateTime();
    _idvlt = CPLib.Space(50);
    _piattaforme = "";
    _fileok = CPLib.Space(1);
    _gMsgProc = "";
    cProg = CPLib.Space(20);
    _dataoggi = CPLib.NullDate();
    _vltemi = CPLib.Space(50);
    _nomemi = 0;
    _nomses = 0;
    _nomcon = 0;
    _nomout = 0;
    _dataimp = CPLib.NullDate();
    _prgscarti = 0;
    _srvmail = CPLib.Space(50);
    _prtmail = 0;
    _emlmail = CPLib.Space(50);
    _usrmail = CPLib.Space(50);
    _pwdmail = CPLib.Space(30);
    _esito = "";
    mcVLTPLAT = new MemoryCursor_cgo_vltplat();
    mcANADIP = new MemoryCursor_anadip();
    mcVLTREP = new MemoryCursor_cgo_vlt_report();
    rowVLTPLAT = new MemoryCursorRow_rwcheck_mcrdef();
    _datachk = CPLib.NullDate();
    _trovato = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_nomefile_vlt,arfn_dateminus,arfn_dttod,arfn_fdatetime,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_cgo_nomefile_vlt,arfn_dateminus,arfn_dttod,arfn_fdatetime,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_00000056(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTIMPDATE,";
    p_cSql = p_cSql+"VLTIMPCODPLAT,";
    p_cSql = p_cSql+"VLTIMPFLAGOK1,";
    p_cSql = p_cSql+"VLTIMPFLAGOK2,";
    p_cSql = p_cSql+"VLTIMPFLAGOK3,";
    p_cSql = p_cSql+"VLTIMPNOMEFILE1,";
    p_cSql = p_cSql+"VLTIMPNOMEFILE2,";
    p_cSql = p_cSql+"VLTIMPNOMEFILE3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_impdata",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTREP_IDPROG,";
    p_cSql = p_cSql+"VLTREP_AAMSSALA,";
    p_cSql = p_cSql+"VLTREP_CODCONC,";
    p_cSql = p_cSql+"VLTREP_CODPLAT,";
    p_cSql = p_cSql+"VLTREP_AAMSVLT,";
    p_cSql = p_cSql+"VLTREP_IDTICKET,";
    p_cSql = p_cSql+"VLTREP_VALNOM,";
    p_cSql = p_cSql+"VLTREP_DATAEMI,";
    p_cSql = p_cSql+"VLTREP_DATACONV,";
    p_cSql = p_cSql+"VLTREP_IMPBET,";
    p_cSql = p_cSql+"VLTREP_GROSWIN,";
    p_cSql = p_cSql+"VLTREP_NETWIN,";
    p_cSql = p_cSql+"VLTREP_TOTALE,";
    p_cSql = p_cSql+"VLTREP_RAPPORTO1,";
    p_cSql = p_cSql+"VLTREP_RAPPORTO2,";
    p_cSql = p_cSql+"VLTREP_RAPPORTO3,";
    p_cSql = p_cSql+"VLTREP_TICKET_BC,";
    p_cSql = p_cSql+"VLTREP_ORIGINE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_report",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSES_IDPROG,";
    p_cSql = p_cSql+"VLTSES_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSES_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSES_SALA,";
    p_cSql = p_cSql+"VLTSES_VLT,";
    p_cSql = p_cSql+"VLTSES_DATINI,";
    p_cSql = p_cSql+"VLTSES_DATFIN,";
    p_cSql = p_cSql+"VLTSES_BETNUM,";
    p_cSql = p_cSql+"VLTSES_BETIMP,";
    p_cSql = p_cSql+"VLTSES_GROSWIN,";
    p_cSql = p_cSql+"VLTSES_NETWIN,";
    p_cSql = p_cSql+"VLTSES_TOTALIN,";
    p_cSql = p_cSql+"VLTSES_TICKETIN,";
    p_cSql = p_cSql+"VLTSES_BILLIN,";
    p_cSql = p_cSql+"VLTSES_OUT,";
    p_cSql = p_cSql+"VLTSES_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTSES_TICKETLIST,";
    p_cSql = p_cSql+"VLTSES_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_sessioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSES_IDPROG,";
    p_cSql = p_cSql+"VLTSES_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSES_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSES_SALA,";
    p_cSql = p_cSql+"VLTSES_VLT,";
    p_cSql = p_cSql+"VLTSES_DATINI,";
    p_cSql = p_cSql+"VLTSES_DATFIN,";
    p_cSql = p_cSql+"VLTSES_BETNUM,";
    p_cSql = p_cSql+"VLTSES_BETIMP,";
    p_cSql = p_cSql+"VLTSES_GROSWIN,";
    p_cSql = p_cSql+"VLTSES_NETWIN,";
    p_cSql = p_cSql+"VLTSES_TOTALIN,";
    p_cSql = p_cSql+"VLTSES_TICKETIN,";
    p_cSql = p_cSql+"VLTSES_BILLIN,";
    p_cSql = p_cSql+"VLTSES_OUT,";
    p_cSql = p_cSql+"VLTSES_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTSES_TICKETLIST,";
    p_cSql = p_cSql+"VLTSES_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_sessioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSES_IDPROG,";
    p_cSql = p_cSql+"VLTSES_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSES_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSES_SALA,";
    p_cSql = p_cSql+"VLTSES_VLT,";
    p_cSql = p_cSql+"VLTSES_DATINI,";
    p_cSql = p_cSql+"VLTSES_DATFIN,";
    p_cSql = p_cSql+"VLTSES_BETNUM,";
    p_cSql = p_cSql+"VLTSES_BETIMP,";
    p_cSql = p_cSql+"VLTSES_GROSWIN,";
    p_cSql = p_cSql+"VLTSES_NETWIN,";
    p_cSql = p_cSql+"VLTSES_TOTALIN,";
    p_cSql = p_cSql+"VLTSES_TICKETIN,";
    p_cSql = p_cSql+"VLTSES_BILLIN,";
    p_cSql = p_cSql+"VLTSES_OUT,";
    p_cSql = p_cSql+"VLTSES_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTSES_TICKETLIST,";
    p_cSql = p_cSql+"VLTSES_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_sessioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSES_IDPROG,";
    p_cSql = p_cSql+"VLTSES_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSES_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSES_SALA,";
    p_cSql = p_cSql+"VLTSES_VLT,";
    p_cSql = p_cSql+"VLTSES_DATINI,";
    p_cSql = p_cSql+"VLTSES_DATFIN,";
    p_cSql = p_cSql+"VLTSES_BETNUM,";
    p_cSql = p_cSql+"VLTSES_BETIMP,";
    p_cSql = p_cSql+"VLTSES_GROSWIN,";
    p_cSql = p_cSql+"VLTSES_NETWIN,";
    p_cSql = p_cSql+"VLTSES_TOTALIN,";
    p_cSql = p_cSql+"VLTSES_TICKETIN,";
    p_cSql = p_cSql+"VLTSES_BILLIN,";
    p_cSql = p_cSql+"VLTSES_OUT,";
    p_cSql = p_cSql+"VLTSES_DATACREA,";
    p_cSql = p_cSql+"VLTSES_TICKET_BC,";
    p_cSql = p_cSql+"VLTSES_DATAEMI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_sessioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTEME_IDPROG,";
    p_cSql = p_cSql+"VLTEME_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTEME_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTEME_SALA,";
    p_cSql = p_cSql+"VLTEME_VLT,";
    p_cSql = p_cSql+"VLTEME_IMPORTO,";
    p_cSql = p_cSql+"VLTEME_DATEMI,";
    p_cSql = p_cSql+"VLTEME_DATSCA,";
    p_cSql = p_cSql+"VLTEME_IDSESSIONE,";
    p_cSql = p_cSql+"VLTEME_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_emessi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTEME_IDPROG,";
    p_cSql = p_cSql+"VLTEME_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTEME_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTEME_SALA,";
    p_cSql = p_cSql+"VLTEME_VLT,";
    p_cSql = p_cSql+"VLTEME_IMPORTO,";
    p_cSql = p_cSql+"VLTEME_DATEMI,";
    p_cSql = p_cSql+"VLTEME_DATSCA,";
    p_cSql = p_cSql+"VLTEME_IDSESSIONE,";
    p_cSql = p_cSql+"VLTEME_DATACREA,";
    p_cSql = p_cSql+"VLTEME_IDXAFF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_emessi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000115(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTEME_IDPROG,";
    p_cSql = p_cSql+"VLTEME_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTEME_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTEME_SALA,";
    p_cSql = p_cSql+"VLTEME_VLT,";
    p_cSql = p_cSql+"VLTEME_IMPORTO,";
    p_cSql = p_cSql+"VLTEME_DATEMI,";
    p_cSql = p_cSql+"VLTEME_DATSCA,";
    p_cSql = p_cSql+"VLTEME_IDSESSIONE,";
    p_cSql = p_cSql+"VLTEME_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_emessi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000142(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTEME_IDPROG,";
    p_cSql = p_cSql+"VLTEME_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTEME_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTEME_SALA,";
    p_cSql = p_cSql+"VLTEME_VLT,";
    p_cSql = p_cSql+"VLTEME_IMPORTO,";
    p_cSql = p_cSql+"VLTEME_TICKET_BC,";
    p_cSql = p_cSql+"VLTEME_DATEMI,";
    p_cSql = p_cSql+"VLTEME_IDSESSIONE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_emessi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000014A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000172(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTCON_IDPROG,";
    p_cSql = p_cSql+"VLTCON_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTCON_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTCON_SALA,";
    p_cSql = p_cSql+"VLTCON_VLT,";
    p_cSql = p_cSql+"VLTCON_IMPORTO,";
    p_cSql = p_cSql+"VLTCON_DATCONV,";
    p_cSql = p_cSql+"VLTCON_IDSESEMIS,";
    p_cSql = p_cSql+"VLTCON_FLGAML,";
    p_cSql = p_cSql+"VLTCON_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_convalidati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000179(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000195(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTCON_IDPROG,";
    p_cSql = p_cSql+"VLTCON_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTCON_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTCON_SALA,";
    p_cSql = p_cSql+"VLTCON_VLT,";
    p_cSql = p_cSql+"VLTCON_IMPORTO,";
    p_cSql = p_cSql+"VLTCON_DATCONV,";
    p_cSql = p_cSql+"VLTCON_IDSESCONV,";
    p_cSql = p_cSql+"VLTCON_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_convalidati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000022A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000245(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000027D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTCON_IDPROG,";
    p_cSql = p_cSql+"VLTCON_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTCON_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTCON_SALA,";
    p_cSql = p_cSql+"VLTCON_VLT,";
    p_cSql = p_cSql+"VLTCON_IMPORTO,";
    p_cSql = p_cSql+"VLTCON_DATCONV,";
    p_cSql = p_cSql+"VLTCON_IDSESCONV,";
    p_cSql = p_cSql+"VLTCON_DATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_convalidati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000284(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002F2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000303(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTCON_IDPROG,";
    p_cSql = p_cSql+"VLTCON_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTCON_IDTICKETOUT,";
    p_cSql = p_cSql+"VLTCON_SALA,";
    p_cSql = p_cSql+"VLTCON_VLT,";
    p_cSql = p_cSql+"VLTCON_IMPORTO,";
    p_cSql = p_cSql+"VLTCON_DATCONV,";
    p_cSql = p_cSql+"VLTCON_TICKET_BC,";
    p_cSql = p_cSql+"VLTCON_IDSESEMIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_convalidati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000030B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000327(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000337(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000353(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000037A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VLTSCARTI_PROG,";
    p_cSql = p_cSql+"VLTSCARTI_DATAIMPORT,";
    p_cSql = p_cSql+"VLTSCARTI_IDSESSIONE,";
    p_cSql = p_cSql+"VLTSCARTI_PIATTAFORMA,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET,";
    p_cSql = p_cSql+"VLTSCARTI_IDTICKET_BC,";
    p_cSql = p_cSql+"VLTSCARTI_MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_vlt_scarti",true);
    return p_cSql;
  }
}
