// * --- Area Manuale = BO - Header
// * --- arfn_read_p12
import java.security.KeyStore;
import java.security.Key;
import java.security.PrivateKey;
import java.io.*;
import java.util.*;
import java.security.cert.*;
import java.time.*;
// * --- Fine Area Manuale
public class arfn_read_p12R implements CallerWithObjs {
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
  public String gAzienda;
  public String gPathDoc;
  public String _filename;
  public String _password;
  public String _dataini;
  public String _datafin;
  public String _chiave;
  public MemoryCursor_mcdaticertificati_mcrdef mcDatiCert;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_read_p12R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_read_p12",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_read_p12";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_password",p_cVarName)) {
      return _password;
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      return _chiave;
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
    if (CPLib.eqr("mcDatiCert",p_cVarName)) {
      return mcDatiCert;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_password",p_cVarName)) {
      _password = value;
      return;
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
      return;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      _chiave = value;
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
    if (CPLib.eqr("mcDatiCert",p_cVarName)) {
      mcDatiCert = (MemoryCursor_mcdaticertificati_mcrdef)value;
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
      /* gAzienda Char(10) // Azienda */
      /* gPathDoc Char(128) // Path Documenti */
      /* _filename Char(0) */
      /* _password Char(0) */
      /* _dataini Char(0) */
      /* _datafin Char(0) */
      /* _chiave Char(0) */
      /* mcDatiCert MemoryCursor(mcDatiCertificati.MCRDef) */
      /* _filename := LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTEF.P12" */
      _filename = CPLib.LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTEF.P12";
      /* If FileLibMit.ExistFile(_filename) */
      if (FileLibMit.ExistFile(_filename)) {
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SIDPASS  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _password := Upper(LRTrim(intermbo->SIDPASS)) */
          _password = CPLib.Upper(CPLib.LRTrim(Cursor_intermbo.GetString("SIDPASS")));
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        // Cerca di leggere il file
        try{
           KeyStore p12 = KeyStore.getInstance("pkcs12");
           p12.load(new FileInputStream(_filename), _password.toCharArray());
           Certificate cert = p12.getCertificate("sign_keypair0");
           Key key = p12.getKey("sign_keypair0", _password.toCharArray()); 
           Certificate[] cc = p12.getCertificateChain("sign_keypair0");
           X509Certificate certificate1 = (X509Certificate) cc[0];   
           LocalDateTime expiryDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(certificate1.getNotAfter().getTime()), ZoneId.systemDefault());
           LocalDateTime startingDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(certificate1.getNotBefore().getTime()), ZoneId.systemDefault());
        /* _dataini := startingDate.toString() */
        _dataini = startingDate.toString();
        /* _datafin := expiryDate.toString() */
        _datafin = expiryDate.toString();
        /* _chiave := Left(key.toString(),At("bits",key.toString())+3) */
        _chiave = CPLib.Left(key.toString(),CPLib.At("bits",key.toString())+3);
        /* mcDatiCert.AppendBlank() */
        mcDatiCert.AppendBlank();
        /* mcDatiCert.startDate := Substr(_dataini,9,2)+"-"+Substr(_dataini,6,2)+"-"+Left(_dataini,4)+" "+Substr(_dataini,12,8) */
        mcDatiCert.row.startDate = CPLib.Substr(_dataini,9,2)+"-"+CPLib.Substr(_dataini,6,2)+"-"+CPLib.Left(_dataini,4)+" "+CPLib.Substr(_dataini,12,8);
        /* mcDatiCert.endDate := Substr(_datafin,9,2)+"-"+Substr(_datafin,6,2)+"-"+Left(_datafin,4)+" "+Substr(_datafin,12,8) */
        mcDatiCert.row.endDate = CPLib.Substr(_datafin,9,2)+"-"+CPLib.Substr(_datafin,6,2)+"-"+CPLib.Left(_datafin,4)+" "+CPLib.Substr(_datafin,12,8);
        /* mcDatiCert.codifica := _chiave */
        mcDatiCert.row.codifica = _chiave;
        // Chiude la try
        } catch (Exception ex){
            ex.printStackTrace();
        /* mcDatiCert.codifica := 'ERRPWD' */
        mcDatiCert.row.codifica = "ERRPWD";
        /* } */
        };
      } else { // Else
        /* mcDatiCert.AppendBlank() */
        mcDatiCert.AppendBlank();
        /* mcDatiCert.codifica := 'NOFILE' */
        mcDatiCert.row.codifica = "NOFILE";
      } // End If
      /* Return mcDatiCert */
      throw new Stop(mcDatiCert);
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
  public String RunAsync() {
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
  public MemoryCursor_mcdaticertificati_mcrdef Run() {
    MemoryCursor_mcdaticertificati_mcrdef l_result;
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
        l_result = (MemoryCursor_mcdaticertificati_mcrdef)stop_value.GetObject();
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
  public static arfn_read_p12R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_read_p12R(p_Ctx, p_Caller);
  }
  public static arfn_read_p12R Make(CPContext p_Ctx) {
    return new arfn_read_p12R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _filename = CPLib.Space(0);
    _password = CPLib.Space(0);
    _dataini = CPLib.Space(0);
    _datafin = CPLib.Space(0);
    _chiave = CPLib.Space(0);
    mcDatiCert = new MemoryCursor_mcdaticertificati_mcrdef();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_read_p12,
  public static final String i_InvokedRoutines = ",arfn_read_p12,";
  public static String[] m_cRunParameterNames={};
}
