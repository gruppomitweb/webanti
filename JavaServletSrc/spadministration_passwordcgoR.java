// * --- Area Manuale = BO - Header
// * --- spadministration_passwordcgo
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
public class spadministration_passwordcgoR implements CallerWithObjs {
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
  public String pEvent;
  public double usercode;
  public String w_new_password;
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
  public String _accesso;
  public String c_UserName;
  public String _flgcgo;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_passwordcgoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_passwordcgo",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("usercode",p_cVarName)) {
      return usercode;
    }
    if (CPLib.eqr("_skt_port",p_cVarName)) {
      return _skt_port;
    }
    if (CPLib.eqr("_ldati",p_cVarName)) {
      return _ldati;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_passwordcgo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("new_password",p_cVarName)) {
      return w_new_password;
    }
    if (CPLib.eqr("pEvent",p_cVarName)) {
      return pEvent;
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
    if (CPLib.eqr("_accesso",p_cVarName)) {
      return _accesso;
    }
    if (CPLib.eqr("c_UserName",p_cVarName)) {
      return c_UserName;
    }
    if (CPLib.eqr("_flgcgo",p_cVarName)) {
      return _flgcgo;
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
    if (CPLib.eqr("usercode",p_cVarName)) {
      usercode = value;
      return;
    }
    if (CPLib.eqr("_skt_port",p_cVarName)) {
      _skt_port = value;
      return;
    }
    if (CPLib.eqr("_ldati",p_cVarName)) {
      _ldati = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("new_password",p_cVarName)) {
      w_new_password = value;
      return;
    }
    if (CPLib.eqr("pEvent",p_cVarName)) {
      pEvent = value;
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
    if (CPLib.eqr("_accesso",p_cVarName)) {
      _accesso = value;
      return;
    }
    if (CPLib.eqr("c_UserName",p_cVarName)) {
      c_UserName = value;
      return;
    }
    if (CPLib.eqr("_flgcgo",p_cVarName)) {
      _flgcgo = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pEvent Char(50) */
      /* usercode Numeric(10, 0) */
      /* w_new_password Char(20) */
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
      /* _ritorno Memo */
      /* _accesso Char(1) */
      /* c_UserName Char(20) */
      /* _flgcgo Char(1) */
      /* If pEvent='Password Changed' */
      if (CPLib.eqr(pEvent,"Password Changed")) {
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
          /* _flgcgo := intermbo->FLGCGOPWD */
          _flgcgo = Cursor_intermbo.GetString("FLGCGOPWD");
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* If _flgcgo='S' */
        if (CPLib.eqr(_flgcgo,"S")) {
          /* c_UserName := '' */
          c_UserName = "";
          // * --- Read from cpusers
          m_cServer = m_Ctx.GetServer("cpusers");
          m_cPhName = m_Ctx.GetPhName("cpusers");
          m_cSql = "";
          m_cSql = m_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"N",10,0,m_cServer),m_cServer,usercode);
          if (m_Ctx.IsSharedTemp("cpusers")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("name",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            c_UserName = Read_Cursor.GetString("name");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpusers into routine spadministration_passwordcgo returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            c_UserName = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _dati := '<xml version=' */
          _dati = "<xml version=";
          /* _dati := _dati+"'1.0' encoding='utf-8'><user>"+LRTrim(c_UserName)+"</user><pwd>"+LRTrim(w_new_password) */
          _dati = _dati+"'1.0' encoding='utf-8'><user>"+CPLib.LRTrim(c_UserName)+"</user><pwd>"+CPLib.LRTrim(w_new_password);
          /* _dati := _dati+'</pwd></xml>' */
          _dati = _dati+"</pwd></xml>";
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
            /* Exec "HTTP/HTTPS" Page 3:Page_3 */
            Page_3();
          } // End If
        } // End If
      } // End If
    } finally {
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
    System.out.println("Message: " + message);
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
  public String RunAsync(String p_pEvent) {
    pEvent = p_pEvent;
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
  public Forward Run(String p_pEvent) {
    pEvent = p_pEvent;
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
      m_Caller.SetNumber("usercode","N",10,0,usercode);
      m_Caller.SetString("new_password","C",20,0,w_new_password);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static spadministration_passwordcgoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_passwordcgoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pEvent = CPLib.Space(50);
    usercode = m_Caller.GetNumber("usercode","N",10,0);
    w_new_password = m_Caller.GetString("new_password","C",20,0);
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
    _accesso = CPLib.Space(1);
    c_UserName = CPLib.Space(20);
    _flgcgo = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pEvent"};
}
