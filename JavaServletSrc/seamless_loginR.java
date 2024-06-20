// * --- Area Manuale = BO - Header
// * --- seamless_login
import it.sauronsoftware.base64.Base64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.URLEncoder;
// * --- Fine Area Manuale
public class seamless_loginR implements CallerWithObjs {
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
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_cpusrgrp;
  public String m_cServer_cpusrgrp;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_cgo_subnet;
  public String m_cServer_cgo_subnet;
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
  public String pUser;
  public String pPwd;
  public String pAzienda;
  public String pURL;
  public String pURLOE;
  public String pOTP;
  public String pIPC;
  public String pIPS;
  public String pIPSP;
  public String pIPRP;
  public String pBrowser;
  public String gUtility;
  public String gIPC;
  public String gIPS;
  public String gIPSP;
  public String gIPP;
  public String gBrowser;
  public String gOTP;
  public String _path;
  public String _skt_server;
  public String _skt_paths;
  public double _skt_port;
  public String _skt_mode;
  public String _skt_connes;
  public String _header;
  public String _ritorno;
  public String _dati;
  public String _dati64;
  public double _ldati;
  public java.io.InputStreamReader _isr;
  public double _usrcode;
  public double _isadm;
  public String _muser;
  public double _mutil;
  public String _accesso;
  public String _tip;
  public double _ltip;
  public double _ntip;
  public double _nfind;
  public String fhand;
  public String riga;
  public double _maxazi;
  public double _aziext;
  public double _blocco;
  public String pippo;
  public String _pathdoc;
  public String _otp;
  public String _superdip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public seamless_loginR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("seamless_login",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    if (m_cPhName_cpusrgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusrgrp = m_cPhName_cpusrgrp+" "+m_Ctx.GetWritePhName("cpusrgrp");
    }
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_cgo_subnet = p_ContextObject.GetPhName("cgo_subnet");
    if (m_cPhName_cgo_subnet.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_subnet = m_cPhName_cgo_subnet+" "+m_Ctx.GetWritePhName("cgo_subnet");
    }
    m_cServer_cgo_subnet = p_ContextObject.GetServer("cgo_subnet");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_skt_port",p_cVarName)) {
      return _skt_port;
    }
    if (CPLib.eqr("_ldati",p_cVarName)) {
      return _ldati;
    }
    if (CPLib.eqr("_usrcode",p_cVarName)) {
      return _usrcode;
    }
    if (CPLib.eqr("_isadm",p_cVarName)) {
      return _isadm;
    }
    if (CPLib.eqr("_mutil",p_cVarName)) {
      return _mutil;
    }
    if (CPLib.eqr("_ltip",p_cVarName)) {
      return _ltip;
    }
    if (CPLib.eqr("_ntip",p_cVarName)) {
      return _ntip;
    }
    if (CPLib.eqr("_nfind",p_cVarName)) {
      return _nfind;
    }
    if (CPLib.eqr("_maxazi",p_cVarName)) {
      return _maxazi;
    }
    if (CPLib.eqr("_aziext",p_cVarName)) {
      return _aziext;
    }
    if (CPLib.eqr("_blocco",p_cVarName)) {
      return _blocco;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "seamless_login";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pUser",p_cVarName)) {
      return pUser;
    }
    if (CPLib.eqr("pPwd",p_cVarName)) {
      return pPwd;
    }
    if (CPLib.eqr("pAzienda",p_cVarName)) {
      return pAzienda;
    }
    if (CPLib.eqr("pURL",p_cVarName)) {
      return pURL;
    }
    if (CPLib.eqr("pURLOE",p_cVarName)) {
      return pURLOE;
    }
    if (CPLib.eqr("pOTP",p_cVarName)) {
      return pOTP;
    }
    if (CPLib.eqr("pIPC",p_cVarName)) {
      return pIPC;
    }
    if (CPLib.eqr("pIPS",p_cVarName)) {
      return pIPS;
    }
    if (CPLib.eqr("pIPSP",p_cVarName)) {
      return pIPSP;
    }
    if (CPLib.eqr("pIPRP",p_cVarName)) {
      return pIPRP;
    }
    if (CPLib.eqr("pBrowser",p_cVarName)) {
      return pBrowser;
    }
    if (CPLib.eqr("gUtility",p_cVarName)) {
      return gUtility;
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
    if (CPLib.eqr("gBrowser",p_cVarName)) {
      return gBrowser;
    }
    if (CPLib.eqr("gOTP",p_cVarName)) {
      return gOTP;
    }
    if (CPLib.eqr("_path",p_cVarName)) {
      return _path;
    }
    if (CPLib.eqr("_skt_server",p_cVarName)) {
      return _skt_server;
    }
    if (CPLib.eqr("_skt_paths",p_cVarName)) {
      return _skt_paths;
    }
    if (CPLib.eqr("_skt_mode",p_cVarName)) {
      return _skt_mode;
    }
    if (CPLib.eqr("_skt_connes",p_cVarName)) {
      return _skt_connes;
    }
    if (CPLib.eqr("_header",p_cVarName)) {
      return _header;
    }
    if (CPLib.eqr("_ritorno",p_cVarName)) {
      return _ritorno;
    }
    if (CPLib.eqr("_dati",p_cVarName)) {
      return _dati;
    }
    if (CPLib.eqr("_dati64",p_cVarName)) {
      return _dati64;
    }
    if (CPLib.eqr("_muser",p_cVarName)) {
      return _muser;
    }
    if (CPLib.eqr("_accesso",p_cVarName)) {
      return _accesso;
    }
    if (CPLib.eqr("_tip",p_cVarName)) {
      return _tip;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("pippo",p_cVarName)) {
      return pippo;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      return _pathdoc;
    }
    if (CPLib.eqr("_otp",p_cVarName)) {
      return _otp;
    }
    if (CPLib.eqr("_superdip",p_cVarName)) {
      return _superdip;
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
    if (CPLib.eqr("_skt_port",p_cVarName)) {
      _skt_port = value;
      return;
    }
    if (CPLib.eqr("_ldati",p_cVarName)) {
      _ldati = value;
      return;
    }
    if (CPLib.eqr("_usrcode",p_cVarName)) {
      _usrcode = value;
      return;
    }
    if (CPLib.eqr("_isadm",p_cVarName)) {
      _isadm = value;
      return;
    }
    if (CPLib.eqr("_mutil",p_cVarName)) {
      _mutil = value;
      return;
    }
    if (CPLib.eqr("_ltip",p_cVarName)) {
      _ltip = value;
      return;
    }
    if (CPLib.eqr("_ntip",p_cVarName)) {
      _ntip = value;
      return;
    }
    if (CPLib.eqr("_nfind",p_cVarName)) {
      _nfind = value;
      return;
    }
    if (CPLib.eqr("_maxazi",p_cVarName)) {
      _maxazi = value;
      return;
    }
    if (CPLib.eqr("_aziext",p_cVarName)) {
      _aziext = value;
      return;
    }
    if (CPLib.eqr("_blocco",p_cVarName)) {
      _blocco = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pUser",p_cVarName)) {
      pUser = value;
      return;
    }
    if (CPLib.eqr("pPwd",p_cVarName)) {
      pPwd = value;
      return;
    }
    if (CPLib.eqr("pAzienda",p_cVarName)) {
      pAzienda = value;
      return;
    }
    if (CPLib.eqr("pURL",p_cVarName)) {
      pURL = value;
      return;
    }
    if (CPLib.eqr("pURLOE",p_cVarName)) {
      pURLOE = value;
      return;
    }
    if (CPLib.eqr("pOTP",p_cVarName)) {
      pOTP = value;
      return;
    }
    if (CPLib.eqr("pIPC",p_cVarName)) {
      pIPC = value;
      return;
    }
    if (CPLib.eqr("pIPS",p_cVarName)) {
      pIPS = value;
      return;
    }
    if (CPLib.eqr("pIPSP",p_cVarName)) {
      pIPSP = value;
      return;
    }
    if (CPLib.eqr("pIPRP",p_cVarName)) {
      pIPRP = value;
      return;
    }
    if (CPLib.eqr("pBrowser",p_cVarName)) {
      pBrowser = value;
      return;
    }
    if (CPLib.eqr("gUtility",p_cVarName)) {
      gUtility = value;
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
    if (CPLib.eqr("gBrowser",p_cVarName)) {
      gBrowser = value;
      return;
    }
    if (CPLib.eqr("gOTP",p_cVarName)) {
      gOTP = value;
      return;
    }
    if (CPLib.eqr("_path",p_cVarName)) {
      _path = value;
      return;
    }
    if (CPLib.eqr("_skt_server",p_cVarName)) {
      _skt_server = value;
      return;
    }
    if (CPLib.eqr("_skt_paths",p_cVarName)) {
      _skt_paths = value;
      return;
    }
    if (CPLib.eqr("_skt_mode",p_cVarName)) {
      _skt_mode = value;
      return;
    }
    if (CPLib.eqr("_skt_connes",p_cVarName)) {
      _skt_connes = value;
      return;
    }
    if (CPLib.eqr("_header",p_cVarName)) {
      _header = value;
      return;
    }
    if (CPLib.eqr("_ritorno",p_cVarName)) {
      _ritorno = value;
      return;
    }
    if (CPLib.eqr("_dati",p_cVarName)) {
      _dati = value;
      return;
    }
    if (CPLib.eqr("_dati64",p_cVarName)) {
      _dati64 = value;
      return;
    }
    if (CPLib.eqr("_muser",p_cVarName)) {
      _muser = value;
      return;
    }
    if (CPLib.eqr("_accesso",p_cVarName)) {
      _accesso = value;
      return;
    }
    if (CPLib.eqr("_tip",p_cVarName)) {
      _tip = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("pippo",p_cVarName)) {
      pippo = value;
      return;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      _pathdoc = value;
      return;
    }
    if (CPLib.eqr("_otp",p_cVarName)) {
      _otp = value;
      return;
    }
    if (CPLib.eqr("_superdip",p_cVarName)) {
      _superdip = value;
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
    CPResultSet Cursor_cpusrgrp=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_subnet=null;
    CPResultSet Cursor_cpazi=null;
    try {
      /* Variabili del caller */
      /* pUser Char(20) */
      /* pPwd Char(20) */
      /* pAzienda Char(10) */
      /* pURL Char(50) */
      /* pURLOE Char(50) */
      /* pOTP Char(6) */
      /* pIPC Char(20) */
      /* pIPS Char(120) */
      /* pIPSP Char(20) */
      /* pIPRP Char(20) */
      /* pBrowser Char(128) */
      /* gUtility Char(2) // Gestione menu utility */
      /* gIPC Char(20) // IPClient */
      /* gIPS Char(120) // IPServer */
      /* gIPSP Char(20) // Porta Server */
      /* gIPP Char(20) // Protocollo Server */
      /* gBrowser Char(1) // Tipo Browser */
      /* gOTP Char(1) // Attiva gestione OTP */
      /* _path Char(120) */
      /* _skt_server Char(30) */
      /* _skt_paths Char(60) */
      /* _skt_port Numeric(5, 0) */
      /* _skt_mode Char(5) */
      /* _skt_connes Char(50) */
      /* _header Memo */
      /* _ritorno Memo */
      /* _dati Char(512) */
      /* _dati64 Char(512) */
      /* _ldati Numeric(10, 0) */
      /* _isr Object(java.io.InputStreamReader) */
      /* _usrcode Numeric(10, 0) */
      /* _isadm Numeric(1, 0) */
      /* _muser Char(50) */
      /* _muser Char(50) */
      /* _mutil Numeric(1, 0) */
      /* _accesso Char(1) */
      /* _tip Char(10) */
      /* _ltip Numeric(2, 0) */
      /* _ntip Numeric(2, 0) */
      /* _nfind Numeric(1, 0) */
      /* fhand Char(10) */
      /* riga Char(100) */
      /* _maxazi Numeric(10, 0) */
      /* _aziext Numeric(10, 0) */
      /* _blocco Numeric(1, 0) */
      /* pippo Char(26) */
      /* _pathdoc Char(250) */
      /* _otp Char(100) */
      /* _superdip Char(1) */
      /* _usrcode := 0 */
      _usrcode = CPLib.Round(0,0);
      /* _isadm := 1 */
      _isadm = CPLib.Round(1,0);
      /* gUtility := 'no' // Gestione menu utility */
      gUtility = "no";
      m_Ctx.SetGlobalString("gUtility",gUtility);
      /* Creo la comunicazione con il webservice */
      /* _otp := '' */
      _otp = "";
      /* _superdip := 'N' */
      _superdip = "N";
      // * --- Read from cpusers
      m_cServer = m_Ctx.GetServer("cpusers");
      m_cPhName = m_Ctx.GetPhName("cpusers");
      m_cSql = "";
      m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL(pUser,"C",50,0,m_cServer),m_cServer,pUser);
      if (m_Ctx.IsSharedTemp("cpusers")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("cpotp",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _usrcode = CPLib.Round(Read_Cursor.GetDouble("code"),0);
        _otp = Read_Cursor.GetString("cpotp");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpusers into routine seamless_login returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _usrcode = 0;
        _otp = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Read from cpusers_add
      m_cServer = m_Ctx.GetServer("cpusers_add");
      m_cPhName = m_Ctx.GetPhName("cpusers_add");
      m_cSql = "";
      m_cSql = m_cSql+"CODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_usrcode,"N",10,0,m_cServer),m_cServer,_usrcode);
      if (m_Ctx.IsSharedTemp("cpusers_add")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SUPERDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _superdip = Read_Cursor.GetString("SUPERDIP");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpusers_add into routine seamless_login returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _superdip = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Select from cpusrgrp
      m_cServer = m_Ctx.GetServer("cpusrgrp");
      m_cPhName = m_Ctx.GetPhName("cpusrgrp");
      if (Cursor_cpusrgrp!=null)
        Cursor_cpusrgrp.Close();
      Cursor_cpusrgrp = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select groupcode  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"usercode="+CPSql.SQLValueAdapter(CPLib.ToSQL(_usrcode,"?",0,0,m_cServer, m_oParameters),m_cServer,_usrcode)+" "+")"+(m_Ctx.IsSharedTemp("cpusrgrp")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpusrgrp.Eof())) {
        /* If cpusrgrp->groupcode=6 or cpusrgrp->groupcode=12 */
        if (CPLib.eqr(Cursor_cpusrgrp.GetDouble("groupcode"),6) || CPLib.eqr(Cursor_cpusrgrp.GetDouble("groupcode"),12)) {
          /* _isadm := 0 */
          _isadm = CPLib.Round(0,0);
          /* ElseIf cpusrgrp->groupcode=1 */
        } else if (CPLib.eqr(Cursor_cpusrgrp.GetDouble("groupcode"),1)) {
          /* gUtility := '' // Gestione menu utility */
          gUtility = "";
          m_Ctx.SetGlobalString("gUtility",gUtility);
        } // End If
        Cursor_cpusrgrp.Next();
      }
      m_cConnectivityError = Cursor_cpusrgrp.ErrorMessage();
      Cursor_cpusrgrp.Close();
      // * --- End Select
      /* Utilities.SetCompany(LRTrim(pAzienda)) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(pAzienda));
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _skt_server := intermbo->SKT_SERVER */
        _skt_server = Cursor_intermbo.GetString("SKT_SERVER");
        /* _skt_paths := intermbo->SKT_PATHS */
        _skt_paths = Cursor_intermbo.GetString("SKT_PATHS");
        /* _skt_port := intermbo->SKT_PORT */
        _skt_port = CPLib.Round(Cursor_intermbo.GetDouble("SKT_PORT"),0);
        /* _skt_mode := Lower(intermbo->SKT_MODET) */
        _skt_mode = CPLib.Lower(Cursor_intermbo.GetString("SKT_MODET"));
        /* _skt_connes := Lower(LRTrim(intermbo->SKT_MODET)+"://"+LRTrim(intermbo->SKT_SERVER)) */
        _skt_connes = CPLib.Lower(CPLib.LRTrim(Cursor_intermbo.GetString("SKT_MODET"))+"://"+CPLib.LRTrim(Cursor_intermbo.GetString("SKT_SERVER")));
        /* _pathdoc := intermbo->RICEVUTE */
        _pathdoc = Cursor_intermbo.GetString("RICEVUTE");
        /* gOTP := intermbo->FLGCGOOTP // Attiva gestione OTP */
        gOTP = Cursor_intermbo.GetString("FLGCGOOTP");
        m_Ctx.SetGlobalString("gOTP",gOTP);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* gIPC := pIPC // IPClient */
      gIPC = pIPC;
      m_Ctx.SetGlobalString("gIPC",gIPC);
      /* gIPS := pIPS // IPServer */
      gIPS = pIPS;
      m_Ctx.SetGlobalString("gIPS",gIPS);
      /* gIPSP := pIPSP // Porta Server */
      gIPSP = pIPSP;
      m_Ctx.SetGlobalString("gIPSP",gIPSP);
      /* gIPP := pIPRP // Porta Server */
      gIPP = pIPRP;
      m_Ctx.SetGlobalString("gIPP",gIPP);
      /* Case At('MSIE',pBrowser) <> 0 or At('Trident/7.0',pBrowser) <> 0 */
      if (CPLib.ne(CPLib.At("MSIE",pBrowser),0) || CPLib.ne(CPLib.At("Trident/7.0",pBrowser),0)) {
        /* gBrowser := 'I' // Tipo Browser */
        gBrowser = "I";
        m_Ctx.SetGlobalString("gBrowser",gBrowser);
        /* Case At('Firefox',pBrowser) <> 0 */
      } else if (CPLib.ne(CPLib.At("Firefox",pBrowser),0)) {
        /* gBrowser := 'F' // Tipo Browser */
        gBrowser = "F";
        m_Ctx.SetGlobalString("gBrowser",gBrowser);
        /* Case At('Chrome',pBrowser) <> 0 */
      } else if (CPLib.ne(CPLib.At("Chrome",pBrowser),0)) {
        /* gBrowser := 'C' // Tipo Browser */
        gBrowser = "C";
        m_Ctx.SetGlobalString("gBrowser",gBrowser);
        /* Case At('Safari',pBrowser) <> 0 */
      } else if (CPLib.ne(CPLib.At("Safari",pBrowser),0)) {
        /* gBrowser := 'S' // Tipo Browser */
        gBrowser = "S";
        m_Ctx.SetGlobalString("gBrowser",gBrowser);
        /* Case At('OPR',pBrowser) <> 0 */
      } else if (CPLib.ne(CPLib.At("OPR",pBrowser),0)) {
        /* gBrowser := 'O' // Tipo Browser */
        gBrowser = "O";
        m_Ctx.SetGlobalString("gBrowser",gBrowser);
      } // End Case
      /* If FileLibMit.ExistFile('blocca.inf') */
      if (FileLibMit.ExistFile("blocca.inf")) {
        /* pippo := CriptoLibrary.encodeBase64('1') */
        pippo = CriptoLibrary.encodeBase64("1");
        /* fhand := FileLibMit.OpenWrite('conf.lic') */
        fhand = FileLibMit.OpenWrite("conf.lic");
        /* FileLibMit.Write(fhand,pippo) */
        FileLibMit.Write(fhand,pippo);
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* FileLibMit.DeleteFile('blocca.inf') */
        FileLibMit.DeleteFile("blocca.inf");
      } // End If
      /* If _isadm=0 and not(Empty(_skt_server)) and _superdip='S' */
      if (CPLib.eqr(_isadm,0) &&  ! (CPLib.Empty(_skt_server)) && CPLib.eqr(_superdip,"S")) {
        /* _dati := '<xml version=' */
        _dati = "<xml version=";
        /* _dati := _dati+"'1.0' encoding='utf-8'><user>"+LRTrim(pUser)+"</user><pwd>"+LRTrim(pPwd) */
        _dati = _dati+"'1.0' encoding='utf-8'><user>"+CPLib.LRTrim(pUser)+"</user><pwd>"+CPLib.LRTrim(pPwd);
        /* _dati := _dati+'</pwd><otp>'+LRTrim(pOTP)+'</otp></xml>' */
        _dati = _dati+"</pwd><otp>"+CPLib.LRTrim(pOTP)+"</otp></xml>";
        /* _dati64 := Base64.encode(_dati) */
        _dati64 = Base64.encode(_dati);
        /* _ldati := Len(LRTrim(_dati64)) */
        _ldati = CPLib.Round(CPLib.Len(CPLib.LRTrim(_dati64)),0);
        /* _dati := 'mode=XML&StringXML='+_dati64 */
        _dati = "mode=XML&StringXML="+_dati64;
        /* If LRTrim(_skt_mode)="ssl" */
        if (CPLib.eqr(CPLib.LRTrim(_skt_mode),"ssl")) {
          /* Exec "SSL" Page 2:Page_2 */
          Page_2();
        } else { // Else
          /* _ritorno Memo */
          /* Exec "HTTP/HTTPS" Page 3:Page_3 */
          Page_3();
        } // End If
        /* If _accesso='1' */
        if (CPLib.eqr(_accesso,"1")) {
          /* Stop cp_login */
          Forward f;
          f=new Forward("cp_login",false,this,Forward.Execute,false);
          f.SetParameter("m_cUserName",pUser);
          f.SetParameter("m_cPassword","mitwebanti");
          f.SetParameter("m_cAction","login");
          f.SetParameter("g_codazi",(CPLib.Empty(CPLib.LRTrim(pAzienda))?"snai":pAzienda));
          f.SetParameter("m_cURL",pURL);
          f.SetParameter("m_cURLOnError",pURLOE);
          f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          /* Stop cp_login */
          Forward f;
          f=new Forward("cp_login",false,this,Forward.Execute,false);
          f.SetParameter("m_cUserName",pUser);
          f.SetParameter("m_cPassword","errore");
          f.SetParameter("m_cAction","login");
          f.SetParameter("g_codazi",pAzienda);
          f.SetParameter("m_cURL",pURL);
          f.SetParameter("m_cURLOnError",pURLOE);
          f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
      } else { // Else
        /* Utilities.SetCompany(LRTrim(pAzienda)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(pAzienda));
        /* _tip := '' */
        _tip = "";
        /* _ltip := 0 */
        _ltip = CPLib.Round(0,0);
        /* _ntip := 0 */
        _ntip = CPLib.Round(0,0);
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _tip := intermbo->TESTIP */
          _tip = Cursor_intermbo.GetString("TESTIP");
          /* _ltip := Len(LRTrim(_tip)) */
          _ltip = CPLib.Round(CPLib.Len(CPLib.LRTrim(_tip)),0);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* If _ltip = 0 */
        if (CPLib.eqr(_ltip,0)) {
          // * --- Select from cgo_subnet
          m_cServer = m_Ctx.GetServer("cgo_subnet");
          m_cPhName = m_Ctx.GetPhName("cgo_subnet");
          if (Cursor_cgo_subnet!=null)
            Cursor_cgo_subnet.Close();
          Cursor_cgo_subnet = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNSUBNET  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_subnet")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_subnet.Eof())) {
            /* _ntip := _ntip + 1 */
            _ntip = CPLib.Round(_ntip+1,0);
            Cursor_cgo_subnet.Next();
          }
          m_cConnectivityError = Cursor_cgo_subnet.ErrorMessage();
          Cursor_cgo_subnet.Close();
          // * --- End Select
        } // End If
        /* gUtility := '' // Gestione menu utility */
        gUtility = "";
        m_Ctx.SetGlobalString("gUtility",gUtility);
        /* If FileLibMit.ExistFile(LRTrim(_pathdoc)+'/conf.azi') and not(Empty(_pathdoc)) */
        if (FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/conf.azi") &&  ! (CPLib.Empty(_pathdoc))) {
          /* fhand := FileLibMit.OpenReadPath(LRTrim(_pathdoc)+'/conf.azi') */
          fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(_pathdoc)+"/conf.azi");
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _maxazi := Val(LRTrim(riga)) / 3141592 */
          _maxazi = CPLib.Round(CPLib.Val(CPLib.LRTrim(riga))/3141592,0);
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* ElseIf FileLibMit.ExistFile('conf.azi') */
        } else if (FileLibMit.ExistFile("conf.azi")) {
          /* fhand := FileLibMit.OpenRead('conf.azi') */
          fhand = FileLibMit.OpenRead("conf.azi");
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _maxazi := Val(LRTrim(riga)) / 3141592 */
          _maxazi = CPLib.Round(CPLib.Val(CPLib.LRTrim(riga))/3141592,0);
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
        } else { // Else
          /* _maxazi := 1 */
          _maxazi = CPLib.Round(1,0);
        } // End If
        /* If not(FileLibMit.ExistFile('conf.lic')) */
        if ( ! (FileLibMit.ExistFile("conf.lic"))) {
          /* _blocco := 1 */
          _blocco = CPLib.Round(1,0);
        } else { // Else
          /* fhand := FileLibMit.OpenRead('conf.lic') */
          fhand = FileLibMit.OpenRead("conf.lic");
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _blocco := iif(CriptoLibrary.decodeBase64(LRTrim(riga))='0',0,1) */
          _blocco = CPLib.Round((CPLib.eqr(CriptoLibrary.decodeBase64(CPLib.LRTrim(riga)),"0")?0:1),0);
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
        } // End If
        /* Verifica ilnumero di aziende già presenti su cpazi */
        /* _aziext := 0 */
        _aziext = CPLib.Round(0,0);
        // * --- Select from cpazi
        m_cServer = m_Ctx.GetServer("cpazi");
        m_cPhName = m_Ctx.GetPhName("cpazi");
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
        Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpazi.Eof())) {
          /* _aziext := _aziext + 1 */
          _aziext = CPLib.Round(_aziext+1,0);
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
        /* If _aziext > _maxazi */
        if (CPLib.gt(_aziext,_maxazi)) {
          /* Stop jsp/index.jsp */
          Forward f;
          f=new Forward("../jsp/index.jsp",false,this,Forward.NoStatus,true);
          f.SetParameter("m_cFailedLoginReason","Attenzione ! Superato numero massimo aziende. Contattare l'assistenza");
          f.SetParameter("m_cParameterSequence","m_cFailedLoginReason");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
          /* ElseIf _blocco=1 */
        } else if (CPLib.eqr(_blocco,1)) {
          /* Stop jsp/index.jsp */
          Forward f;
          f=new Forward("../jsp/index.jsp",false,this,Forward.NoStatus,true);
          f.SetParameter("m_cFailedLoginReason","Attenzione ! Errore imprevisto nell'applicazione. Contattare l'assistenza");
          f.SetParameter("m_cParameterSequence","m_cFailedLoginReason");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
          /* ElseIf Empty(LRTrim(pAzienda)) */
        } else if (CPLib.Empty(CPLib.LRTrim(pAzienda))) {
          /* Stop jsp/index.jsp */
          Forward f;
          f=new Forward("../jsp/index.jsp",false,this,Forward.NoStatus,true);
          f.SetParameter("m_cFailedLoginReason","Attenzione ! Azienda non settata correttamente");
          f.SetParameter("m_cParameterSequence","m_cFailedLoginReason");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          /* If _ltip > 0 or _ntip > 0 */
          if (CPLib.gt(_ltip,0) || CPLib.gt(_ntip,0)) {
            /* _nfind := 0 */
            _nfind = CPLib.Round(0,0);
            /* If _ltip > 0 */
            if (CPLib.gt(_ltip,0)) {
              /* If Left(pIPC,_ltip) = Left(_tip,_ltip) */
              if (CPLib.eqr(CPLib.Left(pIPC,_ltip),CPLib.Left(_tip,_ltip))) {
                /* _nfind := 1 */
                _nfind = CPLib.Round(1,0);
              } // End If
              /* ElseIf _ntip > 0 */
            } else if (CPLib.gt(_ntip,0)) {
              // * --- Select from cgo_subnet
              m_cServer = m_Ctx.GetServer("cgo_subnet");
              m_cPhName = m_Ctx.GetPhName("cgo_subnet");
              if (Cursor_cgo_subnet!=null)
                Cursor_cgo_subnet.Close();
              Cursor_cgo_subnet = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNSUBNET  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_subnet")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_cgo_subnet.Eof())) {
                /* _ltip := Len(LRTrim(cgo_subnet->SNSUBNET)) */
                _ltip = CPLib.Round(CPLib.Len(CPLib.LRTrim(Cursor_cgo_subnet.GetString("SNSUBNET"))),0);
                /* If Left(pIPC,_ltip) = Left(cgo_subnet->SNSUBNET,_ltip) */
                if (CPLib.eqr(CPLib.Left(pIPC,_ltip),CPLib.Left(Cursor_cgo_subnet.GetString("SNSUBNET"),_ltip))) {
                  /* _nfind := 1 */
                  _nfind = CPLib.Round(1,0);
                } // End If
                Cursor_cgo_subnet.Next();
              }
              m_cConnectivityError = Cursor_cgo_subnet.ErrorMessage();
              Cursor_cgo_subnet.Close();
              // * --- End Select
            } // End If
            /* If _nfind=1 */
            if (CPLib.eqr(_nfind,1)) {
              /* If Empty(_otp) and gOTP='S' */
              if (CPLib.Empty(_otp) && CPLib.eqr(gOTP,"S")) {
                /* Stop cp_login */
                Forward f;
                f=new Forward("cp_login",false,this,Forward.Execute,false);
                f.SetParameter("m_cUserName",pUser);
                f.SetParameter("m_cPassword",pPwd);
                f.SetParameter("m_cAction","login");
                f.SetParameter("g_codazi",pAzienda);
                f.SetParameter("m_cURL","jsp/spadministration_users_otp_cgo_portlet.jsp");
                f.SetParameter("m_cURLOnError",pURLOE);
                f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
                f.SetParameter("m_cMode","hyperlink");
                throw f;
              } else { // Else
                /* Stop cp_login */
                Forward f;
                f=new Forward("cp_login",false,this,Forward.Execute,false);
                f.SetParameter("m_cUserName",pUser);
                f.SetParameter("m_cPassword",pPwd);
                f.SetParameter("m_cAction","login");
                f.SetParameter("g_codazi",pAzienda);
                f.SetParameter("m_cURL",pURL);
                f.SetParameter("m_cURLOnError",pURLOE);
                f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
                f.SetParameter("m_cMode","hyperlink");
                throw f;
              } // End If
            } else { // Else
              /* Stop cp_login */
              Forward f;
              f=new Forward("cp_login",false,this,Forward.Execute,false);
              f.SetParameter("m_cUserName",pUser);
              f.SetParameter("m_cPassword","errore");
              f.SetParameter("m_cAction","login");
              f.SetParameter("g_codazi",pAzienda);
              f.SetParameter("m_cURL",pURL);
              f.SetParameter("m_cURLOnError",pURLOE);
              f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
              f.SetParameter("m_cMode","hyperlink");
              throw f;
            } // End If
          } else { // Else
            /* If Empty(_otp) and gOTP='S' */
            if (CPLib.Empty(_otp) && CPLib.eqr(gOTP,"S")) {
              /* Stop cp_login */
              Forward f;
              f=new Forward("cp_login",false,this,Forward.Execute,false);
              f.SetParameter("m_cUserName",pUser);
              f.SetParameter("m_cPassword",pPwd);
              f.SetParameter("m_cAction","login");
              f.SetParameter("g_codazi",pAzienda);
              f.SetParameter("m_cURL","jsp/spadministration_users_otp_cgo_portlet.jsp");
              f.SetParameter("m_cURLOnError",pURLOE);
              f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
              f.SetParameter("m_cMode","hyperlink");
              throw f;
            } else { // Else
              /* Stop cp_login */
              Forward f;
              f=new Forward("cp_login",false,this,Forward.Execute,false);
              f.SetParameter("m_cUserName",pUser);
              f.SetParameter("m_cPassword",pPwd);
              f.SetParameter("m_cAction","login");
              f.SetParameter("g_codazi",pAzienda);
              f.SetParameter("m_cURL",pURL);
              f.SetParameter("m_cURLOnError",pURLOE);
              f.SetParameter("m_cParameterSequence","m_cUserName"+","+"m_cPassword"+","+"m_cAction"+","+"g_codazi"+","+"m_cURL"+","+"m_cURLOnError");
              f.SetParameter("m_cMode","hyperlink");
              throw f;
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
      try {
        if (Cursor_cpusrgrp!=null)
          Cursor_cpusrgrp.Close();
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
        if (Cursor_cgo_subnet!=null)
          Cursor_cgo_subnet.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* _header := "POST "+LRTrim(_skt_paths)+" HTTP/1.0\r\n;Host: "+LRTrim(_skt_server)+"\r\n;Content-Type:application/x-www-form-urlencoded\r\n;Content-length:"+LRTrim(Str(_ldati,10,0))+"\r\n;Connection: close\r\n" */
    _header = "POST "+CPLib.LRTrim(_skt_paths)+" HTTP/1.0\\r\\n;Host: "+CPLib.LRTrim(_skt_server)+"\\r\\n;Content-Type:application/x-www-form-urlencoded\\r\\n;Content-length:"+CPLib.LRTrim(CPLib.Str(_ldati,10,0))+"\\r\\n;Connection: close\\r\\n";
    //Connection to the socket
    Socket socket = null;
    SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
    socket = ssf.createSocket(CPLib.LRTrim(_skt_server),(int)_skt_port);
    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    oos.writeObject(CPLib.LRTrim(_header)+CPLib.LRTrim(_dati)+CPLib.LRTrim(_dati64));
    //
    // Read and display the response message sent by server application
    //
    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    String message = (String) ois.readObject();
    ois.close();
    oos.close();
  }
  void Page_3() throws Exception {
    // Test
    String data = URLEncoder.encode("mode", "UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8");
    data = data+"&"+URLEncoder.encode("StringXML", "UTF-8") + "=" + _dati64;
      
    Socket socket = new Socket(CPLib.LRTrim(_skt_server), (int)_skt_port);
    String path = CPLib.LRTrim(_skt_paths);
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
    wr.write("POST " + path + " HTTP/1.0\r\nContent-Length: " + data.length() + "\r\nContent-Type: application/x-www-form-urlencoded\r\n\r\n"+data+"\r\n");
    wr.flush();
    
    BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
       _ritorno=_ritorno+line;
    }
    wr.close();
    rd.close();
    /* If At('<abilitazione>1</abilitazione>',_ritorno) <> 0 */
    if (CPLib.ne(CPLib.At("<abilitazione>1</abilitazione>",_ritorno),0)) {
      /* _accesso := '1' */
      _accesso = "1";
    } else { // Else
      /* _accesso := '0' */
      _accesso = "0";
    } // End If
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
      m_Caller.SetString("pUser","C",20,0,pUser);
      m_Caller.SetString("pPwd","C",20,0,pPwd);
      m_Caller.SetString("pAzienda","C",10,0,pAzienda);
      m_Caller.SetString("pURL","C",50,0,pURL);
      m_Caller.SetString("pURLOE","C",50,0,pURLOE);
      m_Caller.SetString("pOTP","C",6,0,pOTP);
      m_Caller.SetString("pIPC","C",20,0,pIPC);
      m_Caller.SetString("pIPS","C",120,0,pIPS);
      m_Caller.SetString("pIPSP","C",20,0,pIPSP);
      m_Caller.SetString("pIPRP","C",20,0,pIPRP);
      m_Caller.SetString("pBrowser","C",128,0,pBrowser);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static seamless_loginR Make(CPContext p_Ctx, Caller p_Caller) {
    return new seamless_loginR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pUser = m_Caller.GetString("pUser","C",20,0);
    pPwd = m_Caller.GetString("pPwd","C",20,0);
    pAzienda = m_Caller.GetString("pAzienda","C",10,0);
    pURL = m_Caller.GetString("pURL","C",50,0);
    pURLOE = m_Caller.GetString("pURLOE","C",50,0);
    pOTP = m_Caller.GetString("pOTP","C",6,0);
    pIPC = m_Caller.GetString("pIPC","C",20,0);
    pIPS = m_Caller.GetString("pIPS","C",120,0);
    pIPSP = m_Caller.GetString("pIPSP","C",20,0);
    pIPRP = m_Caller.GetString("pIPRP","C",20,0);
    pBrowser = m_Caller.GetString("pBrowser","C",128,0);
    _path = CPLib.Space(120);
    _skt_server = CPLib.Space(30);
    _skt_paths = CPLib.Space(60);
    _skt_port = 0;
    _skt_mode = CPLib.Space(5);
    _skt_connes = CPLib.Space(50);
    _header = "";
    _ritorno = "";
    _dati = CPLib.Space(512);
    _dati64 = CPLib.Space(512);
    _ldati = 0;
    _isr = null;
    _usrcode = 0;
    _isadm = 0;
    _muser = CPLib.Space(50);
    _mutil = 0;
    _accesso = CPLib.Space(1);
    _tip = CPLib.Space(10);
    _ltip = 0;
    _ntip = 0;
    _nfind = 0;
    fhand = CPLib.Space(10);
    riga = CPLib.Space(100);
    _maxazi = 0;
    _aziext = 0;
    _blocco = 0;
    pippo = CPLib.Space(26);
    _pathdoc = CPLib.Space(250);
    _otp = CPLib.Space(100);
    _superdip = CPLib.Space(1);
    gUtility=m_Ctx.GetGlobalString("gUtility");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
    gIPP=m_Ctx.GetGlobalString("gIPP");
    gBrowser=m_Ctx.GetGlobalString("gBrowser");
    gOTP=m_Ctx.GetGlobalString("gOTP");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
