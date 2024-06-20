// * --- Area Manuale = BO - Header
// * --- arrt_ricevute_sid
import java.io.*;
import java.util.Scanner;
// * --- Fine Area Manuale
public class arrt_ricevute_sidR implements CallerWithObjs {
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
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_tberrorisid;
  public String m_cServer_tberrorisid;
  public String m_cPhName_tberrsiddgn;
  public String m_cServer_tberrsiddgn;
  public String m_cPhName_tbricevutesid;
  public String m_cServer_tbricevutesid;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_tmp_esitosid;
  public String m_cServer_tmp_esitosid;
  public String m_cPhName_tberrdge;
  public String m_cServer_tberrdge;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aeinvio;
  public String m_cServer_aeinvio;
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
  public double w_anno;
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
  public String _categsid;
  public String _descrsid;
  public String _azionesid;
  public String _fileesi;
  public String _filedgn;
  public String _protocollo;
  public String _fileprot;
  public String _filename1;
  public String _filename2;
  public String _tipodoc;
  public String _terna;
  public String _tfile;
  public String _tprog;
  public String _tfind;
  public String _filename;
  public double _contaB;
  public double _contaC;
  public double _contaT;
  public double _contaI;
  public MemoryCursor_tberrdge _errdge;
  public MemoryCursorRow_tberrdge _rowerr;
  public String w_annorif;
  public double _wesito;
  public String _fileorig;
  public double _nriga;
  public String _rapporto;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_ricevute_sidR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_ricevute_sid",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_tberrorisid = p_ContextObject.GetPhName("tberrorisid");
    if (m_cPhName_tberrorisid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrorisid = m_cPhName_tberrorisid+" "+m_Ctx.GetWritePhName("tberrorisid");
    }
    m_cServer_tberrorisid = p_ContextObject.GetServer("tberrorisid");
    m_cPhName_tberrsiddgn = p_ContextObject.GetPhName("tberrsiddgn");
    if (m_cPhName_tberrsiddgn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrsiddgn = m_cPhName_tberrsiddgn+" "+m_Ctx.GetWritePhName("tberrsiddgn");
    }
    m_cServer_tberrsiddgn = p_ContextObject.GetServer("tberrsiddgn");
    m_cPhName_tbricevutesid = p_ContextObject.GetPhName("tbricevutesid");
    if (m_cPhName_tbricevutesid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbricevutesid = m_cPhName_tbricevutesid+" "+m_Ctx.GetWritePhName("tbricevutesid");
    }
    m_cServer_tbricevutesid = p_ContextObject.GetServer("tbricevutesid");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosid")) {
      m_cPhName_tmp_esitosid = p_ContextObject.GetPhName("tmp_esitosid");
      if (m_cPhName_tmp_esitosid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_esitosid = m_cPhName_tmp_esitosid+" "+m_Ctx.GetWritePhName("tmp_esitosid");
      }
      m_cServer_tmp_esitosid = p_ContextObject.GetServer("tmp_esitosid");
    }
    m_cPhName_tberrdge = p_ContextObject.GetPhName("tberrdge");
    if (m_cPhName_tberrdge.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrdge = m_cPhName_tberrdge+" "+m_Ctx.GetWritePhName("tberrdge");
    }
    m_cServer_tberrdge = p_ContextObject.GetServer("tberrdge");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aeinvio = p_ContextObject.GetPhName("aeinvio");
    if (m_cPhName_aeinvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeinvio = m_cPhName_aeinvio+" "+m_Ctx.GetWritePhName("aeinvio");
    }
    m_cServer_aeinvio = p_ContextObject.GetServer("aeinvio");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_contaB",p_cVarName)) {
      return _contaB;
    }
    if (CPLib.eqr("_contaC",p_cVarName)) {
      return _contaC;
    }
    if (CPLib.eqr("_contaT",p_cVarName)) {
      return _contaT;
    }
    if (CPLib.eqr("_contaI",p_cVarName)) {
      return _contaI;
    }
    if (CPLib.eqr("_wesito",p_cVarName)) {
      return _wesito;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_ricevute_sid";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
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
    if (CPLib.eqr("_categsid",p_cVarName)) {
      return _categsid;
    }
    if (CPLib.eqr("_descrsid",p_cVarName)) {
      return _descrsid;
    }
    if (CPLib.eqr("_azionesid",p_cVarName)) {
      return _azionesid;
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
    if (CPLib.eqr("_fileprot",p_cVarName)) {
      return _fileprot;
    }
    if (CPLib.eqr("_filename1",p_cVarName)) {
      return _filename1;
    }
    if (CPLib.eqr("_filename2",p_cVarName)) {
      return _filename2;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_terna",p_cVarName)) {
      return _terna;
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
    if (CPLib.eqr("_errdge",p_cVarName)) {
      return _errdge;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_rowerr",p_cVarName)) {
      return _rowerr;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_contaB",p_cVarName)) {
      _contaB = value;
      return;
    }
    if (CPLib.eqr("_contaC",p_cVarName)) {
      _contaC = value;
      return;
    }
    if (CPLib.eqr("_contaT",p_cVarName)) {
      _contaT = value;
      return;
    }
    if (CPLib.eqr("_contaI",p_cVarName)) {
      _contaI = value;
      return;
    }
    if (CPLib.eqr("_wesito",p_cVarName)) {
      _wesito = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
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
    if (CPLib.eqr("_categsid",p_cVarName)) {
      _categsid = value;
      return;
    }
    if (CPLib.eqr("_descrsid",p_cVarName)) {
      _descrsid = value;
      return;
    }
    if (CPLib.eqr("_azionesid",p_cVarName)) {
      _azionesid = value;
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
    if (CPLib.eqr("_fileprot",p_cVarName)) {
      _fileprot = value;
      return;
    }
    if (CPLib.eqr("_filename1",p_cVarName)) {
      _filename1 = value;
      return;
    }
    if (CPLib.eqr("_filename2",p_cVarName)) {
      _filename2 = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("_terna",p_cVarName)) {
      _terna = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("_rowerr",p_cVarName)) {
      _rowerr = (MemoryCursorRow_tberrdge)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("_errdge",p_cVarName)) {
      _errdge = (MemoryCursor_tberrdge)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tberrdge=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_tot_annoora=null;
    CPResultSet Cursor_aesaldi=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_nomefile Char(100) */
      /* w_anno Numeric(4, 0) */
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
      /* _categsid Char(15) */
      /* _descrsid Char(100) */
      /* _azionesid Char(100) */
      /* _fileesi Char(80) */
      /* _filedgn Char(80) */
      /* _protocollo Char(24) */
      /* _fileprot Char(50) */
      /* _filename1 Char(50) */
      /* _filename2 Char(50) */
      /* _tipodoc Char(1) */
      /* _terna Char(56) */
      /* _tfile Char(15) */
      /* _tprog Char(25) */
      /* _tfind Char(10) */
      /* _filename Char(255) */
      /* _contaB Numeric(10, 0) */
      /* _contaC Numeric(10, 0) */
      /* _contaT Numeric(10, 0) */
      /* _contaI Numeric(10, 0) */
      /* _errdge MemoryCursor(tberrdge) */
      /* _rowerr Row(tberrdge) */
      /* w_annorif Char(4) */
      /* _wesito Numeric(1, 0) */
      /* _fileorig Char(50) */
      /* _nriga Numeric(10, 0) */
      /* _rapporto Char(25) */
      /* gMsgProc := gMsgProc + 'Inizio Elaborazione SID'+ NL // Log Messaggi */
      gMsgProc = gMsgProc+"Inizio Elaborazione SID"+"\n";
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
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _semaforo = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Select from tberrdge
      m_cServer = m_Ctx.GetServer("tberrdge");
      m_cPhName = m_Ctx.GetPhName("tberrdge");
      if (Cursor_tberrdge!=null)
        Cursor_tberrdge.Close();
      Cursor_tberrdge = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tberrdge")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tberrdge.Eof())) {
        /* _rowerr.DGECODICE := tberrdge->DGECODICE */
        _rowerr.DGECODICE = Cursor_tberrdge.GetString("DGECODICE");
        /* _rowerr.DGEDESCRI := tberrdge->DGEDESCRI */
        _rowerr.DGEDESCRI = Cursor_tberrdge.GetString("DGEDESCRI");
        /* _rowerr.DGEAZIONE := tberrdge->DGEAZIONE */
        _rowerr.DGEAZIONE = Cursor_tberrdge.GetString("DGEAZIONE");
        /* _rowerr.DGECONSEG := tberrdge->DGECONSEG */
        _rowerr.DGECONSEG = Cursor_tberrdge.GetString("DGECONSEG");
        /* _errdge.AppendRowWithKey(tberrdge->DGECODICE,_rowerr) */
        _errdge.AppendRowWithKey(Cursor_tberrdge.GetString("DGECODICE"),_rowerr);
        Cursor_tberrdge.Next();
      }
      m_cConnectivityError = Cursor_tberrdge.ErrorMessage();
      Cursor_tberrdge.Close();
      // * --- End Select
      /* If Empty(LRTrim(_semaforo)) */
      if (CPLib.Empty(CPLib.LRTrim(_semaforo))) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"00000044")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000044(m_Ctx,m_oWrInfo);
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
        /* If At(LRTrim(w_nomefile),fl3[_i].getName()) = 0 */
        if (CPLib.eqr(CPLib.At(CPLib.LRTrim(w_nomefile),fl3[_i].getName()),0)) {
          /* fl3[_i].delete() */
          fl3[_i].delete();
        } // End If
        /* } */
        };
        /* _dirsid := gPathApp+"/SID/SID_STD" */
        _dirsid = gPathApp+"/SID/SID_STD";
        /* _dir1 := LRTrim("ARG1 " +LRTrim(gPathDoc)+"/SID/RICEVUTE/ELB/"+LRTrim(gAzienda)) */
        _dir1 = CPLib.LRTrim("ARG1 "+CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ELB/"+CPLib.LRTrim(gAzienda));
        /* _dir2 := LRTrim("ARG2 " +LRTrim(gPathDoc)+"/SID/RICEVUTE/ESI/"+LRTrim(gAzienda)) */
        _dir2 = CPLib.LRTrim("ARG2 "+CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ESI/"+CPLib.LRTrim(gAzienda));
        /* _dir3 := LRTrim("ARG3 " +LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+LRTrim(gAzienda)) */
        _dir3 = CPLib.LRTrim("ARG3 "+CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+CPLib.LRTrim(gAzienda));
        /* _dir4 := LRTrim("ARG4 " +LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)) */
        _dir4 = CPLib.LRTrim("ARG4 "+CPLib.LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda));
        /* _fcfg := '/SID/SID_STD/config/ricevute.cfg' */
        _fcfg = "/SID/SID_STD/config/ricevute.cfg";
        /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
        fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
        // Scrive il file Ricevute CFG
        FileLibMit.WriteLine(fhand,"###############################################################################");
        FileLibMit.WriteLine(fhand,"### Commenti:");
        FileLibMit.WriteLine(fhand,"### l'identificativo di ogni parametro (ARG1, ARG2, etc.)non deve essere modificato; ");
        FileLibMit.WriteLine(fhand,"### lasciare uno spazio tra l'dentificativo del parametro (ARG1, ARG2, etc.)ed il ");
        FileLibMit.WriteLine(fhand,"### parametro stesso. ");
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file di ricevute da elaborare");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir1);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file degli esiti derivanti dalle operazioni di elaborazione delle ricevute");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir2);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella che conterrà i file di ricevute elaborati ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir3);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare la cartella contenente i certificati di firma e di cifra ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir4);
        FileLibMit.WriteLine(fhand,"##");
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
        /* _dir1 := "ARG1" */
        _dir1 = "ARG1";
        /* _dir2 := "ARG2" */
        _dir2 = "ARG2";
        /* _dir3 := "ARG3" */
        _dir3 = "ARG3";
        /* _dir4 := "ARG4" */
        _dir4 = "ARG4";
        /* _fcfg := '/SID/SID_STD/config/ricevute.cfg' */
        _fcfg = "/SID/SID_STD/config/ricevute.cfg";
        /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
        fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
        // Scrive il file Ricevute CFG Originale
        FileLibMit.WriteLine(fhand,"###############################################################################");
        FileLibMit.WriteLine(fhand,"### Commenti:");
        FileLibMit.WriteLine(fhand,"### l'identificativo di ogni parametro (ARG1, ARG2, etc.)non deve essere modificato; ");
        FileLibMit.WriteLine(fhand,"### lasciare uno spazio tra l'dentificativo del parametro (ARG1, ARG2, etc.)ed il ");
        FileLibMit.WriteLine(fhand,"### parametro stesso. ");
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file di ricevute da elaborare");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir1);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file degli esiti derivanti dalle operazioni di elaborazione delle ricevute");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir2);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella che conterrà i file di ricevute elaborati ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir3);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare la cartella contenente i certificati di firma e di cifra ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir4);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.Close(fhand);
        // * --- Delete from cpwarn
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"0000006A")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // Legge il file
        File _file =new File(CPLib.LRTrim(_filename));
        Scanner in = new Scanner(_file);
        // Read each line until end of file is reached
        while (in.hasNextLine()) {
          // Read an entire line, which contains all the details for 1 account
          _riga = in.nextLine();
        /* If Left(_riga,1)='B' */
        if (CPLib.eqr(CPLib.Left(_riga,1),"B")) {
          /* _contaB := _contaB + 1 */
          _contaB = CPLib.Round(_contaB+1,0);
          /* ElseIf Left(_riga,1)='C' */
        } else if (CPLib.eqr(CPLib.Left(_riga,1),"C")) {
          /* _contaC := _contaC + 1 */
          _contaC = CPLib.Round(_contaC+1,0);
        } // End If
        /* _contaT := _contaT + 1 */
        _contaT = CPLib.Round(_contaT+1,0);
        // Chiude il ciclo e il file
        }
        in.close();
        /* _contaI := 0 */
        _contaI = CPLib.Round(0,0);
        // * --- Select from qbe_tot_annoora
        SPBridge.HMCaller _h00000075;
        _h00000075 = new SPBridge.HMCaller();
        _h00000075.Set("m_cVQRList",m_cVQRList);
        _h00000075.Set("annorif",w_annorif);
        if (Cursor_qbe_tot_annoora!=null)
          Cursor_qbe_tot_annoora.Close();
        Cursor_qbe_tot_annoora = new VQRHolder("qbe_tot_annoora",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000075,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tot_annoora.Eof())) {
          /* _contaI := qbe_tot_annoora->TOTALE */
          _contaI = CPLib.Round(Cursor_qbe_tot_annoora.GetDouble("TOTALE"),0);
          Cursor_qbe_tot_annoora.Next();
        }
        m_cConnectivityError = Cursor_qbe_tot_annoora.ErrorMessage();
        Cursor_qbe_tot_annoora.Close();
        // * --- End Select
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000078status;
        nTry00000078status = m_Sql.GetTransactionStatus();
        String cTry00000078msg;
        cTry00000078msg = m_Sql.TransactionErrorMessage();
        try {
          // Legge il file
          in = new Scanner(_file);
          // Read each line until end of file is reached
          while (in.hasNextLine()) {
            // Read an entire line, which contains all the details for 1 account
            _riga = in.nextLine();
          /* _nriga := _nriga + 1 */
          _nriga = CPLib.Round(_nriga+1,0);
          /* If Left(_riga,1)='A' */
          if (CPLib.eqr(CPLib.Left(_riga,1),"A")) {
            /* _tipodoc := Substr(_riga,2,1) */
            _tipodoc = CPLib.Substr(_riga,2,1);
            /* If Substr(_riga,2,1) = '1' */
            if (CPLib.eqr(CPLib.Substr(_riga,2,1),"1")) {
              /* If Substr(_riga,3,1)='1' */
              if (CPLib.eqr(CPLib.Substr(_riga,3,1),"1")) {
                /* gMsgProc := gMsgProc + "1 - Assenza di errori formali nella comunicazione. Fornitura Accettata" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"1 - Assenza di errori formali nella comunicazione. Fornitura Accettata"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* ElseIf Substr(_riga,3,1)='2' */
              } else if (CPLib.eqr(CPLib.Substr(_riga,3,1),"2")) {
                /* gMsgProc := gMsgProc + "2 - Presenza di errori formali nella comunicazione. Fornitura scartata" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"2 - Presenza di errori formali nella comunicazione. Fornitura scartata"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
              /* ElseIf Substr(_riga,2,1) = '2' */
            } else if (CPLib.eqr(CPLib.Substr(_riga,2,1),"2")) {
              /* If Substr(_riga,3,1)='1' */
              if (CPLib.eqr(CPLib.Substr(_riga,3,1),"1")) {
                /* gMsgProc := gMsgProc + "1 - La comunicazione è stata correttamente presentata" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"1 - La comunicazione è stata correttamente presentata"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _risultato := Substr(_riga,4,3) */
                _risultato = CPLib.Substr(_riga,4,3);
                /* _protocollo := Substr(_riga,7,24) */
                _protocollo = CPLib.Substr(_riga,7,24);
                /* _fileprot := Substr(_riga,31,50) */
                _fileprot = CPLib.Substr(_riga,31,50);
                /* _fileorig := '' */
                _fileorig = "";
                /* _filename1 := Strtran(_fileprot,'ATZB','ATB1') */
                _filename1 = CPLib.Strtran(_fileprot,"ATZB","ATB1");
                /* _filename2 := Strtran(_fileprot,'ATZB','ATB2') */
                _filename2 = CPLib.Strtran(_fileprot,"ATZB","ATB2");
                // * --- Select from aesaldi
                m_cServer = m_Ctx.GetServer("aesaldi");
                m_cPhName = m_Ctx.GetPhName("aesaldi");
                if (Cursor_aesaldi!=null)
                  Cursor_aesaldi.Close();
                Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(FILEINV1="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename1,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename1)+"  or  FILEINV2="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename2,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename2)+")  and  TIPO='4' "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aesaldi.Eof())) {
                  /* _fileorig := aesaldi->NOMEFILE */
                  _fileorig = Cursor_aesaldi.GetString("NOMEFILE");
                  Cursor_aesaldi.Next();
                }
                m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
                Cursor_aesaldi.Close();
                // * --- End Select
                // * --- Read from tbricevutesid
                m_cServer = m_Ctx.GetServer("tbricevutesid");
                m_cPhName = m_Ctx.GetPhName("tbricevutesid");
                m_cSql = "";
                m_cSql = m_cSql+"ESICODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_risultato,"C",3,0,m_cServer),m_cServer,_risultato);
                if (m_Ctx.IsSharedTemp("tbricevutesid")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ESIDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descrsid = Read_Cursor.GetString("ESIDESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbricevutesid into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descrsid = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* gMsgProc := gMsgProc + 'ESITO:'+_risultato + " - " +_descrsid + NL // Log Messaggi */
                gMsgProc = gMsgProc+"ESITO:"+_risultato+" - "+_descrsid+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + 'PROTOCOLLO:'+_protocollo + NL // Log Messaggi */
                gMsgProc = gMsgProc+"PROTOCOLLO:"+_protocollo+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + 'FILE PROTOCOLLATO:'+_fileprot + NL // Log Messaggi */
                gMsgProc = gMsgProc+"FILE PROTOCOLLATO:"+_fileprot+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* ElseIf Substr(_riga,3,1)='2' */
              } else if (CPLib.eqr(CPLib.Substr(_riga,3,1),"2")) {
                /* gMsgProc := gMsgProc + "2 - La comunicazione è stata scartata" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"2 - La comunicazione è stata scartata"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _risultato := Substr(_riga,4,3) */
                _risultato = CPLib.Substr(_riga,4,3);
                /* _protocollo := Substr(_riga,7,24) */
                _protocollo = CPLib.Substr(_riga,7,24);
                /* _fileprot := Substr(_riga,31,50) */
                _fileprot = CPLib.Substr(_riga,31,50);
                /* _fileorig := '' */
                _fileorig = "";
                /* _filename1 := Strtran(_fileprot,'ATZB','ATB1') */
                _filename1 = CPLib.Strtran(_fileprot,"ATZB","ATB1");
                /* _filename2 := Strtran(_fileprot,'ATZB','ATB2') */
                _filename2 = CPLib.Strtran(_fileprot,"ATZB","ATB2");
                // * --- Select from aesaldi
                m_cServer = m_Ctx.GetServer("aesaldi");
                m_cPhName = m_Ctx.GetPhName("aesaldi");
                if (Cursor_aesaldi!=null)
                  Cursor_aesaldi.Close();
                Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"FILEINV1="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename1,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename1)+"  or  FILEINV2="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename2,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename2)+" "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aesaldi.Eof())) {
                  /* _fileorig := aesaldi->NOMEFILE */
                  _fileorig = Cursor_aesaldi.GetString("NOMEFILE");
                  Cursor_aesaldi.Next();
                }
                m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
                Cursor_aesaldi.Close();
                // * --- End Select
                // * --- Read from tbricevutesid
                m_cServer = m_Ctx.GetServer("tbricevutesid");
                m_cPhName = m_Ctx.GetPhName("tbricevutesid");
                m_cSql = "";
                m_cSql = m_cSql+"ESICODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_risultato,"C",3,0,m_cServer),m_cServer,_risultato);
                if (m_Ctx.IsSharedTemp("tbricevutesid")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ESIDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descrsid = Read_Cursor.GetString("ESIDESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbricevutesid into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descrsid = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* gMsgProc := gMsgProc + 'ESITO:'+_risultato + " - " +_descrsid + NL // Log Messaggi */
                gMsgProc = gMsgProc+"ESITO:"+_risultato+" - "+_descrsid+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + 'PROTOCOLLO:'+_protocollo + NL // Log Messaggi */
                gMsgProc = gMsgProc+"PROTOCOLLO:"+_protocollo+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + 'FILE PROTOCOLLATO:'+_fileprot + NL // Log Messaggi */
                gMsgProc = gMsgProc+"FILE PROTOCOLLATO:"+_fileprot+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
              /* ElseIf Substr(_riga,2,1) = '3' */
            } else if (CPLib.eqr(CPLib.Substr(_riga,2,1),"3")) {
              /* If Substr(_riga,3,1)='1' */
              if (CPLib.eqr(CPLib.Substr(_riga,3,1),"1")) {
                /* gMsgProc := gMsgProc + "1 - La comunicazione è stata correttamente presentata" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"1 - La comunicazione è stata correttamente presentata"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* ElseIf Substr(_riga,3,1)='2' */
              } else if (CPLib.eqr(CPLib.Substr(_riga,3,1),"2")) {
                /* gMsgProc := gMsgProc + "2 - Le informazioni contenute nella comunicazione non sono coerenti con la banca dati dell’Anagrafe dei rapporti finanziari" +  NL // Log Messaggi */
                gMsgProc = gMsgProc+"2 - Le informazioni contenute nella comunicazione non sono coerenti con la banca dati dell\u2019Anagrafe dei rapporti finanziari"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _risultato := Substr(_riga,4,3) */
                _risultato = CPLib.Substr(_riga,4,3);
                /* _protocollo := Substr(_riga,7,24) */
                _protocollo = CPLib.Substr(_riga,7,24);
                /* _fileprot := Substr(_riga,31,50) */
                _fileprot = CPLib.Substr(_riga,31,50);
                /* _fileorig := '' */
                _fileorig = "";
                /* _filename1 := Strtran(_fileprot,'ATZB','ATB1') */
                _filename1 = CPLib.Strtran(_fileprot,"ATZB","ATB1");
                /* _filename2 := Strtran(_fileprot,'ATZB','ATB2') */
                _filename2 = CPLib.Strtran(_fileprot,"ATZB","ATB2");
                // * --- Select from aesaldi
                m_cServer = m_Ctx.GetServer("aesaldi");
                m_cPhName = m_Ctx.GetPhName("aesaldi");
                if (Cursor_aesaldi!=null)
                  Cursor_aesaldi.Close();
                Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(FILEINV1="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename1,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename1)+"  or  FILEINV2="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename2,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename2)+")  and  TIPO='4' "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aesaldi.Eof())) {
                  /* _fileorig := aesaldi->NOMEFILE */
                  _fileorig = Cursor_aesaldi.GetString("NOMEFILE");
                  Cursor_aesaldi.Next();
                }
                m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
                Cursor_aesaldi.Close();
                // * --- End Select
                // * --- Read from tbricevutesid
                m_cServer = m_Ctx.GetServer("tbricevutesid");
                m_cPhName = m_Ctx.GetPhName("tbricevutesid");
                m_cSql = "";
                m_cSql = m_cSql+"ESICODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_risultato,"C",3,0,m_cServer),m_cServer,_risultato);
                if (m_Ctx.IsSharedTemp("tbricevutesid")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ESIDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descrsid = Read_Cursor.GetString("ESIDESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbricevutesid into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descrsid = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* gMsgProc := gMsgProc + 'ESITO:'+_risultato + " - " +_descrsid + NL // Log Messaggi */
                gMsgProc = gMsgProc+"ESITO:"+_risultato+" - "+_descrsid+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + 'PROTOCOLLO:'+_protocollo + NL // Log Messaggi */
                gMsgProc = gMsgProc+"PROTOCOLLO:"+_protocollo+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc + 'FILE PROTOCOLLATO:'+_fileprot + NL // Log Messaggi */
                gMsgProc = gMsgProc+"FILE PROTOCOLLATO:"+_fileprot+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
            } // End If
            // * --- Insert into tmp_esitosid from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_esitosid");
            m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosid",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000AE(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nriga,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
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
            /* ElseIf Left(_riga,1)='B' */
          } else if (CPLib.eqr(CPLib.Left(_riga,1),"B")) {
            /* _contaB := _contaB + 1 */
            _contaB = CPLib.Round(_contaB+1,0);
            /* _risultato := Substr(_riga,2,3) */
            _risultato = CPLib.Substr(_riga,2,3);
            /* _errdge.GoToKey(_risultato) */
            _errdge.GoToKey(_risultato);
            /* _descrsid := _errdge.DGEDESCRI */
            _descrsid = _errdge.row.DGEDESCRI;
            /* _azionesid := _errdge.DGEAZIONE */
            _azionesid = _errdge.row.DGEAZIONE;
            /* _wesito := 0 */
            _wesito = CPLib.Round(0,0);
            /* _idb := '' */
            _idb = "";
            /* _rapporto := '' */
            _rapporto = "";
            // * --- Read from aeannora
            m_cServer = m_Ctx.GetServer("aeannora");
            m_cPhName = m_Ctx.GetPhName("aeannora");
            m_cSql = "";
            m_cSql = m_cSql+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_annorif,"C",4,0,m_cServer),m_cServer,w_annorif);
            m_cSql = m_cSql+" and PROG1="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,15,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(_riga,15,10));
            m_cSql = m_cSql+" and FILEANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_fileorig,"C",50,0,m_cServer),m_cServer,_fileorig);
            if (m_Ctx.IsSharedTemp("aeannora")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _idb = Read_Cursor.GetString("IDBASE");
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aeannora into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _idb = "";
              _rapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_idb))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_idb)))) {
              // * --- Write into aeannora from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeannora");
              m_cPhName = m_Ctx.GetPhName("aeannora");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000B9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ESITOANNO = "+CPLib.ToSQL(CPLib.Substr(_riga,33,10),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_annorif,"?",0,0,m_cServer),m_cServer,w_annorif)+"";
              m_cSql = m_cSql+" and PROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,15,10),"?",0,0,m_cServer),m_cServer,CPLib.Substr(_riga,15,10))+"";
              m_cSql = m_cSql+" and PROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,25,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(_riga,25,5))+"";
              m_cSql = m_cSql+" and FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_fileorig,"?",0,0,m_cServer),m_cServer,_fileorig)+"";
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
              /* _wesito := 1 */
              _wesito = CPLib.Round(1,0);
            } // End If
            /* If _wesito=0 */
            if (CPLib.eqr(_wesito,0)) {
              // * --- Read from aeoprig
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_cSql = "";
              m_cSql = m_cSql+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_annorif,"C",4,0,m_cServer),m_cServer,w_annorif);
              m_cSql = m_cSql+" and PROG1="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,15,10),"C",10,0,m_cServer),m_cServer,CPLib.Substr(_riga,15,10));
              m_cSql = m_cSql+" and PROG2="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,25,5),"C",5,0,m_cServer),m_cServer,CPLib.Substr(_riga,25,5));
              m_cSql = m_cSql+" and FILEANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_fileorig,"C",50,0,m_cServer),m_cServer,_fileorig);
              if (m_Ctx.IsSharedTemp("aeoprig")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _idb = Read_Cursor.GetString("IDBASE");
                _rapporto = Read_Cursor.GetString("CONNESINT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _idb = "";
                _rapporto = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Write into aeoprig from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000BD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ESITOANNO = "+CPLib.ToSQL(CPLib.Substr(_riga,33,10),"C",10,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_annorif,"?",0,0,m_cServer),m_cServer,w_annorif)+"";
              m_cSql = m_cSql+" and PROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,15,10),"?",0,0,m_cServer),m_cServer,CPLib.Substr(_riga,15,10))+"";
              m_cSql = m_cSql+" and PROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,25,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(_riga,25,5))+"";
              m_cSql = m_cSql+" and FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_fileorig,"?",0,0,m_cServer),m_cServer,_fileorig)+"";
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
              /* _wesito := 1 */
              _wesito = CPLib.Round(1,0);
            } // End If
            // * --- Write into aeinvio from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeinvio");
            m_cPhName = m_Ctx.GetPhName("aeinvio");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000BF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ESITOANNO = "+CPLib.ToSQL(CPLib.Substr(_riga,33,10),"C",10,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeinvio",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_annorif,"?",0,0,m_cServer),m_cServer,w_annorif)+"";
            m_cSql = m_cSql+" and PROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,15,10),"?",0,0,m_cServer),m_cServer,CPLib.Substr(_riga,15,10))+"";
            m_cSql = m_cSql+" and PROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,25,5),"?",0,0,m_cServer),m_cServer,CPLib.Substr(_riga,25,5))+"";
            m_cSql = m_cSql+" and FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_fileorig,"?",0,0,m_cServer),m_cServer,_fileorig)+"";
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
            // * --- Insert into tmp_esitosid from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_esitosid");
            m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosid",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000C0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nriga,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Left(_riga,1),"A")?"ESITO:":"ERRORE: ")+CPLib.LRTrim(_risultato)+" - "+CPLib.LRTrim(_descrsid)+" - "+CPLib.LRTrim(_azionesid)+"\n"+"Tipo Riga: "+CPLib.Substr(_riga,5,1)+" - N. Record: "+CPLib.Substr(_riga,6,9)+" - Campo Riferimento:"+CPLib.Substr(_riga,30,3)+" - Area 1:"+CPLib.Substr(_riga,15,10)+" - Area 2:"+CPLib.Substr(_riga,25,5),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
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
            /* gMsgImp := 'Tipo Riga: '+Substr(_riga,5,1)+' - N. Record: '+Substr(_riga,6,9) +' - Campo Riferimento:'+Substr(_riga,30,3) // Messaggio Import */
            gMsgImp = "Tipo Riga: "+CPLib.Substr(_riga,5,1)+" - N. Record: "+CPLib.Substr(_riga,6,9)+" - Campo Riferimento:"+CPLib.Substr(_riga,30,3);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* ElseIf Left(_riga,1)='C' */
          } else if (CPLib.eqr(CPLib.Left(_riga,1),"C")) {
            /* _contaC := _contaC + 1 */
            _contaC = CPLib.Round(_contaC+1,0);
            /* _risultato := Substr(_riga,2,3) */
            _risultato = CPLib.Substr(_riga,2,3);
            /* _errdge.GoToKey(_risultato) */
            _errdge.GoToKey(_risultato);
            /* _descrsid := _errdge.DGEDESCRI */
            _descrsid = _errdge.row.DGEDESCRI;
            /* _azionesid := _errdge.DGEAZIONE */
            _azionesid = _errdge.row.DGEAZIONE;
            /* _terna := Substr(_riga,5,56) */
            _terna = CPLib.Substr(_riga,5,56);
            /* Exec "Legge la terna e aggiorna l'esito" Page 4:Page_4 */
            Page_4();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* gMsgImp := 'Terna: '+Substr(_riga,5,56) // Messaggio Import */
            gMsgImp = "Terna: "+CPLib.Substr(_riga,5,56);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Insert into tmp_esitosid from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_esitosid");
            m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosid",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000CA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000CA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nriga,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Left(_riga,1),"A")?"ESITO:":"ERRORE: ")+CPLib.LRTrim(_risultato)+" - "+CPLib.LRTrim(_descrsid)+" - "+CPLib.LRTrim(_azionesid)+"\n"+"Terna: "+CPLib.Substr(_riga,5,56),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
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
          } // End If
          /* _contaT := _contaT + 1 */
          _contaT = CPLib.Round(_contaT+1,0);
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
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000078status,0)) {
            m_Sql.SetTransactionStatus(nTry00000078status,cTry00000078msg);
          }
        }
        /* If _contaB > 15 or (_contaB=_contaI and _contaB > 0) */
        if (CPLib.gt(_contaB,15) || (CPLib.eqr(_contaB,_contaI) && CPLib.gt(_contaB,0))) {
          /* gMsgProc := gMsgProc + 'Errorre 555 - Univocità del codice non verificata' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Errorre 555 - Univocità del codice non verificata"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Utilizzare apposita procedura nel menu 8.05' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Utilizzare apposita procedura nel menu 8.05"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + "Record B " + LRTrim(Str(_contaB,10,0)) + " Record C " + LRTrim(Str(_contaC,10,0)) + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Record B "+CPLib.LRTrim(CPLib.Str(_contaB,10,0))+" Record C "+CPLib.LRTrim(CPLib.Str(_contaC,10,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If _tipodoc = '2' */
        if (CPLib.eqr(_tipodoc,"2")) {
          /* _filename1 := Strtran(_fileprot,'ATZB','ATB1') */
          _filename1 = CPLib.Strtran(_fileprot,"ATZB","ATB1");
          /* _filename2 := Strtran(_fileprot,'ATZB','ATB2') */
          _filename2 = CPLib.Strtran(_fileprot,"ATZB","ATB2");
          // * --- Select from aesaldi
          m_cServer = m_Ctx.GetServer("aesaldi");
          m_cPhName = m_Ctx.GetPhName("aesaldi");
          if (Cursor_aesaldi!=null)
            Cursor_aesaldi.Close();
          Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"FILEINV1="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename1,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename1)+"  or  FILEINV2="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename2,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename2)+" "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aesaldi.Eof())) {
            // * --- Write into aesaldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aesaldi");
            m_cPhName = m_Ctx.GetPhName("aesaldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000D8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"PROTOCOLLO = "+CPLib.ToSQL(_protocollo,"C",24,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
            m_cSql = m_cSql+" and NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aesaldi.GetString("NOMEFILE"),"?",0,0,m_cServer),m_cServer,Cursor_aesaldi.GetString("NOMEFILE"))+"";
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
            // * --- Insert into aesaldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aesaldi");
            m_cPhName = m_Ctx.GetPhName("aesaldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aesaldi.GetString("NOMEFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aesaldi",true);
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
            Cursor_aesaldi.Next();
          }
          m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
          Cursor_aesaldi.Close();
          // * --- End Select
        } else { // Else
          /* _filename1 := Strtran(_fileprot,'ATZB','ATB1') */
          _filename1 = CPLib.Strtran(_fileprot,"ATZB","ATB1");
          /* _filename2 := Strtran(_fileprot,'ATZB','ATB2') */
          _filename2 = CPLib.Strtran(_fileprot,"ATZB","ATB2");
          // * --- Select from aesaldi
          m_cServer = m_Ctx.GetServer("aesaldi");
          m_cPhName = m_Ctx.GetPhName("aesaldi");
          if (Cursor_aesaldi!=null)
            Cursor_aesaldi.Close();
          Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(FILEINV1="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename1,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename1)+"  or  FILEINV2="+CPSql.SQLValueAdapter(CPLib.ToSQL(_filename2,"?",0,0,m_cServer, m_oParameters),m_cServer,_filename2)+")  and  TIPO='4' "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aesaldi.Eof())) {
            // * --- Insert into aesaldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aesaldi");
            m_cPhName = m_Ctx.GetPhName("aesaldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000DD(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aesaldi.GetString("NOMEFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_protocollo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_fileprot,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipodoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aesaldi",true);
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
            Cursor_aesaldi.Next();
          }
          m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
          Cursor_aesaldi.Close();
          // * --- End Select
        } // End If
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
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tberrdge!=null)
          Cursor_tberrdge.Close();
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
        if (Cursor_qbe_tot_annoora!=null)
          Cursor_qbe_tot_annoora.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aesaldi!=null)
          Cursor_aesaldi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Esegue SID Windows */
    /* _dir1 := '"'+LRTrim(_dirjava)+'"'  */
    _dir1 = "\""+CPLib.LRTrim(_dirjava)+"\"";
    // Provo a lanciare il batch
    try
    {
      File _mydir = new File(CPLib.LRTrim(_dirsid)+"/prog");
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.bat",CPLib.LRTrim(_dir1),CPLib.Upper(_pwdsog)};
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
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java",CPLib.Upper(_pwdsog)};
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
  void Page_4() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Cerca la terna */
      /* _tfile := Substr(_terna,16,15) */
      _tfile = CPLib.Substr(_terna,16,15);
      /* _tprog := arfn_delzero(LRTrim(Right(_terna,25))) */
      _tprog = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.LRTrim(CPLib.Right(_terna,25)));
      /* _tfind := '' */
      _tfind = "";
      /* _rapporto := '' */
      _rapporto = "";
      // * --- Read from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      m_cSql = "";
      m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tfile,"C",15,0,m_cServer),m_cServer,_tfile);
      m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tprog,"C",25,0,m_cServer),m_cServer,_tprog);
      if (m_Ctx.IsSharedTemp("aerighe")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _tfind = Read_Cursor.GetString("IDBASE");
        _rapporto = Read_Cursor.GetString("RAPPORTO");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on aerighe into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _tfind = "";
        _rapporto = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Len(LRTrim(_tfind)) <> 0 */
      if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_tfind)),0)) {
        // * --- Write into aerighe from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000EF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ESITOANNO = "+CPLib.ToSQL(CPLib.Substr(_riga,61,10),"C",10,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_tfile,"?",0,0,m_cServer),m_cServer,_tfile)+"";
        m_cSql = m_cSql+" and APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_tprog,"?",0,0,m_cServer),m_cServer,_tprog)+"";
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
      } else { // Else
        /* _rapporto := '' */
        _rapporto = "";
        /* _tfind := '' */
        _tfind = "";
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tfile,"C",15,0,m_cServer),m_cServer,_tfile);
        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tprog,"C",25,0,m_cServer),m_cServer,_tprog);
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tfind = Read_Cursor.GetString("IDBASE");
          _rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tfind = "";
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Len(LRTrim(_tfind)) <> 0 */
        if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_tfind)),0)) {
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000F4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ESITOANNO = "+CPLib.ToSQL(CPLib.Substr(_riga,61,10),"C",10,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_tfile,"?",0,0,m_cServer),m_cServer,_tfile)+"";
          m_cSql = m_cSql+" and APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_tprog,"?",0,0,m_cServer),m_cServer,_tprog)+"";
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
        } else { // Else
          /* _rapporto := '' */
          _rapporto = "";
          /* _tfind := '' */
          _tfind = "";
          // * --- Read from aeoprig
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_cSql = "";
          m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tfile,"C",15,0,m_cServer),m_cServer,_tfile);
          m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tprog,"C",25,0,m_cServer),m_cServer,_tprog);
          if (m_Ctx.IsSharedTemp("aeoprig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tfind = Read_Cursor.GetString("IDBASE");
            _rapporto = Read_Cursor.GetString("CONNESINT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_ricevute_sid returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tfind = "";
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Len(LRTrim(_tfind)) <> 0 */
          if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_tfind)),0)) {
            // * --- Write into aeoprig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeoprig");
            m_cPhName = m_Ctx.GetPhName("aeoprig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ricevute_sid",291,"000000F9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ESITOANNO = "+CPLib.ToSQL(CPLib.Substr(_riga,61,10),"C",10,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_tfile,"?",0,0,m_cServer),m_cServer,_tfile)+"";
            m_cSql = m_cSql+" and APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_tprog,"?",0,0,m_cServer),m_cServer,_tprog)+"";
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
      m_Caller.SetString("nomefile","C",100,0,w_nomefile);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_ricevute_sidR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_ricevute_sidR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",100,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
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
    _categsid = CPLib.Space(15);
    _descrsid = CPLib.Space(100);
    _azionesid = CPLib.Space(100);
    _fileesi = CPLib.Space(80);
    _filedgn = CPLib.Space(80);
    _protocollo = CPLib.Space(24);
    _fileprot = CPLib.Space(50);
    _filename1 = CPLib.Space(50);
    _filename2 = CPLib.Space(50);
    _tipodoc = CPLib.Space(1);
    _terna = CPLib.Space(56);
    _tfile = CPLib.Space(15);
    _tprog = CPLib.Space(25);
    _tfind = CPLib.Space(10);
    _filename = CPLib.Space(255);
    _contaB = 0;
    _contaC = 0;
    _contaT = 0;
    _contaI = 0;
    _errdge = new MemoryCursor_tberrdge();
    _rowerr = new MemoryCursorRow_tberrdge();
    w_annorif = CPLib.Space(4);
    _wesito = 0;
    _fileorig = CPLib.Space(50);
    _nriga = 0;
    _rapporto = CPLib.Space(25);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tot_annoora,
  public static final String m_cVQRList = ",qbe_tot_annoora,";
  // ENTITY_BATCHES: ,arfn_delzero,
  public static final String i_InvokedRoutines = ",arfn_delzero,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000044(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEPROT,";
    p_cSql = p_cSql+"TXTMSG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEPROT,";
    p_cSql = p_cSql+"TXTMSG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEPROT,";
    p_cSql = p_cSql+"TXTMSG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEINV1,";
    p_cSql = p_cSql+"FILEINV2,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"FILEINV1,";
    p_cSql = p_cSql+"FILEINV2,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
}
