// * --- Area Manuale = BO - Header
// * --- arrt_fammigra_old
import java.io.*;
import java.util.Scanner;
import java.util.List;
// * --- Fine Area Manuale
public class arrt_fammigra_oldR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_famesiti;
  public String m_cServer_famesiti;
  public String m_cPhName_famesitid;
  public String m_cServer_famesitid;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
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
  public String pAzzera;
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
  public String _invio;
  public String _unique;
  public String _tipoanom;
  public String _datoerr;
  public java.sql.Date _data1;
  public java.sql.Date _data2;
  public java.sql.Date _data3;
  public String _nomedir;
  public String cRitorno;
  public String _anno;
  public String czipfile;
  public String buffernomefile;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_fammigra_old
  public int conteggio;
  public String[] lista;
  public int i;
  
  
  
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_fammigra_oldR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fammigra_old",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
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
    m_cPhName_famesiti = p_ContextObject.GetPhName("famesiti");
    if (m_cPhName_famesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_famesiti = m_cPhName_famesiti+" "+m_Ctx.GetWritePhName("famesiti");
    }
    m_cServer_famesiti = p_ContextObject.GetServer("famesiti");
    m_cPhName_famesitid = p_ContextObject.GetPhName("famesitid");
    if (m_cPhName_famesitid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_famesitid = m_cPhName_famesitid+" "+m_Ctx.GetWritePhName("famesitid");
    }
    m_cServer_famesitid = p_ContextObject.GetServer("famesitid");
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
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
      return "arrt_fammigra_old";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pAzzera",p_cVarName)) {
      return pAzzera;
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
    if (CPLib.eqr("_nomedir",p_cVarName)) {
      return _nomedir;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_data1",p_cVarName)) {
      return _data1;
    }
    if (CPLib.eqr("_data2",p_cVarName)) {
      return _data2;
    }
    if (CPLib.eqr("_data3",p_cVarName)) {
      return _data3;
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
    if (CPLib.eqr("pAzzera",p_cVarName)) {
      pAzzera = value;
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
    if (CPLib.eqr("_nomedir",p_cVarName)) {
      _nomedir = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_data1",p_cVarName)) {
      _data1 = value;
      return;
    }
    if (CPLib.eqr("_data2",p_cVarName)) {
      _data2 = value;
      return;
    }
    if (CPLib.eqr("_data3",p_cVarName)) {
      _data3 = value;
      return;
    }
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* pAzzera Char(1) */
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
      /* _invio Char(10) */
      /* _unique Char(50) */
      /* _tipoanom Char(1) */
      /* _datoerr Char(16) */
      /* _data1 Date */
      /* _data2 Date */
      /* _data3 Date */
      /* _nomedir Char(128) */
      /* cRitorno Char(2) */
      /* _anno Char(4) */
      /* czipfile Char(100) := NullString() // nome file zip */
      czipfile = CPLib.NullString();
      /* gMsgProc := 'Inizio Elaborazione SID'+ NL // Log Messaggi */
      gMsgProc = "Inizio Elaborazione SID"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pAzzera='S' */
      if (CPLib.eqr(pAzzera,"S")) {
        /* gMsgProc := gMsgProc + 'Cancellazione Tabella Destinazione'+ NL // Log Messaggi */
        gMsgProc = gMsgProc+"Cancellazione Tabella Destinazione"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Delete from famesiti
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("famesiti");
        m_cPhName = m_Ctx.GetPhName("famesiti");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"famesiti",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"00000045")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Delete from famesitid
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("famesitid");
        m_cPhName = m_Ctx.GetPhName("famesitid");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"famesitid",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"00000046")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
      /* _semaforo := '' // Veridica semaforo SID */
      _semaforo = "";
      /* _contaT := 0 */
      _contaT = CPLib.Round(0,0);
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
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_fammigra_old returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _semaforo = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(LRTrim(_semaforo)) */
      if (CPLib.Empty(CPLib.LRTrim(_semaforo))) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"0000004B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
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
        /* gMsgProc := gMsgProc + 'Cancellazione file esiti precedenti' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Cancellazione file esiti precedenti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Legge i file degli esiti
        File di = new File(CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/ESI/"+CPLib.LRTrim(gAzienda)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
          fl[_i].delete();
        }
        // Legge i file degli esiti
        di = new File(CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+CPLib.LRTrim(gAzienda)+"/");
        File fl2[] = di.listFiles();
        count=0;
        for (_i=0; _i < fl2.length; _i++)  {
          fl2[_i].delete();
        }
        /* _dirsid := gPathApp+"/SID/SID_FOTO" */
        _dirsid = gPathApp+"/SID/SID_FOTO";
        /* gMsgProc := gMsgProc + 'Costruzione File di configurazione' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Costruzione File di configurazione"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _dir1 := LRTrim("ARG1 " +LRTrim(gPathDoc)+"/SID/MIGRA/ELB/"+LRTrim(gAzienda)) */
        _dir1 = CPLib.LRTrim("ARG1 "+CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/ELB/"+CPLib.LRTrim(gAzienda));
        /* _dir2 := LRTrim("ARG2 " +LRTrim(gPathDoc)+"/SID/MIGRA/ESI/"+LRTrim(gAzienda)) */
        _dir2 = CPLib.LRTrim("ARG2 "+CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/ESI/"+CPLib.LRTrim(gAzienda));
        /* _dir3 := LRTrim("ARG3 " +LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+LRTrim(gAzienda)) */
        _dir3 = CPLib.LRTrim("ARG3 "+CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+CPLib.LRTrim(gAzienda));
        /* _dir4 := LRTrim("ARG4 " +LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)) */
        _dir4 = CPLib.LRTrim("ARG4 "+CPLib.LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda));
        /* _fcfg := '/SID/SID_FOTO/config/comunicazioni.cfg' */
        _fcfg = "/SID/SID_FOTO/config/comunicazioni.cfg";
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
        /* _fcfg := '/SID/SID_FOTO/config/comunicazioni.cfg' */
        _fcfg = "/SID/SID_FOTO/config/comunicazioni.cfg";
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
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000006Estatus;
        nTry0000006Estatus = m_Sql.GetTransactionStatus();
        String cTry0000006Emsg;
        cTry0000006Emsg = m_Sql.TransactionErrorMessage();
        try {
          /* Cicla sul file della lista e lancia la pagina appropriata */
          // * --- Select from tmp_list_imprich
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          if (Cursor_tmp_list_imprich!=null)
            Cursor_tmp_list_imprich.Close();
          Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_list_imprich.Eof())) {
            /* If At('.zip',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
            if (CPLib.ne(CPLib.At(".zip",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
              /* czipfile := LRTrim(tmp_list_imprich->nomefile) */
              czipfile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
              /* Exec "Estrai zip" Page 4:Page_4 */
              Page_4();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            } // End If
            Cursor_tmp_list_imprich.Next();
          }
          m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
          Cursor_tmp_list_imprich.Close();
          // * --- End Select
          // * --- Select from tmp_list_imprich
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          if (Cursor_tmp_list_imprich!=null)
            Cursor_tmp_list_imprich.Close();
          Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_list_imprich.Eof())) {
            /* _nriga := 0 */
            _nriga = CPLib.Round(0,0);
            /* _filename := LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+LRTrim(gAzienda)+"/"+Strtran(LRTrim(tmp_list_imprich->nomefile),'.p7m.enc','.run') */
            _filename = CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.Strtran(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")),".p7m.enc",".run");
            /* gMsgProc := gMsgProc + LRTrim(_filename) + NL // Log Messaggi */
            gMsgProc = gMsgProc+CPLib.LRTrim(_filename)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* fhand := FileLibMit.OpenReadPath(_filename) // Handle File */
            fhand = FileLibMit.OpenReadPath(_filename);
            /* While not(FileLibMit.Eof(fhand)) */
            while ( ! (FileLibMit.Eof(fhand))) {
              /* _riga := FileLibMit.ReadLine(fhand) */
              _riga = FileLibMit.ReadLine(fhand);
              /* _nriga := _nriga + 1 */
              _nriga = CPLib.Round(_nriga+1,0);
              /* If Left(_riga,1)='1' */
              if (CPLib.eqr(CPLib.Left(_riga,1),"1")) {
                /* _contaT := _contaT + 1 */
                _contaT = CPLib.Round(_contaT+1,0);
                /* _data1 := iif(Substr(_riga,78,10)='0001-01-01',NullDate(),CharToDate(Left(Substr(_riga,78,10),4)+Substr(Substr(_riga,78,10),6,2)+Substr(Substr(_riga,78,10),9,2))) */
                _data1 = (CPLib.eqr(CPLib.Substr(_riga,78,10),"0001-01-01")?CPLib.NullDate():CPLib.CharToDate(CPLib.Left(CPLib.Substr(_riga,78,10),4)+CPLib.Substr(CPLib.Substr(_riga,78,10),6,2)+CPLib.Substr(CPLib.Substr(_riga,78,10),9,2)));
                /* _data2 := iif(Substr(_riga,88,10)='0001-01-01',NullDate(),CharToDate(Left(Substr(_riga,88,10),4)+Substr(Substr(_riga,88,10),6,2)+Substr(Substr(_riga,88,10),9,2))) */
                _data2 = (CPLib.eqr(CPLib.Substr(_riga,88,10),"0001-01-01")?CPLib.NullDate():CPLib.CharToDate(CPLib.Left(CPLib.Substr(_riga,88,10),4)+CPLib.Substr(CPLib.Substr(_riga,88,10),6,2)+CPLib.Substr(CPLib.Substr(_riga,88,10),9,2)));
                // * --- Insert into famesiti from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("famesiti");
                m_cPhName = m_Ctx.GetPhName("famesiti");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"famesiti",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"00000080")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000080(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,2,50),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,52,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,54,24),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_data1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_data2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,98,1))?"0":CPLib.Substr(_riga,98,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,99,1))?"0":CPLib.Substr(_riga,99,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,100,1))?"0":CPLib.Substr(_riga,100,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,101,1))?"0":CPLib.Substr(_riga,101,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,102,1))?"0":CPLib.Substr(_riga,102,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,103,1))?"0":CPLib.Substr(_riga,103,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(_riga,104,1))?"0":CPLib.Substr(_riga,104,1)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_contaT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"famesiti",true);
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
                /* ElseIf Left(_riga,1)='2' */
              } else if (CPLib.eqr(CPLib.Left(_riga,1),"2")) {
                /* _data1 := iif(Substr(_riga,79,10)='0001-01-01',NullDate(),CharToDate(Left(Substr(_riga,79,10),4)+Substr(Substr(_riga,79,10),6,2)+Substr(Substr(_riga,79,10),9,2))) */
                _data1 = (CPLib.eqr(CPLib.Substr(_riga,79,10),"0001-01-01")?CPLib.NullDate():CPLib.CharToDate(CPLib.Left(CPLib.Substr(_riga,79,10),4)+CPLib.Substr(CPLib.Substr(_riga,79,10),6,2)+CPLib.Substr(CPLib.Substr(_riga,79,10),9,2)));
                /* _data2 := iif(Substr(_riga,89,10)='0001-01-01',NullDate(),CharToDate(Left(Substr(_riga,89,10),4)+Substr(Substr(_riga,89,10),6,2)+Substr(Substr(_riga,89,10),9,2))) */
                _data2 = (CPLib.eqr(CPLib.Substr(_riga,89,10),"0001-01-01")?CPLib.NullDate():CPLib.CharToDate(CPLib.Left(CPLib.Substr(_riga,89,10),4)+CPLib.Substr(CPLib.Substr(_riga,89,10),6,2)+CPLib.Substr(CPLib.Substr(_riga,89,10),9,2)));
                /* _data3 := iif(Substr(_riga,160,10)='0001-01-01',NullDate(),CharToDate(Left(Substr(_riga,160,10),4)+Substr(Substr(_riga,160,10),6,2)+Substr(Substr(_riga,160,10),9,2))) */
                _data3 = (CPLib.eqr(CPLib.Substr(_riga,160,10),"0001-01-01")?CPLib.NullDate():CPLib.CharToDate(CPLib.Left(CPLib.Substr(_riga,160,10),4)+CPLib.Substr(CPLib.Substr(_riga,160,10),6,2)+CPLib.Substr(CPLib.Substr(_riga,160,10),9,2)));
                // * --- Insert into famesitid from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("famesitid");
                m_cPhName = m_Ctx.GetPhName("famesitid");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"famesitid",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"00000084")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000084(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,2,50),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(_riga,52,9)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,61,16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(_riga,77,2)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_data1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_data2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,99,60),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,159,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_data3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,170,40),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_riga,210,2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"famesitid",true);
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
                /* ElseIf Left(_riga,1)='0' */
              } else if (CPLib.eqr(CPLib.Left(_riga,1),"0")) {
                /* _data1 := iif(Substr(_riga,105,10)='0001-01-01',NullDate(),CharToDate(Left(Substr(_riga,105,10),4)+Substr(Substr(_riga,105,10),6,2)+Substr(Substr(_riga,105,10),9,2))) */
                _data1 = (CPLib.eqr(CPLib.Substr(_riga,105,10),"0001-01-01")?CPLib.NullDate():CPLib.CharToDate(CPLib.Left(CPLib.Substr(_riga,105,10),4)+CPLib.Substr(CPLib.Substr(_riga,105,10),6,2)+CPLib.Substr(CPLib.Substr(_riga,105,10),9,2)));
                /* _anno := Substr(_riga,105,4) */
                _anno = CPLib.Substr(_riga,105,4);
                // * --- Write into intermbo from all
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intermbo");
                m_cPhName = m_Ctx.GetPhName("intermbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"00000087")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAINTER = "+CPLib.ToSQL(_data1,"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
              /* gMsgImp := 'Sto elaborando la riga: ' + Str(_nriga,10,0) + ' del file '+LRTrim(_filename) // Messaggio Import */
              gMsgImp = "Sto elaborando la riga: "+CPLib.Str(_nriga,10,0)+" del file "+CPLib.LRTrim(_filename);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End While
            /* FileLibMit.Close(fhand) */
            FileLibMit.Close(fhand);
            Cursor_tmp_list_imprich.Next();
          }
          m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
          Cursor_tmp_list_imprich.Close();
          // * --- End Select
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* cRitorno := 'OK' */
          cRitorno = "OK";
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* cRitorno := 'KO' */
          cRitorno = "KO";
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000006Estatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000006Estatus,cTry0000006Emsg);
          }
        }
        /* gMsgProc := gMsgProc + 'PROCEDURA COMPLETATA.' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"PROCEDURA COMPLETATA."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'ELABORAZIONE TERMINATA.' // Messaggio Import */
        gMsgImp = "ELABORAZIONE TERMINATA.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Delete from cpwarn
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"00000090")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        /* cRitorno := 'KO' */
        cRitorno = "KO";
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
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
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runComunicazioniMIT.bat",CPLib.LRTrim(_dir1),CPLib.Upper(_pwdsog)};
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
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runComunicazioniMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java",CPLib.Upper(_pwdsog)};
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
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Inizio estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* cpercorsozip Char(200) := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+czipfile */
    String cpercorsozip;
    cpercorsozip = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+czipfile;
    /* cdirectoryfile Char(200) := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/" */
    String cdirectoryfile;
    cdirectoryfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/";
    /* buffernomefile Char(100) := NullString() */
    buffernomefile = CPLib.NullString();
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          //Conto il numero di file all interno del file zip e creo un array di stringhe per memorizzare i nomi file
          conteggio=zf.size();
          lista=new String[conteggio];
          
          // Enumerate each entry
          i=0;
          for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
              // Get the entry name
              lista[i] = ((java.util.zip.ZipEntry)entries.nextElement()).getName();
              i++;
          }
         zf.close();
         } catch (java.io.IOException e) {
         }
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          byte[] buffer = new byte[1024]; 
          java.util.Enumeration entries = zf.entries();
          while(entries.hasMoreElements() ) {
            java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry)entries.nextElement();
            java.io.InputStream in =zf.getInputStream(entry);
            java.io.OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(cdirectoryfile+entry.getName()));
    
            int len;
    
            while((len = in.read(buffer)) >= 0){
              out.write(buffer, 0, len);
            }
    
              in.close();
              out.close();
          }
    
          zf.close();
    } catch (java.io.IOException ioe) {
          System.err.println("Unhandled exception:");
          ioe.printStackTrace();
          return;
    }
    // * --- Delete from tmp_list_imprich
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_list_imprich");
    m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"000000A1")+"delete from "+m_oWrInfo.GetTableWriteName();
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
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
    /* contanome := 0 */
    contanome = 0;
    /* While contanome<conteggio */
    while (CPLib.lt(contanome,conteggio)) {
      buffernomefile=lista[contanome];
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_old",352,"000000A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000A5(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_list_imprich",true);
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
      /* contanome := contanome+1 */
      contanome = contanome+1;
    } // End While
    /* FileLibMit.DeleteFile('appo/'+LRTrim(gAzienda)+"/"+czipfile) */
    FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+czipfile);
    /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Fine estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void _init_() {
  }
  public String RunAsync(String p_pAzzera) {
    pAzzera = p_pAzzera;
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
  public String Run(String p_pAzzera) {
    pAzzera = p_pAzzera;
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
  public static arrt_fammigra_oldR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fammigra_oldR(p_Ctx, p_Caller);
  }
  public static arrt_fammigra_oldR Make(CPContext p_Ctx) {
    return new arrt_fammigra_oldR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAzzera = CPLib.Space(1);
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
    _invio = CPLib.Space(10);
    _unique = CPLib.Space(50);
    _tipoanom = CPLib.Space(1);
    _datoerr = CPLib.Space(16);
    _data1 = CPLib.NullDate();
    _data2 = CPLib.NullDate();
    _data3 = CPLib.NullDate();
    _nomedir = CPLib.Space(128);
    cRitorno = CPLib.Space(2);
    _anno = CPLib.Space(4);
    czipfile = CPLib.NullString();
    buffernomefile = CPLib.NullString();
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
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_fammigra_old,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_fammigra_old,";
  public static String[] m_cRunParameterNames={"pAzzera"};
  protected static String GetFieldsName_0000004B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000080(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"FAMCODICE,";
    p_cSql = p_cSql+"FAMTIPORAP,";
    p_cSql = p_cSql+"FAMDESCRI,";
    p_cSql = p_cSql+"FAMDATINI,";
    p_cSql = p_cSql+"FAMDATFIN,";
    p_cSql = p_cSql+"FAMSAL2011,";
    p_cSql = p_cSql+"FAMSAL2012,";
    p_cSql = p_cSql+"FAMSAL2013,";
    p_cSql = p_cSql+"FAMSAL2014,";
    p_cSql = p_cSql+"FAMSAL2015,";
    p_cSql = p_cSql+"FAMSAL2016,";
    p_cSql = p_cSql+"FAMSAL2017,";
    p_cSql = p_cSql+"FAMCONTA,";
    p_cSql = p_cSql+"FAMANNORIF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"famesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000084(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"FADRAPPORTO,";
    p_cSql = p_cSql+"FADPROGR,";
    p_cSql = p_cSql+"FADCODFIS,";
    p_cSql = p_cSql+"FADRUOLO,";
    p_cSql = p_cSql+"FADDATINI,";
    p_cSql = p_cSql+"FADDATFIN,";
    p_cSql = p_cSql+"FADCOGRAG,";
    p_cSql = p_cSql+"FADSESSO,";
    p_cSql = p_cSql+"FADDATNAS,";
    p_cSql = p_cSql+"FADNASSEL,";
    p_cSql = p_cSql+"FADPRVSEL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"famesitid",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
