// * --- Area Manuale = BO - Header
// * --- arfn_catchfile
import com.openkm.ws.client.auth.OKMAuth;
import com.openkm.ws.client.auth.OKMAuth_Service;
import com.openkm.ws.client.document.OKMDocument;
import com.openkm.ws.client.document.OKMDocument_Service;
import com.openkm.ws.client.repository.OKMRepository;
import com.openkm.ws.client.repository.OKMRepository_Service;
import com.openkm.sdk4j.OKMWebservices;
import com.openkm.sdk4j.OKMWebservicesFactory;
import com.openkm.sdk4j.bean.Folder;
import com.openkm.sdk4j.bean.Document;
import com.openkm.sdk4j.bean.*;
import com.openkm.sdk4j.exception.*;
import java.util.*;
import java.io.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.FileUtils;
import javax.xml.namespace.QName;
import java.net.URL;
// * --- Fine Area Manuale
public class arfn_catchfileR implements CallerWithObjs {
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
  public String pID;
  public String pFile;
  public String pTipo;
  public String pCodDip;
  public String cRitorno;
  public String _nomedoc;
  public String _newdoc;
  public String _pathout;
  public String host;
  public String user;
  public String password;
  public String _nomeorg;
  public String utente;
  public boolean bDoc;
  public String uuid;
  public String gPathApp;
  public double gUserCode;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_catchfile
  public FileOutputStream os;
  private static QName AuthServiceName = new QName("http://ws.openkm.com", "OKMAuth");
  private static QName DocumentServiceName = new QName("http://ws.openkm.com", "OKMDocument");
  private static QName RepositoryServiceName = new QName("http://ws.openkm.com", "OKMRepository");
  
  public OKMAuth_Service authService = null;
  public OKMDocument_Service documentService = null;
  public OKMRepository_Service repoService = null;
  public OKMAuth okmAuth = null;
  public OKMDocument okmDocument = null;
  public OKMRepository okmRepository = null;
  // * --- Fine Area Manuale
  public arfn_catchfileR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_catchfile",m_Caller);
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
      return "arfn_catchfile";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pID",p_cVarName)) {
      return pID;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_nomedoc",p_cVarName)) {
      return _nomedoc;
    }
    if (CPLib.eqr("_newdoc",p_cVarName)) {
      return _newdoc;
    }
    if (CPLib.eqr("_pathout",p_cVarName)) {
      return _pathout;
    }
    if (CPLib.eqr("host",p_cVarName)) {
      return host;
    }
    if (CPLib.eqr("user",p_cVarName)) {
      return user;
    }
    if (CPLib.eqr("password",p_cVarName)) {
      return password;
    }
    if (CPLib.eqr("_nomeorg",p_cVarName)) {
      return _nomeorg;
    }
    if (CPLib.eqr("utente",p_cVarName)) {
      return utente;
    }
    if (CPLib.eqr("uuid",p_cVarName)) {
      return uuid;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("bDoc",p_cVarName)) {
      return bDoc;
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pID",p_cVarName)) {
      pID = value;
      return;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      pCodDip = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_nomedoc",p_cVarName)) {
      _nomedoc = value;
      return;
    }
    if (CPLib.eqr("_newdoc",p_cVarName)) {
      _newdoc = value;
      return;
    }
    if (CPLib.eqr("_pathout",p_cVarName)) {
      _pathout = value;
      return;
    }
    if (CPLib.eqr("host",p_cVarName)) {
      host = value;
      return;
    }
    if (CPLib.eqr("user",p_cVarName)) {
      user = value;
      return;
    }
    if (CPLib.eqr("password",p_cVarName)) {
      password = value;
      return;
    }
    if (CPLib.eqr("_nomeorg",p_cVarName)) {
      _nomeorg = value;
      return;
    }
    if (CPLib.eqr("utente",p_cVarName)) {
      utente = value;
      return;
    }
    if (CPLib.eqr("uuid",p_cVarName)) {
      uuid = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bDoc",p_cVarName)) {
      bDoc = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* pID Char(36) */
      /* pFile Char(120) */
      /* pTipo Char(1) // Tipo Estrazione */
      /* pCodDip Char(6) // Dipendenza */
      /* cRitorno Char(100) */
      /* _nomedoc Char(100) */
      /* _newdoc Char(100) */
      /* _pathout Char(128) */
      /* host Char(100) */
      /* user Char(100) */
      /* password Char(100) */
      /* _nomeorg Char(100) */
      /* utente Char(10) */
      /* bDoc Bool */
      /* uuid Char(36) */
      /* gPathApp Char(150) // Path Applicazione */
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* host := LRTrim(intermbo->URLDESDOC) */
        host = CPLib.LRTrim(Cursor_intermbo.GetString("URLDESDOC"));
        /* user := LRTrim(intermbo->USRGESDOC) */
        user = CPLib.LRTrim(Cursor_intermbo.GetString("USRGESDOC"));
        /* password := LRTrim(intermbo->PWDGESDOC) */
        password = CPLib.LRTrim(Cursor_intermbo.GetString("PWDGESDOC"));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* utente := Right('0000000000'+LRTrim(Str(gUserCode,4,0)),10) */
      utente = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(gUserCode,4,0)),10);
      /* _pathout := LRTrim(gPathApp)+"/appo/" */
      _pathout = CPLib.LRTrim(gPathApp)+"/appo/";
      /* FileLibMit.CreateDirPath(LRTrim(_pathout)+LRTrim(pCodDip)) */
      FileLibMit.CreateDirPath(CPLib.LRTrim(_pathout)+CPLib.LRTrim(pCodDip));
      /* cRitorno := "../appo/"+LRTrim(pCodDip)+"/"+LRTrim(pFile) */
      cRitorno = "../appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pFile);
      /* _nomedoc := "/okm:root/"+LRTrim(pID)+"/"+LRTrim(pFile) */
      _nomedoc = "/okm:root/"+CPLib.LRTrim(pID)+"/"+CPLib.LRTrim(pFile);
      /* _newdoc := LRTrim(gPathApp)+"/appo/"+LRTrim(pCodDip)+"/"+LRTrim(pFile) */
      _newdoc = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pFile);
      //
      // Ripulisce directory utente
      // Autentica in OpenKM
      authService = new OKMAuth_Service(new URL(host + "/services/OKMAuth?wsdl"), AuthServiceName);
      documentService = new OKMDocument_Service(new URL(host + "/services/OKMDocument?wsdl"), DocumentServiceName);
      repoService = new OKMRepository_Service(new URL(host + "/services/OKMRepository?wsdl"), RepositoryServiceName);
      okmAuth = authService.getOKMAuthPort();
      okmDocument = documentService.getOKMDocumentPort();
      okmRepository = repoService.getOKMRepositoryPort();
      // Login
      String token = okmAuth.login(user, password);
      try {
        bDoc=okmDocument.isValid(token,_nomedoc);
        uuid=okmRepository.getNodeUuid(token,_nomedoc);
      //  _newdoc=CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pFile);
      //  cRitorno="../appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(uuid);
      } catch (Exception e){
        bDoc=false;
      }
      if (bDoc) {
        OKMWebservices okm= OKMWebservicesFactory.newInstance(host, user, password);
        // Crea file da visualizzare 
        os=new FileOutputStream(CPLib.LRTrim(_newdoc));
        IOUtils.copy(okm.getContent(CPLib.LRTrim(_nomedoc)),os);
        os.flush(); 
        os.close();
      } else {
        // cRitorno=CPLib.LRTrim(_pathout)+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pFile);
        cRitorno="../appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pFile);
      }
      /* Return LRTrim(cRitorno) */
      throw new Stop(CPLib.LRTrim(cRitorno));
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
  void _init_() {
  }
  public String RunAsync(String p_pID,String p_pFile,String p_pTipo,String p_pCodDip) {
    pID = p_pID;
    pFile = p_pFile;
    pTipo = p_pTipo;
    pCodDip = p_pCodDip;
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
  public String Run(String p_pID,String p_pFile,String p_pTipo,String p_pCodDip) {
    pID = p_pID;
    pFile = p_pFile;
    pTipo = p_pTipo;
    pCodDip = p_pCodDip;
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
  public static arfn_catchfileR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_catchfileR(p_Ctx, p_Caller);
  }
  public static arfn_catchfileR Make(CPContext p_Ctx) {
    return new arfn_catchfileR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pID = CPLib.Space(36);
    pFile = CPLib.Space(120);
    pTipo = CPLib.Space(1);
    pCodDip = CPLib.Space(6);
    cRitorno = CPLib.Space(100);
    _nomedoc = CPLib.Space(100);
    _newdoc = CPLib.Space(100);
    _pathout = CPLib.Space(128);
    host = CPLib.Space(100);
    user = CPLib.Space(100);
    password = CPLib.Space(100);
    _nomeorg = CPLib.Space(100);
    utente = CPLib.Space(10);
    bDoc = false;
    uuid = CPLib.Space(36);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_catchfile,
  public static final String i_InvokedRoutines = ",arfn_catchfile,";
  public static String[] m_cRunParameterNames={"pID","pFile","pTipo","pCodDip"};
}
