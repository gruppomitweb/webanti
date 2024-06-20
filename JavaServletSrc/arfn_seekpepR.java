// * --- Area Manuale = BO - Header
// * --- arfn_seekpep
import java.io.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.*;
import java.net.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.*;
import org.apache.http.message.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.entity.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import org.json.*;
import java.net.*;
import java.util.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.*;
import org.apache.http.message.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.entity.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import java.util.Base64;
// * --- Fine Area Manuale
public class arfn_seekpepR implements CallerWithObjs {
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
  public String m_cPhName_tmp_reppep;
  public String m_cServer_tmp_reppep;
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
  public String pRagSoc;
  public String pCodFisc;
  public String _file;
  public String _fname;
  public String _file2;
  public String _fname2;
  public String _nomefile;
  public String _memo;
  public String _msgerr;
  public String _uniquefile;
  public String _riga;
  public String _filename;
  public String _pdfrow;
  public String _cognome;
  public String _nome;
  public String _reportname;
  public String _reportvrp;
  public double _conta;
  public String _pathfile;
  public ReportLibrary _report;
  public boolean bReport;
  public String gPathAppl;
  public String gIPC;
  public String gAppPath;
  public String gPathPrat;
  public String gMsgImp;
  public double gUserCode;
  public String gUtente;
  public String _motinc;
  public String _catinc;
  public String _dateread;
  public double _perc;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_seekpep
  public ArrayList<NameValuePair> nvPairList;
  public StringEntity _params;
  public String encoded;
  // * --- Fine Area Manuale
  public arfn_seekpepR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_seekpep",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_reppep")) {
      m_cPhName_tmp_reppep = p_ContextObject.GetPhName("tmp_reppep");
      if (m_cPhName_tmp_reppep.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_reppep = m_cPhName_tmp_reppep+" "+m_Ctx.GetWritePhName("tmp_reppep");
      }
      m_cServer_tmp_reppep = p_ContextObject.GetServer("tmp_reppep");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    if (CPLib.eqr("_perc",p_cVarName)) {
      return _perc;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_seekpep";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRagSoc",p_cVarName)) {
      return pRagSoc;
    }
    if (CPLib.eqr("pCodFisc",p_cVarName)) {
      return pCodFisc;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("_fname",p_cVarName)) {
      return _fname;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_fname2",p_cVarName)) {
      return _fname2;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_memo",p_cVarName)) {
      return _memo;
    }
    if (CPLib.eqr("_msgerr",p_cVarName)) {
      return _msgerr;
    }
    if (CPLib.eqr("_uniquefile",p_cVarName)) {
      return _uniquefile;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_pdfrow",p_cVarName)) {
      return _pdfrow;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      return _reportname;
    }
    if (CPLib.eqr("_reportvrp",p_cVarName)) {
      return _reportvrp;
    }
    if (CPLib.eqr("_pathfile",p_cVarName)) {
      return _pathfile;
    }
    if (CPLib.eqr("gPathAppl",p_cVarName)) {
      return gPathAppl;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gAppPath",p_cVarName)) {
      return gAppPath;
    }
    if (CPLib.eqr("gPathPrat",p_cVarName)) {
      return gPathPrat;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      return gUtente;
    }
    if (CPLib.eqr("_motinc",p_cVarName)) {
      return _motinc;
    }
    if (CPLib.eqr("_catinc",p_cVarName)) {
      return _catinc;
    }
    if (CPLib.eqr("_dateread",p_cVarName)) {
      return _dateread;
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
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
    }
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
    if (CPLib.eqr("_perc",p_cVarName)) {
      _perc = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pRagSoc",p_cVarName)) {
      pRagSoc = value;
      return;
    }
    if (CPLib.eqr("pCodFisc",p_cVarName)) {
      pCodFisc = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("_fname",p_cVarName)) {
      _fname = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("_fname2",p_cVarName)) {
      _fname2 = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_memo",p_cVarName)) {
      _memo = value;
      return;
    }
    if (CPLib.eqr("_msgerr",p_cVarName)) {
      _msgerr = value;
      return;
    }
    if (CPLib.eqr("_uniquefile",p_cVarName)) {
      _uniquefile = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_pdfrow",p_cVarName)) {
      _pdfrow = value;
      return;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      _cognome = value;
      return;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      _nome = value;
      return;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      _reportname = value;
      return;
    }
    if (CPLib.eqr("_reportvrp",p_cVarName)) {
      _reportvrp = value;
      return;
    }
    if (CPLib.eqr("_pathfile",p_cVarName)) {
      _pathfile = value;
      return;
    }
    if (CPLib.eqr("gPathAppl",p_cVarName)) {
      gPathAppl = value;
      return;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gAppPath",p_cVarName)) {
      gAppPath = value;
      return;
    }
    if (CPLib.eqr("gPathPrat",p_cVarName)) {
      gPathPrat = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      gUtente = value;
      return;
    }
    if (CPLib.eqr("_motinc",p_cVarName)) {
      _motinc = value;
      return;
    }
    if (CPLib.eqr("_catinc",p_cVarName)) {
      _catinc = value;
      return;
    }
    if (CPLib.eqr("_dateread",p_cVarName)) {
      _dateread = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
      return;
    }
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
    /* pRagSoc Char(160) */
    /* pCodFisc Char(16) */
    /* _file Char(10) */
    /* _fname Char(80) */
    /* _file2 Char(10) */
    /* _fname2 Char(80) */
    /* _nomefile Char(14) */
    /* _memo Char(100) */
    /* _msgerr Memo */
    /* _uniquefile Char(36) */
    /* _riga Memo */
    /* _filename Char(40) */
    /* _pdfrow Memo */
    /* _cognome Char(30) */
    /* _nome Char(30) */
    /* _reportname Char(60) */
    /* _reportvrp Char(60) */
    /* _conta Numeric(3, 0) */
    /* _pathfile Char(128) */
    /* _report Object(ReportLibrary) */
    /* bReport Bool */
    /* gPathAppl Char(150) // Path Installazione */
    /* gIPC Char(20) // IP Client */
    /* gAppPath Char(80) // Path Applicazione */
    /* gPathPrat Char(100) // Cartella Documenti */
    /* gMsgImp Char(120) // Messaggi Elaborazione */
    /* gUserCode Numeric(10, 0) // Utente SP */
    /* gUtente Char(10) // Codice Utente */
    /* Legge utente e password per CRIF */
    // * --- Create temporary table tmp_reppep
    if (m_Ctx.IsSharedTemp("tmp_reppep")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_reppep")) {
        m_cServer = m_Ctx.GetServer("tmp_reppep");
        m_cPhName = m_Ctx.GetPhName("tmp_reppep");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_reppep");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_reppep");
    if ( ! (m_Ctx.IsSharedTemp("tmp_reppep"))) {
      m_cServer = m_Ctx.GetServer("tmp_reppep");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_reppep",m_cServer,"proto")),m_cPhName,"tmp_reppep",m_Ctx);
    }
    m_cPhName_tmp_reppep = m_cPhName;
    /* Exec "Legge il JSon" Page 2:Page_2 */
    Page_2();
    /* Exec "CRea Report" Page 3:Page_3 */
    Page_3();
    /* Return _reportname */
    throw new Stop(_reportname);
  }
  void Page_2() throws Exception {
    /* _cflegale Char(16) */
    String _cflegale;
    _cflegale = CPLib.Space(16);
    /* _codcli Char(10) */
    String _codcli;
    _codcli = CPLib.Space(10);
    /* _idbcli Char(10) */
    String _idbcli;
    _idbcli = CPLib.Space(10);
    /* _luonas Char(60) */
    String _luonas;
    _luonas = CPLib.Space(60);
    /* _prvnas Char(3) */
    String _prvnas;
    _prvnas = CPLib.Space(3);
    /* _anas Char(4) */
    String _anas;
    _anas = CPLib.Space(4);
    /* _mnas Char(2) */
    String _mnas;
    _mnas = CPLib.Space(2);
    /* _gnas Char(2) */
    String _gnas;
    _gnas = CPLib.Space(2);
    /* _lenateco Numeric(2, 0) */
    double _lenateco;
    _lenateco = 0;
    /* _datanas Date */
    java.sql.Date _datanas;
    _datanas = CPLib.NullDate();
    /* _datamor Date */
    java.sql.Date _datamor;
    _datamor = CPLib.NullDate();
    /* _motinc Memo */
    /* _catinc Char(128) */
    /* _dateread Char(50) */
    /* _perc Numeric(6, 2) */
    /* _file := FileLibMit.OpenReadPath(LRTrim(gPathPrat)+"/Soggetti/"+LRTrim(pCodFisc)+"/PEP_"+LRTrim(pCodFisc)+".xml") */
    _file = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathPrat)+"/Soggetti/"+CPLib.LRTrim(pCodFisc)+"/PEP_"+CPLib.LRTrim(pCodFisc)+".xml");
    /* _riga := FileLibMit.ReadLine(_file) */
    _riga = FileLibMit.ReadLine(_file);
    // Legge
    JSONObject jsonObject = new JSONObject(XML.toJSONObject(_riga).toString());
    FileLibMit.Close(_file);
    /* _conta := 0 */
    _conta = CPLib.Round(0,0);
    /* If jsonObject.has("ns2:trovaPEPResponse") */
    if (jsonObject.has("ns2:trovaPEPResponse")) {
      // Crea oggetto per lettura
      JSONObject jsonTotal = jsonObject.getJSONObject("ns2:trovaPEPResponse");
      /* If jsonTotal.has("output") */
      if (jsonTotal.has("output")) {
        // Crea oggetti per esecutore
        if (jsonTotal.get("output") instanceof JSONArray) {
        JSONArray jSONList=jsonTotal.getJSONArray("output");
        for (int _i = 0; CPLib.ne(_i,jSONList.length()); _i = _i + (1)) {
          // Crea oggetto per titolari effettivi
          JSONObject jsonSoggetto=jSONList.getJSONObject(_i);
          /* _cognome := jsonSoggetto.get("cognome").toString() */
          _cognome = jsonSoggetto.get("cognome").toString();
          /* _nome := jsonSoggetto.get("nome").toString() */
          _nome = jsonSoggetto.get("nome").toString();
          /* If jsonSoggetto.has("dataMorte") */
          if (jsonSoggetto.has("dataMorte")) {
            /* _dateread := '' */
            _dateread = "";
            /* _datamor := NullDate() */
            _datamor = CPLib.NullDate();
          } else { // Else
            /* _datamor := NullDate() */
            _datamor = CPLib.NullDate();
          } // End If
          /* If jsonSoggetto.has("dataNascita") */
          if (jsonSoggetto.has("dataNascita")) {
            /* _dateread := jsonSoggetto.get("dataNascita").toString() */
            _dateread = jsonSoggetto.get("dataNascita").toString();
            /* _anas := Left(_dateread,4) */
            _anas = CPLib.Left(_dateread,4);
            /* _mnas := Substr(_dateread,6,2) */
            _mnas = CPLib.Substr(_dateread,6,2);
            /* _gnas := Substr(_dateread,9,2) */
            _gnas = CPLib.Substr(_dateread,9,2);
            /* _datanas := CharToDate(_anas+_mnas+_gnas) */
            _datanas = CPLib.CharToDate(_anas+_mnas+_gnas);
          } else { // Else
            /* _datanas := NullDate() */
            _datanas = CPLib.NullDate();
          } // End If
          /* If jsonSoggetto.has("luogoNascita") */
          if (jsonSoggetto.has("luogoNascita")) {
            /* _luonas := Upper(jsonSoggetto.getJSONObject("luogoNascita").get("nome").toString()) */
            _luonas = CPLib.Upper(jsonSoggetto.getJSONObject("luogoNascita").get("nome").toString());
            /* _prvnas := Upper(jsonSoggetto.getJSONObject("luogoNascita").get("siglaProvincia").toString()) */
            _prvnas = CPLib.Upper(jsonSoggetto.getJSONObject("luogoNascita").get("siglaProvincia").toString());
          } // End If
          /* If jsonSoggetto.has("percentuale") */
          if (jsonSoggetto.has("percentuale")) {
            /* _perc := Val(jsonSoggetto.get("percentuale").toString()) */
            _perc = CPLib.Round(CPLib.Val(jsonSoggetto.get("percentuale").toString()),2);
          } // End If
          /* If jsonSoggetto.has("categoria") */
          if (jsonSoggetto.has("categoria")) {
            /* _catinc := jsonSoggetto.get("categoria").toString() */
            _catinc = jsonSoggetto.get("categoria").toString();
            /* _catinc := java.net.URLDecoder.decode(_catinc,"UTF-8") */
            _catinc = java.net.URLDecoder.decode(_catinc,"UTF-8");
          } // End If
          /* If jsonSoggetto.has("motivoInclusione") */
          if (jsonSoggetto.has("motivoInclusione")) {
            /* _motinc := jsonSoggetto.get("motivoInclusione").toString() */
            _motinc = jsonSoggetto.get("motivoInclusione").toString();
          } // End If
          // * --- Insert into tmp_reppep from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_reppep");
          m_cPhName = m_Ctx.GetPhName("tmp_reppep");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_reppep",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_seekpep",732,"00000058")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000058(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datanas,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datamor,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_catinc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvnas,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_perc,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motinc,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_reppep",true);
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
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        }
        // Chiude IF
        } else {
        // Apre Else
        System.out.println("Unico");
        // Chiude else
        } 
      } // End If
    } // End If
  }
  void Page_3() throws Exception {
    /* _reportname := 'Ricerca_PEP_'+LRTrim(pCodFisc)+".pdf" */
    _reportname = "Ricerca_PEP_"+CPLib.LRTrim(pCodFisc)+".pdf";
    /* If _conta=0 */
    if (CPLib.eqr(_conta,0)) {
      // * --- Insert into tmp_reppep from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_reppep");
      m_cPhName = m_Ctx.GetPhName("tmp_reppep");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_reppep",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arfn_seekpep",732,"0000005F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_0000005F(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_reppep",true);
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
      /* _reportvrp := "fwrp_ricerca_sogg_pep_neg.vrp" */
      _reportvrp = "fwrp_ricerca_sogg_pep_neg.vrp";
    } else { // Else
      /* _reportvrp := "fwrp_ricerca_sogg_pep_pos.vrp" */
      _reportvrp = "fwrp_ricerca_sogg_pep_pos.vrp";
    } // End If
    /* Crea il primo report */
    /* _pathfile := LRTrim(gPathPrat)+"/Soggetti/"+LRTrim(pCodFisc)+"/"+LRTrim(_reportname) */
    _pathfile = CPLib.LRTrim(gPathPrat)+"/Soggetti/"+CPLib.LRTrim(pCodFisc)+"/"+CPLib.LRTrim(_reportname);
    /* _report := ReportLibrary.GetReportLibrary() */
    _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
    /* _report.setParameterChar('denomin',pRagSoc) */
    _report.setParameterChar("denomin",pRagSoc);
    /* bReport := _report.makeReport(LRTrim(_reportvrp),_pathfile,"A4",iif(_conta=0,"PORTRAIT","LANDSCAPE"),'PDF') */
    bReport = _report.makeReport(CPLib.LRTrim(_reportvrp),_pathfile,"A4",(CPLib.eqr(_conta,0)?"PORTRAIT":"LANDSCAPE"),"PDF");
  }
  void _init_() {
  }
  public String RunAsync(String p_pRagSoc,String p_pCodFisc) {
    pRagSoc = p_pRagSoc;
    pCodFisc = p_pCodFisc;
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
  public String Run(String p_pRagSoc,String p_pCodFisc) {
    pRagSoc = p_pRagSoc;
    pCodFisc = p_pCodFisc;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_seekpepR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_seekpepR(p_Ctx, p_Caller);
  }
  public static arfn_seekpepR Make(CPContext p_Ctx) {
    return new arfn_seekpepR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRagSoc = CPLib.Space(160);
    pCodFisc = CPLib.Space(16);
    _file = CPLib.Space(10);
    _fname = CPLib.Space(80);
    _file2 = CPLib.Space(10);
    _fname2 = CPLib.Space(80);
    _nomefile = CPLib.Space(14);
    _memo = CPLib.Space(100);
    _msgerr = "";
    _uniquefile = CPLib.Space(36);
    _riga = "";
    _filename = CPLib.Space(40);
    _pdfrow = "";
    _cognome = CPLib.Space(30);
    _nome = CPLib.Space(30);
    _reportname = CPLib.Space(60);
    _reportvrp = CPLib.Space(60);
    _conta = 0;
    _pathfile = CPLib.Space(128);
    _report = null;
    bReport = false;
    _motinc = "";
    _catinc = CPLib.Space(128);
    _dateread = CPLib.Space(50);
    _perc = 0;
    gPathAppl=m_Ctx.GetGlobalString("gPathAppl");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gAppPath=m_Ctx.GetGlobalString("gAppPath");
    gPathPrat=m_Ctx.GetGlobalString("gPathPrat");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
    gUtente=m_Ctx.GetGlobalString("gUtente");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_seekpep,
  public static final String i_InvokedRoutines = ",arfn_seekpep,";
  public static String[] m_cRunParameterNames={"pRagSoc","pCodFisc"};
  protected static String GetFieldsName_00000058(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PEPCOG,";
    p_cSql = p_cSql+"PEPNOM,";
    p_cSql = p_cSql+"PEPNAS,";
    p_cSql = p_cSql+"PEPMOR,";
    p_cSql = p_cSql+"PEPCAT,";
    p_cSql = p_cSql+"PEPLNAS,";
    p_cSql = p_cSql+"PEPPNAS,";
    p_cSql = p_cSql+"PEPPER,";
    p_cSql = p_cSql+"PEPINC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_reppep",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PEPCOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_reppep",true);
    return p_cSql;
  }
}
