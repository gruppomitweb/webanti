// * --- Area Manuale = BO - Header
// * --- arrt_famesiti_elab
import java.io.*;
import java.util.Scanner;

import org.json.*;
// * --- Fine Area Manuale
public class arrt_famesiti_elabR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_tbesielb;
  public String m_cServer_tbesielb;
  public String m_cPhName_tmp_esitosid;
  public String m_cServer_tmp_esitosid;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
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
  public String w_nomefile;
  public String w_nomsg;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gMsgProc;
  public String gMsgImp;
  public String fhand;
  public String _dir1;
  public String _dir2;
  public String _dir3;
  public String _dir4;
  public String _dirsid;
  public String _dirjava;
  public String _idsog;
  public String _pwdsog;
  public String _tipo;
  public String _riga;
  public String _fcfg;
  public String _idb;
  public String _semaforo;
  public String _risultato;
  public String _tiporis;
  public String _tipoelab;
  public String _fileesi;
  public String _filedgn;
  public String _protocollo;
  public String _tipodoc;
  public String _tfile;
  public String _tprog;
  public String _tfind;
  public String _filename;
  public MemoryCursor_tbesielb _erresi;
  public String w_annorif;
  public double _wesito;
  public String _fileorig;
  public double _nriga;
  public String _rapporto;
  public String _invio;
  public String _unique;
  public String _tipoanom;
  public String _datoerr;
  public String _tipoag;
  public String _codelab;
  public double _contaT;
  public String _descesito;
  public String _esito;
  public String _coderrore;
  public String _codprot;
  public String _protinvio;
  public double _annoinvio;
  public String _errore_testat;
  public double w_anno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_famesiti_elabR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_famesiti_elab",m_Caller);
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_tbesielb = p_ContextObject.GetPhName("tbesielb");
    if (m_cPhName_tbesielb.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbesielb = m_cPhName_tbesielb+" "+m_Ctx.GetWritePhName("tbesielb");
    }
    m_cServer_tbesielb = p_ContextObject.GetServer("tbesielb");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
      m_cPhName_tmp_esitosid = p_ContextObject.GetPhName("tmp_esitosid");
      if (m_cPhName_tmp_esitosid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_esitosid = m_cPhName_tmp_esitosid+" "+m_Ctx.GetWritePhName("tmp_esitosid");
      }
      m_cServer_tmp_esitosid = p_ContextObject.GetServer("tmp_esitosid");
    }
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_wesito",p_cVarName)) {
      return _wesito;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_contaT",p_cVarName)) {
      return _contaT;
    }
    if (CPLib.eqr("_annoinvio",p_cVarName)) {
      return _annoinvio;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_famesiti_elab";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("nomsg",p_cVarName)) {
      return w_nomsg;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_dir1",p_cVarName)) {
      return _dir1;
    }
    if (CPLib.eqr("_dir2",p_cVarName)) {
      return _dir2;
    }
    if (CPLib.eqr("_dir3",p_cVarName)) {
      return _dir3;
    }
    if (CPLib.eqr("_dir4",p_cVarName)) {
      return _dir4;
    }
    if (CPLib.eqr("_dirsid",p_cVarName)) {
      return _dirsid;
    }
    if (CPLib.eqr("_dirjava",p_cVarName)) {
      return _dirjava;
    }
    if (CPLib.eqr("_idsog",p_cVarName)) {
      return _idsog;
    }
    if (CPLib.eqr("_pwdsog",p_cVarName)) {
      return _pwdsog;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      return _tipo;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_fcfg",p_cVarName)) {
      return _fcfg;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_semaforo",p_cVarName)) {
      return _semaforo;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      return _risultato;
    }
    if (CPLib.eqr("_tiporis",p_cVarName)) {
      return _tiporis;
    }
    if (CPLib.eqr("_tipoelab",p_cVarName)) {
      return _tipoelab;
    }
    if (CPLib.eqr("_fileesi",p_cVarName)) {
      return _fileesi;
    }
    if (CPLib.eqr("_filedgn",p_cVarName)) {
      return _filedgn;
    }
    if (CPLib.eqr("_protocollo",p_cVarName)) {
      return _protocollo;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_tfile",p_cVarName)) {
      return _tfile;
    }
    if (CPLib.eqr("_tprog",p_cVarName)) {
      return _tprog;
    }
    if (CPLib.eqr("_tfind",p_cVarName)) {
      return _tfind;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("annorif",p_cVarName)) {
      return w_annorif;
    }
    if (CPLib.eqr("_fileorig",p_cVarName)) {
      return _fileorig;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      return _invio;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      return _unique;
    }
    if (CPLib.eqr("_tipoanom",p_cVarName)) {
      return _tipoanom;
    }
    if (CPLib.eqr("_datoerr",p_cVarName)) {
      return _datoerr;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_codelab",p_cVarName)) {
      return _codelab;
    }
    if (CPLib.eqr("_descesito",p_cVarName)) {
      return _descesito;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_coderrore",p_cVarName)) {
      return _coderrore;
    }
    if (CPLib.eqr("_codprot",p_cVarName)) {
      return _codprot;
    }
    if (CPLib.eqr("_protinvio",p_cVarName)) {
      return _protinvio;
    }
    if (CPLib.eqr("_errore_testat",p_cVarName)) {
      return _errore_testat;
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
    if (CPLib.eqr("_erresi",p_cVarName)) {
      return _erresi;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_wesito",p_cVarName)) {
      _wesito = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_contaT",p_cVarName)) {
      _contaT = value;
      return;
    }
    if (CPLib.eqr("_annoinvio",p_cVarName)) {
      _annoinvio = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("nomsg",p_cVarName)) {
      w_nomsg = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_dir1",p_cVarName)) {
      _dir1 = value;
      return;
    }
    if (CPLib.eqr("_dir2",p_cVarName)) {
      _dir2 = value;
      return;
    }
    if (CPLib.eqr("_dir3",p_cVarName)) {
      _dir3 = value;
      return;
    }
    if (CPLib.eqr("_dir4",p_cVarName)) {
      _dir4 = value;
      return;
    }
    if (CPLib.eqr("_dirsid",p_cVarName)) {
      _dirsid = value;
      return;
    }
    if (CPLib.eqr("_dirjava",p_cVarName)) {
      _dirjava = value;
      return;
    }
    if (CPLib.eqr("_idsog",p_cVarName)) {
      _idsog = value;
      return;
    }
    if (CPLib.eqr("_pwdsog",p_cVarName)) {
      _pwdsog = value;
      return;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      _tipo = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_fcfg",p_cVarName)) {
      _fcfg = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_semaforo",p_cVarName)) {
      _semaforo = value;
      return;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      _risultato = value;
      return;
    }
    if (CPLib.eqr("_tiporis",p_cVarName)) {
      _tiporis = value;
      return;
    }
    if (CPLib.eqr("_tipoelab",p_cVarName)) {
      _tipoelab = value;
      return;
    }
    if (CPLib.eqr("_fileesi",p_cVarName)) {
      _fileesi = value;
      return;
    }
    if (CPLib.eqr("_filedgn",p_cVarName)) {
      _filedgn = value;
      return;
    }
    if (CPLib.eqr("_protocollo",p_cVarName)) {
      _protocollo = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("_tfile",p_cVarName)) {
      _tfile = value;
      return;
    }
    if (CPLib.eqr("_tprog",p_cVarName)) {
      _tprog = value;
      return;
    }
    if (CPLib.eqr("_tfind",p_cVarName)) {
      _tfind = value;
      return;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("annorif",p_cVarName)) {
      w_annorif = value;
      return;
    }
    if (CPLib.eqr("_fileorig",p_cVarName)) {
      _fileorig = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      _invio = value;
      return;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      _unique = value;
      return;
    }
    if (CPLib.eqr("_tipoanom",p_cVarName)) {
      _tipoanom = value;
      return;
    }
    if (CPLib.eqr("_datoerr",p_cVarName)) {
      _datoerr = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("_codelab",p_cVarName)) {
      _codelab = value;
      return;
    }
    if (CPLib.eqr("_descesito",p_cVarName)) {
      _descesito = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_coderrore",p_cVarName)) {
      _coderrore = value;
      return;
    }
    if (CPLib.eqr("_codprot",p_cVarName)) {
      _codprot = value;
      return;
    }
    if (CPLib.eqr("_protinvio",p_cVarName)) {
      _protinvio = value;
      return;
    }
    if (CPLib.eqr("_errore_testat",p_cVarName)) {
      _errore_testat = value;
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
    if (CPLib.eqr("_erresi",p_cVarName)) {
      _erresi = (MemoryCursor_tbesielb)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbesielb=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_nomefile Char(100) */
      /* w_nomsg Char(1) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgProc Memo // Log Messaggi */
      /* gMsgImp Char(120) // Messaggio Import */
      /* fhand Char(1) // Handle File */
      /* _dir1 Char(180) */
      /* _dir2 Char(180) */
      /* _dir3 Char(180) */
      /* _dir4 Char(180) */
      /* _dirsid Char(250) */
      /* _dirjava Char(250) */
      /* _idsog Char(50) */
      /* _pwdsog Char(50) */
      /* _tipo Char(1) */
      /* _riga Memo */
      /* _fcfg Char(120) */
      /* _idb Char(10) */
      /* _semaforo Char(8) // Veridica semaforo SID */
      /* _risultato Char(3) */
      /* _tiporis Char(20) */
      /* _tipoelab Char(20) */
      /* _fileesi Char(80) */
      /* _filedgn Char(80) */
      /* _protocollo Char(24) */
      /* _tipodoc Char(1) */
      /* _tfile Char(15) */
      /* _tprog Char(25) */
      /* _tfind Char(10) */
      /* _filename Char(255) */
      /* _erresi MemoryCursor(tbesielb) */
      /* w_annorif Char(4) */
      /* _wesito Numeric(1, 0) */
      /* _fileorig Char(50) */
      /* _nriga Numeric(10, 0) */
      /* _rapporto Char(25) */
      /* _invio Char(10) */
      /* _unique Char(50) */
      /* _tipoanom Char(1) */
      /* _datoerr Char(16) */
      /* _tipoag Char(2) */
      /* _codelab Char(13) */
      /* _contaT Numeric(10, 0) */
      /* _descesito Memo */
      /* _esito Char(3) */
      /* _coderrore Char(16) */
      /* _codprot Char(13) */
      /* _protinvio Char(24) */
      /* _annoinvio Numeric(4, 0) */
      /* _errore_testat Char(70) */
      /* w_anno Numeric(4, 0) */
      /* jsonUtente Object(JSONObject) */
      JSONObject jsonUtente;
      jsonUtente = null;
      /* gMsgProc := 'Inizio Elaborazione SID'+ NL // Log Messaggi */
      gMsgProc = "Inizio Elaborazione SID"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _semaforo := '' // Veridica semaforo SID */
      _semaforo = "";
      // * --- Drop temporary table tmp_esitosid
      if (m_Ctx.IsSharedTemp("tmp_esitosid")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
          m_cServer = m_Ctx.GetServer("tmp_esitosid");
          m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_esitosid");
      }
      // * --- Create temporary table tmp_esitosid
      if (m_Ctx.IsSharedTemp("tmp_esitosid")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
          m_cServer = m_Ctx.GetServer("tmp_esitosid");
          m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_esitosid");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_esitosid");
      if ( ! (m_Ctx.IsSharedTemp("tmp_esitosid"))) {
        m_cServer = m_Ctx.GetServer("tmp_esitosid");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_esitosid",m_cServer,"proto")),m_cPhName,"tmp_esitosid",m_Ctx);
      }
      m_cPhName_tmp_esitosid = m_cPhName;
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("SEMAFORO","C",100,0,m_cServer),m_cServer,"SEMAFORO");
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("tablecode",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _semaforo = Read_Cursor.GetString("tablecode");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_famesiti_elab returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _semaforo = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Fill memory cursor _erresi on tbesielb
      _erresi.Zap();
      m_cServer = m_Ctx.GetServer("tbesielb");
      m_cPhName = m_Ctx.GetPhName("tbesielb");
      if (Cursor_tbesielb!=null)
        Cursor_tbesielb.Close();
      Cursor_tbesielb = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbesielb")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbesielb;
        Cursor_tbesielb.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_famesiti_elab: query on tbesielb returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbesielb.Eof())) {
        _erresi.AppendWithTrimmedKey(Cursor_tbesielb.GetString("EECODICE"));
        _erresi.row.EECODICE = Cursor_tbesielb.GetString("EECODICE");
        _erresi.row.EEDESCRI = Cursor_tbesielb.GetString("EEDESCRI");
        _erresi.row.EEAZIONE = Cursor_tbesielb.GetString("EEAZIONE");
        _erresi.row.EECOMMEN = Cursor_tbesielb.GetString("EECOMMEN");
        _erresi.row.EELETINI = Cursor_tbesielb.GetString("EELETINI");
        _erresi.row.EETIPESI = Cursor_tbesielb.GetString("EETIPESI");
        Cursor_tbesielb.Next();
      }
      m_cConnectivityError = Cursor_tbesielb.ErrorMessage();
      Cursor_tbesielb.Close();
      _erresi.GoTop();
      /* gMsgProc := gMsgProc + 'Cancellazione file esiti precedenti' + NL // Log Messaggi */
      gMsgProc = gMsgProc+"Cancellazione file esiti precedenti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Legge i file degli esiti
      File di = new File(CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ESI/"+CPLib.LRTrim(gAzienda)+"/");
      File fl[] = di.listFiles();
      int _i;
      int count=0;
      for (_i=0; _i < fl.length; _i++)  {
        fl[_i].delete();
      }
      // Legge i file degli esiti
      di = new File(CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+CPLib.LRTrim(gAzienda)+"/");
      File fl2[] = di.listFiles();
      count=0;
      for (_i=0; _i < fl2.length; _i++)  {
        fl2[_i].delete();
      }
      // Legge i file degli esiti
      di = new File(CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ELB/"+CPLib.LRTrim(gAzienda)+"/");
      File fl3[] = di.listFiles();
      count=0;
      for (_i=0; _i < fl3.length; _i++)  {
      fl3[_i].delete();
      }
      /* If FileLibMit.FileCopy(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+LRTrim(w_nomefile),LRTrim(gPathDoc)+'/SID/RICEVUTE/ELB/'+LRTrim(gAzienda)+'/'+LRTrim(w_nomefile)) */
      if (FileLibMit.FileCopy(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile),CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ELB/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile))) {
        /* If Empty(LRTrim(_semaforo)) */
        if (CPLib.Empty(CPLib.LRTrim(_semaforo))) {
          /* w_anno := Year(Date()) */
          w_anno = CPLib.Round(CPLib.Year(CPLib.Date()),0);
          /* _contaT := 0 */
          _contaT = CPLib.Round(0,0);
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famesiti_elab",348,"0000004B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000004B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("SEMAFORO","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("xxx","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
          // * --- Select from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          if (Cursor_intermbo!=null)
            Cursor_intermbo.Close();
          Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDSID,SIDPASS,PATHSID,PATHJAVA,TIPOINST  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intermbo.Eof())) {
            /* _idsog := intermbo->IDSID */
            _idsog = Cursor_intermbo.GetString("IDSID");
            /* _pwdsog := intermbo->SIDPASS */
            _pwdsog = Cursor_intermbo.GetString("SIDPASS");
            /* _dirjava := intermbo->PATHJAVA */
            _dirjava = Cursor_intermbo.GetString("PATHJAVA");
            /* _tipo := intermbo->TIPOINST */
            _tipo = Cursor_intermbo.GetString("TIPOINST");
            Cursor_intermbo.Next();
          }
          m_cConnectivityError = Cursor_intermbo.ErrorMessage();
          Cursor_intermbo.Close();
          // * --- End Select
          /* w_annorif := Str(w_anno,4,0) */
          w_annorif = CPLib.Str(w_anno,4,0);
          /* gMsgProc := gMsgProc + 'Costruzione File di configurazione' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Costruzione File di configurazione"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _dirsid := gPathApp+"/SID" */
          _dirsid = gPathApp+"/SID";
          /* If _tipo='W' */
          if (CPLib.eqr(_tipo,"W")) {
            /* _dir1 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\RICEVUTE\ELB\"+LRTrim(gAzienda)+"\" */
            _dir1 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\RICEVUTE\\ELB\\"+CPLib.LRTrim(gAzienda)+"\\";
            /* _dir2 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\RICEVUTE\ESI\"+LRTrim(gAzienda)+"\" */
            _dir2 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\RICEVUTE\\ESI\\"+CPLib.LRTrim(gAzienda)+"\\";
            /* _dir3 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\RICEVUTE\RIC\"+LRTrim(gAzienda)+"\" */
            _dir3 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\RICEVUTE\\RIC\\"+CPLib.LRTrim(gAzienda)+"\\";
            /* _dir4 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\CERTIFICATI\"+LRTrim(gAzienda)+"\" */
            _dir4 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\CERTIFICATI\\"+CPLib.LRTrim(gAzienda)+"\\";
            /* ElseIf _tipo='L' */
          } else if (CPLib.eqr(_tipo,"L")) {
            /* _dir1 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/RICEVUTE/ELB/"+LRTrim(gAzienda)+"/" */
            _dir1 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/RICEVUTE/ELB/"+CPLib.LRTrim(gAzienda)+"/";
            /* _dir2 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/RICEVUTE/ESI/"+LRTrim(gAzienda)+"/" */
            _dir2 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/RICEVUTE/ESI/"+CPLib.LRTrim(gAzienda)+"/";
            /* _dir3 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/RICEVUTE/RIC/"+LRTrim(gAzienda)+"/" */
            _dir3 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/RICEVUTE/RIC/"+CPLib.LRTrim(gAzienda)+"/";
            /* _dir4 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/" */
            _dir4 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/";
          } // End If
          /* _fcfg := '/SID/config/utente.json' */
          _fcfg = "/SID/config/utente.json";
          /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
          fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
          /* Prepara il file di configurazione */
          /* jsonUtente := new JSONObject() */
          jsonUtente = new JSONObject();
          /* jsonUtente.put("idSid",LRTrim(_idsog)) */
          jsonUtente.put("idSid",CPLib.LRTrim(_idsog));
          /* jsonUtente.put("denominazione","utente2") */
          jsonUtente.put("denominazione","utente2");
          /* jsonUtente.put("ambienteSicurezzaPath",LibreriaMit.UTFtoISO(_dir4)) */
          jsonUtente.put("ambienteSicurezzaPath",LibreriaMit.UTFtoISO(_dir4));
          /* jsonUtente.put("ricevute_da_elaborare",LibreriaMit.UTFtoISO(_dir1)) */
          jsonUtente.put("ricevute_da_elaborare",LibreriaMit.UTFtoISO(_dir1));
          /* jsonUtente.put("ricevute_elaborate",LibreriaMit.UTFtoISO(_dir3)) */
          jsonUtente.put("ricevute_elaborate",LibreriaMit.UTFtoISO(_dir3));
          /* jsonUtente.put("file_esiti",LibreriaMit.UTFtoISO(_dir2)) */
          jsonUtente.put("file_esiti",LibreriaMit.UTFtoISO(_dir2));
          // Scrive il file di configurazione
          FileLibMit.Write(fhand,jsonUtente.toString());
          FileLibMit.Close(fhand);
          /* If _tipo='W' */
          if (CPLib.eqr(_tipo,"W")) {
            /* Exec "Windows" Page 2:Page_2 */
            Page_2();
            /* ElseIf _tipo='L' */
          } else if (CPLib.eqr(_tipo,"L")) {
            /* Exec "Linux" Page 3:Page_3 */
            Page_3();
          } // End If
          // * --- Delete from cpwarn
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famesiti_elab",348,"0000006E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("SEMAFORO","?",0,0,m_cServer),m_cServer,"SEMAFORO")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("xxx","?",0,0,m_cServer),m_cServer,"xxx")+"";
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
          /* _nriga := 0 */
          _nriga = CPLib.Round(0,0);
          /* _filename := LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+LRTrim(gAzienda)+"/"+Strtran(LTrim(w_nomefile),'.p7m','.run') */
          _filename = CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.Strtran(CPLib.LTrim(w_nomefile),".p7m",".run");
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000073status;
          nTry00000073status = m_Sql.GetTransactionStatus();
          String cTry00000073msg;
          cTry00000073msg = m_Sql.TransactionErrorMessage();
          try {
            // Legge il file
            File _file =new File(CPLib.LRTrim(_filename));
            Scanner in = new Scanner(_file);
            // Read each line until end of file is reached
            while (in.hasNextLine()) {
              // Read an entire line, which contains all the details for 1 account
              _riga = in.nextLine();
            /* If Left(_riga,1)='0' */
            if (CPLib.eqr(CPLib.Left(_riga,1),"0")) {
              /* _protinvio := iif(Len(LRTrim(Substr(_riga,129,24))) > 0,LRTrim(Substr(_riga,129,24)),'') */
              _protinvio = (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(_riga,129,24))),0)?CPLib.LRTrim(CPLib.Substr(_riga,129,24)):"");
              /* _annoinvio := iif(Len(LRTrim(Substr(_riga,153,4))) > 0,Val(Substr(_riga,153,4)),0) */
              _annoinvio = CPLib.Round((CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(_riga,153,4))),0)?CPLib.Val(CPLib.Substr(_riga,153,4)):0),0);
            } // End If
            /* If Left(_riga,1)='1' */
            if (CPLib.eqr(CPLib.Left(_riga,1),"1")) {
              /* _nriga := _nriga + 1 */
              _nriga = CPLib.Round(_nriga+1,0);
              /* If w_nomsg='S' and Mod(_nriga,5000)=0 */
              if (CPLib.eqr(w_nomsg,"S") && CPLib.eqr(CPLib.Mod(_nriga,5000),0)) {
                /* gMsgProc := gMsgProc + "Sono state elaborate "+LRTrim(Str(_nriga,10,0)) + " segnalazioni" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_nriga,10,0))+" segnalazioni"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
              /* _unique := Substr(_riga,2,50) */
              _unique = CPLib.Substr(_riga,2,50);
              /* _tipoag := '' */
              _tipoag = "";
              /* _rapporto := '' */
              _rapporto = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unique,"C",50,0,m_cServer),m_cServer,_unique);
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _rapporto = Read_Cursor.GetString("RAPPORTO");
                _tipoag = Read_Cursor.GetString("TIPOAG");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_famesiti_elab returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _rapporto = "";
                _tipoag = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_rapporto) */
              if (CPLib.Empty(_rapporto)) {
                // * --- Read from opextrbo
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_cSql = "";
                m_cSql = m_cSql+"UNIQUER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_unique,"C",50,0,m_cServer),m_cServer,_unique);
                if (m_Ctx.IsSharedTemp("opextrbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _rapporto = Read_Cursor.GetString("RAPPORTO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_famesiti_elab returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _rapporto = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If not(Empty(_rapporto)) */
                if ( ! (CPLib.Empty(_rapporto))) {
                  /* _tipoag := '98' */
                  _tipoag = "98";
                } // End If
              } // End If
              /* _tipodoc := Substr(_riga,52,1) */
              _tipodoc = CPLib.Substr(_riga,52,1);
              /* If Empty(_rapporto) */
              if (CPLib.Empty(_rapporto)) {
                /* If w_nomsg='N' */
                if (CPLib.eqr(w_nomsg,"N")) {
                  /* If _tipodoc = '1' */
                  if (CPLib.eqr(_tipodoc,"1")) {
                    /* gMsgProc := gMsgProc + "Famiglia: "+LRTrim(_unique) + " - Non presente in archivio - 1 - La famiglia è stata scartata" +  NL // Log Messaggi */
                    gMsgProc = gMsgProc+"Famiglia: "+CPLib.LRTrim(_unique)+" - Non presente in archivio - 1 - La famiglia è stata scartata"+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* ElseIf _tipodoc = '0' */
                  } else if (CPLib.eqr(_tipodoc,"0")) {
                    /* gMsgProc := gMsgProc + "Famiglia: "+LRTrim(_unique) + " - Non presente in archivio - 0 - La famiglia presenta segnalazioni" +  NL // Log Messaggi */
                    gMsgProc = gMsgProc+"Famiglia: "+CPLib.LRTrim(_unique)+" - Non presente in archivio - 0 - La famiglia presenta segnalazioni"+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                } // End If
                /* _errore_testat :=  "Non presente in archivio" */
                _errore_testat = "Non presente in archivio";
              } else { // Else
                /* If w_nomsg='N' */
                if (CPLib.eqr(w_nomsg,"N")) {
                  /* If _tipodoc = '1' */
                  if (CPLib.eqr(_tipodoc,"1")) {
                    /* gMsgProc := gMsgProc + "Famiglia: "+LRTrim(_rapporto) + " - Tipo: "+_tipoag+ " - 1 - Il rapporto è stato scartato" +  NL // Log Messaggi */
                    gMsgProc = gMsgProc+"Famiglia: "+CPLib.LRTrim(_rapporto)+" - Tipo: "+_tipoag+" - 1 - Il rapporto è stato scartato"+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* ElseIf _tipodoc = '0' */
                  } else if (CPLib.eqr(_tipodoc,"0")) {
                    /* gMsgProc := gMsgProc + "Rapporto: "+LRTrim(_rapporto) + " - Tipo: "+_tipoag+ " - 0 - Il rapporto presenta segnalazioni" +  NL // Log Messaggi */
                    gMsgProc = gMsgProc+"Rapporto: "+CPLib.LRTrim(_rapporto)+" - Tipo: "+_tipoag+" - 0 - Il rapporto presenta segnalazioni"+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                } // End If
                /* _errore_testat :=  "Presente in archivio" */
                _errore_testat = "Presente in archivio";
              } // End If
              /* _esito := '' */
              _esito = "";
              for (int _z = 1; CPLib.ne(_z,7); _z = _z + (1)) {
                /* _coderrore := Substr(_riga,53+(16*(_z-1)),16) */
                _coderrore = CPLib.Substr(_riga,53+(16*(_z-1)),16);
                /* _esito := Left(_coderrore,3) */
                _esito = CPLib.Left(_coderrore,3);
                /* _codprot := Substr(_coderrore,4,13) */
                _codprot = CPLib.Substr(_coderrore,4,13);
                /* If not(Empty(LRTrim(_esito))) and _esito <> '000' */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_esito))) && CPLib.ne(_esito,"000")) {
                  /* _contaT := _contaT + 1 */
                  _contaT = CPLib.Round(_contaT+1,0);
                  /* _descesito := '' */
                  _descesito = "";
                  /* If _erresi.GoToKey(_esito) */
                  if (_erresi.GoToKey(_esito)) {
                    /* _descesito := _erresi.EEDESCRI */
                    _descesito = _erresi.row.EEDESCRI;
                  } // End If
                  // * --- Insert into tmp_esitosid from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitosid");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosid",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famesiti_elab",348,"0000009B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000009B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(_annoinvio,0)?_annoinvio:w_anno),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_contaT,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_unique,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_tipoag,"")?"X":(CPLib.eqr(_tipoag,"98")?"O":"R")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_esito,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codprot,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_errore_testat+"- "+_descesito,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_protinvio,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosid",true);
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
                  /* If not(Empty(_rapporto)) */
                  if ( ! (CPLib.Empty(_rapporto))) {
                    /* If _tipoag='98' */
                    if (CPLib.eqr(_tipoag,"98")) {
                      // * --- Write into opextrbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("opextrbo");
                      m_cPhName = m_Ctx.GetPhName("opextrbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_famesiti_elab",348,"0000009E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IDESITO = "+CPLib.ToSQL(_codprot,"C",13,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"UNIQUER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_unique,"?",0,0,m_cServer),m_cServer,_unique)+"";
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
                    } else { // Else
                      // * --- Write into aetesta from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aetesta");
                      m_cPhName = m_Ctx.GetPhName("aetesta");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_famesiti_elab",348,"0000009F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"IDESITOFAM = "+CPLib.ToSQL(_codprot,"C",24,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"UNIQUECODE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_unique,"?",0,0,m_cServer),m_cServer,_unique)+"";
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
                  } // End If
                } // End If
              }
            } // End If
            // Chiude il ciclo e il file
            }
            in.close();
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
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000073status,0)) {
              m_Sql.SetTransactionStatus(nTry00000073status,cTry00000073msg);
            }
          }
          /* gMsgProc := gMsgProc + 'PROCEDURA COMPLETATA.' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"PROCEDURA COMPLETATA."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'ELABORAZIONE TERMINATA.' // Messaggio Import */
          gMsgImp = "ELABORAZIONE TERMINATA.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          /* gMsgProc := gMsgProc + 'Impossibile Procedere' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Impossibile Procedere"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Procedura SID già in utilizzo da altro utente' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Procedura SID già in utilizzo da altro utente"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'PROCEDURA ABORTITA' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"PROCEDURA ABORTITA"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      try {
        if (Cursor_tbesielb!=null)
          Cursor_tbesielb.Close();
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
    }
  }
  void Page_2() throws Exception {
    /* Esegue SID Windows */
    /* _dir1 := '"'+LRTrim(_dirjava)+"\bin\java"+'"'  */
    _dir1 = "\""+CPLib.LRTrim(_dirjava)+"\\bin\\java"+"\"";
    // Provo a lanciare il batch
    try
    {
      File _mydir = new File(CPLib.LRTrim(_dirsid)+"/prog");
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.bat",CPLib.LRTrim(_dir1),"ARU00"};
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec(cmd,null,_mydir);
      // any error message?
      StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERRORE", m_Ctx);            
      // any output?
      StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", m_Ctx);
      // kick them off
      errorGobbler.start();
      outputGobbler.start();
      // any error???
      int exitVal = proc.waitFor();
      System.out.println("ExitValue: " + exitVal);     
    } catch (IOException ex) { 
      ex.printStackTrace();   
    }
  }
  void Page_3() throws Exception {
    /* Esegue SID Linux */
    // Provo a lanciare il batch
    try
    {
      File _mydir = new File(CPLib.LRTrim(_dirsid)+"/prog");
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java","ARU00"};
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec(cmd,null,_mydir);
      // any error message?
      StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERRORE", m_Ctx);            
      // any output?
      StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", m_Ctx);
      // kick them off
      errorGobbler.start();
      outputGobbler.start();
      // any error???
      int exitVal = proc.waitFor();
      System.out.println("ExitValue: " + exitVal);     
    } catch (IOException ex) { 
      ex.printStackTrace();   
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_nomefile,String p_w_nomsg) {
    w_nomefile = p_w_nomefile;
    w_nomsg = p_w_nomsg;
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
  public String Run(String p_w_nomefile,String p_w_nomsg) {
    w_nomefile = p_w_nomefile;
    w_nomsg = p_w_nomsg;
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
  public static arrt_famesiti_elabR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_famesiti_elabR(p_Ctx, p_Caller);
  }
  public static arrt_famesiti_elabR Make(CPContext p_Ctx) {
    return new arrt_famesiti_elabR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_nomefile = CPLib.Space(100);
    w_nomsg = CPLib.Space(1);
    fhand = CPLib.Space(1);
    _dir1 = CPLib.Space(180);
    _dir2 = CPLib.Space(180);
    _dir3 = CPLib.Space(180);
    _dir4 = CPLib.Space(180);
    _dirsid = CPLib.Space(250);
    _dirjava = CPLib.Space(250);
    _idsog = CPLib.Space(50);
    _pwdsog = CPLib.Space(50);
    _tipo = CPLib.Space(1);
    _riga = "";
    _fcfg = CPLib.Space(120);
    _idb = CPLib.Space(10);
    _semaforo = CPLib.Space(8);
    _risultato = CPLib.Space(3);
    _tiporis = CPLib.Space(20);
    _tipoelab = CPLib.Space(20);
    _fileesi = CPLib.Space(80);
    _filedgn = CPLib.Space(80);
    _protocollo = CPLib.Space(24);
    _tipodoc = CPLib.Space(1);
    _tfile = CPLib.Space(15);
    _tprog = CPLib.Space(25);
    _tfind = CPLib.Space(10);
    _filename = CPLib.Space(255);
    _erresi = new MemoryCursor_tbesielb();
    w_annorif = CPLib.Space(4);
    _wesito = 0;
    _fileorig = CPLib.Space(50);
    _nriga = 0;
    _rapporto = CPLib.Space(25);
    _invio = CPLib.Space(10);
    _unique = CPLib.Space(50);
    _tipoanom = CPLib.Space(1);
    _datoerr = CPLib.Space(16);
    _tipoag = CPLib.Space(2);
    _codelab = CPLib.Space(13);
    _contaT = 0;
    _descesito = "";
    _esito = CPLib.Space(3);
    _coderrore = CPLib.Space(16);
    _codprot = CPLib.Space(13);
    _protinvio = CPLib.Space(24);
    _annoinvio = 0;
    _errore_testat = CPLib.Space(70);
    w_anno = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_famesiti_elab,
  public static final String i_InvokedRoutines = ",arrt_famesiti_elab,";
  public static String[] m_cRunParameterNames={"w_nomefile","w_nomsg"};
  protected static String GetFieldsName_0000004B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORIGA,";
    p_cSql = p_cSql+"CODERR,";
    p_cSql = p_cSql+"DATOERR,";
    p_cSql = p_cSql+"TXTMSG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosid",true);
    return p_cSql;
  }
}
