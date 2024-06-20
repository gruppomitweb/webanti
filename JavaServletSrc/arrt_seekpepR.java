// * --- Area Manuale = BO - Header
// * --- arrt_seekpep
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
public class arrt_seekpepR implements CallerWithObjs {
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
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public String _flgws;
  public String _urlws;
  public String _utews;
  public String _pwdws;
  public String _msgerr;
  public String _xml;
  public String _risposta;
  public InputStream inputStream;
  public BufferedReader streamReader;
  public StringBuilder responseStrBuilder;
  public InputStreamReader inputStreamReader;
  public String inputStr;
  public String _uniquefile;
  public String _riga;
  public String _filename;
  public String _pdfrow;
  public String xmlSource;
  public String _cognome;
  public String _nome;
  public MemoryCursor_mcpepstructure_mcrdef mcPEP;
  public String gPathAppl;
  public String gIPC;
  public String gPathDoc;
  public String gMsgImp;
  public String _motinc;
  public String _catinc;
  public String _dateread;
  public double _perc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_seekpep
  public ArrayList<NameValuePair> nvPairList;
  public StringEntity _params;
  public String encoded;
  // * --- Fine Area Manuale
  public arrt_seekpepR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_seekpep",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
      return "arrt_seekpep";
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
    if (CPLib.eqr("_flgws",p_cVarName)) {
      return _flgws;
    }
    if (CPLib.eqr("_urlws",p_cVarName)) {
      return _urlws;
    }
    if (CPLib.eqr("_utews",p_cVarName)) {
      return _utews;
    }
    if (CPLib.eqr("_pwdws",p_cVarName)) {
      return _pwdws;
    }
    if (CPLib.eqr("_msgerr",p_cVarName)) {
      return _msgerr;
    }
    if (CPLib.eqr("_xml",p_cVarName)) {
      return _xml;
    }
    if (CPLib.eqr("_risposta",p_cVarName)) {
      return _risposta;
    }
    if (CPLib.eqr("inputStr",p_cVarName)) {
      return inputStr;
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
    if (CPLib.eqr("xmlSource",p_cVarName)) {
      return xmlSource;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("gPathAppl",p_cVarName)) {
      return gPathAppl;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcPEP",p_cVarName)) {
      return mcPEP;
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
    if (CPLib.eqr("_flgws",p_cVarName)) {
      _flgws = value;
      return;
    }
    if (CPLib.eqr("_urlws",p_cVarName)) {
      _urlws = value;
      return;
    }
    if (CPLib.eqr("_utews",p_cVarName)) {
      _utews = value;
      return;
    }
    if (CPLib.eqr("_pwdws",p_cVarName)) {
      _pwdws = value;
      return;
    }
    if (CPLib.eqr("_msgerr",p_cVarName)) {
      _msgerr = value;
      return;
    }
    if (CPLib.eqr("_xml",p_cVarName)) {
      _xml = value;
      return;
    }
    if (CPLib.eqr("_risposta",p_cVarName)) {
      _risposta = value;
      return;
    }
    if (CPLib.eqr("inputStr",p_cVarName)) {
      inputStr = value;
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
    if (CPLib.eqr("xmlSource",p_cVarName)) {
      xmlSource = value;
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
    if (CPLib.eqr("gPathAppl",p_cVarName)) {
      gPathAppl = value;
      return;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcPEP",p_cVarName)) {
      mcPEP = (MemoryCursor_mcpepstructure_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* pRagSoc Char(160) */
      /* pCodFisc Char(16) */
      /* _file Char(10) */
      /* _fname Char(80) */
      /* _file2 Char(10) */
      /* _fname2 Char(80) */
      /* _nomefile Char(14) */
      /* _memo Char(100) */
      /* _flgws Char(1) */
      /* _urlws Char(80) */
      /* _utews Char(20) */
      /* _pwdws Char(50) */
      /* _msgerr Memo */
      /* _xml Memo */
      /* _risposta Memo */
      /* inputStream Object(InputStream) */
      /* streamReader Object(BufferedReader) */
      /* responseStrBuilder Object(StringBuilder) */
      /* inputStreamReader Object(InputStreamReader) */
      /* inputStr Memo */
      /* _uniquefile Char(36) */
      /* _riga Memo */
      /* _filename Char(40) */
      /* _pdfrow Memo */
      /* xmlSource Char(100) */
      /* _cognome Char(30) */
      /* _nome Char(30) */
      /* mcPEP MemoryCursor(mcPEPStructure.MCRDef) */
      /* gPathAppl Char(150) // Path Installazione */
      /* gIPC Char(20) // IP Client */
      /* gPathDoc Char(128) // Path Documenti */
      /* gMsgImp Char(120) // Messaggi Elaborazione */
      /* Legge utente e password per CRIF */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _flgws := intermbo->ITFLGPEP */
        _flgws = Cursor_intermbo.GetString("ITFLGPEP");
        /* _utews := intermbo->ITUSRPEP */
        _utews = Cursor_intermbo.GetString("ITUSRPEP");
        /* _pwdws := intermbo->ITPWDPEP */
        _pwdws = Cursor_intermbo.GetString("ITPWDPEP");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Exec "PEP" Page 2:Page_2 */
      Page_2();
      /* Exec "Crea memory Cursor" Page 3:Page_3 */
      Page_3();
      /* Return mcPEP */
      throw new Stop(mcPEP);
    } finally {
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
    /* httpClient Object(HttpClient) */
    HttpClient httpClient;
    httpClient = null;
    /* httpGetRequest Object(HttpGet) */
    HttpGet httpGetRequest;
    httpGetRequest = null;
    /* httpPostRequest Object(HttpPost) */
    HttpPost httpPostRequest;
    httpPostRequest = null;
    /* httpResponse Object(HttpResponse) */
    HttpResponse httpResponse;
    httpResponse = null;
    /* httpPostResponse Object(HttpResponse) */
    HttpResponse httpPostResponse;
    httpPostResponse = null;
    /* entity Object(HttpEntity) */
    HttpEntity entity;
    entity = null;
    /* jsonObj Object(JSONObject) */
    JSONObject jsonObj;
    jsonObj = null;
    /* _urlstr Char(128) */
    String _urlstr;
    _urlstr = CPLib.Space(128);
    double nTry00000035status;
    nTry00000035status = m_Sql.GetTransactionStatus();
    String cTry00000035msg;
    cTry00000035msg = m_Sql.TransactionErrorMessage();
    try {
      /* Colloquoi XML */
      /* httpClient := new DefaultHttpClient() */
      httpClient = new DefaultHttpClient();
      /* _urlstr := LRTrim("https://geniocom.it/bbi-api/services/lar/trovaPEP") */
      _urlstr = CPLib.LRTrim("https://geniocom.it/bbi-api/services/lar/trovaPEP");
      /* httpGetRequest := new HttpGet(_urlstr) */
      httpGetRequest = new HttpGet(_urlstr);
      // Crea variabile per lista parametri
      nvPairList= new ArrayList<NameValuePair>();
      // Settaggio parametri
      NameValuePair nv1 = new BasicNameValuePair("nominativo",CPLib.LRTrim(pRagSoc));
      nvPairList.add(nv1);
      
      // Crea stringa autorizzazione
      String auth = CPLib.LRTrim(_utews) + ":" + CPLib.LRTrim(_pwdws);
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      encoded=new String(encodedAuth);
      /* httpGetRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json") */
      httpGetRequest.addHeader(HttpHeaders.CONTENT_TYPE,"application/json");
      /* httpGetRequest.addHeader(HttpHeaders.AUTHORIZATION, "Basic "+encoded) */
      httpGetRequest.addHeader(HttpHeaders.AUTHORIZATION,"Basic "+encoded);
      // Crea Variabile URI
      URI _uri = new URIBuilder(httpGetRequest.getURI()).addParameters(nvPairList).build();
      /* httpGetRequest.setURI(_uri) */
      httpGetRequest.setURI(_uri);
      /* httpResponse := httpClient.execute(httpGetRequest) */
      httpResponse = httpClient.execute(httpGetRequest);
      /* If At('200',httpResponse.getStatusLine().toString()) > 0 */
      if (CPLib.gt(CPLib.At("200",httpResponse.getStatusLine().toString()),0)) {
        /* entity := httpResponse.getEntity() */
        entity = httpResponse.getEntity();
        /* inputStream := entity.getContent() */
        inputStream = entity.getContent();
        /* inputStreamReader := new InputStreamReader(inputStream) */
        inputStreamReader = new InputStreamReader(inputStream);
        /* streamReader := new BufferedReader(inputStreamReader) */
        streamReader = new BufferedReader(inputStreamReader);
        /* responseStrBuilder := new StringBuilder() */
        responseStrBuilder = new StringBuilder();
        //Legge la risposta
        while ((inputStr=streamReader.readLine()) != null) {
             responseStrBuilder.append(inputStr);
        }
        /* _risposta := responseStrBuilder.toString() */
        _risposta = responseStrBuilder.toString();
      } else { // Else
        /* System.out.println(httpResponse.getStatusLine().toString()) */
        System.out.println(httpResponse.getStatusLine().toString());
      } // End If
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000035status,0)) {
        m_Sql.SetTransactionStatus(nTry00000035status,cTry00000035msg);
      }
    }
  }
  void Page_3() throws Exception {
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
    /* _file := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/export/"+LRTrim(pCodFisc)+"/PEP_"+LRTrim(pCodFisc)+".xml") */
    _file = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(pCodFisc)+"/PEP_"+CPLib.LRTrim(pCodFisc)+".xml");
    // Legge
    JSONObject jsonObject = new JSONObject(XML.toJSONObject(_risposta).toString());
    FileLibMit.Write(_file,_risposta);
    FileLibMit.Close(_file);
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
          /* mcPEP.AppendBlank() */
          mcPEP.AppendBlank();
          /* mcPEP.PEPCOG := _cognome */
          mcPEP.row.PEPCOG = _cognome;
          /* mcPEP.PEPNOM := _nome */
          mcPEP.row.PEPNOM = _nome;
          /* mcPEP.PEPNAS := _datanas */
          mcPEP.row.PEPNAS = _datanas;
          /* mcPEP.PEPMOR := _datamor */
          mcPEP.row.PEPMOR = _datamor;
          /* mcPEP.PEPLNAS := _luonas */
          mcPEP.row.PEPLNAS = _luonas;
          /* mcPEP.PEPPNAS := _prvnas */
          mcPEP.row.PEPPNAS = _prvnas;
          /* mcPEP.PEPPER := _perc */
          mcPEP.row.PEPPER = _perc;
          /* mcPEP.PEPINC := _motinc */
          mcPEP.row.PEPINC = _motinc;
          /* mcPEP.PEPCAT := _catinc */
          mcPEP.row.PEPCAT = _catinc;
          /* mcPEP.SaveRow() */
          mcPEP.SaveRow();
        }
        // Chiude IF
        } else {
        // Apre Else
        System.out.println("Unico");
        // Chiude else
        } 
      } else { // Else
        /* mcPEP.AppendBlank() */
        mcPEP.AppendBlank();
        /* mcPEP.SaveRow() */
        mcPEP.SaveRow();
      } // End If
    } // End If
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
  public MemoryCursor_mcpepstructure_mcrdef Run(String p_pRagSoc,String p_pCodFisc) {
    pRagSoc = p_pRagSoc;
    pCodFisc = p_pCodFisc;
    return Run();
  }
  public MemoryCursor_mcpepstructure_mcrdef Run() {
    MemoryCursor_mcpepstructure_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursor_mcpepstructure_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arrt_seekpepR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_seekpepR(p_Ctx, p_Caller);
  }
  public static arrt_seekpepR Make(CPContext p_Ctx) {
    return new arrt_seekpepR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
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
    _flgws = CPLib.Space(1);
    _urlws = CPLib.Space(80);
    _utews = CPLib.Space(20);
    _pwdws = CPLib.Space(50);
    _msgerr = "";
    _xml = "";
    _risposta = "";
    inputStream = null;
    streamReader = null;
    responseStrBuilder = null;
    inputStreamReader = null;
    inputStr = "";
    _uniquefile = CPLib.Space(36);
    _riga = "";
    _filename = CPLib.Space(40);
    _pdfrow = "";
    xmlSource = CPLib.Space(100);
    _cognome = CPLib.Space(30);
    _nome = CPLib.Space(30);
    mcPEP = new MemoryCursor_mcpepstructure_mcrdef();
    _motinc = "";
    _catinc = CPLib.Space(128);
    _dateread = CPLib.Space(50);
    _perc = 0;
    gPathAppl=m_Ctx.GetGlobalString("gPathAppl");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_seekpep,
  public static final String i_InvokedRoutines = ",arrt_seekpep,";
  public static String[] m_cRunParameterNames={"pRagSoc","pCodFisc"};
}
