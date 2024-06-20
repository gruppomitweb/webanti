// * --- Area Manuale = BO - Header
// * --- arrt_seekpep_rs_ver
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
public class arrt_seekpep_rs_verR implements CallerWithObjs {
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
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String pTicket;
  public String pDataTic;
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
  public String _ticket;
  public String _urlstr;
  public String _result;
  public String gPathAppl;
  public String gIPC;
  public String gAppPath;
  public String gPathPrat;
  public String gMsgImp;
  public double gUserCode;
  public String gUtente;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_seekpep_rs_ver
  public ArrayList<NameValuePair> nvPairList;
  public StringEntity _params;
  public String encoded;
  // * --- Fine Area Manuale
  public arrt_seekpep_rs_verR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_seekpep_rs_ver",m_Caller);
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_seekpep_rs_ver";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTicket",p_cVarName)) {
      return pTicket;
    }
    if (CPLib.eqr("pDataTic",p_cVarName)) {
      return pDataTic;
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
    if (CPLib.eqr("_ticket",p_cVarName)) {
      return _ticket;
    }
    if (CPLib.eqr("_urlstr",p_cVarName)) {
      return _urlstr;
    }
    if (CPLib.eqr("_result",p_cVarName)) {
      return _result;
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTicket",p_cVarName)) {
      pTicket = value;
      return;
    }
    if (CPLib.eqr("pDataTic",p_cVarName)) {
      pDataTic = value;
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
    if (CPLib.eqr("_ticket",p_cVarName)) {
      _ticket = value;
      return;
    }
    if (CPLib.eqr("_urlstr",p_cVarName)) {
      _urlstr = value;
      return;
    }
    if (CPLib.eqr("_result",p_cVarName)) {
      _result = value;
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
      /* pTicket Char(40) */
      /* pDataTic Char(8) */
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
      /* _ticket Char(40) */
      /* _urlstr Char(128) */
      /* _result Char(3) */
      /* gPathAppl Char(150) // Path Installazione */
      /* gIPC Char(20) // IP Client */
      /* gAppPath Char(80) // Path Applicazione */
      /* gPathPrat Char(100) // Cartella Documenti */
      /* gMsgImp Char(120) // Messaggi Elaborazione */
      /* gUserCode Numeric(10, 0) // Utente SP */
      /* gUtente Char(10) // Codice Utente */
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
      /* Exec "Verifica la fase del ticket" Page 3:Page_3 */
      Page_3();
      /* Return Val(_result) */
      throw new Stop(CPLib.Val(_result));
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
    /* _dataver Char(8) */
    String _dataver;
    _dataver = CPLib.Space(8);
    double nTry0000003Bstatus;
    nTry0000003Bstatus = m_Sql.GetTransactionStatus();
    String cTry0000003Bmsg;
    cTry0000003Bmsg = m_Sql.TransactionErrorMessage();
    try {
      /* _dataver := iif(Empty(pDataTic),DateToChar(Date()),pDataTic) */
      _dataver = (CPLib.Empty(pDataTic)?CPLib.DateToChar(CPLib.Date()):pDataTic);
      /* Colloquoi XML */
      /* httpClient := new DefaultHttpClient() */
      httpClient = new DefaultHttpClient();
      /* _urlstr := LRTrim("https://geniocom.it/bbi-api/services/Bbi/richiediServizio") */
      _urlstr = CPLib.LRTrim("https://geniocom.it/bbi-api/services/Bbi/richiediServizio");
      /* httpGetRequest := new HttpGet(_urlstr) */
      httpGetRequest = new HttpGet(_urlstr);
      // Crea stringa autorizzazione
      String auth = CPLib.LRTrim(_utews) + ":" + CPLib.LRTrim(_pwdws);
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      encoded=new String(encodedAuth);
      
      // Crea variabile per lista parametri
      nvPairList= new ArrayList<NameValuePair>();
      // Settaggio parametri
      NameValuePair nv1 = new BasicNameValuePair("tipo","LISAREADXML");
      nvPairList.add(nv1);
      NameValuePair nv2 = new BasicNameValuePair("parametri.DATADA",_dataver);
      nvPairList.add(nv2);
      NameValuePair nv3 = new BasicNameValuePair("parametri.DATAA",_dataver);
      nvPairList.add(nv3);
      
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000003Bstatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000003Bstatus,cTry0000003Bmsg);
      }
    }
  }
  void Page_3() throws Exception {
    // Legge
    JSONObject jsonObject = new JSONObject(XML.toJSONObject(_risposta).toString());
    /* _result := "0" */
    _result = "0";
    /* If jsonObject.has("RECORD") */
    if (jsonObject.has("RECORD")) {
      // Crea oggetto per lettura
      JSONObject jsonRecord = jsonObject.getJSONObject("RECORD");
      /* If jsonRecord.has("REPORT") */
      if (jsonRecord.has("REPORT")) {
        // Crea oggetto per lettura
        JSONObject jsonReport = jsonRecord.getJSONObject("REPORT");
        /* If jsonReport.has("RICORRENZA") */
        if (jsonReport.has("RICORRENZA")) {
          // Crea oggetti per esecutore
          if (jsonReport.get("RICORRENZA") instanceof JSONArray) {
          JSONArray jSONList=jsonReport.getJSONArray("RICORRENZA");
          for (int _i = 0; CPLib.ne(_i,jSONList.length()); _i = _i + (1)) {
            // Crea oggetto per titolari effettivi
            JSONObject jsonRicorrenza=jSONList.getJSONObject(_i);
            /* If jsonRicorrenza.get("TICKET").toString()=pTicket */
            if (CPLib.eqr(jsonRicorrenza.get("TICKET").toString(),pTicket)) {
              /* _result := jsonRicorrenza.get("FASE").toString() */
              _result = jsonRicorrenza.get("FASE").toString();
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          }
          // Chiude IF
          } else {
          // Apre Else
          // Crea oggetto per titolari effettivi
          JSONObject jsonRicorrenza=jsonReport.getJSONObject("RICORRENZA");
          /* If jsonRicorrenza.get("TICKET").toString()=pTicket */
          if (CPLib.eqr(jsonRicorrenza.get("TICKET").toString(),pTicket)) {
            /* _result := jsonRicorrenza.get("FASE").toString() */
            _result = jsonRicorrenza.get("FASE").toString();
          } // End If
          // Chiude else
          } 
        } // End If
      } // End If
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_pTicket,String p_pDataTic) {
    pTicket = p_pTicket;
    pDataTic = p_pDataTic;
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
  public double Run(String p_pTicket,String p_pDataTic) {
    pTicket = p_pTicket;
    pDataTic = p_pDataTic;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_seekpep_rs_verR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_seekpep_rs_verR(p_Ctx, p_Caller);
  }
  public static arrt_seekpep_rs_verR Make(CPContext p_Ctx) {
    return new arrt_seekpep_rs_verR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pTicket = CPLib.Space(40);
    pDataTic = CPLib.Space(8);
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
    _ticket = CPLib.Space(40);
    _urlstr = CPLib.Space(128);
    _result = CPLib.Space(3);
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
  // ENTITY_BATCHES: ,arrt_seekpep_rs_ver,
  public static final String i_InvokedRoutines = ",arrt_seekpep_rs_ver,";
  public static String[] m_cRunParameterNames={"pTicket","pDataTic"};
}
