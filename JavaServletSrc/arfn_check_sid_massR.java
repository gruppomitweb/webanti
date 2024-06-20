// * --- Area Manuale = BO - Header
// * --- arfn_check_sid_mass
import java.security.KeyStore;
import java.security.Key;
import java.security.PrivateKey;
import java.io.*;
import java.util.*;
import java.security.cert.*;
// * --- Fine Area Manuale
public class arfn_check_sid_massR implements CallerWithObjs {
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
  public String _filename;
  public String _password;
  public String cRitorno;
  public boolean bRitorno;
  public MemoryCursor_mcdaticertificati_mcrdef mcDatiCert;
  public String _tipoinst;
  public String _pathjava;
  public String _pathdoc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_check_sid_massR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_check_sid_mass",m_Caller);
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
      return "arfn_check_sid_mass";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_password",p_cVarName)) {
      return _password;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_tipoinst",p_cVarName)) {
      return _tipoinst;
    }
    if (CPLib.eqr("_pathjava",p_cVarName)) {
      return _pathjava;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      return _pathdoc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
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
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_password",p_cVarName)) {
      _password = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_tipoinst",p_cVarName)) {
      _tipoinst = value;
      return;
    }
    if (CPLib.eqr("_pathjava",p_cVarName)) {
      _pathjava = value;
      return;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      _pathdoc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
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
      /* _filename Char(0) */
      /* _password Char(0) */
      /* cRitorno Memo := "" */
      cRitorno = "";
      /* bRitorno Bool := true */
      bRitorno = true;
      /* mcDatiCert MemoryCursor(mcDatiCertificati.MCRDef) */
      /* _tipoinst Char(1) */
      /* _pathjava Char(0) */
      /* _pathdoc Char(0) */
      /* gAzienda Char(10) // Azienda */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PATHJAVA,TIPOINST,RICEVUTE,SIDPASS  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _tipoinst := intermbo->TIPOINST */
        _tipoinst = Cursor_intermbo.GetString("TIPOINST");
        /* _pathjava := intermbo->PATHJAVA */
        _pathjava = Cursor_intermbo.GetString("PATHJAVA");
        /* _pathdoc := intermbo->RICEVUTE */
        _pathdoc = Cursor_intermbo.GetString("RICEVUTE");
        /* _password := Upper(LRTrim(intermbo->SIDPASS)) */
        _password = CPLib.Upper(CPLib.LRTrim(Cursor_intermbo.GetString("SIDPASS")));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If _tipoinst='W' */
      if (CPLib.eqr(_tipoinst,"W")) {
        /* bRitorno := FileLibMit.ExistFile(LRTrim(intermbo->PATHJAVA)+"\bin\java.exe") */
        bRitorno = FileLibMit.ExistFile(CPLib.LRTrim(Cursor_intermbo.GetString("PATHJAVA"))+"\\bin\\java.exe");
      } else { // Else
        /* bRitorno := FileLibMit.ExistFile(LRTrim(intermbo->PATHJAVA)+"/bin/java") */
        bRitorno = FileLibMit.ExistFile(CPLib.LRTrim(Cursor_intermbo.GetString("PATHJAVA"))+"/bin/java");
      } // End If
      /* If bRitorno */
      if (bRitorno) {
        /* cRitorno := cRitorno + "Java Correttamente Installato" + NL */
        cRitorno = cRitorno+"Java Correttamente Installato"+"\n";
      } else { // Else
        /* cRitorno := cRitorno + "Java non è correttamente Installato" + NL */
        cRitorno = cRitorno+"Java non è correttamente Installato"+"\n";
      } // End If
      /* bRitorno := FileLibMit.ExistFile(LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTEF.p12") and FileLibMit.ExistFile(LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTEC.p12") and FileLibMit.ExistFile(LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTENTE.ks") */
      bRitorno = FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTEF.p12") && FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTEC.p12") && FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTENTE.ks");
      /* If not(bRitorno) */
      if ( ! (bRitorno)) {
        /* bRitorno := FileLibMit.ExistFile(LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTEF.P12") and FileLibMit.ExistFile(LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTEC.P12") and FileLibMit.ExistFile(LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTENTE.KS") */
        bRitorno = FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTEF.P12") && FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTEC.P12") && FileLibMit.ExistFile(CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTENTE.KS");
      } // End If
      /* If bRitorno */
      if (bRitorno) {
        /* cRitorno := cRitorno + "File Certificati Presenti" + NL */
        cRitorno = cRitorno+"File Certificati Presenti"+"\n";
      } else { // Else
        /* cRitorno := cRitorno + "File Certificati Non Presenti" + NL */
        cRitorno = cRitorno+"File Certificati Non Presenti"+"\n";
      } // End If
      /* bRitorno := True */
      bRitorno = true;
      /* _filename := LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/UTEF.P12" */
      _filename = CPLib.LRTrim(_pathdoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/UTEF.P12";
      /* If FileLibMit.ExistFile(_filename) */
      if (FileLibMit.ExistFile(_filename)) {
        double nTry00000025status;
        nTry00000025status = m_Sql.GetTransactionStatus();
        String cTry00000025msg;
        cTry00000025msg = m_Sql.TransactionErrorMessage();
        try {
          // Cerca di leggere il file
          KeyStore p12 = KeyStore.getInstance("pkcs12");
          p12.load(new FileInputStream(_filename), _password.toCharArray());
          Certificate cert = p12.getCertificate("sign_keypair0");
          X509Certificate tmpCert = (X509Certificate) cert;   
          tmpCert.checkValidity();
          /* mcDatiCert := arfn_read_p12() */
          mcDatiCert = arfn_read_p12R.Make(m_Ctx,this).Run();
          /* If At('4096',mcDatiCert.codifica) = 0 and Date() > CharToDate('20230131') */
          if (CPLib.eqr(CPLib.At("4096",mcDatiCert.row.codifica),0) && CPLib.gt(CPLib.Date(),CPLib.CharToDate("20230131"))) {
            /* bRitorno := False */
            bRitorno = false;
          } // End If
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* bRitorno := False */
          bRitorno = false;
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000025status,0)) {
            m_Sql.SetTransactionStatus(nTry00000025status,cTry00000025msg);
          }
        }
      } else { // Else
        /* bRitorno := False */
        bRitorno = false;
      } // End If
      /* If bRitorno */
      if (bRitorno) {
        /* cRitorno := cRitorno + "Certificati Validi" + NL */
        cRitorno = cRitorno+"Certificati Validi"+"\n";
      } else { // Else
        /* cRitorno := cRitorno + "Certificati Non Validi" + NL */
        cRitorno = cRitorno+"Certificati Non Validi"+"\n";
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
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
  public static arfn_check_sid_massR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_check_sid_massR(p_Ctx, p_Caller);
  }
  public static arfn_check_sid_massR Make(CPContext p_Ctx) {
    return new arfn_check_sid_massR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _filename = CPLib.Space(0);
    _password = CPLib.Space(0);
    cRitorno = "";
    bRitorno = true;
    mcDatiCert = new MemoryCursor_mcdaticertificati_mcrdef();
    _tipoinst = CPLib.Space(1);
    _pathjava = CPLib.Space(0);
    _pathdoc = CPLib.Space(0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_check_sid_mass,arfn_read_p12,
  public static final String i_InvokedRoutines = ",arfn_check_sid_mass,arfn_read_p12,";
  public static String[] m_cRunParameterNames={};
}
